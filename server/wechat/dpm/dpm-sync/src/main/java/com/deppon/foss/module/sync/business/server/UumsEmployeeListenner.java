package com.deppon.foss.module.sync.business.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.sso.util.StringUtil;
import com.deppon.foss.module.sync.business.exception.EmployeeJMSException;
import com.deppon.foss.module.sync.business.jms.MdmEmpInfo;
import com.deppon.foss.module.sync.business.jms.SendMdmEmpProcessReult;
import com.deppon.foss.module.sync.business.jms.SendMdmEmpRequest;
import com.deppon.foss.module.sync.business.jms.SendMdmEmpResponse;
import com.deppon.foss.module.sync.esb.process.IProcess;
import com.deppon.foss.module.sync.esb.util.LogUtils;

/**
 * 
 * 职员监听类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:ztjie,date:2013-8-29 上午10:14:43
 * </p>
 * 
 * @author fuzhong
 * @date 2015-6-18
 * @since
 * @version
 */
public class UumsEmployeeListenner implements IProcess {
	/**
	 * log
	 */
	private static final Log LOGGER = LogFactory
			.getLog(UumsEmployeeListenner.class);
	/**
	 * set injection
	 */
	private ITongxunLuService tongxunLuService;
	/**
	 * 时间转换格式(精确到6位数毫秒)
	 */
	static final String DATE_FROMATE = "yyyy-MM-dd HH:mm:ss.SSSSSS";

	/**
	 * <p>
	 * 职员业务逻辑类
	 * </p>
	 * <BR>
	 * 遍历EmployeeInfoList根据工号逐条信息判断： <BR>
	 * （1）如果存在多条人员信息,则先根据工号删除这些相同的信息再新增，防止数据库出现多条数据 <BR>
	 * （2）如果存在1条人员信息，则修改 <BR>
	 * （3）如果不存在人员信息，则新增 <BR>
	 * 将成功或者失败的详细信息返回给UUMS
	 * 
	 * @param req
	 *            员工信息集e
	 * @return
	 */
	@Override
	public Object process(Object req) {
		// log
		LOGGER.info("接受员工信息开始");
		// 成功条数
		int successCount = 0;
		// 失败条数
		int failedCount = 0;
		// response实体
		SendMdmEmpResponse response = new SendMdmEmpResponse();
		// json-->SendMdmEmpRequest
		SendMdmEmpRequest request = (SendMdmEmpRequest) req;
		// log
		LogUtils.infoJSON(LOGGER, "员工信息request", request);
		try {
			// 空判断
			if (null == request || null == request.getEmployeeInfoList()
					|| request.getEmployeeInfoList().size() == 0) {
				// log
				LOGGER.info("接收到的SyncEmployeeRequest对象为空");
				// 异常抛出
				throw new EmployeeJMSException("接收到的SyncEmployeeRequest对象为空");
			}
			// 循环赋值
			for (MdmEmpInfo empInfo : request.getEmployeeInfoList()) {
				try {
					// 工号是否为null
					if (StringUtil.isNull(empInfo.getEmpCode())) {
						// 异常抛出
						throw new EmployeeJMSException("EmpCode is null");
					}
					// 用于查询参数
					EmployeeVO vo = new EmployeeVO();
					// 设置工号
					vo.setEmpCode(empInfo.getEmpCode());
					// 设置
					vo.setDepart(empInfo.getDeptCode());
					// 信息查询
					int count = tongxunLuService.uumsQuerySize(vo);
					// 属性考培
					this.copyProperties(empInfo, vo);
					if (count > 1) {
						// 人员数据大于1条时(工号不能有相同的重复数据)
						try {
							// 删除相同工号的多条数据
							tongxunLuService.delAndAdd(vo);
						} catch (Exception e) {
							// log
							LOGGER.info("删除和新增多条员工出错:" + JSON.toJSONString(empInfo));
						}
						// 一条信息
					} else if (count == 1) {
						try {
							// 修改人员信息
							tongxunLuService.updateEmployee(vo);
						} catch (Exception e) {
							// logger
							LOGGER.info("修改员工信息出错:" + JSON.toJSONString(vo));
						}
					} else {
						try {
							// 新增
							tongxunLuService.addEmployee(vo);
						} catch (Exception e) {
							// logger
							LOGGER.info("新增员工信息出错:" + JSON.toJSONString(vo));
						}
					}
					// 成功数+1
					successCount++;
					// 设置成功数量
					response.setSuccessCount(successCount);
					// 结果集定义
					SendMdmEmpProcessReult result = new SendMdmEmpProcessReult();
					// true为成功
					result.setResult(true);
					// 变更id
					result.setEmployeeChangeId(empInfo.getEmployeeChangeId());
					// 添加
					response.getProcessResultList().add(result);
					// 系统名
					response.setSysName("DPM");
				} catch (EmployeeJMSException e) {
					// log
					LOGGER.error(e.getMessage(), e);
					// 失败数+1
					failedCount++;
					// 结果集定义
					SendMdmEmpProcessReult result = new SendMdmEmpProcessReult();
					// 变更id
					result.setEmployeeChangeId(empInfo.getEmployeeChangeId());
					// fasle为失败
					result.setResult(false);
					// 失败原因
					result.setReason(e.getMessage());
					// 结果集累加
					response.getProcessResultList().add(result);
					// 失败数量
					response.setFailedCount(failedCount);
					// 系统名
					response.setSysName("DPM");
				}
			}
		} catch (Exception e) {
			// 失败数量+1
			failedCount++;
			// log
			LOGGER.error(e.getMessage(), e);
			// 结果集定义
			SendMdmEmpProcessReult result = new SendMdmEmpProcessReult();
			// 失败原因
			result.setReason(e.getMessage());
			// 结果集累加
			response.getProcessResultList().add(result);
			// 成功数量
			response.setSuccessCount(successCount);
			// 失败数量
			response.setFailedCount(failedCount);
		}
		// log
		LogUtils.infoJSON(LOGGER, "员工信息同步结束", response);
		// log
		LOGGER.info("接收员工信息结束");
		// 返回信息
		return response;
	}

	/**
	 * <p>
	 * 参数转换
	 * </p>
	 * 
	 * @author 150953 冯世杰
	 * @date 2015-3-25 下午5:02:56
	 * @param employeeInfo
	 *            源
	 * @param employeeEntity
	 *            目的
	 * @see
	 */
	private void copyProperties(MdmEmpInfo employeeInfo,
			EmployeeVO employeeEntity) {
		// 传入员工信息为空
		if (employeeInfo == null || employeeEntity == null) {
			// 直接跳出
			return;
		}
		// 与oa同步区分
		// employeeEntity.setEmpId(0);
		// 职员编号
		employeeEntity.setEmpCode(employeeInfo.getEmpCode());
		// 人员姓名
		employeeEntity.setEmpName(employeeInfo.getEmpName());
		// 性别 (0--false,1--true)
		employeeEntity.setGender(0 == employeeInfo.getGender() ? "f" : "m");
		// 出生日期
		try {
			employeeEntity.setBirthDate(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(employeeInfo.getBirthDate()
					.toString()));
		} catch (ParseException e) {
			// 设置出生日期
			employeeEntity.setBirthDate(employeeInfo.getBirthDate());
		} catch (NullPointerException e) {
			// 设置出生日期
			employeeEntity.setBirthDate(null);
		}
		// 人员状态（是否离职 ）0-离职人员；1-在职人员
		employeeEntity.setEmpStatus(0 == employeeInfo.getStatus() ? "leave"
				: "on");
		// 证件号码
		employeeEntity.setCardNo(employeeInfo.getDocNumber());
		// 入职日期
		try {
			employeeEntity
					.setInDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(employeeInfo.getInDate().toString()));
		} catch (ParseException e) {
			// 入职日期
			employeeEntity.setInDate(employeeInfo.getInDate());
		} catch (NullPointerException e) {
			// 入职日期
			employeeEntity.setInDate(null);
		}
		// 空判断
		if (null != employeeInfo.getOfficeEmail()) {
			// 企业邮箱
			employeeEntity.setEmailUserName(employeeInfo.getOfficeEmail());
		}
		// 手机号
		employeeEntity.setMobileNo(employeeInfo.getMobile());
		// 空判断
		if (null != employeeInfo.getPersonalEmail()) {
			// 私人邮箱
			employeeEntity.setEmail(employeeInfo.getPersonalEmail());
		}
		// 组织ID
		String deptId = employeeInfo.getDeptId();
		// 空判断
		if (null != deptId) {
			// 设置
			employeeEntity.setOrgId(Integer.valueOf(deptId));
		}
		// 职位
		employeeEntity.setJobName(employeeInfo.getPosition());
		// 岗位族群
		employeeEntity.setJobGroups(employeeInfo.getJobGroups());
		// 等级
		employeeEntity.setJobLevel(employeeInfo.getJobLevel());
		// 工作序列
		employeeEntity.setJobSequence(employeeInfo.getJobSequence());
		// 工作职责
		employeeEntity.setJobDuty(employeeInfo.getWorkexp());
		// 空判断
//		if (null != employeeInfo.getHomeTel()) {
//			// 电话
//			employeeEntity.setTel(employeeInfo.getHomeTel());
//		}
		// 空判断
		if (null != employeeInfo.getOfficeTel()) {
			// 电话
			employeeEntity.setTel(employeeInfo.getOfficeTel());
		}
		// 空判断
		if (null != employeeInfo.getHomeAddress()) {
			// 地址
			employeeEntity.setAddress(employeeInfo.getHomeAddress());
		}
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public ITongxunLuService getTongxunLuService() {
		return tongxunLuService;
	}

	/**
	 * set
	 * 
	 * @param tongxunLuService
	 */
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}
}
