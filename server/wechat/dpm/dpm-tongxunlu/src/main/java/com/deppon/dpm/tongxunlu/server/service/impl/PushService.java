package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import com.deppon.dpm.tongxunlu.server.dao.IJPushDao;
import com.deppon.dpm.tongxunlu.server.service.IJpushService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.vo.JpushVO;

/**
 * 提供的接口. TODO(描述类的职责)
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:130126,date:2014-4-10 下午3:50:39,content:TODO
 * </p>
 * 
 * @author 130126
 * @date 2014-4-10 下午3:50:39
 * @since
 * @version
 */
public class PushService implements IJpushService {
	private static final Logger logger = Logger.getLogger(PushService.class);
	// set
	private IJPushDao dao;

	/**
	 * 发送到苹果.
	 * 
	 * @param userId
	 *            用户id
	 * @param sysCode
	 *            系统名
	 * @param content
	 *            发送的内容
	 * @param extras
	 *            附带的数据信息
	 */
//	private int sendToIphone(String userId, String sysCode, String content,
//			Map<String, Object> extras) {
//		// 发送到苹果手机,到数据库查询要发送的苹果推送的注册的token。
//		List<JpushVO> vos = queryTagAndAlias(userId, sysCode, Constants.PINGGUO); 
//		if (vos != null && vos.size() > 0) {
//			//添加多个token准备进行发送。
//			List<String> tokens = new ArrayList<String>(vos.size());
//			for (JpushVO v : vos) { 
//				// 添加多个token
//				tokens.add(v.getToken());
//			}
//			//只有有token的时候才调用推送接口
//			if(tokens.size()>0){
//				// 循环发送
//				return IphonePushUtil.sendMessage(tokens, content, extras);
//			}else{
//				return 0;
//			}
//		}
//		return 2;
//	}

	@Override
	public String sendNotification(String sysCode, String content,
			Map<String, Object> extras) {
//		String type = extras.get("type") + "";
//		// 发送到android
//		if (!"1".equals(type) && !"3".equals(type)) {
//			// 通过tag发送通知
//			JpushUtil.sendNotificationByTag(sysCode, content, extras);
//		}
//		// 发送到苹果手机
//		if (!"2".equals(type) && !"4".equals(type)) {
//			// 发送给iphone
//			sendToIphone(null, sysCode, content, extras);
//		}
		return "ok";
	}

	@Override
	public String sendNotificationToOne(String sysCode, String userId,
			String content, Map<String, Object> extras) {
		// 获取设备类型
//		String type = extras.get("type") + "";
		// 结果
		String resultOK="";
//		// 发送到安卓.
//		if (!"1".equals(type) && !"3".equals(type)) {
//			// 通过别名查询用户
//			List<JpushVO> vos = queryTagAndAlias(userId, sysCode,
//					Constants.ANDROID);
//			if (vos!=null&&vos.size() > 0) {
////				System.out.println("查询到的token;" + vos.get(0).getToken());
//				logger.info("查询到的token:" + vos.get(0).getToken());
//				// 通过别名推送
//				MessageResult result = JpushUtil.sendNotificationByAlias(vos
//						.get(0).getToken(), content, extras);
//				if (result.isResultOK()){
//					// 格式化返回
//					resultOK=JSON.toJSONString(result); 
//				}else{
//					// 格式化返回
//					resultOK="android:NO";
//				}
//					//return JSON.toJSONString(result); 
//			} else {
//				//"没有找到注册的安卓推送用户信息";
//				resultOK="android:NO_device";
//			}
//		}
//		// 发送到苹果手机
//		if (!"2".equals(type) && !"4".equals(type)){
//			// 发送
//			int isok = sendToIphone(userId, sysCode, content, extras);
//			if(isok==1){
//				// 返回结果
//				resultOK="ok";
//			}else if(isok==0){
//				// 返回结果
//				resultOK+="iphone:NO";
//			}else if(isok==2){
//				// 返回结果
//				resultOK+="iphone:NO_device";
//			}
//		}
		// 结果返回
		return resultOK;

	}

	private String saveJpushVo(String deviceType, String token, String sysCode,
			String userId) {
		JpushVO vo = new JpushVO();
		// 生成的别名是这样计算出来的.
		if (Constants.ANDROID.equals(deviceType))
			token = DigestUtils.md5Hex(sysCode + userId
					+ deviceType + System.currentTimeMillis());
		else if (Constants.PINGGUO.equals(deviceType)) {
			logger.info("saveJpushVo::PINGGUO");
			// 苹果是直接上传的token，不是生成的。
		} else {
			throw new RuntimeException("不支持的终端类型.");
		}
		vo.setUserId(userId);
		vo.setSysCode(sysCode);
		vo.setDeviceType(deviceType);
		vo.setToken(token);// 再插入新的数据
		dao.savePushUser(vo);
		return token;
	}

	@Override
	public String saveTagAndAlias(String userId, String sysCode,
			String deviceType, String token) {
		List<JpushVO> ans = queryTagAndAlias(userId, sysCode, deviceType);
		// 如果找不到以前的记录，就插入新的数据
		if (ans==null||ans.size() == 0) {
			token = saveJpushVo(deviceType, token, sysCode, userId);
		}
		// 否则就返回以前的token.
		else {
			String dbToken = ans.get(0).getToken();
			// 如果是苹果上传，如果数据库里面的和上传的token不一样，就更新.
			if (dbToken != null && token != null && !dbToken.equals(token)
					&& Constants.PINGGUO.equals(deviceType)) {
				JpushVO vo = new JpushVO();
				vo.setUserId(userId);
				vo.setSysCode(sysCode);
				vo.setDeviceType(deviceType);
				vo.setToken(token);
				dao.updatePushUser(vo);
			}

			// 如果是android，以前没有保存token，就添加新的数据
			if (dbToken == null && Constants.ANDROID.equals(deviceType)) {
				dao.deletePushUser(userId, sysCode, deviceType);
				token = saveJpushVo(deviceType, token, sysCode, userId);
			}
			// 如果是android， 以前保存了token，就返回以前的值.
			else if (Constants.ANDROID.equals(deviceType) && dbToken != null) {
				return dbToken;
			}
		}
		return token;
	}

	@Override
	public void deleteTagAndAlias(String userId, String sysCode,
			String deviceType) {
		// 删除
		dao.deletePushUser(userId, sysCode, deviceType);
	}

	@Override
	public List<JpushVO> queryTagAndAlias(String userId, String sysCode,
			String deviceType) {
		// 查询
		JpushVO vo = new JpushVO();
		// 设置条件
		vo.setUserId(userId);
		// 设置条件
		vo.setSysCode(sysCode);
		// 设置条件
		vo.setDeviceType(deviceType);
		// 返回查询结果
		return dao.selectPushUser(vo);
	}
	
	public IJPushDao getDao() {
		return dao;
	}

	public void setDao(IJPushDao dao) {
		this.dao = dao;
	}
}
