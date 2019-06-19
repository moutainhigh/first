package com.deppon.dpm.module.lsp.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

import com.deppon.dpm.module.lsp.server.dao.IAssetStockDao;
import com.deppon.dpm.module.lsp.server.service.IFixedAssetsCheckService;
import com.deppon.dpm.module.lsp.shared.domain.FixedAssetsCheckReEntity;
import com.deppon.dpm.module.lsp.shared.domain.MySSLProtocolSocketFactory;
import com.google.gson.Gson;

/**
 * 固定资产列表服务接口
 * @author 233357
 * @date 2015/03/19
 */
public class FixedAssetsCheckService implements IFixedAssetsCheckService {

	//请求地址
    private String uri;
    private IAssetStockDao assetStockDao; 

  	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	public IAssetStockDao getAssetStockDao() {
		return assetStockDao;
	}

	public void setAssetStockDao(IAssetStockDao assetStockDao) {
		this.assetStockDao = assetStockDao;
	}


	//httpClient
    private HttpClient hclient;
	public static final int NUMBEWR_OF_60000 = 60000;
	public static final int NUMBEWR_OF_10000 = 10000;
	public static final int NUMBEWR_OF_443 = 443;
	@Override
	public String getFixedAssets(FixedAssetsCheckReEntity assetsCheckReEntity) {
		/*HttpResponse hr = null;*/
		String rs = "";
		try{
			//如果盘点任务未超时
			if (assetStockDao.queryStockTimeOut(assetsCheckReEntity.getRequestEntity())>0) {
				Gson gson = new Gson();
				
				hclient = new HttpClient();
				//设置编码格式
				hclient.getParams().setContentCharset("UTF-8");
				// 设置超时时间
				HttpConnectionManagerParams managerParams = hclient
									.getHttpConnectionManager().getParams();
	
				// 设置连接超时时间(单位毫秒)
				managerParams.setConnectionTimeout(NUMBEWR_OF_60000);
				// 设置读数据超时时间(单位毫秒)
				managerParams.setSoTimeout(NUMBEWR_OF_10000);
				Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), NUMBEWR_OF_443);
				Protocol.registerProtocol("https", myhttps); 	
				//构造PostMethod的实例
				PostMethod postMethod = new PostMethod(uri);  
				
				Map<String,String> map = new HashMap<String,String>();
				map.put("version","1.0");
				map.put("Content-Type", "application/json;charset=UTF-8");
				map.put("esbServiceCode", "ESB_DPM2ESB_LSP_ASSETS_REQCODE_LIST");
				map.put("requestId", UUID.randomUUID().toString());
				map.put("sourceSystem", "DPM");
				String jsonStr = gson.toJson(map);
				
				// 设置消息体
				RequestEntity entity = new StringRequestEntity(gson.toJson(assetsCheckReEntity),"application/json","UTF-8");
				postMethod.setRequestEntity(entity);
				
				postMethod.addRequestHeader("Content-Type","application/json;charset=UTF-8");
				postMethod.addRequestHeader("requestHeaders", jsonStr);
				// 执行postMethod
				hclient.executeMethod(postMethod);
				
				rs = postMethod.getResponseBodyAsString();
			}
			else{
				assetStockDao.delStockTask(assetsCheckReEntity.getRequestEntity());//删除超时的盘点任务
				rs = "{\"resultFlag\":false,\"failureReason\":\"盘点任务已超时！\",\"responseEntity\":null}";
			}
		} catch(Exception e) {
			rs = "{\"resultFlag\":false,\"failureReason\":\"抱歉   请求暂时出错   刷新试试！\",\"responseEntity\":null}";
			//System.out.print(e.getMessage());
		}
		return rs;
	}

}
