package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IH5ApplyFileCompareService;

/**
 * 专为Android记录H5应用文件数量使用，
 * 每次点击H5应用时查询文件数量，在前台作对比判断文件是否缺失
 * 2016-01-27
 */
public class H5ApplyFileCompareAction extends BaseAction{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5447499379440386214L;
	
	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(H5ApplyFileCompareAction.class);
	
	//H5应用编号
	private int applyCode;
	
	//类型，保存或更新  （save/update）
	private String type;
	
	//H5文件数量
	private int count;
	
	private static final int INITNUM = 0;

	//service
	private IH5ApplyFileCompareService h5ApplyFileCompareService;
	
	/**
	 * 保存或更新
	 */
	public void saveOrUpdateCount(){
		int i = INITNUM;
		//判断
		if("save".equalsIgnoreCase(type)){
			try {
				//保存
				i = h5ApplyFileCompareService.saveCount(applyCode, count);
			} catch (Exception e) {
				//日志记录
				LOG.error("保存H5资源文件数量失败>>>>>{applyCode="+applyCode+",count="+count+",type="+type+"}", e);
			}
		}else{
			try {
				//更新
				i = h5ApplyFileCompareService.updateCount(applyCode, count);
			} catch (Exception e) {
				//日志记录
				LOG.error("更新H5资源文件数量失败>>>>>{applyCode="+applyCode+",count="+count+",type="+type+"}", e);
			}
		}
		if(i == INITNUM){
			//操作失败
			writeToPage("{'errorCode':1}");
		}else{
			//操作成功
			writeToPage("{'errorCode':0}");
		}
	}
	
	/**
	 * 查询
	 */
	public void queryCount(){
		int fileCount = INITNUM;
		try {
			fileCount = h5ApplyFileCompareService.getFileCount(applyCode);
		} catch (Exception e) {
			//日志记录
			LOG.error("查询H5资源文件数量失败>>>>>{applyCode="+applyCode+"}", e);
			writeToPage("{'errorCode':1}");
			return;
		}
		//返回
		writeToPage("{'errorCode':0,'count':"+fileCount+",'applyCode':"+applyCode+"}");
	}
	
	//getter
	public int getApplyCode() {
		return applyCode;
	}

	//setter
	public void setApplyCode(int applyCode) {
		this.applyCode = applyCode;
	}

	//getter
	public String getType() {
		return type;
	}

	//setter
	public void setType(String type) {
		this.type = type;
	}

	//getter
	public int getCount() {
		return count;
	}

	//setter
	public void setCount(int count) {
		this.count = count;
	}

	//setter
	public void setH5ApplyFileCompareService(
			IH5ApplyFileCompareService h5ApplyFileCompareService) {
		this.h5ApplyFileCompareService = h5ApplyFileCompareService;
	}
}
