package com.deppon.dpm.module.lsp.server.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jettison.json.JSONArray;
import org.json.JSONObject;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.lsp.server.service.IFixedAssetsCheckService;
import com.deppon.dpm.module.lsp.shared.domain.FixedAssetsCheckReEntity;

/**
 * 固定资产列表请求Action
 * @author 233357
 * @date 2015/03/19
 *
 */
public class FixedAssetsCheckAction extends BaseAction{
	
	private static final long serialVersionUID = 1397420409043898745L;
	
	// ESB TYPE
	private static final String ESB_TYPE = "MOBILE_GETTASKLIST_LSP";
	
	//服务接口
	private IFixedAssetsCheckService fixedAssetsCheckService;

	public void setFixedAssetsCheckService(
			IFixedAssetsCheckService fixedAssetsCheckService) {
		this.fixedAssetsCheckService = fixedAssetsCheckService;
	}

	
	// 记录请求固定资产列表信息的访问时间服务
	private IMonitorCountInfoService monitorCountInfoService;

	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}


	//固定资产盘点单单据编号
    private String stockTaskingFnumber; 
	
	public String getStockTaskingFnumber() {
		return stockTaskingFnumber;
	}

	public void setStockTaskingFnumber(String stockTaskingFnumber) {
		this.stockTaskingFnumber = stockTaskingFnumber;
	}
	
	/**
	 * 根据单据编号查询固定资产盘点列表信息
	 */
	public void queryFixedAssets() {
		// 开始时间
		Date startDt = new Date();
		
		// 传入的实体类封装
		FixedAssetsCheckReEntity assetsCheckReEntity = new FixedAssetsCheckReEntity();
		assetsCheckReEntity.setType(ESB_TYPE);
		assetsCheckReEntity.setRequestEntity(stockTaskingFnumber);
		
		// 设置页面响应实体
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 调用服务接口，请求列表数据
		String rs = fixedAssetsCheckService.getFixedAssets(assetsCheckReEntity);
		
		int count=0;
        String billNo="";
        // 结束时间
		Date endDt = new Date();
		// 根据后台接受的值判断设定
		if (null == rs || rs.equals("")) {
			rs = "{\"resultFlag\":false,\"failureReason\":\"资产列表暂无数据！\",\"responseEntity\":null}";
			response.setStatus(HttpStatus.SC_FORBIDDEN);
		}else{
			try {
				/*
				 * 获取任务编号和应盘个数
				 */
			    JSONObject json= new JSONObject(rs);
				String responseEntity=json.get("responseEntity").toString();
				JSONArray reList=new JSONArray(responseEntity);
				count=reList.length();
				String ob=reList.get(0).toString();
				JSONObject jsonObject= new JSONObject(ob);
				billNo=jsonObject.get("billNo").toString();
				
			    //查询当前任务是否有过数据监控
			    int num=monitorCountInfoService.queryCountInfoCount(billNo);
			    if(num==0){
					//资产任务应盘个数数据监控
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("userId", userId);
					map.put("startDt", startDt);
					map.put("endDt", endDt);
					map.put("type", Constants.ASSETS_CHECKNUM);
					//应盘个数
					map.put("count", count);
					//任务编号
					map.put("billNo", billNo);
					monitorCountInfoService.saveClackCountInfo(map);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// 保存资产盘点数据监控到数据库
		monitorCountInfoService.saveMonitorCountInfo(userId,startDt,endDt,Constants.ASSETS_STOCK);
		
		// 返回给页面
		writeToPage(response, rs);
	}

}
