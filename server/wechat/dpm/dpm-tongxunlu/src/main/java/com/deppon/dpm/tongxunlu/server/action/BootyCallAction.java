package com.deppon.dpm.tongxunlu.server.action;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IBootyCallService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.shared.domain.BootyEntity;

/**
 * 约吧
 * 
 * @Date 2015-09-14
 * @author 231586
 * 
 */
public class BootyCallAction extends BaseAction {
	private static final long serialVersionUID = -3174811032893556260L;
	// 日志
	private static final Logger logger = Logger
			.getLogger(BootyCallAction.class);
	// 约会实体信息
	private BootyCallEntity entity;
	// set注入
	private IBootyCallService bootyCallService;
	// 注入tongxunlu
	private ITongxunLuService tongxunLuService;
	// 注入头像service
	//private IPersonlyImageService personlyImageService;
	// 是不是查询自己的 Y-是的 N-不是 空-全部
	private String isMyself;
	// 根据活动类型查询
	private String type;
	// 根据活动时间查询 0-今天 1-明天 7-7天内 空-全部
	private String intervalDay;
	// 分页
	private int limit;
	// 性别
	private String gender;
	// 约吧信息对应ID
	private int dateId;

	/**
	 * 发布约吧信息
	 */
	@CookieNotCheckedRequired
	public void publishBootyCallInfo() {
		// 定义返回实体
		Result<String> result = new Result<String>();
		// 定义返回count值，0表示发布失败
		int res = 0;
		// 获取约会地址
		String address = entity.getDataAddress();
		// 获取约会类型
		String dataType = entity.getDataType();
		// 获取约会主题
		String subject = entity.getDataSubject();
		try {
			// 处理IOS的中文编码问题
			if (null != address && address.startsWith("%")) {
				// 地址解码
				address = URLDecoder.decode(address, "utf-8");
				// 重新设置地址信息
				entity.setDataAddress(address);
			}
			// 处理IOS的中文编码问题
			if (null != dataType && dataType.startsWith("%")) {
				// 类型解码
				dataType = URLDecoder.decode(dataType, "utf-8");
				// 重新设置类型信息
				entity.setDataType(dataType);
			}
			// 处理IOS的中文编码问题
			if (null != subject && subject.startsWith("%")) {
				// 主题解码
				subject = URLDecoder.decode(subject, "utf-8");
				// 重新设置主题信息
				entity.setDataSubject(subject);
			}
			// 默认将自己添加进去
			entity.setDataEmpCode(entity.getUserId());
			// 更改属性
			entity.setDataGender("n".equals(entity.getDataGender()) ? "noLimit"
					: entity.getDataGender());
			// 发布约吧信息
			res = bootyCallService.publishBootyCallInfo(entity);
			// 数据库插入成功
			if (res > 0) {
				// 设置返回数据
				result.setData("发布成功");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_YES);
			} else {
				// 设置返回数据
				result.setData("发布失败");
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage(Constants.ACTIVE_NO);
			}
		} catch (Exception e) {
			// log
			logger.error("约吧信息出错", e);
			// 提示信息
			result.setData("数据库操作失败");
			// errorCode
			result.setErrorCode(Constants.SERVICE_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);

		}
		// 设置相应数量
		result.setCount(res);
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 查询约吧信息
	 */
	@CookieNotCheckedRequired
	public void getBootyCallInfo() {
		// 定义数据库查询结果
		List<Map<String, Object>> bootyCallInfo = new ArrayList<Map<String, Object>>();
		// 定义返回实体信息
		Result<List<Map<String, Object>>> result = new Result<List<Map<String, Object>>>();
		// 定义一页展示数据
		int pageSize = MagicNumber.NUM20;
		// 定义起始值
		int start = pageSize * limit;
		// 属性值
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断是否查询自己,不传为全部查询
		if (null != isMyself && StringUtils.isNotEmpty(isMyself)) {
			// 拼接参数
			map.put("userId", userId);
			// 如果是自己，其余条件都没用
			if ("Y".equalsIgnoreCase(isMyself)) {
				map.put("isMyself", "Y");
			} // 不是自己发布的，拼接其余参数
			else if ("N".equalsIgnoreCase(isMyself)) {
				// 类型参数拼接
				if (null != type && StringUtils.isNotEmpty(type)) {
					map.put("type", type);
				}
				// 性别参数拼接
				if (null != gender && StringUtils.isNotEmpty(gender)) {
					map.put("gender", gender.equals("female") ? "f" : "m");
				}
				// 天数参数拼接
				if (null != intervalDay && StringUtils.isNotEmpty(intervalDay)) {
					map.put("intervalDay", intervalDay);
				}
			}
		} // 全部查询也需要其余参数
		else {
			// 类型参数拼接
			if (null != type && StringUtils.isNotEmpty(type)) {
				map.put("type", type);
			}
			// 性别参数拼接
			if (null != gender && StringUtils.isNotEmpty(gender)) {
				map.put("gender", gender.equals("female") ? "f" : "m");
			}
			// 天数参数拼接
			if (null != intervalDay && StringUtils.isNotEmpty(intervalDay)) {
				map.put("intervalDay", intervalDay);
			}
		}
		// 开始条数
		map.put("start", start);
		// 页面数量
		map.put("pageSize", pageSize);
		try {
			// 获取返回实体
			bootyCallInfo = bootyCallService.getBootyCallInfo(map);
			// 通讯录领导列表
			List<String> leaderList = tongxunLuService.getEmpleaderConfig();
			// 循环更改属性值
			for (int i = 0; i < bootyCallInfo.size(); i++) {
				bootyCallInfo.set(i, changeAttr(userId, bootyCallInfo.get(i),leaderList));
			}
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage("查询成功");
		} catch (Exception e) {
			// log
			logger.error("约吧查询出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("查询失败");
		}
		// 返回条数
		result.setCount(bootyCallInfo.size());
		// 实体类
		result.setData(bootyCallInfo);
		// 返回前端
		writeToPage(result);
	}

	/**
	 * 更改属性名称
	 * 
	 * @param bootyCallInfo
	 * @return
	 */
	private Map<String, Object> changeAttr(String userId,
			Map<String, Object> bootyCallInfo,List<String> leaderList) {
		// 用map接受
		Map<String, Object> map = new HashMap<String, Object>();
		// 头像设置
		map.put("headImage", "https://dpm.deppon.com:8881/dpm/headPhoto/"
				+ bootyCallInfo.get("pictPath"));
		// 对应的约吧信息id
		map.put("dateId", bootyCallInfo.get("id"));
		// 主题
		map.put("subject", bootyCallInfo.get("data_subject"));
		// 姓名
		map.put("name", bootyCallInfo.get("empName"));
		// 要求的性别
		map.put("requiredGender", bootyCallInfo.get("data_gender"));
		// 创建人
		map.put("userId", bootyCallInfo.get("userId"));
		// 约会时间
		map.put("time", bootyCallInfo.get("data_time"));
		// 约会地点
		map.put("address", bootyCallInfo.get("data_address"));
		// 约会人数
		map.put("count",
				("".equals(bootyCallInfo.get("data_empCode")) || null == bootyCallInfo
						.get("data_empCode")) ? 0 : bootyCallInfo
						.get("data_empCode").toString().split(",").length);
		// 约会类型
		map.put("type", bootyCallInfo.get("data_type"));
		// 是否是自己发布
		map.put("mySelf", userId.equals(bootyCallInfo.get("userId")));
		if (userId.equals(bootyCallInfo.get("userId"))) {
			// 如果是自己发布，默认参加
			map.put("joined", true);
		} else {
			// 判断是否参加
			map.put("joined",
					bootyCallService.checkExists(userId,
							bootyCallInfo.get("data_empCode")));
		}
		// 吧主性别
		map.put("sex", bootyCallInfo.get("gender"));
		try {
			// 参加人详细信息
//			map.put("joinArr",
//					getJoinedDetail(("".equals(bootyCallInfo
//							.get("data_empCode")) || null == bootyCallInfo
//							.get("data_empCode")) ? "" : bootyCallInfo.get(
//							"data_empCode").toString()));
			
			List<BootyEntity> joinedDetail = getJoinedDetail(("".equals(bootyCallInfo
					.get("data_empCode")) || null == bootyCallInfo
					.get("data_empCode")) ? "" : bootyCallInfo.get(
					"data_empCode").toString(),leaderList);
			map.put("joinArr",joinedDetail == null ? "" : joinedDetail);
		} catch (Exception e) {
			// 出错默认没有参加人
			map.put("joinArr", "");
		}
		// 返回
		return map;
	}

	/**
	 * 由于阿狸JSON的局限性，另用一个类封装参数
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private List<BootyEntity> getJoinedDetail(String str,List<String> leaderList) throws Exception {
	/*	// 定义详细参加人实体
		List<BootyEntity> bes = new ArrayList<BootyEntity>();
		// 通讯录查询参数设置
		EmployeeVO vo = null;
		// 查询返回实体
		EmployeeEntity empEntity = null;
		// 参加人实体类
		BootyEntity be = null;
		if (StringUtils.isNotEmpty(str)) {
			// 根据参加人工号分隔
			String[] ress = str.split(",");
			// 个人头像
			String headImage = null;
			for (String res : ress) {
				// 设置查询条件
				vo = new EmployeeVO();
				// 设置工号
				vo.setEmpCode(res);
				// 查询结果
				if(StringUtils.isNotEmpty(res)){
					empEntity = tongxunLuService.queryEmployeeByCode(vo);
					// 个人头像查询
					headImage = personlyImageService.downloadImage(res);
				}
				// 实体
				if(null != empEntity){
					be = new BootyEntity(empEntity.getEmpCode(), empEntity.getEmpName(),
							headImage, empEntity.getMobileNo(), empEntity.getOrgName(),
							empEntity.getGender());
					// 添加
					bes.add(be);
				}
			}
		}*/
		
		// 定义详细参加人实体
		List<BootyEntity> bes = null;
		if (StringUtils.isNotEmpty(str)) {
			// 根据参加人工号分隔
			String[] ress = str.split(",");
			bes = bootyCallService.queryJoinEmpsByEmpCodes(ress,leaderList);
		}
		// 返回
		return bes;
	}
	
	/**
	 * 删除
	 */
	@CookieNotCheckedRequired
	public void delete(){
		writeToPage(bootyCallService.delete(dateId));
		
	}

	/**
	 * 加入约会
	 */
	@CookieNotCheckedRequired
	public void joinBootyCall() {
		// 定义返回实体
		Result<String> result = new Result<String>();
		// 判断是否加入 0-未加入
		int join = 0;
		try {
			// 空判断
			if (0 != dateId || StringUtils.isNotEmpty(userId)) {
				// 加入约吧
				join = bootyCallService.joinBootyCall(userId, dateId);
			}
			// 设置返回值
			result.setCount(join);
			// 返回信息
			result.setData("加入约会信息");
			if (join > 0) {
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				// errorMessage
				result.setErrorMessage("加入约会成功");
			} else {
				// errorCode
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("加入约会失败");
			}
		} catch (Exception e) {
			// log
			logger.error("约吧添加出错信息", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("服务器异常，请稍后再试");
		}
		// 前端返回
		writeToPage(result);
	}

	// get
	public BootyCallEntity getEntity() {
		return entity;
	}

	// set
	public void setEntity(BootyCallEntity entity) {
		this.entity = entity;
	}

	// set
	public void setBootyCallService(IBootyCallService bootyCallService) {
		this.bootyCallService = bootyCallService;
	}

	// get
	public String getType() {
		return type;
	}

	// set
	public void setType(String type) {
		this.type = type;
	}

	// get
	public String getIntervalDay() {
		return intervalDay;
	}

	// set
	public void setIntervalDay(String intervalDay) {
		this.intervalDay = intervalDay;
	}

	// get
	public String getIsMyself() {
		return isMyself;
	}

	// set
	public void setIsMyself(String isMyself) {
		this.isMyself = isMyself;
	}

	// get
	public int getLimit() {
		return limit;
	}

	// set
	public void setLimit(int limit) {
		this.limit = limit;
	}

	// get
	public String getGender() {
		return gender;
	}

	// set
	public void setGender(String gender) {
		this.gender = gender;
	}

	// get
	public int getDateId() {
		return dateId;
	}

	// set
	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	// set
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}

	// set
//	public void setPersonlyImageService(
//			IPersonlyImageService personlyImageService) {
//		this.personlyImageService = personlyImageService;
//	}

}
