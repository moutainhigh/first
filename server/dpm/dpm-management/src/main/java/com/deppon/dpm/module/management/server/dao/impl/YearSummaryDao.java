package com.deppon.dpm.module.management.server.dao.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IYearSummaryDao;
import com.deppon.dpm.module.management.shared.domain.YearSummaryEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 2017年度总结
 * @author 276344
 *
 */
public class YearSummaryDao extends iBatis3DaoImpl implements IYearSummaryDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.module.management.server.dao.impl.YearSummaryDao.";
	private String webUrl;
	
	
	@SuppressWarnings("unused")
	public YearSummaryEntity getYearSummary(String empCode){
		//查询个人数据
		@SuppressWarnings("unchecked")
		List<YearSummaryEntity> entitys = this.getSqlSession().selectList(NAMESPACE + "getYearSummary", empCode);
		
		YearSummaryEntity entity = null;
		if(entitys != null){
			for (int i = 0; i < entitys.size(); i++) { 
				entity = entitys.get(0);

				//入职时间
				if(entity.getHiredate() ==null){
					entity.setHiredate("");
				}
				//打卡时长
				if(entity.getPunchClockTime() == null){
					entity.setPunchClockTime(0.00);
				}
				//18年最早一次打卡时间
				if(entity.getFirstPunchClockDate() ==null){
					entity.setFirstPunchClockDate("无");
				}
				//18年最晚一次打卡时间
				if(entity.getLastPunchClockDate() ==null){
					entity.setLastPunchClockDate("无");
				}
				//18年访问次数最高的应用
				if (entity.getFirstApp() == null || entity.getFirstApp() == "0") {
					entity.setFirstApp("无");
					entity.setAppVisitedNum(0);
				}
				//18年欢行因公用车次数
				if((entity.getTaxiNumber() + "") == null){
					entity.setTaxiNumber(0);
					entity.setTaxiRanking(0);	
				}
				
				if(entity.getTaxiRankingPercent() != null){
					//String转百分比
					double taxiranking = Double.valueOf(entity.getTaxiRankingPercent().toString());
					DecimalFormat df = new DecimalFormat("0.00%");
					entity.setTaxiRankingPercent(df.format(taxiranking));
					System.out.println(entity.getTaxiRankingPercent());
				}
				
				if(entity.getWorkflowRanking() != null){
					//String转百分比
					double workflowranking = Double.valueOf(entity.getWorkflowRanking().toString());
					DecimalFormat df = new DecimalFormat("0.00%");
					entity.setWorkflowRanking(df.format(workflowranking));
					System.out.println(entity.getWorkflowRanking());
				}
				//数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
				StringBuffer sb = new StringBuffer();
				sb.append(webUrl + "/");
				sb.append("headPhoto/");
				String pic = entity.getPicPath();
				if (pic == null || pic.equals("")) {
					entity.setPicPath("");
				}else {
					entity.setPicPath(sb + pic);
				}
			}
		}
		return entity;
	}
	
	@Override
	public YearSummaryEntity getYearSummaryByEmpCode(String userId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<YearSummaryEntity> entitys = this.getSqlSession().selectList(NAMESPACE + "getSummaryByEmpcode", userId);
		YearSummaryEntity entity = null;
		for (int i = 0; i < entitys.size(); i++) { 
			entity = entitys.get(0);
			//访问高峰时间段
			if (entity.getVisitorTime() == null) 
				entity.setVisitorTime("2017您没有访问过移动办公");
			//访问前无的应用
			if (entity.getFirstApp() == null) {
				entity.setFirstApp("无");
				entity.setSecondApp("无");
				entity.setThirdApp("无");
				entity.setFouthApp("无");
				entity.setFifthApp("无");
				//最常访问的应用超过了0位同事
				entity.setPersonNum(0);
				entity.setTag("暂无");
				entity.setTagDescription("暂无");
				
			}else{
				Map<String, String> map = this.getTagForYear(entity.getFirstApp());
				entity.setTag(map.get("tag"));
				entity.setTagDescription(map.get("description"));
			}
			entity.setVisitorNum(entity.getLoginNum());
			//String comeCompanyTime = entity.getComeCompanyTime()+" 00:00:00.0";
			entity.setComeCompanyTime(entity.getComeCompanyTime()+" 00:00:00.0");
			//弥补前端计算 公式的错误
			double y = entity.getPersonNum();
			double x = (double)entity.getUserOrder();
			double c = y / (x + y);
			double personNumber = x/c - x;
			entity.setPersonNum((float)personNumber);
			
			// 数据库中获取的是保存的图片名，要把结果拼接成服务器图片路径地址
			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/");
			sb.append("headPhoto/");
			String pic = entity.getPicPath();
			if (pic == null || pic.equals("")) {
				entity.setPicPath("");
			}else {
				entity.setPicPath(sb + pic);
			}
			
		}
		return entity;
	}
	
	private Map<String, String> getTagForYear(String appName){
		//2017标签
		String tag = "";
		//2017标签描述
		String description = "";
		if ("日程、邮箱、工作流、新工作流、访客平台、项目管理工具、公文、劳动合同、通讯录".indexOf(appName) != -1) {
			tag = "办公达人";
			description = "感激你过去一年的付出，移动办公，陪你成长";
		}else if("德邦欢行、差旅助手".indexOf(appName) != -1) {
			tag = "行者";
			description = "每一段轨迹，都记录下，你曾经忙碌的身影";
		}else if("打卡、考勤、班车服务".indexOf(appName) != -1) {
			tag = "小蜜蜂";
			description = "早出晚归，我的每一天，都有你见证";
		}else if("人才选拔、招聘".indexOf(appName) != -1) {
			tag = "HR大大";
			description = "12万德邦人，每一个，都是你的学子";
		}else if("工程管理、物资反馈、固定资产".indexOf(appName) != -1) {
			tag = "部门管家";
			description = "部门的资产，离不开你的呵护";
		}else if("场地预订".indexOf(appName) != -1) {
			tag = "羽毛球健将";
			description = "爱运动，爱生活，爱自己";
		}else if("移动BI、差错、奖金、我的工资、智慧收派、收派助手、TPS".indexOf(appName) != -1) {
			tag = "数据达人";
			description = "踏实肯干创造业绩，洞察数据助力业绩";
		}else if("移动CRM".indexOf(appName) != -1) {
			tag = "销售达人";
			description = "客户是你的好友，你是我的好友";
		}else if("德邦e站、发现".indexOf(appName) != -1) {
			tag = "社交达人";
			description = "哪里有社交，哪里就有你";
		}else if("刊物、知识库、微课堂、营运安全".indexOf(appName) != -1) {
			tag = "学霸";
			description = "学习，永无止境";
		}else {
			tag = "相遇待相知";
			description = "2017，移动办公与您相遇 2018，期待与您相识相知";
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("tag", tag);
		result.put("description", description);
		return result;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	@Override
	public EmployeeVO getLeaveByEmpCode(String userId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		EmployeeVO entity = (EmployeeVO) this.getSqlSession().selectOne(NAMESPACE + "getLeaveByEmpcode", userId);
		
		long leaveTime= entity.getLeaveDate().getTime()-entity.getInDate().getTime();		
	    entity.setLeaveTime((int) (leaveTime/1000));
		return entity;
	}

}
