
package com.deppon.dpm.module.management.server.service.impl;
import com.deppon.dpm.module.management.server.service.IMainPageService;
//import com.deppon.dpm.doc.server.service.IAddMessageService;

public class MainPageService implements IMainPageService {

	
	/**
	 * set injection
	 */
    //private IMainPageDao mainPageDao;
    /**
	 * emailService 注入
	 */
	//private IEmailService emailService;
	
	
	/**
	 * 卡片ID对应 就用   1：通知中心  2：常用应用  3：待审批   4：会议
	 */
	@Override
	public String cardDetailByUserId(String userId) {
		// TODO Auto-generated method stub
		//每个用户默认所有拥有的卡片
		String defaultCards = "1,2,3,4";
		//从数据库中查询用户所拥有的自己定制的卡片ID  因前端暂时没做这个功能  所以这一步先省略 以后做的话只要建张表 （工号，卡片ID,修改时间） 从里面查即可
//		String cardUser = ;
		return defaultCards;
	}
	
	/**
	 * 获取消息类型
	 */
	/*public List<NoticeCenterEntity> getType(){
		
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		nclist = mainPageDao.getType();
		for(NoticeCenterEntity ncEntity : nclist){
			
			if(ncEntity.getType().equals("1")){
				//日程通知
				
			}else if(ncEntity.getType().equals("2")){
				//邮件通知
				
			}else if(ncEntity.getType().equals("3")){
				//欢行通知
				
				
			}else if(ncEntity.getType().equals("4")){
				
			}
		}
		return nclist;
		
	}

	public IMainPageDao getMainPageDao() {
		return mainPageDao;
	}

	public void setMainPageDao(IMainPageDao mainPageDao) {
		this.mainPageDao = mainPageDao;
	}*/

	/*public IEmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}*/
	
}
