package com.deppon.montal.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象ACTION，独立于应用。作为整个项目的根SERVLET
 * 负责接收用户HTTP请求
 * 
 * @author lin.liu
 */
public class RootAbstractAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		doGet((HttpServletRequest)arg0, (HttpServletResponse)arg1);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.request = request;
		this.response = response;
		
		initialize();
		
		response();
	}

	/**
	 * ACTION响应方法，由子类继承并完善
	 * 子类的业务逻辑以这个方法为入口
	 */
	protected void response(){
		System.out.println("[RootAbstractAction] response");
	}
	
	/**
	 * ACTION每次响应前的初始方法，
	 * 由子类继承并完善。
	 */
	protected void initialize(){
		System.out.println("[RootAbstractAction] initialize");
	}
	
}
