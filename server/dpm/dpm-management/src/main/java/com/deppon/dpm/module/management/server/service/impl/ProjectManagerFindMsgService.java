package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProjectManagerFindMsgDao;
import com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService;
import com.deppon.dpm.module.management.shared.domain.AttachmentEntity;
import com.deppon.dpm.module.management.shared.domain.BaseProjectInfo;
import com.deppon.dpm.module.management.shared.domain.BaseQualityPollingEntity;
import com.deppon.dpm.module.management.shared.domain.FUser;
import com.deppon.dpm.module.management.shared.domain.MaintenRequestEntity;
import com.deppon.dpm.module.management.shared.domain.MaintenRequestEntryEntity;
import com.deppon.dpm.module.management.shared.domain.MareaEntity;
import com.deppon.dpm.module.management.shared.domain.MtypeEntity;
import com.deppon.dpm.module.management.shared.domain.ProIocBeanEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCountEntity;
import com.deppon.dpm.module.management.shared.domain.ProcHistorySubmitEntity;
import com.deppon.dpm.module.management.shared.domain.ProjectManagerFindMsgEntity;
import com.deppon.dpm.module.management.shared.domain.QualitypollingEntity;
import com.deppon.dpm.module.management.shared.domain.QualitypollingentryEntity;
import com.deppon.dpm.module.management.shared.domain.RepairMatterEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * <p>
 * ClassName: ProjectManagerFindMsgService.
 * </p>
 * <p>
 * Description:获取界面参数
 * </p>
 * <p>
 * Author: xieyidong
 * </p>
 * <p>
 * Date: 2015-7-14
 * </p>
 */
@SuppressWarnings("static-access")
public class ProjectManagerFindMsgService implements
		IProjectManagerFindMsgService{

	/**
	 * <p>
	 * 
	 * Field cacheMap:接口缓存
	 * </p>
	 */
	public static Map<String, List<BaseQualityPollingEntity>> cacheMap = new HashMap<String, List<BaseQualityPollingEntity>>();
	/**
	 * iocInfo
	 */
	//public static List<ProIocBeanEntity> iocInfo = new ArrayList<ProIocBeanEntity>();
	public List<ProIocBeanEntity> iocInfo = new ArrayList<ProIocBeanEntity>();
	public static List<ProjectManagerFindMsgEntity> areaList = new ArrayList<ProjectManagerFindMsgEntity>();
	/**
	 * projectManagerFindMsgDao 注入
	 */
	public IProjectManagerFindMsgDao projectManagerFindMsgDao;

	/**
	 * @param projectManagerFindMsgDao 注入
	 */
	public void setProjectManagerFindMsgDao(
			IProjectManagerFindMsgDao projectManagerFindMsgDao) {
		this.projectManagerFindMsgDao = projectManagerFindMsgDao;
	}

	/**
	 * ESB查询请求Url
	 */
	public String proManagerUrl;

	/**
	 * @param proManagerUrl ESB查询请求Url
	 */
	public void setProManagerUrl(String proManagerUrl) {
		this.proManagerUrl = proManagerUrl;
	}

	/**
	 * 日志
	 */
	private Logger log = LoggerFactory
			.getLogger(ProjectManagerFindMsgService.class);

	/*
	 * <p>Description:获取界面参数</p>
	 * 
	 * @param str
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #getProjectMsg(java.lang.String)
	 */
	@Override
	public String getProjectMsg(String str) throws BusinessException, IOException {
		
		// 历史总分数
		int totalScore = 0;
		// 历史0分个数
		int zeroScore = 0;
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\"}";
		log.info("proManagerUrl:" + proManagerUrl);
        //json转换
		JSONObject json = new JSONObject().parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// fcheckAreaCode区域栏code（功能栏）
		String fcheckAreaCode = json.getString("fcheckAreaCode").trim();
		// 门店地址
		String proAdress = json.getString("proAdress").trim();
		// 用户工号
		String userNo = json.getString("userNo").trim();

		log.info("areaName:" + fcheckAreaCode);
		log.info("proAdress:" + proAdress);
		log.info("userNo:" + userNo);
        //判断参数是否为null
		if (proAdress == null || "".equals(proAdress) || userNo == null
				|| "".equals(userNo)) {
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为Null！\"}";
		}

		/*// 判断缓存是否存在
		if (cacheMap.isEmpty()) {
			getParserInfo();
		}*/
		getParserInfo();
		// 获取功能栏（检测区域）key
		Set<String> keys = cacheMap.keySet();
		if (keys == null || keys.size() <= 0) {
			log.info("<<<<<<<<<<<<<<从缓存中获取检查区域失败！<<<<<<<<<<<<<<<<<");
			return "{\"resultFlag\":false,\"failureReason\":\"从缓存中获取检查区域失败！\"}";
		}
		/*// 获取功能栏（检查区域）实体
		if (areaList == null || areaList.size() <= 0) {
			for (String key : keys) {
				ProjectManagerFindMsgEntity proMan = new ProjectManagerFindMsgEntity();
				List<BaseQualityPollingEntity> cacheList = cacheMap.get(key);
				BaseQualityPollingEntity bean = cacheList.get(0);
				String araeName = bean.getFcheckArea();
				proMan.setAreaId(key);
				proMan.setFcheckArea(araeName);
				areaList.add(proMan);
			}
		}*/
		// 获取功能栏（检查区域）实体
		setAreaListInfo(keys);
		
		// 第一次访问
		// 获取默认的key
		if (fcheckAreaCode != null && "".equals(fcheckAreaCode)) {
			for (String key : keys) {
				fcheckAreaCode = key;
				break;
			}
		}
		
		List<BaseQualityPollingEntity> fcheckProjects = null;
		//判断
		if (cacheMap.containsKey(fcheckAreaCode)) {
			
			// 获取需要传到页面的数据fcheckProject值和图片匹配
			fcheckProjects = getFcheckProjects(fcheckAreaCode);
			
			// 返回给前端维修事项
			Map<String, List<BaseQualityPollingEntity>> gradeMap = getGradeMap(fcheckProjects);
			
			// 取缓存值放到resultNew
			List<BaseQualityPollingEntity> resultNew = setResultList(fcheckProjects);
			
			// 设置历史评分记录
			List<BaseQualityPollingEntity> resultHis = setHistoryInfo(resultNew,fcheckAreaCode, proAdress, userNo);
			
			// 设置每一项的检查记录统计
			List<BaseQualityPollingEntity> resultList = setProcCountInfo(fcheckAreaCode,resultHis);

			// 获取总分数
			totalScore = getScore(proAdress, userNo);
			// 0分个数
			zeroScore = getzeroScore(proAdress, userNo);
			log.info("totalScore:" + totalScore);
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("areaList", areaList);// 检查栏
			result.put("projects", resultList);// 检查项
			result.put("totalScore", totalScore);// 统计总门店分数
			result.put("zeroScore", zeroScore);// 统计0分项
			result.put("matterList", gradeMap);// 检查项Id对应维修项值

			res = "{\"proInformationList\":";
			res += JsonUtil.mapToJsonString(result);
			res += "}";
			log.info("res=" + res);
			return res;
		} else {
			return "{\"resultFlag\":false,\"failureReason\":\"检测区域栏没有数据\"}";
		}

	}

	/**
	 * @param fcheckAreaCode 参数
	 * @param resultHis 参数
	 * @return
	 * @throws BusinessException 抛出异常
	 */
	private List<BaseQualityPollingEntity> setProcCountInfo (
			String fcheckAreaCode, List<BaseQualityPollingEntity> resultHis) throws BusinessException{
		// 统计量的匹配
					Map<String, Object> countPro = getProcCount(fcheckAreaCode);
					//判断参数是否为null
					if (countPro != null && !countPro.isEmpty()) {
						int countStore = (Integer) countPro.get("countStore");
						@SuppressWarnings("unchecked")
						List<ProcCountEntity> listCount = (List<ProcCountEntity>) countPro
								.get("listCount");
						if (countStore > 0) {
							log.info("countStore:" + countStore);
							for (BaseQualityPollingEntity bean : resultHis) {
								//抽取方法
								setBeanValue(countStore, listCount, bean);
							}
						}
					}
		return resultHis;
	}

	public void setBeanValue(int countStore, List<ProcCountEntity> listCount,
			BaseQualityPollingEntity bean) {
		// 检查项id
		String priId = bean.getProId().trim();
		log.info(priId);
		if (listCount != null && listCount.size() > 0) {
			for (ProcCountEntity count : listCount) {
				log.info("每一个检查项的数据:" + count.toString());
				if (priId != null && !"".equals(priId)
						&& priId.equals(count.getScopeId())) {
					// 0分数
					bean.setZeroCount(count.getCountScopeId());

					break;
				}
			}
		}
		// 设置总分
		bean.setCountStore(countStore);
	}

	
	private List<BaseQualityPollingEntity> setHistoryInfo(
			List<BaseQualityPollingEntity> resultNew, String fcheckAreaCode,
			String proAdress, String userNo) throws BusinessException{
		// 获取历史评分记录
		List<BaseQualityPollingEntity> historyInfo = getHistoryInfo(fcheckAreaCode, proAdress, userNo);
		// 存在历史记录
		if (historyInfo != null && historyInfo.size() > 0) {
			for (BaseQualityPollingEntity cacheBean : resultNew) {
				// 获取map检查项目(打分项id)
				//int hisTab = 0;
				String cacheId = cacheBean.getProId().trim();
				for (BaseQualityPollingEntity hisBean : historyInfo) {
					String proId = hisBean.getProId().trim();
					// 和历史记录比较
					if (cacheId != null && cacheId.equals(proId)) {
						cacheBean.setHisFscore(hisBean.getHisFscore());
						cacheBean.setFscoreId(hisBean.getFscoreId());
						//hisTab = 1;
						break;
					}

				}
				// 没有分数设置101
				/*if (hisTab == 0) {
					cacheBean.setHisFscore(-100d);
				}*/
			}
		} /*else {
			for (BaseQualityPollingEntity cacheBean : resultList) {
				cacheBean.setHisFscore(-100d);
			}

		}*/
		return resultNew;
	}

	/**
	 * 取缓存值放到resultList
	 * @param fcheckProjects
	 * @return
	 */
	private List<BaseQualityPollingEntity> setResultList(
			List<BaseQualityPollingEntity> fcheckProjects) {
		List<BaseQualityPollingEntity> resultList = new ArrayList<BaseQualityPollingEntity>();
		for (BaseQualityPollingEntity resBean : fcheckProjects) {
			// BeanUtils.copyProperties(bean,resBean);Apache方法，把后面一个复制给前面的。
			// BeanUtils.copyProperties(resBean, bean);德邦方法，把前面一个的内容复制给后面一个
			BaseQualityPollingEntity bean = copyBean(resBean);
			resultList.add(bean);
		}
		return resultList;
	}

	/**
	 * 返回给前端维修事项
	 * @param fcheckProjects
	 * @return
	 * @throws BusinessException
	 */
	private Map<String, List<BaseQualityPollingEntity>> getGradeMap(
			List<BaseQualityPollingEntity> fcheckProjects) throws BusinessException{
		Map<String, List<BaseQualityPollingEntity>> gradeMap = new HashMap<String, List<BaseQualityPollingEntity>>();
		for (BaseQualityPollingEntity bean : fcheckProjects) {
			String id = bean.getProId().trim();
			String matter = bean.getFrepairMatter();
			if (!"".equals(id) && gradeMap.containsKey(id)) {
				BaseQualityPollingEntity oldBean = new BaseQualityPollingEntity();
				List<BaseQualityPollingEntity> matList = gradeMap.get(id);
				oldBean.setFrepairMatterCode(bean.getFrepairMatterCode());
				oldBean.setFrepairMatter(matter);
				oldBean.setProId(id);
				matList.add(oldBean);
			} else {
				List<BaseQualityPollingEntity> list = new ArrayList<BaseQualityPollingEntity>();
				BaseQualityPollingEntity newBean = new BaseQualityPollingEntity();
				newBean.setFrepairMatterCode(bean.getFrepairMatterCode());
				newBean.setFrepairMatter(matter);
				newBean.setProId(id);
				list.add(newBean);
				gradeMap.put(id, list);
			}
		}

		return gradeMap;
	}

	/** 获取需要传到页面的数据fcheckProject值
	 * @param fcheckAreaCode
	 * @return
	 */
	private synchronized List<BaseQualityPollingEntity> getFcheckProjects (
			String fcheckAreaCode) throws BusinessException{
		List<BaseQualityPollingEntity> fcheckProjects = cacheMap.get(fcheckAreaCode);

		/*// 获取图片和打分项的关系
		if (iocInfo == null || iocInfo.size() <= 0) {
			iocInfo = projectManagerFindMsgDao.getIocInfo();
		}
       */
		iocInfo = projectManagerFindMsgDao.getIocInfo();
		// 打分项和图片地址匹配
		String proName = "";
		if (iocInfo != null && iocInfo.size() > 0) {
			for (BaseQualityPollingEntity iocBean : fcheckProjects) {
				proName = iocBean.getFcheckProjectCode().trim();
				for (ProIocBeanEntity ioc : iocInfo) {
					String iocName = ioc.getName().trim();
					if (!"".equals(proName) && proName.equals(iocName)) {
						iocBean.setIocUrl(ioc.getCord());
						break;
					}
				}
			}
		}
		return fcheckProjects;
	}

	/**
	 * 获取功能栏（检查区域）实体
	 * @param keys
	 */
	private void setAreaListInfo(Set<String> keys) {
		for (String key : keys) {
			ProjectManagerFindMsgEntity proMan = new ProjectManagerFindMsgEntity();
			List<BaseQualityPollingEntity> cacheList = cacheMap.get(key);
			BaseQualityPollingEntity bean = cacheList.get(0);
			String araeName = bean.getFcheckArea();
			proMan.setAreaId(key);
			proMan.setFcheckArea(araeName);
			areaList.add(proMan);
		}
		
	}

	/**
	 * <p>
	 * Description:实体类的复制
	 * </p>
	 * 
	 * @param resBean
	 * @return
	 */
	private BaseQualityPollingEntity copyBean(BaseQualityPollingEntity resBean) {
		BaseQualityPollingEntity bean = new BaseQualityPollingEntity();
		bean.setAreaId(resBean.getAreaId());
		bean.setProId(resBean.getProId());
		bean.setFid(resBean.getFid());
		bean.setFnumber(resBean.getFnumber());
		bean.setFsimplename(resBean.getFsimplename());
		bean.setFcreator(resBean.getFcreator());
		bean.setFcreateTime(resBean.getFcreateTime());
		bean.setFlastupdateuserid(resBean.getFlastupdateuserid());
		bean.setFcheckArea(resBean.getFcheckArea());
		bean.setFcheckProject(resBean.getFcheckProject());
		bean.setFrepairMatter(resBean.getFrepairMatter());
		bean.setFscoreStandard(resBean.getFscoreStandard());
		bean.setFscore(resBean.getFscore());
		bean.setHisFscore(resBean.getHisFscore());
		bean.setArrList(resBean.getArrList());
		bean.setIocUrl(resBean.getIocUrl());
		bean.setCountStore(resBean.getCountStore());
		bean.setZeroCount(resBean.getZeroCount());
		bean.setFcheckAreaId(resBean.getFcheckAreaId());
		bean.setFcheckAreaCode(resBean.getFcheckAreaCode());
		bean.setFcheckProjectId(resBean.getFcheckProjectId());
		bean.setFcheckProjectCode(resBean.getFcheckProjectCode());
		bean.setFrepairMatterId(resBean.getFrepairMatterId());
		bean.setFrepairMatterCode(resBean.getFrepairMatterCode());

		return bean;
	}

	/**
	 * <p>
	 * Description:获取检查区域0分项
	 * </p>
	 * 
	 * @param proAdress
	 * @param userNo
	 * @return
	 */
	private int getzeroScore(String proAdress, String userNo) throws BusinessException {
		// 获取门店地址的0分项
		ProjectManagerFindMsgEntity msgBean = new ProjectManagerFindMsgEntity();

		log.info("getScore_proAdress:" + proAdress);
		log.info("getScore_userNo:" + userNo);
		msgBean.setProAdress(proAdress);
		msgBean.setUserNo(userNo);
		int zeroScore = projectManagerFindMsgDao.getAdrZeroScore(msgBean);
		if (zeroScore > 0) {
			return zeroScore;
		}
		return 0;
	}

	/**
	 * <p>
	 * Description：获取历史总分数
	 * </p>
	 * 
	 * @param proAdress
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	private int getScore(String proAdress, String userNo) throws BusinessException {
		ProjectManagerFindMsgEntity msgBean = new ProjectManagerFindMsgEntity();
		log.info("getScore_proAdress:" + proAdress);
		log.info("getScore_userNo:" + userNo);
		msgBean.setProAdress(proAdress);
		msgBean.setUserNo(userNo);
		int count = 0;
		try {
			log.info("++++++++");
			count = projectManagerFindMsgDao.getTotalScore(msgBean);
			log.info("总分数》》》》》》" + count);
		} catch (BusinessException e) {
			// e.printStackTrace();
			log.info("没有查到总分数时抛null指针异常：" + e);
		}

		if (count >= 0) {
			return count;
		}
		return count;
	}

	/**
	 * <p>
	 * Description: 获取历史评分记录
	 * </p>
	 * 
	 * @param areaName
	 * @param proAdress
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	private List<BaseQualityPollingEntity> getHistoryInfo(
			String fcheckAreaCode, String proAdress, String userNo)
			throws BusinessException {
		ProjectManagerFindMsgEntity msgBean = new ProjectManagerFindMsgEntity();

		msgBean.setAreaId(fcheckAreaCode);
		msgBean.setProAdress(proAdress);
		msgBean.setUserNo(userNo);
		return projectManagerFindMsgDao.getHistoryInfo(msgBean);

	}

	/*
	 * <p>Description:获取pc端传来的数据</p>
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #getParserInfo()
	 */
	public String getParserInfo() throws BusinessException, IOException {
		// proManagerUrl="http://10.224.64.54:8089/lsp/webservice/baseProjectService/queryBaseData";
		log.info("proManagerUrl:" + proManagerUrl);
		log.info("PC联调开始");
		// String result =
		// "{'items':{'list':[{'fid':'TYfQDfn/Q/6oYGVEhB8mH9+Y0k0=','fnumber':'Q000001','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 09:35:53','fsimplename':null,'flastupdateTime':'2015-07-28 16:33:25','fcreator':'孙伟','frepairMatter':'指示牌','fcheckArea':'其他区域','fcheckProject':'招牌指示','fscoreStandard':'1、存在色差;\n2、存在破损;\n3、褶皱(整改措施：换背喷);\n','fscore':5.0,'fcheckAreaId':'b1HGQ6idRN6XZNaADkLRy+IOMtc=','fcheckAreaCode':'WXQY0007','fcheckProjectId':'WseqlcCtTmypP3R1fKcGquIW8YQ=','fcheckProjectCode':'WXLB0004','frepairMatterId':'0pcRYlb2N1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00402','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'BnD9eahkRdCk60UlEc5EUt+Y0k0=','fnumber':'Q000002','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:22:03','fsimplename':null,'flastupdateTime':'2015-07-28 16:22:03','fcreator':'孙伟','frepairMatter':'地锁类','fcheckArea':'仓库','fcheckProject':'卷闸门','fscoreStandard':'地锁损坏','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'NDoUhycwTcm+A31/yBwLAeIW8YQ=','fcheckProjectCode':'WXLB0001','frepairMatterId':'0pcRYlbpN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00102','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'DrojQffCQEiHmgeG9TYRG9+Y0k0=','fnumber':'Q000003','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:23:38','fsimplename':null,'flastupdateTime':'2015-07-28 16:23:38','fcreator':'孙伟','frepairMatter':'地面','fcheckArea':'仓库','fcheckProject':'地面','fscoreStandard':'1、地面起灰面积超过仓库面积三分之一；\n2、地砖破损面积超过仓库面积三分之一;\n','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'0UatVWN+Sm29j9h/DV9b8eIW8YQ=','fcheckProjectCode':'WXLB0008','frepairMatterId':'0pcRYlcIN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00803','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'gIVV+u1OSgKlfobFTyEp89+Y0k0=','fnumber':'Q000004','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:25:02','fsimplename':null,'flastupdateTime':'2015-07-28 16:25:02','fcreator':'孙伟','frepairMatter':'墙面批涂','fcheckArea':'仓库','fcheckProject':'墙面','fscoreStandard':'1、墙面破损直径＞1m；\n2、墙面出现水渍;\n3、墙面霉斑等污染直径>1m；\n4、仓库防撞条脱落；\n5、仓库防撞条缺失;\n','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'0zwqQcscQ0SUUGoqicz64eIW8YQ=','fcheckProjectCode':'WXLB0007','frepairMatterId':'0pcRYlcDN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00701','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'OcI7ZPaeSCW+gKahtDtZJN+Y0k0=','fnumber':'Q000005','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:28:14','fsimplename':null,'flastupdateTime':'2015-07-28 16:28:14','fcreator':'孙伟','frepairMatter':'卷闸门其他','fcheckArea':'仓库','fcheckProject':'卷闸门','fscoreStandard':'门帘受损','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'NDoUhycwTcm+A31/yBwLAeIW8YQ=','fcheckProjectCode':'WXLB0001','frepairMatterId':'0pcRYlbrN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00104','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'SyLp+V98Q56vFiuqjz4Mzt+Y0k0=','fnumber':'Q000006','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:29:25','fsimplename':null,'flastupdateTime':'2015-07-28 16:29:25','fcreator':'孙伟','frepairMatter':'日光灯','fcheckArea':'仓库','fcheckProject':'灯具','fscoreStandard':'闪烁；\n不亮；','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'NPjERKPhSm6WPsj4gEapmOIW8YQ=','fcheckProjectCode':'WXLB0003','frepairMatterId':'0pcRYlbzN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00304','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'BHJoMgYiTCq+NZHVWEnzP9+Y0k0=','fnumber':'Q000007','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:29:56','fsimplename':null,'flastupdateTime':'2015-07-28 16:29:56','fcreator':'孙伟','frepairMatter':'其他灯具','fcheckArea':'仓库','fcheckProject':'灯具','fscoreStandard':'脱落;\n规格不符；','fscore':2.0,'fcheckAreaId':'8Sckkqc5Q0upPX2Y6zL4teIOMtc=','fcheckAreaCode':'WXQY0002','fcheckProjectId':'NPjERKPhSm6WPsj4gEapmOIW8YQ=','fcheckProjectCode':'WXLB0003','frepairMatterId':'0pcRYlb0N1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00305','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'DqsNfZhLQweK0S/VTSbrMN+Y0k0=','fnumber':'Q000008','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:31:58','fsimplename':null,'flastupdateTime':'2015-07-28 16:33:15','fcreator':'孙伟','frepairMatter':'招牌','fcheckArea':'其他区域','fcheckProject':'招牌指示','fscoreStandard':'倾斜；\n闪烁或不亮；\n','fscore':5.0,'fcheckAreaId':'b1HGQ6idRN6XZNaADkLRy+IOMtc=','fcheckAreaCode':'WXQY0007','fcheckProjectId':'WseqlcCtTmypP3R1fKcGquIW8YQ=','fcheckProjectCode':'WXLB0004','frepairMatterId':'0pcRYlb1N1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00401','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'PVe+o6sGRf6KlNTvLbpMGd+Y0k0=','fnumber':'Q000009','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:32:53','fsimplename':null,'flastupdateTime':'2015-07-28 16:32:53','fcreator':'孙伟','frepairMatter':'看板','fcheckArea':'其他区域','fcheckProject':'招牌指示','fscoreStandard':'字体破损；\n存在色差；\n','fscore':5.0,'fcheckAreaId':'b1HGQ6idRN6XZNaADkLRy+IOMtc=','fcheckAreaCode':'WXQY0007','fcheckProjectId':'WseqlcCtTmypP3R1fKcGquIW8YQ=','fcheckProjectCode':'WXLB0004','frepairMatterId':'0pcRYlb3N1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00403','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'dXKxr4EzTXSbzBsa/mAv2d+Y0k0=','fnumber':'Q000010','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:34:44','fsimplename':null,'flastupdateTime':'2015-07-28 16:34:44','fcreator':'孙伟','frepairMatter':'地面','fcheckArea':'营业厅','fcheckProject':'地面','fscoreStandard':'色差；\n脱釉；','fscore':3.0,'fcheckAreaId':'ijCi3tX9Q2a8Aq1s8h6UA+IOMtc=','fcheckAreaCode':'WXQY0001','fcheckProjectId':'0UatVWN+Sm29j9h/DV9b8eIW8YQ=','fcheckProjectCode':'WXLB0008','frepairMatterId':'0pcRYlcIN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00803','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'aXsCiRGOTtiRrleE9FDW6d+Y0k0=','fnumber':'Q000011','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:35:07','fsimplename':null,'flastupdateTime':'2015-07-28 16:35:07','fcreator':'孙伟','frepairMatter':'地砖','fcheckArea':'营业厅','fcheckProject':'地面','fscoreStandard':'破损（一块以上）；\n裂缝（二块以上）；','fscore':3.0,'fcheckAreaId':'ijCi3tX9Q2a8Aq1s8h6UA+IOMtc=','fcheckAreaCode':'WXQY0001','fcheckProjectId':'0UatVWN+Sm29j9h/DV9b8eIW8YQ=','fcheckProjectCode':'WXLB0008','frepairMatterId':'0pcRYlcGN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00801','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'0tBm/68iT4y+c8FXhtCsot+Y0k0=','fnumber':'Q000012','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:35:38','fsimplename':null,'flastupdateTime':'2015-07-28 16:35:38','fcreator':'孙伟','frepairMatter':'墙面批涂','fcheckArea':'营业厅','fcheckProject':'墙面','fscoreStandard':'存在色差；\n墙面起皮；','fscore':3.0,'fcheckAreaId':'ijCi3tX9Q2a8Aq1s8h6UA+IOMtc=','fcheckAreaCode':'WXQY0001','fcheckProjectId':'0zwqQcscQ0SUUGoqicz64eIW8YQ=','fcheckProjectCode':'WXLB0007','frepairMatterId':'0pcRYlcDN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00701','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null},{'fid':'DT2TCaCpQXGiENYe4vYYt9+Y0k0=','fnumber':'Q000013','flastupdateuserid':'Wx1ZSeWdQweaN5bv+ljTyBO33n8=','fcreateTime':'2015-07-28 16:35:57','fsimplename':null,'flastupdateTime':'2015-07-28 16:35:57','fcreator':'孙伟','frepairMatter':'玻璃','fcheckArea':'营业厅','fcheckProject':'墙面','fscoreStandard':'脱落；\n霉斑；\n水渍；','fscore':3.0,'fcheckAreaId':'ijCi3tX9Q2a8Aq1s8h6UA+IOMtc=','fcheckAreaCode':'WXQY0001','fcheckProjectId':'0zwqQcscQ0SUUGoqicz64eIW8YQ=','fcheckProjectCode':'WXLB0007','frepairMatterId':'0pcRYlcEN1PgQwEAAH8KPc08b3c=','frepairMatterCode':'WXSX00702','id':null,'createUser':null,'createDate':null,'modifyDate':null,'modifyUser':null}]}}";
		String result = requestClient("quality", proManagerUrl
				+ "/queryBaseData", "ESB_APP2ESB_PROJECT_POLLING");

		if (result != null && !"".equals(result)) {
			log.info("result:" + result);
			JSONObject json = new JSONObject().parseObject(result);
			String items = json.getString("items");
			log.info("items:" + items);
			JSONObject json2 = new JSONObject().parseObject(items);
			String listStr = json2.getString("list");
			log.info("listStr:" + listStr);
			// 客户端的数据转化为list
			List<BaseQualityPollingEntity> list = JsonUtil.jsonToList(listStr,
					BaseQualityPollingEntity.class);
			log.info("list的转化值:" + list.get(0).toString());
			// 信息分类
			parseListToMap(list);
			// 打印map
			Set<String> keys = cacheMap.keySet();
			for (String key : keys) {
				List<BaseQualityPollingEntity> priList = cacheMap.get(key);
				for (BaseQualityPollingEntity priBean : priList) {
					log.info("日志key:" + key + ":" + priBean.toString());
				}

			}

			log.info("信息解析成功");
			return "successful";
		}
		return "failure";
	}

	/**
	 * <p>
	 * Description: 把pc端的数据放入缓存中
	 * </p>
	 * 
	 * @param list
	 * @throws BusinessException
	 */
	private synchronized void parseListToMap(List<BaseQualityPollingEntity> list)
			throws BusinessException {
		cacheMap.clear();
		areaList.clear();
		
		for (BaseQualityPollingEntity bean : list) {
			// 评分标准(界面的扣分项目)
			String standard = bean.getFscoreStandard();
			if (standard != null && !"".equals(standard)
					&& standard.contains("\n")) {
				String standards = standard.replaceAll("\n", "");
				bean.setFscoreStandard(standards);
			}
			
			bean.setHisFscore(Constants.PROC_MANAGER_SOCER);
			String fcheckAreaCode = bean.getFcheckAreaCode();
			if (fcheckAreaCode != null) {
				if (cacheMap.containsKey(fcheckAreaCode)) {
					// 存在key
					List<BaseQualityPollingEntity> oldList = cacheMap
							.get(fcheckAreaCode);
					log.info("获取原来的List：" + oldList);
					bean.setAreaId(bean.getFcheckAreaCode());
					bean.setProId(bean.getFcheckProjectCode());

					oldList.add(bean);
					cacheMap.put(fcheckAreaCode, oldList);
				} else {
					// 不存在key
					log.info("新建list");
					List<BaseQualityPollingEntity> newList = new ArrayList<BaseQualityPollingEntity>();

					bean.setAreaId(bean.getFcheckAreaCode());
					bean.setProId(bean.getFcheckProjectCode());
					newList.add(bean);
					cacheMap.put(fcheckAreaCode, newList);

				}

			}
		}
	}

	/**
	 * <p>
	 * Description:获取Http的客户端
	 * </p>
	 * 
	 * @param param
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 */
	public String requestToPcClient(Map<String, Object> param, String url,
			String esbServiceCode) throws BusinessException, IOException {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(Constants.HTTP_CON_TIMEOUT);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(Constants.HTTP_SO_TIMEOUT);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(),Constants.HTTP_PROTOCOL);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");

		// 参数设置
		String paramJson = JsonUtil.mapToJsonString(param);
		String headerJson = JsonUtil.mapToJsonString(map);

		RequestEntity entity = new StringRequestEntity(paramJson,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);

		log.info("post url ==========>" + url);
		log.info("post paramter ==========>" + param);
		log.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);

		String result = post.getResponseBodyAsString();
		log.info(esbServiceCode + " response data : " + result);

		return result;
	}

	/*
	 * <p>Description:单独获取历史评分项</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #getSigHistoryInfo(java.lang.String)
	 */
	@Override
	public String getSigHistoryInfo(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\"}";
		log.info("proManagerUrl2:" + proManagerUrl);
		JSONObject json = new JSONObject().parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// areaName区域栏名字（功能栏）
		String areaName = json.getString("areaName").trim();
		// 门店地址
		String proAdress = json.getString("proAdress").trim();
		// 用户工号
		String userNo = json.getString("userNo").trim();

		log.info("areaName:" + areaName);
		log.info("proAdress:" + proAdress);
		log.info("userNo:" + userNo);

		if (areaName == null || "".equals(areaName) || proAdress == null
				|| "".equals(proAdress) || userNo == null || "".equals(userNo)) {
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为Null！\"}";
		}

		List<BaseQualityPollingEntity> hisList = getHistoryInfo(areaName,
				proAdress, userNo);
		res = "{\"proInformationList\":";
		res += JsonUtil.listToJsonString(hisList);
		res += "}";
		log.info("res=" + res);

		return res;
	}

	/**
	 * <p>
	 * Description: 计算工程巡检门店数据
	 * </p>
	 * 
	 * @param mark
	 *            标志位
	 * @return 工程数据
	 * @throws BusinessException
	 *             抛出异常
	 */
	public Map<String, Object> getProcCount(String fcheckAreaCode)
			throws BusinessException {
		String mark = fcheckAreaCode;

		log.info("进入计算工程巡检门店数据service参数为<<<<<<<<<<<<<<<<<<" + mark);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(mark)) {
			// 获得门店总数
			int countStore = projectManagerFindMsgDao.getCountStore();

			if (countStore > 0) {
				List<ProcCountEntity> listCount = projectManagerFindMsgDao
						.getProcCount(mark);
				/*
				 * if (listCount.size() > 0) { countEntities = new
				 * ArrayList<ProcCountEntity>(); for (ProcCountEntity
				 * procCountEntity : listCount) {
				 * procCountEntity.setCountStore(countStore);
				 * countEntities.add(procCountEntity); } //res =
				 * JsonUtil.beanToJsonString(countEntities);
				 * log.info("工程巡检统计转换成countEntities之后的数据为<<<<<<<<<<<<<<<<<<<"
				 * +countEntities); }
				 */
				log.info("工程巡检门店总数为<<<<<<<<<<<<<<<<<<<" + countStore);
				log.info("工程巡检门店0分数为<<<<<<<<<<<<<<<<<<<" + listCount);
				resultMap.put("countStore", countStore);
				resultMap.put("listCount", listCount);
			} else {
				resultMap.put("countStore", 0);
				resultMap.put("listCount", null);
			}

		}
		return resultMap;

	}

	/*
	 * <p>移动端所有信息的提交方法————保存数据到PC端 Title: setToPcRecord</p>
	 * <p>Description:保存数据到PC端</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #setToPcRecord(java.lang.String)
	 */
	@Override
	public String setToPcRecord(String str) throws BusinessException, IOException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询失败\",\"isSubmit\":\"unsuccessful\"}";
		String result = "";
		List<BaseProjectInfo> baseList = null;
		// 解析前台传过来的数据
		JSONObject json = new JSONObject().parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// 门店的标杆编码
		String deptCode = json.getString("deptCode").trim();
		// 门店地址
		String proAdress = json.getString("proAdress").trim();
		// 定位地址
		String streetAddress = getStreetAddress(json);
		// 用户工号
		String userNo = json.getString("userNo").trim();
		// 项目编码
		String proNumber = getProNumber(json);
		// 备注
		String mark = getMark(json);
		log.info(mark);
		log.info(proAdress);
		log.info(userNo);
		log.info(proNumber);
		if(checkNull(deptCode, proAdress, userNo,result)!=null){
			return result;
		}
		// proNumber为null是首次提交 不等于NUll客户选择编号后提交
		if (proNumber == null || "".equals(proNumber)) {
			// 访问PC端获取项目编码
			List<BaseProjectInfo> tempList = getBaseProjectInfo(deptCode);
			if (tempList == null || tempList.size() <= 0) {
				return "{\"resultFlag\":false,\"failureReason\":\"项目编码为空，获取项目编码失败\",\"isSubmit\":\"unsuccessful\"}";
			}
			// 只有一条数据不提示客户选择
			if (tempList.size() == 1) {
				baseList = tempList;
			}
			// 有多条数据给可选择返回给前端
			if (tempList.size() > 1) {
				res = JsonUtil.beanToJsonString(tempList);
				return "{\"resultFlag\":false,\"failureReason\":\"出现多个项目编码，请选择一个后提交\",\"isSubmit\":\"resubmit\",\"parameter\":"
						+ res + "}";
			}

		} else {
			String parameter = json.getString("parameter");
			log.info("parameter:" + parameter);
			// 客户端的数据转化为list
			baseList = JsonUtil.jsonToList(parameter, BaseProjectInfo.class);
		}

		if (baseList == null || baseList.size() != 1) {
			return "{\"resultFlag\":false,\"failureReason\":\"项目编码List不等于1，请选择一个后提交\",\"isSubmit\":\"unsuccessful\"}";
		}
		// 获取所有的评分信息和0分原因
		ProjectManagerFindMsgEntity paraBean = new ProjectManagerFindMsgEntity();
		paraBean.setUserNo(userNo);
		paraBean.setProAdress(proAdress);
		List<ProjectManagerFindMsgEntity> hisRecord = projectManagerFindMsgDao
				.getHisScoreOrZero(paraBean);
		
		//对历史记录去重复
		hisRecord = filterRepeat(hisRecord);
		
		if (hisRecord == null || hisRecord.size() <= 0) {
			log.info("<<<<<<<<<<<<<获取检查项的分数等信息失败<<<<<<<<<");
			return "{\"resultFlag\":false,\"failureReason\":\"获取检查项的分数等信息失败\",\"isSubmit\":\"unsuccessful\"}";
		}
		List<ProjectManagerFindMsgEntity> empList = projectManagerFindMsgDao
				.getEmpInfo(userNo);
		log.info("返回员工信息empList" + empList);
		//提交两个表单
		res = submitPollingAndMaintain(streetAddress, mark, proAdress,
				userNo, baseList, hisRecord, empList);
		
        return res;
	}

	private String getStreetAddress(JSONObject json) {
		return json.getString("streetAddress") == null ? ""
				: json.getString("streetAddress").trim();
	}

	private String getProNumber(JSONObject json) {
		return json.getString("proNumber") == null ? "" : json
				.getString("proNumber").trim();
	}

	private String getMark(JSONObject json) {
		return json.getString("mark") == null ? "" : json.getString(
				"mark").trim();
	}

	private String checkNull(String deptCode, String proAdress, String userNo, String result) {
		if(deptCode == null || "".equals(deptCode)){
			result =  "{\"resultFlag\":false,\"failureReason\":\"传入的标杆编码(deptCode)为空\",\"isSubmit\":\"unsuccessful\"}";
		}
		if (proAdress == null || "".equals(proAdress) || userNo == null
				|| "".equals(userNo)) {
			result =  "{\"resultFlag\":false,\"failureReason\":\"传入的参数为NULL\",\"isSubmit\":\"unsuccessful\"}";
		}
		return result;
	}

	/**提交两个表单
	 * @param streetAddress
	 * @param mark
	 * @param proAdress
	 * @param userNo
	 * @param baseList
	 * @param hisRecord
	 * @param empList
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 */
	private String submitPollingAndMaintain(String streetAddress, String mark,
			String proAdress, String userNo, List<BaseProjectInfo> baseList,
			List<ProjectManagerFindMsgEntity> hisRecord,
			List<ProjectManagerFindMsgEntity> empList) throws BusinessException, IOException{
		// 提交巡检表
				boolean pollSucc = savePollingToPc(streetAddress, mark, proAdress,
						userNo, baseList, hisRecord, empList);
				if (pollSucc) {
					// 看是否存在0分项,是否需要提交提交维修表单
					boolean zeroCheck = false;
					for (ProjectManagerFindMsgEntity zeroCheckBean : hisRecord) {
						double zero = zeroCheckBean.getHisFscore();
						int zeroInt = (int)zero;
						if (zeroInt == 0) {
							zeroCheck = true;
							break;
						}
					}

					if (zeroCheck) {
						// 存在0分项，提交维修表单
						boolean maintain = saveMaintain(mark, proAdress, userNo,
								baseList, hisRecord, empList);
						if (maintain) {
							saveHisSubmit(proAdress, userNo);
							return "{\"resultFlag\":true,\"failureReason\":\"恭喜您，您的信息已经提交成功\",\"isSubmit\":\"successful\"}";
						}
						return "{\"resultFlag\":false,\"failureReason\":\"生成维修单时失败\",\"isSubmit\":\"unsuccessful\"}";
					}
					saveHisSubmit(proAdress, userNo);
					return "{\"resultFlag\":true,\"failureReason\":\"恭喜您，您的信息已经提交成功\",\"isSubmit\":\"successful\"}";
				} else {

					return "{\"resultFlag\":false,\"failureReason\":\"生成巡检单时失败\",\"isSubmit\":\"unsuccessful\"}";
				}
	}

	/**对历史记录去重复
	 * @param hisRecord
	 * @return
	 */
	private List<ProjectManagerFindMsgEntity> filterRepeat(
			List<ProjectManagerFindMsgEntity> hisRecord) {
		List<String> strList = new ArrayList<String>();
		StringBuffer buf = new StringBuffer();
	    List<ProjectManagerFindMsgEntity> proList = new ArrayList<ProjectManagerFindMsgEntity>();
	    for(ProjectManagerFindMsgEntity pr : hisRecord) {
	    	buf.append(pr.getFcheckAreaCode().trim()).append(pr.getFcheckProjectCode().trim());
	    	if(!strList.contains(buf.toString().trim())) {
	    		strList.add(buf.toString().trim());
	    		proList.add(pr);
	    	}
	    }
	  
		return proList;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param proAdress
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	private int saveHisSubmit(String proAdress, String userNo) throws BusinessException {
		ProcHistorySubmitEntity hisSubBean = new ProcHistorySubmitEntity();
		hisSubBean.setStoreName(proAdress);
		hisSubBean.setUserNo(userNo);
		// hisSubBean.setIsSubmit("Y");
		// hisSubBean.setCreateDate(new Date());
		// projectManagerFindMsgDao.saveHisSubmit(hisSubBean);
		projectManagerFindMsgDao.updateHisSubmit(hisSubBean);
		return -1;
	}

	/**
	 * <p>
	 * Description:提交维修表单
	 * </p>
	 * 
	 * @param mark
	 * @param proAdress
	 * @param userNo
	 * @param baseList
	 * @param hisRecord
	 * @return boolean
	 * @throws IOException 
	 */
	private boolean saveMaintain(String mark, String proAdress, String userNo,
			List<BaseProjectInfo> baseList,
			List<ProjectManagerFindMsgEntity> hisRecord,
			List<ProjectManagerFindMsgEntity> empList) throws BusinessException, IOException {

		List<MaintenRequestEntryEntity> entryEntity = new ArrayList<MaintenRequestEntryEntity>();
		// 图片集
		List<AttachmentEntity> phones = new ArrayList<AttachmentEntity>();
		// 给维修的参数
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (hisRecord != null && hisRecord.size() > 0) {
			for (ProjectManagerFindMsgEntity hisBean : hisRecord) {

				double hisFco = hisBean.getHisFscore();
				int hisFcoInt = (int)hisFco;
				if (hisFcoInt == 0) {
					// 获取区域信息
					String areaCode = hisBean.getFcheckAreaCode();
					MareaEntity marea = getRepairArea(areaCode);

					// 获取检查项信息
					String projectCode = hisBean.getFcheckProjectCode();
					MtypeEntity mtype = getMtypeEntity(areaCode, projectCode);

					// 获取维修项信息
					String mattCodeAndId = hisBean.getFrepairMatter();
					List<RepairMatterEntity> rmes = getRepairMatterEntity(
							areaCode, projectCode, mattCodeAndId);

					for (RepairMatterEntity rme : rmes) {
						MaintenRequestEntryEntity mreBean = new MaintenRequestEntryEntity();
						mreBean.setRepairType(mtype);
						mreBean.setRepairTypeId(mtype.getMtid());
						mreBean.setRepairMatter(rme);
						mreBean.setRepairMatterId(rme.getMid());
						mreBean.setRepairArea(marea);
						mreBean.setRepairAreaId(marea.getAid());
						mreBean.setDamageReason(hisBean.getDamageReason());
						entryEntity.add(mreBean);
					}
					// 图片
					// 获取5图片
					String phone = hisBean.getPhoto();
					if (phone != null && !"".equals(phone)) {
						AttachmentEntity attac = new AttachmentEntity();
						attac.setFileName("phone.jpg");
						attac.setFileContent(phone);
						phones.add(attac);

					}
					String phone2 = hisBean.getPhoto2();
					if (phone2 != null && !"".equals(phone2)) {
						AttachmentEntity attac = new AttachmentEntity();
						attac.setFileName("phone2.jpg");
						attac.setFileContent(phone2);
						phones.add(attac);

					}
					String phone3 = hisBean.getPhoto3();
					if (phone3 != null && !"".equals(phone3)) {
						AttachmentEntity attac = new AttachmentEntity();
						attac.setFileName("phone3.jpg");
						attac.setFileContent(phone3);
						phones.add(attac);

					}
					String phone4 = hisBean.getPhoto4();
					if (phone4 != null && !"".equals(phone4)) {
						AttachmentEntity attac = new AttachmentEntity();
						attac.setFileName("phone4.jpg");
						attac.setFileContent(phone4);
						phones.add(attac);

					}
					String phone5 = hisBean.getPhoto5();
					if (phone5 != null && !"".equals(phone5)) {
						AttachmentEntity attac = new AttachmentEntity();
						attac.setFileName("phone5.jpg");
						attac.setFileContent(phone5);
						phones.add(attac);

					}
				}

			}
			// 维修申请表头实体
			MaintenRequestEntity headEntity = new MaintenRequestEntity();
			Date date = new Date();
			if (empList != null && empList.size() > 0) {
				ProjectManagerFindMsgEntity empBean = empList.get(0);
				FUser user = new FUser();
				user.setFnumber(userNo);
				user.setFname(empBean.getEmpname());
				user.setForg(empBean.getOrgname());
				// headEntity.setCreator(user);
				// headEntity.setLastUpdateUser(user);
				// headEntity.setLastUpdateUserId(userNo);
				// headEntity.setHandler(user);
				// headEntity.setAuditor(user);
				// headEntity.setAuditorId(userNo);
			}
			// headEntity.setCreatorId(userNo);
			headEntity.setCreateDate(date);
			headEntity.setLastUpdateTime(date);
			headEntity.setBizDate(date);
			BaseProjectInfo baseBean = baseList.get(0);
			headEntity.setProNumber(baseBean);
			headEntity.setProNumberId(baseBean.getProid());
			headEntity.setProName(baseBean.getProName());
			headEntity.setRepproLocation(proAdress);
			headEntity.setEndTime(baseBean.getEndTime());
			headEntity.setCfmaintenType(baseBean.getFprojectType());
			headEntity.setApplyReason(mark);
			
			resultMap.put("billName", userNo);
			resultMap.put("headEntity", headEntity);
			resultMap.put("entryEntity", entryEntity);
			resultMap.put("attachmentEntity", phones);
			// 推送给pc端
			log.info("开始进行推送给PC端");
			String resultMaintain = requestToPcClient(resultMap, proManagerUrl
					+ "/saveOrUpdateRepRequest", "ESB_APP2ESB_PROJECT_POLLING");

			log.info("《《《《《《维修表单返回值：《《《《《《《" + resultMaintain);
			// 对返回结果处理
			if ("true".equals(resultMaintain.trim())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * <p>
	 * Description:获取维修项的信息
	 * </p>
	 * 
	 * @param areaCode
	 * @param projectCode
	 * @param mattCodeAndId
	 * @return
	 */
	private List<RepairMatterEntity> getRepairMatterEntity(String areaCode,
			String projectCode, String mattCodeAndId) {

		if (mattCodeAndId != null && !"".equals(mattCodeAndId)) {
			// 拆分id与code
			List<RepairMatterEntity> repaList = new ArrayList<RepairMatterEntity>();
			// WXSX00301:节能灯|WXSX00301:节能灯
			if (mattCodeAndId.contains("|")) {
				String[] mttas = mattCodeAndId.split("\\|");
				for (String str : mttas) {
					if (str.contains(":")) {
						String[] matta = str.split("\\:");
						RepairMatterEntity bean = new RepairMatterEntity();
						bean.setMname(matta[1]);
						bean.setMnumber(matta[0]);
						repaList.add(bean);

					}
				}
			} else {
				if (mattCodeAndId.contains(":")) {
					String[] matta = mattCodeAndId.split("\\:");
					RepairMatterEntity bean = new RepairMatterEntity();
					bean.setMname(matta[1]);
					bean.setMnumber(matta[0]);
					repaList.add(bean);

				}
			}
			List<BaseQualityPollingEntity> areas = null;
			if (repaList != null && repaList.size() > 0) {
				// 获取缓存信息
				areas = cacheMap.get(areaCode);
				if (areas != null && areas.size() > 0) {
					 //抽取方法
					setMid(repaList, areas);
					return repaList;
				}

			}

		}

		return null;
	}

	public void setMid(List<RepairMatterEntity> repaList,
			List<BaseQualityPollingEntity> areas) {
		for (RepairMatterEntity rep : repaList) {
			String repMtter = rep.getMnumber().trim();
			for (BaseQualityPollingEntity cachePro : areas) {
				String mattCode = cachePro.getFrepairMatterCode()
						.trim();
				if (mattCode != null && mattCode.equals(repMtter)) {
					rep.setMid(cachePro.getFrepairMatterId());
					break;
				}
			}
		}
	}

	/**
	 * <p>
	 * Description:获取检查项的信息
	 * </p>
	 * 
	 * @param areaCode
	 * @param projectCode
	 * @return
	 */
	private MtypeEntity getMtypeEntity(String areaCode, String projectCode) {
		List<BaseQualityPollingEntity> areaMtype = cacheMap.get(areaCode);
		if (areaMtype != null && areaMtype.size() > 0) {
			MtypeEntity mtype = new MtypeEntity();
			for (BaseQualityPollingEntity cachePro : areaMtype) {
				String cacheProCode = cachePro.getFcheckProjectCode().trim();
				if (projectCode != null && projectCode.equals(cacheProCode)) {
					mtype.setMtid(cachePro.getFcheckProjectId());
					mtype.setMtnumber(cachePro.getFcheckProjectCode());
					mtype.setMtname(cachePro.getFcheckProject());
					return mtype;
				}
			}

		}

		return null;
	}

	/**
	 * <p>
	 * Description:获取区域（导航栏）信息
	 * </p>
	 * 
	 * @param areaCode
	 * @return
	 */
	private MareaEntity getRepairArea(String areaCode) {
		List<BaseQualityPollingEntity> areaRepair= cacheMap.get(areaCode);
		if (areaRepair != null && areaRepair.size() > 0) {
			BaseQualityPollingEntity bean = areaRepair.get(0);
			MareaEntity mareaBean = new MareaEntity();
			mareaBean.setAid(bean.getFcheckAreaId());
			mareaBean.setAnumber(bean.getFcheckAreaCode());
			mareaBean.setAname(bean.getFcheckArea());

			return mareaBean;
		}

		return null;
	}

	/**
	 * <p>
	 * Description:保存巡检表单
	 * </p>
	 * 
	 * @param paraBean
	 * @param hisRecord
	 * @return
	 * @throws IOException 
	 */
	private boolean savePollingToPc(String streetAddress, String mark,
			String proAdress, String userNo, List<BaseProjectInfo> baseList,
			List<ProjectManagerFindMsgEntity> hisRecord,
			List<ProjectManagerFindMsgEntity> empList) throws BusinessException, IOException {
		// 获取本地数据库所属工程部的名称和Id
		List<QualitypollingentryEntity> entry = new ArrayList<QualitypollingentryEntity>();
		// 图片集
		List<AttachmentEntity> phones = new ArrayList<AttachmentEntity>();
		// 给巡检的参数
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (empList != null && empList.size() == 1) {
			double totalScere = 0;
			ProjectManagerFindMsgEntity empBean = empList.get(0);
			// 组拼巡检单
			BaseProjectInfo baseInfo = baseList.get(0);
			// 参数1
			for (ProjectManagerFindMsgEntity hisBean : hisRecord) {
				double hisFscore = hisBean.getHisFscore();// 得分
				double fullFscore = 0d;// 满分
				double poiFscore = 0d;// 扣分
				totalScere += hisFscore;
				// 获取检查项目分值
				int hisFscoreInt = (int)hisFscore;
				if (hisFscoreInt == 0) {
					fullFscore = getFullFscore(hisBean);
					poiFscore = fullFscore;
				} else {
					fullFscore = hisBean.getHisFscore();
				}
				QualitypollingentryEntity bean = new QualitypollingentryEntity();
				bean.setCfcheckarea(hisBean.getFcheckArea());
				bean.setCfcheckaproject(hisBean.getFcheckProject());
				bean.setCfscore(fullFscore);
				bean.setCfpoints(poiFscore);
				bean.setCfaccount(hisFscore);
				bean.setCfproblemcontent(hisBean.getFscoreStandard());
				bean.setCfcause("");
				entry.add(bean);
				// 获取5图片
				String phone = hisBean.getPhoto();
				if (phone != null && !"".equals(phone)) {
					AttachmentEntity attac = new AttachmentEntity();
					attac.setFileName("phone.jpg");
					attac.setFileContent(phone);
					phones.add(attac);

				}
				String phone2 = hisBean.getPhoto2();
				if (phone2 != null && !"".equals(phone2)) {
					AttachmentEntity attac = new AttachmentEntity();
					attac.setFileName("phone2.jpg");
					attac.setFileContent(phone2);
					phones.add(attac);

				}
				String phone3 = hisBean.getPhoto3();
				if (phone3 != null && !"".equals(phone3)) {
					AttachmentEntity attac = new AttachmentEntity();
					attac.setFileName("phone3.jpg");
					attac.setFileContent(phone3);
					phones.add(attac);

				}
				String phone4 = hisBean.getPhoto4();
				if (phone4 != null && !"".equals(phone4)) {
					AttachmentEntity attac = new AttachmentEntity();
					attac.setFileName("phone4.jpg");
					attac.setFileContent(phone4);
					phones.add(attac);

				}
				String phone5 = hisBean.getPhoto5();
				if (phone5 != null && !"".equals(phone5)) {
					AttachmentEntity attac = new AttachmentEntity();
					attac.setFileName("phone5.jpg");
					attac.setFileContent(phone5);
					phones.add(attac);

				}
			}

			Date date = new Date();
			// 参数2
			QualitypollingEntity items = new QualitypollingEntity();
			// items.setFcreatorid(userNo);
			items.setFcreatetime(date);
			// items.setFlastupdateuserid(userNo);
			items.setFlastupdatetime(date);
			items.setFbizdate(date);
			// items.setFauditorid(userNo);
			items.setCfprojectnumberid(baseInfo.getProid());
			items.setCfprojectname(baseInfo.getProName());
			// items.setCfbelongprodeptid(empBean.getOrgid());
			// items.setCfbelongprodeptidasname(empBean.getOrgname());
			items.setCfcheckpersonid(userNo);
			items.setCfcheckpersonidasname(empBean.getEmpname());
			items.setCftotalscore(totalScere);
			items.setCflackparts(streetAddress);
			items.setCfremake(mark);

			resultMap.put("empCode", userNo);
			resultMap.put("billName", "quality");
			resultMap.put("items", items);
			resultMap.put("entry", entry);
			if (phones != null && phones.size() > 0) {
				resultMap.put("attachmentEntity", phones);
			}

			// proManagerUrl="http://10.224.72.25:8089/lsp/webservice/baseProjectService/queryBaseData";

			// 把数据放到PC端
			log.info("开始进行推送给PC端");
			String resultPoll = requestToPcClient(resultMap, proManagerUrl
					+ "/saveOrUpdateBaseData", "ESB_APP2ESB_PROJECT_POLLING");
			log.info("<<<<<<<<<巡检单返回结果:<<<<<<<<<<" + resultPoll);
			// 对返回结果解析。。
			if ("false".equals(resultPoll.trim())) {
				return true;
			}

		}
		return false;
	}

	/**
	 * <p>
	 * Description:获取检查项满分值
	 * </p>
	 * 
	 * @param hisBean
	 * @return
	 */
	private double getFullFscore(ProjectManagerFindMsgEntity hisBean) {
		// Map<String, List<BaseQualityPollingEntity>> cacheMap
		String areaId = hisBean.getFcheckAreaCode().trim();
		String proId = hisBean.getFcheckProjectCode().trim();
		List<BaseQualityPollingEntity> cacheList = cacheMap.get(areaId);
		for (BaseQualityPollingEntity cacheBean : cacheList) {
			String chcheProId = cacheBean.getFcheckProjectCode().trim();
			if (proId != null && proId.equals(chcheProId)) {
				return cacheBean.getFscore();
			}
		}
		return -1;
	}

	/**
	 * <p>
	 * Description: PC联调———获取项目编码
	 * </p>
	 * 
	 * @param proAdress
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 */
	private List<BaseProjectInfo> getBaseProjectInfo(String deptCode)
			throws BusinessException, IOException {
		// String result =
		// "{'resultFlag':false,'failureReason':'出现多个项目编码，请选择一个后提交','isSubmit':' resubmit','parameter':[{'creator':'预设用户','proAdress':'南通市崇川区虹桥路怡安花园25幢1店西间（段家坝路与虹桥路交叉口路南、中国银行旁）','proCreateTime':1359679463000,'proDep':'苏南事业部','proName':'南通崇川区虹桥路营业部','proNumber':'GDM-20120101-0909','proState':'7','proType':'1','proid':'pq6NegwrQhavlG4ZuwCYYyHkC0s='},{'creator':'预设用户','proAdress':'南通市崇川区工农路436号103室','proCreateTime':1359679469000,'proDep':'苏南事业部','proName':'南通崇川区工农路营业部','proNumber':'GDM-20120101-1187','proState':'7','proType':'1','proid':'pWZ5qt2tTLSJmj9ej7tXQSHkC0s='},{'creator':'预设用户','endTime':1362585600000,'proAdress':'南通崇川区观音山镇太平北路8号文华名邸11-105','proCreateTime':1359679889000,'proDep':'苏南事业部','proName':'南通崇川区观音山镇营业部','proNumber':'GDM-20130125-0140','proState':'7','proType':'1','proid':'jtZpX2zVRCe0HeXp40XL4SHkC0s='},{'creator':'预设用户','proAdress':'南通崇川区紫琅路30号','proCreateTime':1359679889000,'proDep':'苏南事业部','proName':'南通崇川区紫琅路营业部','proNumber':'GDM-20130125-0153','proState':'7','proType':'1','proid':'5IlWiibPSHWq2C8bembDyyHkC0s='},{'creator':'朱金','endTime':1389715200000,'proAdress':'南通','proCreateTime':1388482873000,'proDep':'江苏工程部','proName':'南通崇川区虹桥路营业部改建','proNumber':'GDM-20131231-5780','proOrderId':'7tDcLMpgBovgQzEDqMCG5lYQptY=','proState':'2','proType':'1','proid':'7tHnx5CCDC/gQzEDqMBOQSHkC0s='},{'creator':'卜志奎','endTime':1397750400000,'proAdress':'南通崇川区工农路78号103室','proCreateTime':1395450893000,'proDep':'江苏工程部','proName':'南通崇川区工农路营业部 ','proNumber':'GDM-20140319-0819','proOrderId':'9PbW3jWNbf3gQzIDqMCc4VYQptY=','proState':'7','proType':'1','proid':'9Si6whdFOeTgQzIDqMDqtiHkC0s='},{'creator':'卜志奎','proAdress':'南通市崇川区任港路23号（万濠华府南门商业D1-02）','proCreateTime':1404205254000,'proDep':'江苏工程部','proName':'南通崇川区任港路营业部','proNumber':'GDM-20140628-5470','proOrderId':'/OQ9IpGlA7TgQzEDqMAp4lYQptY=','proState':'1','proType':'1','proid':'/R75yJHQeNzgQzEDqMDKACHkC0s='}]}";
		String result = requestClient(deptCode, proManagerUrl
				+ "/queryBaseProjectData", "ESB_APP2ESB_PROJECT_POLLING");

		if (result != null && !"".equals(result)) {
			log.info("result:" + result);
			JSONObject json = new JSONObject().parseObject(result);
			String items = json.getString("items") == null ? "" : json
					.getString("items");
			log.info("items:" + items);
			if ("".equals(items)) {
				return null;
			}
			JSONObject json2 = new JSONObject().parseObject(items);
			String listStr = json2.getString("list") == null ? "" : json2
					.getString("list");
			log.info("listStr:" + listStr);
			if ("".equals(listStr)) {
				return null;
			}
			// 客户端的数据转化为list
			List<BaseProjectInfo> baseList = JsonUtil.jsonToList(listStr,
					BaseProjectInfo.class);
			log.info("pc端基础信息的值:" + baseList.get(0).toString());

			log.info("信息解析成功");
			return baseList;
		}
		return null;
	}

	/*
	 * 提交检验 <p>Title: checkSubmit</p> <p>Description:提交检验</p>
	 * 
	 * @param str
	 * 
	 * @return
	 * 
	 * @throws BusinessException
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.service.IProjectManagerFindMsgService
	 * #checkSubmit(java.lang.String)
	 */
	@Override
	public synchronized String checkSubmit(String str) throws BusinessException {
		//String res = "{\"resultFlag\":false,\"failureReason\":\"校验失败\",\"isSubmit\":false}";

		JSONObject json = new JSONObject().parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// 门店地址
		String proAdress = json.getString("proAdress").trim();
		// 用户工号
		String userNo = json.getString("userNo").trim();
		log.info("proAdress:" + proAdress);
		log.info("userNo:" + userNo);
		if (proAdress == null || "".equals(proAdress) || userNo == null
				|| "".equals(userNo)) {

			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空\"}";
		}
		// 存储缓存里的评分项（检查项）

		Set<Entry<String, List<BaseQualityPollingEntity>>> sets = cacheMap
				.entrySet();
		int cacheProId = 0;
		// 获取缓存中每一个检查项Id
		for (Entry<String, List<BaseQualityPollingEntity>> entry : sets) {
			Set<String> setId = new HashSet<String>();
			List<BaseQualityPollingEntity> listBean = entry.getValue();
			for (BaseQualityPollingEntity bean : listBean) {
				String proId = bean.getProId().trim();
				log.info("proId" + proId);
				if (!setId.contains(proId)) {
					cacheProId++;
					setId.add(proId);
				}
			}
		}
		//缓存里没有数据，变为100000
        if(cacheProId == 0){
        	cacheProId = Constants.PROC_CACHCHE_PROID;
        }
		ProjectManagerFindMsgEntity msgBean = new ProjectManagerFindMsgEntity();
		msgBean.setProAdress(proAdress);
		msgBean.setUserNo(userNo);
		int tatol = projectManagerFindMsgDao.getCountProId(msgBean);

		log.info("数据库评分个数：" + tatol);
		log.info("缓存里检查项个数" + cacheProId);
		if (tatol >= cacheProId) {
			return "{\"resultFlag\":true,\"failureReason\":\"已经全部评分\",\"isSubmit\":true}";
		} else {
			return "{\"resultFlag\":false,\"failureReason\":\"没有全部评分\",\"isSubmit\":false}";
		}

	}

	/**
	 * <p>
	 * Description:获取Http的客户端
	 * </p>
	 * 
	 * @param param
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 */
	public String requestClient(String param, String url, String esbServiceCode)
			throws BusinessException, IOException {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(Constants.HTTP_CON_TIMEOUT);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(Constants.HTTP_SO_TIMEOUT);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(),Constants.HTTP_PROTOCOL);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");

		// 参数设置
		// String paramJson = JsonUtil.mapToJsonString(param);
		String headerJson = JsonUtil.mapToJsonString(map);

		RequestEntity entity = new StringRequestEntity(param,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);

		log.info("post url ==========>" + url);
		log.info("post paramter ==========>" + param);
		log.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);

		String result = post.getResponseBodyAsString();
		log.info(esbServiceCode + " response data : " + result);

		return result;
	}

}
