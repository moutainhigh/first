package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;
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
	 * @return
	 */
	public static Holder<ESBHeader> setEsbHeaderData(String version,String serviceCode) {
		Holder<ESBHeader> esbHeader = new Holder<ESBHeader>(new ESBHeader());
		esbHeader.value.setVersion(version);
		esbHeader.value.setSourceSystem("DPM");
		esbHeader.value.setEsbServiceCode(serviceCode);
		esbHeader.value.setMessageFormat("SOAP");
		esbHeader.value.setExchangePattern(1);
		return esbHeader;	
	}

}
