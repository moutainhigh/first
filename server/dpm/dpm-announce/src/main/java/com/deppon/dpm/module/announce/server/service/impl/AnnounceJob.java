package com.deppon.dpm.module.announce.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.announce.server.dao.IAnnounceDao;
import com.deppon.dpm.module.announce.shared.domain.AnnounceEntity;

/**
 * 通告相关信息修改
 * @author 
 * @since 2018-12-13
 * */
public class AnnounceJob {
	
	private static final Logger LOG = Logger.getLogger(AnnounceJob.class);
	
	/**
	 * set injection
	 */
	private IAnnounceDao announceDao;
	
	public void changeJob(){
		long start_time = System.currentTimeMillis();
		LOG.error("《《《《《《《《《《通告信息更改start》》》》》》》》》》");
		
		LOG.error("《《《《《《《《《《通告类型获取开始》》》》》》》》》》");
		List<String> types = announceDao.getAnnounceTypes();
		LOG.error("《《《《《《《《《《通告类型获取结束》》》》》》》》》》");
		
		if(null != types && types.size() > 0){
			
			final int rows = 100;
			final CountDownLatch countDownLatch = new CountDownLatch(types.size());
			
			LOG.error("《《《《《《《《《《通告信息更改开始》》》》》》》》》》");
			
			ExecutorService exe = Executors.newFixedThreadPool(types.size());
			//根据通告类型批量更新
			for(String t: types){
				final String type = t;
				exe.execute(new Thread(new Runnable(){
					
					@Override
					public void run() {
						try {
							updateBatchByType(type,rows);
							LOG.error("《《《《《《《《《《通告信息类型"+type+"更改结束 》》》》》》》》》》");
							LOG.error("《《《《《《《《《《通告信息类型"+type+"::::"+Thread.currentThread().getName()+"更改结束 》》》》》》》》》》");
						} catch (Exception e) {
							e.printStackTrace();
							LOG.error("《《《更新通告信息类型 "+type+" 报错》》》:" + e.getMessage());
						}finally{
							countDownLatch.countDown();
						}
					}
					
				},"AnnounceThread-"+type));
				
			}
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
				LOG.error(e.getMessage());
			}
			exe.shutdown();
		}
		long end_time = System.currentTimeMillis();
		LOG.error("《《《《《《《《《《通告信息更改end,执行时长:"+(end_time-start_time)/1000+"s》》》》》》》》》》");
	}
	
	private void updateBatchByType(String type,int rows){
		//查询每种类型的通告
		List<AnnounceEntity> list = announceDao.getAnnouncesByType(type);
		List<AnnounceEntity> listType = new ArrayList<AnnounceEntity>();
		if(null != list && list.size() > 0){
			int size = list.size();
			//更新通告信息
			for(AnnounceEntity entity : list){
				boolean changed = false;
				if(StringUtils.isNoneBlank(entity.getAttachmentPath()) 
						&& entity.getAttachmentPath().startsWith("http://192.168.68.117:8080/dpm/upload")){
					String path = entity.getAttachmentPath()
							.replaceAll("http://192.168.68.117:8080/dpm/upload", 
									"http://192.168.67.47:8082/dpmfile");
					entity.setAttachmentPath(path);
					changed=true;
				}
				if(StringUtils.isNoneBlank(entity.getSrcollImagPath()) 
						&& entity.getSrcollImagPath().startsWith("http://192.168.68.117:8080/dpm/upload")){
					String path = entity.getSrcollImagPath()
							.replaceAll("http://192.168.68.117:8080/dpm/upload", 
									"http://192.168.67.47:8082/dpmfile");
					entity.setSrcollImagPath(path);
					changed=true;
				}
				if(StringUtils.isNoneBlank(entity.getAppScrollImgPath()) 
						&& entity.getAppScrollImgPath().startsWith("/upload")){
					String path = entity.getAppScrollImgPath().replaceAll("/upload", "/dpmfile");
					entity.setAppScrollImgPath(path);
					changed=true;
				}
				if(StringUtils.isNoneBlank(entity.getAppConImgPath()) 
						&& entity.getAppConImgPath().startsWith("/upload")){
					String path = entity.getAppConImgPath().replace("/upload", "/dpmfile");
					entity.setAppConImgPath(path);
					changed=true;
				}
				if(changed){
					listType.add(entity);
				}
			}
			if(size < rows){
				announceDao.updateBatch4Path(listType);
			}else{
				List<AnnounceEntity> tempList = new ArrayList<AnnounceEntity>();
				for(int i=0,length=listType.size(),count=listType.size(); i < length;i++,count--){
					if(i > 0 && (i % rows == 0 || (count <= 0 && length <= rows))){
						announceDao.updateBatch4Path(tempList);
						tempList = new ArrayList<AnnounceEntity>();
					}else{
						tempList.add(listType.get(i));
					}
				}
			}
			
		}
	}
	
	
	public IAnnounceDao getAnnounceDao() {
		return announceDao;
	}
	
	public void setAnnounceDao(IAnnounceDao announceDao) {
		this.announceDao = announceDao;
	}

}
