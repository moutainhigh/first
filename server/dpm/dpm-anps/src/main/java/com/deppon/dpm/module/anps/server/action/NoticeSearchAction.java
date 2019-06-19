package com.deppon.dpm.module.anps.server.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.anps.server.service.INoticeSearchService;
import com.deppon.dpm.module.anps.shared.define.AnpsConstants;
import com.deppon.dpm.module.anps.shared.domain.NoticeSearchResult;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 公文搜索接口
 * @author 276344
 *
 */
public class NoticeSearchAction extends BaseAction{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	INoticeSearchService searchService;
	//搜索内容
	private String searchContent;
	//当前页  如果不传的话则查询全部
	private Integer pageNo;
	//组织id
	private String orgid;



	/**
	 * 公文搜索
	 */
	/*@CookieNotCheckedRequired
	public void search(){
		//接口地址 http://localhost:8080/dpm/dpm-anps/noticeSearch_search.action?searchContent=&orgid=
		this.solveCrossDomain();
		//结果集
		Result<NoticeSearchResult> result = new Result<NoticeSearchResult>();
		if(StringUtils.isBlank(searchContent)){
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入参数不能为空");
			writeToPage(result);
			return;
		}
		//是否是纯中文  如果是的话就按组织名和人名搜索
	    //boolean isOrgNameOrEmpName = searchContent.matches("[\u4E00-\u9FA5]+");
	    //纯数字
	    boolean isNum = searchContent.matches("^[0-9]*$");
	    if (isNum && searchContent.length() != AnpsConstants.searchTextLength) {
			//是纯数字 但不是6位工号
	    	result.setErrorCode(Constants.SERVICE_ERROR);
			result.setErrorMessage("不是6位纯数字：" + searchContent);
			writeToPage(result);
			return;
		}
	    //6位纯数字则表示工号
		boolean isEmpCode = searchContent.matches("^\\d{6}$");
		
		NoticeSearchResult searchResult = new NoticeSearchResult();
		
		try {

			if (isEmpCode) {
				List<OrganizationEntity> orgs = new ArrayList<OrganizationEntity>();
				List<EmployeeVO> emps = searchService.getEmps(searchContent, null, orgid,pageNo);
				searchResult.setOrgs(orgs);
				searchResult.setEmps(emps);
				
			}else {
				//不是纯数字的话就 按 组织名 和 姓名搜索
				List<OrganizationEntity> orgs = searchService.getOrgs(searchContent, orgid);
				List<EmployeeVO> emps = searchService.getEmps(null, searchContent, orgid, pageNo);
				searchResult.setOrgs(orgs);
				searchResult.setEmps(emps);
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(searchResult);
		// 返回
		writeToPage(result);
	}*/
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	public void setSearchService(INoticeSearchService searchService) {
		this.searchService = searchService;
	}
	
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
}
