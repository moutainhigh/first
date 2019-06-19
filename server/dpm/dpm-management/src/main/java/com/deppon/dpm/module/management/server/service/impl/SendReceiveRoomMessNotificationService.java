package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.jfree.util.Log;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.management.server.dao.ISendParcelDao;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;

/**
* @ClassName: SendReceiveRoomMessNotificationService
* @Description: SendReceiveRoomMessNotificationService接口的实现
* @author A18ccms a18ccms_gmail_com
* @date 2016-4-8 上午11:47:08
* 
*/

public class SendReceiveRoomMessNotificationService implements
		ISendReceiveRoomMessNotificationService {
	/**
	 * 日志
	 */
	private static Logger logger = Logger
			.getLogger(SendReceiveRoomMessNotificationService.class);
   //dao的注入
	private ISendParcelDao sendParcelDao;
   //get set
	public ISendParcelDao getSendParcelDao() {
		return sendParcelDao;
	}
	 //get set
	public void setSendParcelDao(ISendParcelDao sendParcelDao) {
		this.sendParcelDao = sendParcelDao;
	}

	/**
	 * 推送消息方法
	 */
	private TpushNewsService tpushNewsService;
    // tpushNewsService
	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}
    //tpushNewsService
	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/**
	 * 记录提交响应时长
	 */
	private IMonitorCountInfoService monitorCountInfoService;
    //monitorCountInfoService
	public IMonitorCountInfoService getMonitorCountInfoService() {
		return monitorCountInfoService;
	}
    //monitorCountInfoService
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	/**
	 * 新包裹.
	 */
	private static final Integer NEW_PACKAGE = 0;

	/**
	 * 已签收.
	 */
	private static final Integer HAS_BEEN_SIGNED = 1;

	/**
	 * 已拒收.
	 */
	private static final Integer REJECTED = 2;

	/**
	 * 已注销.
	 */
	private static final Integer CANCELLED = 3;

	/**
	 * 催领.
	 */
	private static final Integer RECEIVE_REMINDERS = 4;
	
	//收发室状态
	private static final int SENDRECEIVEROOMMESS_STAUTS = 9;

	/**
	 * 判断推送消息方法.
	 * 
	 * @param packageId
	 *            包裹唯一标示.
	 */
	@Override
	public void judgmentMessage(Long packageId) {

		Date startDate = new Date(); // 开始时间

		logger.info("已经进入消息方法》》》》SendReceiveRoomMessNotificationService中的方法judgmentMessage");
		logger.info("传入参数的值为:packageId:" + packageId);
		NewsCenterEntity nce = null;
		try {
			//得到包裹唯一标示
			ParcelEntity parcelEntity = sendParcelDao.getPackageInfo(packageId);

			// sdf用来将String类型的时间转换成Date类型的时间（时间格式是：yyyy-MM-dd）
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// sdf2将sdf转换的Date类型的时间转换成String的类型。（时间格式是：yyyy年MM月dd日）
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");

			if (null != parcelEntity) { // 判断实体类是否不为空，不为空的时候才继续往下面执行下去
				logger.info("parcelEntity的id和名称:" + parcelEntity.getUserNo() + " "
						+ parcelEntity.getUserName());
				// 包裹领取、催领通知.
				String newPackageMess = "您好！"
						+ sdf2.format(sdf.parse(parcelEntity.getArriveDate()))
						+ "您有"
						+ parcelEntity.getPackageType()
						+ "已送至"
						+ parcelEntity.getAddressName()
						+ ".";

				// 已注销通知
				String cancelMess = "您好!"
						+ sdf2.format(sdf.parse(parcelEntity.getArriveDate()))
						+ "由于系统原因,信息匹配错误,您当日无快递到达,无需至"
						+ parcelEntity.getAddressName() + "领取.";

				// 已签收、代领通知
				String hasBeenMess = "您好!"
						+ sdf2.format(sdf.parse(parcelEntity.getArriveDate()))
						+ "到达的" + parcelEntity.getPackageType() + "快递已签收!签收人:"
						+ parcelEntity.getUserNo() + ""
						+ parcelEntity.getUserName() + ".";

				// 已拒收通知
				String rejectedMess = "您好!"
						+ sdf2.format(sdf.parse(parcelEntity.getArriveDate()))
						+ "到达的" + parcelEntity.getPackageType()
						+ "快递1件已按您要求退回快递公司.";

				logger.info("包裹领取、催领通知:" + newPackageMess);
				logger.info("已注销通知:" + cancelMess);
				logger.info("已签收、代领通知:" + hasBeenMess);
				logger.info("已拒收通知:" + rejectedMess);
                //new 一个对象构造方法
				nce = new NewsCenterEntity("18", SENDRECEIVEROOMMESS_STAUTS, 0, 1, "收发室");
				//判断是什么包裹类型
				if (parcelEntity.getParcelState() == NEW_PACKAGE
						|| parcelEntity.getParcelState() == RECEIVE_REMINDERS) { // 状态为新包裹、催领
					logger.info("进入新包裹和催领消息方法");
					tpushNewsService.pushUserNews(parcelEntity.getUserNo(),
							"收发室通知", newPackageMess, nce);
				} else if (parcelEntity.getParcelState() == CANCELLED) { // 已注销
					logger.info("进入已注销消息方法");
					tpushNewsService.pushUserNews(parcelEntity.getUserNo(),
							"收发室通知", cancelMess, nce);
				} else if (parcelEntity.getParcelState() == HAS_BEEN_SIGNED) { // 已签收、代领
					logger.info("进入已签收、代领通知方法");
					tpushNewsService.pushUserNews(parcelEntity.getUserNo(),
							"收发室通知", hasBeenMess, nce);
                    //判断是否是代领取
					//抽取方法
					pushUserNews(packageId, nce, parcelEntity, hasBeenMess);

				} else if (parcelEntity.getParcelState() == REJECTED) { // 已拒收
					logger.info("进入已拒收通知方法");
					tpushNewsService.pushUserNews(parcelEntity.getUserNo(),
							"收发室通知", rejectedMess, nce);
				} else { // 其它状态
					logger.info("parcelState不是规定状态,parcelState:"
							+ parcelEntity.getParcelState());
				}
				Date endDate = new Date(); // 结束时间
				//保存一个数据
				monitorCountInfoService.saveMonitorCountInfo(
						parcelEntity.getUserNo(), startDate, endDate,
						Constants.PUSH_THE_NUMBER_OF_PARCELS_SENT);
				logger.info("程序运行结束。");
			} else {
				logger.info("parcelEntity为空,推送消息失败！！");
			}
		} catch (Exception e) {
			//捕获异常
			e.printStackTrace();
			logger.info("推送消息失败！！");
		}
	}
	public void pushUserNews(Long packageId, NewsCenterEntity nce,
			ParcelEntity parcelEntity, String hasBeenMess) {
		if (parcelEntity.getPostStatus() == 1) { // 判断如果为代领取
			List<ParcelEntity> parcelEntityList = sendParcelDao
					.getPackageList(packageId);
			//判断是否为null
			if (!parcelEntityList.isEmpty()) {
				//循环Push数据
				for (ParcelEntity peList : parcelEntityList) {
					tpushNewsService.pushUserNews(
							peList.getForUserNo(), "收发室通知",
							hasBeenMess, nce);
				}
			} else {
				logger.info("parcelEntityList为空！");
			}
		}
	}
	 /**
     * 给代领人发送信息.
     * @param userNo 代领人工号
     * @param userName 代领人姓名
     * @param packageId 包裹唯一标示
     */
	@Override
	public void generationLeaderMessage(String userNo, String userName,
			Long packageId) {
		logger.info("进入给代领人发送的消息方法");
		logger.info("userNo:" + userNo);
		logger.info("userName:" + userName);
		logger.info("packageId:" + packageId);
		NewsCenterEntity nce = null;
		try {
			nce = new NewsCenterEntity("18", SENDRECEIVEROOMMESS_STAUTS, 0, 1, "收发室");
			ParcelEntity parcelEntity = sendParcelDao.getPackageInfo(packageId);
			if (parcelEntity != null) {
				// 本人通知
				String message = "您的包裹已经委托给" + userNo + " " + userName;
				// 代理人通知
				String generationMessage = parcelEntity.getUserNo() + " "
						+ parcelEntity.getUserName() + "的包裹已经委托给您,请尽快来领取.";
				// 推送消息给本人
				tpushNewsService.pushUserNews(parcelEntity.getUserNo(),
						"收发室通知", message, nce);
				// 推送消息给代领人
				tpushNewsService.pushUserNews(userNo, "收发室通知",
						generationMessage, nce);
			} else {
				logger.info("generationLeaderMessage实体类为空");
			}
		} catch (Exception e) {
			//捕获异常
			e.printStackTrace();
			logger.info("generationLeaderMessage推送消息失败！！");
		}
	}

	/* 
	 * 把推送消息保存在本地数据库
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService#saveMesssageToDB(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveMesssageToDB(String userNo, String content,
			int parcelState, String statusTime) {
		try{
			//new 一个新的对象
			MailReceiveSendFunctionEntity parBean = new MailReceiveSendFunctionEntity();
			parBean.setUserNo(userNo);
			parBean.setMessage(content);
			parBean.setParcelState(parcelState);
			parBean.setEnterTime(statusTime);
			//保存消息
			sendParcelDao.saveMesssageToDB(parBean);
		}catch(Exception e){
			//捕获异常
			Log.info("收发室消息通知保存异常");
			e.printStackTrace();
		}
	
	}
	
	/* 
	 * 把推送消息保存在本地数据库(催领单独查询、保存)
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService#saveMesssageToDB(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void saveMesssageToDBCorporal(Long packageId) {
		try{
			String content = "你的包裹已经被催领，如有疑问，请及时联系收发室，谢谢！";
			//得到工号
			String userNo = sendParcelDao.queryMesssageToDBCorporal(packageId);
			logger.info("userNo"+userNo);
			//时间格式的转换
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//new 一个新的对象
			MailReceiveSendFunctionEntity parBean = new MailReceiveSendFunctionEntity();
			//set数据
			parBean.setUserNo(userNo);
			parBean.setMessage(content);
			parBean.setParcelState(com.deppon.dpm.module.management.util.Constants.MailRecSen_Corporal);
			parBean.setEnterTime(format.format(new Date()));
			//插入数据
			sendParcelDao.saveMesssageToDB(parBean);
		}catch(Exception e){
			//捕获异常
			Log.info("收发室消息通知保存异常");
			e.printStackTrace();
		}
	
	}
	
}
