package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.domain.MonitorCountInfoEntity;
import com.deppon.dpm.module.management.server.dao.IProcCheckScoreDao;
import com.deppon.dpm.module.management.server.service.IProcCheckScoreService;
import com.deppon.dpm.module.management.shared.domain.ConstantClassField;
import com.deppon.dpm.module.management.shared.domain.ProcCheckScoreEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckStandardNameEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101(修改袁中华代码，哥不背这个黑锅，烂代码) ProcCheckScoreService 接口实现
 * 
 */
public class ProcCheckScoreService implements IProcCheckScoreService {

	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(ProcScoringService.class);
	/**
	 * 注入对象
	 */
	IProcCheckScoreDao procCheckScoreDao;

	/**
	 * @param procCheckScoreDao
	 *            dao接口
	 */
	public void setProcCheckScoreDao(IProcCheckScoreDao procCheckScoreDao) {
		this.procCheckScoreDao = procCheckScoreDao;
	}

	/**
	 * 保存合格和不合格以及初次和最终
	 * 
	 * @param String
	 * @return String
	 */
	
	public String savaPassCheck(String stu) {
		// json转实体对象
		ProcCheckScoreEntity procCheckScoreEntity = JsonUtil.jsonToEntity(stu,
				ProcCheckScoreEntity.class);
		// 判断页面值
		if (getPagePassValue(procCheckScoreEntity)) {
			logger.debug("很好,值不为空! 合格的开始");
			// 判断分数
			if (procCheckScoreEntity.getScore() > 0) {
				// 判断扣分传入值
				if (getPageOutValue(procCheckScoreEntity)) {
					logger.debug("很好,值不为空! 扣分的开始");
				} else {
					// 值为空
					logger.debug("界面传值有些为空："
							+ ConstantClassField.RETURNVALUENULL);
					return ConstantClassField.RETURNVALUENULL;
				}
			}
		} else {
			// 值为空
			logger.debug("界面传值有些为空”" + ConstantClassField.RETURNVALUENULL);
			// 返回数据
			return ConstantClassField.RETURNVALUENULL;
		}
		// 把时间放进实体类
		procCheckScoreEntity.setSubmitNub(getnum(procCheckScoreEntity
				.getSubmitNub()));
		// 保存时间
		getNewDate(procCheckScoreEntity);
		// 线程同步
		synchronized (this) {
			// 判断地址表是否有数据
			if (getRecordId(procCheckScoreEntity)) {
				// 开始修改地址表
				int recordNum = procCheckScoreDao
						.updateCheckRecord(procCheckScoreEntity);
				// 判断参数
				if (recordNum < 1) {
					return ConstantClassField.RETURNVALUEFAIL;
				}
				// 如果为空那就保存，不然就修改
				if (getProcCheckScoreId(procCheckScoreEntity)) {
					// 修改工程验收扣分表数据
					int scoreNum = procCheckScoreDao
							.updateCheckScore(procCheckScoreEntity);
					// 判断是否更新成功
					if (scoreNum > 0) {
						logger.info("修改成功：");
						// 返回
						return ConstantClassField.RETURNVALUESUCCESS;
					}
				} else {
					// 塞入数据
					procCheckScoreEntity.setScoreid(getUUID());
					logger.debug("scoreid表的ID："
							+ procCheckScoreEntity.getScoreid());
					// 保存Score表
					int scoreNum = procCheckScoreDao
							.savaCheckScore(procCheckScoreEntity);
					// 判断是否保存成功
					if (scoreNum > 0) {
						return ConstantClassField.RETURNVALUESUCCESS;
					}
					// 返回数据
					return ConstantClassField.RETURNVALUEFAIL;
				}
			} else {
				procCheckScoreEntity.setRecordid(getUUID());
				logger.debug("record表的ID：" + procCheckScoreEntity.getRecordid());
				// 保存Record表
				int recordNum = procCheckScoreDao
						.savaCheckRecord(procCheckScoreEntity);
				if (recordNum < 1) {
					return ConstantClassField.RETURNVALUEFAIL;
				}
				// 保存ID
				procCheckScoreEntity.setScoreid(getUUID());
				logger.debug("scoreid表的ID：" + procCheckScoreEntity.getScoreid());
				// 保存Score表
				int scoreNum = procCheckScoreDao
						.savaCheckScore(procCheckScoreEntity);
				// 对保存的scoreNum标志位进行判断
				if (scoreNum > 0) {
					// 返回数据
					return ConstantClassField.RETURNVALUESUCCESS;
				}
			}
		}
		// return 数据
		return ConstantClassField.RETURNVALUEFAIL;
	}

	/**
	 * /** 拉保存合格和不合格数据以及初次和最终
	 * 
	 * @param String
	 * @return String
	 */
	
	public String getProcCheckStandard(String stu) {
		// 解析json
		ProcCheckStandardNameEntity json = JsonUtil.jsonToEntity(stu,
				ProcCheckStandardNameEntity.class);
		logger.debug("Json数据" + json);
		// 判断前端传过来的数据是否为空
		if (StringUtil.isEmpty(json.getAddressCode())
				|| StringUtil.isEmpty(json.getNavCode())
				|| StringUtil.isEmpty(json.getOrigItemCode())
				|| json.getSubmitNub() < -1) {
			return ConstantClassField.RETURNVALUENULL;
		}
		// 设置状态
		json.setSubmitNub(getnum(json.getSubmitNub()));
		json.setIsSubmit(getisSubmit(json.getSubmitNub()));
		// 数据库是否有数据
		ProcCheckStandardNameEntity revalue = procCheckScoreDao
				.getProcCheckSelectStandard(json);
		logger.debug("revalue" + revalue);
		Map<String, Object> resmap = new HashMap<String, Object>();
		// 判断是否为null
		if (revalue != null) {
			List<Object> list = new ArrayList<Object>();
			List<Object> imglist = new ArrayList<Object>();
			// 判断是否为null
			if (revalue.getSelectItem() != null) {
				// 得到splitvalue
				String[] splitvalue = getSplit(revalue.getSelectItem());
				// 循环判断
				for (int i = 0; i < splitvalue.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					// put 数据
					map.put("isCheck", true);
					// put 数据
					map.put("name", splitvalue[i]);
					// 把map加入list
					list.add(map);
				}
			}
			// 判断它的未选字段
			if (revalue.getUnSelectItem() != null) {
				String[] nocheckvalue = getSplit(revalue.getUnSelectItem());
				for (int i = 0; i < nocheckvalue.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					// put 数据
					map.put("isCheck", false);
					// put 数据
					map.put("name", nocheckvalue[i]);
					// 把map加入list
					list.add(map);
				}
			}
			// 保存图片
			getImg(revalue.getImgOne(), imglist);
			// 保存图片
			getImg(revalue.getImgFive(), imglist);
			// 保存图片
			getImg(revalue.getImgFour(), imglist);
			// 保存图片
			getImg(revalue.getImgThree(), imglist);
			// 保存图片
			getImg(revalue.getImgTwo(), imglist);
			resmap.put("option", list);
			if (imglist != null && imglist.size() > 0) {
				resmap.put("img", imglist);
			}
			resmap.put("opinion", revalue.getOpinion());
			//返回json格式数据
			return JsonUtil.mapToJsonString(resmap);

		} else {
			// 数据库没有数据直接拉取基本数据
			String noCheckValue = procCheckScoreDao
					.getProcCheckStandardName(json);
			logger.debug("查询值" + noCheckValue);
			if (noCheckValue != null) {
				// 分割
				String[] splitvalue = getSplit(noCheckValue);
				logger.debug("查询值");
				// 去空循环放入
				List<Object> list = new ArrayList<Object>();
				for (int i = 0; i < splitvalue.length; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("isCheck", false);
					map.put("name", splitvalue[i]);
					list.add(map);
				}
				resmap.put("option", list);
				// 返回一个json给前端！
				return JsonUtil.mapToJsonString(resmap);
			}
			return ConstantClassField.RETURNVALUENULL;
		}
	}

	/**
	 * 对初次按钮的一个保存，修改以及全部状态
	 */
	
	public String updateCheckRecordAll(String stu) throws BusinessException {
		// TODO Auto-generated method stub
		ProcCheckScoreEntity procCheckScoreEntity = JsonUtil.jsonToEntity(stu,
				ProcCheckScoreEntity.class);
		if (getPageCheckFirst(procCheckScoreEntity)) {
			logger.debug("可以开始修改了");
			getNewDate(procCheckScoreEntity);

			// 营业部查询地址表所有数据
			List<ProcCheckScoreEntity> recordAll = procCheckScoreDao
					.getProcCheckRecordAll(procCheckScoreEntity);
			logger.debug("可以开始修改了" + recordAll.size());
			if (recordAll.size() < 1) {
				return ConstantClassField.RETURNVALUEFAIL;
			}
			// 营业部拉取打分表的所有数据
			List<ProcCheckScoreEntity> scoreAll = procCheckScoreDao
					.getProcCheckScoreAll(recordAll);
			logger.debug("可以开始修改了" + scoreAll.size());
			if (scoreAll.size() < 1) {
				return ConstantClassField.RETURNVALUEFAIL;
			}
			Date newdate = new Date();
			// 对最终数据的操作for for循环的对初次包装
			for (ProcCheckScoreEntity recordAll2 : recordAll) {
				String str = getUUID();
				logger.debug("UUID" + str);
				for (ProcCheckScoreEntity procCheckScoreEntity2 : scoreAll) {
					if (recordAll2.getRecordid().equals(
							procCheckScoreEntity2.getCheckrecordId())) {

						procCheckScoreEntity2.setCheckrecordId(str);
						procCheckScoreEntity2.setScoreid(getUUID());
						logger.debug("打分表ID"
								+ procCheckScoreEntity2.getScoreid());
						procCheckScoreEntity2.setScorecreateDate(newdate);

					}
				}
				// set 数据
				recordAll2.setRecordid(str);
				// set 数据
				recordAll2.setCheckDate(newdate);
				// set 数据
				recordAll2.setSubmitNub(2);

			}

			// 因为图片有点多 必须一条一条插入
			for (ProcCheckScoreEntity procCheckScoreEntity2 : scoreAll) {
				procCheckScoreDao.savaProcCheckScoreAll(procCheckScoreEntity2);
			}

			// 保存数据
			int renum = procCheckScoreDao.savaProcCheckRecordAll(recordAll);
			logger.debug("修改了" + renum);
			if (renum < 1) {
				return ConstantClassField.RETURNVALUEFAIL;
			}
			// 修改地址表的状态
			int num = procCheckScoreDao
					.updateCheckRecordAll(procCheckScoreEntity);
			logger.debug("修改数量" + num);
			if (num < 1) {
				return ConstantClassField.RETURNVALUEFAIL;
			}
			// 修改推送数据表的状态
			int taskNum = procCheckScoreDao
					.updateCheckTask(procCheckScoreEntity);
			if (taskNum > 0) {
				return ConstantClassField.RETURNVALUESUCCESS;
			}

		} else {
			// 值为空
			logger.debug("界面传值有些为空：" + ConstantClassField.RETURNVALUENULL);
			return ConstantClassField.RETURNVALUENULL;
		}
		// 返回参数
		return ConstantClassField.RETURNVALUEFAIL;

	}

	/**
	 * 数据访问量保存
	 * 
	 * @param MonitorCountInfoEntity
	 * @return int
	 */
	
	public String savaCheckControl(String stu) {
		// TODO Auto-generated method stub
		Log.info("界面数据" + stu);
		// 解析json
		MonitorCountInfoEntity monitor = JsonUtil.jsonToEntity(stu,
				MonitorCountInfoEntity.class);
		Log.info("JSON" + monitor);
		if (monitor != null) {
			// 判断数据是否为空 以及Constants.PROC_CHECK_ACCEPT值为监控表数据字典
			if (StringUtil.isEmpty(monitor.getUserId())
					|| monitor.getType() != Constants.PROC_CHECK_ACCEPT) {
				logger.info("界面传值有些为空：" + ConstantClassField.RETURNVALUENULL);
				return ConstantClassField.RETURNVALUENULL;
			} else {
				// 值为空
				monitor.setStartTime(new Date());
				monitor.setEndTime(new Date());
				// 调用数据监控dao层接口
				int num = procCheckScoreDao.savaCheckControl(monitor);
				if (num > 0) {
					Log.info("成功" + num);
					return ConstantClassField.RETURNVALUESUCCESS;
				}

			}
		}
		// 返回参数
		return ConstantClassField.RETURNVALUEFAIL;
	}

	/**
	 * 判断页面合格值
	 * 
	 * @param ProcCheckScoreEntity
	 * @return Boolean
	 */
	private Boolean getPagePassValue(ProcCheckScoreEntity json) {
		// 判断界面的值是否为空
		if (StringUtil.isEmpty(json.getNavName())
				|| StringUtil.isEmpty(json.getNavCode())
				|| StringUtil.isEmpty(json.getAddress())
				|| json.getStaticScore() < -1
				|| StringUtil.isEmpty(json.getAddressCode())
				|| StringUtil.isEmpty(json.getUserNo())
				|| StringUtil.isEmpty(json.getOrigItemCode())
				|| StringUtil.isEmpty(json.getOrigItemName())
				|| json.getSubmitNub() < -1 || json.getScore() < -1) {
			return false;
		}
		return true;
	}

	/**
	 * 判断页面不合格值
	 * 
	 * @param ProcCheckScoreEntity
	 * @return Boolean
	 */
	private Boolean getPageOutValue(ProcCheckScoreEntity json) {
		// 判断参数是否为null
		if (StringUtil.isEmpty(json.getImgOne())
				|| StringUtil.isEmpty(json.getSelectItem())) {
			return false;
		}
		return true;
	}

	/**
	 * @param json
	 *            boolean欧判断
	 * @return
	 */
	private Boolean getPageCheckFirst(ProcCheckScoreEntity json) {
		// 判断参数是否为null
		if (StringUtil.isEmpty(json.getUserNo())
				|| StringUtil.isEmpty(json.getAddressCode())) {
			return false;
		}
		return true;
	}

	/**
	 * 保存时间
	 * 
	 * @param ProcCheckScoreEntity
	 */
	private void getNewDate(ProcCheckScoreEntity procCheckScoreEntity) {
		// new 一个时间
		Date newdate = new Date();
		// 塞入数据
		procCheckScoreEntity.setCheckDate(newdate);
		// 塞入数据
		procCheckScoreEntity.setScorecreateDate(newdate);
	}

	/**
	 * 生成UUID
	 * 
	 * @param ProcCheckScoreEntity
	 */
	private String getUUID() {
		// 生成uuid
		String id = UUID.randomUUID().toString();
		return id;
	}

	// 判断地址表是否有数据
	private boolean getRecordId(ProcCheckScoreEntity procCheckScoreEntity) {
		// 查询工程验收导航栏表ID
		String str = procCheckScoreDao
				.selectCheckRecordId(procCheckScoreEntity);
		// 判断参数是否为null
		if (StringUtil.isNotEmpty(str)) {
			procCheckScoreEntity.setRecordid(str);
			return true;
		}
		return false;

	}

	// 判断分数表是否有数据
	private boolean getProcCheckScoreId(
			ProcCheckScoreEntity procCheckScoreEntity) {
		// 查询工程验收扣分表ID
		String str = procCheckScoreDao
				.selectProcCheckScoreId(procCheckScoreEntity);
		// 判断参数是否为null
		if (StringUtil.isNotEmpty(str)) {
			// 塞入参数
			procCheckScoreEntity.setScoreid(str);
			return true;
		}
		return false;

	}

	// 判读图片不为空
	public void getImg(String r, List<Object> imglist) {
		Log.info("图片的值" + r);
		// 判断值是否符合条件
		if (r != null) {

			imglist.add(r);
		}

	}

	// 对数据库查询的分割
	public String[] getSplit(String stu) {
		// 正则表达式
		String[] str = stu.replaceAll("\\；", "\\|").replaceAll("\\;", "\\|")
				.split("\\|");
		// 返回正则
		return str;
	}

	// 初次和最终提交的状态
	public int getnum(int i) {
		int num = ConstantClassField.VALUEONE;
		Log.info("i" + i + "num" + num);
		// 3元表达式
		int state = i > num ? 2 : 0;
		return state;
	}

	// PC的状态
	public String getisSubmit(int i) {
		// num=2
		int num = ConstantClassField.VALUETWO;
		Log.info("i" + i + "num" + num);
		// 3元表达式
		String state = i > num ? "Y" : "N";
		//返回state
		return state;
	}

}
