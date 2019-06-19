package com.deppon.dpm.doc.server.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IMyConsumptionService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;

/**
 * @Desciption:TODO(我的消费接口)
 * @className:Myconsumption
 * @author: lvdf
 * @date:2018年3月19日09:03:26
 */
public class MyConsumptionAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5026161459829826206L;
	
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(MyConsumptionAction.class);
	
	/**
	 * 构造方法
	 */
	public MyConsumptionAction() {
		super();
	}
	
	/**
	 * 注入我的消费service
	 */
	private IMyConsumptionService myConsumptionService;
	
	
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
	
	/**
	 * @Desciption:TODO(我的消费查询)
	 * @author: lvdf
	 * @date:2018年3月19日09:27:46
	 */
	@SuppressWarnings("all")
	@CookieNotCheckedRequired
	public void myConsumption(){
		JSONObject jonum = new JSONObject();
		logger.info("查询普通员工个人消费myConsumption()开始-------------");
		//判断传入的员工号,年,月,非空非null
		if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(year) && StringUtils.isNotEmpty(month)){
			if(userId.length()==6){
				if(Integer.parseInt(month)>=1 && Integer.parseInt(month)<=12){
					List<MyConsumptionRequestEntity> list = eExternalMethodService.getDeptInfo(userId);
					//判断这个员工是否存在
					if(list==null&&list.size()<1){
						jonum.put("msg", "该员工不存在"); 
						writeToPage(jonum);
					}else{
						//根据调用移动BI的接口判断是否为领导
						String order = list.get(0).getOrder();
						if("1".equals(order)){
							jonum.put("Jurisdiction", "2"); //权限,0表示普通员工,1表示小领导,2表示大领导
						}else if("2".equals(order)){
							jonum.put("Jurisdiction", "1"); //权限,0表示普通员工,1表示小领导,2表示大领导
						}else{
							jonum.put("Jurisdiction", "0"); //权限,0表示普通员工,1表示小领导,2表示大领导
						}
						//根据年和月,拼接传入的日期参数
						String startDate=year+"-"+month+"-"+"01"+" "+"00:00:00"; //当月起始日期
						String endDate=year+"-"+month+"-"+"31"+" "+"23:59:59"; //当月终止日期
						if(yearOfJudgment(Integer.parseInt(year))){//调用判断是平年还是闰年的方法,平年为true,闰年为false
							 //调用当前月份是大小月的方法
							 String monthOfStrong = monthOfStrong(Integer.parseInt(month));
							 if("February".equals(monthOfStrong)){//如果为平年二月,根据员工号查询当月每日有效订单数和钱数
								 logger.info("查询当月每日有效订单数和钱数-------------");
								 fillContextTOArray(jonum, startDate, endDate,28);
							 }else if("bigMonth".equals(monthOfStrong)){//如果为大月份,根据员工号查询当月每日有效订单数和钱数
								logger.info("查询当月每日有效订单数和钱数-------------");
								fillContextTOArray(jonum, startDate, endDate,31);
							 }else if("smallMonth".equals(monthOfStrong)){//如果为小月份,根据员工号查询当月每日有效订单数和钱数
								 logger.info("查询当月每日有效订单数和钱数-------------");
								 fillContextTOArray(jonum, startDate, endDate,30);
							 }
						}else{
							String monthOfStrong = monthOfStrong(Integer.parseInt(month));//调用当前月份是大小月的方法
							 if("February".equals(monthOfStrong)){//如果为平年二月,根据员工号查询当月每日有效订单数和钱数
								 logger.info("查询当月每日有效订单数和钱数-------------");
								 fillContextTOArray(jonum, startDate, endDate,29);
							 }else if("bigMonth".equals(monthOfStrong)){//如果为大月份,根据员工号查询当月每日有效订单数和钱数
								 logger.info("查询当月每日有效订单数和钱数-------------");
								 fillContextTOArray(jonum, startDate, endDate,31);
							 }else if("smallMonth".equals(monthOfStrong)){//如果为小月份,根据员工号查询当月每日有效订单数和钱数
								 logger.info("查询当月每日有效订单数和钱数-------------");
								 fillContextTOArray(jonum, startDate, endDate,30);
							 }
						}
						jonum.put("msg", "success");
						writeToPage(jonum);
					}
				}else{
					jonum.put("msg", "查询失败,传入月份有误");	
					writeToPage(jonum);
				}
			}else{
				jonum.put("msg", "工号长度有误");	
				writeToPage(jonum);
			}
		}else{
			jonum.put("msg", "查询失败,员工号年月不能为空");	
			writeToPage(jonum);
		}
	}

	/**
	 * 查询头部折线图(个人消费每日累计金额,累计订单数)
	 * @param jonum
	 * @param startDate
	 * @param endDate
	 * @param number(根据月份传入的天数)
	 */
	public void fillContextTOArray(JSONObject jonum, String startDate,String endDate,Integer number) {
		List<DidiOrderEntity> list = myConsumptionService.queryCountAndPrice(userId,startDate,endDate);
		logger.info("查询头部折线图(个人消费每日累计金额,累计订单数)-------------");
		if(list!=null){
			Map<String, Object> mapList = new HashMap<String, Object>();
			//调用方法填充订单数量数组
			List<String[]> orderNumberArrayALL = fillorderNumTOArray(number,list);
			String[] countArray = orderNumberArrayALL.get(0);
			String[] DateArray = orderNumberArrayALL.get(1);
			//调用方法填充订单金额数组
			String[] orderPriceAll = fillorderPriceTOArray(number,list);
			//将俩个数组一起装入map
			mapList.put("countArray", countArray);
			mapList.put("DateArray", DateArray);
			mapList.put("orderPriceAll", orderPriceAll);
			jonum.put("countMoneyDate", mapList);
			//调用查询当月订单其他信息的方法
			queryOrderOthers(jonum, startDate, endDate);
		}else{
			queryOrderOthers(jonum, startDate, endDate);
			//为Null的时候,表示当月没有任何有效订单
			Map<String, Object> mapList = new HashMap<String, Object>();
			//如果等于NULL的话则 返回一个对应日期长度全部为0的数组
			String[] Array = new String[number];
			for (int i = 0; i < number; i++) {
				Array[i]="0";
			}
			//定义一个日期数组
			//把1号到10号的日期拼接成2018-03-01 格式
			String[] dateArray = new String[number];
			 for (int i = 0; i < number; i++) {
				 dateArray[i]=String.valueOf((i+1))+"日";
			}
			mapList.put("countArray", Array);//总订单
			mapList.put("orderPriceAll", Array);//订单总钱数
			mapList.put("DateArray", dateArray);//日期
			jonum.put("countMoneyDate", mapList);//一块放入JsonObject
		}

	}

	/**
	 * @param jonum
	 * @param startDate
	 * @param endDate
	 * @Desciption:TODO(查询员工号当月累计金额,总公里数,订单总数,分布情况)
	 * @author 吕德富
	 * @date:2018年3月20日17:34:19
	 */
	public void queryOrderOthers(JSONObject jonum, String startDate,
			String endDate) {
		logger.info("查询员工号当月累计金额,总公里数,订单总数,分布情况开始-------------");
		//根据员工号查询有效订单月累计金额
		String totalPriceByMonth = myConsumptionService.queryTotalPriceById(startDate,endDate,userId);
		if(totalPriceByMonth==null){
			jonum.put("totalPriceByMonth", "0");//装入月累计金额(根据个人)
		}else{
			jonum.put("totalPriceByMonth", Intercept(totalPriceByMonth));//装入月累计金额(根据个人)
		}
		//根据员工号查询当月有效订单总公里数
		logger.info("根据员工号查询当月有效订单总公里数开始-------------");
		String normalDistanceByMonth=myConsumptionService.queryNormalDistanceById(startDate,endDate,userId);
		if(normalDistanceByMonth==null){
			jonum.put("normalDistanceByMonth", "0");//装入月累计总公里数(根据个人)
		}else{
			jonum.put("normalDistanceByMonth", Intercept(normalDistanceByMonth));//装入月累计总公里数(根据个人)
		}
		//根据员工号查询当月有效订单总数
		logger.info("根据员工号查询当月有效订单总数开始-------------");
		String count = myConsumptionService.queryOrderCountById(startDate,endDate,userId);
		if(count==null){
			jonum.put("count", "0");//装入月累计订单数(根据个人)
		}else{
			jonum.put("count", count);//装入月累计订单数(根据个人)
		}
		logger.info("根据员工号查询当月打车分布情况开始-------------");
		//根据员工号查询当月打车分布情况
		DidiOrderEntity TaxiDistribution=myConsumptionService.queryTaxiDistribution(startDate,endDate,userId);
		if(TaxiDistribution==null){
			logger.info("根据员工号查询当月打车分布情况开始-------------");
			//将分布情况装入6个map,再装入一个数组
			logger.info("将分布情况装入7个map,再装入一个数组开始-------------");
			Map<String,Object> mapWaiChuGongWu=new HashMap<String,Object>();//外出公务map
			Map<String,Object> mapJiaBan=new HashMap<String,Object>();//加班map
			Map<String,Object> mapGongKuanCunHu=new HashMap<String,Object>();//公款存户map
			Map<String,Object> mapBaiFangKeHu=new HashMap<String,Object>();//拜访客户map
			Map<String,Object> mapCanJiaHuiYi=new HashMap<String,Object>();//参加会议map
			Map<String,Object> mapKuaQuBanGong=new HashMap<String,Object>();//跨区办公map
			Map<String,Object> mapQiTa=new HashMap<String,Object>();//其他map
			//把这些map装到一个数组里
			Map[] otherArrays = new Map[7];
			//挨个放入map
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
			logger.info("月累计金额,总公里数,订单总数,分布情况装入Json开始-------------");
			jonum.put("otherArrays", otherArrays);//装入月累计订单分布情况(根据个人)
		}else{
			logger.info("根据员工号查询当月打车分布情况开始-------------");
			//将分布情况装入6个map,再装入一个数组
			logger.info("将分布情况装入7个map,再装入一个数组开始-------------");
			Map<String,Object> mapWaiChuGongWu=new HashMap<String,Object>();//公务外出map
			Map<String,Object> mapJiaBan=new HashMap<String,Object>();//加班map
			Map<String,Object> mapGongKuanCunHu=new HashMap<String,Object>();//公款存户map
			Map<String,Object> mapBaiFangKeHu=new HashMap<String,Object>();//拜访客户map
			Map<String,Object> mapCanJiaHuiYi=new HashMap<String,Object>();//参加会议map
			Map<String,Object> mapKuaQuBanGong=new HashMap<String,Object>();//跨区办公map
			Map<String,Object> mapQiTa=new HashMap<String,Object>();//其他map
			logger.info("获取分布情况的每个字段开始-------------");
			String waiChuGongWu = TaxiDistribution.getBillno()==null?"0":TaxiDistribution.getBillno(); //外出公务
			String jiaBan = TaxiDistribution.getOfftime()==null?"0":TaxiDistribution.getOfftime();//加班
			String gongKuanCunHu = TaxiDistribution.getEmployeeno()==null?"0":TaxiDistribution.getEmployeeno();//公款存户
			String baiFangKeHu = TaxiDistribution.getModels()==null?"0":TaxiDistribution.getModels();//拜访客户
			String canJiaHuiYi = TaxiDistribution.getFromName()==null?"0":TaxiDistribution.getFromName();//参加会议
			String kuaQuBanGong = TaxiDistribution.getTaxidate()==null?"0":TaxiDistribution.getTaxidate();//跨区办公
			String bangGongQuWangFan = TaxiDistribution.getBudgetratio()==null?"0":TaxiDistribution.getBudgetratio();//办公区往返
			String qiTa=TaxiDistribution.getTimeschedule()==null?"0":TaxiDistribution.getTimeschedule();//其他
			String qiTaGongWu = TaxiDistribution.getTomanagername()==null?"0":TaxiDistribution.getTomanagername();//其他公务
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
			logger.info("月累计金额,总公里数,订单总数,分布情况装入Json开始-------------");
			jonum.put("otherArrays", otherArrays);//装入月累计订单分布情况(根据个人)
		}	
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
	 * @Desciption:TODO(讲每日订单总条数装入数组)
	 * @param ArrayLength
	 * @return Object[]
	 */
	public List<String[]> fillorderNumTOArray(Integer ArrayLength,List<DidiOrderEntity> list){
		logger.info("按照对应日期装入每月每日订单总条数开始-------------");
		List<String[]> listArray=new ArrayList<String[]>();
		String[] Array = new String[ArrayLength];
		//把数组每个位置设置为"0"
		for (int i = 0; i < ArrayLength; i++) {
			Array[i]="0";
		}
		//把对应每日对应的数组放到对应的日期上,
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)!=null){
				String ArrayIndex = list.get(i).getTaxidate().substring(8, 10);//数组位置(根据日期的后俩位数组,如2018-03-15,截取出15)
				Array[Integer.parseInt(ArrayIndex)-1]=list.get(i).getModels();//获取当月订单每日总条数,放到截取数字减1的位置,(15号的应放在数组的第14位)
			}
		}
		 //填入日期数组
		String[] dateArray = new String[ArrayLength];
		 for (int i = 0; i < ArrayLength; i++) {
			 dateArray[i]=String.valueOf((i+1))+"日";
		}
		 //装入list
		 listArray.add(Array);
		 listArray.add(dateArray);
		 logger.info("按照对应日期装入每月每日订单总条数结束-------------");
		return listArray;
	}
	
	/**
	 * @Desciption:TODO(将每日订单总金额装入数组)
	 * @param ArrayLength
	 * @return Object[]
	 */
	public String[] fillorderPriceTOArray(Integer ArrayLength,List<DidiOrderEntity> list){
		logger.info("按照对应日期装入每月没每日总金额开始-------------");
		String[] Array = new String[ArrayLength];
		//把数组每个位置设置为"0"
		for (int i = 0; i < ArrayLength; i++) {
			Array[i]="0";
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)!=null){
				String ArrayIndex = list.get(i).getTaxidate().substring(8, 10);//数组位置(根据日期的后俩位数组,如2018-03-15,截取出15)
				Array[Integer.parseInt(ArrayIndex)-1]=Intercept(list.get(i).getEmployeeno());//获取当月每日订单总钱数,放到截取数字减1的位置,(15号的应放在数组的第14位)
			}
		}
		logger.info("按照对应日期装入每月没每日总金额结束-------------");
		return Array;
	}
	
	
	/**
	 * 小数点后保留两位的方法
	 * @return
	 */
	public String Intercept(String string){
		logger.info("小数点后保留两位的方法开始-------------");
		Double d = Double.parseDouble(string);
		BigDecimal bg = new BigDecimal(d);
		double d1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(d1);
	}
	
	public IMyConsumptionService getMyConsumptionService() {
		return myConsumptionService;
	}

	public void setMyConsumptionService(IMyConsumptionService myConsumptionService) {
		this.myConsumptionService = myConsumptionService;
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
