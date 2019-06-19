package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.dao.ISendParcelWorkDao;
import com.deppon.dpm.module.management.server.service.ISendParcelWorkService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ParcelListVO;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**   
* @Description: 收发室管理
* @author 268087 张广波
* @date 2015-11-16 下午2:12:03 
* @version V1.0 
*/
public class SendParcelWorkService implements ISendParcelWorkService {
	/**
	 * @Fields logger 日志
	 */
	private Logger logger = LoggerFactory.getLogger(SendParcelWorkService.class);
	/** 
	* @Fields sendParcelWorkDao 收发室管理业务操作dao
	*/ 
	private ISendParcelWorkDao sendParcelWorkDao;
	private ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService;
	
	/** 判断当前用户是否收发室管理员
	 * @param empCode 员工号
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#checkIsSendAdm(java.lang.String)
	 */
	public int checkIsSendAdm(String empCode) {
		return sendParcelWorkDao.checkIsSendAdm(empCode);
	}
	
	/** 查询人员详细信息接口
	 * @param empVO
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#queryEmpInfoList(com.deppon.dpm.module.management.shared.vo.EmpVO)
	 */
	public List<EmpVO> queryEmpInfoList(EmpVO empVO) {
		List<EmpVO> empVOs = new ArrayList<EmpVO>();
		empVOs = sendParcelWorkDao.queryEmpInfoList(empVO);
		return empVOs;
	}

	/** 根据当前登录人工号查询已领取列表
	 * @param parcelListVO
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#queryParcelList(com.deppon.dpm.module.management.shared.vo.ParcelListVO)
	 */
	public List<ParcelListVO> queryParcelList(ParcelListVO parcelListVO) {
		List<ParcelListVO> listVOs = new ArrayList<ParcelListVO>();
		listVOs = sendParcelWorkDao.queryParcelList(parcelListVO);
		return listVOs;
	}

	/** 查询通告
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#queryNotice()
	 */
	public String queryNotice() {
		return StringUtil.isBlank(sendParcelWorkDao.queryNotice())?"温馨提示：包裹和快递领取时间 12:00~13:30　17:30~20:00　 信件和账单领取时间 13:30-  17:30":sendParcelWorkDao.queryNotice();
	}
	
	/** 更新通告
	 * @param content
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#updateNotice(java.lang.String)
	 */
	
	public int updateNotice(String content) {
		return sendParcelWorkDao.updateNotice(content);
	}
	
	/** 保存代领人员信息
	 * @param jsonParcelStr
	 * @param retMap
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.ISendParcelWorkService#saveParcelAct(java.lang.String, java.util.HashMap)
	 */
	
	public Map<String, Object> saveParcelAct(String jsonParcelStr,HashMap<String, Object> retMap) {
		if (StringUtil.isBlank(jsonParcelStr)) {
			retMap.put("resultFlag", false);
			retMap.put("failureReason", "传入的参数不能为空!");
		} else {
			JSONObject jsonObject = new JSONObject().parseObject(jsonParcelStr);
			ParcelListVO vo = new ParcelListVO();
			int retInt = 0;
			//int upRetInt =0;
			// 签收时间
			vo.setReceiveDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			if (!StringUtil.isBlank(jsonObject.getString("userName"))&& !StringUtil.isBlank(jsonObject.getString("userNo"))&& !StringUtil.isBlank(jsonObject.getString("packageId"))) {
				vo.setUserName(jsonObject.getString("userName"));
				vo.setUserNo(jsonObject.getString("userNo"));
				vo.setPackageId(Integer.parseInt(jsonObject.getString("packageId")));
				if (sendParcelWorkDao.checkIsRepeat(vo) > 0) {
					retMap.put("resultFlag", false);
					retMap.put("failureReason", "不能重复提交!");
				} else {
					retInt = sendParcelWorkDao.saveParcelAct(vo);
					//upRetInt = sendParcelWorkDao.updatePostStatus(vo);
					if (retInt > 0) {
						try {
							logger.info("进入发送消息方法");
							sendReceiveRoomMessNotificationService.generationLeaderMessage(jsonObject.getString("userNo"), jsonObject.getString("userName"), Long.parseLong(jsonObject.getString("packageId")));
						} catch (Exception e) {
							e.printStackTrace();
							logger.info("saveParcelAct发送消息方法错误");
						}
						retMap.put("resultFlag", true);
						retMap.put("failureReason", "保存成功!");
					} else {
						retMap.put("resultFlag", false);
						retMap.put("failureReason", "保存失败!");
					}
				}
			} else {
				retMap.put("resultFlag", false);
				retMap.put("failureReason", "传入的参数有为空!");
			}
		}
		return retMap;
	}

	/** 
	* @Description: 获取数据操作dao
	* @author 268087 张广波
	* @date 2015-11-16 下午5:18:04 
	*  @return 
	*/
	public ISendParcelWorkDao getSendParcelWorkDao() {
		return sendParcelWorkDao;
	}

	/** 
	* @Description: 设置数据操作dao
	* @author 268087 张广波
	* @date 2015-11-16 下午5:18:36 
	*  @param sendParcelWorkDao 
	*/
	public void setSendParcelWorkDao(ISendParcelWorkDao sendParcelWorkDao) {
		this.sendParcelWorkDao = sendParcelWorkDao;
	}

	/** 
	* @Description: 获取操作service
	* @author 268087 张广波
	* @date 2015-11-18 下午4:04:25 
	*  @return 
	*/
	public ISendReceiveRoomMessNotificationService getSendReceiveRoomMessNotificationService() {
		return sendReceiveRoomMessNotificationService;
	}

	/** 
	* @Description: 设置操作service
	* @author 268087 张广波
	* @date 2015-11-18 下午4:04:28 
	*  @param sendReceiveRoomMessNotificationService 
	*/
	public void setSendReceiveRoomMessNotificationService(
			ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService) {
		this.sendReceiveRoomMessNotificationService = sendReceiveRoomMessNotificationService;
	}

}
