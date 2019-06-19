package com.deppon.dpm.module.vpp.server.action;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.vpp.server.service.IVisitorService;
import com.deppon.dpm.module.vpp.shared.domain.VisitorEntity;
import com.deppon.dpm.module.vpp.shared.domain.VisitorOrderEntity;

/**
 * 访客机 预约访客信息
 * @version
 */
public class VisitorAction extends BaseAction {
	/** 
	*
	*/
	private static final long serialVersionUID = 1397420409043898745L;
	private static Logger logger  = LoggerFactory.getLogger(VisitorAction.class);
	/**
	 * service
	 */
	private IVisitorService visitorSrv;

	/**
	 * 访客信息预约保存
	 */
	public void visitorAdd() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//编码转换
			str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");;
			//打印出参数
			logger.info("----vpp 访客预约信息保存 action param:" + str);
//			System.out.println(str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//调用service
				//获得 预约结果  {"success":"1","message":"预约成功"}  --0失败 1成功 2重复预约 3接口异常
				String json = visitorSrv.visitorAdd(str);
//				System.out.println(json);
				logger.info("----vpp 访客预约信息保存 action result:" + json);
				if(json == null) {
					//接口调用异常
					json = "{\"success\":\"3\",\"message\":\"供应商服务接口异常\"}";
				}
				//返回给页面
				writeToPage(response, json);
			}
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "{\"success\":\"0\",\"message\":\"预约失败\"}");
		}
	}
	
	/**
	 * 预约信息查询
	 * */
	public void visitorQuery() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//编码转换
			str = java.net.URLDecoder.decode(StringUtil.bufferString(bu),"utf-8");
			//打印参数
			logger.info("-----vpp 查询访客信息：" + str);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//调用service 
				//获得查询结果{"sucess":"1","message":"预约成功"} --0失败1成功
				String json  = visitorSrv.visitorQuery(str);
				logger.info("----vpp 查询预约信息action result" + json);
				//返回给页面
				writeToPage(json);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	} 
	
		/**
	 *访客删除 
	 */
	
	public void visitorDel() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		String str = null;
		try {
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			//编码转换
			str = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			//打印出参数
			logger.info("----vpp 删除访客信息:" + str);
			if(!com.deppon.foss.framework.shared.util.string.StringUtil.isEmpty(str)) {
				//调用service
				//获得 删除结果  {"success":"1","message":"预约成功"}  --0失败 1成功 
				String json = visitorSrv.visitorDel(str);
				logger.info("----vpp 删除预约信 action result:" + json);
				//返回给页面
				writeToPage(json);
			}
			
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
			writeToPage(response, "0");
		}
	}
	
	public static void main(String[] args) {
		VisitorOrderEntity vo = new VisitorOrderEntity();
		vo.setType("0");//个人
		vo.setInnerCode("000001");
		vo.setInnerName("张三");
		VisitorEntity entity = new VisitorEntity(); 
		List<VisitorEntity> vlist = new ArrayList<VisitorEntity>();
		vlist.add(entity);
		vo.setVlist(vlist);
		System.out.println(JSONObject.toJSONString(vo));
		
		//团队
		VisitorOrderEntity vo2 = new VisitorOrderEntity();
		vo2.setType("1");//团队
		vo2.setInnerCode("000001");
		vo2.setInnerName("张三");
		vo2.setCompany("博慧佳有限公司");
		vo2.setThing("1");
		vo2.setVisitorDate("2017-04-18 10:30");
		vo2.setRemark("访客机会议,带一台访客机设备");
		VisitorEntity entity2 = new VisitorEntity(); 
		vlist.add(entity2);
		vo2.setVlist(vlist);
		System.out.println(JSONObject.toJSONString(vo2));
		//查询参数 访客姓名 访客公司 来访日期 被访人工号
		//{"visitorName":"","company":"","visitorDate":"","innerCode":""}
	}

	/**
	 * @param visitorSrv the visitorSrv to set
	 */
	public void setVisitorSrv(IVisitorService visitorSrv) {
		this.visitorSrv = visitorSrv;
	}

}