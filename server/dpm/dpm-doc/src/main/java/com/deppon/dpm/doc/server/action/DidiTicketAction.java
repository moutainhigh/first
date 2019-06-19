package com.deppon.dpm.doc.server.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.DidiCityEntity;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.dpm.doc.server.service.IDepositorService;
import com.deppon.dpm.doc.server.service.IDidiCitiesService;
import com.deppon.dpm.doc.server.service.IDidiTicketService;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.util.DESHelper4Doc;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.CitiesClassVO;
import com.deppon.dpm.doc.server.vo.CitiesInfoVO;
import com.deppon.dpm.doc.server.vo.CityResultVO;
import com.deppon.dpm.doc.server.vo.DidiTicketItemVO;
import com.deppon.dpm.doc.server.vo.DidiTicketResultVO;
import com.deppon.dpm.doc.server.vo.DidiTicketVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
import com.deppon.foss.framework.shared.encypt.base64.BASE64Decoder;

/**
 * 滴滴发单申请
 * 
 * @author guzf
 * 
 */
public class DidiTicketAction extends BaseAction {

	private static final long serialVersionUID = 889914310536722024L;

	private static final Logger logger = LoggerFactory
			.getLogger(DidiTicketAction.class);

	private IDidiTicketService didiTicketService;
	private IDidiCitiesService didiCitiesService;

	private String didi_client_id;
	private String didi_client_secret;
	private String didi_key;
	private String didi_pubiphone;
	private String didi_didiurl;

	private static final int subkey = 8;
//	private static final int levellist = 600;

	private String userId;
	private String userName;
	private String userTel;
	private String userCompany;
	private String userDepartment;
	private String userFinance;
	private String carAuthority;
	private String remark;
	private String remarkinfo;
	// 城市名称
	private String city_name;
	// 出发地名称
	private String from_name;
	// 出发地纬度
	private float flat;
	// 出发地经度
	private float flng;
	   //客户名称：
    private String customname ;
  //银行卡号：
    private String bankcardnum ;
  //客户手机号：
    private String customtel ;
  //客户编码：
    private String customcode ;
  // 日程会议名称：
    private String meetingname ;
  //出发部门负责人姓名：
    private String frommanagername ;
  //目的部门负责人姓名：
    private String tomanagername ;
  //  目的部门负责人工号：
    private String tomanagercode ;
  //出发部门负责人工号：
    private String frommanagercode ;
  //其他公务审核人工号：
    private String auditorcode ;
  //  其他公务审核人姓名：
    private String auditorname ;
//  用户头像：
    private String userheadpic ;
    //图片名称
    private String meetingpic ;
  //直属上级级别
    private String joblevel;
    //新增会议名称
    private String newmeetingname;
    //会议开始时间
    private String newmeetingstart;
    //会议结束时间
    private String newmeetingend;
    //差旅工作流号
    private String travelWorkflowNo;
    //差旅出差城市
    private String travelCity;
    //差旅开始时间
	private String startDate;
    //差旅结束时间
	private String endDate;
    
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private IExternalMethodService externalMethodService;//获取用户头像
	
	private IDepositorService depositorService;
	
	//查询排班状态
	private IDoubtfulExAuditService doubtfulExAuditService;
	
	//查询人力考勤信息接口
	private String attendanceUrl;

	
	private static String filePath = "/dpmfile/didimettingpic/";
	/**
	 * 构造方法
	 */
	public DidiTicketAction() {
		super();
	}

	/**
	 * 获取滴滴服务城市列表
	 */
	public String getCitis() {
		String result = null;
		try {
			logger.info("获取滴滴服务城市列表开始》》》》》》》》》》》");
			Map<String, Object> datamap = new HashMap<String, Object>();
			datamap.put("client_id", didi_client_id);
			datamap.put("client_secret", didi_client_secret);
			String data = DESHelper4Doc.encrypt(JSON.toJSONString(datamap,
					SerializerFeature.WriteNullStringAsEmpty), didi_key
					.substring(0, subkey));
			data = URLEncoder.encode(data, "UTF-8");
			// 请求地址
			result = HttpClientUtil.sendGet(didi_didiurl + "cities/getAll",
					"client_id=" + didi_client_id + "&data_encode=" + data);
			logger.info("获取滴滴服务城市列表结束》》》》》》》》》》》");
		} catch (Exception e) {
			logger.info("获取滴滴服务城市列表出现异常>>>>>>>>>" + e.getMessage());
		}
		return result;
	}

	// /**
	// * 获取滴滴服务城市列表
	// */
	// @CookieNotCheckedRequired
	// public void getCitiss() {
	// String result = null;
	// try {
	// logger.info("获取滴滴服务城市列表开始》》》》》》》》》》》");
	// Map<String,Object> datamap = new HashMap<String,Object>();
	// datamap.put("client_id", didi_client_id);
	// datamap.put("client_secret", didi_client_secret);
	// String data =
	// DESHelper.encrypt(JSON.toJSONString(datamap,SerializerFeature.WriteNullStringAsEmpty),
	// didi_key.substring(0, 8));
	// Pattern p = Pattern.compile("\r|\n");
	// Matcher m = p.matcher(data);
	// data = m.replaceAll("");
	// data = URLEncoder.encode(data,"UTF-8");
	// // 请求地址
	// result = HttpClientUtil.sendGet(didi_didiurl+"cities/getAll",
	// "client_id="+didi_client_id+"&data_encode="+data);
	// if(result!=null){
	// CityResultVO didiResultVO = JSON.parseObject(result, CityResultVO.class);
	// if(didiResultVO.getErrno()!=0){
	// writeToPage(didiResultVO);
	// return;
	// }
	// for(CitiesClassVO citiesclassvo : didiResultVO.getData()){
	// List<CitiesInfoVO> cities = citiesclassvo.getCities();
	// for(CitiesInfoVO city : cities){
	// DidiCityEntity didicityentity = new DidiCityEntity();
	// didicityentity.setName(city.getName());
	// didicityentity.setCityid(city.getCityid());
	// didicityentity.setOpenKuaiche(city.getOpen_kuaiche());
	// didicityentity.setOpenZhuanche(city.getOpen_zhuanche());
	// didicityentity.setTs(sdf.format(new Date()));
	// didiCitiesService.insert(didicityentity);
	// }
	// }
	// }
	// logger.info("获取滴滴服务城市列表结束》》》》》》》》》》》");
	// } catch (Exception e) {
	// logger.info("获取滴滴服务城市列表出现异常>>>>>>>>>"+e.getMessage());
	// }
	// }

	/**
	 * 一次性发单ticket申请
	 */
	@SuppressWarnings("unchecked")
	public void getTicket() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getMethod() == "POST") {
			// 初始化数据
			userId = getvalue("userId");
			userName = getvalue("userName");
			userTel = getvalue("userTel");
			userCompany = getvalue("userCompany");
			userDepartment = getvalue("userDepartment");
			
			userFinance = getvalue("userFinance");
			carAuthority = getvalue("carAuthority");
			remark = getvalue("remark");
			remarkinfo = getvalue("remarkinfo");
//			sessionId = String.valueOf(request.getParameterMap().get("sessionId"));
//			casCookie = String.valueOf(request.getParameterMap().get("casCookie"));
//			deviceToken = String.valueOf(request.getParameterMap().get("deviceToken"));
			if (getvalue("flat") == null || "".equals(getvalue("flat"))) {
				// 不做处理
			}else{
				flat = Float.parseFloat( getvalue("flat"));
			}
			if (getvalue("flng") == null || "".equals(getvalue("flng"))) {
				// 不做处理
			}else{
				flng = Float.parseFloat( getvalue("flng"));
			}
			city_name = getvalue("city_name");
			from_name = getvalue("from_name");
			
			customname = getvalue("customname");
			bankcardnum = getvalue("bankcardnum");
			customtel = getvalue("customtel");
			customcode = getvalue("customcode");
			joblevel = getvalue("joblevel");
			meetingname = getvalue("meetingname");
			frommanagername = getvalue("frommanagername");
			tomanagername = getvalue("tomanagername");
			tomanagercode = getvalue("tomanagercode");
			frommanagercode = getvalue("frommanagercode");
			auditorcode = getvalue("auditorcode");
			auditorname = getvalue("auditorname");
			userheadpic = getvalue("userheadpic");
			meetingpic = String.valueOf(request.getParameterMap().get("meetingpic[]"));
			//新增会议名称
			newmeetingname = getvalue("newmeetingname");
		    //会议开始时间
			newmeetingstart = getvalue("newmeetingstart");
		    //会议结束时间
			newmeetingend = getvalue("newmeetingend");
			
			String result = "{}";
			
			EmployeeVO empVo = externalMethodService.getEmpInfo(userId);
			//所有用车限制不包括band10及以上
			boolean isSeniorLeader =  (empVo.getJobLevel().compareTo("10") != -1 && empVo.getJobGroups().equals("管理族群"))||
					                   empVo.getJobName().contains("秘书") || empVo.getJobName().contains("总裁助理");
			
			try {
				logger.info("开始获取滴滴发单申请》》》》》》》》》》》" + userId);
				logger.info("组装滴滴发单申请VO开始》》》》》》》》》》》");
				DidiTicketItemVO itemvo = new DidiTicketItemVO();
				itemvo.setClient_id(didi_client_id);
				itemvo.setClient_secret(didi_client_secret);// 申请应用时分配的client_secret
				itemvo.setMaster_phone(didi_pubiphone);// 管理员手机号（作为统一叫车人）
				itemvo.setPassenger_phone(userTel);// 乘客手机号(当前用户)
				itemvo.setAuth_type(1);// 授权类型：0-非发单（无发单权限）；1-发单（有发单权限及其他所有权限）
				itemvo.setRemark(remark);// 备注
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("userId", userId);
				map1.put("remark", remark);
				itemvo.setCallback_info(JSON.toJSONString(map1,
						SerializerFeature.WriteNullStringAsEmpty));// 乘车人&用车自定义信息（信息透传），在对账单中会展示该字段
				logger.info("组装滴滴发单申请》》》》》》》》》》》匹配城市id" + city_name);
				
				/*营运事业群内，根据部门名前两个限定打车城市*/  
				/*非营运事业群，部门名能识别出城市的定位为该城市，否则定位为上海*/
				OrganizationVO dept = externalMethodService.getDeptByEmpcode(userId);
				int cityid = 0;
				if(dept != null && !remark.equals("其他公务") && !remark.equals("差旅")){
					//营运事业群
					if(dept.getDeptSeq().indexOf(".270.") != -1||dept.getDeptSeq().indexOf(".348.") != -1||
						dept.getDeptSeq().indexOf(".463.") != -1||dept.getDeptSeq().indexOf(".475.") != -1||
						dept.getDeptSeq().indexOf(".613.") != -1||dept.getDeptSeq().indexOf(".621.") != -1||
						dept.getDeptSeq().indexOf(".622.") != -1||dept.getDeptSeq().indexOf(".754.") != -1||
						dept.getDeptSeq().indexOf(".110775.") != -1||dept.getDeptSeq().indexOf(".192773.") != -1||
						dept.getDeptSeq().indexOf(".464255.") != -1||dept.getDeptSeq().indexOf(".464256.") != -1||
						dept.getDeptSeq().indexOf(".464257.") != -1||dept.getDeptSeq().indexOf(".491698.") != -1||
						dept.getDeptSeq().indexOf(".491699.") != -1||dept.getDeptSeq().indexOf(".491700.") != -1||
						dept.getDeptSeq().indexOf(".498482.") != -1||dept.getDeptSeq().indexOf(".499820.") != -1){
						String cityname = dept.getOrgName().substring(0, 2);
						List<Integer> cityidlist = didiCitiesService.getCityId(cityname);
						if(cityidlist != null && cityidlist.size() > 0){
							if(cityidlist.size() > 1){
								//若市名前两个字相同，取前三个字
								List<Integer> cityidlist1 = didiCitiesService.getCityId(dept.getOrgName().substring(0, 3));
								if(cityidlist1 != null && cityidlist1.size() > 0){
									cityid = cityidlist1.get(0);
								}
									
							}else{
								cityid = cityidlist.get(0);
							}
						}
					}else{
					//非营运事业群
						String cityname = dept.getOrgName().substring(0, 2);
						List<Integer> cityidlist = didiCitiesService.getCityId(cityname);
						//能识别出城市名
						if(cityidlist != null && cityidlist.size() > 0){
							if(cityidlist.size() > 1){
								//若市名前两个字相同，取前三个字
								List<Integer> cityidlist1 = didiCitiesService.getCityId(dept.getOrgName().substring(0, 3));
								if(cityidlist1 != null && cityidlist1.size() > 0){
									cityid = cityidlist1.get(0);
								}
									
							}else{
								cityid = cityidlist.get(0);
							}
						}else{
						//不能识别出城市名，默认定位上海
							List<Integer> shcityid = didiCitiesService.getCityId("上海");
							cityid = shcityid.get(0);
						}
					}
					
				}
				
				
				if(city_name!=null&&!"".equals(city_name)){
					DidiCityEntity didicityentity = new DidiCityEntity();
					didicityentity.setName(city_name);
					DidiCityEntity didicityentity1 = didiCitiesService
							.find(didicityentity);
					if (didicityentity1 == null) {
						String citystr = getCitis();
						logger.info(userId +"getCitis"+citystr);
						if (citystr != null) {
							CityResultVO didiResultVO = JSON.parseObject(citystr,
									CityResultVO.class);
							if (didiResultVO.getErrno() != 0) {
								writeToPage(didiResultVO);
								return;
							}
							for (CitiesClassVO citiesclassvo : didiResultVO.getData()) {
								List<CitiesInfoVO> cities = citiesclassvo.getCities();
								for (CitiesInfoVO city : cities) {
									if (city.getName().equals(city_name)) {
										didicityentity.setName(city.getName());
										didicityentity.setCityid(city.getCityid());
										didicityentity.setOpenKuaiche(city
												.getOpen_kuaiche());
										didicityentity.setOpenZhuanche(city
												.getOpen_zhuanche());
										didicityentity.setTs(sdf.format(new Date()));
										didiCitiesService.insert(didicityentity);
										if(isSeniorLeader==false){
											itemvo.setCity_id(city.getCityid());// 用车城市，如不传，则不限制城市；传了城市ID，限制本次叫车只允许在该城市发单
										}
									}
								}
							}
						}
		
					} else {
						if(isSeniorLeader==false){
							itemvo.setCity_id(didicityentity1.getCityid());// 用车城市，如不传，则不限制城市；传了城市ID，限制本次叫车只允许在该城市发单
						}
					}
					
					//所有用车限制不包括band10及以上
					//boolean isSeniorLeader =  empVo.getJobLevel().compareTo("10") != -1 && empVo.getJobGroups().equals("管理族群");
					
					//营运事业群部门名限制  + 非营运事业群
					if(isSeniorLeader == false){
						if(cityid > 0 && !(cityid == itemvo.getCity_id()) && !remark.equals("其他公务") && !remark.equals("差旅")){	
							logger.info(userId +" 用车城市不符合要求：" + "部门所在城市" + cityid + "当前定位城市" + itemvo.getCity_id());
							DidiTicketResultVO resultvo = new DidiTicketResultVO();
							resultvo.setErrno(3);
							resultvo.setErrmsg(userId +" 用车城市不符合要求：" + "部门所在城市" + cityid + "当前定位城市" + itemvo.getCity_id());
							writeToPage(resultvo);
							return;
						}
					}
					//公款存户用车限制
					try{
						if(remark.equals("公款存户")){
							int num = depositorService.query(userId);
							if(num>=2){
								DidiTicketResultVO resultvo = new DidiTicketResultVO();
								resultvo.setErrno(6);
								resultvo.setErrmsg("同事你好，该用车场景每天只可用车两次，如有其它原因用车，请使用其它公务。");
								writeToPage(resultvo);
								return;
							}
						}
					}catch(Exception e){
						DidiTicketResultVO resultvo = new DidiTicketResultVO();
						resultvo.setErrno(6);
						resultvo.setErrmsg("公款存户异常");
						writeToPage(resultvo);
						return;
					}
					//下班卡限制
					try{
						if(remark.equals("加班")){
							String str = HttpClientUtil.httpPost(attendanceUrl,userId);
							
							List<Map> list = JSONArray.parseArray(str, Map.class);
							
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
							
							
							if(list.size()==0){
								DidiTicketResultVO resultvo = new DidiTicketResultVO();
								resultvo.setErrno(8);
								resultvo.setErrmsg("同事你好，未获取下班卡记录，请先打下班卡");
								writeToPage(resultvo);
								return;
								
							}else if(list.size()==1){
								
								
								Map<String,String> map = list.get(0);
								Date now = new Date();

								String date1 = map.get("CURDATE");
								String time1 = map.get("CURTIME");
								
								
								String n = sdf.format(now);
								String n1 = sdf2.format(now);
								
								Date d1 = sdf.parse(date1);
								Date t1 = sdf2.parse(time1);
								Date now1 = sdf.parse(n);
								Date nowt =sdf2.parse(n1);
								
								if(d1.before(now1)){
									Date ts=sdf2.parse("00:00:00");
									Date te=sdf2.parse("05:59:59");
									if(nowt.after(ts)&&nowt.before(te)){
										
										Date times=sdf2.parse("22:00:00");
										Date timee=sdf2.parse("29:59:59");
										if(!(t1.before(timee)&&t1.after(times))){
											DidiTicketResultVO resultvo = new DidiTicketResultVO();
											resultvo.setErrno(7);
											resultvo.setErrmsg("同事你好，你的下班卡时间不在使用欢行范围内");
											writeToPage(resultvo);
											return;
										}
									}else{
										DidiTicketResultVO resultvo = new DidiTicketResultVO();
										resultvo.setErrno(8);
										resultvo.setErrmsg("同事你好，未获取下班卡记录，请先打下班卡");
										writeToPage(resultvo);
										return;
									}
								}else{
									Date times=sdf2.parse("22:00:00");
									Date timee=sdf2.parse("23:59:59");
									if(!(t1.before(timee)&&t1.after(times))){
										DidiTicketResultVO resultvo = new DidiTicketResultVO();
										resultvo.setErrno(7);
										resultvo.setErrmsg("同事你好，你的下班卡时间不在使用欢行范围内");
										writeToPage(resultvo);
										return;
									}
								}
								
							}else{
								
								Map<String,String> map = list.get(0);
								Map<String,String> map2 = list.get(1);
								
								String date1 = map.get("CURDATE");
								String time1 = map.get("CURTIME");
								String date2 = map2.get("CURDATE");
								String time2 = map2.get("CURTIME");
								
								Date d1 = sdf.parse(date1);
								
								Date d2 = sdf.parse(date2);
								
								
								if(d1.before(d2)){
									
									Date t2 = sdf2.parse(time2);
									
									Date times=sdf2.parse("22:00:00");
									Date timee=sdf2.parse("23:59:59");
									if(!(t2.before(timee)&&t2.after(times))){
										DidiTicketResultVO resultvo = new DidiTicketResultVO();
										resultvo.setErrno(7);
										resultvo.setErrmsg("同事你好，你的下班卡时间不在使用欢行范围内");
										writeToPage(resultvo);
										return;
									}
									
								}else{
									Date t1 = sdf2.parse(time1);
									Date times=sdf2.parse("22:00:00");
									Date timee=sdf2.parse("23:59:59");
									if(!(t1.before(timee)&&t1.after(times))){
										DidiTicketResultVO resultvo = new DidiTicketResultVO();
										resultvo.setErrno(7);
										resultvo.setErrmsg("同事你好，你的下班卡时间不在使用欢行范围内");
										writeToPage(resultvo);
										return;
									}
								}
								
							}
						}
					}catch(Exception e){
						DidiTicketResultVO resultvo = new DidiTicketResultVO();
						resultvo.setErrno(7);
						resultvo.setErrmsg("下班卡出现异常");
						writeToPage(resultvo);
						return;
					}
					
					
					//排班为离的限制打车，标志：14-离
					try{
						String stateResult = doubtfulExAuditService.queryScheduleState(userId);
						if("14".equals(stateResult)){
							DidiTicketResultVO resultvo = new DidiTicketResultVO();
							resultvo.setErrno(9);
							resultvo.setErrmsg("同事你好,你的排班状态为'离',被限制打车");
							writeToPage(resultvo);
							return;
						}
					}catch(Exception e){
						DidiTicketResultVO resultvo = new DidiTicketResultVO();
						resultvo.setErrno(9);
						resultvo.setErrmsg("排班限制出现异常");
						writeToPage(resultvo);
						return;
					}
					
					//差旅用车限制
					int tcityid = 0;
					if(remark.equals("差旅") && travelCity != null && !travelCity.trim().equals("")){
						String cityname = "";
						if(travelCity.indexOf("省") != -1){
							cityname = travelCity;
						}else{
							cityname = travelCity.substring( (travelCity.indexOf("省")+1) );
							System.out.println(cityname);
						}
						
						List<Integer> cityidlist = didiCitiesService.getCityId(cityname);
						if(cityidlist != null && cityidlist.size() > 0){
							tcityid = cityidlist.get(0);
						}
					}
					//暂时只有营运事业群限制  部门所在地+差旅目的地           cityid>0限制为营运事业群
					if((isSeniorLeader == false) && remark.equals("差旅") && tcityid > 0 && !(tcityid == itemvo.getCity_id()) && cityid > 0){
						logger.info(userId +" 差旅用车必须在出差地：" + tcityid + "当前定位城市" + itemvo.getCity_id());
						DidiTicketResultVO resultvo = new DidiTicketResultVO();
						resultvo.setErrno(4);
						resultvo.setErrmsg(userId +" 差旅用车必须在出差地：" +  tcityid + "当前定位城市" + itemvo.getCity_id());
						writeToPage(resultvo);
						return;
					}
					if((isSeniorLeader == false) && remark.equals("差旅") && startDate.trim() != "" && endDate.trim() != ""){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String nowdate = sdf.format(System.currentTimeMillis());
						
						Date beginTimeDate = sdf.parse( startDate );
						Date endTimeDate = sdf.parse( endDate );
						Date nowtimeTimeDate = sdf.parse( nowdate );
						
						Calendar calendar = new GregorianCalendar();
						calendar.setTime(endTimeDate);
						calendar.add(calendar.DATE, 1);
						endTimeDate = calendar.getTime();
						
						if ( (nowtimeTimeDate.before(endTimeDate))&&(!(nowtimeTimeDate.before(beginTimeDate))) ){ 
							System.out.println("差旅期内");
						}else{
							System.out.println("活动期外");
							logger.info(userId +"不在差旅起始时间内");
							DidiTicketResultVO resultvo = new DidiTicketResultVO();
							resultvo.setErrno(5);
							resultvo.setErrmsg(userId +"不在差旅起始时间内");
							writeToPage(resultvo);
							return;
						}
					}

					
					if (!"0".equals(String.valueOf(itemvo.getCity_id()))) {
						itemvo.setFrom_name(from_name);// 出发地名称
						itemvo.setFlat(flat);// 出发地纬度
						itemvo.setFlng(flng);// 出发地经度
					}
				}else{
					logger.info(userId +"定位失败，获取城市名失败");
				}
				logger.info("组装滴滴发单申请》》》》》》》》》》》匹配城市id结束");
				itemvo.setForbid_city_cross(0);// 是否禁止跨城（出发地和目的地不在同一城市）：0-否，1-是，默认0
                if((isSeniorLeader == false) && !remark.equals("其他公务")){
                	itemvo.setForbid_city_cross(1); //禁止跨城
				}
				itemvo.setRequire_level_list("600");// 允许可选车型，不传则不限制可选车型
				if(remark.equals("加班")){
					itemvo.setRequire_level_list("600,900,100");
				}
				//EmployeeVO empVo = externalMethodService.getEmpInfo(userId);
				if(empVo.getJobLevel().compareTo("10") != -1 && empVo.getJobGroups().equals("管理族群")){
					itemvo.setRequire_level_list("600,900,100,200");
				}else if(empVo.getJobName().contains("秘书") || empVo.getJobName().contains("总裁助理")){
					itemvo.setRequire_level_list("600,900,100,200");
				}
								
				// itemvo.setClat(22f);//当前位置纬度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
				// itemvo.setClng(22f);//当前位置经度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
				itemvo.setRestrict_from_point(0);// 是否限制出发地（0-否，1-是；默认0）
				// itemvo.setRestrict_to_point(0);//是否限制目的地（0-否，1-是；默认0）
				// itemvo.setTo_name("");//目的地名称
				// itemvo.setTlat(22f);//目的地纬度
				// itemvo.setTlng(22f);//目的地经度
				// itemvo.setDeparture_time("2017-09-20 21:00:00");//出发时间，格式：2017-09-20
				// 21:00:00，出发时间大于当前20分钟，发预约单；如果小于20分钟或不传该字段，发实时单。
				itemvo.setEmployee_number(userId);// 员工工号
				// itemvo.setClient_order_id("");//接入方系统的订单ID
				// itemvo.setOrganization("");//用车人组织（所属部门或分公司等）
				// itemvo.setAirport_id(1);//机场ID
				// itemvo.setFlight_number("");//航班号
				// itemvo.setFlight_time("");//航班号
	
				String data = DESHelper4Doc.encrypt(JSON.toJSONString(itemvo,
						SerializerFeature.WriteNullStringAsEmpty), didi_key
						.substring(0, subkey));
				DidiTicketVO vo = new DidiTicketVO();
				vo.setClient_id(didi_client_id);
				vo.setData_encode(data);
				logger.info("组装滴滴发单申请VO结束》》》》》》》》》》》");
				// IHttpClient httpClient = NetUtil.fetchHttpClient();
				String url = didi_didiurl + "ticket/fetch";
				// 请求地址
				// httpClient.setRequestURL(url);
				// 请求
				String json = JSON.toJSONString(vo,
						SerializerFeature.WriteNullStringAsEmpty);
				Pattern p = Pattern.compile("\r|\n");
				Matcher m = p.matcher(json);
				json = m.replaceAll("");
				logger.info(userId + "组装滴滴发单申请请求参数》》》》》》》》》》》" + json);
				result = HttpClientUtil.httpPost(url, json);
				logger.info(userId + "组装滴滴发单申请请求结果》》》》》》》》》》》" + result);
				DidiTicketResultVO resultvo = JSON.parseObject(result,
						DidiTicketResultVO.class);
	
				if (resultvo.getErrno() == 0) {
					Map<String, Object> map = JSON.parseObject(resultvo.getData()
							.toString(), Map.class);
					String webapp = "https://open.es.xiaojukeji.com/webapp/entry?client_id="
							+ didi_client_id + "&ticket=" + map.get("ticket");
					logger.info(userId + "滴滴webbapp入口url》》》》》》》》》》》" + webapp);
					resultvo.setData(webapp);
					DidiTicketEntity diditicketentity = new DidiTicketEntity();
					diditicketentity.setOrderId((String) map.get("order_id"));// 订单号
					DidiTicketEntity entity1 = didiTicketService
							.find(diditicketentity);
					diditicketentity.setDept(userDepartment);// 部门
					diditicketentity.setUserid(userId);// 工号
					diditicketentity.setFinancedept(userFinance);// 财务部门
					diditicketentity.setUsername(userName);// 名称
					diditicketentity.setUsertel(userTel);// 电话
					diditicketentity.setRemark(remark);//
					diditicketentity.setRemarkinfo(remarkinfo);//
					diditicketentity.setCompany(userCompany);//
					//add by gwl 20180302
					diditicketentity.setCustomname(customname);//客户名称：customname
					diditicketentity.setCustomtel(customtel);//客户手机号：customtel
					diditicketentity.setCustomcode(customcode);//客户编码：customcode
					
//					111存图片名称
					if(meetingpic != null && !("null".equals(meetingpic)) && !("".equals(meetingpic))){
						diditicketentity.setMeetingname(getvalue("meetingpic[]"));//日程会议名称：meetingname
					}else{
						diditicketentity.setMeetingname(meetingname);//日程会议名称：meetingname
					}
					diditicketentity.setFrommanagercode(frommanagercode);//出发部门负责人工号：frommanagercode
					diditicketentity.setFrommanagername(frommanagername);//出发部门负责人姓名：frommanagername
					diditicketentity.setTomanagercode(tomanagercode);//目的部门负责人工号：tomanagercode
					diditicketentity.setTomanagername(tomanagername);//目的部门负责人姓名：tomanagername
					diditicketentity.setAuditorcode(auditorcode);//其他公务审核人工号：auditorcode
					diditicketentity.setJoblevel(joblevel);//其他公务审核人级别：joblevel
					diditicketentity.setAuditorname(auditorname);//其他公务审核人姓名：auditorname
					diditicketentity.setBankcardnum(bankcardnum);//银行卡号：bankcardnum
					diditicketentity.setNewmeetingend(newmeetingend);
					diditicketentity.setNewmeetingname(newmeetingname);
					diditicketentity.setNewmeetingstart(newmeetingstart);
					
					diditicketentity.setTravelWorkflowNo(travelWorkflowNo);//差旅工作流号
					
					diditicketentity.setRemoteAddr(ServletActionContext.getRequest().getRemoteAddr());//真实ip
					
					logger.info("<<<<<<<<<<<新增ticket添加用户头像>>>>>>>>>>>");
					List<EmployeeVO> employeeList = externalMethodService.getEmpInfolist(userId);
					if(employeeList != null &&employeeList.size()>0){
						diditicketentity.setUserheadpic(employeeList.get(0).getHeadPhoto());//用户头像
					}
					logger.info("<<<<<<<<<<<新增ticket添加用户头像结束>>>>>>>>>>>");
					
					//end by gwl
					diditicketentity.setFlag(0);//
					diditicketentity.setTicket((String) map.get("ticket"));// ticket
					if (entity1 == null) {
						didiTicketService.insert(diditicketentity);
					} else {
						diditicketentity.setId(entity1.getId());
						didiTicketService.update(diditicketentity);
					}
	
				}
				// 获取返回的结果
				logger.info("获取滴滴发单申请结束》》》》》》》》》》》");
				// 传入前端
				writeToPage(resultvo);
			} catch (Exception e) {
				logger.error(userId + "获取滴滴发单申请出现异常>>>>>>>>>" + e.getMessage());
				DidiTicketResultVO resultvo = new DidiTicketResultVO();
				resultvo.setErrno(1);
				resultvo.setErrmsg("请求滴滴失败，请退出或重新进入移动办公试试。PS：记得更新欢行和移动办公到最新版，打车异常请联系移动BI研发部 ");
				writeToPage(resultvo);
			}
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserFinance() {
		return userFinance;
	}

	public void setUserFinance(String userFinance) {
		this.userFinance = userFinance;
	}

	public String getDidi_client_id() {
		return didi_client_id;
	}

	public void setDidi_client_id(String didi_client_id) {
		this.didi_client_id = didi_client_id;
	}

	public String getDidi_client_secret() {
		return didi_client_secret;
	}

	public void setDidi_client_secret(String didi_client_secret) {
		this.didi_client_secret = didi_client_secret;
	}

	public String getDidi_key() {
		return didi_key;
	}

	public void setDidi_key(String didi_key) {
		this.didi_key = didi_key;
	}

	public String getDidi_pubiphone() {
		return didi_pubiphone;
	}

	public void setDidi_pubiphone(String didi_pubiphone) {
		this.didi_pubiphone = didi_pubiphone;
	}

	public String getDidi_didiurl() {
		return didi_didiurl;
	}

	public void setDidi_didiurl(String didi_didiurl) {
		this.didi_didiurl = didi_didiurl;
	}

	public String getCarAuthority() {
		return carAuthority;
	}

	public void setCarAuthority(String carAuthority) {
		this.carAuthority = carAuthority;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkinfo() {
		return remarkinfo;
	}

	public void setRemarkinfo(String remarkinfo) {
		this.remarkinfo = remarkinfo;
	}

	public IDidiTicketService getDidiTicketService() {
		return didiTicketService;
	}

	public void setDidiTicketService(IDidiTicketService didiTicketService) {
		this.didiTicketService = didiTicketService;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}

	public void setFlat(float flat) {
		this.flat = flat;
	}

	public void setFlng(float flng) {
		this.flng = flng;
	}

	public void setDidiCitiesService(IDidiCitiesService didiCitiesService) {
		this.didiCitiesService = didiCitiesService;
	}

	/**
	 * @return the customname
	 */
	public String getCustomname() {
		return customname;
	}

	/**
	 * @param customname the customname to set
	 */
	public void setCustomname(String customname) {
		this.customname = customname;
	}

	/**
	 * @return the bankcardnum
	 */
	public String getBankcardnum() {
		return bankcardnum;
	}

	/**
	 * @param bankcardnum the bankcardnum to set
	 */
	public void setBankcardnum(String bankcardnum) {
		this.bankcardnum = bankcardnum;
	}

	/**
	 * @return the customtel
	 */
	public String getCustomtel() {
		return customtel;
	}

	/**
	 * @param customtel the customtel to set
	 */
	public void setCustomtel(String customtel) {
		this.customtel = customtel;
	}

	/**
	 * @return the customcode
	 */
	public String getCustomcode() {
		return customcode;
	}

	/**
	 * @param customcode the customcode to set
	 */
	public void setCustomcode(String customcode) {
		this.customcode = customcode;
	}

	/**
	 * @return the meetingname
	 */
	public String getMeetingname() {
		return meetingname;
	}

	/**
	 * @param meetingname the meetingname to set
	 */
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	/**
	 * @return the frommanagername
	 */
	public String getFrommanagername() {
		return frommanagername;
	}

	/**
	 * @param frommanagername the frommanagername to set
	 */
	public void setFrommanagername(String frommanagername) {
		this.frommanagername = frommanagername;
	}

	/**
	 * @return the tomanagername
	 */
	public String getTomanagername() {
		return tomanagername;
	}

	/**
	 * @param tomanagername the tomanagername to set
	 */
	public void setTomanagername(String tomanagername) {
		this.tomanagername = tomanagername;
	}

	/**
	 * @return the tomanagercode
	 */
	public String getTomanagercode() {
		return tomanagercode;
	}

	/**
	 * @param tomanagercode the tomanagercode to set
	 */
	public void setTomanagercode(String tomanagercode) {
		this.tomanagercode = tomanagercode;
	}

	/**
	 * @return the frommanagercode
	 */
	public String getFrommanagercode() {
		return frommanagercode;
	}

	/**
	 * @param frommanagercode the frommanagercode to set
	 */
	public void setFrommanagercode(String frommanagercode) {
		this.frommanagercode = frommanagercode;
	}

	/**
	 * @return the auditorcode
	 */
	public String getAuditorcode() {
		return auditorcode;
	}

	/**
	 * @param auditorcode the auditorcode to set
	 */
	public void setAuditorcode(String auditorcode) {
		this.auditorcode = auditorcode;
	}

	/**
	 * @return the auditorname
	 */
	public String getAuditorname() {
		return auditorname;
	}

	/**
	 * @param auditorname the auditorname to set
	 */
	public void setAuditorname(String auditorname) {
		this.auditorname = auditorname;
	}

	/**
	 * @return the userheadpic
	 */
	public String getUserheadpic() {
		return userheadpic;
	}

	/**
	 * @param userheadpic the userheadpic to set
	 */
	public void setUserheadpic(String userheadpic) {
		this.userheadpic = userheadpic;
	}

	public String getMeetingpic() {
		return meetingpic;
	}

	public void setMeetingpic(String meetingpic) {
		this.meetingpic = meetingpic;
	}
	
	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}

	/**
	 * @return the joblevel
	 */
	public String getJoblevel() {
		return joblevel;
	}

	/**
	 * @param joblevel the joblevel to set
	 */
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	/**
	 * 生成图片名称，存入会议名称字段
	 */
	public String getvalue(String key) {
		Object[] values;
		String value="";
		HttpServletRequest request = ServletActionContext.getRequest();
		if(key == "meetingpic[]"){
			values = (Object[]) request.getParameterMap().get("meetingpic[]");
		}else{
			values = (Object[]) request.getParameterMap().get(key);
		}
		try{
			if(values != null){
				if(values.length!=0){
					if("meetingpic[]".equals(key)){
						for(int i=0;i<values.length;i++){
							//前台获取image
							String recordpic = values[i].toString();//
							//得到文件格式
							String spcode = recordpic.substring(recordpic.lastIndexOf("."));
//							//去掉后缀
							String imagecode = recordpic.substring(0,recordpic.lastIndexOf("."));
							StringBuilder sb = new StringBuilder();
							// 文件名用UUID防止重复
							sb.append(UUID.randomUUID().toString());
							//文件名fileName
							String fileName = sb.toString()+spcode;
							byte[] buffer = new BASE64Decoder().decodeBuffer(imagecode.replaceAll("(?s)'.*'", "").replaceAll(" ", "+"));
							OutputStream out = null;
							out = new FileOutputStream(new File(filePath,fileName));
							out.write(buffer);
							if(i == values.length-1){
								value = value + fileName;
							}else{
								value = value + fileName+",";
							}
						}
					
					}else{
						value = String.valueOf(values[0]);
					}
				}
				}
		}catch (Exception e) {
			logger.info("保存图片发生错误>>>>>>>>>" + e.getMessage());
		}finally{
			
		}
		return value;
	}
	
	//根据经纬度获取城市
	/*public static String getAdd(String log, String lat ){  
    	//lat 小  log  大  
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项) 
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";  
        String res = "";     
        try {     
            URL url = new URL(urlString);    
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
            conn.setDoOutput(true);    
            conn.setRequestMethod("POST");    
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
            String line;    
           while ((line = in.readLine()) != null) {    
               res += line+"\n";    
         }    
            in.close();    
        } catch (Exception e) {    
            System.out.println("error in wapaction,and e is " + e.getMessage());    
        }   
        System.out.println(res);  
        return res;    
    }*/


	/**
	 * @return the newmeetingname
	 */
	public String getNewmeetingname() {
		return newmeetingname;
	}

	/**
	 * @return the newmeetingstart
	 */
	public String getNewmeetingstart() {
		return newmeetingstart;
	}

	/**
	 * @return the newmeetingend
	 */
	public String getNewmeetingend() {
		return newmeetingend;
	}

	/**
	 * @param newmeetingname the newmeetingname to set
	 */
	public void setNewmeetingname(String newmeetingname) {
		this.newmeetingname = newmeetingname;
	}

	/**
	 * @param newmeetingstart the newmeetingstart to set
	 */
	public void setNewmeetingstart(String newmeetingstart) {
		this.newmeetingstart = newmeetingstart;
	}

	/**
	 * @param newmeetingend the newmeetingend to set
	 */
	public void setNewmeetingend(String newmeetingend) {
		this.newmeetingend = newmeetingend;
	}

	public String getTravelWorkflowNo() {
		return travelWorkflowNo;
	}

	public void setTravelWorkflowNo(String travelWorkflowNo) {
		this.travelWorkflowNo = travelWorkflowNo;
	}

	public String getTravelCity() {
		return travelCity;
	}

	public void setTravelCity(String travelCity) {
		this.travelCity = travelCity;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public IDepositorService getDepositorService() {
		return depositorService;
	}

	public void setDepositorService(IDepositorService depositorService) {
		this.depositorService = depositorService;
	}

	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}

	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}

	public String getAttendanceUrl() {
		return attendanceUrl;
	}

	public void setAttendanceUrl(String attendanceUrl) {
		this.attendanceUrl = attendanceUrl;
	}

	
	
	
}
