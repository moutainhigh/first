package com.deppon.dpm.module.management.server.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcScoringDao;
import com.deppon.dpm.module.management.server.service.IProcScoringService;
import com.deppon.dpm.module.management.shared.domain.ConstantClassField;
import com.deppon.dpm.module.management.shared.domain.ProcAddressEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMessageEntity;
import com.deppon.dpm.module.management.shared.domain.ProcScoringEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchDeptEntity;
import com.deppon.dpm.module.management.shared.domain.ProcWatchProjectEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * Description：保存5分信息的service层实现接口
 * </p>
 * 
 * @author 袁中华
 * @date 2015.07.14
 * 
 */
public class ProcScoringService implements IProcScoringService {
	/**
	 * 值为空
	 */                         
	private final static String RETURNVALUENULL = "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL！\"}";
	/**
	 * 保存成功
	 */
	private final static String RETURNVALUESUCCESS = "{\"resultFlag\":true,\"failureReason\":\"保存信息成功！\"}";
	/**
	 * 保存失败
	 */
	private final static String RETURNVALUEFAIL = "{\"resultFlag\":false,\"failureReason\":\"保存失败！\"}";
	/**
	 * IOC注入对象
	 * 
	 */
	private IProcScoringDao engScoringDao;
	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(BusMsgAssNewsService.class);

	/**
	 * 
	 */
	public void setEngScoringDao(IProcScoringDao engScoringDao) {
		this.engScoringDao = engScoringDao;
	}

	/**
	 * <p>
	 * Description：5分保存
	 * </p>
	 * <p>
	 * Description：地址保存
	 * </p>
	 * 
	 * @throws Exception
	 * @return
	 * @see String
	 */
	
	public String savaScoring(String str) throws Exception {
		// 解析JSON

		JSONObject json = JsonUtil.parseObject(str);
		logger.info("新增页面传过来的参数为:" + json);
		// 从JSON中取值
		String userNo = json.getString("userNo");
		String proAdress = json.getString("proAdress");
		String proType = json.getString("proType");
		String scopeid = json.getString("scopeid");
		String scope1 = json.getString("scope");
		String proName = json.getString("proName");
		String scopeName = json.getString("scopeName");
		// 转换
		int scope = Integer.parseInt(scope1);
		// 日志录入
		logger.info("userNo:" + userNo + "proAdress:" + proAdress + "proType:"
				+ proType + "scopeid:" + scopeid + "scope:" + scope
				+ "proName:" + proName + "scopeName:" + scopeName);

		// 判断是否为空
		if (StringUtil.isEmpty(userNo) || StringUtil.isEmpty(proAdress)
				|| StringUtil.isEmpty(proType) || StringUtil.isEmpty(scopeid)
				|| StringUtil.isEmpty(proName) || StringUtil.isEmpty(scopeName)
				|| scope < -1) {
			logger.info(RETURNVALUENULL);
			return RETURNVALUENULL;
		}
		// 日期
		Date date = new Date();
		ProcAddressEntity engAddressEntity = new ProcAddressEntity();
		// 查询人员地点表
		engAddressEntity.setProType(proType);
		engAddressEntity.setProAdress(proAdress);
		engAddressEntity.setUserno(userNo);
		engAddressEntity.setProName(proName);
		ProcScoringEntity engScoringEntity = new ProcScoringEntity();
		engScoringEntity.setScopeName(scopeName);


		// 查询是否有人员地点ID
		synchronized (this) {
			String useraddressid = engScoringDao
					.selectAddressid(engAddressEntity);
			logger.info("人员地点ID:" + useraddressid);
			// 有

			if (StringUtil.isNotEmpty(useraddressid)) {
				// 有人员地点表ID修改时间
				engAddressEntity.setCreateDate(date);
				engAddressEntity.setId(useraddressid);
				// 修改
				int updateEngAddress = engScoringDao
						.updateEngAddress(engAddressEntity);
				if (updateEngAddress < 1) {
					return RETURNVALUEFAIL;
				}
				// 查询打分表ID 用人员 地点ID 和打分ID
				engScoringEntity.setUserAddressid(useraddressid);
				engScoringEntity.setScopeid(scopeid);
				// 查询
				String userScopeid = engScoringDao
						.selectScopeid(engScoringEntity);
				logger.info("打分表ID:" + userScopeid);
				// 有
				if (StringUtil.isNotEmpty(userScopeid)) {
					// 修改时间 分数和时间 根据主键ID
					engScoringEntity.setCreateDate(date);
					engScoringEntity.setScope(scope);
					engScoringEntity.setId(userScopeid);
					logger.info("打分表对象:" + engScoringEntity);
					// 返回参数
					int rows = engScoringDao
							.updateEngScoring(engScoringEntity);
					logger.info("参数:" + rows);
					if (rows > 0) {
						return RETURNVALUESUCCESS;
					}
				} else {
					// 没有就直接插入 1条数据
					String scopeidCcf = UUID.randomUUID().toString();
					engScoringEntity.setCreateDate(date);
					engScoringEntity.setScope(scope);
					engScoringEntity.setId(scopeidCcf);
					// 提交打分实体
					int tag = engScoringDao
							.savaEngScoring(engScoringEntity);
					if (tag > 0) {
						return RETURNVALUESUCCESS;
					}
					return RETURNVALUEFAIL;
				}

			} else {
				// 直接插入2条数据
				String userAddressid = UUID.randomUUID().toString();
				engAddressEntity.setId(userAddressid);
				engAddressEntity.setCreateDate(date);

				// 提交地址录入
				int tag = engScoringDao.savaEngAddress(engAddressEntity);
				if (tag < 1) {
					return RETURNVALUEFAIL;
				}
				// 生成UUid
				String scoringid = UUID.randomUUID().toString();
				engScoringEntity.setId(scoringid);
				engScoringEntity.setScope(scope);
				engScoringEntity.setScopeid(scopeid);
				engScoringEntity.setUserAddressid(userAddressid);
				engScoringEntity.setCreateDate(date);
				int tag1 = engScoringDao.savaEngScoring(engScoringEntity);
				if (tag1 > 0) {
					logger.info("成功");
					return RETURNVALUESUCCESS;
				}
			}
		}

		return RETURNVALUENULL;
	}

	/**
	 * <p>
	 * Description：0分保存
	 * </p>
	 * <p>
	 * Description：地址保存
	 * </p>
	 * <p>
	 * Description：损坏原因
	 * </p>
	 * 
	 * @throws Exception
	 * @return
	 * @see String
	 */
	
	public String savaMessageReason(String str) throws Exception {
		// TODO Auto-generated method stub
		// 解析JSON
		JSONObject json = JsonUtil.parseObject(str);
		logger.info("新增页面传过来的参数为:" + json);
		// 从JSON中取值
		String userNo = json.getString("userNo");
		String proAdress = json.getString("proAdress");
		String proType = json.getString("proType");
		String scopeid = json.getString("scopeid");
		String scope2 = json.getString("scope");
		String proName = json.getString("proName");
		String scopeName = json.getString("scopeName");
		//        判断是否有值
		int scope = Integer.parseInt(scope2);
		String photo = json.getString("photo");
		String photo2 = json.getString("photo2");
		String photo3 = json.getString("photo3");
		String photo4 = json.getString("photo4");
		String photo5 = json.getString("photo5");
		String damageReason = json.getString("damageReason");
		String deductSProject = json.getString("deductSProject");
		String serviceItems = json.getString("serviceItems");


		// 判断分数
		if (scope == 0) {
			if (StringUtil.isEmpty(userNo) || StringUtil.isEmpty(proAdress)
					|| StringUtil.isEmpty(proType)
					|| StringUtil.isEmpty(scopeid)
					|| StringUtil.isEmpty(proName)
					|| StringUtil.isEmpty(scopeName) || scope < -1
					|| StringUtil.isEmpty(serviceItems)
					|| StringUtil.isEmpty(deductSProject)
					|| StringUtil.isEmpty(damageReason)
					|| StringUtil.isEmpty(photo)) {
				logger.info(RETURNVALUENULL);
				return RETURNVALUENULL;
			}
		} else {
			if (StringUtil.isEmpty(userNo) || StringUtil.isEmpty(proAdress)
					|| StringUtil.isEmpty(proType)
					|| StringUtil.isEmpty(scopeid)
					|| StringUtil.isEmpty(proName)
					|| StringUtil.isEmpty(scopeName) || scope < -1) {
				logger.info(RETURNVALUENULL);
				return RETURNVALUENULL;
			}
		}

		Date date = new Date();
		ProcAddressEntity engAddressEntity = new ProcAddressEntity();
		// 查询人员地点表
		engAddressEntity.setProType(proType);
		engAddressEntity.setProAdress(proAdress);
		engAddressEntity.setUserno(userNo);
		engAddressEntity.setProName(proName);
		// 实例化对象
		ProcScoringEntity engScoringEntity = new ProcScoringEntity();
		engScoringEntity.setScopeName(scopeName);
		// 实例化对象
		ProcMessageEntity procMessageEntity = new ProcMessageEntity();
		procMessageEntity.setDeductSProject(deductSProject);
		procMessageEntity.setDamageReason(damageReason);
		procMessageEntity.setPhoto(photo);
		procMessageEntity.setPhoto2(photo2);
		procMessageEntity.setPhoto3(photo3);
		procMessageEntity.setPhoto4(photo4);
		procMessageEntity.setPhoto5(photo5);
		procMessageEntity.setServiceItems(serviceItems);


		// 查询是否有人员地点ID
		synchronized (this) {
			String useraddressid = engScoringDao
					.selectAddressid(engAddressEntity);
			// 有
			if (StringUtil.isNotEmpty(useraddressid)) {
				// 有人员地点表ID修改时间
				engAddressEntity.setCreateDate(date);
				engAddressEntity.setId(useraddressid);
				int updateEngAddress = engScoringDao
						.updateEngAddress(engAddressEntity);
				if (updateEngAddress < 1) {
					return RETURNVALUEFAIL;
				}
				// 查询打分表ID 用人员 地点ID 和打分ID
				engScoringEntity.setUserAddressid(useraddressid);
				engScoringEntity.setScopeid(scopeid);
				String userScopeid = engScoringDao
						.selectScopeid(engScoringEntity);

				// 有
				if (StringUtil.isNotEmpty(userScopeid)) {
					// 修改时间 分数和时间 根据主键ID
					engScoringEntity.setScope(scope);
					return	getSavaScopeone(procMessageEntity, date,
							engScoringEntity,userScopeid);
				} else {
					//					判断是否有值
					engScoringEntity.setScope(scope);
					return	getSavaScopetwo(engScoringEntity
							, procMessageEntity, date);
				}

			} else {
				//				没有就插入
				engScoringEntity.setScope(scope);
				engScoringEntity.setScopeid(scopeid);
				return	getSavaScopeThree( engAddressEntity,engScoringEntity
						, procMessageEntity, date);
			}
		}

	}

	/**
	 * <p>
	 * Description：数据监控
	 * </p>
	 * 
	 * @throws Exception
	 * @return String
	 * @see String
	 */
	
	public String savaProcWatchDept(String str) throws Exception {
		// 解析JSON转换为实体类
		ProcWatchDeptEntity procWatchDeptEntity = JsonUtil.jsonToEntity(str,
				ProcWatchDeptEntity.class);

		// 判断不能为空
		if (StringUtil.isEmpty(procWatchDeptEntity.getDeptcode()) ||
				StringUtil.isEmpty(procWatchDeptEntity.getDeptname())) {
			logger.info(RETURNVALUENULL);
			return RETURNVALUENULL;
		}
		// 获得数据库记录时间
		String sqldate = engScoringDao.
				selectProcWatchDept(procWatchDeptEntity.getDeptcode());
		logger.info("数据库时间" + sqldate);
		Date newdate = new Date();
		logger.info("当前时间" + newdate);
		// 是否有记录
		if (StringUtil.isNotEmpty(sqldate)) {
			// 判断是否大于1个月
			if (compareTime(newdate, sqldate)) {
				procWatchDeptEntity.setUpdatedate(newdate);

				// 提交
				int num = engScoringDao
						.savaProcWatchDept(procWatchDeptEntity);
				if (num > 0) {
					logger.info("保存成功");
					return RETURNVALUESUCCESS;

				}
				return RETURNVALUENULL;
			} else {
				// 不做任何处理
				logger.info("不做处理");
				return "{\"resultFlag\":true,\"failureReason\":\"没满一个月不处理\"}";
			}
		} else {
			// 做保存处理
			procWatchDeptEntity.setUpdatedate(newdate);
			//            提交部门的信息
			int num = engScoringDao.savaProcWatchDept(procWatchDeptEntity);
			if (num > 0) {
				logger.info("保存成功");
				return RETURNVALUESUCCESS;

			}
			return RETURNVALUENULL;
		}

	}

	/**
	 * <p>
	 * Description：数据监控
	 * </p>
	 * 
	 * @throws Exception
	 * @return String
	 * @see String
	 */
	
	public String savaProcWatchProject(String str) throws Exception {
		logger.info(str);
		// 解析JSON转换实体类
		List<ProcWatchProjectEntity> pro = JsonUtil.jsonToList(str,
				ProcWatchProjectEntity.class);
		if (pro != null) {
			Date date = new Date();
			// 循环判断
			for (ProcWatchProjectEntity procWatchDeptEntity2 : pro) {
				procWatchDeptEntity2.setUpdatedate(date);
				if (StringUtil.isEmpty(procWatchDeptEntity2.getProcode())
						|| StringUtil.isEmpty(procWatchDeptEntity2.getProname())
						|| procWatchDeptEntity2.getPronum() < -1
						|| procWatchDeptEntity2.getProcount() < -1) {
					logger.info(RETURNVALUENULL);
					return RETURNVALUENULL;
				}
			}
			synchronized (this) {
				// 批量删除
				int deletenum = engScoringDao.deleteProcWatchProject(pro);
				if (deletenum > 0) {
					logger.info("删除数量" + deletenum);
					// 批量修改
					int savanum = engScoringDao.savaProcWatchProject(pro);
					if (savanum > 0) {
						logger.info("提交数量" + savanum);
						return RETURNVALUESUCCESS;
					}

				}

			}

		}
		return RETURNVALUENULL;
	}

	/**
	 * <p>
	 * Description：比较时间
	 * </p>
	 * 
	 * @return boolean
	 */


	public boolean compareTime(Date newdate, String sqldate) {
		// 时间格式
		SimpleDateFormat simplea = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			// 数据库时间转换
			d = simplea.parse(sqldate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// 设置时间格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
		// 转换后并去掉-
		String sqldateformat = simpleDateFormat.format(d);
		String sqldatestr = sqldateformat.replace("-", "");
		int sqlde = Integer.parseInt(sqldatestr);
		// 转换后并去掉-
		String dateNowStr = simpleDateFormat.format(newdate);
		String newdatestr = dateNowStr.replace("-", "");
		int newde = Integer.parseInt(newdatestr);

		logger.info("转换比较1:" + newde);
		logger.info("转换比较2:" + sqlde);
		// 时间大于1一个月
		if (newde - sqlde > ConstantClassField.VALUEJIUJIU) {
			return true;
		}
		return false;
	}
	//    为了减少代码的重复性  ，就适当的写一个方法
	private String getResult(int i){
		if (i >0) {
			return RETURNVALUESUCCESS;
		}
		return RETURNVALUENULL;
	}
	/**
	 * 
	 * @param procMessageEntity
	 * @param date
	 * @param engScoringEntity
	 * @param userScopeid
	 * @return
	 * @throws Exception
	 */
	private String  getSavaScopeone(ProcMessageEntity
			procMessageEntity,Date date,ProcScoringEntity engScoringEntity,String userScopeid
			) throws Exception{
		engScoringEntity.setCreateDate(date);

		engScoringEntity.setId(userScopeid);
		int updateEngScoring = engScoringDao
				.updateEngScoring(engScoringEntity);
		if (updateEngScoring < 1) {
			return RETURNVALUEFAIL;
		}
		String messageid = engScoringDao
				.selectMessageid(userScopeid);
		if (StringUtil.isNotEmpty(messageid)) {
			// 有就修改
			procMessageEntity.setId(messageid);
			procMessageEntity.setUserScoreid(userScopeid);
			int tag = engScoringDao
					.updateProcMessage(procMessageEntity);
			return getResult(tag);
		} else {
			// 没有就直接插入
			String messageuuid = UUID.randomUUID().toString();
			procMessageEntity.setId(messageuuid);
			procMessageEntity.setUserScoreid(userScopeid);
			int tag = engScoringDao
					.savaProcMessage(procMessageEntity);
			return getResult(tag);
		}
	}

	/**
	 * 
	 * @param engScoringEntity
	 * @param procMessageEntity
	 * @param date
	 * @return
	 * @throws Exception
	 */
	private String getSavaScopetwo(
			ProcScoringEntity engScoringEntity,ProcMessageEntity
			procMessageEntity,Date date) throws Exception{

		// 没有就直接插入 2条数据
		String scopeid = UUID.randomUUID().toString();
		engScoringEntity.setCreateDate(date);

		engScoringEntity.setId(scopeid);
		int tag = engScoringDao
				.savaEngScoring(engScoringEntity);
		if (tag < 1) {
			return RETURNVALUEFAIL;
		}
		// 一条打分数据
		String messageuuid = UUID.randomUUID().toString();
		procMessageEntity.setId(messageuuid);
		procMessageEntity.setUserScoreid(scopeid);
		// 插入一条损坏原因数据
		int tag1 = engScoringDao
				.savaProcMessage(procMessageEntity);

		if (tag1 > 0) {

			return RETURNVALUESUCCESS;
		}
		return RETURNVALUEFAIL;
	}
	/*
	 * 直接插入3条语句
	 */
	private String getSavaScopeThree(ProcAddressEntity 
			engAddressEntity,
			ProcScoringEntity engScoringEntity,ProcMessageEntity
			procMessageEntity,Date date) throws Exception{
		// 直接插入3条数据
		String userAddressid = UUID.randomUUID().toString();
		engAddressEntity.setId(userAddressid);
		engAddressEntity.setCreateDate(date);
		int tag = engScoringDao.savaEngAddress(engAddressEntity);
		if (tag < 1) {

			return RETURNVALUEFAIL;
		}

		// 插入打分数据
		String scoringid = UUID.randomUUID().toString();
		engScoringEntity.setId(scoringid);

		engScoringEntity.setUserAddressid(userAddressid);
		engScoringEntity.setCreateDate(date);

		// 插入损坏原因数据
		String messageuuid = UUID.randomUUID().toString();
		procMessageEntity.setId(messageuuid);
		procMessageEntity.setUserScoreid(scoringid);
		// 插入一条损坏原因数据
		int tag2 = engScoringDao.savaProcMessage(procMessageEntity);

		if (tag2 < 1) {

			return RETURNVALUEFAIL;
		}
		// 插入一条得分数据
		int tag3 = engScoringDao.savaEngScoring(engScoringEntity);
		if (tag3 > 0) {
			// 返回结果

			return RETURNVALUESUCCESS;

		}
		return RETURNVALUENULL;
	}
}
