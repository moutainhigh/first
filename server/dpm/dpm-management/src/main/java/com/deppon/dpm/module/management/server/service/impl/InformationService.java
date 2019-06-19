package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.IUUMSRoleService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.management.server.dao.IInformationDao;
import com.deppon.dpm.module.management.server.service.IInformationService;
import com.deppon.dpm.module.management.shared.domain.InformationSort;

public class InformationService implements IInformationService {
	// 日志
	private static Logger logger = Logger.getLogger(InformationService.class);
	
	// 请求角色的url
	private String roleUrl;
	
	// 注入dao
	private IInformationDao informationDao;
	
	// 注入
	private IUUMSRoleService uUMSRoleService;

	

	/**
	 * 根据用户id获取该用户角色对应的信息板块
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<InformationSort> list(String userId) {
		//构造返回的结果集合
		List<InformationSort> result = new ArrayList<InformationSort>();
		//查询所有排序后的信息板块
		List<InformationSort> list = informationDao.list(userId);
		// 起始时间
		long startTime = System.currentTimeMillis();
		//查询出所有的该用户所具有的角色
		String roleStr = uUMSRoleService.getRoles(userId);
		// 结束时间
		long endTime = System.currentTimeMillis();
		// 日志
		logger.info("["+userId+"]请求资讯排序信息调用uums用时>>>>>>" + (endTime - startTime));
		// 解析
		List<String> role = (List<String>)JSON.parseObject(roleStr).get("roleCodes");
//		List<String> role = getRole(userId);
		//遍历查询到的所有信息板块
		for (InformationSort applyStore : list) {
			//如果信息板块的infoId为5
			if (applyStore.getInfoId() == MagicNumber.NUM5) {
				//如果该用户具有DPM0016的角色
				if (role != null && role.contains(DpmConstants.dpmExpressRole)) {
					//将此信息板块添加进返回的结果集合中
					result.add(applyStore);
				}
			} else if (applyStore.getInfoId() == MagicNumber.NUM6) {//如果信息板块的infoId为5
				//如果该用户具有DPM0015的角色
				if (role != null
						&& role.contains(DpmConstants.morningMeetingRole)) {
					result.add(applyStore);
				}
			}else if (applyStore.getInfoId() == MagicNumber.NUM7) {
				if (role != null
						&& role.contains(DpmConstants.inOutExpressRole)) {
					result.add(applyStore);
				}
			} else {
				result.add(applyStore);
			}
		}
		//返回
		return result;
	}

	/**
	 * 对该用户的信息进行排序
	 */
	@Override
	public void sort(String userId, String sortStr) {
		informationDao.sort(userId, sortStr);
	}

	/**
	 * 获取用户具备的信息板块排序字符串
	 */
	@Override
	public String getSort(String userId) {
		//获取用户对应的信息排序字符串
		String sort = informationDao.getSort(userId);
		//如果该用户没有改排序字符串
		if (StringUtils.isEmpty(sort)) {
			//根据用户id获取该用户角色对应的信息板块
			List<InformationSort> list = list(userId);
			//字符串缓冲区
			StringBuilder builder = new StringBuilder();
			//遍历
			for (InformationSort info : list) {
				//拼接字符串
				builder.append(info.getInfoId()).append(",");
			}
			String res = builder.toString();
			//去掉最后多余的一个,
			sort = res.substring(0, res.length() - 1);
			//新增获取更新该用户对应的信息字符串数据
			sort(userId, sort);
			return sort;
		} else {
			//根据用户id获取该用户角色对应的信息板块
			List<InformationSort> list = list(userId);
			//字符串缓冲区
			StringBuilder builder = new StringBuilder();
			//遍历
			for (InformationSort info : list) {
				//拼接字符串
				builder.append(info.getInfoId()).append(",");
			}
			//转成字符串
			String res = builder.toString();
			//去掉最后多余的一个,
			String ne = res.substring(0, res.length() - 1);
			//获取最终的字符串
			String transSort = getTransSort(sort, ne);
			//如果与表中的数据不一致
			if (!sort.equals(transSort))
				//新增获取更新该用户对应的信息字符串数据
				sort(userId, transSort);
			//返回
			return transSort;
		}
	}

	/**
	 * 获取用户对应的角色
	 * @param userId
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	private List<String> getRole(String userId) {
//		//请求的url
//		String url = roleUrl + "?appID=DPM&userCode=" + userId;
//		//角色集合
//		List<String> roleCodes = new ArrayList<String>();
//		RestTemplate restTemplate = new RestTemplate();
//		// 起始时间
//		long startTime = System.currentTimeMillis();
//		//请求获取对应的角色信息
//		String object = restTemplate.getForObject(url, String.class);
//		// 结束时间
//		long endTime = System.currentTimeMillis();
//		// 日志
//		logger.info("调用uums获取角色信息用时>>>>>>" + (endTime - startTime));
//		if (StringUtils.isNotEmpty(object)) {
//			roleCodes = (List<String>) JSON.parseObject(object)
//					.get("roleCodes");
//		}
//		return roleCodes;
//	}

	

	/**
	 * 用户对应的信息字符串与所有信息板块拼接的字符串作比对
	 * 返回最终的字符串
	 * @param old
	 * @param ne
	 * @return
	 */
	public String getTransSort(String old, String ne) {
		//转为List集合
		List<String> list1 = new ArrayList<String>(
				Arrays.asList(old.split(",")));
		//转为List集合
		List<String> list2 = new ArrayList<String>(Arrays.asList(ne.split(",")));
		//获取迭代器
		Iterator<String> oldit = list1.iterator();
		//迭代
		while (oldit.hasNext()) {
			String value = oldit.next();
			//如果ne的字符串中不包含的
			if (!list2.contains(value))
				//删除old字符串中的这个编号
				oldit.remove();
		}
		//遍历ne字符串转成的集合
		for (String value : list2) {
			//如果ne字符串有的，而old字符串中没有的
			if (!list1.contains(value))
				//将此编号添加进old字符串
				list1.add(value);
		}
		//System.out.println(list1.toString());

		StringBuilder builder = new StringBuilder();
		//拼接字符串
		for (String info : list1) {
			builder.append(info).append(",");
		}
		//转为字符串
		String res = builder.toString();
		//去掉多余的,
		String result = res.substring(0, res.length() - 1);
		//返回
		return result;
	}
	
	// getter
	public String getRoleUrl() {
		return roleUrl;
	}

	// setter
	public void setRoleUrl(String roleUrl) {
		this.roleUrl = roleUrl;
	}
	
	// getter
	public IInformationDao getInformationDao() {
		return informationDao;
	}

	// setter
	public void setInformationDao(IInformationDao informationDao) {
		this.informationDao = informationDao;
	}

	// setter
	public void setuUMSRoleService(IUUMSRoleService uUMSRoleService) {
		this.uUMSRoleService = uUMSRoleService;
	}
}
