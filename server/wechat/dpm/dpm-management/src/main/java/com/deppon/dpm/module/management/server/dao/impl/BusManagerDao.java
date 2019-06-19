package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IBusManagerDao;
import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusUserEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 ccf 班车管理dao接口的实现
 */
public class BusManagerDao extends iBatis3DaoImpl implements IBusManagerDao {
	static String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.busmanager";

	/**
	 * @return 得到路线调整list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusManagerView> getWayMessage() throws Exception {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getWayMessage");

	}

	/**
	 * @param lineId
	 *            线路id
	 * @return 这条线路数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusMessageView> getOneMessage(String lineId) throws Exception {
		if (!(lineId == null || lineId.length() <= 0)) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getOneMessage", lineId);
		}
		return null;

	}

	/**
	 * 更新线路的站点，状态
	 * 
	 * @param busSite
	 *            线路站点表
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateStation(BusLineOfSite busSite) throws Exception {

		return this.getSqlSession().update(mapperNameSpace + ".updateStation",
				busSite);

	}

	/**
	 * <p>
	 * Description: 更新线路信息表
	 * </p>
	 * 
	 * @param lineInfo
	 *            线路信息表实体类
	 * @return int
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateLineInfo(BusLineInfo lineInfo) throws Exception {
		return this.getSqlSession().update(mapperNameSpace + ".updateLineInfo",
				lineInfo);
	}

	/**
	 * <p>
	 * Description: 保存线路信息
	 * </p>
	 * 
	 * @param lineInfo
	 *            线路信息实体类
	 * @return 是否保存成功
	 * @throws Exception
	 *             抛出异常
	 */
	public int saveLineInfo(BusLineInfo lineInfo) throws Exception {

		return this.getSqlSession().insert(mapperNameSpace + ".saveLineInfo",
				lineInfo);

	}

	/**
	 * <p>
	 * Description: 得到线路信息详情
	 * </p>
	 * 
	 * @param busInfo
	 *            线路详情实体类
	 * @return 线路list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusLineInfo> listLineInfo(BusLineInfo busInfo) throws Exception {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".listLineInfo", busInfo);
	}

	/**
	 * <p>
	 * Description: 得到评价表和建议表中间表的list数据 查询近期一个月数据
	 * </p>
	 * 
	 * @return 评价表和建议表list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusCentreAdviceEntity> getCentreData() throws Exception {
		return this.getSqlSession().selectList(
				mapperNameSpace + ".getCentreData");

	}

	/**
	 * <p>
	 * Description: 得到建议内容和回复的内容
	 * </p>
	 * 
	 * @param id
	 *            开线建议表主键id
	 * @return 建议内容和回复的内容 list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusFormBeanEntity> getOpenAdviceData(int id) throws Exception {
		if (id > 0) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getOpenAdviceData", id);
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 得到用户评价的数据
	 * </p>
	 * 
	 * @param id
	 *            用户评价表主键id
	 * @return 用户评价List数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusFormBeanEntity> getEvaFormBeanData(int id) throws Exception {
		if (id > 0) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getEvaFormBeanData", id);
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 根据工号获得评价表和建议表数据
	 * </p>
	 * 
	 * @param userNo
	 *            工号
	 * @return 评价表和建议表list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusCentreAdviceEntity> getBusCentreData(String userNo)
			throws Exception {
		if (!StringUtil.isEmpty(userNo)) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getBusCentreData", userNo);
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 得到用户数据
	 * </p>
	 * 
	 * @param userNo
	 *            工号
	 * @return user
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusUserEntity> getUserData(String userNo) throws Exception {
		if (null != userNo) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".getUserData", userNo);
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 获得插入当前主键id
	 * </p>
	 * 
	 * @return id
	 * @throws Exception
	 *             抛出异常
	 */
	public int getMaxLineId() throws Exception {
		return (Integer) this.getSqlSession().selectOne(
				mapperNameSpace + ".getMaxLineId");
	}

	/**
	 * <p>
	 * Description: 查询线路站点表
	 * </p>
	 * 
	 * @param lineId
	 *            线路id
	 * @return 线路站点表list数据
	 * @throws Exception
	 *             抛出异常
	 */
	@SuppressWarnings("unchecked")
	public List<BusLineOfSite> listSite(int lineId) throws Exception {
		if (lineId > 0) {
			return this.getSqlSession().selectList(
					mapperNameSpace + ".listSite", lineId);
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 保存站点表信息
	 * </p>
	 * 
	 * @param lineOfSite
	 *            实体类
	 * @return 是否成功
	 * @throws Exception
	 *             抛出异常
	 */
	public int saveLineSite(BusLineOfSite lineOfSite) throws Exception {

		return this.getSqlSession().insert(mapperNameSpace + ".saveLineSite",
				lineOfSite);
	}

	/**
	 * <p>
	 * Description: 删除回复
	 * </p>
	 * 
	 * @param id
	 *            参数id
	 * @return int
	 * @throws Exception
	 *             抛出异常
	 */
	public int delOpenLineReply(int id) throws Exception {
		if (id > 0) {
			return this.getSqlSession().delete(
					mapperNameSpace + ".delOpenLineReply", id);
		}
		return 0;

	}

	/**
	 * <p>
	 * Description: 删除评价回复
	 * </p>
	 * 
	 * @param id
	 *            参数id
	 * @return int
	 * @throws Exception
	 *             抛出异常
	 */
	public int delManageReply(int id) throws Exception {
		if (id > 0) {
			return this.getSqlSession().delete(
					mapperNameSpace + ".delManageReply", id);
		}
		return 0;

	}
	


}
