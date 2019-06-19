package com.deppon.montal.util.redis.service.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.deppon.montal.util.redis.util.TaskServlet;

/**
 * Servlet implementation class autofresh
 */
public class Autofresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(TaskServlet.class);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("-------------autorefresh--------->开始初始化用户数据和权限的数据");
		
		/**
		 * 初始化用户信息和权限信息
		 */
		try{
			InitAllUsers.initAllUser2Redis();
//			InitAllUsers.initAllRoleJobname();
//			InitAllUsers.initAllDpmonEmployee();
//			InitAllUsers.synDpmonEmployee();
//			InitAllUsers.synRole();
			InitWorkflowInfo.initAllWorkflow2Redis();
			InitWorkflowInfo.synWorkflowInfo();
			InitDictEntry.initAllDictEntry2Redis();
			InitDictEntry.synDictEntry();
		}catch(Exception ex){
			request.getSession().setAttribute("message", "刷新失败");
			request.getRequestDispatcher("jsp/forward.jsp").forward(request, response);
			ex.printStackTrace();
		}
		request.getSession().setAttribute("message", "刷新成功");
		request.getRequestDispatcher("jsp/forward.jsp").forward(request, response);
		logger.info("------------autorefresh---------->初始化完毕");
	}

}
