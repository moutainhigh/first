package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.shared.domain.FeedBackPushEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.server.dao.IFeedbackDao;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackProblemListEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 意见反馈dao层实现
 * @author 231586
 */
public class FeedbackDao extends iBatis3DaoImpl implements IFeedbackDao {
	/**
	 * jdbc模板
	 */
	private JdbcTemplate jdbcTemplate;
	/**
	 * namespece
	 */
	private String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.systemConfig.";

	/**
	 * 插入意见反馈
	 */
	@Override
	public void feedback(Map<String, String> map) {
		// 插入意见反馈信息
		getSqlSession().insert(NAMESPACE + "feedbackinsert", map);
	}

	/**
	 * 获取意见反馈
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FeedBackDetailsEntity> getFeedbackDetails(int start,
			int pageSize,FeedbackSearch search) {
		// 参数拼接
		Map map = new HashMap();
		// 起始条数
		map.put("start", start);
		// 返回大小
		map.put("pageSize", pageSize);
		// 参数拼接
		map = getSearchMap(map,search);
		// 返回查询
		return this.getSqlSession().selectList(
				NAMESPACE + "getFeedbackList", map);
	}
	
	/**
	 * 拼接意见反馈查询参数
	 * @param map
	 * @param search
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map getSearchMap(Map map,FeedbackSearch search){
		if(null != search){
			// 工号
			if(StringUtils.isNotBlank(search.getSearchCode())){
				map.put("searchCode", search.getSearchCode());
			}
			// 姓名
			if(StringUtils.isNotBlank(search.getSearchName())){
				map.put("searchName", search.getSearchName());
			}
			// 反馈内容
			if(StringUtils.isNotBlank(search.getSearchContent())){
				map.put("searchContent", search.getSearchContent());
			}
			// 设备类型
			if(StringUtils.isNotBlank(search.getSearchOsType())){
				map.put("searchOsType", search.getSearchOsType());
			}
			// 反馈模块类型
			if(StringUtils.isNotBlank(search.getSearchType())){
				map.put("searchType", search.getSearchType());
			}
			// 是否解决
			if(StringUtils.isNotBlank(search.getSearchIsSolve())){
				map.put("searchIsSolve", search.getSearchIsSolve());
			}
			// 是否处理
			if(StringUtils.isNotBlank(search.getSearchStatus())){
				map.put("searchStatus", search.getSearchStatus());
			}
			// 提交开始时间
			if(StringUtils.isNotBlank(search.getSearchBeginTime())){
				map.put("searchBeginTime", search.getSearchBeginTime());
			}
			// 提交结束时间
			if(StringUtils.isNotBlank(search.getSearchEndTime())){
				map.put("searchEndTime", search.getSearchEndTime());
			}
		}
		return map;
	}
	
	/**
	 * 获取总条数
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int getTotalCounts(FeedbackSearch search) {
		// 参数拼接查询
		Map<String, String> map = new HashMap<String, String>();
		// 参数拼接
		map = getSearchMap(map,search);
		// 查询数量
		return (Integer) this.getSqlSession().selectOne(
						NAMESPACE + "getFeedbackCount", map);
	}

	/**
	 * 获取意见反馈
	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public List<FeedBackDetailsEntity> getFeedbackDetails(int start,
//			int pageSize) {
//		// 参数拼接
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		// 起始条数
//		map.put("start", start);
//		// 返回大小
//		map.put("pageSize", pageSize);
//		// 返回查询
//		return this.getSqlSession().selectList(
//				NAMESPACE + "getFeedbackDetails", map);
//	}

	/**
	 * 获取反馈信息及反馈人信息
	 */
	@Override
	public FeedBackDetailsEntity getFeedBackDetailsById(int id) {
		Map map = new HashMap();
		map.put("id", id);
		return (FeedBackDetailsEntity) this.getSqlSession().selectOne(
				NAMESPACE + "getFeedbackDetailEnt", map);
	}
	/**
	 * 获取反馈负责人信息
	 * @param id
	 * @return
	 */
	public EmployeeEntity getExecuteEntById(int id){
		Map map = new HashMap();
		map.put("id", id);
		return (EmployeeEntity) this.getSqlSession().selectOne(
				NAMESPACE + "getExecuteEnt", map);
	}


	/**
	 * 获取总条数
	 */
//	@Override
//	public int getTotalCounts() {
//		// 查询条数
//		return jdbcTemplate.queryForInt("select count(*) from feedback");
//	}
	
	/**
	 * 获取负责人ID条数
	 */
	public int getExcEmpCodeCount(String excEmpCode){
		//检查ID是否在意见反馈通讯表中
		return (Integer) this.getSqlSession().selectOne(
				NAMESPACE + "getExcEmpCodeCount", excEmpCode);
	}
	
	/**
	 * 更新意见反馈回复
	 */
	public int updateFeedbackReply(FeedBackDetailsEntity feedBackDetailsEntity){
		//更新意见反馈回复内容
		return getSqlSession().update(NAMESPACE + "updateFeedbackReply",
				feedBackDetailsEntity);
	}

	/**
	 * 更新
	 */
	@Override
	public int updateFeedback(FeedBackDetailsEntity feedBackDetailsEntity) {
		// 更新意见反馈
		return getSqlSession().update(NAMESPACE + "updateFeedback",
				feedBackDetailsEntity);
	}

	/**
	 * 获取一条
	 */
	@Override
	public Date getSubmitTimeById(int id) {
		// 根据id获取意见反馈时间
		return (Date) getSqlSession().selectOne(
				NAMESPACE + "getSubmitTimeById", id);
	}

	/**
	 * 根据员工id获取意见反馈列表
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FeedBackDetailsEntity> getFeedbackByEmpcode(int start,
			int pageSize, String empCode) {
		// 参数拼接
		Map map = new HashMap();
		// 起始条数
		map.put("start", start);
		// 返回大小
		map.put("pageSize", pageSize);
		map.put("empCode", empCode);
		// 返回查询
		return this.getSqlSession().selectList(
				NAMESPACE + "getFeedbackDetails", map);
	}

	@Override
	public FeedBackPushEntity getSloverById(String empCode) {
		Map map = new HashMap();
		map.put("id", empCode);
		return (FeedBackPushEntity) this.getSqlSession().selectOne(
				NAMESPACE + "getSloverEnt", map);
	}

	/**
	 * 意见反馈 问题类型列表
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<FeedbackProblemListEntity> problemList() {
		return getSqlSession().selectList(NAMESPACE + "problemList");
	}
	
	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * set
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FeedBackDetailsEntity> getReportListByHandleId(String userId, int start, int size, FeedbackSearch search) {
		Map<String, Object> map = new HashMap<String, Object>();
		getSearchMap(map,search);
		map.put("userId", userId);
		map.put("start", start);
		map.put("size", size);
		return (List<FeedBackDetailsEntity>) this.getSqlSession().selectList(
				NAMESPACE + "getReportListByHandleId", map);
	}

	@Override
	public int getReportListSize(String userId, FeedbackSearch search) {
		Map<String, Object> map = new HashMap<String, Object>();
		getSearchMap(map,search);
		map.put("userId", userId);

		return (Integer) this.getSqlSession().selectOne(NAMESPACE + "getReportCountByHandleId", map);
	}
}
