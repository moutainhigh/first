package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcCheckFindScoreShowDao;
import com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService;
import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 详细页面的显示
 * @author 274858
 *
 */
public class ProcCheckFindScoreShowService implements IProcCheckFindScoreShowService{
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcCheckFindScoreShowService.class);
	private IProcCheckFindScoreShowDao procCheckFindScoreShowDao;

	public void setProcCheckFindScoreShowDao(
			IProcCheckFindScoreShowDao procCheckFindScoreShowDao) {
		this.procCheckFindScoreShowDao = procCheckFindScoreShowDao;
	}

	/* <!--获取初次、最终验收明细查询-->
	 * @see com.deppon.dpm.module.management.server.
	 * service.IProcCheckFindScoreShowService#
	 * getHisScoreFind(java.lang.String)
	 */
	@Override
	public String getHisScoreFind(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\"}";
		log.info("已经进入ProcCheckFindScoreShowService——getHisScoreFind(String str)");
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// fcheckAreaCode区域栏code（功能栏）
		// 门店地址
		String addressCode = json.getString("addressCode").trim();
        //检查次数
		int submitNub = json.getInteger("submitNub");
		
		log.info("addressCode:" + addressCode);
		log.info("submitNub:" + submitNub);
		
		if (addressCode == null || "".equals(addressCode)  || submitNub<0) {
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为Null！\"}";
		}
		ProcCheckScoreEntity paraBean = new ProcCheckScoreEntity();
		paraBean.setAddressCode(addressCode);
		paraBean.setSubmitNub(submitNub);
		List<ProcCheckScoreEntity> socreList = procCheckFindScoreShowDao.getHisScoreFind(paraBean);
		/*//数据归类
		Map<String,List<ProcCheckScoreEntity>> resultMap = parseSocreList(socreList);
		if(resultMap.isEmpty()){
			return res = "{\"resultFlag\":false,\"failureReason\":\"查询的数据为空\"}";
		}*/
		res = "{\"informationList\":";
		res += JsonUtil.beanToJsonString(socreList);
		res +="}";
		log.info("res="+res);
		
		
		return res;
	}

	/** 数据归类
	 * @param socreList
	 * @return
	 */
	/*
	private Map<String, List<ProcCheckScoreEntity>> parseSocreList(
			List<ProcCheckScoreEntity> socreList) throws BusinessException{
		Map<String,List<ProcCheckScoreEntity>> resultMap = new HashMap<String,List<ProcCheckScoreEntity>>();
		///获取导航栏
		//List<ProcCheckScoreEntity> navList = procCheckFindScoreShowDao.getNaviInfo();
		if(navList !=null && !navList.isEmpty()){
			for(ProcCheckScoreEntity navBean:navList){
				String navCode = navBean.getNavCode();
				for(ProcCheckScoreEntity socreBean:socreList){
					parseBean(navCode,socreBean);
				}
			}
			
		}
		for(ProcCheckScoreEntity socreBean:socreList){
			String navCode = socreBean.getNavCode().trim();
			
			if(!resultMap.containsKey(navCode)){
				List<ProcCheckScoreEntity> newList = new ArrayList<ProcCheckScoreEntity>();
			    newList.add(socreBean);
				resultMap.put(navCode, newList);
			}else{
				List<ProcCheckScoreEntity> oldList = resultMap.get(navCode);
			    oldList.add(socreBean);
			}
			
		}
		
		return resultMap;
	}*/
	
	/*
	 * 统计扣分总数和扣分项
	 * @see com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService#getCountScore(java.lang.String)
	 */
	@Override
	public String getCountScore(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\"}";
		log.info("已经进入ProcCheckFindScoreShowService——getHisScoreFind(String str)");
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// fcheckAreaCode区域栏code（功能栏）
		// 门店地址
		String addressCode = json.getString("addressCode").trim();
        //检查次数
		int submitNub = json.getInteger("submitNub");
		
		log.info("addressCode:" + addressCode);
		log.info("submitNub:" + submitNub);
		
		if (addressCode == null || "".equals(addressCode)  || submitNub<0) {
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为Null！\"}";
		}
		ProcCheckScoreEntity paraBean = new ProcCheckScoreEntity();
		paraBean.setAddressCode(addressCode);
		paraBean.setSubmitNub(submitNub);
		List<ProcCheckScoreEntity> socreList = procCheckFindScoreShowDao.getCountScore(paraBean);
		
		res = "{\"informationList\":";
		res += JsonUtil.beanToJsonString(socreList);
		res +="}";
		log.info("res="+res);
		
		return res;
	}

	/* 查询明细信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService#getFindListView(java.lang.String)
	 */
	@Override
	public String getFindListView(String str) throws BusinessException {
		//获取检查项信息
		List<ProcCheckScoreEntity> itemList = null;
		int totalScore = 0;
		int pointsItem = 0;
		List<ProcCheckScoreEntity> socreList = new ArrayList<ProcCheckScoreEntity>();
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\"}";
		log.info("已经进入ProcCheckFindScoreShowService——getHisScoreFind(String str)");
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// fcheckAreaCode区域栏code（功能栏）
		// 门店地址
		String addressCode = json.getString("addressCode") == null ? "" : json.getString("addressCode").trim();
		
        //部门检查状态
		int branchIsCheck = json.getInteger("branchIsCheck");
		//导航栏code
		String navCode = json.getString("navCode")==null ? "" : json.getString("navCode").trim();
		
		log.info("addressCode:" + addressCode);
		log.info("branchIsCheck:" + branchIsCheck);
		log.info("navCode:" + navCode);
		
		if(checkPar(addressCode,branchIsCheck)){
			return "{\"resultFlag\":false,\"failureReason\":\"对不起，传入的参数有误\"}";
		}
		
		//获取导航栏
		List<ProcCheckScoreEntity> navList = procCheckFindScoreShowDao.getNaviInfo();
		if(navList ==null ||navList.isEmpty()){
			return "{\"resultFlag\":false,\"failureReason\":\"导航栏查询为空\"}";
		}
		
	    //没有导航栏code获取默认的code
	    if("".equals(navCode)){
	    	for(ProcCheckScoreEntity bean:navList){
	    		navCode = bean.getNavCode().trim();
	    		if(!"".equals(navCode)){
	    			break;
	    		}
	    	}
	    }
	  //设置参数
	  		ProcCheckScoreEntity paraBean = new ProcCheckScoreEntity();
	  		paraBean.setAddressCode(addressCode);
	  		paraBean.setNavCode(navCode);
	  		paraBean.setBranchIsCheck(branchIsCheck);
	  		
		//待检查
	  	int updateTab = -1;
		if(branchIsCheck == Constants.PROC_CHECK_AWAITING){
			log.info("待检查");
			itemList = procCheckFindScoreShowDao.getNaviItem(navCode);
			updateTab = procCheckFindScoreShowDao.updateBranchIsCheck(addressCode);
			log.info("updateTab "+updateTab );
		}
		
		//暂存_按初次按钮之前
		if(branchIsCheck == Constants.PROC_CHECK_STOP){
			log.info("暂存_按初次按钮之前");
			itemList = procCheckFindScoreShowDao.getNaviItemFirstBefore(paraBean);
			paraBean.setSubmitNub(0);
			socreList = procCheckFindScoreShowDao.getCountScore(paraBean);
		} 
		
		//暂存_按初次按钮之后 
		if(branchIsCheck == Constants.PROC_CHECK_END){
			log.info("暂存_按初次按钮之后");
			itemList = procCheckFindScoreShowDao.getNaviItemFirstAfter(paraBean);
			paraBean.setSubmitNub(2);
			socreList = procCheckFindScoreShowDao.getCountScore(paraBean);
			/*List<ProcCheckScoreEntity> HisScore = procCheckFindScoreShowDao.getCountScoreEnd(paraBean);
			socreList = getTotalPointsItem(HisScore);*/
		}
		//最终按钮点击之后
		if(branchIsCheck == Constants.PROC_CHECK_FINISH){
			log.info("暂存_按初次按钮之后");
			itemList = procCheckFindScoreShowDao.getNaviItemFinish(paraBean);
			paraBean.setSubmitNub(2);
			socreList = procCheckFindScoreShowDao.getCountScoreFinish(paraBean);
		}
		
		/*
		if(itemList ==null ||itemList.isEmpty()){
			
			return "{\"resultFlag\":false,\"failureReason\":\"检查项查询为空\"}";
		}
		*/
		//if(socreList.size() == 0||(socreList.size() == 1 && "[null]".equals(socreList.get(0)))){
		if(socreList.size() == 0||(socreList.size() == 1 && null==socreList.get(0))){
			ProcCheckScoreEntity scoreBean = new ProcCheckScoreEntity();
			scoreBean.setTotalScore(totalScore);
			scoreBean.setPointsItem(pointsItem);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("navList",navList);
		result.put("itemList",itemList);
		result.put("socreList",socreList);
		
		res = "{\"informationList\":";
		res += JsonUtil.mapToJsonString(result);
		res +="}";
		log.info("res="+res);
		
		return res;
	}

	/**
	 * @param addressCode
	 * @param branchIsCheck
	 * @return
	 */
	private boolean checkPar(String addressCode, int branchIsCheck) {
		if (addressCode == null || "".equals(addressCode)) {
			log.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为Null！\"}");
			return true;
		}
		if(branchIsCheck<0 || branchIsCheck>Constants.PROC_CHECK_FINISH){
			log.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数branchIsCheck（状态值不对，只允许为0、1、2、3，现在的值为:"+branchIsCheck+"）\"}");
			return true;
		}
		return false;
	}

	/* 扣分保存
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcCheckFindScoreShowService#setProcCheckSave(java.lang.String)
	 */
	/*@Override
	public String setProcCheckSave(String str) throws BusinessException {
		str = "{'address':'上海闵行营业部XY003','addressCode':'XY003','branchIsCheck':0,'checkMethod':'阿士大夫撒','imgFive':'afsdf','imgFour':'afsdf','imgOne':'afsdf','imgThree':'afsdf','imgTwo':'afsdf','isKeyPro':'撒旦飞洒','navCode':'YSBW0001-2','navName':'营业厅','opinion':'撒旦法撒旦','origItemCode':'YSSX0001-52','origItemName':'招牌面板修改再改','pointsItem':0,'score':0,'selectItem':'1、送达方式的发生;2、阿士大夫撒','staticScore':0,'submitNub':0,'totalScore':0,'unSelectItem':'3、送达方式的发生;4、阿士大夫撒','userNo':'074996'}";
		// 客户端的数据转化为list
		
		//ProcCheckScoreEntity parBean = new ProcCheckScoreEntity();
		ProcCheckScoreEntity parBean = JsonUtil.jsonToEntity(str,
				ProcCheckScoreEntity.class);
		parBean.setSubmitNub(0);
		if(parBean ==  null){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空\"}";
		}
		checkHisPointsList(parBean);
		
		return null;
	}

	private void checkHisPointsList(ProcCheckScoreEntity parBean) throws BusinessException{
		List<ProcCheckScoreEntity> hisList = procCheckFindScoreShowDao.getHisPointsList(parBean);
		if(hisList != null && hisList.size()>0){
			
		}
	}
*/
	/**
	 * 初次按钮点击之后扣分数和扣分项
	 * @param hisScore
	 * @return
	 */
	/*private List<ProcCheckScoreEntity> getTotalPointsItem(
			List<ProcCheckScoreEntity> hisScore) {
		*//**
		 * 总扣分分数
		 *//*
		int totalScore = 0;
		*//**
		 * 扣分的个数
		 *//*
		int  pointsItem = 0;
		List<ProcCheckScoreEntity> firtScore = new ArrayList<ProcCheckScoreEntity>();
		List<ProcCheckScoreEntity> endScore = new ArrayList<ProcCheckScoreEntity>();
		for(ProcCheckScoreEntity bean:hisScore){
			int submitNub = bean.getSubmitNub();
			if(submitNub == 1){
				firtScore.add(bean);
			}else{
				endScore.add(bean);
			}
		}
		//更新第二次的分数放到第一次里面去
		for(ProcCheckScoreEntity firtBean:firtScore){
			
			if(endScore != null && endScore.size()>0){
				StringBuffer firtStr = new StringBuffer();
				StringBuffer endStr = new StringBuffer();
				
				firtStr.append(firtBean.getNavCode().trim());
				firtStr.append(firtBean.getOrigItemCode().trim());
				String firtKey = firtStr.toString().trim();
				for(ProcCheckScoreEntity endBean:endScore){
					endStr.append(endBean.getNavCode().trim());
					endStr.append(endBean.getOrigItemCode().trim());
					String endKey = endStr.toString().trim();
					if(firtKey.equals(endKey)){
						firtBean.setScore(endBean.getScore());
					}
					
				}
			}
			
			int score = firtBean.getScore();
			//看是否存在扣分
			if(score > 0){
				totalScore += score;
				pointsItem++;
			}
			
			
		}
		
		ProcCheckScoreEntity result = new ProcCheckScoreEntity();
		result.setTotalScore(totalScore);
		result.setPointsItem(pointsItem);
		List<ProcCheckScoreEntity> resList = new ArrayList<ProcCheckScoreEntity>();
		resList.add(result);
		return resList;
	}
*/
	
}
