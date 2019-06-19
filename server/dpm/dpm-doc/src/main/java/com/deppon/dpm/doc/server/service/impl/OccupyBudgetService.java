package com.deppon.dpm.doc.server.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.DDOrderRequestEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetResponseEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetRquestEntity;
import com.deppon.dpm.doc.server.entity.QueryResponseBudgetEntity;
import com.deppon.dpm.doc.server.entity.QueryRquestBudgetEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.service.IOccupyBudgetService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.common.server.action.AppToUseTimeMonitorAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;

/**
 * 预算暂用实现类
 * @author wanc
 * 20171128
 */
/**
 * @author admin
 *
 */
/**
 * @author Administrator
 * 
 */
public class OccupyBudgetService implements IOccupyBudgetService {

	private static final Logger LOG = LoggerFactory
			.getLogger(AppToUseTimeMonitorAction.class);

	// 更新预算接口url地址
	private String budgetupdurl;
	// 预算查询url地址
	private String budgetqryurl;
	// 更新预算凭证url地址
	private String respcertifurl;

	private IAddMessageService addmessageservice;

	// 推送消息服务
	private IJPushNewService jPushNewService;

	private RedisService redisService;
	
	private static int zero = 0;
	private static int ten = 10;
	private static int fourteen = 14;
	private static int sixteen = 16;

	/**
	 * 构造方法
	 */
	public OccupyBudgetService() {
		super();
	}

	/**
	 * 预算占用更新方法
	 */
	@Override
	public OccupyBudgetResponseEntity updateBudget(
			OccupyBudgetRquestEntity rqentity) {
		// 转换为json字符串
		String json = JSON.toJSONString(rqentity,
				SerializerFeature.WriteNullStringAsEmpty);
		// 替换特殊字符
		Pattern p = Pattern.compile("\r|\n");
		Matcher m = p.matcher(json);
		json = m.replaceAll("");
		LOG.info("didi_预算更新接口请求参数" + json);
		try {
			// 调用预算更新接口
			String resultstr = HttpClientUtil.httpPost(budgetupdurl, json);
			LOG.info("didi_预算更新接口返回参数" + resultstr);
			// 重新查询预算，检验是否还有余额
			// OccupyBudgetResponseEntity resentity =
			// JSON.parseObject(resultstr, OccupyBudgetResponseEntity.class);

			return JSON
					.parseObject(resultstr, OccupyBudgetResponseEntity.class);

		} catch (Exception e) {
			LOG.info("didi_预算更新接口出错" + e.getMessage());
		}
		return null;
	}

	public void pushMessageMethord(OccupyBudgetRquestEntity rqentity) {
		
		String code = redisService.get(RedisService.DPM_SMS_DIDI_DOC_KEY
				+ rqentity.getBusinessId());
		if(code != null){
			return;
		}
		try {
			// 转换为json字符串
			String json = JSON.toJSONString(rqentity,SerializerFeature.WriteNullStringAsEmpty);
			// 查询员工所属部门预算数据
			QueryRquestBudgetEntity queryentity = new QueryRquestBudgetEntity();
			queryentity.setEmpCode(rqentity.getEmpCode());

			String json1 = JSON.toJSONString(queryentity,SerializerFeature.WriteNullStringAsEmpty);
			// 替换掉特殊字符
			Pattern p1 = Pattern.compile("\r|\n");
			Matcher m1 = p1.matcher(json);
			json1 = m1.replaceAll("");
			// 调用预算查询接口
			String queryresults;
 
			queryresults = HttpClientUtil.httpPost(budgetqryurl, json1);
			//queryresults = "{\"deptCode\":\"DP20575\",\"deptName\":\"大数据研发中心\",\"empCode\":\"245102\",\"failReason\":\"\",\"isSuccess\":\"y\",\"leftAmount\":1700,\"subCom\":\"上海德启信息科技有限公司\",\"subComCode\":\"SQZ0000\",\"thisMonthAmount\":42700,\"toDayAmount\":39}";
			// 预算数据加工
			QueryResponseBudgetEntity queryresultentity = JSON.parseObject(
					queryresults, QueryResponseBudgetEntity.class);
			BigDecimal leftAmount = queryresultentity.getLeftAmount();

			List<String> orgidList = addmessageservice
					.queryOrgId(queryresultentity.getDeptCode());
			
			if (orgidList != null) {

				BigDecimal leftmny = queryresultentity.getLeftAmount() == null ? new BigDecimal(
						0) : queryresultentity.getLeftAmount();
				BigDecimal monthmny = queryresultentity.getThisMonthAmount() == null ? new BigDecimal(
						0) : queryresultentity.getThisMonthAmount();
				BigDecimal mnybf = leftmny.divide(leftmny.add(monthmny), 2, BigDecimal.ROUND_HALF_UP);
 
				// 根据部门查询出所有用户 不包含大于8的管理族群
				List<EmployeeEntity> entityList = addmessageservice
						.queryAlluserId(orgidList.get(0));
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

				//本月剩余天数
				Calendar c = Calendar.getInstance();
				int month1 = c.get(Calendar.MONTH) + 1;
		        int today = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
		        int lastday = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
		        int hour = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
		        
		        //标记是否需要推送存表
		        int mark = 1;
		        //1.预算小于20%
				if (mnybf.compareTo(new BigDecimal(0.2)) <= 0) {
					 //当月剩余天数 （大于5天按点推送）
					if((lastday - today + 1) <= 5){
						//当月剩余时间<=5天
						if((lastday - today + 1) >= 4 && (lastday - today + 1) <= 5){
							//当月剩余时间在4-5天
							if(!(mnybf.compareTo(new BigDecimal(0.15)) < 0)){
								//预算>=15%时不推送
								mark = 0;
							}
						}else if((lastday - today + 1) >= 2 && (lastday - today + 1) < 4){
							//当月剩余时间在2-3天
							if(!(mnybf.compareTo(new BigDecimal(0.10)) < 0)){
								//预算>=10%时不推送
								mark = 0;
							}
						}else{
							//当月剩余时间在1天内
							if(!(mnybf.compareTo(new BigDecimal(0.1)) < 0.05)){
								//预算>=5%时不推送
								mark = 0;
							}
							if(hour >= 16){
								//最后一天16点后不推
								mark = 0;
							}
						}		
					}
					//符合推送条件
					if(mark == 1){
						//封装推送信息
				        QueryResponseBudgetEntity qrEntity = new QueryResponseBudgetEntity();
				        qrEntity.setMonth(month1 + "");
				        qrEntity.setDay(today + "");
				        //当月剩余天数>5天
						if(ten <= hour && hour < fourteen){
							//14点整推消息
							qrEntity.setHour("14");
						}else if(fourteen <= hour && hour < sixteen){
							//16点整推消息
							qrEntity.setHour("16");
						}else if(hour < ten){
							//10点整推消息
							qrEntity.setHour("10");
						}else{
							//第二天10天推消息  (月末一天16点后不推)
							if(today != lastday){
								qrEntity.setDay((today+1) + "");
								qrEntity.setHour("10");
							}
						}
						qrEntity.setStatus("on");
						qrEntity.setDeptCode(queryresultentity.getDeptCode());
						qrEntity.setDeptName(queryresultentity.getDeptName());
						qrEntity.setPercent(mnybf);
						qrEntity.setLeftAmount(leftmny);
						qrEntity.setEmpCode(rqentity.getEmpCode());
						//存表
						addmessageservice.insertMessagePush(qrEntity);
						
						//加缓存，判断此时间段是否有插入
						//部门+时间
						
						
						
						
						
					}

				}

				// 如果预算小于20%，提示部门领导调整预算
				/*if (mnybf.compareTo(new BigDecimal(0.2)) <= 0) {

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String ufdate = sdf.format(System.currentTimeMillis());
					String month = ufdate.substring(5, 7);
					String day = ufdate.substring(8, 10);

					// 推送消息员工
					JPushParam paramuser = new JPushParam();
					paramuser.setAlert("截止" + month + "月" + day + "日，您所属成本中心"
							+ queryresultentity.getDeptName() + "的交通费预算为"
							+ leftmny + "，已不足20%，请联系部门负责人或对应预算专员及时调整！");// 消息弹出的内容
					paramuser.setContent("截止" + month + "月" + day + "日，您所属成本中心"
							+ queryresultentity.getDeptName() + "的交通费预算为"
							+ leftmny + "，已不足20%，请协调部门领导或对应预算专员及时调整！");
					paramuser.setUserIds(usercodes.substring(0,
							usercodes.length() - 1));
					// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
					paramuser.setLinktype(2);
					paramuser.setLinkaddr("app_package/doc/index.html");
					paramuser.getExtras().put("toNews", "true");
					List<PushMessageVO> addVOListUser = new ArrayList<PushMessageVO>();
					for (String temp : userIdList) {
						PushMessageVO pushmessagevo = new PushMessageVO();
						pushmessagevo.setDept(Integer.valueOf("123"));
						pushmessagevo.setUserid(temp);
						pushmessagevo.setState("0");
						pushmessagevo.setMessage("截止" + month + "月" + day
								+ "日，您所属成本中心" + queryresultentity.getDeptName()
								+ "的交通费预算为" + leftmny
								+ "，已不足20%，请协调部门领导或对应预算专员及时调整！");// 消息弹出的内容
						pushmessagevo.setMsgtitle("部门预算余额提醒");
						addVOListUser.add(pushmessagevo);
					}
					addmessageservice.insertRemind(addVOListUser);

					//jPushNewService.pushByUserIds(paramuser);
				}*/

				// 判断余额是否小于0，小于0推送消息
				/*if (leftAmount != null
						&& leftAmount.compareTo(BigDecimal.ZERO) <= 0) {
					// 推送消息
					if (usercodes != null && usercodes.length() > 0) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						String ufdate = sdf.format(System.currentTimeMillis());
						String month = ufdate.substring(5, 7);
						String day = ufdate.substring(8, 10);

						JPushParam param = new JPushParam();
						param.setAlert("截止" + month + "月" + day + "日，您所属成本中心"
								+ queryresultentity.getDeptName() + "的交通费预算为"
								+ leftmny + "，请联系部门负责人或对应预算专员及时处理！");// 消息弹出的内容
						param.setContent("截止" + month + "月" + day + "日，您所属成本中心"
								+ queryresultentity.getDeptName() + "的交通费预算为"
								+ leftmny + "，请联系部门负责人或对应预算专员及时处理！");
						param.setUserIds(usercodes.substring(0,
								usercodes.length() - 1));
						// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
						param.setLinktype(2);
						param.getExtras().put("toNews", "true");
						param.setLinkaddr("app_package/doc/index.html");
						jPushNewService.pushByUserIds(param);
						addmessageservice.insert(userIdList,
								queryresultentity.getDeptCode());
					}
				}*/
				
			}
		} catch (Exception e) {
			LOG.info("预算余额不足提醒出错》》》》》》》》》" + e.getMessage());
		}
		redisService.set(RedisService.DPM_SMS_DIDI_DOC_KEY+rqentity.getBusinessId(), rqentity.getBusinessId(), 86400);

	}

	/**
	 * 无应答订单凭证更新
	 */
	@Override
	public OccupyBudgetResponseEntity noRespCertif(DDOrderRequestEntity rqentity) {
		// 转换为json字符串
		String json = JSON.toJSONString(rqentity,
				SerializerFeature.WriteNullStringAsEmpty);
		// 替换特殊字符
		Pattern p = Pattern.compile("\r|\n");
		Matcher m = p.matcher(json);
		json = m.replaceAll("");
		LOG.info("didi_预算无应答订单凭证更新请求串" + json);
		// 调用凭证更新接口
		try {
			String resultstr = HttpClientUtil.httpPost(respcertifurl, json);
			LOG.info("didi_预算无应答订单凭证更新返回串" + resultstr);
			return JSON
					.parseObject(resultstr, OccupyBudgetResponseEntity.class);
		} catch (IOException e) {
			LOG.info("didi_预算无应答订单凭证更新出错" + e.getMessage());
			LOG.debug(e.getMessage());
		}
		return null;
	}

	public void setBudgetupdurl(String budgetupdurl) {
		this.budgetupdurl = budgetupdurl;
	}

	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}

	public void setBudgetqryurl(String budgetqryurl) {
		this.budgetqryurl = budgetqryurl;
	}

	public void setRespcertifurl(String respcertifurl) {
		this.respcertifurl = respcertifurl;
	}

	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	/**
	 * @return the redisService
	 */
	public RedisService getRedisService() {
		return redisService;
	}

	/**
	 * @param redisService
	 *            the redisService to set
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

}
