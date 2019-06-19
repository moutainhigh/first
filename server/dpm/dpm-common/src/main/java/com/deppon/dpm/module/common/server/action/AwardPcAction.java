package com.deppon.dpm.module.common.server.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.service.IAwardService;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;
import com.deppon.foss.framework.server.components.security.SecurityNonCheckRequired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AwardPcAction extends ActionSupport implements ModelDriven<AwardEntity>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9208979001989378613L;
	/**
	 * 定义常量
	 */
	private static final int PAGENUM = 1;
	private static final int PAGESIZE = 5;

	/**
	 * 悬赏service
	 */
	private IAwardService awardService;
	
	/**
	 * 实体参数
	 */
	private AwardEntity entity;
	/**
	 * 悬赏内容id
	 */
	private String awardId;
	/**
	 * 需要删除的悬赏的id
	 */
	private String ids;
	/**
	 * 当前页
	 */
	private int page = PAGENUM;
	/**
	 * 每页显示条数
	 */
	private int rows = PAGESIZE;
	/**
	 * 返回页面的数据
	 */
	private Map<String,Object> resultObj;
	/**
	 * 错误状态码
	 */
	private static final int ERROR = 500;
	/**
	 * 新增成功状态码
	 */
	private static final int CREATED = 201;
	/**
	 * 删除或编辑成功状态码
	 */
	private static final int NO_CONTENT = 204;
	/**
	 * 用户名
	 */
	private String loginName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 覆盖ModelDriven的方法
	 */
	@Override
	public AwardEntity getModel() {
		if(entity == null){
			 entity = new AwardEntity();
		}
		return entity;
	}
	
	/**
	 * 新增页面跳转
	 * @return
	 */
	public String addAward(){
		return SUCCESS;
	}
	/**
	 * 编辑页面跳转
	 * @return
	 */
	public String editAward(){
		return SUCCESS;
	}
	
	/**
	 * 保存悬赏内容
	 */
	@SecurityNonCheckRequired
	public String saveAndEditAward() {
		//健壮判断
		if(null == entity){
			ServletActionContext.getResponse().setStatus(ERROR);
			return NONE;
		}
		try {
			//处理内容，将转义的字符串替换
			String content = entity.getContent();
			content = content.replace("&lt;", "<");
			content = content.replace("&gt;", ">");
			entity.setContent(content);
			// 判断页面是否有传递id
			if (null != entity.getArticleID()) {
				//更新
				awardService.updateAward(entity);
				//更新成功返回204
				ServletActionContext.getResponse().setStatus(NO_CONTENT);
			} else {
				// 新增
				//生成唯一主键id，以时间作为id
				entity.setArticleID(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				awardService.insertAward(entity);
				//新增成功返回201
				ServletActionContext.getResponse().setStatus(CREATED);
			}
		} catch (Exception e) {
			//出现异常，返回500
			ServletActionContext.getResponse().setStatus(ERROR);
		}
		// 返回
		return NONE;
	}

	/**
	 * 删除悬赏内容
	 */
	@SecurityNonCheckRequired
	public String deleteAward() {
		// 判断是否为空
		if(StringUtils.isEmpty(ids)){
			//返回500
			ServletActionContext.getResponse().setStatus(ERROR);
			return NONE;
		}
		try {
			awardService.deleteAwardsByIds(ids);
			//删除成功返回204
			ServletActionContext.getResponse().setStatus(NO_CONTENT);
		} catch (Exception e) {
			//出现异常，返回500
			ServletActionContext.getResponse().setStatus(ERROR);
		}
		return NONE;
	}
	
	/**
	 * 悬赏列表
	 */
	@SecurityNonCheckRequired
	public String awardList(){
		//分页查询起始索引
		int begin = (page - 1) * rows;
		//分页数据
		List<AwardEntity> list = awardService.getAwardList(begin,rows);
		//数据总条数
		Long total = awardService.queryCount();
		//封装datagrid需要的属性数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		this.setResultObj(map);
		return SUCCESS;
	}

	/**
	 * set
	 * 
	 * @param awardService
	 */
	public void setAwardService(IAwardService awardService) {
		this.awardService = awardService;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAwardId() {
		return awardId;
	}

	/**
	 * set
	 * 
	 * @param awardId
	 */
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}

	/**
	 * getter
	 * @return
	 */
	public int getPage() {
		return page;
	}
	/**
	 * setter
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * getter
	 * @return
	 */
	public int getRows() {
		return rows;
	}
	/**
	 * setter
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	/**
	 * getter
	 * @return
	 */
	public String getIds() {
		return ids;
	}
	/**
	 * setter
	 * @param rows
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * getter
	 * @return
	 */
	public Map<String, Object> getResultObj() {
		return resultObj;
	}
	/**
	 * setter
	 * @param rows
	 */
	public void setResultObj(Map<String, Object> resultObj) {
		this.resultObj = resultObj;
	}
	/**
	 * getter
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * setter
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * getter
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setter
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
