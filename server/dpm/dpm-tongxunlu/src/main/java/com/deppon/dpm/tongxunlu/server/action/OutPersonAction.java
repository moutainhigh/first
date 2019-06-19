package com.deppon.dpm.tongxunlu.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IOutPersonService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonEntity;
import com.deppon.dpm.tongxunlu.shared.domain.OutPersonTagEntity;

/**
 * 外部联系人.
 */
@SuppressWarnings("all")
public class OutPersonAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1397420409043898745L;
	/**
	 * log
	 */
	private static final Logger logger = Logger
			.getLogger(OutPersonAction.class);

	/**
	 * 外部联系人接口
	 */
	private IOutPersonService outPersonService;

	/**
	 * 外部联系人id
	 */
	private int id;
	/**
	 * 手机号
	 */
	private String mobileNo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 外部联系人标签
	 */
	private String tag;
	/**
	 * 创建人工号
	 */
	private String userId;
	/**
	 * 性别
	 */
	private String gendar;

	private static final int PAGESIZE_30 = 30;

	private int pageNo;

	private static final String[] TAG_TYPE = new String[] { "客户", "外包", "供应商",
			"顾问" };

	/**
	 * 新增外部联系人
	 */
	// @CookieNotCheckedRequired
	public void addOutPer() {
		// 处理跨域
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// 手机号
			map.put("mobileNo", mobileNo);
			// 邮箱
			map.put("email", email);
			// 姓名
			map.put("name", name);
			// 备注
			map.put("remark", remark);
			// 性别
			map.put("gendar", gendar);
			// 公司
			map.put("company", company);
			// 创建人id
			map.put("userId", userId);
			// 标签
			map.put("tag", tag);

			map.put("pageSize", 0);
			// 查询外部联系人是否已经存在
			List<OutPersonEntity> outPersonList = outPersonService
					.getOutPersonList(map);
			if (outPersonList.size() > 0) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage("手机号已经存在");
				writeToPage(result);
			} else {
				int count = outPersonService.addPerson(map);
				if (count > 0) {
					result.setErrorCode(Constants.ACTION_RESULT_SUC);
					result.setErrorMessage(Constants.ACTIVE_YES);
					writeToPage(result);
				}
			}
			// 异常处理
		} catch (Exception e) {
			logger.error("添加联系人失败", e);
			e.printStackTrace();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;

		}

	}

	/**
	 * 更新外部联系人
	 */
	// @CookieNotCheckedRequired
	public void updateOutPer() {
		// 处理跨域
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		// 判断请求参数
		if (userId == null) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage(userId + "必传参数");
			writeToPage(result);
			return;
		}

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			// 手机号
			map.put("mobileNo", mobileNo);
			// 邮箱
			map.put("email", email);
			// 姓名
			map.put("name", name);
			// 备注
			map.put("remark", remark);
			// 备注
			map.put("gendar", gendar);
			// 公司
			map.put("company", company);
			// 创建人id
			map.put("userId", userId);
			// 创建人id
			map.put("id", id);
			// 标签
			map.put("tag", tag);

			int count = outPersonService.updatePerson(map);
			if (count > 0) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				writeToPage(result);
			}
			// 异常处理
		} catch (Exception e) {
			logger.error("更新联系人失败", e);
			e.printStackTrace();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;
		}

	}

	/**
	 * 删除外部联系人
	 */
	// @CookieNotCheckedRequired
	public void deleteOutPer() {

		// 处理跨域
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();

		// 处理请求参数
		if (id == 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage(id + "必传参数");
			writeToPage(result);
			return;
		}

		try {
			int count = outPersonService.deletePerson(id);
			if (count > 0) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				writeToPage(result);
			}
			// 异常处理
		} catch (Exception e) {
			logger.error("删除联系人失败", e);
			e.printStackTrace();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;

		}

	}

	/**
	 * 获取外部联系人列表
	 * 
	 * @return
	 */
	// @CookieNotCheckedRequired
	public void getOutPersonList() {
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		if (ParamUtils.checkUserId(userId)) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}

		// 请求参数验证
		if (pageNo <= 0) {
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入参数错误：" + "页数必须大于0");
			writeToPage(result);
			return;
		}
		// 封装参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNo", getStartNo());
		map.put("userId", userId);
		map.put("pageSize", PAGESIZE_30);

		List<OutPersonEntity> outPersonList = outPersonService
				.getOutPersonList(map);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(outPersonList);
		writeToPage(result);

	}

	// 分页首页处理
	public int getStartNo() {
		// 起始评论编号
		int startNo = (pageNo - 1) * PAGESIZE_30;
		return startNo;
	}

	/**
	 * 获取联系人标签
	 */
	// @CookieNotCheckedRequired
	public void getPersonTag() {
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		List<String> arrayList = new ArrayList<String>();
		String tag = "客户,外包,供应商,顾问";
		List<String> list = Arrays.asList(tag.split(","));
		// 获得自定义标签

		List<OutPersonTagEntity> tagList = outPersonService
				.getPersonTag(userId);
		for (OutPersonTagEntity outPersonTag : tagList) {
			arrayList.add(outPersonTag.getTag());
		}
		List ownList = new ArrayList(list);
		// 拼接tag
		ownList.addAll(arrayList);
		result.setErrorCode(Constants.ACTION_RESULT_SUC);
		result.setErrorMessage(Constants.ACTIVE_YES);
		result.setData(ownList);
		writeToPage(result);
	}

	/**
	 * 添加联系人自定义标签
	 */
	// @CookieNotCheckedRequired
	public void addPersonTag() {
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		int count = 0;
		try {
			// tag判断
			for (String type : TAG_TYPE) {
				if (tag.equals(type)) {
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					result.setErrorMessage("标签已经存在");
					writeToPage(result);
					return;
				}
			}

			// 插入标签表
			List<OutPersonTagEntity> tagList = outPersonService
					.getPersonTag(userId);

			for (OutPersonTagEntity owntag : tagList) {
				if (owntag.getTag().equalsIgnoreCase(tag)) {
					result.setErrorCode(Constants.ACTION_RESULT_ERROR);
					result.setErrorMessage("标签已经存在");
					writeToPage(result);
					return;
				}
			}
			count = outPersonService.addPersonTag(userId, tag);

		} catch (Exception e) {
			logger.error("添加联系人自定义标签失败", e);
			e.printStackTrace();
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(Constants.ACTIVE_NO);
			writeToPage(result);
			return;
		}
		//
		if (count > 0) {
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			result.setErrorMessage(Constants.ACTIVE_YES);
			writeToPage(result);
		}
	}

	/**
	 * 添加联系人自定义标签
	 */
	// @CookieNotCheckedRequired
	public void deletePersonTag() {
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		if (ParamUtils.checkUserId(userId)) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("工号错误，不符合规范");
			writeToPage(result);
			return;
		}

		// 请求参数验证
		if (tag == null) {
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage("传入标签参数错误不能为空");
			writeToPage(result);
			return;
		}

		int count = 0;

		// 删除标签表
		try {
			count = outPersonService.deletePersonTag(userId, tag);
			if (count > 0) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage(Constants.ACTIVE_YES);
				writeToPage(result);
			} else {
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage(Constants.ACTIVE_NO);
				writeToPage(result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("删除外部自定义标签异常",e);
		}

		

	}

	/**
	 * 解决H5跨域 Access-Control-Allow-Credentials
	 */
	public void solveCrossDomain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public IOutPersonService getOutPersonService() {
		return outPersonService;
	}

	public void setOutPersonService(IOutPersonService outPersonService) {
		this.outPersonService = outPersonService;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

}
