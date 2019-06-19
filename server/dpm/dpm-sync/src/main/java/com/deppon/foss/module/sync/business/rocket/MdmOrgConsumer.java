package com.deppon.foss.module.sync.business.rocket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.deppon.dpboot.module.mq.client.consumer.GenericsMessageReConsumer;
import com.deppon.dpboot.module.mq.client.consumer.impl.GenericsConcurrentlyReConsumer;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.foss.framework.shared.util.string.StringUtil;
import com.deppon.foss.module.sync.business.entity.MdmSendOrgInfo;
import com.deppon.foss.module.sync.business.exception.DeptJMSException;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgProcessReult;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgResponse;
import com.deppon.foss.module.sync.esb.util.LogUtils;
@Component
public class MdmOrgConsumer implements GenericsMessageReConsumer<String>{
	
	/**
	 * 日志记录
	 */
	private static final Log LOGGER = LogFactory.getLog(MdmOrgConsumer.class);
	/**
	 * set injection
	 */
	
	private ITongxunLuService tongxunLuService;
	
	private String rocketMqUrl;
	
	/**
	 * 时间转换格式(精确到6位数毫秒)
	 */
	//static final String DATE_FROMATE = "yyyy-MM-dd HH:mm:ss.SSSSSS";
	static final String DATE_FROMATE = "yyyy-MM-dd HH:mm:ss";
	
	
	protected GenericsConcurrentlyReConsumer<String> consumer = new GenericsConcurrentlyReConsumer<String>();
	
	public MdmOrgConsumer(){
		
	}
	@PreDestroy
	public void shutdown() {
		consumer.shutdown();
	}
	
	@PostConstruct
	public void startup() {
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		System.out.println("启动接收主数据机构服务：");
		//consumer.setNamesrvAddr("10.230.20.226:8765");
		consumer.setNamesrvAddr(rocketMqUrl);
		consumer.setTopic("UUMS_SYN_MDMORG");
		consumer.setConsumerGroup("DPM_ORG_CGROUP");//根据系统名定义
		consumer.setMessageReConsumer(this);
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		// 客户端消费线程最大值，默认为64，请根据业务实际情况调整
		consumer.setConsumeThreadMax(64);
		  // 客户端消费线程最小值，默认为20，请根据业务实际情况调整
		consumer.setConsumeThreadMin(20);

		try {
			consumer.startup();
			System.out.println("Consumer Started.");
		} catch (Throwable e) {
			e.printStackTrace();
			e.printStackTrace();
			e.printStackTrace();
			e.printStackTrace();
			e.printStackTrace();
		}
	}
	@Override
	public void onConsume(String arg0) {}
	
	private void dealOrgVO(MdmSendOrgInfo info) {
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
			if (count > 1) {
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

	private void copyProperties(MdmSendOrgInfo entry, OrganizationEntity entity) {
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
	    //部门性质
		//entity.setDeptAttribute(entry.getDeptAttribute());
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
		//是否是合伙人
		if (null != entry.getIsPartner()) {
			entity.setIsPartner(entry.getIsPartner());
		}
		try {
			// 启用时间
		    if(null!=entry.getBeginTime()){
			entity.setCreateTime(new SimpleDateFormat(MdmOrgConsumer.DATE_FROMATE).parse(entry.getBeginTime()));
		    }
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
	public String getRocketMqUrl() {
		return rocketMqUrl;
	}
	public void setRocketMqUrl(String rocketMqUrl) {
		this.rocketMqUrl = rocketMqUrl;
	}
	@Override
	public Boolean onReConsume(String arg0) {
		if(arg0!=null){
			System.out.println("开始接收主数据组织");
			// log
			LOGGER.info("接收部门信息开始");
			// 获取组织相应实体
			SendMdmOrgResponse response = new SendMdmOrgResponse();
			// 成功数量
			int successCount = 0;
			// 失败数量
			int failedCount = 0;
			List<MdmSendOrgInfo> list = JSON.parseArray( arg0, MdmSendOrgInfo.class);
			// 传入参数强转
			//SendMdmOrgRequests request = (SendMdmOrgRequests) req;
			// log
			LogUtils.infoJSON(LOGGER, "部门信息request", arg0);
			try {
				// 如果传入参数为空
				if (null == list|| list.size() == 0) {
					// log
					LOGGER.info("接收到的组织信息为空");
					// 抛出异常
					throw new DeptJMSException("接收到的组织信息为空");
				}
				// 循环更改
				for (MdmSendOrgInfo info : list) {
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
				return Boolean.FALSE;
			}
			// log
			LogUtils.infoJSON(LOGGER, "组织信息同步结束", response);
			// log
			LOGGER.info("接收部门信息结束");
		
			
			}else{
				System.out.println("kongde............");
			}
		return Boolean.TRUE;
	}
	
	


}
