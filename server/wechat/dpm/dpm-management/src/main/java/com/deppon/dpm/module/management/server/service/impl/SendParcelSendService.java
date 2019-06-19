package com.deppon.dpm.module.management.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.ISendParcelSendDao;
import com.deppon.dpm.module.management.server.service.ISendParcelSendSerice;
import com.deppon.dpm.module.management.shared.domain.ConstantClassField;
import com.deppon.dpm.module.management.shared.domain.SendParcelSendEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;
/**
 * <p>寄快递业务处理实现类<p>
 * @author 袁中华
 * @date 2015 9.9
 */
public class SendParcelSendService implements ISendParcelSendSerice {
	/**
	 * 日志打印
	 */  
	Logger   log =LoggerFactory.getLogger(SendParcelSendService.class);
	/**
	 * 注入
	 */
	ISendParcelSendDao sendParcelSendDao;

	/**
	 * @param sendParcelSendDao 注入
	 */
	public void setSendParcelSendDao(ISendParcelSendDao sendParcelSendDao) {
		this.sendParcelSendDao = sendParcelSendDao;
	}
	/**
	 * 实现业务处理方法
	 */
	
	public String getNeedManage (String stu) throws Exception {
		// TODO Auto-generated method stub
		//解析JSON
		SendParcelSendEntity sendParcelSendEntity = JsonUtil.jsonToEntity(stu,SendParcelSendEntity.class);
		log.debug("sendParcelSendEntity对象值"+sendParcelSendEntity);
		//		简单工厂模式 
		if (StringUtil.isNotEmpty(sendParcelSendEntity.getManageCode())) {
			//判断是否是select
			if (sendParcelSendEntity.getManageCode().equals("SELECT")) {
				log.debug("正在执行查询");
				//返回查询语句结果
				return	selectSendParcelSend();
			}else  if (sendParcelSendEntity.getManageCode().equals("SAVA")) {
				log.debug("正在执行保存");
				//返回保存语句结果
				return savaSendParcelSend(sendParcelSendEntity);				
			}else  if (sendParcelSendEntity.getManageCode().equals("UPDATE")) {
				log.debug("正在执行修改");
				//返回更新语句结果
				return updateSendParcelSend(sendParcelSendEntity);		
			}else  if (sendParcelSendEntity.getManageCode().equals("DELETE")) {
				log.debug("正在执行删除");
				//返回删除语句结果
				return deleteSendParcelSend(sendParcelSendEntity);
			}

		}
		//返回参数
		return ConstantClassField.RETURNVALUENULL;	
	}

	/**
	 * 执行查询的SQL
	 * @return
	 */
	public String selectSendParcelSend(){
		//查询信息结果
		List<SendParcelSendEntity> list = sendParcelSendDao.selectSendParcelSend();
		log.debug("寄快递的查询结果"+ list);
		//		判断list的一个大小
		if ( list==null  || list.size()<=0) {

			return "{\"resultFlag\":false,\"failureReason\":\"暂无数据\"}";
		}
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("resultFlag", true);
		map.put("express", list);
		log.debug("寄快递的包装结果"+ list);
		//返回json
		return JsonUtil.mapToJsonString(map);
	} 

	/**
	 * 执行保存SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String savaSendParcelSend(SendParcelSendEntity sendParcelSendEntity){
		//判断是否为null
		if (getIsNotNull(sendParcelSendEntity)) {
			log.debug("数据验证成功");
			//			保存执行
			int num = sendParcelSendDao.savaSendParcelSend(sendParcelSendEntity);
			return isNum(num);
		}
		return ConstantClassField.RETURNVALUENULL;
	} 
	/**
	 * 执行修改SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String updateSendParcelSend(SendParcelSendEntity sendParcelSendEntity){
		//		判断传送过来的数据是否为空
		if (getIsNotNull(sendParcelSendEntity)&&getid(sendParcelSendEntity)) {	
			log.debug("数据验证成功");
			//			调用dao层修改寄快递信息
			int num = sendParcelSendDao.updateSendParcelSend(sendParcelSendEntity);
			return	isNum(num);
		}
		return ConstantClassField.RETURNVALUENULL;
	} 

	/**
	 * 执行删除SQL
	 * @param sendParcelSendEntity
	 * @return
	 */
	public String deleteSendParcelSend(SendParcelSendEntity sendParcelSendEntity){
		if (getid(sendParcelSendEntity)) {
			log.debug("数据验证成功");
			//			删除寄快递数据
			int num = sendParcelSendDao.deleteSendParcelSend(sendParcelSendEntity.getId());
			return	isNum(num);
		}
		return ConstantClassField.RETURNVALUENULL;
	} 
	/**
	 * 判断JSON的值不为空
	 * @param sendParcelSendEntity
	 * @return
	 */
	public boolean getid(SendParcelSendEntity sendParcelSendEntity){
		//判断
		if (sendParcelSendEntity.getId() < -1) {	
			return false;
		}
		return true;
	}
	/**
	 * 判断JSON的值不为空
	 * @param sendParcelSendEntity
	 * @return
	 */
	public boolean getIsNotNull(SendParcelSendEntity sendParcelSendEntity){
		//		判断页面的值是否为空
		if (StringUtil.isEmpty(sendParcelSendEntity.getSendCompany())||
				StringUtil.isEmpty(sendParcelSendEntity.getPhotoCode())||
				StringUtil.isEmpty(sendParcelSendEntity.getSendName())||
				StringUtil.isEmpty(sendParcelSendEntity.getSendPhone())) {
			return false;	
		}
		return true;
	}
	/**
	 * 判断执行SQL后的数量，返回值
	 * @param i
	 * @return
	 */
	public String isNum(int i){
		//判断
		if (i > 0) {
			log.debug("数据操作成功");
			return ConstantClassField.RETURNVALUESUCCESS;
		}else{
			log.debug("数据操作失败");
			return ConstantClassField.RETURNVALUEFAIL;
		}

	}
}
