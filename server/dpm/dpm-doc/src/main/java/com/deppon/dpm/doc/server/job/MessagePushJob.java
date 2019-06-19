package com.deppon.dpm.doc.server.job;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.entity.QueryRquestBudgetEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.service.ISendWechartOfficialService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.anps.server.job.NoticeMessageJob;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;


public class MessagePushJob {
	
	// 预算查询url地址
	private String budgetqryurl;
	
	private IAddMessageService addmessageservice;

	// 推送消息服务
	private IJPushNewService jPushNewService;
	
	private static final Logger LOG = LoggerFactory.getLogger(MessagePushJob.class);
	
	private ISendWechartOfficialService sendWechartOfficialService;

	/**
	 * 定时任务：每天10,14,16点推送预算不足通知
	 */
	public void execute() {
		
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
		
		// 获取主机地址
		//String hostAddress = address.getHostAddress();
			
		String hostAddress = this.getHostIp();
		System.out.println(hostAddress);
		LOG.info("服务器ip：" + hostAddress);
		if (hostAddress.equals("10.249.5.99")) {
			/*10.249.5.99*/
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;
        int today = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int hour = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        
        System.out.println("定时推送预算开始..."+ month + today + hour);
        LOG.info("定时推送预算开始..."+ month + today + hour  + "____月日时");
        
        //从数据库中查询该时间是否有待推送消息
        List<QueryResponseBudgetEntity> qrEntity = addmessageservice.
        		getMessagePush((month+""), (today+""), (hour+""), "on");
       
        //循环查询此时的预算余额
        for(QueryResponseBudgetEntity qr : qrEntity){
        	
        	LOG.info(month + today + hour  + "有待推送消息");
        	QueryRquestBudgetEntity queryentity = new QueryRquestBudgetEntity();
        	queryentity.setEmpCode(qr.getEmpCode());
        	String json = JSON.toJSONString(queryentity,SerializerFeature.WriteNullStringAsEmpty);
        	
        	// 调用预算查询接口
        	String queryresults = "";
        	try {
				queryresults = HttpClientUtil.httpPost(budgetqryurl, json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        	//queryresults = "{\"deptCode\":\"DP20575\",\"deptName\":\"大数据研发中心\",\"empCode\":\"245102\",\"failReason\":\"\",\"isSuccess\":\"y\",\"leftAmount\":1700,\"subCom\":\"上海德启信息科技有限公司\",\"subComCode\":\"SQZ0000\",\"thisMonthAmount\":42700,\"toDayAmount\":39}";
			
        	// 预算数据加工
        	QueryResponseBudgetEntity queryresultentity = JSON.parseObject(
        			queryresults, QueryResponseBudgetEntity.class);
        	BigDecimal leftAmount = queryresultentity.getLeftAmount();

        	//保证员工部门没变
        	if(queryresultentity.getDeptCode().equals(qr.getDeptCode())){
        	
        		List<String> orgidList = addmessageservice.queryOrgId(queryresultentity.getDeptCode());

        		//推送消息
        		if (orgidList != null) {
        			
        			LOG.info(month + today + hour  + "准备推送消息");

        			BigDecimal leftmny = queryresultentity.getLeftAmount() == null ? new BigDecimal(
        					0) : queryresultentity.getLeftAmount();
        			BigDecimal monthmny = queryresultentity.getThisMonthAmount() == null ? new BigDecimal(
        							0) : queryresultentity.getThisMonthAmount();
        			BigDecimal mnybf = leftmny.divide(leftmny.add(monthmny), 2, BigDecimal.ROUND_HALF_UP);

        			// 根据部门查询出所有用户 不包含大于8的管理族群   
        			//先判断是否包含C D 10 , 如果包含，则只给该部门直属人员推送消息
        			List<EmployeeEntity> entityGGList = addmessageservice.queryGGuserId(orgidList.get(0));
        			List<EmployeeEntity> entityList = new ArrayList<EmployeeEntity>();
        			if(entityGGList != null && entityGGList.size() > 0){
        				entityList = addmessageservice.queryOrguserId(orgidList.get(0));
        			}else{
        				entityList = addmessageservice.queryAlluserId(orgidList.get(0));
        			}     			
        			//List<EmployeeEntity> entityList = addmessageservice.queryAlluserId(orgidList.get(0));
        			List<String> userIdList = new ArrayList<String>();
        			for (EmployeeEntity temp : entityList) {
        				if (temp.getEmpCode() != null) {
        					userIdList.add(temp.getEmpCode());
        				}
        			}
        			StringBuffer usercodes = new StringBuffer();
        			for (String temp : userIdList) {
        				usercodes.append(temp + ",");
        			}

        			// 如果预算小于20%，提示部门领导调整预算
        			if (mnybf.compareTo(new BigDecimal(0.2)) <= 0 && leftmny.compareTo(BigDecimal.ZERO) > 0) {

        				JPushParam paramuser = new JPushParam();
        				paramuser.setAlert("截止" + month + "月" + today + "日，您所属成本中心"
        						+ queryresultentity.getDeptName() + "的交通费预算为"
        						+ leftmny + "，已不足20%，请联系部门负责人或对应预算专员及时调整！");// 消息弹出的内容
        				paramuser.setContent("截止" + month + "月" + today + "日，您所属成本中心"
        						+ queryresultentity.getDeptName() + "的交通费预算为"
        						+ leftmny + "，已不足20%，请协调部门领导或对应预算专员及时调整！");
        				paramuser.setUserIds(usercodes.substring(0,usercodes.length() - 1));
        				//paramuser.setUserIds("245102,275309,274727");
        				// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
        				paramuser.setLinktype(2);
        				paramuser.setLinkaddr("app_package/doc/index.html");
        				paramuser.getExtras().put("toNews", "true");

        				/*try {
        					jPushNewService.pushByUserIds(paramuser);
        				} catch (APIConnectionException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				} catch (APIRequestException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}*/
        				LOG.info(month + today + hour  + "预算不足20%系统推送消息");
        				//预算推送状态改为off
        				int n = addmessageservice.
        						updatePushStatus((month+""), (today+""), (hour+""), queryresultentity.getDeptCode());
        				
        				
        				
        				//欢行消息中心
        				SimpleDateFormat sdf = new SimpleDateFormat(
    							"yyyy-MM-dd HH:mm:ss");
    					String ufdate = sdf.format(System.currentTimeMillis());
    					String month1 = ufdate.substring(5, 7);
    					String day1 = ufdate.substring(8, 10);
    					
    					List<PushMessageVO> addVOListUser = new ArrayList<PushMessageVO>();
    					for (String temp : userIdList) {
    						PushMessageVO pushmessagevo = new PushMessageVO();
    						pushmessagevo.setDept(Integer.valueOf("123"));
    						pushmessagevo.setUserid(temp);
    						pushmessagevo.setState("0");
    						pushmessagevo.setMessage("截止" + month1 + "月" + day1
    								+ "日，您所属成本中心" + queryresultentity.getDeptName()
    								+ "的交通费预算为" + leftmny
    								+ "，已不足20%，请协调部门领导或对应预算专员及时调整！");// 消息弹出的内容
    						pushmessagevo.setMsgtitle("部门预算余额提醒");
    						addVOListUser.add(pushmessagevo);
    						String str = sendWechartOfficialService.sendWechartOfficial("截止" + month1 + "月" + day1
    								+ "日，您所属成本中心" + queryresultentity.getDeptName()
    								+ "的交通费预算为" + leftmny
    								+ "，已不足20%，请协调部门领导或对应预算专员及时调整！",temp);
    						LOG.info("截止" + month1 + "月" + day1
    								+ "日，您所属成本中心" + queryresultentity.getDeptName()
    								+ "的交通费预算为" + leftmny
    								+ "，已不足20%，请协调部门领导或对应预算专员及时调整！"+temp);
    						LOG.info("企业微信发送结果>>>>>>" + str);
    					}
    					addmessageservice.insertRemind(addVOListUser);
    					LOG.info(month + today + hour  + "预算不足20%消息通知提醒");
        			}	

        			// 判断余额是否小于0，小于0推送消息
        			if (leftAmount != null
        					&& leftAmount.compareTo(BigDecimal.ZERO) <= 0) {
        				// 推送消息
        				if (usercodes != null && usercodes.length() > 0) {

        					JPushParam param = new JPushParam();
        					param.setAlert("截止" + month + "月" + today + "日，您所属成本中心"
        							+ queryresultentity.getDeptName() + "的交通费预算为"
        							+ leftmny + "，请联系部门负责人或对应预算专员及时处理！");// 消息弹出的内容
        					param.setContent("截止" + month + "月" + today + "日，您所属成本中心"
        							+ queryresultentity.getDeptName() + "的交通费预算为"
        							+ leftmny + "，请联系部门负责人或对应预算专员及时处理！");
        					param.setUserIds(usercodes.substring(0,usercodes.length() - 1));
        					//param.setUserIds("245102,275309,274727");
        					// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
        					param.setLinktype(2);
        					param.getExtras().put("toNews", "true");
        					param.setLinkaddr("app_package/doc/index.html");
        					//try {
        					//	jPushNewService.pushByUserIds(param);
        						LOG.info("企业微信发送开始>>>>>>");
        						String str = sendWechartOfficialService.sendWechartOfficial("截止" + month + "月" + today + "日，您所属成本中心"
            							+ queryresultentity.getDeptName() + "的交通费预算为"
            							+ leftmny + "，请联系部门负责人或对应预算专员及时处理！",usercodes.substring(0,usercodes.length() - 1));
        						LOG.info("截止" + month + "月" + today + "日，您所属成本中心"
            							+ queryresultentity.getDeptName() + "的交通费预算为"
            							+ leftmny + "，请联系部门负责人或对应预算专员及时处理！"+usercodes.substring(0,usercodes.length() - 1));
        						LOG.info("企业微信发送结果>>>>>>" + str);
        						LOG.info(month + today + hour  + "预算不足0%系统推送消息");
        					//} catch (APIConnectionException e) {
        						// TODO Auto-generated catch block
        					//	e.printStackTrace();
        					//} catch (APIRequestException e) {
        						// TODO Auto-generated catch block
        					//	e.printStackTrace();
        					//}
        					//欢行消息中心
        					addmessageservice.insert(userIdList,
    								queryresultentity.getDeptCode());
        					for(String temp : userIdList){
        						PushMessageVO pushmessagevo = new PushMessageVO();
        						pushmessagevo.setDept(Integer.valueOf("123"));
        						pushmessagevo.setUserid(temp);
        						pushmessagevo.setState("0");
        						pushmessagevo.setMessage("您好,您当月部门预算余额已用完,无法进行打车。");
        						String str1 = sendWechartOfficialService.sendWechartOfficial("您好,您当月部门预算余额已用完,无法进行打车。",temp);
        						LOG.info("您好,您当月部门预算余额已用完,无法进行打车。"+temp);
        						LOG.info("企业微信发送结果>>>>>>" + str1);
        					}
        					LOG.info(month + today + hour  + "预算不足0%消息通知提醒");
        				}		
        				
        				//预算推送状态改为off
        				int n = addmessageservice.
                				updatePushStatus((month+""), (today+""), (hour+""), queryresultentity.getDeptCode());
        			}

        		}
        	
            }
			
	    }
        System.out.println("定时推送预算结束...");
        LOG.info("定时推送预算结束...");

    }
	} catch (Exception e) {
		LOG.error("定时推送预算余额不足通知出错!!!", e);
	}
	LOG.info("定时推送预算余额不足通知成功");
		
	}
	
	private String getHostIp(){
		try{
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()){
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()){
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null 
							&& ip instanceof Inet4Address
                    		&& !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                    		&& ip.getHostAddress().indexOf(":") == -1){
						System.out.println("本机的IP = " + ip.getHostAddress());
						LOG.info("本机的IP = " + ip.getHostAddress());
						return ip.getHostAddress();
					} 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public IAddMessageService getAddmessageservice() {
		return addmessageservice;
	}

	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}

	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	public String getBudgetqryurl() {
		return budgetqryurl;
	}

	public void setBudgetqryurl(String budgetqryurl) {
		this.budgetqryurl = budgetqryurl;
	}

	public ISendWechartOfficialService getSendWechartOfficialService() {
		return sendWechartOfficialService;
	}

	public void setSendWechartOfficialService(
			ISendWechartOfficialService sendWechartOfficialService) {
		this.sendWechartOfficialService = sendWechartOfficialService;
	}
	
	
}
