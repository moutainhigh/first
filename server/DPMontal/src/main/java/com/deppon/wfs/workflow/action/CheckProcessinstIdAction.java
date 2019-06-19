package com.deppon.wfs.workflow.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deppon.montal.action.RootAbstractAction;
import com.deppon.wfs.workflow.service.CheckProcessinstIdService;

public class CheckProcessinstIdAction extends RootAbstractAction{
	
	CheckProcessinstIdService service = new CheckProcessinstIdService();
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int contractProcessinstid = Integer.parseInt(request.getParameter("contractProcessinstid"));
		char msg = service.check(contractProcessinstid);
		response.getWriter().write(msg);
		
	}
}
