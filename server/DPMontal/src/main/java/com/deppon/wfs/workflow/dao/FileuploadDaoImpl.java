package com.deppon.wfs.workflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.ConvertPojoUtil;
import com.deppon.wfs.workflow.domain.Fileupload;

public class FileuploadDaoImpl implements IFileuploadDao{
	//获取所有附件列表
	private static String getAll = "SELECT A.FILE_ID FILEID," +
										"A.FILE_NAME FILENAME," +
										"A.FILE_NEW_NAME FILENEWNAME," +
										"A.FILE_PATH FILEPATH," +
										"A.FILE_SIZE FILESIZE," +
										"A.FILE_TYPE FILETYPE," +
										"A.FILE_TIME FILETIME," +
										"A.OPERATORID OPERATORID," +
										"A.OPERATORNAME OPERATORNAME," +
										"A.BUSINO BUSINO," +
										"A.GROUP_ID GROUPID," +
										"A.RESERVE_ONE RESERVEONE," +
										"A.RESERVE_TWO RESERVETWO," +
										"A.RESERVE_THREE RESERVETHREE " +
										"FROM T_WFS_FILEUPLOAD@LINK_WFSDB A WHERE A.BUSINO = ?";
	//获取一个附件
	private static String getOne = "SELECT A.FILE_ID FILEID," +
										"A.FILE_NAME FILENAME," +
										"A.FILE_NEW_NAME FILENEWNAME," +
										"A.FILE_PATH FILEPATH," +
										"A.FILE_SIZE FILESIZE," +
										"A.FILE_TYPE FILETYPE," +
										"A.FILE_TIME FILETIME," +
										"A.OPERATORID OPERATORID," +
										"A.OPERATORNAME OPERATORNAME," +
										"A.BUSINO BUSINO," +
										"A.GROUP_ID GROUPID," +
										"A.RESERVE_ONE RESERVEONE," +
										"A.RESERVE_TWO RESERVETWO," +
										"A.RESERVE_THREE RESERVETHREE " + 
										"FROM T_WFS_FILEUPLOAD@LINK_WFSDB A WHERE A.FILE_ID = ?";
	
	Logger logger = Logger.getLogger(FileuploadDaoImpl.class);
	
	/**
	 * 
	* @MethodName: getAllFileupload 
	* @description : 根据业务单据号获取所有的文件列表
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:08:32
	* @param fileupload
	* @return List<Fileupload>
	 */
	@Override
	public List<Fileupload> getAllFileupload(Fileupload fileupload) {
		if (fileupload.getBusino() == "" || fileupload.getBusino() == null) {
			return null;
		}
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Fileupload> fileList = new ArrayList<Fileupload>();
		try {
			connection = ConnectionManager.getConnection();
			ps = connection.prepareStatement(getAll);
			ps.setString(1, fileupload.getBusino());
			rs = ps.executeQuery();
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			for (int i = 0 ; i <= resultList.size()-1 ; i++) {
				fileList.add((Fileupload) ConvertPojoUtil.mapToBean(new Fileupload(), (Map)resultList.get(i)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取所有文件信息异常" + e);
			return null;
		} finally {
			ConnectionManager.closeAll(connection, ps, rs);
		}
		return fileList;
	}
	
	/**
	 * 
	* @MethodName: getOneFileupload 
	* @description : 根据文件id获取指定文件信息
	* @author：何玲菠 
	* @date： 2014-4-2 上午11:08:47
	* @param fileupload
	* @return Fileupload
	 */
	@Override
	public Fileupload getOneFileupload(Fileupload fileupload) {
		if (fileupload.getFileId() == null || fileupload.getFileId() == "") {
			return null;
		}
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Fileupload entity = new Fileupload();
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(getOne);
			ps.setString(1, fileupload.getFileId());
			rs = ps.executeQuery();
			List resultList = ConvertPojoUtil.resultSetToList(rs);
			if (resultList.size() > 0) {
				entity = (Fileupload) ConvertPojoUtil.mapToBean(entity, (Map) resultList.get(0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("[获取单个文件信息异常，异常文件id为:" + fileupload.getFileId() + " ][异常信息为:" + e + "]");
			return null;
		} finally {
			ConnectionManager.closeAll(conn, ps, rs);
		}
		return entity; 
	}
}
