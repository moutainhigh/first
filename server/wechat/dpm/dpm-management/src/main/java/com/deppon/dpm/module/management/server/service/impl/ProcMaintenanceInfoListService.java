package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IProcMaintenanceInfoListDao;
import com.deppon.dpm.module.management.server.service.IProcMaintenanceInfoListService;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
/**
 * 工程维修信息service层实现方法.
 * @author 曹嵩
 * <p>时间:2015.9.29</p>
 */
public class ProcMaintenanceInfoListService implements
		IProcMaintenanceInfoListService {
	
	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(ProcMaintenanceInfoListService.class);
	//dao 层的注入
	private IProcMaintenanceInfoListDao procMaintenanceInfoListDao;
    //get set
	public IProcMaintenanceInfoListDao getProcMaintenanceInfoListDao() {
		return procMaintenanceInfoListDao;
	}
	   //get set
	public void setProcMaintenanceInfoListDao(
			IProcMaintenanceInfoListDao procMaintenanceInfoListDao) {
		this.procMaintenanceInfoListDao = procMaintenanceInfoListDao;
	}

	@Override

	/**得到工程维修list数据
	 * @param pageNum 分页 多少行
	 * @param pageSize 第几页
	 * @param userNo 工号
	 * @return 工程维修list数据
	 */
	public Map<String, Object> getProcMainList(int pageNum, int pageSize, String userNo) {
		logger.info("进入工程维修信息service层实现方法getProcMainList");
		logger.info("pageNum:"+pageNum);
		logger.info("pageSize:"+pageSize);
		logger.info("userNo:"+userNo);
		//对时间格式进行转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//new 一个新的list对象
		List<ProcMaintainEntity> procMaintainList = new ArrayList<ProcMaintainEntity>();
		//new 一个新的map 存储数据
		Map<String, Object> mapList = new HashMap<String, Object>();
		// 根据工号得到工程维修的总数
		mapList.put("count", procMaintenanceInfoListDao.getCount(userNo)); 
		logger.info("count数量为:"+procMaintenanceInfoListDao.getCount(userNo));
		//得到分页的数据
		List<ProcMaintainEntity> list = procMaintenanceInfoListDao.getProcMainList(pageNum, pageSize, userNo);
		//对查询出来的数据进行组装
		for (ProcMaintainEntity pme : list) {
			if(pme.getUpdateDate()!=null){ //如果日期不为空.
				pme.setUpdateDateStr(sdf.format(pme.getUpdateDate())); //转换时间为年月日格式.
			}
			procMaintainList.add(pme); // 将得到的工程维修信息放入到list集合中.
		}
		mapList.put("procMaintainList", procMaintainList); //将得到的list集合放到map集合中.
		return mapList;
	}

}
