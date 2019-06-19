package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao;
import com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService;
import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusEvaluationManageEntity;
import com.deppon.dpm.module.management.shared.domain.BusMessageEntity;
import com.deppon.dpm.module.management.shared.domain.BusNewsSiteEntity;
import com.deppon.dpm.module.management.shared.domain.BusOpenLineEntity;


/**
 * <!-- 异常信息的查询、新增，评价建议的回复、删除，开线建议统计、新增 Service层-->
 * @author xieyidong
 * @date 2015-6-29 上午8:58:10
 * @since
 * @version
 */

/**
 * @author 274858
 *
 */
public class BusMsgAssNewsService implements IBusMsgAssNewsService {

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusMsgAssNewsService.class);
	//dao的注入
	public IBusMsgAssNewsDao busMsgAssNewsDao;
	//get set
	public void setBusMsgAssNewsDao(IBusMsgAssNewsDao busMsgAssNewsDao) {
		this.busMsgAssNewsDao = busMsgAssNewsDao;
	}
	//get set
	public IBusMsgAssNewsDao getBusMsgAssNewsDao() {
		return busMsgAssNewsDao;
	}

	/** 
	 * <p>获取异常信息表的数据</p> 
	 * @author xieyidong
	 * @date 2015-6-29 上午11:22:03
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#getGustyMessage()
	 */
	@Override
	public String getGustyMessage() throws Exception {
		String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息值为Null！\"}";
		logger.info("已经执行到BusMsgAssNewsService——getGustyMessage()");
		//得到msgList
		List<BusMessageEntity> msgList = busMsgAssNewsDao.getGustyMessage();
		//时间格式化
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = "";
        //判断是否为null
        if(msgList!=null && msgList.size()>0){
        	//进行循环判断
			for(BusMessageEntity bean:msgList){
				strDate = format.format(bean.getCreateDate());
				bean.setStrDate(strDate);
				
			}
		
			res = "{\"busInformationList\":";
			//res 的拼装
			res += JsonUtil.beanToJsonString(msgList);
			res +="}";
			logger.info("res="+res);
		}
        //返回结果集
		return res;
	}

	/** 
	 * <p>保存消息表</p> 
	 * @author xieyidong
	 * @date 2015-6-29 下午2:01:31
	 * @param str （用户Id、内容）
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveGustyMessage(java.lang.String)
	 */
	@Override
	public String saveGustyMessage(String str) throws Exception {
		//转json格式
		JSONObject json = JSONObject.parseObject(str);
		logger.info("新增页面传过来的参数为:"+json);
		//得到工号
		String userNo = json.getString("userNo");
		//得到内容
		String content = json.getString("content");
		logger.info("userNo:"+userNo);
		logger.info("content:"+content);
		//判断是否为null
		if(userNo==null || "".equals(userNo) || content==null || "".equals(content)){			
			logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}");
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
		}
		
		//Calendar calendar = Calendar.getInstance();
		BusMessageEntity msgBean = new BusMessageEntity();
		//塞入数据
		msgBean.setUserNo(userNo);
		//塞入数据
		msgBean.setContent(content);
		//msgBean.setCreateDate(new Date());
		msgBean.setCreateBy(userNo);
		msgBean.setDelMark(0);//0不删除，1删除
		//判断对象是否为null
		if(msgBean!=null){
			//保存实体
			int tag = busMsgAssNewsDao.saveGustyMessage(msgBean);
			if(tag>0){
				return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\"}";
			}
		}
		//返回数据
		return "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
	}

	/** 
	 * <p>点击量保存</p> 
	 * @author xieyidong
	 * @date 2015-6-30 上午10:13:52
	 * @param str
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveHits(java.lang.String)
	 */
	@Override
	public String saveHits(String str) throws Exception {
		JSONObject json = JSONObject.parseObject(str);
		logger.info("点击量页面传过来的参数为:"+json);
		//得到siteId
		int siteId = json.getInteger("siteId");
		//得到工号
		String userNo = json.getString("userNo");
		logger.info("userNo:"+userNo);
		logger.info("siteId:"+siteId);
		//判断siteId  userNo
		if(userNo==null || "".equals(userNo) || siteId<=0){			
			logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}");
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
		}
		
		//Calendar calendar = Calendar.getInstance();
		BusOpenLineEntity msgBean = new BusOpenLineEntity();
		msgBean.setSiteId(siteId);
		msgBean.setUserNo(userNo);
		msgBean.setHits(1);		
		msgBean.setCreateBy(userNo);
		//判断对象是否为null
		if(msgBean!=null){
			//按工号、站点Id查询
			List<BusOpenLineEntity> oldBean = busMsgAssNewsDao.findHits(msgBean); 
			//oldBean是否为null
			if(oldBean.isEmpty()){
				//没有记录，插入新记录
				logger.info("没有记录");
				//保存数据
				int tag = busMsgAssNewsDao.saveHits(msgBean);
				logger.info("tag="+tag);
				if(tag>0){
					return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\"}";
				}
            }else{
            	//有记录
            	logger.info("有记录");
            	//时间格式的转换
            	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        		Date tDate = new Date();
        		String strDate = format.format(tDate);
        		//时间标志，时间比较
        		int tagDate = -1;
        		//循环判断
        		for(BusOpenLineEntity  bean:oldBean){
        			if(strDate.equals(format.format(bean.getCreateDate()))){
        				tagDate = 1;
        				break;
        			}
        		}
        		//今天有不处理
            	if(tagDate == 1){
            		logger.info("今天已经点击过了！");
            		return "{\"resultFlag\":false,\"failureReason\":\"您今天已经点击过了！\",\"myTag\":1}";
            	}else{
            		//今天无，更新操作
            		logger.info("点击量、时间更新成功！");
            		int tagUpdate = busMsgAssNewsDao.updateHits(msgBean);
            		if(tagUpdate>0){
            			return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\"}";
            		}
            	}
            	
            }
			
			
		}
		//返回数据
		return "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
	}

	/** 
	 * <p>保存建议新开的站点</p> 
	 * @author xieyidong
	 * @date 2015-6-30 下午3:50:54
	 * @param str
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveSite(java.lang.String)
	 */
	
	@Override
	public String saveSite(String str) throws Exception {
		JSONObject json = JSONObject.parseObject(str);
		logger.info("开线建议页面传过来的参数为:"+json);
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		String siteName = json.getString("siteName") == null ? "":json.getString("siteName").trim();
		logger.info("userNo:"+userNo);
		logger.info("siteName:"+siteName);
		if("".equals(userNo) || "".equals(siteName)){			
			logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}");
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format.format(new Date());
		BusNewsSiteEntity msgBean = new BusNewsSiteEntity();
		msgBean.setUserNo(userNo);
		msgBean.setSiteName(siteName);
		msgBean.setIsAct(0);
        msgBean.setCreateDate(format.parse(strDate));
		if(msgBean!=null){
			//查重复站点
			logger.info("查重复站点");
			
			List<BusNewsSiteEntity> repeat = busMsgAssNewsDao.getRepeSiteId(msgBean);
			if(repeat.size()>0){
				return "{\"resultFlag\":false,\"failureReason\":\"新增的站点重复或今天已经新增过！\"}";
			}
			logger.info("保存站点表的数据");
			int tag = busMsgAssNewsDao.saveSite(msgBean);
			logger.info("开线建议表插入标志："+tag);
			if(tag>0){
				int siteId = 0;//站点id
				
				logger.info("获取新增站点的Id");
				List<BusNewsSiteEntity> beans = busMsgAssNewsDao.getSiteId(msgBean);
				if(beans.size()==1){
					for(BusNewsSiteEntity bean:beans){
						siteId = bean.getId();
						} 
				}
				logger.info("siteId:"+siteId);
				boolean sucss = saveOtherData(siteId,userNo);
				
				SimpleDateFormat relDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String strrelDate = relDate.format(new Date());
				
				if(sucss){
					return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\",\"siteId\":"+siteId+",\"strrelDate\":\""+strrelDate+"\"}";
				}else{
					logger.info("保存BusCentreAdviceEn表失败，抛异常，回滚上所有的dao，本次保存操作结束");
					throw new Exception();
				}
			
				
			}
		}
		
		return "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
	}

	public boolean saveOtherData(int siteId, String userNo) {
		int tagHits = 0;
		int hitsId = 0;
		int tagCentre = 0;
		BusOpenLineEntity openLine = null;
		List<BusOpenLineEntity> hitsIds = null;
		BusCentreAdviceEntity centreBean = null;
		if(siteId>0){
			//id存在，保存开线建议表
			logger.info("id存在，保存开线建议表");
			openLine = new BusOpenLineEntity();
			openLine.setSiteId(siteId);
			openLine.setUserNo(userNo);
			openLine.setHits(1);
			openLine.setCreateDate(new Date());
			openLine.setCreateBy(userNo);
			tagHits = busMsgAssNewsDao.saveSiteHits(openLine);
			logger.info("tagHits"+tagHits);
		}else{
			logger.info("查询站点表Id失败，抛异常，回滚上一个保存站点dao，本次保存操作结束");
			//throw new Exception();
		}
		
		
		if(tagHits>0){
			logger.info("获取开线建议Id(点击量表)");
			hitsIds = busMsgAssNewsDao.getSiteHits(openLine);
			if(hitsIds.size()==1){
				for(BusOpenLineEntity bean:hitsIds){
					hitsId = bean.getId();
					} 
				centreBean = new BusCentreAdviceEntity();
				centreBean.setCentreId(hitsId);
				centreBean.setUserNo(userNo);
				centreBean.setCreateDate(new Date());
				centreBean.setCentreMark(1);
			}
			logger.info("hitsId:"+hitsId);
		}else{
			logger.info("保存点击量表（开线建议表）失败，抛异常，回滚上所有的dao，本次保存操作结束");
			//throw new Exception();
		}
		
		if(hitsId>0){
			logger.info("获取到了开线建议Id(点击量表)，保存中间表");
			tagCentre = busMsgAssNewsDao.saveCentre(centreBean);
			
		}else{
			logger.info("获取点击表（开线建议表）Id失败，抛异常，回滚上一个保存站点dao，本次保存操作结束");
			//throw new Exception();
		}
		
		return tagCentre>0 ? true:false;
	}

	/** 
	 * <p>删除评价回复</p> 
	 * @author xieyidong
	 * @date 2015-7-1 下午6:57:29
	 * @param str
	 * @return
	 * @throws Exception 
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#deleteReplySugg(java.lang.String)
	 */
	@Override
	public String deleteReply(String str) throws Exception {
		JSONObject json = JSONObject.parseObject(str);
		logger.info("页面传过来的参数为:"+json);
		int id = json.getInteger("id");
		int isState = json.getInteger("isState");
		int tag = 0;
		logger.info("id :"+id );
		if(id<0 || isState<0){			
			logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数不正确！\"}");
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数不正确！\"}";
		}else{
			if(isState==1){
				logger.info("删除建议表");
				tag = busMsgAssNewsDao.deleteReplySugg(id);
				return "{\"resultFlag\":true,\"failureReason\":\"删除信息成功！\"}";
			}
			if(isState==0){
				logger.info("删除评价表");
				tag = busMsgAssNewsDao.deleteReplyMsg(id);
				return "{\"resultFlag\":true,\"failureReason\":\"删除信息成功！\"}";
			}
			
		}
		logger.info("tag:"+tag);
		
		
		return "{\"resultFlag\":false,\"failureReason\":\"删除信息失败！\"}";
	}

	
	
	/* 
	 * <p>Title: saveReply</p>
	 * <p>Description:保存建议评价回复</p>
	 * @param str
	 * @return
	 * @throws Exception
	 * @see com.deppon.dpm.module.management.server.service.IBusMsgAssNewsService#saveReply(java.lang.String)
	 */
	
	@Override
	public String saveReply(String str) throws Exception {
		JSONObject json = JSONObject.parseObject(str);
		logger.info("页面传过来的参数为:"+json);
		int isState = json.getInteger("isState");
		logger.info("isState:"+isState);
		if(isState<0){			
			logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数isState为NULL！\"}");
			return "{\"resultFlag\":false,\"failureReason\":\"传入isState的参数为NULL！\"}";
		}
		
		if(isState==0){
			logger.info("评价回复保存");
			int retId = json.getInteger("retId");
			String userNo = json.getString("userNo");		
			String replyContent = json.getString("replyContent");
			if(retId<0 || userNo==null || "".equals(userNo) || replyContent==null || "".equals(replyContent)){
				logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}");
				return "{\"resultFlag\":false,\"failureReason\":\"传入的参数不正确！\"}";
			}
			logger.info("retId:"+retId);
			logger.info("userNo:"+userNo);
			logger.info("replyContent:"+replyContent);
			int resId = saveEvaluate(retId,userNo,replyContent);
			
			if(resId < 0){
				logger.info("获取Id失败，保存回滚，保存信息失败！");
				return "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
			}
			return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\",\"id\":"+resId+"}";
		}
		
		if(isState==1){
			logger.info("建议回复");
			
			int openId = json.getInteger("openId");
			String userNo = json.getString("userNo");		
			String replyContent = json.getString("replyContent");
			if(openId<0 || userNo==null || "".equals(userNo) || replyContent==null || "".equals(replyContent)){
				logger.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}");
				return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
			}
			logger.info("openId:"+openId);
			logger.info("userNo:"+userNo);
			logger.info("replyContent:"+replyContent);
			int resId = setSuggest(openId,userNo,replyContent);
			
			if(resId < 0){
				logger.info("获取Id失败，保存回滚，保存信息失败！");
				return "{\"resultFlag\":false,\"failureReason\":\"保存信息失败！\"}";
			}
			return "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\",\"id\":"+resId+"}";
		}else{
			return "{\"resultFlag\":false,\"failureReason\":\"参数isState不准确！\"}";
		}
		
	}

	/**
	 * 保存建议
	 * @param openId
	 * @param userNo
	 * @param replyContent
	 * @return
	 */
	public int setSuggest(int openId,
			String userNo, String replyContent) {
		//new 一个advBean
		BusEvaluationAdviceEntity advBean = new BusEvaluationAdviceEntity();
		advBean.setOpenId(openId);
		advBean.setUserNo(userNo);
		advBean.setReplyContent(replyContent);
		advBean.setCreateDate(new Date());
		advBean.setCreateBy(userNo);
		//保存数据
		int tag = busMsgAssNewsDao.saveEvaluateAdvice(advBean);
		int id = -1;
		//判断是否保存成功
		if(tag > 0){
			//得到ids
			List<BusEvaluationAdviceEntity> ids = busMsgAssNewsDao.getEvaAdvice(advBean);
			//判断非null
			if(ids != null && ids.size()==1){
				for(BusEvaluationAdviceEntity idBean:ids){
					id = idBean.getId();
				}
			}
		}
		
		return id;
	}

	/**
	 * 保存评价
	 * @param retId
	 * @param userNo
	 * @param replyContent
	 * @return
	 * @throws Exception
	 */
	private int saveEvaluate(int retId,
			String userNo, String replyContent) throws Exception{
		//new 一个新的对象
		BusEvaluationManageEntity manBean = new BusEvaluationManageEntity();
		//set retId
		manBean.setRetId(retId);
		manBean.setUserNo(userNo);
		manBean.setReplyContent(replyContent);
		manBean.setCreateDate(new Date());
		manBean.setCreateBy(userNo);
		int id = -1;
		//保存数据
		int tag = busMsgAssNewsDao.saveEvaluateManage(manBean);
		//判断是否保存成功
		if(tag > 0){
			//在得到数据
			List<BusEvaluationManageEntity> ids = busMsgAssNewsDao.getEvaManage(manBean);
			//进行判断
			if(ids != null && ids.size()==1){
				for(BusEvaluationManageEntity idBean:ids){
					id = idBean.getId();
				}
			}
		}
		//返回id
		return id;
	}

	
}
