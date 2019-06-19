package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 268101 ccf 班车管理service接口
 */
public interface IBusManagerService {
	/**
	 * @return 得到路线调整list数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public List<BusManagerView> getWayMessage() throws BusinessException;

	/**
	 * @param lineId
	 *            线路id
	 * @return 这条线路数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public List<BusMessageView> getOneMessage(String lineId) throws BusinessException;

	/**
	 * <p>
	 * Description: 更新站点和线路状态
	 * </p>
	 * 
	 * @param busSite
	 *            线路站点表
	
	 * @return 字符串
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String updateStation(BusLineOfSite busSite)throws BusinessException;

	// updateLineTime
	/**
	 * <p>
	 * Description: 更新线路时间
	 * </p>
	 * 
	 * @param lineInfo
	 *            线路信息表
	 * @return 字符串
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String updateLineTime(BusLineInfo lineInfo) throws BusinessException;

	/**
	 * <p>
	 * Description: 得到评价建议列表接口
	 * </p>
	 * 
	 * @return 建议和评价组装成map数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String getEvaManData() throws BusinessException;

	/**
	 * <p>
	 * Description: 获取历史反馈数据
	 * </p>
	 * 
	 * @param userNo
	 *            用户工号
	 * @return 历史反馈数据map集合
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String getHistoryData(String userNo) throws BusinessException;

	/**
	 * <p>
	 * Description: 保存线路信息
	 * </p>
	 * 
	 * @param lineInfo
	 *            线路信息实体类
	 * @return 是否保存成功
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String saveLineInfo(BusLineInfo lineInfo) throws BusinessException;

	/**
	 * <p>
	 * Description: 删除回复
	 * </p>
	 * 
	 * @param beanEntity
	 *            formBean
	 * @return 是否成功参数
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String delReply(BusFormBeanEntity beanEntity) throws BusinessException;

}
