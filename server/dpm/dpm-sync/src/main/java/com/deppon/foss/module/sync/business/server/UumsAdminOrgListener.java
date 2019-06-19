package com.deppon.foss.module.sync.business.server;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.foss.framework.shared.util.string.StringUtil;
import com.deppon.foss.module.sync.business.exception.DeptJMSException;
import com.deppon.foss.module.sync.business.jms.MdmOrgInfo;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgProcessReult;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgRequest;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgResponse;
import com.deppon.foss.module.sync.esb.process.IProcess;
import com.deppon.foss.module.sync.esb.util.LogUtils;

/**
 * 
 * 部门组织信息同步监听
 * 
 * @author YangBin
 * @date 2013-8-9 下午12:14:03
 */
public class UumsAdminOrgListener implements IProcess {
	/**
	 * 日志记录
	 */
	private static final Log LOGGER = LogFactory.getLog(UumsAdminOrgListener.class);
	/**
	 * set injection
	 */
	private ITongxunLuService tongxunLuService;

	/**
	 * @部门组织信息接受信息
	 * @author YangBin
	 * @date 2013-8-14 下午5:00:04 最新修改人:FuZhong 最新修改时间:2015-6-18
	 * @see com.deppon.network.esb.process.IProcess#process(java.lang.Object)
	 */
	@Override
	public Object process(Object req) {
		// log
		LOGGER.info("接收部门信息开始");
		// 获取组织相应实体
		SendMdmOrgResponse response = new SendMdmOrgResponse();
		// 成功数量
		int successCount = 0;
		// 失败数量
		int failedCount = 0;
		// 传入参数强转
		SendMdmOrgRequest request = (SendMdmOrgRequest) req;
		// log
		LogUtils.infoJSON(LOGGER, "部门信息request", request);
		try {
			// 如果传入参数为空
			if (null == request || null == request.getAdminOrgInfoList()
					|| request.getAdminOrgInfoList().size() == 0) {
				// log
				LOGGER.info("接收到的组织信息为空");
				// 抛出异常
				throw new DeptJMSException("接收到的组织信息为空");
			}
			// 循环更改
			for (MdmOrgInfo info : request.getAdminOrgInfoList()) {
				try {
					// 获取组织编码
					if (StringUtil.equals(info.getOrgCode(), info.getParentOrgCode())) {
						// 异常抛出
						throw new DeptJMSException("组织编码OrgCode与组织的上组织编码ParentOrgCode相同");
					}
					// 组织id不能为0
					if (0 == info.getOrgId()) {
						// 异常抛出
						throw new DeptJMSException("组织id为0，数据不可用");
					}
					// 获取组织标杆编码
					if (StringUtils.isNotEmpty(info.getOrgBenchmarkCode())) {
						//抽取方法
						dealOrgVO(info);
					}
					// 成功数量+1
					successCount++;
					// 设置相应数量
					response.setSuccessCount(successCount);
					// 相应的系统
					response.setSysName("DPM");
					// 返回值
					SendMdmOrgProcessReult result = new SendMdmOrgProcessReult();
					// true为成功
					result.setResult(true);
					// 组织标杆编码
					result.setOrgBenchmarkCode(info.getOrgBenchmarkCode());
					// 组织更改id
					result.setOrgChangeId(info.getOrgChangeId());
					// 同步结果
					response.getProcessResultList().add(result);
				} catch (DeptJMSException e) {
					// error
					LOGGER.error(e.getMessage(), e);
					// 错误数量+1
					failedCount++;
					// 相应返回值
					SendMdmOrgProcessReult result = new SendMdmOrgProcessReult();
					// false为失败
					result.setResult(false);
					// 组织更改id
					result.setOrgChangeId(info.getOrgChangeId());
					// 错误原因
					result.setReason(e.getMessage());
					// 组织标杆编码
					result.setOrgBenchmarkCode(info.getOrgBenchmarkCode());
					// 系统信息
					response.setSysName("DPM");
					// 错误数量
					response.setFailedCount(failedCount);
					// 设置
					response.getProcessResultList().add(result);
				}
			}
		} catch (Exception e) {
			// 错误数量+1
			failedCount++;
			// log
			LOGGER.error("同步部门信息出错！", e);
			// 相应返回值
			SendMdmOrgProcessReult result = new SendMdmOrgProcessReult();
			// 错误原因
			result.setReason(e.getMessage());
			// 错误信息添加
			response.getProcessResultList().add(result);
			// 成功数量
			response.setSuccessCount(successCount);
			// 失败数量
			response.setFailedCount(failedCount);
			// 系统值
			response.setSysName("DPM");
		}
		// log
		LogUtils.infoJSON(LOGGER, "组织信息同步结束", response);
		// log
		LOGGER.info("接收部门信息结束");
		// 返回
		return response;
	}

	private void dealOrgVO(MdmOrgInfo info) {
		// 组织实体
		OrganizationEntity entity = new OrganizationEntity();
		// vo
		OrganizationVO vo = new OrganizationVO();
		// 组织id
		vo.setOrgId(info.getOrgId());
		// 属性更改
		copyProperties(info, entity);
		// 状态为2，删除组织
		if (2 == info.getOrgStatus()) {
			// 删除
			tongxunLuService.delOrg(info.getOrgId());
		} else {
			// 查询组织数量
			int count = tongxunLuService.queryOrgSize(vo);
			if (count >= 1) {
				// 先删除
				tongxunLuService.delOrg(info.getOrgId());
				// 后新增
				tongxunLuService.addOrg(entity);
			} else if (count == 1) {
				// 更新
				tongxunLuService.updateOrg(entity);
			} else {
				// 新增
				tongxunLuService.addOrg(entity);
			}
		}
	}

	private void copyProperties(MdmOrgInfo entry, OrganizationEntity entity) {
		// UUMS主键(OA特需) int
		entity.setOrgId(entry.getOrgId());
		if (StringUtils.isNotBlank(entry.getOrgCode())) {
			// 组织编码
			entity.setOrgCode(entry.getOrgCode().trim());
		} else {
			// 组织编码
			entity.setOrgCode(entry.getOrgCode());
		}
		// 组织名称
		entity.setOrgName(entry.getOrgName());
		// 组织层级 int
		entity.setOrgLevel(entry.getOrgLevel());
		// 上级组织id int
		entity.setParentOrgId(entry.getParentOrgId());
		// 地址
		entity.setOrgAddr(entry.getOrgAddress());
		// 邮编
		entity.setZipCode(entry.getOrgZipCode());
		// 组织管理者工号
		entity.setManagerId(entry.getOrgManager());
		// 电话
		entity.setLinkTel(entry.getOrgPhone());
		// 邮箱
		entity.setEmail(entry.getOrgEmail());
		// 父组织编码
		entity.setAppSysCode(entry.getParentOrgCode());
		// 空判断
		if (null != entry.getParentOrgName()) {
			// 父组织名称
			entity.setParentCompCode(entry.getParentOrgName());
		}
		// 部门性质
		entity.setOrgProperty(entry.getDeptAttributeNo() + "");
		// 设置标杆编码
		entity.setFinaSysCode(entry.getOrgBenchmarkCode());
		// 设置组织序列关系
		entity.setDeptSeq(entry.getDeptSeq());
		try {
			// 启用时间
			entity.setCreateTime(new SimpleDateFormat(UumsEmployeeListenner.DATE_FROMATE).parse(entry.getBeginTime()));
		} catch (ParseException e) {
			LOGGER.error("同步部门信息解析启用时间出错!", e);
			// 设置为空
			entity.setCreateTime(null);
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
