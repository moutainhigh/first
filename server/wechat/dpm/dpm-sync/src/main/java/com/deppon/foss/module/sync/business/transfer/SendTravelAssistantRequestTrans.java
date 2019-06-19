/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */ 
package com.deppon.foss.module.sync.business.transfer;

//import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.foss.module.sync.business.jms.SendPriorApplicationRequest;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;

/**
 * [接口改造]部门信息 消息request转换类
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0</p>
 * @author 曹嵩
 * @date 2015-8-19
 * @since
 * @version
 */
public class SendTravelAssistantRequestTrans implements IMessageTransform<SendPriorApplicationRequest> {

	@Override
	public SendPriorApplicationRequest toMessage(String string){
		//SendPriorApplicationRequest s = new SendPriorApplicationRequest();
		//String str = string;
			/*String time = JsonUtil.jsonGetValueBykey(string, "applyDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateTime = null;
			try {
				dateTime = sdf.parse(time);
			} catch (ParseException e) {
				System.out.println("转换错误");
			}
			string = string.replace(time,dateTime.toString());*/
			//s = (SendPriorApplicationRequest)new ObjectMapper().readValue(string, SendPriorApplicationRequest.class);
		
		//List<PriorApplicationInfo>  listInfo = new ArrayList<PriorApplicationInfo>();
		//listInfo.add(info);
		/*s.setPriorApplicationInfoList(listInfo);
		List<PriorApplicationInfo> dd = s.getPriorApplicationInfoList();
		for(PriorApplicationInfo pp : dd) {
			System.out.println(pp.getApplyEmpNo()+"================================");
		}*/
		//将传送过来的string转成一个实体类
		SendPriorApplicationRequest info =	JsonUtil.jsonToEntity(string, SendPriorApplicationRequest.class);
		
		return info;
	}

	@Override
	public String fromMessage(SendPriorApplicationRequest message) throws ConvertException {
		String txtMsg = null;
		try {
			txtMsg = new ObjectMapper().writeValueAsString(message).toString();
		} catch (JsonGenerationException e) {
			throw new ConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} catch (JsonMappingException e) {
			throw new ConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} catch (IOException e) {
			throw new ConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} 
		return txtMsg;
	}
}
