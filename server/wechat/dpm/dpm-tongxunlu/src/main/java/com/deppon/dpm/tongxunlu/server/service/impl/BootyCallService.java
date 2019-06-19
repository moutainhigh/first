package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.server.dao.IBootyCallDao;
import com.deppon.dpm.tongxunlu.server.service.IBootyCallService;
import com.deppon.dpm.tongxunlu.shared.domain.BootyCallEntity;
import com.deppon.dpm.tongxunlu.shared.domain.BootyEntity;

/**
 * 约吧service实现层
 * 
 * @date 2015-09-14
 * @author 231586
 * 
 */
public class BootyCallService implements IBootyCallService {
	private static final Logger logger = Logger
			.getLogger(BootyCallService.class);
	// jdbc模板
	private JdbcTemplate template;
	// set注入dao层
	private IBootyCallDao bootyCallDao;
	// set injection
	private String webUrl;

	@Override
	public int publishBootyCallInfo(BootyCallEntity entity) {
		// 发布约吧信息
		return bootyCallDao.publishBootyCallInfo(entity);
	}

	@Override
	public List<Map<String, Object>> getBootyCallInfo(Map<String, Object> map) {
		// 获取约吧数据
		return bootyCallDao.getBootyCallInfo(map);
	}

	@Override
	public int joinBootyCall(String userId, int id) {
		// 定义查询条件
		Map<String, Object> map = new HashMap<String, Object>();
		// 拼接参数
		StringBuilder sb = new StringBuilder();
		// 定义参加人数
		String joinedPerson = null;
		// 定义结果
		int result = 0;
		try {
			// 获取加入人
			joinedPerson = bootyCallDao.getJoinedPerson(id);
			if (null != joinedPerson && joinedPerson.length() > 0) {
				// 判断当前工号人是否存在
				boolean checkExists = checkExists(userId, joinedPerson);
				if (checkExists) {
					// 存在不叠加
					sb.append(joinedPerson);
				} else {
					// 不存在叠加
					sb.append(joinedPerson).append(",").append(userId);
				}
			} else {
				// 没人则直接添加自己
				sb.append(userId);
			}
		} catch (Exception e) {
			// log
			logger.error("根据id获取约吧信息错误", e);
		}
		try {
			// 参加人参数拼接
			map.put("dataEmpCode", sb.toString());
			// 参数拼接
			map.put("dateId", id);
			// 更新参与人
			result = bootyCallDao.joinBootyCall(map);
		} catch (Exception e) {
			// log
			logger.error("根据id更新约吧信息错误", e);
		}
		// 返回
		return result;
	}

	@Override
	public boolean checkExists(String userId, Object str) {
		// 定义boolean数据
		List<Boolean> list = new ArrayList<Boolean>();
		// 默认没参加
		Boolean result = false;
		// 工号数组
		String[] ress = new String[] {};
		if (null != str) {
			// 分隔
			ress = str.toString().split(",");
		} else {
			// 为null默认没参加
			return result;
		}
		for (String res : ress) {
			if (res.equals(userId)) {
				// 相等就为将参加
				list.add(true);
			} else {
				// 否则没参加
				list.add(false);
			}
		}
		if (list.contains(true)) {
			// 包含设置为true
			result = true;
		} else {
			// 包含设置为false
			result = false;
		}
		// 返回
		return result;
	}

	@Override
	@Deprecated
	public List<Map<String, Object>> getSelfBootyCallInfo(String userId,
			int start, int pageSize) {
		// 获取约吧信息sql
		String sql = "SELECT bc.userId,bc.id,ep.pictPath,oe.empName,bc.data_type,bc.data_time,bc.data_gender,"
				+ "bc.data_address,bc.data_subject,bc.data_empCode,oe.gender "
				+ "FROM booty_call_info bc LEFT JOIN emp_pic ep ON bc.userId = ep.empCode "
				+ "LEFT JOIN om_employee oe ON bc.userId = oe.empCode WHERE bc.userId = '" + userId +"' "
				+ " AND oe.EMPSTATUS = 'on' AND bc.data_time > str_to_date(now(), '%Y-%m-%d %H:%i:%s') order by bc.data_create_time "
				+ "desc limit " + start  + "," + pageSize;
		// 定义约吧信息返回值
		List<Map<String, Object>> result = template.queryForList(sql);
		return result;
	}
	
	/**
	 * 查询参加约吧的人员信息
	 */
	@Override
	public List<BootyEntity> queryJoinEmpsByEmpCodes(String[] ress,
			List<String> leaderList) {
		//健壮性判断
		if(null == ress || ress.length < 1){
			return null;
		}
		List<BootyEntity> resultList = bootyCallDao.queryJoinEmpsByEmpCodes(ress);
		if(null != resultList && resultList.size() > 0){
			for (BootyEntity bootyEntity : resultList) {
				//拼完整的头像地址
				String path = bootyEntity.getHeadImage();
				if(null == path){
					//如果地址为空，设置为""
					bootyEntity.setHeadImage("");
				}else{
					// 用于拼接
					StringBuffer sb = new StringBuffer();
					sb.append(webUrl + "/");
					sb.append("headPhoto/");
					// 拼接文件名
					sb.append(path);
					//如果地址不为空，拼接完整地址并设置
					bootyEntity.setHeadImage(sb.toString());
				}
				
				if(null != leaderList && leaderList.size() > 0){
					// 判断是否是领导，如是，屏蔽号码
					if (leaderList.contains(bootyEntity.getUserId())) {
						bootyEntity.setTelNumber(null);
					}
				}
			}
		}
		return resultList;
	}

	// set injection
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// set injection
	public void setBootyCallDao(IBootyCallDao bootyCallDao) {
		this.bootyCallDao = bootyCallDao;
	}
	
	// setter
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	@Override
	public int delete(int dateId) {
		String sql = "delete from booty_call_info where id = '" + dateId + "'";
		return template.update(sql);
	}

}
