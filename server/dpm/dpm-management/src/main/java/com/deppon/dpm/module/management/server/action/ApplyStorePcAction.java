package com.deppon.dpm.module.management.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;
import com.deppon.dpm.module.management.server.service.IApplyStoreService;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 应用商店Pc端
 * 
 */
public class ApplyStorePcAction extends BaseAction implements
		ModelDriven<ApplyStore> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3667358344999442883L;
	
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ApplyStorePcAction.class);
	/**
	 * 分页大小
	 */
	private static final int ROWS_10 = 10;
	/**
	 * 应用商店service
	 */
	private IApplyStoreService iApplyStoreService;
	/**
	 * 实体参数
	 */
	private ApplyStore entity;
	/**
	 * 应用编号
	 */
	private String appid;
	/**
	 * 当前页
	 */
	private int page = 1;
	/**
	 * 每页显示条数
	 */
	private int rows = ROWS_10;
	/**
	 * 返回页面的数据
	 */
	private Map<String, Object> resultObj;
	/**
	 * 错误状态码
	 */
	private static final int ERROR_500 = 500;
	/**
	 * 成功状态码
	 */
	private static final int SUCCESS_200 = 200;

	@Override
	public ApplyStore getModel() {
		if (entity == null) {
			// 创建对象
			entity = new ApplyStore();
		}
		// 返回
		return entity;
	}

	/**
	 * 新增页面跳转
	 * 
	 * @return
	 */
	public String addApplyStore() {
		return SUCCESS;
	}

	/**
	 * 编辑页面跳转
	 * 
	 * @return
	 */
	public String editApplyStore() {
		return SUCCESS;
	}

	/**
	 * 保存应用商店内容
	 */
	public void saveAndEditApplyStore() {
		logger.info("应用id为"+entity.getAppId()+"的应用开始编辑保存");
		// 判断是否为空
		if (null != entity && entity.getAppId() != 0) {
			String autoUpdateCondition = ServletActionContext.getRequest().getParameter("autoUpdateCondition");
			if(StringUtils.isNotBlank(autoUpdateCondition)) {
				entity.setAppAutoRefreshControlList(JSONObject.parseArray(autoUpdateCondition, AppAutoRefreshControlEntity.class));
			}
			int num = 0;
			// 获取信息
			List<ApplyStore> oldEntityList = iApplyStoreService
					.getApplyStoreList(entity.getAppId(), 0, 1);
			if (null != oldEntityList && oldEntityList.size() > 0) {
				// 编辑
				num = iApplyStoreService.updateApplyStore(entity);
			} else {
				// 新增
				num = iApplyStoreService.insertApplyStore(entity);
			}
			if(num == 1){
				// 成功
				ServletActionContext.getResponse().setStatus(SUCCESS_200);
			} else {
				// 删除失败 返回500
				ServletActionContext.getResponse().setStatus(ERROR_500);
			}
		} else {
			// 删除失败 返回500
			ServletActionContext.getResponse().setStatus(ERROR_500);
		}
	}

	/**
	 * 删除应用商店内容
	 */
	public void deleteApplyStore() {
		// 判断是否为空
		if (StringUtils.isNotEmpty(appid) && appid.matches("^[0-9]*$")) {
			// 应用商店id
			ApplyStore appStore = new ApplyStore();
			appStore.setAppId(Integer.valueOf(appid));
			// 删除
			iApplyStoreService.deleteApplyStore(appStore);
			// 成功
			ServletActionContext.getResponse().setStatus(SUCCESS_200);
		} else {
			// 删除失败 返回500
			ServletActionContext.getResponse().setStatus(ERROR_500);
		}
	}
	
	/**
	 * 切换应用下载平台
	 */
	public void updateDLoadLine() {
		try {
			String dLoadLine = ServletActionContext.getRequest().getParameter("dLoadLine");
			int line = Integer.parseInt(dLoadLine);
			iApplyStoreService.updateDLoadLine(line);
			writeToPage("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 应用商店列表
	 */
	public String applyStoreList() {
		int begin = (page - 1) * rows;
		// 获取应用商店列表
		List<ApplyStore> list = iApplyStoreService.getApplyStoreList(0, begin,
				rows);
		// 获取总数
		Long total = iApplyStoreService.getApplyStoreCount();
		// 前台接受值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		this.setResultObj(map);
		// 返回
		return SUCCESS;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * set
	 * 
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * set
	 * 
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Map<String, Object> getResultObj() {
		return resultObj;
	}

	/**
	 * set
	 * 
	 * @param resultObj
	 */
	public void setResultObj(Map<String, Object> resultObj) {
		this.resultObj = resultObj;
	}

	/**
	 * set
	 * 
	 * @param iApplyStoreService
	 */
	public void setiApplyStoreService(IApplyStoreService iApplyStoreService) {
		this.iApplyStoreService = iApplyStoreService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * set
	 * 
	 * @param appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
}
