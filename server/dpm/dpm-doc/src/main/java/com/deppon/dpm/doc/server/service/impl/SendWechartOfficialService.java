package com.deppon.dpm.doc.server.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.doc.server.entity.ClientMessEntity;
import com.deppon.dpm.doc.server.entity.UmpDetail;
import com.deppon.dpm.doc.server.entity.WechartOfficial;
import com.deppon.dpm.doc.server.service.ISendWechartOfficialService;
import com.deppon.dpm.doc.server.util.MD5Encrypt;
import com.deppon.dpm.doc.server.util.PustTypeEnum;

public class SendWechartOfficialService implements ISendWechartOfficialService{

	private String httpUrl;
	
	@Override
	public String sendWechartOfficial(String WxContent,String WxTouser) {
		List<UmpDetail> umpDetails = new ArrayList<UmpDetail>();
		
            UmpDetail detail = new UmpDetail();
            detail.setPushType(PustTypeEnum.ONLY.getType());
        
            WechartOfficial wechartOfficial = new WechartOfficial();
            wechartOfficial.setSendDept("移动BI研发部");
            wechartOfficial.setSender("陆文诗");
            wechartOfficial.setUnionId(UUID.randomUUID().toString());
            wechartOfficial.setWxAgentid("1000275");
            wechartOfficial.setWxContent(WxContent);
            wechartOfficial.setWxMegtype("text");
            wechartOfficial.setWxTouser("DP-"+WxTouser);
            detail.setWechartOfficial(wechartOfficial);

            umpDetails.add(detail);
        
        String appKey = "ExcellentDrivingKey";
        String appSecret = "20171205";
        String dataDigest = MD5Encrypt.encrypt(appKey + appSecret);
        //String dataDigest = "FSSN/BFpHyUvldZD5J9dSg==";
        ClientMessEntity clientMessEntity = new ClientMessEntity();
        clientMessEntity.setDataDigest(dataDigest);
        clientMessEntity.setMsgSource("XTLY20171205095628");
        clientMessEntity.setMsgType("YWLX20171205100204");
        clientMessEntity.setSendType(2);
        clientMessEntity.setUmpDetails(umpDetails);

		//String httpUrl = "http://192.168.2.119:8280/ump-interface/api/send ";
		//String httpUrl = "http://10.230.44.125:8083/ump-interface/api/send";
        String param = JSON.toJSONString(clientMessEntity);
        RequestBuilder requestBuilder = RequestBuilder.create(HttpPost.METHOD_NAME).setUri(httpUrl);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000)
                .setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000)
                .build();
        StringEntity stringEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
        HttpUriRequest httpUriRequest = requestBuilder
                .setEntity(stringEntity)
                .setConfig(requestConfig)
                .build();
        String result = null;
        try {
        	CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpUriRequest);
        	HttpEntity entity = response.getEntity();
            result = entity != null ? EntityUtils.toString(entity) : null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
		return result;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

}
