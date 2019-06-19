package com.deppon.dpm.doc.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.doc.server.dao.IDiDiJPushDao;
import com.deppon.dpm.tongxunlu.shared.vo.JpushVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 查询推送映射关系的数据库操作类.
 * @author 130126
 *
 */
public class DiDiJPushDao extends iBatis3DaoImpl implements IDiDiJPushDao {
	/**
	 * namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.jpush.";
	/**
	 * jdbc模板
	 */
	private JdbcTemplate template;

	/**
	 * 存取推送人
	 */
	@Override
	public void savePushUser(JpushVO vo) {
		// sql
		String sql = "insert into push_user(userid,token,devicetype,syscode) values(?,?,?,?)";
		// 保存
		template.update(sql, vo.getUserId(),vo.getToken(),vo.getDeviceType(),vo.getSysCode());
	}

	/**
	 * 删除推送人员
	 */
	@Override
	public void deletePushUser(String userId, String sysCode, String deviceType) {
		// sql
		String sql = "delete from push_user where  userid = ? and syscode=? and devicetype=?";
		// 执行
		template.update(sql, userId,sysCode,deviceType);
	}

	/**
	 * 选取
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<JpushVO> selectPushUser(JpushVO vo) {
		List<JpushVO> result = new ArrayList<JpushVO>();
		// 获取推送人员
		result = this.getSqlSession().selectList(NAMESPACE + "getPushs", vo);
		//  返回推送人员集合
		return result;
	}

	/**
	 * 更新
	 */
	@Override
	public void updatePushUser(JpushVO vo) {
		// sql
		String sql = "update push_user set token=  ? where  userid = ? and syscode=? and devicetype=?";
		// 执行
		template.update(sql,vo.getToken(),vo.getUserId(),vo.getSysCode(),vo.getDeviceType());
	}
	
	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getTemplate() {
		return template;
	}

	/**
	 * set
	 * 
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
