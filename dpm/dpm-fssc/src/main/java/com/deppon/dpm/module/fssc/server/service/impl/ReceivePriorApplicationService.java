
package com.deppon.dpm.module.fssc.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.fssc.server.dao.IPriorApplicationDao;
import com.deppon.dpm.module.fssc.shared.domain.DetailInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.FlightOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.HotelOrderInfoEntity;
import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgProcessReult;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgResponse;
import com.deppon.foss.module.sync.esb.process.IProcess;

public class ReceivePriorApplicationService implements
IProcess {
	//private static final String ESB_CODE_Travel_Assistant="TRAVEL_ESB2TRAVEL_ORG_NAV_LINK_QUERY";
	/**
	 * 提交暂存url
	 */
	private String synUrl;
	
	private static Logger logger = Logger
			.getLogger(ReceivePriorApplicationService.class);
	/**
	 *  dao的注入
	 */
	@Resource
	private IPriorApplicationDao iaDao;
	/**
	 * tpushNewsService 注入
	 */
	@Resource
	private TpushNewsService tpushNewsService;
	
	/**
	 * num
	 */
	private static final int num = 7;
	
	/**
	 * @return synUrl
	 */
	public String getSynUrl() {
		return synUrl;
	}

	/**
	 * @param synUrl synUrl
	 */
	public void setSynUrl(String synUrl) {
		this.synUrl = synUrl;
	}

	@Override
	public Object process(Object req){
		//SendPriorApplicationRequest sendReq = (SendPriorApplicationRequest)req;
		//PriorApplicationEntity prior = new PriorApplicationEntity();
		//BeanUtils.copyProperties(sendReq, prior); // copy一个对象
		/*JSONObject json = JSONObject.fromObject(req);
		//JSONArray json = JSONArray .fromObject(req);
		String strJson = json.toString();
		logger.info("json为:"+json+"strJson为:"+strJson);*/
		//String strJson = (String) req;
		//将javaBean(req)转换为JSONString
        //json转换
		String strJson = JsonUtil.beanToJsonString(req);
		logger.info("ReceivePriorApplicationService>>>>>>>>>进入process,传送过来的req:"+strJson);
		//初始化一个返回消息
		SendMdmOrgResponse response = new SendMdmOrgResponse();
		response.setSysName("DPM");
		int flag = 0;
		//声明实体对象
		NewsCenterEntity nce=null;	
		SendMdmOrgProcessReult result = new SendMdmOrgProcessReult();
		try {
			//费用类型编码（酒店：104002002，飞机：104002003 String类型）
			// 自定义测试数据str   
			//String str = "{\"claimNo\":\"CSE0001\",\"auditState\":\"审批中\",\"state\":0,\"applyDate\":\"2015-06-01\",\"applyEmpNo\":\"CSC01\",\"totalCost\":\"890\",\"detailInfoList\":[{\"claimLineId\":\"CSA01\",\"scNo\":\"F\",\"scName\":\"飞机\",\"flightInfo\":[{\"orderNo\":\"CSF01\"},{\"orderNo\":\"CSF02\"}],\"hotelInfo\":[]},{\"claimLineId\":\"CSA02\",\"scNo\":\"F\",\"scName\":\"飞机\",\"flightInfo\":[{\"orderNo\":\"CSF03\"}],\"hotelInfo\":[]},{\"claimLineId\":\"CSA03\",\"scNo\":\"H\",\"scName\":\"酒店\",\"flightInfo\":[],\"hotelInfo\":[{\"orderNo\":\"CSH01\"}]}]}";
			//String str = "{\"claimNo\":\"CSE0001\",\"auditState\":\"审批中\",\"state\":1,\"applyDate\":\"2015-06-01\",\"applyEmpNo\":\"CSC01\",\"totalCost\":\"890\",\"detailInfoList\":[{\"claimLineId\":\"CSA01\",\"scNo\":\"F\",\"scName\":\"飞机\",\"flightInfo\":[{\"orderNo\":\"CSF01\",\"orderState\":\"3\"},{\"orderNo\":\"CSF02\",\"orderState\":\"2\"}],\"hotelInfo\":[]},{\"claimLineId\":\"CSA02\",\"scNo\":\"F\",\"scName\":\"飞机\",\"flightInfo\":[{\"orderNo\":\"CSF03\"}],\"hotelInfo\":[]},{\"claimLineId\":\"CSA03\",\"scNo\":\"H\",\"scName\":\"酒店\",\"flightInfo\":[],\"hotelInfo\":[{\"orderNo\":\"CSH01\",\"orderState\":\"1\"}]}]}";
			//解析JSON得到PC端的状态并将其转化成Integer类型
			Integer type = Integer.parseInt(JsonUtil.jsonGetValueBykey(strJson,
					"state").toString());
			//System.out.println(type);
			//System.out.println(str);
			//Integer type = prior.getState();
			logger.info("ReceivePriorApplicationService>>>>>>>>>进入process,传送过来的type:"+type);
			if (type == 0) {// 判断事前申请单是什么状态(0:推送数据1:更新状态)
				PriorApplicationEntity prior = JsonUtil.jsonToEntity(strJson,
						PriorApplicationEntity.class);
				flag = iaDao.savePriorApplication(prior);//保存事前申请单信息
				//进行判断
				if(flag>0){
//					nce=new NewsCenterEntity();
//					 nce.setApplicationId(DpmConstants.TRAVEL_ASSISTANT);
//					 nce.setTaskId(prior.getClaimNo());
//					 nce.setActive(DpmConstants.YES);
//					 nce.setContent("");
//					 nce.setIsTxtNews(DpmConstants.NO);
					nce = new NewsCenterEntity(prior.getClaimNo(), num, 0, 1,
							"差旅助手");
					//推送消息
					 tpushNewsService.pushUserNews(prior.getApplyEmpNo(), "你有一条事前申请单可预订",  "事前申请单任务",nce);
					 //esb联调
					/* String resString=HttpUtil.httpClient(JsonUtil.beanToJSONObject(JsonUtil.jsonToEntity(strJson,PriorApplicationEntity.class )), synUrl, ESB_CODE_Travel_Assistant);
						ResponseParameterEntity<?> rpe=JsonUtil.jsonToEntity(resString, ResponseParameterEntity.class);
						if (rpe.isResultFlag()) {
							res="{\"resultFlag\":\"1\",\"failureReason\":\"\"}";
						}
						else{
							res="{\"resultFlag\":\"0\",\"failureReason\":\"网络异常，请在PC端处理！\"}";
							logger.error("assetsRenew---------"+rpe.getFailureReason());
						}*/
					//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
					 //设置参数
					 result.setResult(true);
					//设置参数
					 result.setReason("插入事前申请单信息成功");
					//设置参数
					 response.getProcessResultList().add(result);
					 logger.info("[process]-----插入事前申请单信息成功");
				}else{
					result.setResult(false);
					result.setReason("插入事前申请单信息失败");
					response.getProcessResultList().add(result);
					//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
					 logger.info("[process]-----插入事前申请单信息失败");
				}
				//得到list
				List<DetailInfoEntity> detailList = prior.getDetailInfoList();
				//对list进行循环赋值
				for (DetailInfoEntity d : detailList) {
					d.setClaimNo(prior.getClaimNo());//将事前申请单单号保存到明细信息里面（相当于外键关系）
					flag = iaDao.saveDetailInfoEntity(d);//保存明细信息
					if(flag>0){
						//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
						 result.setResult(true);
						 result.setReason("插入明细信息成功");
						 response.getProcessResultList().add(result);
						 logger.info("[process]-----插入明细信息成功");
					}else{
						//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
						result.setResult(false);
						result.setReason("插入明细信息失败");
						response.getProcessResultList().add(result);
						 logger.info("[process]-----插入明细信息失败");
					}
					//判断no
					if (d.getScNo().equals("104002003")) {
						//抽取方法
						forScNoTo104002003(response, result, prior, d);
					} else if (d.getScNo().equals("104002002")) {
						//抽取方法
						forScNoTo104002002(response, result, prior, d);
					}else{
						//res="{\"resultFlag\":\"false\",\"failureReason\":\"插入失败!\"}";
						result.setResult(false);
						 result.setReason("插入失败，没有此类型");
						 response.getProcessResultList().add(result);
						logger.info("[process]-----插入失败，没有此类型");
					}
				}

			} else if (type == 1) {
				//抽取方法
				forTypeOne(strJson, response, result);
			}else{
				//res="{\"resultFlag\":\"false\",\"failureReason\":\"事前申请单判断失败!\"}";
				 result.setResult(false);
				 result.setReason("事前申请单判断失败!");
				 response.getProcessResultList().add(result);
				logger.info("[process]-----判断失败，事前申请单没有此状态");
			}
		} catch (Exception e) {
			//抛出异常
			logger.error("[process]-----操作失败",e);
			result.setResult(false);
			 result.setReason(e.getMessage());
			 response.getProcessResultList().add(result);
			//return Response.ok("{\"resultFlag\":\"false\",\"failureReason\":\""+e.getMessage()+"\"}").header("ESB-ResultCode", 1).build();
		}
		//return Response.ok(res).header("ESB-ResultCode", 1).build();
		return response;
	}

	private void forTypeOne(String strJson, SendMdmOrgResponse response,
			SendMdmOrgProcessReult result) {
		int flag;
		// 判断事前申请单是什么状态(0:推送数据1:更新状态)
			//解析json得到事前申请单详情
			PriorApplicationEntity prior = JsonUtil.jsonToEntity(strJson,
					PriorApplicationEntity.class);
			//得到明细信息
			List<DetailInfoEntity> detailList = prior.getDetailInfoList();
			for (DetailInfoEntity d : detailList) {
				d.setClaimNo(prior.getClaimNo());
				if (d.getScNo().equals("104002003")) {//判断是不是飞机费用类型
					List<FlightOrderInfoEntity> flightList = d
							.getFlightOrderInfoEntity();
					for (FlightOrderInfoEntity flight : flightList) {
						flight.setClaimLineId(d.getClaimLineId());
						flag = iaDao.updateFlightOrderInfoEntityByOrderState(flight);
						if(flag>0){
							//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
							result.setResult(true);
							 result.setReason("更新飞机订单信息成功");
							 response.getProcessResultList().add(result);
							 logger.info("[process]-----更新飞机订单信息成功");
						}else{
							//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
							result.setResult(false);
							 result.setReason("更新飞机订单信息失败");
							 response.getProcessResultList().add(result);
							 logger.info("[process]-----更新飞机订单信息失败");
						}
						
					}
				} else if (d.getScNo().equals("104002002")) {//判断是不是酒店费用类型
					List<HotelOrderInfoEntity> hotelList = d
							.getHotelOrderInfoList();
					for (HotelOrderInfoEntity hotel : hotelList) {
						hotel.setClaimLineId(d.getClaimLineId());
						//更新对象
						flag = iaDao.updateHotelOrderInfoEntityByOrderState(hotel);
						//判断是否符合条件
						if(flag>0){
							//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
							result.setResult(true);
							 result.setReason("更新酒店订单信息成功");
							 response.getProcessResultList().add(result);
							 logger.info("[process]-----更新酒店订单信息成功");
						}else{
							//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
							result.setResult(false);
							 result.setReason("更新酒店订单信息失败");
							 response.getProcessResultList().add(result);
							 logger.info("[process]-----更新酒店订单信息失败");
						}
					}
				}else{
					//res="{\"resultFlag\":\"false\",\"failureReason\":\"更新失败!\"}";
					result.setResult(false);
					 result.setReason("更新失败，没有此类型");
					 response.getProcessResultList().add(result);
					logger.info("[process]-----更新失败，没有此类型");
				}
			}
	}

	private void forScNoTo104002002(SendMdmOrgResponse response,
			SendMdmOrgProcessReult result, PriorApplicationEntity prior,
			DetailInfoEntity d) {
		int flag;
		if(d.getHotelOrderInfoList()!=null){
		List<HotelOrderInfoEntity> hotelList = d
				.getHotelOrderInfoList();
		for (HotelOrderInfoEntity hotel : hotelList) {
			hotel.setClaimLineId(d.getClaimLineId());//保存酒店订单信息
			hotel.setEmpNo(prior.getApplyEmpNo());
			flag = iaDao.saveHotelOrderInfoEntity(hotel);
			if(flag>0){
				//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				result.setResult(true);
				 result.setReason("插入酒店订单信息成功");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入酒店订单信息成功");
			}else{
				//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
				result.setResult(false);
				 result.setReason("插入酒店订单信息失败");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入酒店订单信息失败");
			}
			
		}
		}else{
			HotelOrderInfoEntity hotel = new HotelOrderInfoEntity();
			hotel.setClaimLineId(d.getClaimLineId());
			hotel.setEmpNo(prior.getApplyEmpNo());
			flag = iaDao.saveHotelOrderInfoEntity(hotel);
			if(flag>0){
				//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				result.setResult(true);
				 result.setReason("插入酒店订单信息成功");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入酒店订单信息成功");
			}else{
				//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
				result.setResult(false);
				 result.setReason("插入酒店订单信息失败");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入酒店订单信息失败");
			}
		}
	}

	private void forScNoTo104002003(SendMdmOrgResponse response,
			SendMdmOrgProcessReult result, PriorApplicationEntity prior,
			DetailInfoEntity d) {
		int flag;
		//判断对象是否为null
		if(d.getFlightOrderInfoEntity()!=null){
		//得到list对象
		List<FlightOrderInfoEntity> flightList = d
				.getFlightOrderInfoEntity();
		//循环复制
		for (FlightOrderInfoEntity flight : flightList) {
			//塞入参数
			flight.setClaimLineId(d.getClaimLineId());
			//塞入参数
			flight.setEmpNo(prior.getApplyEmpNo());
			//塞入参数
			flag = iaDao.saveFlightOrderInfoEntity(flight);//保存飞机订单信息
			if(flag>0){
				//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				 result.setResult(true);
				 result.setReason("插入飞机订单信息成功");
				 response.getProcessResultList().add(result);
				logger.info("[process]-----插入飞机订单信息成功");
			}else{
				//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
				result.setResult(false);
				 result.setReason("插入飞机订单信息失败");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入飞机订单信息失败");
			}
		}
		}else{
			//声明对象
			FlightOrderInfoEntity flight = new FlightOrderInfoEntity();
			flight.setClaimLineId(d.getClaimLineId());
			flight.setEmpNo(prior.getApplyEmpNo());
			//保存对象
			flag = iaDao.saveFlightOrderInfoEntity(flight);
			if(flag>0){
				//res="{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				result.setResult(true);
				 result.setReason("插入飞机订单信息成功");
				 response.getProcessResultList().add(result);
				logger.info("[process]-----插入飞机订单信息成功");
			}else{
				//res="{\"resultFlag\":\"false\",\"failureReason\":\"\"}";
				result.setResult(false);
				 result.setReason("插入飞机订单信息失败");
				 response.getProcessResultList().add(result);
				 logger.info("[process]-----插入飞机订单信息失败");
			}
		}
	}
}
