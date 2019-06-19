package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcSurveyDetailsDao;
import com.deppon.dpm.module.management.server.service.IProcSurveyDetailsService;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyMsg;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyPhoto;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 工程勘测详情service接口实现
 * 
 */
public class ProcSurveyDetailsService implements IProcSurveyDetailsService {
	/**
	 * procSurveyDetailsDao接口
	 */
	private IProcSurveyDetailsDao procSurveyDetailsDao;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcSurveyDetailsService.class);

	/**
	 * @param partCode
	 *            勘测部位code
	 * @return 勘测详情数据
	 */
	public String getProcDeatils(String partCode, String checkId) {

		logger.info("工程勘测>>>>>>>>>>>>>ProcSurveyDetailsService 的 partCode"
				+ partCode);
		String res = "{\"resultFlag\":false,\"failureReason\":\"工程勘测得到详情数据有误！！\"}";
		// 声明一个map
		Map<String, Object> mapObj = new HashMap<String, Object>();
        //判断参数是否为Null
		if (!StringUtil.isEmpty(partCode)) {
			// 根据勘测部位code得到勘测基础数据
			List<ProcSurveyMsg> listMsg = this.procSurveyDetailsDao
					.getProcDeatils(partCode);
			// 判断是否有勘测数据
			if (null != listMsg && listMsg.size() > 0) {
				// 得到勘测详情总数
				int countDetail = this.procSurveyDetailsDao.countDetail();
				mapObj.put("countDetail", countDetail);
				// put数据
				mapObj.put("partCode", listMsg.get(0).getPartCode());
				mapObj.put("partName", listMsg.get(0).getPartName());
				// 得到勘测项目code
				List<String> strList = Arrays.asList(listMsg.get(0)
						.getArrayCode().split(","));
				//ProcSurveyMsg procSurveyMsg = null;
				// 得到勘测项目名称
				List<String> nameList = Arrays.asList(listMsg.get(0)
						.getArrayName().split(","));
				ProcSurveyMsg surveyMsg = null;
				List<ProcSurveyMsg> list = new ArrayList<ProcSurveyMsg>();
				// 得到已选择的勘测项id
				List<String> listMsgId = this.procSurveyDetailsDao.getListId(
						partCode, checkId);
				//Map<String, Object> mapData = new HashMap<String, Object>();
				ProcSurveyMsg procSurveyMsg2 = null;
				ProcSurveyMsg procSurveyMsg3 = null;
				// 对勘测项目进行循环组装
				for (int i = 0; i < strList.size(); i++) {
					//List<ProcSurveyMsg> listProcMsg = new ArrayList<ProcSurveyMsg>();
					surveyMsg = new ProcSurveyMsg();
					List<ProcSurveyMsg> list2 = new ArrayList<ProcSurveyMsg>();
					// 根据勘测项目code得到lineId集合
					List<ProcSurveyMsg> listMsgs = this.procSurveyDetailsDao
							.lineIdList(partCode, strList.get(i));
					//for 循环进行判断
					for (ProcSurveyMsg surveyMsg2 : listMsgs) {
						//声明一个list对象
						List<ProcSurveyMsg> listSurvey = new ArrayList<ProcSurveyMsg>();
						//for 循环进行判断
						for (ProcSurveyMsg msg : listMsg) {
							//判断值是否相等
							if (strList.get(i).equals(msg.getProCode())) {
								if (surveyMsg2.getLineId().equals(
										msg.getLineId())) {
									procSurveyMsg2 = new ProcSurveyMsg();
									//塞入数据
									procSurveyMsg2.setExplainCode(msg
											.getExplainCode());
									//塞入数据
									procSurveyMsg2.setExplainName(msg
											.getExplainName());
									//塞入数据
									procSurveyMsg2.setId(msg.getId());
									//塞入数据
									procSurveyMsg2.setOrderId(msg.getOrderId());
									procSurveyMsg2.setLineId(msg.getLineId());

									procSurveyMsg2
											.setIsSelect(listMsgId
													.contains(procSurveyMsg2
															.getId()) ? 1L : 0L);
									//塞入数据
									procSurveyMsg2.setLisMsgs(null);
									//list加入对象数据
									listSurvey.add(procSurveyMsg2);

								}

							}

						}
						procSurveyMsg3 = new ProcSurveyMsg();
						procSurveyMsg3.setLineId(surveyMsg2.getLineId());
						procSurveyMsg3.setLisMsgs(listSurvey);
						list2.add(procSurveyMsg3);

					}

					// mapData.put(strList.get(i), listProcMsg);
					surveyMsg.setLisMsgs(list2);
					surveyMsg.setIsSelect(null);
					surveyMsg.setProCode(strList.get(i));
					surveyMsg.setProName(nameList.get(i));
					list.add(surveyMsg);

					// mapData.put("ss", list2);

				}
				//塞入map数据
				mapObj.put("data", list);
				// 转json格式
				return JsonUtil.mapToJsonString(mapObj);

			}

		}
		return res;

	}

	/**
	 * @param id
	 *            工程勘测检查表id
	 * @param partCode
	 *            勘测部位code
	 * @return str
	 */
	public String getProcSelect(int id, String partCode) {

		/*
		 * SELECT a.check_id,a.msg_id,b.note,b.mark, c.part_code,c.part_name
		 * FROM proc_survey_submit a ,proc_survey_photo b,proc_survey_msg c
		 * WHERE a.check_id = b.check_id and a.msg_id = c.id;
		 */
		return partCode;

	}

	/**
	 * @param checkId
	 *            检查id
	 * @return 综合详细数据
	 */
	public String getPhotoDetail(String checkId) {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询数据有误！！\"}";
		//判断是否为null
		if (!StringUtil.isEmpty(checkId)) {
			//得到综合详细数据
			List<ProcSurveyPhoto> listPhoto = this.procSurveyDetailsDao
					.getPhotoDetail(checkId);
			//判断是否有数据
			if (null != listPhoto && listPhoto.size() > 0)
				//返回json格式数据
				return JsonUtil.beanToJsonString(listPhoto.get(0));
		}
		return res;

	}

	/**
	 * @return procSurveyDetailsDao
	 */
	public IProcSurveyDetailsDao getProcSurveyDetailsDao() {
		return procSurveyDetailsDao;
	}

	/**
	 * @param procSurveyDetailsDao
	 */
	public void setProcSurveyDetailsDao(
			IProcSurveyDetailsDao procSurveyDetailsDao) {
		this.procSurveyDetailsDao = procSurveyDetailsDao;
	}

}
