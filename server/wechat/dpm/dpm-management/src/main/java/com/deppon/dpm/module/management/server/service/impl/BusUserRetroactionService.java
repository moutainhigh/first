package com.deppon.dpm.module.management.server.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IBusManagerDao;
import com.deppon.dpm.module.management.server.dao.IBusMsgAssNewsDao;
import com.deppon.dpm.module.management.server.dao.IBusUserRetroactionAddDao;
import com.deppon.dpm.module.management.server.service.IBusUserRetroactionAddService;
import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusUserEntity;
import com.deppon.dpm.module.management.shared.domain.BusUserRetroactionEntity;

/**
 * 添加用户评价的service层实现接口
 * 
 * @author 曹嵩
 * @date 2015.6.30
 */
public class BusUserRetroactionService implements IBusUserRetroactionAddService {

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusUserRetroactionService.class);
	// 注入dao
	private IBusUserRetroactionAddDao buraDao;
	// 注入dao
	private IBusManagerDao busManagerDao;
	// 注入dao
	private IBusMsgAssNewsDao busMsgAssNewsDao;

	// get set
	public IBusMsgAssNewsDao getBusMsgAssNewsDao() {
		return busMsgAssNewsDao;
	}

	// get set
	public void setBusMsgAssNewsDao(IBusMsgAssNewsDao busMsgAssNewsDao) {
		this.busMsgAssNewsDao = busMsgAssNewsDao;
	}

	// get set
	public IBusManagerDao getBusManagerDao() {
		return busManagerDao;
	}

	// get set
	public void setBusManagerDao(IBusManagerDao busManagerDao) {
		this.busManagerDao = busManagerDao;
	}

	// get set
	public IBusUserRetroactionAddDao getBuraDao() {
		return buraDao;
	}

	// get set
	public void setBuraDao(IBusUserRetroactionAddDao buraDao) {
		this.buraDao = buraDao;
	}

	/**
	 * 添加用户评价方法
	 * 
	 * @param strJson
	 *            前台发过来的json数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public int saveBusUserRetroaction(String strJson) throws Exception {
		int flag = 0;
		int flag2 = 0;
		try {
			logger.info("saveBusUserRetroaction-----得到的strJson为：" + strJson);
			// json转换实体类
			BusUserRetroactionEntity bure = JsonUtil.jsonToEntity(strJson,
					BusUserRetroactionEntity.class);
			// 得到员工工号
			String userNo = JsonUtil.jsonGetValueBykey(strJson, "userNo");
			// 根据工号找到名称
			List<BusUserEntity> bueList = busManagerDao.getUserData(userNo);
			// 判断是否有数据
			if (bueList.size() != 0) {
				bure.setCreateBy(bueList.get(0).getEmpName());
			} else {
				bure.setCreateBy("");
			}
			// 塞入时间
			bure.setCreateDate(new Date());
			logger.info("saveBusUserRetroaction-----转换后的实体类数据为:" + bure
					+ "员工工号为：" + userNo);
			// 保存数据
			flag = buraDao.saveBusUserRetroaction(bure);
			// 判断数据是否保存成功
			if (flag > 0) {
				logger.info("saveBusUserRetroaction----保存数据成功,flag:" + flag);
			} else {
				logger.info("saveBusUserRetroaction----保存数据失败,flag:" + flag);
			}
			// new 一个新对象
			BusCentreAdviceEntity bcae = new BusCentreAdviceEntity();
			// 塞入时间
			bcae.setCreateDate(new Date());
			// SimpleDateFormat sdf = new
			// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// String time = sdf.format(bure.getCreateDate());
			bure.setCreateDate(new Date(bure.getCreateDate().getTime()));
			// 得到主键id
			bcae.setCentreId(buraDao.getBusUserRetroaction(bure));
			// 设置标志位
			bcae.setCentreMark(0);
			// 插入工号
			bcae.setUserNo(userNo);
			// 保存插入的数据
			flag2 = busMsgAssNewsDao.saveCentre(bcae);
			// 判断是否成功插入了数据
			if (flag2 > 0) {
				logger.info("saveBusUserRetroaction--评价与建议的中间表数据--保存数据成功,flag2:"
						+ flag2);
			} else {
				logger.info("saveBusUserRetroaction--评价与建议的中间表数据--保存数据失败,flag2:"
						+ flag2);
			}
		} catch (Exception ce) {
			logger.info("saveBusUserRetroaction----保存数据失败,可能有异常,flag:" + flag);
			ce.printStackTrace();
		}
		// 返回参数
		return flag;
	}

}
