package com.deppon.foss.module.sync.business.transfer;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.deppon.dpap.esb.mqc.core.data.IMessageTransform;
import com.deppon.dpap.esb.mqc.core.exception.ESBConvertException;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.foss.module.sync.business.jms.SendPriorApplicationRequest;

public class SendPriorRequestTrans implements IMessageTransform<SendPriorApplicationRequest>{
	
	@Override
	public SendPriorApplicationRequest toMessage(String string)
			throws ESBConvertException {
		//将传送过来的string转成一个实体类
		SendPriorApplicationRequest info =	JsonUtil.jsonToEntity(string, SendPriorApplicationRequest.class);
		return info;
	}

	@Override
	public String fromMessage(SendPriorApplicationRequest message)
			throws ESBConvertException {
		String txtMsg = null;
		try {
			txtMsg = new ObjectMapper().writeValueAsString(message).toString();
		} catch (JsonGenerationException e) {
			throw new ESBConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} catch (JsonMappingException e) {
			throw new ESBConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} catch (IOException e) {
			throw new ESBConvertException("序列化" + message.getClass().getName()
					+ "时失败！", e);
		} 
		return txtMsg;
	}

}
