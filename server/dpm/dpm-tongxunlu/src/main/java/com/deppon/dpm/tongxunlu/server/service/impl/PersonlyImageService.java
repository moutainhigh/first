package com.deppon.dpm.tongxunlu.server.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.service.impl.PhotoAddressService;
import com.deppon.dpm.module.common.server.util.UploadUtil;
import com.deppon.dpm.module.common.shared.domain.EmpExtensionEntity;
import com.deppon.dpm.tongxunlu.server.dao.IPersonlyImageDao;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.util.Constants;

/**
 * 新增头像service
 * 
 * @author 231586
 * 
 */
public class PersonlyImageService implements IPersonlyImageService {
	// 日志
	private static final Logger logger = Logger
			.getLogger(PersonlyImageService.class);
	// set injection
	private IPersonlyImageDao personlyImageDao;
	// set injection
	private PhotoAddressService photoAddressService;
	// set injection
	private String webUrl;

	@Override
	public int updateImage(EmpExtensionEntity entity) {
		// 返回更新的数量
		return personlyImageDao.updateImageAddress(entity);
	}

	@Override
	public void deleteFile(String empCode) throws IOException {
		// 用于地址拼接
		StringBuilder sb = new StringBuilder();
		// 获取配置文件的地址
		sb.append(photoAddressService.getHeadPortraitAddress());
		// 分隔符
		sb.append(File.separator);
		// 获取文件名称
		sb.append(personlyImageDao.queryImageByEmpCode(empCode));
		// 找文件
		File file = new File(sb.toString());
		if (file.exists() && file.isFile()) {
			try {
				// 删除老文件
				FileUtils.forceDelete(file);
			} catch (IOException e) {
				// 排除异常
				throw new IOException(e);
			}
		}
	}

	@Override
	public int uploadImage(File[] files, String empCode, String[] fileNames)
			throws IOException {
		// 名称返回
		List<String> result = new ArrayList<String>();
		try {
			// 文件上传
			result = UploadUtil.uploadFiles(files,
					photoAddressService.getHeadPortraitAddress(), fileNames);
			if (null != result && result.size() > 0) {
				// 应该用map来接受这两个参数
				EmpExtensionEntity entity = new EmpExtensionEntity();
				// 工号
				entity.setEmpCode(empCode);
				// 图片名称
				entity.setPictPath(result.get(0));
				// 查询数据库，看是否存在对应的数据，没有添加
				if (null == personlyImageDao.queryImageByEmpCode(empCode)) {
					// 存储数据库
					personlyImageDao.addPersonlyImage(entity);
				} else {
					try {
						// 有的话，先删除对应文件
						deleteFile(empCode);
					} catch (Exception e) {
						logger.error("删除头像出错，工号：" + empCode);
					} finally {
						// 再更新数据库对应文件名
						updateImage(entity);
					}
				}
				// 返回成功
				return Constants.SUCCESS;
			} else {
				// 返回失败
				return Constants.WRONG_REQUEST;
			}
		} catch (IOException e) {
			throw new IOException();
		}
	}

	@Override
	public String downloadImage(String empCode) throws FileNotFoundException {
		// 用于拼接
		StringBuffer sb = new StringBuffer();
		sb.append(webUrl + "/");
		sb.append("headPhoto/");
		// 获取文件名
		String path = personlyImageDao.queryImageByEmpCode(empCode);
		if (null != path) {
			// 拼接文件名
			sb.append(path);
			// 返回
			return sb.toString();
		}
		// 没有返回空字符串
		return "";
	}
	
	// get
	public IPersonlyImageDao getPersonlyImageDao() {
		return personlyImageDao;
	}

	// set
	public void setPersonlyImageDao(IPersonlyImageDao personlyImageDao) {
		this.personlyImageDao = personlyImageDao;
	}

	// set
	public void setPhotoAddressService(PhotoAddressService photoAddressService) {
		this.photoAddressService = photoAddressService;
	}

	// set
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

}
