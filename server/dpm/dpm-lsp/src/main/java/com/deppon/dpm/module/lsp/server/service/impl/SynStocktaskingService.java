package com.deppon.dpm.module.lsp.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.lsp.server.service.ISynStocktaskingService;
import com.deppon.dpm.module.lsp.shared.domain.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.lsp.shared.domain.SynchronousStocktaskingInfo;
import com.primeton.fc.bfms.log.sys.Logger;

/**
 * 
 * 同步盘点资产信息Service
 * 
 * <p style="display:none">
 * version:V1.0,author:195406 高春玲,date:2015-3-20 下午1:45:08,content:固定资产
 * 移动端与Lsp数据同步
 * </p>
 * 
 * @author 195406 高春玲
 * @date 2015-3-20 下午1:45:08
 * @since
 * @version 1、 在移动端接收任务通知后，在对应的盘点任务列表中或者首页直接点击扫一扫按钮，即可扫描固定资产； 2、
 *          移动端扫描时，将扫描的固定资产管理编码推送至LSP
 *          ，LSP校验此资产是否已被扫描，未扫描则可进行以下操作，若已扫描则推送已扫描信息至移动端。 3、
 *          移动端扫描时，扫描结果选择完成时将信息推送至LSP 4、
 *          移动端扫描时，资产未在盘点任务列表中的扫描完成后将盘盈的资产信息推送至LSP，LSP系统将固定资产信息匹配完整后推送至移动端保存 5、
 *          移动端扫描时，资产在盘点任务列表中但未进行扫描，盘点列表信息暂存或者提交后将盘亏信息推送至LSP 6、
 *          扫描过程中信息同步到LSP中的“固定资产盘点单”中 7、
 *          扫描的固定资产不在任务盘点列表中则自动新增一条记录，自动新增的固定资产可删除，删除确认后将该固定资产信息推送至LSP
 **/
public class SynStocktaskingService implements ISynStocktaskingService {
	/**
	 * esb URL
	 */
	private String synUrl;

	/**
	 * @author 195406 高春玲
	 * @date 2015-3-20 下午1:45:08
	 * @param info
	 * @return
	 */
	
	public static final int NUMBEWR_OF_60000 = 60000;
	public static final int NUMBEWR_OF_10000 = 10000;
	public static final int NUMBEWR_OF_443 = 443;
	@Override
	public String synStocktasking(SynchronousStocktaskingInfo info) {
		try {
			HttpClient httpClient = new HttpClient();

			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();

			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(NUMBEWR_OF_60000);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(NUMBEWR_OF_10000);
			Protocol myhttps = new Protocol("https",
					new MySSLProtocolSocketFactory(), NUMBEWR_OF_443);
			Protocol.registerProtocol("https", myhttps);
			// 构造PostMethod的实例
			// System.out.println(synUrl+"==========");
			// PostMethod postMethod = new
			// PostMethod("http://10.224.197.35:8089/lsp/webservice/fixassetMobileRest/processRestRequest");
			PostMethod postMethod = new PostMethod(synUrl);
			String json = JSONObject.toJSONString(info);

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "MOBILE_UPDATEASSETINFO_LSP");// 接口类型
			jsonObj.put("requestEntity", json);
			// 声明一个map
			Map<String, String> map = new HashMap<String, String>();
			// map put数据
			map.put("version", "1.0");
			// map put数据
			map.put("Content-Type", "application/json;charset=UTF-8");
			// map put数据
			map.put("esbServiceCode", "ESB_DPM2ESB_LSP_ASSETS_REQCODE_LIST");
			// map put数据
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "DPM");
			// json转string
			String js = jsonObj.toString();
			// System.out.println(js+"=============");
			// 设置对象格式
			RequestEntity entity = new StringRequestEntity(js,
					"application/json", "UTF-8");
			// 塞入数据
			postMethod.setRequestEntity(entity);
			// 设置格式
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			// 转json格式
			postMethod.addRequestHeader("requestHeaders",
					JSONObject.toJSONString(map));
			// 执行postMethod
			httpClient.executeMethod(postMethod);
			String responseBody = postMethod.getResponseBodyAsString();
			// System.out.println(responseBody+"  返回");
			return responseBody;
		} catch (Exception e) {
			if(info!=null){
				Logger.info("synStocktasking：盘点单号："+info.getBillNo() + "的管理编码："+info.getManagementCode()+"盘点扫描调用LSP异常："+e);
			}else{
				Logger.info("synStocktasking：info对象为空！！！");
			}
			// 抛出异常
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param synUrl
	 *            地址
	 */
	public void setSynUrl(String synUrl) {
		this.synUrl = synUrl;
	}

	/**
	 * @return 地址
	 */
	public String getSynUrl() {
		return synUrl;
	}

	/**
	 * @param num
	 *            对数字进行操作
	 */
	public void getNumber(int num) {
		if(num ==1 ) {
			//日起转换
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
//			String res = dateFormat.format(new Date());
//			long id = System.currentTimeMillis();
			//换算前一个月数据
			Calendar calendar = Calendar.getInstance();
			Date date = new Date();
			calendar.setTime(date);
			//进行转换
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			date = calendar.getTime();
//			String str = dateFormat.format(date);
			
			
		}

	}

}
