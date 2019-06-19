package com.deppon.dpm.module.common.server.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.dao.IEditWelcomePageDao;
import com.deppon.dpm.module.common.server.service.IEditWelcomePageService;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;
import com.deppon.dpm.module.common.shared.domain.WelcomePageLinkEntity;

/**
 * 业务层
 * 
 * @date 2015-08-24
 * @author 231586
 * 
 */
public class EditWelcomePageService implements IEditWelcomePageService {
	/**
	 * set injection
	 */
	private PhotoAddressService photoAddressService;
	/**
	 * set injection
	 */
	private IEditWelcomePageDao editWelcomePageDao;
	/**
	 * set injection
	 */
	private String webUrl;
	
	private JdbcTemplate template;
	
	/**
	 * 获取所有应用链接
	 */
	public List<WelcomePageLinkEntity> getWelcomePageLinks() {
		// sql
		String sql = "SELECT id,cn_name FROM apply_store WHERE status = 'on'";
		// 执行
		List<WelcomePageLinkEntity> list = template.query(sql, new RowMapper<WelcomePageLinkEntity>(){
			// 复写方法
			public WelcomePageLinkEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// 封装实体
				WelcomePageLinkEntity entity = new WelcomePageLinkEntity();
				// 应用编号
				entity.setAppId(rs.getInt("id"));
				// 应用中文名
				entity.setAppCName(rs.getString("cn_name"));
				// 返回
				return entity;
			}
			
		});
		// 封装没有链接的页面显示数据
		WelcomePageLinkEntity welcomePageLinkEntity = new WelcomePageLinkEntity(null,"--选择链接--");
		list.add(welcomePageLinkEntity);
		// 返回
		return list;
	}

	/**
	 * 保存配置信息，便于展示
	 */
	@Override
	public int savePic(WelcomePageEntity pageEntity) {
		// 返回结果
		int result = 0;
		// 返回结果集
		List<String> results = new ArrayList<String>();
		try {
			// 图片上传至服务器
			results = UploadUtil.uploadFiles(
					new File[] { pageEntity.getFile() },
					photoAddressService.getWelcomeAddress(),
					new String[] { pageEntity.getFileFileName() });
			// 上传成功
			if (null != results && results.size() > 0) {
				// 设置文件名
				pageEntity.setFileFileName(results.get(0));
				// 保存到数据库
				result = editWelcomePageDao.savePic(pageEntity);
			}
		} catch (IOException e) {
			// 失败
			return -1;
		}
		// 返回
		return result;
	}

	/**
	 * 获取详细信息
	 */
	@Override
	public List<WelcomePageEntity> getDetails(String userId,boolean isDetail) {
		// 获取当前毫秒值
		Long now = System.currentTimeMillis();
		// 实体
		WelcomePageEntity result = null;
		// 获取对应的配置页信息
		List<WelcomePageEntity> details = editWelcomePageDao.getDetails(userId);
		// 是否详情显示
		if (isDetail) {
			// 空判断
			if (null != details && details.size() > 0) {
				// 获取对应配置信息
				result = details.get(0);
				// 设置文件路径
				result.setFileFileName(webUrl + "/welcome/" + result.getFileFileName());
				// 判断时间是否在选定的时间之内
				if (result.getStartDate().getTime() < now && now < result.getEndDate().getTime()) {
					// 之内为true，前端显示
					result.setTimeOut(false);
				} else {
					// 否则为false，不显示
					result.setTimeOut(true);
				}
				// 清空之前信息
				details.clear();
				// 添加新信息
				details.add(result);
			}
		}
		// 返回
		return details;
	}
	
	/**
	 * 获取欢迎页列表
	 */
	@Override
	public List<WelcomePageEntity> getWelcomePageList(int begin,int rows) {
		return editWelcomePageDao.getWelcomePageList(begin,rows);
	}

	/**
	 * 删除
	 */
	@Override
	public int delWelcomePage(String pageIds) {
		
		String[] ids = pageIds.split(",");
		//参数
		Map<String,String[]> map = new HashMap<String,String[]>();
		map.put("ids", ids);
		//根据ids查询出对应的文件名
		List<String> fileNames = editWelcomePageDao.selectWelcomePages(map);
		//没有直接返回
		if(null == fileNames || fileNames.size() < 1){
			return 0;
		}
		//文件所上传的路径
		String path = photoAddressService.getWelcomeAddress();
		//文件对象
		File file = null;
		//遍历
		for (String fileName : fileNames) {
			//构建文件对象
			file = new File(path,fileName);
			//存在就删除
			if(file.exists()){
				file.delete();
			}
		}
		return editWelcomePageDao.delWelcomePages(map);
	}
	
	/**
	 * 查询数据总条数
	 */
	@Override
	public Long queryCount() {
		return editWelcomePageDao.queryCount();
	}
	
	/**
	 * set
	 * 
	 * @param photoAddressService
	 */
	public void setPhotoAddressService(PhotoAddressService photoAddressService) {
		this.photoAddressService = photoAddressService;
	}

	/**
	 * set
	 * 
	 * @param editWelcomePageDao
	 */
	public void setEditWelcomePageDao(IEditWelcomePageDao editWelcomePageDao) {
		this.editWelcomePageDao = editWelcomePageDao;
	}

	/**
	 * set
	 * 
	 * @param webUrl
	 */
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	/**
	 * setter
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
