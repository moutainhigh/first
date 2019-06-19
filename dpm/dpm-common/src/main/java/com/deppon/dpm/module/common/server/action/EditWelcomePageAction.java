package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.IEditWelcomePageService;
import com.deppon.dpm.module.common.shared.domain.WelcomePageEntity;
import com.deppon.dpm.module.common.shared.domain.WelcomePageLinkEntity;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.foss.framework.server.components.security.SecurityNonCheckRequired;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 移动端页面配置action
 * 
 * @date 2015-08-22
 * @author 231586
 * 
 */
public class EditWelcomePageAction extends BaseAction implements ModelDriven<WelcomePageEntity>{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4965996046649633247L;
	
	/**
	 * 定义常量
	 */
	private static final int PAGENUM = 1;
	private static final int PAGESIZE = 5;
	
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
	 * log
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(EditWelcomePageAction.class);
	
	/**
	 * 页面实体类
	 */
	private WelcomePageEntity pageEntity = new WelcomePageEntity();
	
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
	 * set注入
	 */
	private IEditWelcomePageService editWelcomePageService;
	
	/**
	 * Jdbc模板
	 */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 跳转添加页面
	 */
	public String addWelcomePage(){
		return "success";
	}
	
	/**
	 * 欢迎页列表
	 */
	@SecurityNonCheckRequired
	public void getWelcomePageList(){
		//防止datagrid重复加载出现错误
		if(page < 1){
			page = 1;
		}
		//分页查询起始索引
		int begin = (page - 1) * rows;
		//分页数据
		List<WelcomePageEntity> list = editWelcomePageService.getWelcomePageList(begin,rows);
		//判断不为空
		if(null != list && list.size() > 0){
			// 获取当前毫秒值
			Long now = System.currentTimeMillis();
			//遍历
			for (WelcomePageEntity entity : list) {
				// 判断时间是否在选定的时间之内
				if (entity.getStartDate().getTime() < now && now < entity.getEndDate().getTime()) {
					// 之内为true，前端显示未过期
					entity.setTimeOut(false);
				} else {
					// 否则为false，前端显示已过期
					entity.setTimeOut(true);
				}
			}
		}
		//数据总条数
		Long total = editWelcomePageService.queryCount();
		//封装datagrid需要的属性数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows", list);
		//数据返回页面
		this.writeToPage(map);
	}

	/**
	 * 保存页面传入的详细信息
	 */
	public String saveEditPage() {
		//健壮判断
		if(null == pageEntity){
			ServletActionContext.getResponse().setStatus(ERROR);
			return NONE;
		}
		// log
		logger.info("配置页传入参数:" + JSON.toJSONString(pageEntity));
		// 保存配置页信息
		try {
			int i = editWelcomePageService.savePic(pageEntity);
			if( i == 1){
				//保存成功
				ServletActionContext.getResponse().setStatus(CREATED);
			}else{
				//保存失败
				ServletActionContext.getResponse().setStatus(ERROR);
			}
		} catch (Exception e) {
			//保存失败
			ServletActionContext.getResponse().setStatus(ERROR);
		}
		return NONE;
	}

	/**
	 * 返回给前端的详情
	 */
	public void getPageDetails() {
		// 返回结果
		Result<WelcomePageEntity> result = new Result<WelcomePageEntity>();
		try {
			// List<WelcomePageEntity> details =
			// editWelcomePageService.getDetails(userId, true);
			List<WelcomePageEntity> details = editWelcomePageService
					.getDetails(null,true);
			if (null != details && details.size() > 0) {
				// 获取页面详情信息
				pageEntity = details.get(0);
				// count
				result.setCount(1);
			} else {
				// count
				result.setCount(0);
			}
			// errorCode
			result.setErrorCode(0);
			// errorMessage
			result.setErrorMessage("Y");
		} catch (Exception e) {
			// count
			result.setCount(0);
			// errorCode
			result.setErrorCode(-1);
			// errorMessage
			result.setErrorMessage("查询错误");
		}
		// 前端数据
		result.setData(pageEntity);
		// 返回
		writeToPage(result);
	}

	/**
	 * 根据ID删除
	 * 
	 * @return
	 */
	public String delWelcomePage() {
		// 判断是否为空
		if(StringUtils.isEmpty(ids)){
			//返回500
			ServletActionContext.getResponse().setStatus(ERROR);
			return NONE;
		}
		try {
			int i = editWelcomePageService.delWelcomePage(ids);
			if( i < 1){
				//删除失败
				ServletActionContext.getResponse().setStatus(ERROR);
			}else{
				//删除成功返回204
				ServletActionContext.getResponse().setStatus(NO_CONTENT);
			}
		} catch (Exception e) {
			//出现异常，返回500
			ServletActionContext.getResponse().setStatus(ERROR);
		}
		return NONE;
	}
	
	/**
	 * 下拉框加载导航页所有链接
	 */
	public void getWelcomePageLinks(){
		// 查询所有应用链接
		List<WelcomePageLinkEntity> list = editWelcomePageService.getWelcomePageLinks();
		//数据返回页面
		this.writeToPage(list);
	}
	
	/**
	 * 复写ModelDriven的方法
	 */
	@Override
	public WelcomePageEntity getModel() {
		return pageEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public WelcomePageEntity getPageEntity() {
		return pageEntity;
	}

	/**
	 * set
	 * 
	 * @param pageEntity
	 */
	public void setPageEntity(WelcomePageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

	/**
	 * set
	 * 
	 * @param editWelcomePageService
	 */
	public void setEditWelcomePageService(
			IEditWelcomePageService editWelcomePageService) {
		this.editWelcomePageService = editWelcomePageService;
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
	 * @param ids
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * getter
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	/**
	 * setter
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
