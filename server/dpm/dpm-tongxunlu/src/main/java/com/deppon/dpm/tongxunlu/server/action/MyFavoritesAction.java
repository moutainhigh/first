package com.deppon.dpm.tongxunlu.server.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.EmpFurloughInfoEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.service.IMyFavoritesService;
import com.deppon.dpm.tongxunlu.server.service.IPersonlyImageService;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * @date 2015-08-14
 * @author 231586
 * @description 常用联系人
 * 
 */
public class MyFavoritesAction extends BaseAction {

	private static final long serialVersionUID = -1865814131371198354L;
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(MyFavoritesAction.class);
	// set injection
	private IMyFavoritesService myFavoritesService;
	// set injection
	private IPersonlyImageService personlyImageService;
	// service
	private ITongxunLuService tongxunLuService;
	// redisService
	private RedisService redisService;

	/**
	 * 被操作人工号
	 */
	private String collectEmpCode;
	
	/**
	 * 新增常用联系人
	 */
	public void collectOne() {
		// 定义返回结果集
		Result<String> result = new Result<String>();
		// 用于参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 被收藏工号
		map.put("collectEmpCode", collectEmpCode);
		try {
			// 添加
			int res = myFavoritesService.collectOne(map);
			if (-1 == res) {
				// 设置返回提示信息
				result.setData("已添加过");
			} else {
				// 设置返回提示信息
				result.setData("添加成功");
			}
			// 返回数量
			result.setCount(res);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			logger.error("常用联系人collectOne:", e);
			// 返回数量
			result.setCount(0);
			// 设置返回提示信息
			result.setData("添加错误");
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// 前端输出
		writeToPage(result);
	}
	
	/**
	 * 判断是否为合伙人
	 */
	private boolean judgePartner(){
		try {
			// 从ThreadLocal中获取当前登录人的岗位
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			String jobName = loginResult.getUserEntity().getEmployee().getJobName();
			// 判断是否为合伙人
			if("合伙人营业部经理".equals(jobName) || "合伙人收银员".equals(jobName) || "合伙人营业员".equals(jobName)){
				return true;
			}
		} catch (Exception e) {
			logger.error("userId:"+userId+"判断是否为合伙人出错!!!", e);
		}
		return false;
	}
	/**
	 * 设置合伙人看不到除了事业合伙人拓展部下,所有B8以上人员的手机号及固定电话
	 */
	private void setMobileAndTelForPartner(EmployeeVO employeeVO){
		String jobLevel = employeeVO.getJobLevel();
		String deptSeq = employeeVO.getDeptSeq();
		if(null != deptSeq && !(deptSeq.indexOf("477595") != -1)
				&&("08".equals(jobLevel) || "09".equals(jobLevel) 
						|| "10".equals(jobLevel) || "C".equalsIgnoreCase(jobLevel)
						|| "D".equalsIgnoreCase(jobLevel))){
			employeeVO.setMobileNo(null);
			employeeVO.setTel(null);
		}
	}

	/**
	 * 获取常用联系人
	 */
	public void getFavorites() {
		// 常用联系人头像路径
		String path = null;
		// 定义返回类型，人员实体数组
		Result<List<EmployeeVO>> result = new Result<List<EmployeeVO>>();
		// 返回数组
		List<EmployeeVO> res = null;
		try {
			// 查询常用联系人
			res = myFavoritesService.getFavorites(userId);
			if(null != res && res.size() > 0){
				boolean isPartner = judgePartner();
				List<String> leaderList = tongxunLuService.getEmpleaderConfig();
				for (EmployeeVO employeeVO : res) {
					if(isPartner){
						setMobileAndTelForPartner(employeeVO);
					}
					// 根据管理族群来判定权限
					if (!"".equals(employeeVO.getJobGroups())
							&& "管理族群".equals(employeeVO.getJobGroups())) {
						// 参数转换
						employeeVO.setJobGroups("1");
					} else {
						employeeVO.setJobGroups("0");
					}
					// 判断是否是领导
					if (leaderList.contains(employeeVO.getEmpCode())) {
						// 号码置null
						employeeVO.setMobileNo(null);
					}
					// 设置休假信息
					this.setFurlough(employeeVO);
				}
			}
			// 循环设置对应人员头像
			res = extracted(path, res);
			// 是否是常用联系人状态
			res = extractedFavorites(res);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
		} catch (Exception e) {
			logger.error("常用联系人getFavorites:", e);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// 设置结果集
		result.setData(res);
		// 返回数量
		result.setCount(res == null ? 0 : res.size());
		// 结果集返回前端
		writeToPage(result);
	}

	/**
	 * 删除一个常用联系人
	 */
	public void removeOne() {
		// 定义一个返回类型
		Result<String> result = new Result<String>();
		// 用于参数拼接
		Map<String, String> map = new HashMap<String, String>();
		// 工号
		map.put("userId", userId);
		// 删除对象工号
		map.put("collectEmpCode", collectEmpCode);
		try {
			// 数据库操作
			int res = myFavoritesService.removeOne(map);
			if (0 == res) {
				// 提示信息
				result.setData("没有可删除的联系人");
			} else {
				// 提示信息
				result.setData("删除成功");
			}
			// 返回数量
			result.setCount(res);
			// errorCode
			result.setErrorMessage(Constants.ACTIVE_YES);
			// errorMessage
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
		} catch (Exception e) {
			logger.error("常用联系人removeOne:", e);
			// 返回数量
			result.setCount(0);
			// 提示信息
			result.setData("删除错误");
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// 结果集返回前端
		writeToPage(result);
	}

	/**
	 * 删除所有的常用联系人
	 */
	public void removeAll() {
		// 定义返回结果类型
		Result<String> result = new Result<String>();
		try {
			// 数据库操作
			int res = myFavoritesService.removeAll(userId);
			if (res > 0) {
				// 提示信息
				result.setData("删除成功");
			} else {
				// 提示信息
				result.setData("没有可删除的联系人");
			}
			// 返回数量
			result.setCount(res);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			logger.error("常用联系人removeAll:", e);
			// 返回数量
			result.setCount(0);
			// 提示信息
			result.setData("删除错误");
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// 返回消息给前端
		writeToPage(result);
	}

	/**
	 * 实体类添加头像信息返回
	 * 
	 * @param detailPath
	 * @param list
	 * @return
	 */
	private List<EmployeeVO> extracted(String detailPath, List<EmployeeVO> list) {
		if (null != list && list.size() > 0) {
			// 循环
			for (int i = 0; i < list.size(); i++) {
				try {
					// 根据工号查询头像路径
					detailPath = personlyImageService.downloadImage(list.get(i)
							.getEmpCode());
				} catch (FileNotFoundException e) {
					// 打印
					e.printStackTrace();
				}
				// 设置头像信息
				list.get(i).setHeadPhoto(detailPath);
			}
		}
		// 返回
		return list;
	}

	private List<EmployeeVO> extractedFavorites(List<EmployeeVO> list) {
		// 获取常用联系人
		List<EmployeeVO> favorites = myFavoritesService.getFavorites(userId);
		List<String> str = new ArrayList<String>();
		for (EmployeeVO favorite : favorites) {
			// 将人员信息加入
			str.add(favorite.getEmpCode());
		}
		for (int i = 0; i < list.size(); i++) {
			// 判断是否包含
			if (str.contains(list.get(i).getEmpCode())) {
				// 包含设置状态为Y，不能再添加常用联系人
				list.get(i).setMyFavoritesStatus("Y");
			} else {
				// 不包含设置状态为N，可添加常用联系人
				list.get(i).setMyFavoritesStatus("N");
			}
		}
		// 返回信息
		return list;
	}
	
	/**
	 * 设置休假信息
	 */
	private void setFurlough(EmployeeVO employeeVO) {
		String furlough = null;
		try {
			// 查询休假信息
			furlough = redisService.get(RedisService.DPM_TONGXUNLU_FURLOUGH_KEY + employeeVO.getEmpCode());
		} catch (Exception e) {
			logger.error("查询人员休假信息出错!!!",e);
		}
		
		if(StringUtils.isNotEmpty(furlough)) {
			// 休假信息对象
			EmpFurloughInfoEntity empFurInfo = JSON.parseObject(furlough, EmpFurloughInfoEntity.class);
			// 休假类型
			employeeVO.setFurlough(empFurInfo.getFurloughType());
			// 交接人姓名
			employeeVO.setHandoverPerson(empFurInfo.getHandoverEmpCode());
		}
	}

	// set
	public String getCollectEmpCode() {
		return collectEmpCode;
	}

	// set
	public void setCollectEmpCode(String collectEmpCode) {
		this.collectEmpCode = collectEmpCode;
	}

	// set
	public void setMyFavoritesService(IMyFavoritesService myFavoritesService) {
		this.myFavoritesService = myFavoritesService;
	}

	// set
	public void setPersonlyImageService(
			IPersonlyImageService personlyImageService) {
		this.personlyImageService = personlyImageService;
	}

	// setter
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}

	/**
	 * set
	 * @param redisService
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

}
