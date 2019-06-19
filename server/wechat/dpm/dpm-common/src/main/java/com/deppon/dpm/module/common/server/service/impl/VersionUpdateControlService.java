package com.deppon.dpm.module.common.server.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.deppon.dpm.module.common.server.dao.IVersionUpdateControlDao;
import com.deppon.dpm.module.common.server.service.IVersionUpdateControlService;
import com.deppon.dpm.module.common.shared.domain.VersionUpdateControlEntity;

/**
 * 系统版本更新权限控制
 */
public class VersionUpdateControlService implements IVersionUpdateControlService {
	
	// https://dpm.deppon.com:8881/dpm/
	private String serverHost;
	
	// dao
	private IVersionUpdateControlDao versionUpdateControlDao;
	
	// 列表查询
	public List<VersionUpdateControlEntity> list() {
		
		List<VersionUpdateControlEntity> list = versionUpdateControlDao.list();
		for (VersionUpdateControlEntity entity : list) {
			entity.setFilePath(serverHost.substring(0,serverHost.length() -1) + entity.getFilePath());
		}
		return list;
	}

	// 保存
	public void save(VersionUpdateControlEntity entity) {
		versionUpdateControlDao.save(entity);
	}
	
	// 根据id删除
	public void deleteById(int id) {
		// 查询
		VersionUpdateControlEntity entity = versionUpdateControlDao.queryById(id);
		String filePath = entity.getFilePath();
		// 删除文件
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
		// 删除数据
		versionUpdateControlDao.delById(id);
	}
	
	// 更新
	public void update(VersionUpdateControlEntity versionUpdateControlEntity) {
		versionUpdateControlEntity.setUpdateTime(new Date());
		versionUpdateControlDao.update(versionUpdateControlEntity);
	}

	// setter
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	// setter
	public void setVersionUpdateControlDao(
			IVersionUpdateControlDao versionUpdateControlDao) {
		this.versionUpdateControlDao = versionUpdateControlDao;
	}
	
}
