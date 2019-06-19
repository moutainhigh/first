package com.deppon.dpm.module.management.server.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.dao.IAppAutoUpdateControlDao;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;
import com.deppon.dpm.module.management.server.dao.IAppDetailDao;
import com.deppon.dpm.module.management.server.dao.IApplyDeviceDao;
import com.deppon.dpm.module.management.server.dao.IApplyStoreDao;
import com.deppon.dpm.module.management.server.service.IAppPermissionService;
import com.deppon.dpm.module.management.server.service.IApplyStoreService;
import com.deppon.dpm.module.management.server.service.IBIPermissionService;
import com.deppon.dpm.module.management.server.service.IBigDataAppPermissionService;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.dpm.module.management.shared.domain.ApplyDevice;
import com.deppon.dpm.module.management.shared.domain.ApplyStore;
import com.deppon.dpm.module.management.shared.domain.ApplyStoreAppraise;
import com.deppon.dpm.module.management.util.FileUploadUtil;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

/**
 * 应用商店
 * 
 * @author 245968
 * 
 */
public class ApplyStoreService implements IApplyStoreService {

	// 日志
	private static final Logger logger = Logger
			.getLogger(ApplyStoreService.class);

	// 图片类型
	private static final String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
	/**
	 * 通过调用uums返回角色编码列表，根据权限显示相应的应用
	 */
	private String roleUrl;
	/**
	 * set injection
	 */
	private IApplyStoreDao iApplyStoreDao;
	/**
	 * set injection
	 */
	private IApplyDeviceDao iApplyDeviceDao;
	/**
	 * set injection
	 */
	private IAppDetailDao appDetailDao;

	private IAppAutoUpdateControlDao appAutoUpdateControlDao;
	/**
	 * 判断BI有没有权限
	 */
	private IBIPermissionService biService;
	/**
	 * 判断BI有没有权限
	 */
	private IBigDataAppPermissionService bigDataAppPermissionService;
	/**
	 * 应用权限表
	 */
	private IAppPermissionService appPermissionService;
	/**
	 * 员工信息
	 */
	private IExternalMethodService externalMethodService;

	/**
	 * app图片地址
	 */
	private String appPicDir;
	/**
	 * 服务器访问地址
	 */
	private String hostPort;
	/**
	 * CRM有权限的岗位数组
	 */
	private static List<String> HAS_CRM_JOBNAMES = null;
	/**
	 * 智慧收派有权限的岗位数组
	 */
	private static List<String> HAS_RDVS_JOBNAMES = null;
	/**
	 * 智慧收派有权限的岗位数组
	 */
	private static List<String> HAS_ISDM_JOBNAMES = null;
	static {
		HAS_CRM_JOBNAMES = new ArrayList<String>();
		HAS_CRM_JOBNAMES.add("营业部经理");
		HAS_CRM_JOBNAMES.add("营业区区域经理");
		HAS_CRM_JOBNAMES.add("大区总经理");
		HAS_CRM_JOBNAMES.add("点部经理");
		HAS_CRM_JOBNAMES.add("分部经理");
		HAS_CRM_JOBNAMES.add("派送部经理");

		HAS_RDVS_JOBNAMES = new ArrayList<String>();
		HAS_RDVS_JOBNAMES.add("快递员");
		HAS_RDVS_JOBNAMES.add("快递员组长");
		HAS_RDVS_JOBNAMES.add("营业部经理");
		HAS_RDVS_JOBNAMES.add("点部经理");
		HAS_RDVS_JOBNAMES.add("分部经理");
		HAS_RDVS_JOBNAMES.add("营业区区域经理");
		HAS_RDVS_JOBNAMES.add("区部高级经理");
		HAS_RDVS_JOBNAMES.add("大区办公室主任");
		HAS_RDVS_JOBNAMES.add("快递业务管理组经理");
		HAS_RDVS_JOBNAMES.add("大区总经理");
		HAS_RDVS_JOBNAMES.add("营业点经理");
		/**
		 * 事业部总裁
		事业部办公室主任
		营运品质管理组高级经理
		标准推进组高级经理
		营运业务支持组高级经理
		营运效率管理组高级经理
		规划与解决方案支持组高级经理
		审计组高级经理
		大区总经理
		大区办公室主任
		快递业务管理组经理
		营业区区域经理
		营业部经理
		营业点经理
		分部经理
		末端本部总裁
		 */
		
		HAS_ISDM_JOBNAMES = new ArrayList<String>();
		HAS_ISDM_JOBNAMES.add("事业部总裁");
		HAS_ISDM_JOBNAMES.add("事业部办公室主任");
		HAS_ISDM_JOBNAMES.add("营运品质管理组高级经理");
		HAS_ISDM_JOBNAMES.add("标准推进组高级经理");
		HAS_ISDM_JOBNAMES.add("营运业务支持组高级经理");
		HAS_ISDM_JOBNAMES.add("营运效率管理组高级经理");
		HAS_ISDM_JOBNAMES.add("规划与解决方案支持组高级经理");
		HAS_ISDM_JOBNAMES.add("审计组高级经理");
		HAS_ISDM_JOBNAMES.add("大区总经理");
		HAS_ISDM_JOBNAMES.add("大区办公室主任");
		HAS_ISDM_JOBNAMES.add("快递业务管理组经理");
		HAS_ISDM_JOBNAMES.add("营业区区域经理");
		HAS_ISDM_JOBNAMES.add("营业部经理");
		HAS_ISDM_JOBNAMES.add("营业点经理");
		HAS_ISDM_JOBNAMES.add("分部经理");
		HAS_ISDM_JOBNAMES.add("末端本部总裁");
		HAS_ISDM_JOBNAMES.add("快递业务管理组总监");
		HAS_ISDM_JOBNAMES.add("运营管理部总监");
		HAS_ISDM_JOBNAMES.add("快递业务管理组总监");
		HAS_ISDM_JOBNAMES.add("标准推进专员");
		HAS_ISDM_JOBNAMES.add("中级一等标准推进专员");
		HAS_ISDM_JOBNAMES.add("中级二等标准推进专员");
		HAS_ISDM_JOBNAMES.add("中级三等标准推进专员");
		
	}

	public static final int NUMBER_OF_FNN = 4;

	@Override
	public List<ApplyStore> list(EmployeeEntity employee, List<String> role,
			String osType, String appVersion) {

		// 返回的结果
		List<ApplyStore> result = new ArrayList<ApplyStore>();
		// 健壮性判断
		if (null == employee) {
			return result;
		}
		// 调取BI接口 判断是否有BI权限
		String hasBiPermission = biService.hasBiPermission(employee
				.getEmpCode());
		// BI不能访问人员20170401（写死）
		List<String> biNotList = new ArrayList<String>();
		biNotList.add("204401");
		biNotList.add("218024");
		biNotList.add("225748");
		biNotList.add("273026");
		biNotList.add("284310");
		biNotList.add("292798");
		biNotList.add("298634");

		// 新工作流访问人员20170810（写死）
		List<String> nwfsList = new ArrayList<String>();
		/*
		 * nwfsList.add("041338"); nwfsList.add("149607");
		 * nwfsList.add("276344"); nwfsList.add("274727");
		 * nwfsList.add("245102"); nwfsList.add("275309");
		 * nwfsList.add("256339"); nwfsList.add("357095");
		 * nwfsList.add("269007"); nwfsList.add("293575");
		 * nwfsList.add("491275"); nwfsList.add("351355");
		 * nwfsList.add("079464"); nwfsList.add("106998");
		 * nwfsList.add("063155"); nwfsList.add("148257");
		 * nwfsList.add("226728"); nwfsList.add("237986");
		 */
		// 职能研发中心 权限
		nwfsList.add("办公门户研发部");
		nwfsList.add("人力资源研发部");
		nwfsList.add("后勤支持研发部");
		nwfsList.add("BI研发部");
		nwfsList.add("数据架构部");
		nwfsList.add("大数据研发部");
		nwfsList.add("移动BI研发部");
		nwfsList.add("021198");

		// userId
		String userId = employee.getEmpCode();
		// 部门名称
		String orgName = employee.getOrgName();
		orgName = orgName == null ? "" : orgName;
		// 岗位
		String jobname = employee.getJobName() == null ? "" : employee
				.getJobName();

		// 是否是合伙人
		boolean isPartner = false;
		if (userId.toUpperCase().startsWith("T") || orgName.startsWith("【H】")
				|| orgName.startsWith("【D】") || orgName.startsWith("【J】")
				|| orgName.startsWith("【d】")) {
			isPartner = true;
		}
		// 获取数据库中应用商店列表
		List<ApplyStore> list = iApplyStoreDao.list(userId);
		// 获取应用评分
		for (ApplyStore app : list) {
			Double score = appDetailDao.getAppScoreById(app.getAppId());
			if (score != null) {
				BigDecimal bg = new BigDecimal(score);
				// 截取到小数点后一位
				double f1 = bg.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
				// 获取小数点后一位数字
				String fn = (f1 + "").charAt((f1 + "").length() - 1) + "";
				// string转int
				int fnn = Integer.parseInt(fn);
				if (fnn < NUMBER_OF_FNN) {
					app.setStarCount(Double.valueOf((f1 + "").charAt(0) + "."
							+ "0"));
				} else {
					app.setStarCount(Double.valueOf((f1 + "").charAt(0) + "."
							+ "5"));
				}
			}
		}
		// 循环 T工号默认没有权限，如果有权限角色则放开
		String hasDPMPermission = checkPermission(employee, role, osType,
				appVersion, hasBiPermission, result, userId, jobname,
				isPartner, list);
		if (!hasDPMPermission.equals("true")) {
			// 有BI权限，无登移动办公权限
			List<ApplyStore> res = new ArrayList<ApplyStore>();
			ApplyStore point = new ApplyStore();
			point.setStatus(hasDPMPermission);
			res.add(point);
			return res;
		}
		// 返回
		return result;
	}

	private String checkPermission(EmployeeEntity employee, List<String> role,
			String osType, String appVersion, String hasBiPermission,
			List<ApplyStore> result, String userId, String jobname,
			boolean isPartner, List<ApplyStore> list) {
		for (ApplyStore applyStore : list) {
			String iosAppVersion = applyStore.getIosAppVersion();
			String androidAppVersion = applyStore.getAndroidAppVersion();
			try {
				// 如果有配置应用上线版本号
				if (StringUtils.isNotBlank(iosAppVersion)
						&& StringUtils.isNotBlank(appVersion)) {
					// 手机传过来的app版本为空，则不显示
					if (StringUtils.isBlank(appVersion)) {
						continue;
					} else {
						// 手机传递的app版本号int值
						int appVersionIntVal = Integer.valueOf(appVersion
								.trim().replace(".", ""));
						// 应用上线的ios版本号int值
						int iosAppVersionIntVal = Integer.valueOf(iosAppVersion
								.trim().replace(".", ""));
						// 应用上线的android版本号int值
						int androidAppVersionIntVal = Integer
								.valueOf(androidAppVersion.trim().replace(".",
										""));

						// 判断如果android和ios手机安装的app版本不大于等于配置的版本号，则不显示
						if (!(("android".equals(osType) && appVersionIntVal >= androidAppVersionIntVal) || ("iphone"
								.equals(osType) && appVersionIntVal >= iosAppVersionIntVal))) {
							continue;
						}
					}
				}
			} catch (Exception e) {
				logger.error("请求应用商店数据根据版本兼容可显示的应用出错>>>>{userId=" + userId
						+ "}", e);
			}

			// 该应用是否对合伙人开放
			boolean partnerPermission = applyStore.getPartnerPermission();
			// 如果列表中包含crm
			String hasDPMPermission = checkCrm(employee, role, hasBiPermission,
					result, userId, jobname, isPartner, applyStore,
					partnerPermission);
			if (!hasDPMPermission.equals("true")) {
				// 有BI权限，无登移动办公权限
				return hasDPMPermission;
			}
		}
		return "true";
	}

	private String checkCrm(EmployeeEntity employee, List<String> role,
			String hasBiPermission, List<ApplyStore> result, String userId,
			String jobname, boolean isPartner, ApplyStore applyStore,
			boolean partnerPermission) {
		if (applyStore.getAppId() == DpmConstants.crm) {
			// 有crm权限或者是合伙人并且对合伙人开放，或者岗位是营业部经理、营业区区域经理、XXX销售专员
			forCrm(role, result, jobname, isPartner, applyStore,
					partnerPermission);
		}

		else if (applyStore.getAppId() == DpmConstants.re_reward) {
			// 提成奖金权限或者是合伙人并且对合伙人开放
			forReReward(employee, role, result, userId, isPartner, applyStore,
					partnerPermission);
		}

		else if (applyStore.getAppId() == DpmConstants.mobile_bi) {
			/*
			 * // 移动BI（默认应用） 管理族群有权限 其他看权限 if ((role != null &&
			 * role.contains(DpmConstants.BIRole)) ||
			 * ("管理族群".equals(employee.getJobGroups()) && (!isPartner ||
			 * partnerPermission))) { if(!biNotList.contains(userId)){ //
			 * 添加到应用商店 result.add(applyStore); } }
			 */
			if (hasBiPermission.equals("true")) {
				// 添加到应用商店
				result.add(applyStore);
			} else if (!hasBiPermission.equals("false")) {
				// 有BI权限，无登移动办公权限
				return hasBiPermission;
			}

		} else if (applyStore.getAppId() == DpmConstants.manage) {
			// 项目管理工具 （对非合伙人开放、当应用对所有合伙人开放时开放、当合伙人有该权限时开放）
			forManage(role, result, isPartner, applyStore);
		} else if (applyStore.getAppId() == DpmConstants.rdvs) {
			// 智慧收派
			forRdvs(role, result, jobname, isPartner, applyStore);

		} else if (applyStore.getAppId() == DpmConstants.nwfs
				|| applyStore.getAppId() == DpmConstants.anps) {
			// 新工作流
			/*
			 * if (nwfsList.contains(userId) || nwfsList.contains(orgName)) {
			 * result.add(applyStore); }
			 */
			// 上线时需要修改
			// result.add(applyStore);
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		} else if (applyStore.getAppId() == DpmConstants.doc) {
			// 滴滴权限控制
			String deptSeq = appPermissionService.getDeptSeqByUserId(employee
					.getEmpCode());
			if (null != deptSeq) {
				if (!isPartner && deptSeq.indexOf(".466154.") == -1
						&& jobname.indexOf("快运销售专员") == -1 && jobname.indexOf("异地调货销售专员") == -1
						&& (!jobname.equals("快递员")) && (!jobname.equals("理货员")) && jobname.indexOf("整车项目客户专员") == -1
						&& (!jobname.equals("快递员组长"))) {
					result.add(applyStore);
				}
			}
			/*
			 * if (this.appPermission(employee, applyStore.getAppId())) { //组织序列
			 * String deptSeq =
			 * appPermissionService.getDeptSeqByUserId(employee.getEmpCode());
			 * //除去事业合伙人本部 呼叫中心客户服务组 if (deptSeq.indexOf(".477595.") != -1 ||
			 * deptSeq.indexOf(".307.") != -1) continue; String deptSeq =
			 * appPermissionService.getDeptSeqByUserId(employee.getEmpCode());
			 * 
			 * //不对合伙人开放 if (!isPartner){ result.add(applyStore); } }
			 */
		} else if (applyStore.getAppId() == DpmConstants.MDCS) {
			// 移动驾驶舱权限
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		}else if (applyStore.getAppId() == DpmConstants.vpp) {
			// 访客机权限
			
			if(employee.getJobLevel().equals("C")||employee.getJobLevel().equals("D")){
				result.add(applyStore);
			}else{
				Boolean flag=Integer.parseInt(employee.getJobLevel())>6;
				
				if(flag&&employee.getJobGroups().equals("管理族群")){
			    	result.add(applyStore);
			    }
			}
			
			
		} else if (applyStore.getAppId() == DpmConstants.WP) {
			// 智慧园区
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		}/*else if (applyStore.getAppId() == DpmConstants.zxks) {
			// 新在线考试
			if (!jobname.contains("快递员")&&!isPartner) {
				result.add(applyStore);
			}
		}*/else if (applyStore.getAppId() == DpmConstants.MCP) {
			// 全国打卡
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		} else if (applyStore.getAppId() == DpmConstants.ISDM) {
			// 智慧门店权限
			if (this.appPermission(employee, applyStore.getAppId())||(HAS_ISDM_JOBNAMES.contains(jobname) && !isPartner)) {
				result.add(applyStore);
			}
		}else if (applyStore.getAppId() == DpmConstants.IAD) {
			//String deptSeq = appPermissionService.getDeptSeqByUserId(employee.getEmpCode());
			//String orgId="."+employee.getOrgId()+".";
			// 内部带货权限
			if(!isPartner){
					if(this.appPermission(employee, applyStore.getAppId())){
						if(employee.getJobLevel().equals("C")||employee.getJobLevel().equals("D")){
							result.add(applyStore);
							
						}else{
							if((Integer.parseInt(employee.getJobLevel())>=6)
								||(employee.getJobGroups().equals("管理族群"))){
						    	result.add(applyStore);
						    }
							
						}
						
				    }else{
					       result.add(applyStore);
				    }
			
			}
		}else if (applyStore.getAppId() == DpmConstants.WP) {
			// 智慧园区权限
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		}else if (applyStore.getAppId() == DpmConstants.WFEO) {
			// 异常管理权限
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		} /*else if (applyStore.getAppId() == DpmConstants.bigdata_app) {
			// 中专魔镜权限
			if (bigDataAppPermissionService.hasBigDataAppPermission(userId)
					.equals("true")) {
				result.add(applyStore);
			}
		} */
		else if (applyStore.getAppId() == DpmConstants.record) {
			// 打卡权限  上海徐汇营业区下不开放
			OrganizationVO org = externalMethodService.getDeptByEmpcode(userId);
			if(null!=org){
				if(null!=org.getDeptSeq()){
					if (!(org.getDeptSeq().indexOf("503237") != -1)) {
						result.add(applyStore);
					}
				}
			}
		}else if (applyStore.getAppId() == DpmConstants.mr) {
			// 会议室权限  只开放265564
			if (this.appPermission(employee, applyStore.getAppId())) {
				result.add(applyStore);
			}
		}else if (!isPartner || partnerPermission) {
			// 其他的应用如果对合伙人开放，或者该用户不是合伙人，添加
			result.add(applyStore);
		}
		return "true";
	}

	private void forCrm(List<String> role, List<ApplyStore> result,
			String jobname, boolean isPartner, ApplyStore applyStore,
			boolean partnerPermission) {
		if ((role != null && role.contains(DpmConstants.crmPermissionRole))
				|| HAS_CRM_JOBNAMES.contains(jobname)
				|| jobname.endsWith("销售专员") || jobname.endsWith("总裁")
				|| jobname.endsWith("总裁助理") || (isPartner && partnerPermission)) {
			// 添加到应用商店中
			result.add(applyStore);
		}
	}

	private void forReReward(EmployeeEntity employee, List<String> role,
			List<ApplyStore> result, String userId, boolean isPartner,
			ApplyStore applyStore, boolean partnerPermission) {
		if ((role != null && role.contains(DpmConstants.reward))
				|| checkJobNameReward(userId, employee)
				|| (isPartner && partnerPermission)) {
			// 添加到应用商店中
			result.add(applyStore);
		}
	}

	private void forRdvs(List<String> role, List<ApplyStore> result,
			String jobname, boolean isPartner, ApplyStore applyStore) {
		if ((HAS_RDVS_JOBNAMES.contains(jobname) && !isPartner)
				|| (jobname.indexOf("快递员") != -1)
				|| (role != null && role.contains(DpmConstants.RDVSRole))) {
			result.add(applyStore);
		}
	}

	private void forManage(List<String> role, List<ApplyStore> result,
			boolean isPartner, ApplyStore applyStore) {
		if (!isPartner
				|| (role != null && role
						.contains(DpmConstants.managePermissionRole))
				|| applyStore.getPartnerPermission()) {
			// 添加到应用商店
			result.add(applyStore);
		}
	}

	/**
	 * 应用权限控制 true表示有权限 false表示没权限
	 * 
	 * @param employee
	 * @param appid
	 * @return
	 */
	private boolean appPermission(EmployeeEntity employee, int appid) {
		try {
			// 权限获取
			List<AppPermissionEntity> apps = appPermissionService
					.getAppPermission(appid);
			if (apps == null || apps.size() == 0) {
				// 所有人都有权限
				return true;
			} else {
				// 组织序列
				String deptSeq = appPermissionService
						.getDeptSeqByUserId(employee.getEmpCode());
				if (null == deptSeq) {
					return false;
				}
				for (AppPermissionEntity entity : apps) {
					String orgid = "." + String.valueOf(entity.getOrgid())
							+ ".";// 组织id
					String userid = entity.getUserid();// 工号
					String level = entity.getLevel();// 层级
					if (deptSeq.indexOf(orgid) != -1) {
						return true;
					}
					if (employee.getEmpCode().equals(userid)) {
						return true;
					}
					if (level != null) {
						if (level.indexOf(employee.getJobLevel()) != -1) {
							return true;
						}
					}
					/* System.out.println("000000"); */
				}
			}
			return false;
		} catch (Exception e) {
			logger.error("获取应用权限异常 工号：" + employee.getEmpCode() + "应用id:"
					+ String.valueOf(appid) + " 异常原因：" + e);
			return false;
		}

	}

	/**
	 * 判断是否是T工号 T工号默认没有应用权限
	 * 
	 * @param userId
	 * @return
	 */
	// private void checkUserT(List<ApplyStore> result, ApplyStore applyStore,
	// List<String> role, EmployeeEntity entity) {
	// // T工号权限 项目管理 看角色 德邦e站 看角色 BI 看角色
	// // 合伙人权限：工作流、日程、邮件、悬赏、发现、底下的首页、通讯录、资讯、我、场地预定
	// String userId = entity.getEmpCode();
	// String orgName = entity.getOrgName();
	// orgName = orgName == null ? "" : orgName;
	// // 是否为合伙人
	// boolean flag = false;
	// if(userId.toUpperCase().startsWith("T") || orgName.startsWith("【H】")
	// || orgName.startsWith("【D】") || orgName.startsWith("【J】")){
	// flag = true;
	// }
	//
	// // 项目管理工具对有权限的合伙人开放，或者该应用对合伙人开放
	// if (flag) {
	// if ((applyStore.getAppId() == DpmConstants.manage && role != null && role
	// .contains(DpmConstants.managePermissionRole))
	// || applyStore.getPartnerPermission()
	//
	// // || (applyStore.getAppId() == DpmConstants.email)
	// // || ((applyStore.getAppId() == DpmConstants.schedule)
	// // || (applyStore.getAppId() == DpmConstants.award)
	// // || (applyStore.getAppId() == DpmConstants.discovery)
	// // || (applyStore.getAppId() == DpmConstants.venue_booking)
	// // || (applyStore.getAppId() == DpmConstants.deppon_eStation)
	// // || (applyStore.getAppId() == DpmConstants.wrokflow)
	// // || (applyStore.getAppId() == DpmConstants.recruit))
	//
	// ) {
	// // 添加到应用商店
	// result.add(applyStore);
	// }
	// } else {
	// // 添加到应用商店
	// result.add(applyStore);
	// }
	//
	// /*
	// if (StringUtils.isNotEmpty(userId)
	// && userId.toUpperCase().startsWith("T")) {
	// if (applyStore.getAppId() == DpmConstants.manage) {
	// // T工号权限 项目管理
	// if (role != null
	// && role.contains(DpmConstants.managePermissionRole)) {
	// result.add(applyStore);
	// }
	// } else if (applyStore.getAppId() == DpmConstants.email) {
	// // 邮件开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.schedule) {
	// // 日程开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.award) {
	// // 悬赏开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.discovery) {
	// // 发现开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.venue_booking) {
	// // 场地预定开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.deppon_eStation) {
	// // 德邦e站（默认应用） 德邦e站权限 除T工号外，其他工号默认都有权限,T工号看权限
	// if (role != null
	// && role.contains(DpmConstants.eccPermissionRole)) {
	// result.add(applyStore);
	// }
	// } else if (applyStore.getAppId() == DpmConstants.wrokflow) {
	// // 工作流开放
	// result.add(applyStore);
	// } else if (applyStore.getAppId() == DpmConstants.recruit) {
	// // 招聘开放
	// result.add(applyStore);
	// }
	// } else {
	// // 添加应用
	// result.add(applyStore);
	// }
	// */
	//
	// }

	@Override
	public void download(String userId, int id) {
		// 下载
		iApplyStoreDao.download(userId, id);
	}

	@Override
	public void sort(String userId, String sortStr) {
		// 排序
		iApplyStoreDao.sort(userId, sortStr);
	}

	@Override
	public String getSort(String userId) {
		// 获取排序信息
		return iApplyStoreDao.getSort(userId);
	}

	/**
	 * 获取角色权限列表
	 * 
	 * @param userId
	 * @return
	 */
	// @SuppressWarnings("unused")
	// private List<String> getRole(String userId) {
	// // 获取结果集
	// String object = getUserInfo(userId);
	// // 结果集定义
	// List<String> roleCodes = getRoleInfo(object);
	// // 返回
	// return roleCodes;
	// }

	/**
	 * 获取角色权限列表
	 * 
	 * @param object
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	// private List<String> getRoleInfo(String object) {
	// // 结果集定义
	// List<String> roleCodes = new ArrayList<String>();
	// if (StringUtils.isNotEmpty(object)) {
	// // json-->list
	// roleCodes = (List<String>) JSON.parseObject(object)
	// .get("roleCodes");
	// }
	// // 返回
	// return roleCodes;
	// }

	/**
	 * 根据userId获取用户相关信息
	 * 
	 * @param userId
	 */
	// private String getUserInfo(String userId) {
	// // 请求url地址
	// String url = roleUrl + "?appID=DPM&userCode=" + userId;
	// // rest模板
	// RestTemplate restTemplate = new RestTemplate();
	// // 起始时间
	// long startTime = System.currentTimeMillis();
	// // 获取结果集
	// String object = restTemplate.getForObject(url, String.class);
	// // 结束时间
	// long endTime = System.currentTimeMillis();
	// // 日志
	// logger.info("调用uums获取角色信息用时>>>>>>" + (endTime - startTime));
	// // 返回
	// return object;
	// }

	/**
	 * 判断岗位是否是 快递员、快递员组长、派件员
	 * 
	 * @param object
	 */
	// private boolean checkJobName(String userId, EmployeeEntity employee) {
	// // 返回值
	// boolean check = false;
	// // 岗位
	// String jobName = "";
	// // 空判断
	// if (null != employee && StringUtils.isNotEmpty(employee.getJobName())) {
	// jobName = employee.getJobName();
	// }
	// // 岗位列表
	// List<String> jobNameList = new ArrayList<String>();
	// jobNameList.add("快递员");
	// jobNameList.add("快递员组长");
	// jobNameList.add("派件员");
	// // 判断是否包含
	// if (jobNameList.contains(jobName)) {
	// // 设值为true
	// check = true;
	// }
	// // 返回值
	// return check;
	// }

	/**
	 * 判断岗位是否是以下岗位 ①快递：快递员、快递员组长、派件员、包含销售专员、包含客户开发员关键字
	 * ②外场：理货员、运营外场组长、机叉司机、机叉司机组长、电叉司机、电叉司机组长 ③车队：班车司机、接送货司机、接送货员、接送货员组长、
	 * 提升奖金应用（如此类情况出现的多，通过增加表实现，不写死）
	 * 
	 * @param userId
	 */
	private boolean checkJobNameReward(String userId, EmployeeEntity employee) {
		// 返回值
		boolean check = false;
		// 岗位
		String jobName = "";
		// 空判断
		if (null != employee && StringUtils.isNotEmpty(employee.getJobName())) {
			jobName = employee.getJobName();
		}
		// 提升奖金岗位列表
		List<String> jobNameList = getJobNameList();
		// 判断是否包含
		for (String str : jobNameList) {
			if (jobName.indexOf(str) != -1) {
				// 设值为true
				check = true;
				break;
			}
		}
		// 返回值
		return check;
	}

	/**
	 * 根据岗位判断是否包含 提升奖金(15) ①快递：快递员、快递员组长、派件员、包含销售专员、包含客户开发员关键字
	 * ②外场：理货员、运营外场组长、机叉司机、机叉司机组长、电叉司机、电叉司机组长 ③车队：班车司机、接送货司机、接送货员、接送货员组长、
	 * 
	 * @return
	 */
	private List<String> getJobNameList() {
		// 岗位列表
		List<String> jobNameList = new ArrayList<String>();
		jobNameList.add("快递员");
		jobNameList.add("快递员组长");
		jobNameList.add("派件员");
		jobNameList.add("销售专员");
		jobNameList.add("客户开发员");
		jobNameList.add("理货员");
		jobNameList.add("运营外场组长");
		jobNameList.add("机叉司机");
		jobNameList.add("机叉司机组长");
		jobNameList.add("电叉司机");
		jobNameList.add("电叉司机组长");
		jobNameList.add("班车司机");
		jobNameList.add("接送货司机");
		jobNameList.add("接送货员");
		jobNameList.add("接送货员组长");
		jobNameList.add("大件收派员");
		// 返回值
		return jobNameList;
	}

	/**
	 * 获取应用商店列表
	 */
	@Override
	public List<ApplyStore> getApplyStoreList(int appId, int begin, int pageSize) {
		// 图片地址拼接
		List<ApplyStore> appList = iApplyStoreDao.getApplyStoreList(appId,
				begin, pageSize);
		if (null != appList) {
			String url = hostPort + appPicDir.replace("/dpmfile/", "") + "/";
			// 处理图片
			for (ApplyStore app : appList) {
				if (StringUtils.isNotBlank(app.getAppFile())) {
					String[] appFiles = app.getAppFile().split("@AS@P");
					for (int i = 0; i < appFiles.length; i++) {
						if (i == 0) {
							app.setAppFileUrl1(url + appFiles[i]);
						}
						if (i == 1) {
							app.setAppFileUrl2(url + appFiles[i]);
						}
						if (i == 2) {
							app.setAppFileUrl3(url + appFiles[i]);
						}
					}
				}
			}
		}
		return appList;
	}
	

	/**
	 * 获取应用商店列表总数
	 */
	public Long getApplyStoreCount() {
		return iApplyStoreDao.getApplyStoreCount();
	}

	/**
	 * 插入应用商店
	 */
	@Override
	// @Transactional("transactionManager")
	public int insertApplyStore(ApplyStore entity) {
		int result = 0;
		try {
			// 应用图片上传
			dealFile(entity);
			this.insertAutoRefreshControlInfo(entity);
			result = iApplyStoreDao.insertApplyStore(entity);
		} catch (Exception e) {
			logger.info("insertApplyStore:::" + e);
			result = -1;
		}
		return result;
	}

	private void insertAutoRefreshControlInfo(ApplyStore entity) {
		appAutoUpdateControlDao.deleteByAppId(entity.getAppId());
		List<AppAutoRefreshControlEntity> appAutoRefreshControlList = entity
				.getAppAutoRefreshControlList();
		if (appAutoRefreshControlList != null
				&& appAutoRefreshControlList.size() > 0) {
			for (AppAutoRefreshControlEntity appAutoRefreshControlEntity : appAutoRefreshControlList) {
				appAutoRefreshControlEntity.setAppId(entity.getAppId());
			}
			// 只有当开启了自动更新才插入更新控制信息
			if (entity.getAutoUpdate()) {
				appAutoUpdateControlDao.batchInsert(appAutoRefreshControlList);
			}
		}
	}

	/**
	 * 更新应用商店
	 */
	@Override
	// @Transactional("transactionManager")
	public int updateApplyStore(ApplyStore entity) {
		int result = 0;
		try {
			// 应用图片上传
			dealFile(entity);
			this.insertAutoRefreshControlInfo(entity);
			result = iApplyStoreDao.updateApplyStore(entity);
		} catch (IOException e) {
			logger.info("insertApplyStore:::" + e);
			result = -1;
		}
		return result;
	}

	/**
	 * 应用商店图片上传处理 多个附件以@AS@P分割 应用图片有显示顺序之分
	 * 
	 * @param entity
	 * @return
	 * @throws IOException
	 */
	private void dealFile(ApplyStore entity) throws IOException {
		// 附件类型判断
		checkAppFileType(entity);

		// file数组
		File[] files = new File[MagicNumber.NUM3];
		// string数组
		String[] fileNames = new String[MagicNumber.NUM3];
		// 需要删除的图片
		List<String> del = new ArrayList<String>();
		// 应用总上传图片
		StringBuilder appFiles = new StringBuilder();
		// 附件上传个数
		int i = 0;
		// 图片1判断赋值
		if (null != entity.getAppFile1()
				&& StringUtils.isNotBlank(entity.getAppFile1FileName())) {
			files[i] = entity.getAppFile1();
			// 处理附件名
			String fileName = getFileName(entity.getAppFile1FileName());
			fileNames[i] = fileName;
			if (null != dealAppFileUrl(entity.getAppFileUrl1())) {
				// 要删除的图片
				del.add(dealAppFileUrl(entity.getAppFileUrl1()));
			}
			// 保存图片名称
			appFiles.append(fileName);
			appFiles.append("@AS@P");
			i++;
		} else {
			if (null != dealAppFileUrl(entity.getAppFileUrl1())) {
				// 如无上传图片，则使用原图片
				appFiles.append(dealAppFileUrl(entity.getAppFileUrl1()));
				appFiles.append("@AS@P");
			}
		}
		// 图片2判断赋值
		if (null != entity.getAppFile2()
				&& StringUtils.isNotBlank(entity.getAppFile2FileName())) {
			files[i] = entity.getAppFile2();
			// 处理附件名
			String fileName = getFileName(entity.getAppFile2FileName());
			fileNames[i] = fileName;
			if (null != dealAppFileUrl(entity.getAppFileUrl2())) {
				// 要删除的图片
				del.add(dealAppFileUrl(entity.getAppFileUrl2()));
			}
			// 保存图片名称
			appFiles.append(fileName);
			appFiles.append("@AS@P");
			i++;
		} else {
			if (null != dealAppFileUrl(entity.getAppFileUrl2())) {
				// 如无上传图片，则使用原图片
				appFiles.append(dealAppFileUrl(entity.getAppFileUrl2()));
				appFiles.append("@AS@P");
			}
		}
		// 图片3判断赋值
		if (null != entity.getAppFile3()
				&& StringUtils.isNotBlank(entity.getAppFile3FileName())) {
			files[i] = entity.getAppFile3();
			// 处理附件名
			String fileName = getFileName(entity.getAppFile3FileName());
			fileNames[i] = fileName;
			if (null != dealAppFileUrl(entity.getAppFileUrl3())) {
				// 要删除的图片
				del.add(dealAppFileUrl(entity.getAppFileUrl3()));
			}
			// 保存图片名称
			appFiles.append(fileName);
			appFiles.append("@AS@P");
			i++;
		} else {
			if (null != dealAppFileUrl(entity.getAppFileUrl3())) {
				// 如无上传图片，则使用原图片
				appFiles.append(dealAppFileUrl(entity.getAppFileUrl3()));
				appFiles.append("@AS@P");
			}
		}
		// 图片上传路径
		String dir = appPicDir + "/";
		// 上传图片
		FileUploadUtil.uploadFiles(files, dir, fileNames);
		// 保存到数据库的附件名
		if (StringUtils.isNotBlank(appFiles.toString())) {
			entity.setAppFile(appFiles.toString().replaceAll("@AS@P$", ""));
		} else {
			entity.setAppFile("");
		}

		// 文件对象
		File file = null;
		// 遍历
		for (String fileName : del) {
			// 构建文件对象
			file = new File(dir + fileName);
			// 存在就删除
			if (file.exists()) {
				file.delete();
			}
		}
	}

	/**
	 * 判断附件类型，不是图片类型的附件清空
	 * 
	 * @param entity
	 */
	private void checkAppFileType(ApplyStore entity) {
		// 附件判断，前台只接收图片类型附件
		Pattern pattern = Pattern.compile(reg);
		if (StringUtils.isNotBlank(entity.getAppFile1FileName())) {
			Matcher matcher1 = pattern.matcher(entity.getAppFile1FileName());
			if (!matcher1.find()) {
				// 清空附件1
				entity.setAppFile1(null);
				entity.setAppFile1FileName(null);
			}
		}
		if (StringUtils.isNotBlank(entity.getAppFile2FileName())) {
			Matcher matcher2 = pattern.matcher(entity.getAppFile2FileName());
			if (!matcher2.find()) {
				// 清空附件2
				entity.setAppFile2(null);
				entity.setAppFile2FileName(null);
			}
		}
		if (StringUtils.isNotBlank(entity.getAppFile3FileName())) {
			Matcher matcher3 = pattern.matcher(entity.getAppFile3FileName());
			if (!matcher3.find()) {
				// 清空附件3
				entity.setAppFile3(null);
				entity.setAppFile3FileName(null);
			}
		}
	}

	/**
	 * 反向得到图片名，去除图片地址等信息
	 * 
	 * @param appFileUrl
	 * @return
	 */
	private String dealAppFileUrl(String appFileUrl) {
		// 返回值
		String result = null;
		// 文件上传地址
		String dir = appPicDir + "/";
		// 判断是否为空
		if (null != appFileUrl
				&& appFileUrl.length() > (appFileUrl.indexOf(dir) + dir
						.length())) {
			// 结果
			result = appFileUrl
					.substring(appFileUrl.indexOf(dir) + dir.length(),
							appFileUrl.length());
		}
		// 返回
		return result;
	}

	/**
	 * 获取附件名
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileName(String fileName) {
		StringBuilder sb = new StringBuilder();
		// 文件名用UUID防止重复
		sb.append(UUID.randomUUID().toString());
		// 拼接后缀名，如果存在的话
		if (fileName.indexOf(".") != -1) {
			// 拼接
			sb.append(fileName.substring(fileName.lastIndexOf(".")));
		}
		return sb.toString();
	}

	/**
	 * 删除应用商店
	 */
	@Override
	public int deleteApplyStore(ApplyStore entity) {
		// 删除应用更新控制条件信息
		appAutoUpdateControlDao.deleteByAppId(entity.getAppId());
		// 删除应用商店信息
		return iApplyStoreDao.deleteApplyStore(entity);
	}

	/**
	 * 切换应用下载平台
	 */
	@Override
	public void updateDLoadLine(int line) {
		iApplyStoreDao.updateDLoadLine(line);
	}

	/**
	 * 获取设备、应用版本号信息列表
	 */
	@Override
	public List<ApplyDevice> getApplyDeviceList(ApplyDevice entity) {
		// 根据设备号返回应用版本号信息
		List<ApplyDevice> deviceList = iApplyDeviceDao
				.getApplyDeviceList(entity);
		return deviceList;
	}

	/**
	 * 根据设备号与应用编号保存 设备应用版本号 增加版本控制newVersion
	 * 
	 * @param device
	 */
	@Override
	// @Transactional("transactionManager")
	public void saveApplyDeviceByAppId(ApplyDevice device, int newVersion) {
		// 判断此应用是否存在
		List<ApplyStore> appList = getApplyStoreList(device.getApplyStoreId(),
				0, 1);
		if (null != appList && appList.size() > 0) {
			// 应用实体对象
			ApplyStore app = appList.get(0);
			// 应用对象无版本号，无需保存设备应用版本号
			// 原生应用的，无需保存设备应用版本号
			// 03.03版本如不强制更新，则把老版本需要资源更新的应用单个剔除
			// if (StringUtils.isBlank(app.getVersionType()) || newVersion !=
			// Constants.NEWVERSION) {
			if (StringUtils.isBlank(app.getVersionType())) {
				return;
			}
			// 根据设备号返回应用版本号信息
			ApplyDevice deviceOld = null;
			List<ApplyDevice> deviceList = iApplyDeviceDao
					.getApplyDeviceList(device);
			if (null != deviceList && deviceList.size() > 0) {
				// 转换Map
				for (ApplyDevice applyDevice : deviceList) {
					if (device.getApplyStoreId() == applyDevice
							.getApplyStoreId()) {
						deviceOld = applyDevice;
					}
				}
			}
			// 判断此设备是否保存了该应用版本号
			if (null != deviceOld) {
				// 不为空 走更新
				deviceOld.setVersionType(app.getVersionType());
				// 更新
				iApplyDeviceDao.updateApplyDevice(deviceOld);
			} else {
				// 为空 走插入
				device.setVersionType(app.getVersionType());
				// 插入
				iApplyDeviceDao.insertApplyDevice(device);
			}
		}
	}

	/**
	 * 删除设备应用版本号
	 * 
	 */
	@Override
	public int deleteApplyDevice(ApplyDevice device) {
		return iApplyDeviceDao.deleteApplyDevice(device);
	}

	/**
	 * 获取应用商店详情信息
	 * 
	 * @param appId
	 * @return
	 */
	@Override
	public ApplyStore getApplyStoreById(int appId, String userId, int begin,
			int pageSize) {
		// 查询条件
		ApplyStoreAppraise entity = new ApplyStoreAppraise();
		entity.setAppId(appId);
		// 应用评论列表
		List<ApplyStoreAppraise> appraiseList = getApplyStoreAppraiseList(
				entity, begin, pageSize);
		// 判断此用户评论次数
		entity.setEmpcode(userId);
		// 应用评论列表
		List<ApplyStoreAppraise> userList = getApplyStoreAppraiseList(entity,
				begin, pageSize);
		// 应用详情信息
		ApplyStore app = iApplyStoreDao.getApplyStoreById(appId);
		// 条件判断
		if (app == null) {
			// 返回
			return app;
		}
		// 在应用详情信息中加入应用评论信息
		app.setAppraiseList(appraiseList);
		// 处理应用图片地址 以@AS@P分割符分割
		String appFile = app.getAppFile();
		// 返回值
		List<String> appFileList = new ArrayList<String>();
		StringBuilder filename;
		if (StringUtils.isNotBlank(appFile)) {
			// 分割
			String[] appFiles = appFile.split("@AS@P");
			// 循环
			for (String str : appFiles) {
				filename = new StringBuilder();
				if (StringUtils.isNotBlank(str)) {
					// 地址拼接
					filename.append(hostPort);
					filename.append(appPicDir.replace("/dpmfile/", ""));
					filename.append("/");
					filename.append(str);
				}
				appFileList.add(filename.toString());
			}
		}
		// 应用图片
		app.setAppFileList(appFileList);
		// 此用户评论次数
		app.setAppraiseNum(String.valueOf(userList == null ? 0 : userList
				.size()));
		// 返回
		return app;
	}

	/**
	 * 获取应用评论列表
	 */
	@Override
	public List<ApplyStoreAppraise> getApplyStoreAppraiseList(
			ApplyStoreAppraise entity, int begin, int pageSize) {
		return iApplyStoreDao
				.getApplyStoreAppraiseList(entity, begin, pageSize);
	}

	/**
	 * 插入应用评论信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertApplyStoreAppraise(ApplyStoreAppraise entity) {
		return iApplyStoreDao.insertApplyStoreAppraise(entity);
	}

	/**
	 * 屏蔽用户评论
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int updateApplyStoreAppraise(ApplyStoreAppraise entity) {
		return iApplyStoreDao.updateApplyStoreAppraise(entity);
	}

	/**
	 * 查询该应用是否有更新
	 */
	@Override
	public boolean queryHasUpdate(int appId, String deviceToken, String osType) {
		// 根据应用编号查询对应的应用信息
		ApplyStore applyStore = this.iApplyStoreDao.getApplyStoreById(appId);
		// 判断是否为h5应用
		if (null != applyStore && "1".equals(applyStore.getHasResources())) {
			// 封装参数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("appId", appId);
			params.put("deviceToken", deviceToken);
			params.put("osType", osType);
			// 查询指定设备上该应用的版本
			String installedVersion = this.iApplyDeviceDao
					.queryVersionByCondition(params);
			String newVersion = applyStore.getVersionType();
			// 判断安装的应用版本与应用最新的版本是否一致
			if (null != installedVersion && installedVersion.equals(newVersion)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public IApplyStoreDao getiApplyStoreDao() {
		return iApplyStoreDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRoleUrl() {
		return roleUrl;
	}

	/**
	 * set
	 * 
	 * @param roleUrl
	 */
	public void setRoleUrl(String roleUrl) {
		this.roleUrl = roleUrl;
	}

	/**
	 * set
	 * 
	 * @param iApplyStoreDao
	 */
	public void setiApplyStoreDao(IApplyStoreDao iApplyStoreDao) {
		this.iApplyStoreDao = iApplyStoreDao;
	}

	/**
	 * set
	 * 
	 * @param iApplyDeviceDao
	 */
	public void setiApplyDeviceDao(IApplyDeviceDao iApplyDeviceDao) {
		this.iApplyDeviceDao = iApplyDeviceDao;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppPicDir() {
		return appPicDir;
	}

	/**
	 * set
	 * 
	 * @param appPicDir
	 */
	public void setAppPicDir(String appPicDir) {
		this.appPicDir = appPicDir;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHostPort() {
		return hostPort;
	}

	/**
	 * set
	 * 
	 * @param hostPort
	 */
	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	/**
	 * setter
	 * 
	 * @param appAutoUpdateControlDao
	 */
	public void setAppAutoUpdateControlDao(
			IAppAutoUpdateControlDao appAutoUpdateControlDao) {
		this.appAutoUpdateControlDao = appAutoUpdateControlDao;
	}
	
	
	@Override
	public List<ApplyStore> listLimitTen() {
		// TODO Auto-generated method stub
		return iApplyStoreDao.listLimitTen();
	}

	/**
	 * set
	 * 
	 * @param biService
	 */
	public void setBiService(IBIPermissionService biService) {
		this.biService = biService;
	}

	public IAppDetailDao getAppDetailDao() {
		return appDetailDao;
	}

	public void setAppDetailDao(IAppDetailDao appDetailDao) {
		this.appDetailDao = appDetailDao;
	}

	public void setAppPermissionService(
			IAppPermissionService appPermissionService) {
		this.appPermissionService = appPermissionService;
	}

	public IBigDataAppPermissionService getBigDataAppPermissionService() {
		return bigDataAppPermissionService;
	}

	public void setBigDataAppPermissionService(
			IBigDataAppPermissionService bigDataAppPermissionService) {
		this.bigDataAppPermissionService = bigDataAppPermissionService;
	}

	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}



}
