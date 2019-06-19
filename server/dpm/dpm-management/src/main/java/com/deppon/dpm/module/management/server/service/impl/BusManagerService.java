package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IBusManagerDao;
import com.deppon.dpm.module.management.server.service.IBusManagerService;
import com.deppon.dpm.module.management.shared.domain.BusCentreAdviceEntity;
import com.deppon.dpm.module.management.shared.domain.BusFormBeanEntity;
import com.deppon.dpm.module.management.shared.domain.BusLineInfo;
import com.deppon.dpm.module.management.shared.domain.BusLineOfSite;
import com.deppon.dpm.module.management.shared.domain.BusManagerView;
import com.deppon.dpm.module.management.shared.domain.BusMessageView;
import com.deppon.dpm.module.management.shared.domain.BusUserEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.classes.BeanUtils;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 ccf 班车管理service接口的实现
 */
public class BusManagerService implements IBusManagerService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusManagerService.class);
	/**
	 * 线路调整dao接口
	 */
	private IBusManagerDao busManagerDao;

	/**
	 * @return 得到路线调整list数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public List<BusManagerView> getWayMessage() throws BusinessException {
		//得到路线调整list数据
		List<BusManagerView> busView = this.busManagerDao.getWayMessage();
        //new 一个listView
		List<BusManagerView> listView = new ArrayList<BusManagerView>();
		//循环重组数组
		for (BusManagerView bus : busView) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date stDate = bus.getStartDate();
			String timeDate = dateFormat.format(stDate);
			bus.setStartTime(timeDate);
			listView.add(bus);
		}
		//返回listView
		return listView;

	}

	/**
	 * @param lineId
	 *            线路id
	 * @return 这条线路数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public List<BusMessageView> getOneMessage(String lineId) throws BusinessException {
		//得到线路数据
		List<BusMessageView> busView = this.busManagerDao.getOneMessage(lineId);
		//判断这条线路是否有数据
		if (busView.size() > 0) {
			List<BusMessageView> listView = new ArrayList<BusMessageView>();
			//在循环组装数据
			for (BusMessageView bus : busView) {
				//时间格式化
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				Date stDate = bus.getStartDate();
				String timeDate = dateFormat.format(stDate);
				bus.setStartTime(timeDate);
				listView.add(bus);
			}
			return listView;
		}
		return null;

	}

	/**
	 * <p>
	 * Description: 更新站点和线路状态
	 * </p>
	 * 
	 * @param busSite
	 *            线路站点表
	 * 
	 * @return 字符串
	 * @throws BusinessException
	 *             抛出异常
	 */

	public String updateStation(BusLineOfSite busSite) throws BusinessException {
		String res = "";
		if (null != busSite) {
			//update 数据
			int flag = this.busManagerDao.updateStation(busSite);

			try {
				if (flag > 0) {
					res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"修改错误！\"}";
				}
			} catch (BusinessException e) {
				//捕获异常
				res = "{\"resultFlag\":false,\"failureReason\":\"修改错误！\"}";
			}

		}
        //返回结果
		return res;

	}

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
	public String updateLineTime(BusLineInfo lineInfo) throws BusinessException {
		String res = "";
		if (null != lineInfo) {
            //更新线路
			int lineFlag = this.busManagerDao.updateLineInfo(lineInfo);
			try {
				//判断是否更新线路成功
				if (lineFlag > 0) {
					res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"修改错误！\"}";
				}
			} catch (BusinessException e) {
				res = "{\"resultFlag\":false,\"failureReason\":\"修改错误！\"}";
			}

		}
        //返回结果
		return res;

	}

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

	public String saveLineInfo(BusLineInfo lineInfo) throws BusinessException {
		String res = "";
		if (null != lineInfo) {
			logger.info("进入保存线路service");
			// 根据主键id得到线路信息
			List<BusLineInfo> listInfo = this.busManagerDao
					.listLineInfo(lineInfo);
			logger.info("查询线路详细信息service!!!!!");
			List<BusLineOfSite> listSite = new ArrayList<BusLineOfSite>();
			if (lineInfo.getId() > 0) {
				// 得到站点表详细信息
				listSite = this.busManagerDao.listSite(lineInfo.getId());
			}

			BusLineInfo busLineInfo = new BusLineInfo();
			if (listInfo.size() > 0) {
				BeanUtils.copyProperties(listInfo.get(0), busLineInfo); // copy一个对象
				// 保存线路信息
				int lineMark = this.busManagerDao.saveLineInfo(busLineInfo);
				if (lineMark > 0) {
					logger.info("保存线路成功!!!!!");
					//获得主键id
					int lineId = this.busManagerDao.getMaxLineId();
                    //循环判断
					for (BusLineOfSite busLineOfSite : listSite) {
						busLineOfSite.setLineId(lineId);
						int idSucc = this.busManagerDao
								.saveLineSite(busLineOfSite);
						if (idSucc > 0) {
							logger.info("保存站点表成功!!!!!");
							res = "{\"resultFlag\":\"true\",\"failureReason\":\"\",\"lineId\":"
									+ lineId + "}";
						} else {
							res = "{\"resultFlag\":false,\"failureReason\":\"保存数据出错！\"}";
						}
					}
				} else {
					res = "{\"resultFlag\":false,\"failureReason\":\"保存数据出错！\"}";
				}
			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"保存数据出错！\"}";
			}

		} else {
			res = "{\"resultFlag\":false,\"failureReason\":\"保存数据出错！\"}";
		}

		return res;

	}

	/**
	 * <p>
	 * Description: 得到评价建议列表接口
	 * </p>
	 * 
	 * @return 建议和评价组装成map数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public String getEvaManData() throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"评价建议列表没有数据！！\"}";
		Map<String, Object> mapData = new HashMap<String, Object>();
		List<BusFormBeanEntity> beanEntities = new ArrayList<BusFormBeanEntity>();
		// 得到评价表和建议表中间表的list数据 查询近期一个月数据
		List<BusCentreAdviceEntity> listCentre = this.busManagerDao
				.getCentreData();
		if ((null != listCentre) && !listCentre.isEmpty()) {
			logger.info("评价表和中间表的数据为" + listCentre);
			for (BusCentreAdviceEntity cenAdv : listCentre) {
				// 判断是建议表，还是评价表 1是建议，0是评价
				if (cenAdv.getCentreMark() == 1) {
					BusFormBeanEntity entity = getAdviceFormBeanData(cenAdv
							.getCentreId());
					if (null != entity) {
						logger.info("建议表的数据为!!!!!!!!!!!!!!" + entity);
						beanEntities.add(entity);
					}

					/*
					 * mapData.put("listEntities",
					 * getAdviceFormBeanData(cenAdv.getCentreId()));
					 */
				}
				if (cenAdv.getCentreMark() == 0) {
					BusFormBeanEntity formBeanEntity = getEvaFormBeanData(cenAdv
							.getCentreId());
					if (null != formBeanEntity) {
						logger.info("评价表数据位!!!!!!!!!!!!!!" + formBeanEntity);
						beanEntities.add(formBeanEntity);
					}

					/*
					 * mapData.put("listEva",
					 * getEvaFormBeanData(cenAdv.getCentreId()));
					 */
				}

			}
			mapData.put("listEntities", beanEntities);

		} else {
			return res;
		}
		return JsonUtil.mapToJsonString(mapData);

	}

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
	public String getHistoryData(String userNo) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"没有数据！\"}";
		if (!StringUtil.isEmpty(userNo)) {
			Map<String, Object> mapData = new HashMap<String, Object>();
			List<BusFormBeanEntity> beanEntities = new ArrayList<BusFormBeanEntity>();
			// 得到评价表和建议表中间表的list数据 查询近期一个月数据
			List<BusCentreAdviceEntity> listCentre = this.busManagerDao
					.getBusCentreData(userNo);

			if ((null != listCentre) && !listCentre.isEmpty()) {
				logger.info("评价表和中间表的数据为" + listCentre);
				for (BusCentreAdviceEntity cenAdv : listCentre) {

					// 判断是建议表，还是评价表 1是建议，0是评价
					if (cenAdv.getCentreMark() == 1) {
						logger.info("进入建议！！！！service");
						// 得到开线建议的数据
						BusFormBeanEntity beanEntity = getAdviceFormBeanData(cenAdv
								.getCentreId());
						if (null != beanEntity) {
							beanEntities.add(beanEntity);
						}

						/*
						 * mapData.put("listEntities",
						 * getAdviceFormBeanData(cenAdv.getCentreId()));
						 */
					}
					if (cenAdv.getCentreMark() == 0) {
						logger.info("进入评价！！！！service");
						// 得到用户评价的数据
						BusFormBeanEntity formBeanEntity = getEvaFormBeanData(cenAdv
								.getCentreId());
						if (null != formBeanEntity) {
							beanEntities.add(formBeanEntity);
						}

						/*
						 * mapData.put("listEva",
						 * getEvaFormBeanData(cenAdv.getCentreId()));
						 */
					}

				}

				mapData.put("listEntities", beanEntities);

			} else {
				return res;

			}
			return JsonUtil.mapToJsonString(mapData);
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
	 * @throws BusinessException
	 *             抛出异常
	 */
	public BusFormBeanEntity getEvaFormBeanData(int id) throws BusinessException {
		if (id > 0) {
			List<BusFormBeanEntity> listBean = this.busManagerDao
					.getEvaFormBeanData(id);
			if (listBean.size() > 0) {
				BusFormBeanEntity beanEntity = null;
				List<String> adviceIdList = new ArrayList<String>(); // 组装回复建用户评价id
				List<String> replyNoList = new ArrayList<String>(); // 组装回复内容人工号的list
				List<String> contentList = new ArrayList<String>(); // 组装回复内容的list
				List<String> photoList = new ArrayList<String>();
				// List<BusFormBeanEntity> listEntities = new
				// ArrayList<BusFormBeanEntity>();
				// 对建议数据进行重组
				for (BusFormBeanEntity busEntity : listBean) {
					beanEntity = new BusFormBeanEntity();
					// 对时间格式进行转换
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm");
					Date stDate = busEntity.getOpenDate();
					String timeDate = dateFormat.format(stDate);
					BeanUtils.copyProperties(busEntity, beanEntity);
					beanEntity.setOpenStartTime(timeDate);
					//抽取方法
					checkNull(adviceIdList, replyNoList, contentList,
							photoList, busEntity);
					beanEntity.setMark(0);
				}

				

				// 得到用户数据
				if (null != beanEntity) {
					// list转换为数组
					if (adviceIdList != null && adviceIdList.size() > 0) {
						beanEntity.setArrAdviceId((String[]) adviceIdList
								.toArray(new String[adviceIdList.size()]));
					}
					if (contentList != null && contentList.size() > 0) {
						beanEntity.setArrOpenContent((String[]) contentList
								.toArray(new String[contentList.size()]));

					}

					if (replyNoList != null && replyNoList.size() > 0) {
						beanEntity.setArrOpenNo((String[]) replyNoList
								.toArray(new String[replyNoList.size()]));
					}
					if (photoList != null && photoList.size() > 0) {
						beanEntity.setArrPhoto((String[]) photoList
								.toArray(new String[photoList.size()]));
					}
					List<BusUserEntity> listUser = this.busManagerDao
							.getUserData(beanEntity.getOpenUserNo());
					for (BusUserEntity busUserEntity : listUser) {
						// 得到用户名
						beanEntity.setUserName(busUserEntity.getEmpName());
					}
				}
				// listEntities.add(beanEntity);
				return beanEntity;
			}
		}
		return null;
	}

	private void checkNull(List<String> adviceIdList, List<String> replyNoList,
			List<String> contentList, List<String> photoList,
			BusFormBeanEntity busEntity) {
		if (busEntity.getRetId() > 0) {
			adviceIdList
					.add(String.valueOf(busEntity.getManageId()));
		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getOpenReplyUserNo())) {
			replyNoList.add(busEntity.getOpenReplyUserNo());

		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getOpenReplyContent())) {
			contentList.add(busEntity.getOpenReplyContent());

		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getPhoto())) {
			photoList.add(busEntity.getPhoto());
		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getPhoto1())) {
			photoList.add(busEntity.getPhoto1());
		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getPhoto2())) {
			photoList.add(busEntity.getPhoto2());
		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getPhoto3())) {
			photoList.add(busEntity.getPhoto3());
		}
		//非空判断
		if (!StringUtil.isEmpty(busEntity.getPhoto4())) {
			photoList.add(busEntity.getPhoto4());
		}
	}


	/**
	 * <p>
	 * Description: 得到开线建议数据
	 * </p>
	 * 
	 * @param id
	 *            开线建议主键id
	 * @return 开线建议list数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public BusFormBeanEntity getAdviceFormBeanData(int id) throws BusinessException {
		if (id > 0) {
			List<BusFormBeanEntity> listBean = this.busManagerDao
					.getOpenAdviceData(id);
			if (listBean.size() > 0) {
				BusFormBeanEntity beanEntity = null;
				List<String> adviceIdList = new ArrayList<String>(); // 组装回复建议主表adviceId的List
				List<String> replyNoList = new ArrayList<String>(); // 组装回复内容人工号的list
				List<String> contentList = new ArrayList<String>(); // 组装回复内容的list
				// List<BusFormBeanEntity> listEntities = new
				// ArrayList<BusFormBeanEntity>();
				// 对建议数据进行重组
				for (BusFormBeanEntity busEntity : listBean) {
					beanEntity = new BusFormBeanEntity();
					// 对时间格式进行转换
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm");
					Date stDate = busEntity.getOpenDate();
					String timeDate = dateFormat.format(stDate);
					BeanUtils.copyProperties(busEntity, beanEntity); // copy一个对象
					beanEntity.setOpenStartTime(timeDate);
					if (busEntity.getAdviceId() > 0) {
						adviceIdList
								.add(String.valueOf(busEntity.getAdviceId()));
					}
					if (!StringUtil.isEmpty(busEntity.getOpenReplyUserNo())) {
						replyNoList.add(busEntity.getOpenReplyUserNo());
					}
					if (!StringUtil.isEmpty(busEntity.getOpenReplyContent())) {
						contentList.add(busEntity.getOpenReplyContent());
					}
					beanEntity.setMark(1);
				}
                if(null != beanEntity) {
                	// list转换为数组
    				if ((adviceIdList != null && adviceIdList.size() > 0)) {
    					beanEntity.setArrAdviceId((String[]) adviceIdList
    							.toArray(new String[adviceIdList.size()]));
    				}

    				if (contentList != null && contentList.size() > 0) {
    					beanEntity.setArrOpenContent((String[]) contentList
    							.toArray(new String[contentList.size()]));
    				}
    				if (replyNoList != null && replyNoList.size() > 0) {
    					beanEntity.setArrOpenNo((String[]) replyNoList
    							.toArray(new String[replyNoList.size()]));
    				}
    				List<BusUserEntity> listUser = this.busManagerDao
							.getUserData(beanEntity.getOpenUserNo());
					for (BusUserEntity busUserEntity : listUser) {
						// 得到用户名
						beanEntity.setUserName(busUserEntity.getEmpName());
					}
                	
                }
				

				// listEntities.add(beanEntity);
				return beanEntity;

			}

		}
		return null;

	}

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
	
	public String delReply(BusFormBeanEntity beanEntity) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"删除回复出错！\"}";
		if (null != beanEntity) {
			if (beanEntity.getAdviceId() > 0) {
				logger.info("进入删除回复service!!!!!!!!!!!!");
				// 开线建议回复
				if (beanEntity.getMark() == 1) {
					int openFlag = this.busManagerDao
							.delOpenLineReply(beanEntity.getAdviceId());
					if (openFlag > 0) {
						logger.info("删除回复建议成功!!!!!!!!!!!!");
						res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
					}
				}
				// 评价回复
				if (beanEntity.getMark() == 0) {
					int replyFlag = this.busManagerDao
							.delManageReply(beanEntity.getAdviceId());
					if (replyFlag > 0) {
						logger.info("删除回复评价成功!!!!!!!!!!!!");
						res = "{\"resultFlag\":\"true\",\"failureReason\":\"\"}";
					}
				}
			}
		}
		//返回结果
		return res;

	}
    //busManagerDao get set
	public IBusManagerDao getBusManagerDao() {
		return busManagerDao;
	}
	//busManagerDao get set
	public void setBusManagerDao(IBusManagerDao busManagerDao) {
		this.busManagerDao = busManagerDao;
	}

}
