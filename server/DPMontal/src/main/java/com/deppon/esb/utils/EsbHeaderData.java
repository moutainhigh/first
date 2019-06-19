package com.deppon.esb.utils;
import javax.xml.ws.Holder;

import com.deppon.esb.header.ESBHeader;

/**
 * @author zhaohui
 * ESBHeader 赋值
 */
public class EsbHeaderData {
	
	/**
	 * @param version
	 * 版本号
	 * @param serviceCode
	 * esb服务编码
	 * @param  
	 * @return
	 */
	public static Holder<ESBHeader> setEsbHeaderData(String version,String businessId, String serviceCode) {
		Holder<ESBHeader> esbHeader = new Holder<ESBHeader>(new ESBHeader());
		//版本号
		esbHeader.value.setVersion(version);
		//业务唯一ID
		esbHeader.value.setBusinessId(businessId);
		//生成请求的唯一ID
		esbHeader.value.setRequestId(Guid.newGuid());
		//请求端系统编码
		esbHeader.value.setSourceSystem("DPM");
		//ESB服务编码
		esbHeader.value.setEsbServiceCode(serviceCode);
		//服务配置：消息格式
		esbHeader.value.setMessageFormat("SOAP");
		//根据消息格式设置（SOAP统一设置为1,ESB负责处理）
		esbHeader.value.setExchangePattern(1);
		return esbHeader;	
	}

}
