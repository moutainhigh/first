package com.deppon.montal.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.action.AppDelegateAction;
import com.deppon.montal.common.service.ISelectorService;
import com.deppon.montal.common.service.impl.SelectorServiceImpl;
import com.deppon.montal.module.workitems.action.OtherSysApproveWFAction;

public class SelectorAction extends AppDelegateAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger  = Logger.getLogger(OtherSysApproveWFAction.class);
	private ISelectorService selectorService = new SelectorServiceImpl();
	protected void response() {
		List<Map<String,String>> list = null;
		int totalCount = 0;
		String selectorType = reqPara.get("selectorType");
		if("empSelector".equals(selectorType)){
			//查询人员  脚本条件
			String finasyscode1 = reqPara.get("finasyscodeQuery");
			if(finasyscode1 != null && finasyscode1 != ""){
				reqPara.put("finasyscodeQuery", "'" + finasyscode1 + "'");
			}
			//查询人员信息
			list = selectorService.queryList(reqPara);
			int size = list == null ? 0 : list.size();
			//查询某一机构下人员信息
			if(size == 1 && finasyscode1 != null && finasyscode1 != ""){
				String managerid = list.get(0).get("MANAGERID");
				String empCode = list.get(0).get("EMPCODE");
				//当前部门下只有经理  需查询下级部门人员
				if(managerid.equals(empCode)){
					//查询当前用户所属部门的下属机构
					String finasyscode = selectorService.queryOrgFinasyscode(reqPara);
					reqPara.put("finasyscodeQuery", finasyscode);
					list = selectorService.queryList(reqPara);
					totalCount = selectorService.queryCount(reqPara);
				}else{
					totalCount = selectorService.queryCount(reqPara);
				}
			}else{
				totalCount = selectorService.queryCount(reqPara);
			}
			
		}else if("deptSelector".equals(selectorType)){
			list = selectorService.queryList(reqPara);
			totalCount = selectorService.queryCount(reqPara);
		}
		
		
		//
//		list = new ArrayList<Map<String,String>>();
//		totalCount = 0;
		
		response.setHeader( "Pragma", "no-cache" );
		response.addHeader( "Cache-Control", "must-revalidate" );
		response.addHeader( "Cache-Control", "no-cache" );
		response.addHeader( "Cache-Control", "no-store" );
		response.setDateHeader("Expires", 0); 
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter write = null;
		try {
			write = response.getWriter();
			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
			write.write("{'totalCount':'" + totalCount + "','selectorList':'"+ jsonArray + "'}");
		} catch (IOException e1) {
			logger.error("选择器向前台页面写入时候获取输出流异常" + e1.getMessage(),e1);
		}finally {
			write.close();
		}
	}
	/*public static void main(String[] args) {
		List list = null;
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}*/
}
