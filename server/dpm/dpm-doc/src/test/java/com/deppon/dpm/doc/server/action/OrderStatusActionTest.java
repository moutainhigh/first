package com.deppon.dpm.doc.server.action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.doc.server.service.IDidiTicketService;
import com.deppon.dpm.doc.server.service.IOccupyBudgetService;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class OrderStatusActionTest extends TestCase {

	/**
	 * 滴滴订单服务
	 */
	private IDidiOrderService didiOrderService;
	/**
	 * 更新预算服务
	 */
	private IOccupyBudgetService occupyBudgetService;
	/**
	 * 发单Ticket服务
	 */
	private IDidiTicketService didiTicketService;
	protected ApplicationContext appContextorder = null;
	protected ApplicationContext appContextbudget = null;
	protected ApplicationContext appContextticket = null;
	
	OrderStatusAction testorderstatus;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testorderstatus = new OrderStatusAction();
		appContextorder = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiOrderService = (IDidiOrderService) appContextorder.getBean("didiOrderService");
		
		appContextbudget = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		occupyBudgetService = (IOccupyBudgetService) appContextbudget.getBean("occupyBudgetService");
		
		appContextticket = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiTicketService = (IDidiTicketService) appContextticket.getBean("didiTicketService");

	}
	
	@Test
	public void testallMethod() throws Exception {
		
//		testorderstatus.setDidiOrderService(didiOrderService);
//		testorderstatus.setOccupyBudgetService(occupyBudgetService);
//		testorderstatus.setDidiTicketService(didiTicketService);
//		testorderstatus.sendAuthorize();
//		testorderstatus.sendOrderStatus();
		System.out.println(didiOrderService);
		System.out.println(occupyBudgetService);
		System.out.println(didiTicketService);
	}
	
}
