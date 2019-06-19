package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IProcUserScoreAndAddressDao;
import com.deppon.dpm.module.management.server.service.IProcUserScoreAndAddressService;
import com.deppon.dpm.module.management.shared.domain.ProcUserScoreAndAddressEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 提交显示所有0分项service层实现接口.
 * @author 曹嵩
 * 2015.7.30
 */
public class ProcUserScoreAndAddressService implements
		IProcUserScoreAndAddressService {

	/**
	 * 日志.
	 */
	private Logger logger = LoggerFactory
			.getLogger(ProcUserScoreAndAddressService.class);

	/**
	 * 调用dao层的方法.
	 */
	private IProcUserScoreAndAddressDao procUserScoreAndAddressDao;


	/**
	 * @return 调用dao层的方法.
	 */
	public IProcUserScoreAndAddressDao getProcUserScoreAndAddressDao() {
		return procUserScoreAndAddressDao;
	}

	/**
	 * @param procUserScoreAndAddressDao 调用dao层的方法.
	 */
	public void setProcUserScoreAndAddressDao(
			IProcUserScoreAndAddressDao procUserScoreAndAddressDao) {
		this.procUserScoreAndAddressDao = procUserScoreAndAddressDao;
	}

	/**
	 * 组装所有0分项显示信息.
	 * @return list集合
	 * @throws Exception
	 */
	public List<ProcUserScoreAndAddressEntity> getProcUserScoreAndAddressInfo(
			String userNo, String proAdress) throws Exception {

		logger.info("进入到提交显示所有0分项service层实现接口>>>>>>>>>ProcUserScoreAndAddressService");
		logger.info("进入方法getProcUserScoreAndAddressInfo>>>>>>>传值员工工号userNo为："
				+ userNo);
		logger.info("进入方法getProcUserScoreAndAddressInfo>>>>>>>传值部门地址proAdress为："
				+ proAdress);

		// 创建一个实体类
		ProcUserScoreAndAddressEntity pusaae = new ProcUserScoreAndAddressEntity();
        //塞入userNo
		pusaae.setUserNo(userNo);
		//塞入地址
		pusaae.setProAdress(proAdress);

		ProcUserScoreAndAddressEntity procEntity = null;

		// 得到功能栏代码值
		List<ProcUserScoreAndAddressEntity> list = procUserScoreAndAddressDao
				.getProType(pusaae);
         //创建一个list
		List<ProcUserScoreAndAddressEntity> procEntityList = new ArrayList<ProcUserScoreAndAddressEntity>();
		//判断list是否为null
		if (list != null) {
			//for 循环进行数据组装
			for (ProcUserScoreAndAddressEntity p : list) {
				procEntity = new ProcUserScoreAndAddressEntity();
				procEntity.setProName(p.getProName());

				pusaae.setProType(p.getProType());
				// 得到0分项的所有实体信息
				List<ProcUserScoreAndAddressEntity> pusaaeList = procUserScoreAndAddressDao
						.getProcUserScoreAndAddress(pusaae);
				// 得到检查的门店总数
				int countStore = procUserScoreAndAddressDao.getCountStore();
				
				List<String> scopeNameList = new ArrayList<String>(); // 存放打分项名称list
				List<String> scopeCodeList = new ArrayList<String>(); // 存放打分项code的list
				List<Integer> countScopeIdList = new ArrayList<Integer>();//存放这一项门店不合格总数的list
				// for 循环进行数据组装
				for (ProcUserScoreAndAddressEntity procUserScoreAndAddressEntity : pusaaeList) {
					pusaae.setScopeid(procUserScoreAndAddressEntity
							.getScopeid());
					Integer countScopeId = procUserScoreAndAddressDao
							.getCountScopeId(pusaae);// 得到这一项门店不合格总数

					String scopeName = procUserScoreAndAddressEntity
							.getScopeName();//得到打分项名称
					String scopeCode = procUserScoreAndAddressEntity
							.getScopeid();//得到打分项id
					
					if (!StringUtil.isEmpty(scopeName)) {//判断是否为空
						scopeNameList.add(scopeName);
					}

					if (!StringUtil.isEmpty(scopeCode)) {//判断是否为空
						scopeCodeList.add(scopeCode);
					}
					
					if (countScopeId!=0) {//判断门店不合格总数不为0
						countScopeIdList.add(countScopeId);
					}
					
					//将详情存放在新实体中
					procEntity.setReMark(procUserScoreAndAddressEntity
							.getReMark());
					//procEntity.setCountScopeId(countScopeId);//将这一项门店不合格总数放到新实体中
					procEntity.setCountStore(countStore);//将检查的门店总数放到新实体中
					logger.info("新实体类为：procEntity:"+procEntity);
				}

				//给新实体类中的数组定义长度
				procEntity.setArrScopeName((String[]) scopeNameList
						.toArray(new String[scopeNameList.size()]));
				//给新实体类中的数组定义长度
				procEntity.setArrScopeCode((String[]) scopeCodeList
						.toArray(new String[scopeCodeList.size()]));
				//给新实体类中的数组定义长度
				procEntity.setArrcountScopeId((Integer[]) countScopeIdList
						.toArray(new Integer[countScopeIdList.size()]));
				
				procEntityList.add(procEntity);
				logger.info("实体类procEntityList长度为："+procEntityList.size());
			}

		} else {
			logger.info("list为空");
		}
		//返回数据
		return procEntityList;
	}

}
