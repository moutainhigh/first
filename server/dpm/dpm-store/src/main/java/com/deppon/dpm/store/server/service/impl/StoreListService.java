package com.deppon.dpm.store.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.store.server.dao.IStoreListDao;
import com.deppon.dpm.store.server.entity.StoreLikelog;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.service.IStoreListService;
import com.deppon.dpm.store.server.util.IdWorker;
import com.deppon.dpm.store.server.vo.StoreListVo;
/**
 * 
 * @author XiaoTian
 *
 */
public class StoreListService implements IStoreListService {
		//注入dao
		private IStoreListDao storeListDao;
		/**
		 * 
		 * @param storeListDao
		 */
		public void setStoreListDao(IStoreListDao storeListDao) {
			this.storeListDao = storeListDao;
		}
		/**
		 * 
		 * @return
		 */
		public IStoreListDao getStoreListDao() {
			return storeListDao;
		}
		/**
		 * 日志
		 */
		private static final Logger logger = LoggerFactory
				.getLogger(StoreListService.class);

		@Override
		public List<StoreListVo> fineList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return storeListDao.fineList(map);
		}

		@Override
		public int fineCountlikeIf(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return storeListDao.fineCountlikeIf(map);
		}
		
		@Transactional
		@Override
		public int updateNum(String creatorcode,String deptnum,Integer likelogtype) {
			// TODO Auto-generated method stub
			int tmp = 0;
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("deptnum", deptnum);
				map.put("likelogtype", likelogtype);
				//修改榜单点赞信息
				tmp =storeListDao.updateNum(map);
				StoreLikelog storeLikelog = new StoreLikelog(creatorcode, deptnum, likelogtype,new Date(),0,new Date());				
				if(tmp>0){
				   //插入日志
					tmp =storeListDao.insertStorelog(storeLikelog);
				}
			} catch (Exception e) {
				logger.error("警告信息异常-------------");
				logger.error("警告失败-------------");
				tmp = 0;
				throw new RuntimeException();
			}
			return tmp;
		}

		@Override
		public int insertStorelog(StoreLikelog storeLikelog) {
			// TODO Auto-generated method stub
			return storeListDao.insertStorelog(storeLikelog);
		}

		
}
