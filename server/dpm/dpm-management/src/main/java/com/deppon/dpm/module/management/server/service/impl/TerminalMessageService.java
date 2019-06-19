package com.deppon.dpm.module.management.server.service.impl;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.dao.ITerminalMessageDao;
import com.deppon.dpm.module.management.server.service.ITerminalMessageService;
import com.deppon.dpm.module.management.shared.domain.TerminalMessageEntity;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
/**
 * 接收推送IT上报消息
 * @author 237986
 *
 */
public class TerminalMessageService implements ITerminalMessageService {
	/**
	 * 日志
	 */
	private static Logger logger = Logger.getLogger(TerminalMessageService.class);
	/**
	 * terminalMessageDao
	 */
	@Resource
	private ITerminalMessageDao terminalMessageDao;
	@Resource
	private TpushNewsService tpushNewsService;//推送消息
	@Override
	public Response receiveTerminalMessage(String json) {
//		String json1 = "{\"orderCode\":\"BBBBB\",\"dealUserCode\":\"000021\"}";
		//TerminalMessageEntity terminalMessage;
		int flag=0;
		NewsCenterEntity nce;
		//try catch
			try {
				//System.out.println(json);
				TerminalMessageEntity terminalMessage=JsonUtil.jsonToEntity(json, TerminalMessageEntity.class);
					//保存接收到的终端消息
					flag=terminalMessageDao.saveTerminalMessage(terminalMessage);
					//判断是否保存成功
					if (flag>0) {
//						nce=new NewsCenterEntity();
//						nce.setApplicationId(DpmConstants.IT_SERVICE_PLATFORM);//IT上报
//						nce.setTaskId("任务ID");
//						nce.setActive(DpmConstants.YES);
//						nce.setContent("");
//						nce.setIsTxtNews(DpmConstants.NO);
						//如果保存成功
						nce = new NewsCenterEntity(null, MagicNumber.NUM4, 0, 1, "IT服务台");
						//开始进行推送
						tpushNewsService.pushUserNews(terminalMessage.getDealUserCode(), "你有一个IT服务台任务",  "IT服务台任务",nce);
						logger.info("[receiveTerminalMessage]---编码为"+terminalMessage.getOrderCode()
								+"的终端消息插入成功");
					}
					else{
						//打出日志
						logger.error("[receiveTerminalMessage]---编码为"+terminalMessage.getOrderCode()
								+"的终端消息插入失败");
					}
			} catch (Exception e) {
				//异常处理
				logger.error("[receiveTerminalMessage]-----IT上报任务插入失败",e);
				return Response.ok("{\"isSuccess\":\"N\",\"errorMessage\":\""+e.getMessage()+"\"}").header("ESB-ResultCode", 1).build();
			}
			//返回结果
		return Response.ok("{\"isSuccess\":\"Y\",\"errorMessage\":\"\"}").header("ESB-ResultCode", 1).build();
	}
}
