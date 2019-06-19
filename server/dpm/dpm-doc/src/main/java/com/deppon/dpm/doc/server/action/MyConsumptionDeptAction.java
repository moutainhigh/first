package com.deppon.dpm.doc.server.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IMyConsumptionDeptService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;

/**
 * @Desciption:TODO(我的消费接口)
 * @className:MyConsumptionDeptAction
 * @author: lvdf
 * @date:2018年3月19日09:03:26
 */
public class MyConsumptionDeptAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1162924001096039962L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(MyConsumptionDeptAction.class);
	/**
	 * 注入service
	 */
	private IMyConsumptionDeptService myConsumptionDeptService;
	
	/**
	 * 注入dpm提供的接口
	 */
	private IExternalMethodService eExternalMethodService;
	
	//员工号
	private String userId;
	
	//年
	private String year;
	
	//月
	private String month;
	
	@SuppressWarnings("all")
	@CookieNotCheckedRequired
	public void myConsumptionDept(){
 		JSONObject jonum = new JSONObject();
		if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(year) && StringUtils.isNotEmpty(month)){
			if(Integer.parseInt(month)>=1 && Integer.parseInt(month)<=12 ){
				List<MyConsumptionRequestEntity> ListDeptByLeader = eExternalMethodService.getDeptInfo(userId);
				if(ListDeptByLeader==null&&ListDeptByLeader.size()<1){
					jonum.put("msg", "该员工不存在"); 
					writeToPage(jonum);
				}else{
					//根据调用移动BI的接口判断是否为领导
					String order = ListDeptByLeader.get(0).getOrder(); //List的第一位是领导信息
					if("2".equals(order)){//只负责一个部门的领导,2的时候表示小领导
						String deptName = ListDeptByLeader.get(0).getDeptName(); 
						List<String> deptNameList = new ArrayList<String>();
						deptNameList.add(deptName);//放入deptNameList该领导管理的部门名称
						logger.info("根据单个部门查询部门消费开始------------------------------------------------------");
						//根据年和月,拼接传入的日期参数
						String startDate=year+"-"+month+"-"+"01"+" "+"00:00:00"; //当月起始日期
						String endDate=year+"-"+month+"-"+"31"+" "+"23:59:59"; //当月终止日期
						logger.info("根据部门查询它的当月累计金额开始---------------------------------------------------");
						//根据部门查询它的当月累计金额
						String totalPriceMonthByDept=myConsumptionDeptService.queryTotalProcieByDept(deptNameList,startDate,endDate);
						if(totalPriceMonthByDept!=null){
							jonum.put("totalPriceMonthByDept",Intercept(totalPriceMonthByDept));//装入月累计金额(根据部门)
						}else{
							jonum.put("totalPriceMonthByDept","0");//没有订单设置为0
						}
						logger.info("根据部门查询它的月累计公里开始----------------------------------------------------");
						//根据部门查询它的月累计公里
						String normalDistanceMonthByDept=myConsumptionDeptService.querynormalDistance(deptNameList,startDate,endDate);
						if(normalDistanceMonthByDept!=null){
							jonum.put("normalDistanceMonthByDept",Intercept(normalDistanceMonthByDept));//装入月累计总公里数(根据部门)
						}else{
							jonum.put("normalDistanceMonthByDept","0"); //没有月累计公里数设置为0
						}
						logger.info("根据部门查询它的月累计订单数开始----------------------------------------------------");
						//根据部门查询它的月累计订单数
						String CountMonthByDept=myConsumptionDeptService.queryCountMonthByDept(deptNameList,startDate,endDate);
						if(CountMonthByDept!=null){
							jonum.put("CountMonthByDept", CountMonthByDept);//装入月累计订单数(根据部门)
						}else{
							jonum.put("CountMonthByDept", "0");//没有月累计订单设置为0
						}
						/*logger.info("查询页面最顶端的用车数据(每日用车总金额和人均金额)-------------");
						//查询页面最顶端的用车数据(每日用车总金额和人均金额)
						Map<String, Object> mapList = queryUseTaxiDataByDay(jonum, deptNameList, startDate, endDate);
						jonum.put("mapList",mapList);*/
						/*logger.info("根据部门查询部门明细开始----------------------------------------------------");
						//根据部门查询部门明细
						List<DidiOrderEntity> list=myConsumptionDeptService.queryDeptDetail(deptNameList,startDate,endDate);
						if(list!=null){
							for (int i = 0; i < list.size(); i++) {//遍历list处理下总金额,让它保留俩位小数
								list.get(i).setBillno(Intercept(list.get(i).getBillno()));
							}
							jonum.put("deptDetail", list);
						}else{
							List listEmpty=new ArrayList<DidiOrderEntity>();
							jonum.put("deptDetail", listEmpty);//如果没有任何明细,返回一个空的list
						}*/
						
						/*logger.info("根据部门查询部门概况开始----------------------------------------------------");
						//根据部门查询部门概况
						List<Map<String, Object>> listSurvey = queryDeptSurvey(jonum,deptNameList, startDate, endDate);
						//总金额小数点后保留俩位
						String totalPriceMonthByDept0 = (String) listSurvey.get(0).get("totalPriceMonthByDept");
						listSurvey.get(0).put("totalPriceMonthByDept", Intercept(totalPriceMonthByDept0));
						//设置一个部门时候他所占的百分比,直接写死100%
						listSurvey.get(0).put("Percentage", "100%");
						//一个部门的时候deptNameList只有一个值
						listSurvey.get(0).put("deptName", deptNameList.get(0));
						listSurvey.get(0).put("pictPath", ListDeptByLeader.get(0).getPictPath()==null?"":ListDeptByLeader.get(0).getPictPath());
						jonum.put("listSurvey",listSurvey);//返回部门概况*/		
						
						/*logger.info("根据部门查询部门打车分布开始----------------------------------------------------");
						//根据部门查询部门打车分布
						DidiOrderEntity distributionMonthByDept=myConsumptionDeptService.queryDistributionMonthByDept(deptNameList,startDate,endDate);
						//调用月累计订单分布情况整理数据格式的方法
						Map[] otherArrays = encapsulationDistribution(distributionMonthByDept);
						jonum.put("otherArrays", otherArrays);//装入月累计订单分布情况(根据部门)*/						
						logger.info("把员工权限情况给前台开始---------------------------------------------------------");
						jonum.put("Jurisdiction", 1); //权限,0表示普通员工,1表示小领导,2表示大领导
						jonum.put("msg", "success");//成功返回
						//最后统一返回页面
						writeToPage(jonum);
					}else if("1".equals(order)){//如果为高级领导则有多个部门,1的时候为大领导
						//根据年和月,拼接传入的日期参数
						String startDate=year+"-"+month+"-"+"01"+" "+"00:00:00"; //当月起始日期
						String endDate=year+"-"+month+"-"+"31"+" "+"23:59:59"; //当月终止日期
						logger.info("拿到该大部门下所有子部门,及子部门下属全部部门的list开始---------------------------------------");
						//先写死一个部门名称list，
						ArrayList<String> deptNameList = new ArrayList<String>();
						deptNameList.add(ListDeptByLeader.get(0).getDeptName()); //先把大部门放入
						//把该领导所管理的子部门放入deptNameList
						for (int i = 0; i < ListDeptByLeader.size(); i++) { //这里不判空的原因是,既然判断是大部门领导了,那么他下属一定有子部门
							if("2".equals(ListDeptByLeader.get(i).getOrder())){
								Map<String, String> mapChild = ListDeptByLeader.get(i).getAllchilddep();
								if(mapChild != null){
									for (String v : mapChild.values()) { //遍历所有子部门的map放入deptNameList
										deptNameList.add(v);
									}
								}
							}	
						}
						logger.info("多个部门月累计金额查询开始-------------");
						//遍历这个deptNameList,计算所有部门的月累计金额
						String totalPriceMonthByDept = myConsumptionDeptService.queryTotalProcieByDept(deptNameList,startDate,endDate);//根据部门名称查询月累计金额	
						if(totalPriceMonthByDept!=null){
							jonum.put("totalPriceMonthByDept", Intercept(String.valueOf(totalPriceMonthByDept))); //放入时候小数点保留俩位
						}else{
							jonum.put("totalPriceMonthByDept", "0"); //放入时候小数点保留俩位
						}					
						logger.info("多个部门月累计公里数查询开始---------------------------------------------------------------");
						//计算所有部门的月累计公里数
						String normalDistanceMonthByDept = myConsumptionDeptService.querynormalDistance(deptNameList, startDate, endDate);
						if(normalDistanceMonthByDept!=null){
							jonum.put("normalDistanceMonthByDept", Intercept(String.valueOf(normalDistanceMonthByDept))); //放入时候小数点保留俩位
						}else{
							jonum.put("normalDistanceMonthByDept", "0"); //放入时候小数点保留俩位
						}					
						logger.info("多个部门月累计订单数查询开始---------------------------------------------------------------");
						//遍历这个deptNameList,计算所有部门的月累计订单数
						String CountMonthByDept = myConsumptionDeptService.queryCountMonthByDept(deptNameList,startDate,endDate);
						if(CountMonthByDept!=null){
							jonum.put("CountMonthByDept", String.valueOf(CountMonthByDept)); 
						}else{
							jonum.put("CountMonthByDept", "0"); 
						}
						/*logger.info("多个部门打车分布查询开始-----------------------------------------------------------------");
						//遍历这个deptNameList,计算所有部门的打车分布
						int waiChuGongWuCount=0;
						int jiaBanCount=0;
						int gongKuanCunHuCount=0;
						int baiFangKeHuCount=0;
						int canJiaHuiYiCount=0;
						int kuaQuBanGongCount=0;
						int banGongQuWangFanCount=0;
						int qiTaCount=0;
						int qiTaGongWuCount=0;
						//根据多个部门查询打车分部
						DidiOrderEntity distributionMonthByDept = myConsumptionDeptService.queryDistributionMonthByDept(deptNameList, startDate, endDate);
						if(distributionMonthByDept!=null){
							String waiChuGongWu = distributionMonthByDept.getBillno()==null?"0":distributionMonthByDept.getBillno(); //公务外出
							String jiaBan = distributionMonthByDept.getOfftime()==null?"0":distributionMonthByDept.getOfftime();//加班
							String gongKuanCunHu = distributionMonthByDept.getEmployeeno()==null?"0":distributionMonthByDept.getEmployeeno();//公款存户
							String baiFangKeHu = distributionMonthByDept.getModels()==null?"0":distributionMonthByDept.getModels();//拜访客户
							String canJiaHuiYi = distributionMonthByDept.getFromName()==null?"0":distributionMonthByDept.getFromName();//参加会议
							String kuaQuBanGong = distributionMonthByDept.getTaxidate()==null?"0":distributionMonthByDept.getTaxidate();//跨区办公
							String bangGongQuWangFan = distributionMonthByDept.getBudgetratio()==null?"0":distributionMonthByDept.getBudgetratio();//办公区往返
							String qiTa=distributionMonthByDept.getTimeschedule()==null?"0":distributionMonthByDept.getTimeschedule();//其他
							String qiTaGongWu =distributionMonthByDept.getTomanagername()==null?"0":distributionMonthByDept.getTomanagername();//其他公务
							waiChuGongWuCount=waiChuGongWuCount+Integer.parseInt(waiChuGongWu);//每个部门的公务外出相加,重新赋值
							jiaBanCount=jiaBanCount+Integer.parseInt(jiaBan);//每个部门的加班相加,重新赋值
							gongKuanCunHuCount=gongKuanCunHuCount+Integer.parseInt(gongKuanCunHu);//每个部门的公款存户相加,重新赋值
							baiFangKeHuCount=baiFangKeHuCount+Integer.parseInt(baiFangKeHu);//每个部门的拜访客户相加,重新赋值
							canJiaHuiYiCount=canJiaHuiYiCount+Integer.parseInt(canJiaHuiYi);//每个部门的参加会议相加,重新赋值
							kuaQuBanGongCount=kuaQuBanGongCount+Integer.parseInt(kuaQuBanGong);//每个部门的跨区办公相加,重新赋值
							banGongQuWangFanCount=banGongQuWangFanCount+Integer.parseInt(bangGongQuWangFan);//每个部门的办公区往返相加,重新赋值
							qiTaCount=qiTaCount+Integer.parseInt(qiTa);//每个部门的其他相加,重新赋值
							qiTaGongWuCount=qiTaGongWuCount+Integer.parseInt(qiTaGongWu);//每个部门的其他公务相加,重新赋值
						}else{
							waiChuGongWuCount=0;
							jiaBanCount=0;
							gongKuanCunHuCount=0;
							baiFangKeHuCount=0;
							canJiaHuiYiCount=0;
							kuaQuBanGongCount=0;
							banGongQuWangFanCount=0;
							qiTaCount=0;
							qiTaGongWuCount=0;
						}
						//用实体封装起来(这里用didiorderEntity封装)
						DidiOrderEntity didiOrderEntity = new DidiOrderEntity();
						didiOrderEntity.setBillno(String.valueOf(waiChuGongWuCount));//设置公务
						didiOrderEntity.setOfftime(String.valueOf(jiaBanCount));//设置加班
						didiOrderEntity.setEmployeeno(String.valueOf(gongKuanCunHuCount));//设置公款存户
						didiOrderEntity.setModels(String.valueOf(baiFangKeHuCount));//设置拜访客户
						didiOrderEntity.setFromName(String.valueOf(canJiaHuiYiCount));//设置参加会议
						didiOrderEntity.setTaxidate(String.valueOf(kuaQuBanGongCount));//设置跨区办公
						didiOrderEntity.setBudgetratio(String.valueOf(banGongQuWangFanCount));//设置办公区往返
						didiOrderEntity.setTimeschedule((String.valueOf(qiTaCount)));//设置其他
						didiOrderEntity.setTomanagername(String.valueOf(qiTaGongWuCount));//设置其他公务
						//把打车分布情况整理
						Map[] otherArrays = encapsulationDistribution(didiOrderEntity);
						jonum.put("otherArrays", otherArrays);//装入月累计订单分布情况(根据部门);
						logger.info("多个部门的部门明细查询开始---------------------------------------------------------------");
						//调用查询计算所有部门的部门明细,拿到前5个的方法
						List<DidiOrderEntity> listDetail=myConsumptionDeptService.queryDeptDetail(deptNameList, startDate, endDate);
						if(listDetail!=null){
							for (int i = 0; i < listDetail.size(); i++) {//遍历list处理下总金额,让它保留俩位小数
								listDetail.get(i).setBillno(Intercept(listDetail.get(i).getBillno()));
							}
							jonum.put("deptDetail", listDetail);
						}else{
							List listDetailEmpty=new ArrayList(); 
							jonum.put("deptDetail", listDetailEmpty);//没有查询到的时候,直接给个空的list
						}	
						logger.info("多个部门的概况查询开始-----------------------------------------------------------------");
						//部门概况查询开始
						HashMap<String, Object> mapSummary = new HashMap<String,Object>();//新建汇总的map
						mapSummary.put("deptName", ListDeptByLeader.get(0).getDeptName());//汇总大部门的名称
						mapSummary.put("leaderName", ListDeptByLeader.get(0).getEmpName());//大部门的负责人姓名
						mapSummary.put("pictPath", ListDeptByLeader.get(0).getPictPath()==null?"":ListDeptByLeader.get(0).getPictPath());//汇总大部门负责人的头像
						mapSummary.put("isDept", "Y");//判断是否为部门卡片
						//声明一个汇总的金额
						Double summaryPrice=0.0;
						//然后查询个人的时候需要通过本人ID进行查询
						List<Map<String,Object>> IndependentPersonList = new ArrayList<Map<String,Object>>();
						for (int i = 0; i < ListDeptByLeader.size(); i++) { //循环ListDeptByLeader拿到order为null的独立个人和该部门的领导
							if(ListDeptByLeader.get(i).getOrder()==null || "1".equals(ListDeptByLeader.get(i).getOrder())){
								Map<String, Object> mapPersonSurvey = new HashMap<String,Object>();
								//根据这个独立员工的工号查询他的月累计订单总金额
								String TotalPirceByEmpno = myConsumptionDeptService.queryTotalPirceByEmpno(ListDeptByLeader.get(i).getEmpNo(),startDate,endDate);
								if(TotalPirceByEmpno!=null){
									//不为Null把个人钱数放入
									mapPersonSurvey.put("totalPriceMonthByDept", TotalPirceByEmpno);
									//放入人均钱数
									mapPersonSurvey.put("moneyByPerson", TotalPirceByEmpno);
									//放入人数
									mapPersonSurvey.put("personNumber", "1");
									//放入部门名称(直接放入直属领导的大部门名称)
									mapPersonSurvey.put("deptName", ListDeptByLeader.get(0).getDeptName());
									//放入员工姓名
									mapPersonSurvey.put("leaderName", ListDeptByLeader.get(i).getEmpName());
									//放入该员工的图片
									mapPersonSurvey.put("pictPath", ListDeptByLeader.get(i).getPictPath()==null?"":ListDeptByLeader.get(i).getPictPath());
									//最后把金额加入到汇总的金额当中
									summaryPrice+=Double.parseDouble(TotalPirceByEmpno);//把个人金额加入到汇总金额
									//判断是否为个人卡片
									mapPersonSurvey.put("isDept", "N");
								}else{
									//null的时候放入0
									mapPersonSurvey.put("totalPriceMonthByDept", "0");
									//放入人均钱数
									mapPersonSurvey.put("moneyByPerson", "0");
									//放入人数
									mapPersonSurvey.put("personNumber", "1");
									//放入部门名称(直接放入直属领导的大部门名称)
									mapPersonSurvey.put("deptName", ListDeptByLeader.get(0).getDeptName());
									//放入员工姓名
									mapPersonSurvey.put("leaderName", ListDeptByLeader.get(i).getEmpName());
									//放入该员工的图片
									mapPersonSurvey.put("pictPath", ListDeptByLeader.get(i).getPictPath()==null?"":ListDeptByLeader.get(i).getPictPath());
									//最后把金额加入到汇总的金额当中
									summaryPrice+=0;//把个人金额加入到汇总金额
									//判断是否为个人卡片
									mapPersonSurvey.put("isDept", "N");
								}
								IndependentPersonList.add(mapPersonSurvey);
							}
						}
						//查询子部门的卡片列表的时候,需要先通过接口拿到每个子部门的下属部门集合,再通过集合调用查询概况的方法
						for(int i=0; i< ListDeptByLeader.size(); i++){
							if("2".equals(ListDeptByLeader.get(i).getOrder())){
								ArrayList<String> listChildDept = new ArrayList<String>();//子部门 全部名称
								HashMap<String, Object> mapDeptSurvey = new HashMap<String,Object>();
								Map<String, String> mapChild = ListDeptByLeader.get(i).getAllchilddep();
								for (String v : mapChild.values()) { //遍历所有子部门的map放入deptNameList
									listChildDept.add(v);
								}
								//根据多个部门查询这个部门的总金额
								String priceToalByDept = myConsumptionDeptService.queryTotalProcieByDept(listChildDept,startDate,endDate);
								if(priceToalByDept==null){
									//总金额为null时候把他变成"0"
									priceToalByDept="0";
								}
								//根据子部门名称查询该子部门的人数
								int deptPersonNum = eExternalMethodService.getOrgEmpNum(ListDeptByLeader.get(i).getDeptName());
								if(deptPersonNum==0){
									mapDeptSurvey.put("totalPriceMonthByDept", "0");//总金额
									mapDeptSurvey.put("personNumber", "0"); //部门人数
									mapDeptSurvey.put("leaderName", ListDeptByLeader.get(i).getLeaderName());//部门领导姓名
									mapDeptSurvey.put("moneyByPerson", "0");//人均钱数
									mapDeptSurvey.put("deptName", ListDeptByLeader.get(i).getDeptName());//部门名称
									mapDeptSurvey.put("pictPath", ListDeptByLeader.get(i).getPictPath()==null?"":ListDeptByLeader.get(i).getPictPath());//部门负责人头像
									mapDeptSurvey.put("isDept", "Y");//判断是否为部门卡片
									//最后把金额加入到汇总的金额当中
									summaryPrice+=Double.parseDouble(priceToalByDept);
								}else{
									mapDeptSurvey.put("totalPriceMonthByDept", Intercept(priceToalByDept));//总金额
									mapDeptSurvey.put("personNumber", String.valueOf(deptPersonNum));//部门人数
									mapDeptSurvey.put("leaderName", ListDeptByLeader.get(i).getLeaderName());//部门领导姓名
									mapDeptSurvey.put("moneyByPerson", Intercept(String.valueOf(Double.parseDouble(priceToalByDept)/deptPersonNum)));//人均钱数
									mapDeptSurvey.put("deptName", ListDeptByLeader.get(i).getDeptName());//部门名称
									mapDeptSurvey.put("pictPath", ListDeptByLeader.get(i).getPictPath()==null?"":ListDeptByLeader.get(i).getPictPath());//部门负责人头像
									mapDeptSurvey.put("isDept", "Y");//判断是否为部门卡片
									//最后把金额加入到汇总的金额当中
									summaryPrice+=Double.parseDouble(priceToalByDept);
								}
								IndependentPersonList.add(mapDeptSurvey);
							}	
						}
						//设置汇总部门的总钱数
						mapSummary.put("totalPriceMonthByDept", Intercept(String.valueOf(summaryPrice)));
						//查询这个大部门的人数
						int summaryNumber = eExternalMethodService.getOrgEmpNum(ListDeptByLeader.get(0).getDeptName());
						mapSummary.put("personNumber", String.valueOf(summaryNumber));//汇总大部门的人数
						//设置总部门的平均钱数
						if(summaryNumber==0){
							mapSummary.put("moneyByPerson", "0"); //大部门总钱数为0,直接设置部门钱数为0
						}else{
							mapSummary.put("moneyByPerson", Intercept(String.valueOf(summaryPrice/summaryNumber))); //直接计算他的平均钱数
						}
						IndependentPersonList.add(mapSummary);//将汇总map放入list
						//设置百分比
						for (int i = 0; i < IndependentPersonList.size(); i++) {
							if(ListDeptByLeader.get(0).getDeptName().equals(IndependentPersonList.get(i).get("deptName")) && ListDeptByLeader.get(0).getEmpName().equals(IndependentPersonList.get(i).get("leaderName")) && "Y".equals(IndependentPersonList.get(i).get("isDept"))){
								//大领导所负责的汇总部门直接设置为100%
								IndependentPersonList.get(i).put("Percentage", "100%");
							}else{
								//其他部门所占的百分比,通过钱数计算,总金额/汇总金额(小数点后保留俩位)
								if("0".equals(mapSummary.get("totalPriceMonthByDept")) || "0.0".equals(mapSummary.get("totalPriceMonthByDept"))){
									//如果该大部门的总金额为0,0不能当做分母,把每个子部门和人的百分比设置为0%就可以
									IndependentPersonList.get(i).put("Percentage", "0%");
								}else{
									Double PercentageDouble = Double.parseDouble((String) IndependentPersonList.get(i).get("totalPriceMonthByDept"))/Double.parseDouble((String) mapSummary.get("totalPriceMonthByDept"));
									//将小数转化为百分比的形式
									String PercentageString = String.valueOf(Double.parseDouble(Intercept(String.valueOf(PercentageDouble)))*100)+"%";
									IndependentPersonList.get(i).put("Percentage", PercentageString);
								}
							}
						}
						
						//调用排序的方法
						List<Object> listSurvey = sortDeptProfileList(IndependentPersonList,ListDeptByLeader);
						//部门概况放入JsonObject
						jonum.put("listSurvey", listSurvey);*/
						logger.info("多个部门用车数据(每日金额,日均金额查询)开始----------------------------------------------------");
						//部门不为空
						Map<String, Object>  map = queryUseTaxiDataByDay(jonum, deptNameList, startDate, endDate);
						//新建一个map便于一起返回
						Map<String, Object> mapList = new HashMap<String, Object>();
						mapList.put("totalPriceArray", map.get("totalPriceArray"));
						mapList.put("avgTotalPirceDept", map.get("avgTotalPirceDept"));
						mapList.put("dateArray", map.get("dateArray"));
						jonum.put("mapList",mapList);//每日所有部门的汇总金额装入Json
						logger.info("把员工权限情况给前台开始-------------");
						jonum.put("Jurisdiction", 2); //权限,0表示普通员工,1表示小领导,2表示大领导
						jonum.put("msg", "success");//成功返回
						//把所有的值,一块返回给前台页面
						writeToPage(jonum);
					}else{
						jonum.put("msg", "该员工为普通员工");
						writeToPage(jonum);
					}
				}
			}else{
				jonum.put("msg", "传入月份有误");
				writeToPage(jonum);
			}
		}else{
			jonum.put("msg", "员工号,年,月不能为空");
			writeToPage(jonum);
		}
			
	}

	/**
	 * 查询部门概况(计算每个部门的月累计总额，平均钱数,和人数)
	 * @param jonum
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 */
	private List<Map<String,Object>> queryDeptSurvey(JSONObject jonum,List<String> deptNameList,String startDate, String endDate) {
		logger.info("根据部门查询部门概况-------------");
		List<Map<String,Object>> listSurvey=new ArrayList<Map<String,Object>>(); //生命listSurvey用于返回
		HashMap<String, Object> mapSurvey = new HashMap<String,Object>();//生命map用于装入数据
		//先查询所有部门总钱数
		String totalPriceMonthByDept=myConsumptionDeptService.queryTotalProcieByDept(deptNameList,startDate,endDate);
		//调用DPM接口根据领导工号查询所有部门人数
		int deptInt =eExternalMethodService.getOrgEmpNum(deptNameList.get(0)); //调用接口查询人数累计到一起
		//计算部门总钱数和人均钱数
		if(totalPriceMonthByDept==null || "".endsWith(totalPriceMonthByDept)){
			mapSurvey.put("totalPriceMonthByDept","0");//部门总钱数
			mapSurvey.put("moneyByPerson", "0");//人均
		}else{
			mapSurvey.put("totalPriceMonthByDept", totalPriceMonthByDept);//部门总钱数
			if(deptInt==0){
				//大部门下一个人都没有,则返回平均钱数为0
				mapSurvey.put("moneyByPerson", "0");//人均
			}else{
				double moneyByPerson = Double.parseDouble(Intercept(totalPriceMonthByDept))/deptInt;
				mapSurvey.put("moneyByPerson", Intercept(String.valueOf(moneyByPerson)));//人均
			}		
		}
		//放入部门的人数
		mapSurvey.put("personNumber", String.valueOf(deptInt));
		//装入listSurvey
		listSurvey.add(mapSurvey);
		logger.info("根据部门查询部门概况结束-------------");
		return listSurvey;
	}

	/**
	 * 查询页面最顶端的用车数据(每日用车总金额和人均金额)
	 * @param jonum
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @throws NumberFormatException
	 * @return Map<String, Object>
	 */
	public Map<String, Object>  queryUseTaxiDataByDay(JSONObject jonum, List<String> deptNameList,
			String startDate, String endDate) throws NumberFormatException {
		logger.info("查询页面最顶端的用车数据(每日用车总金额和人均金额)开始-------------");
		Map<String, Object> mapList = new HashMap<String,Object>();
		if(yearOfJudgment(Integer.parseInt(year))){//调用判断是平年还是闰年的方法,平年为true,闰年为false
			//调用当前月份是大小月的方法
			 String monthOfStrong = monthOfStrong(Integer.parseInt(month));
			 if("February".equals(monthOfStrong)){//如果为平年二月,根据部门查询每日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,28);
				 mapList= mapListOld;
			 }else if("bigMonth".equals(monthOfStrong)){//如果为大月份,根据部门查询每日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,31);
				 mapList= mapListOld;
			 }else if("smallMonth".equals(monthOfStrong)){//如果为小月份,根据部门查询没日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,30);
				 mapList= mapListOld;
			 }
		}else{
			//调用当前月份是大小月的方法
			 String monthOfStrong = monthOfStrong(Integer.parseInt(month));
			 if("February".equals(monthOfStrong)){//如果为平年二月,根据部门查询没日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,29);
				 mapList= mapListOld;
			 }else if("bigMonth".equals(monthOfStrong)){//如果为大月份,根据根据部门查询没日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,31);
				 mapList= mapListOld;
			 }else if("smallMonth".equals(monthOfStrong)){//如果为小月份,根据根据部门查询没日总金额
				 Map<String, Object> mapListOld = queryUseTaxiData(jonum, deptNameList, startDate, endDate,30);
				 mapList= mapListOld;
			 }
		}
		logger.info("查询页面最顶端的用车数据(每日用车总金额和人均金额)结束-------------");
		 return mapList;
	}

	/**
	 * 根据部门名称查询每日总金额
	 * @param jonum
	 * @param deptNameList
	 * @param startDate
	 * @param endDate
	 * @throws NumberFormatException
	 */
	public Map<String, Object> queryUseTaxiData(JSONObject jonum, List<String> deptNameList,String startDate, String endDate,int days) {
		//查询多个部门每日打车总金额
 		List<DidiOrderEntity> list = myConsumptionDeptService.queryVehicleData(deptNameList,startDate,endDate);
 		logger.info("根据部门名称查询每日总金额开始-------------");
		 Map<String, Object> mapList = new HashMap<String, Object>();
		 if(list!=null){
			//查询俩个数组(每天的总金额数组,大月日期数组)
			 List<String[]> orderPriceAndDateList = fillorderTotalPriceMonth(days,list); 
			 String[] totalPriceArray = orderPriceAndDateList.get(0);//每天的总金额数组
			//放入每日总金额数组
			 mapList.put("totalPriceArray", totalPriceArray);
			//放回日期数组
			String[] dateArray = orderPriceAndDateList.get(1);//大月日期数组
			//把日期数组放入mapList
			mapList.put("dateArray", dateArray);
			//这里算出每日的平均金额,先创建一个放人均金额的数组
			int deptInt=0;
			for (int i = 0; i < deptNameList.size(); i++) {
				 //调用DPM的接口根据部门名称查询部门的人数,并把所有部门的人数累计到一起
				 String deptName = deptNameList.get(i);
				 deptInt = deptInt+eExternalMethodService.getOrgEmpNum(deptName);  
			}
			if(deptInt==0){//如果所有部门的总人数为0,则不能用0作为分母计算每日平均金额
				String[] avgTotalPirceDeptEmpty= new String[days];//返回一个空的
				for (int i = 0; i < avgTotalPirceDeptEmpty.length; i++) {
					avgTotalPirceDeptEmpty[i]="0.0";
				}
				mapList.put("avgTotalPirceDept", avgTotalPirceDeptEmpty); //放入平均金额的数组(虽有值都为0.0)
			 }else{
				 String[] avgTotalPirceDept =new String [days];
				 for (int i = 0; i < avgTotalPirceDept.length; i++) {
					 double avg = (Double.parseDouble(totalPriceArray[i]))/deptInt; //先计算出平均数
					 avgTotalPirceDept[i]=Intercept(String.valueOf(avg)); //平均数一定要处理下，保留小数点后俩位
				}
				mapList.put("avgTotalPirceDept", avgTotalPirceDept); //放入平均金额的数组
			} 
			return mapList;
		 }else{
			//如果等于NULL的话则 返回一个对应日期长度全部为0的数组
			String[] Array = new String[days];
			for (int i = 0; i < days; i++) {
				Array[i]="0";
			}
			//定义一个日期数组
			//把1号到10号的日期拼接成2018-03-01 格式
			String[] dateArray = new String[days];
			 for (int i = 0; i < days; i++) {
				 dateArray[i]=String.valueOf((i+1))+"日";
			}
			mapList.put("totalPriceArray", Array); //总金额数组
			mapList.put("avgTotalPirceDept", Array);//平均金额数组
			mapList.put("dateArray", dateArray);//日期数组
			logger.info("根据部门名称查询每日总金额结束-------------");
			return mapList;
		 }
	}

	/**
	 * 封装月累计订单分布情况数据
	 * @param distributionMonthByDept
	 * @return Map[]
	 */
	public Map[] encapsulationDistribution(
			DidiOrderEntity distributionMonthByDept) {
		if(distributionMonthByDept==null){//该部门没有打车订单,则打车分部全部设置为0
			logger.info("封装月累计订单分布情况数据开始-------------");
			//将分布情况装入6个map,再装入一个数组
			logger.info("将分布情况装入6个map,再装入一个数组开始-------------");
			Map<String,Object> mapWaiChuGongWu=new HashMap<String,Object>();//公务外出map
			Map<String,Object> mapJiaBan=new HashMap<String,Object>();//加班map
			Map<String,Object> mapGongKuanCunHu=new HashMap<String,Object>();//公款存户map
			Map<String,Object> mapBaiFangKeHu=new HashMap<String,Object>();//拜访客户map
			Map<String,Object> mapCanJiaHuiYi=new HashMap<String,Object>();//参加会议map
			Map<String,Object> mapKuaQuBanGong=new HashMap<String,Object>();//跨区办公map
			Map<String,Object> mapQiTa=new HashMap<String,Object>();//其他map
			//把这些map装到一个数组里
			Map[] otherArrays = new Map[7];
			mapWaiChuGongWu.put("value", "0");
			mapWaiChuGongWu.put("name", "公务外出");
			mapJiaBan.put("value", "0");
			mapJiaBan.put("name", "加班");
			mapGongKuanCunHu.put("value", "0");
			mapGongKuanCunHu.put("name", "公款存户");
			mapBaiFangKeHu.put("value", "0");
			mapBaiFangKeHu.put("name", "拜访客户");
			mapCanJiaHuiYi.put("value", "0");
			mapCanJiaHuiYi.put("name", "参加会议");
			mapKuaQuBanGong.put("value", "0");
			mapKuaQuBanGong.put("name", "跨区办公");
			mapQiTa.put("value", "0");
			mapQiTa.put("name", "其他公务");
			//讲六个map分别放入数组
			otherArrays[0]=mapWaiChuGongWu;
			otherArrays[1]=mapJiaBan;
			otherArrays[2]=mapGongKuanCunHu;
			otherArrays[3]=mapBaiFangKeHu;
			otherArrays[4]=mapCanJiaHuiYi;
			otherArrays[5]=mapKuaQuBanGong;
			otherArrays[6]=mapQiTa;
			return otherArrays;
		}else{
			logger.info("封装月累计订单分布情况数据开始-------------");
			//将分布情况装入6个map,再装入一个数组
			logger.info("将分布情况装入6个map,再装入一个数组开始-------------");
			Map<String,Object> mapWaiChuGongWu=new HashMap<String,Object>();//公务外出map
			Map<String,Object> mapJiaBan=new HashMap<String,Object>();//加班map
			Map<String,Object> mapGongKuanCunHu=new HashMap<String,Object>();//公款存户map
			Map<String,Object> mapBaiFangKeHu=new HashMap<String,Object>();//拜访客户map
			Map<String,Object> mapCanJiaHuiYi=new HashMap<String,Object>();//参加会议map
			Map<String,Object> mapKuaQuBanGong=new HashMap<String,Object>();//跨区办公map
			Map<String,Object> mapQiTa=new HashMap<String,Object>();//其他map
			logger.info("获取分布情况的每个字段开始-------------");
			String waiChuGongWu = distributionMonthByDept.getBillno()==null?"0":distributionMonthByDept.getBillno(); //外出公务
			String jiaBan = distributionMonthByDept.getOfftime()==null?"0":distributionMonthByDept.getOfftime();//加班
			String gongKuanCunHu = distributionMonthByDept.getEmployeeno()==null?"0":distributionMonthByDept.getEmployeeno();//公款存户
			String baiFangKeHu = distributionMonthByDept.getModels()==null?"0":distributionMonthByDept.getModels();//拜访客户
			String canJiaHuiYi = distributionMonthByDept.getFromName()==null?"0":distributionMonthByDept.getFromName();//参加会议
			String kuaQuBanGong = distributionMonthByDept.getTaxidate()==null?"0":distributionMonthByDept.getTaxidate();//跨区办公
			String bangGongQuWangFan = distributionMonthByDept.getBudgetratio()==null?"0":distributionMonthByDept.getBudgetratio();//办公区往返
			String qiTa=distributionMonthByDept.getTimeschedule()==null?"0":distributionMonthByDept.getTimeschedule();//其他
			String qiTaGongWu = distributionMonthByDept.getTomanagername()==null?"0":distributionMonthByDept.getTomanagername();//其他公务
			//把这些map装到一个数组里
			Map[] otherArrays = new Map[7];
			mapWaiChuGongWu.put("value", waiChuGongWu);
			mapWaiChuGongWu.put("name", "公务外出");
			mapJiaBan.put("value", jiaBan);
			mapJiaBan.put("name", "加班");
			mapGongKuanCunHu.put("value", gongKuanCunHu);
			mapGongKuanCunHu.put("name", "公款存户");
			mapBaiFangKeHu.put("value", baiFangKeHu);
			mapBaiFangKeHu.put("name", "拜访客户");
			mapCanJiaHuiYi.put("value", canJiaHuiYi);
			mapCanJiaHuiYi.put("name", "参加会议");
			mapKuaQuBanGong.put("value", String.valueOf(Integer.parseInt(kuaQuBanGong)+Integer.parseInt(bangGongQuWangFan))); //办公区往返和跨区办公归到一类
			mapKuaQuBanGong.put("name", "跨区办公");
			mapQiTa.put("value", String.valueOf(Integer.parseInt(qiTa)+Integer.parseInt(qiTaGongWu)));//其他和其他公务归到一类
			mapQiTa.put("name", "其他公务");
			//讲六个map分别放入数组
			otherArrays[0]=mapWaiChuGongWu;
			otherArrays[1]=mapJiaBan;
			otherArrays[2]=mapGongKuanCunHu;
			otherArrays[3]=mapBaiFangKeHu;
			otherArrays[4]=mapCanJiaHuiYi;
			otherArrays[5]=mapKuaQuBanGong;
			otherArrays[6]=mapQiTa;
			return otherArrays;
		}
	}

	
	/**
	 * @Desciption:TODO(部门每日订单总金额装入数组)
	 * @param ArrayLength
	 * @return Object[]
	 */
	public List<String[]> fillorderTotalPriceMonth(Integer ArrayLength,List<DidiOrderEntity> list){
		logger.info("填充每日订单总金额方法开始(根据部门)-------------");
		List<String[]> listArray=new ArrayList<String[]>();
		String[] Array = new String[ArrayLength];
		for (int i = 0; i < ArrayLength; i++) {
			Array[i]="0";
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)!=null){
				String taxiDate = list.get(i).getTaxidate();
				if(taxiDate!=null){
					String ArrayIndex =taxiDate.substring(8, 10);//数组位置
					Array[Integer.parseInt(ArrayIndex)-1]=Intercept(list.get(i).getEmployeeno());//获取每日总金额
				}		
			}
		}
		//创建对应的日期数组
		String[] dateArray = new String[ArrayLength];
		for (int i = 0; i < ArrayLength; i++) {
			dateArray[i]=String.valueOf((i+1))+"日";
		}
		//装入list
		listArray.add(Array);
		listArray.add(dateArray);
		logger.info("填充每日订单总金额方法结束(根据部门)-------------");
		return listArray;
	}
	
	
	
	
	/**
	 * @Desciption:TODO(判断是平年还是闰年的方法,平年28天,闰年29天)
	 * @return true为平年,false为闰年
	 * @date:2018年3月20日17:15:20
	 */
	public boolean yearOfJudgment(Integer year){
		logger.info("判断闰年平年开始-------------");
		if(year%4==0&&year%100!=0||year%400==0){  
			return false;   
        }else{  
        	return true; 
         } 
	}
	
	
	/**
	 * @Desciption:TODO(判断是大月小月还是二月)
	 * @return 返回是大月小月还是二月
	 * @author 吕德富
	 * @date:2018年3月20日17:15:14
	 */
	public String monthOfStrong(Integer month){
		logger.info("判断大月小月还是二月方法开始-------------");
		int [] bigMonthArray={1,3,5,7,8,10,12}; //大月数组
		int [] smallMonthArray={4,6,9,11};//小月数组
		if(month==2){//先判断是否为二月
			return "February";
		}
		for (int i = 0; i < bigMonthArray.length; i++) {
			if(bigMonthArray[i]==month){
				return "bigMonth";
			}
		}
		for (int i = 0; i < smallMonthArray.length; i++) {
			if(smallMonthArray[i]==month){
				return "smallMonth";
			}
		}
		return "others";
	}
	
	
	/**
	 * 小数点后保留两位的方法
	 * @return String
	 */
	public String Intercept(String string){
		logger.info("小数点后保留两位的方法-------------");
		Double d = Double.parseDouble(string);
		BigDecimal bg = new BigDecimal(d);
		double d1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(d1);
	}
	
	
	/**
	 * 根据list中map的value排序的方法开始,将多个部门概况排序的方法
	 * @param list
	 * @return
	 */
	@SuppressWarnings("all")
	public List<Object> sortDeptProfileList(List<Map<String,Object>> list,List<MyConsumptionRequestEntity> ListDeptByLeader ){
		logger.info("将多个部门概况排序的方法开始-------------");	
		Object[] mapobjarr = new Object[list.size()];
		for (int i = 0; i < mapobjarr.length; i++) {
			mapobjarr[i]=list.get(i);//每次的结果放入数组
		}
		//排序
		for(int i =1;i < mapobjarr.length;i++){  
            for(int j = 0;j <  mapobjarr.length-i;j++){  // j开始等于0， 
            	//改成根据百分比排序
            	String Percentage1 = (String) ((Map<String,Object>)mapobjarr[j]).get("Percentage");
            	String PercentageNumber1 = Percentage1.substring(0, Percentage1.length()-1);
            	
            	String Percentage2 = (String) ((Map<String,Object>)mapobjarr[j+1]).get("Percentage");
            	String PercentageNumber2 = Percentage2.substring(0, Percentage2.length()-1);
            	
                if(Double.parseDouble(PercentageNumber1) < Double.parseDouble(PercentageNumber2))  
                {  
                    Object temp = mapobjarr[j];  
                    mapobjarr[j] = mapobjarr[j+1];  
                    mapobjarr[j+1] = temp;  
                }  
            }  
        }  
		
		
		//这里调用接口查询大部门汇总领导的信息
//		List<MyConsumptionRequestEntity> ListDeptByLeader = eExternalMethodService.getDeptInfo(userId);
		//重新创建一个List
		List<Object> sortSurveyList = new ArrayList<Object>();
		List<Object> mapobjarrList = Arrays.asList(mapobjarr);
		List arrayList = new ArrayList(mapobjarrList);//转化为ArrayList 
		for (int i = 0; i <arrayList.size(); i++) {
			if(ListDeptByLeader.get(0).getEmpName().equals(((Map<String,Object>)arrayList.get(i)).get("leaderName")) && "Y".equals(((Map<String,Object>)arrayList.get(i)).get("isDept"))){ //判断下是不是总领导汇总的部门
				sortSurveyList.add(arrayList.get(i));
				arrayList.remove(arrayList.get(i)); //把汇总部门remove掉
				break;
			}	
		}
		//重新装入新的list
		for (int j = 0; j < arrayList.size(); j++) {
			sortSurveyList.add(arrayList.get(j));
		}
		
		
		logger.info("将多个部门概况排序的方法结束-------------");
		/*return Arrays.asList(mapobjarr);*/
		return sortSurveyList;
	}
	
	
		
	public IMyConsumptionDeptService getMyConsumptionDeptService() {
		return myConsumptionDeptService;
	}

	public void setMyConsumptionDeptService(
			IMyConsumptionDeptService myConsumptionDeptService) {
		this.myConsumptionDeptService = myConsumptionDeptService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public IExternalMethodService geteExternalMethodService() {
		return eExternalMethodService;
	}

	public void seteExternalMethodService(
			IExternalMethodService eExternalMethodService) {
		this.eExternalMethodService = eExternalMethodService;
	}
}