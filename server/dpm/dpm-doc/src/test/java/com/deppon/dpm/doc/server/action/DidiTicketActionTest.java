package com.deppon.dpm.doc.server.action;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.IDidiTicketService;


/**					
 *                         _ooOoo_
 *                        o8888888o
 *                        88" . "88
 *                        (| -_- |)
 *                        O\  =  /O
 *                     ____/`---'\____
 *                   .'  \\|     |//  `.
 *                  /  \\|||  :  |||//  \     
 *                 /  _||||| -:- |||||-  \   
 *                 |   | \\\  -  /// |   |
 *                 | \_|  ''\---/''  |   |  
 *                 \  .-\__  `-`  ___/-. /  
 *               ___`. .'  /--.--\  `. . __   
 *            ."" '<  `.___\_<|>_/___.'  >'"".
 *           | | :  ` - `.;`\ _ /`;.`/ - ` : | |       
 *           \  \ `-.   \_ __\ /__ _/   .-` /  /         
 *      ======`-.____`-.___\_____/___.-`____.-'======          
 *                         `=---='             
 *      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                    佛祖保佑       永无BUG 
 *                    佛祖镇楼        BUG辟易
 *                    
 *       佛曰:  写字楼里写字间，写字间里程序员；
 *              程序人员写程序，又拿程序换酒钱。
 *              酒醒只在网上坐，酒醉还来网下眠；
 *              酒醉酒醒日复日，网上网下年复年。
 *              但愿老死电脑间，不愿鞠躬老板前；
 *              奔驰宝马贵者趣，公交自行程序员。
 *              别人笑我忒疯癫，我笑自己命太贱；
 *              不见满街漂亮妹，哪个归得程序员？
 *
 */
				
public class DidiTicketActionTest extends TestCase {

	private IDidiTicketService didiTicketService;
	protected ApplicationContext appContext = null;
	DidiTicketAction testdiditick;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		testdiditick = new DidiTicketAction();
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiTicketService = (IDidiTicketService) appContext
				.getBean("didiTicketService");

	}
	@Test
	public void testallMethod() throws Exception {
		
//		testdiditick.setDidiTicketService(didiTicketService);
//		testdiditick.getTicket();
		System.out.println(didiTicketService);
	}

}
