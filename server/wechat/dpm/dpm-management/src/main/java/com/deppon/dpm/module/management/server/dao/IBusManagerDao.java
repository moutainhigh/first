package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusUserEntity;

/**
 * @author 268101 ccf 班车管理dao接口
 */
public interface IBusManagerDao {
	/**
	 * @return 得到路线调整list数据
	 * @throws Exception
	 *             抛出异常
	 */
	public List<BusManagerView> getWayMessage() throws Exception;

	/**
	 * @param lineId
	 *            线路id
	 * @return 这条线路数据
	 * @throws Exception
	 *             抛出异常
	 */
	public List<BusMessageView> getOneMessage(String lineId) throws Exception;

	/**
	 * 更新线路的站点，状态
	 * 
	 * @param busSite
	 *            线路站点表
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateStation(BusLineOfSite busSite) throws Exception;

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
	public int updateLineInfo(BusLineInfo lineInfo) throws Exception;

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
	public List<BusLineInfo> listLineInfo(BusLineInfo busInfo) throws Exception;

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
	public List<BusLineOfSite> listSite(int lineId) throws Exception;

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
	public int saveLineInfo(BusLineInfo lineInfo) throws Exception;

	/**
	 * <p>
	 * Description: 得到评价表和建议表中间表的list数据 查询近期一个月数据
	 * </p>
	 * 
	 * @return 评价表和建议表list数据
	 * @throws Exception
	 *             抛出异常
	 */
	public List<BusCentreAdviceEntity> getCentreData() throws Exception;

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
	public List<BusCentreAdviceEntity> getBusCentreData(String userNo)
			throws Exception;

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
	public List<BusFormBeanEntity> getOpenAdviceData(int id) throws Exception;

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
	public List<BusFormBeanEntity> getEvaFormBeanData(int id) throws Exception;

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
	public List<BusUserEntity> getUserData(String userNo) throws Exception;

	/**
	 * <p>
	 * Description: 获得插入当前主键id
	 * </p>
	 * 
	 * @return id
	 * @throws Exception
	 *             抛出异常
	 */
	public int getMaxLineId() throws Exception;

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
	public int saveLineSite(BusLineOfSite lineOfSite) throws Exception;

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
	public int delOpenLineReply(int id) throws Exception;
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
	public int delManageReply(int id) throws Exception;
}
