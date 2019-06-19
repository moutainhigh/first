package com.deppon.wfs.workflow.service;

import java.util.List;

import com.deppon.wfs.workflow.dao.FileuploadDaoImpl;
import com.deppon.wfs.workflow.dao.IFileuploadDao;
import com.deppon.wfs.workflow.domain.Fileupload;

public class FileuploadServiceImpl implements IFileuploadService {
	private IFileuploadDao dao = new FileuploadDaoImpl();
	
	@Override
	public List<Fileupload> getAllFileupload(Fileupload fileupload) {
		// TODO Auto-generated method stub
		return dao.getAllFileupload(fileupload);
	}
	
	@Override
	public Fileupload getOneFileupload(Fileupload fileupload) {
		// TODO Auto-generated method stub
		return dao.getOneFileupload(fileupload);
	}
}
