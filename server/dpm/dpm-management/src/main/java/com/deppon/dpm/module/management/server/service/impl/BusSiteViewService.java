package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.management.server.dao.IBusSiteViewDao;
import com.deppon.dpm.module.management.server.service.IBusSiteViewService;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;
import com.deppon.dpm.module.management.shared.domain.BusSiteView;
import com.deppon.foss.framework.exception.BusinessException;
/**
 * 站点显示service接口实现
 * @author 曹嵩
 * @date 2015.6.18
 */
public class BusSiteViewService implements IBusSiteViewService {
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusSiteViewService.class);

	/**
	 * bussiteviewdao 注入
	 */
	private IBusSiteViewDao bussiteviewdao;
	
	/**
	 * @return 注入
	 */
	public IBusSiteViewDao getBussiteviewdao() {
		return bussiteviewdao;
	}

	/**
	 * @param bussiteviewdao 注入
	 */
	public void setBussiteviewdao(IBusSiteViewDao bussiteviewdao) {
		this.bussiteviewdao = bussiteviewdao;
	}


	@Override
	/**
	 * 根据前台的时间判断返回的数据是上班数据还是下班数据
	 */
	public List<BusSiteView> getSiteNameAndState(String time) throws BusinessException {
		int i = 0;
		StringBuffer sbf = new StringBuffer();
		List<BusSiteView> siteList = bussiteviewdao.getSiteNameAndState();
		List<BusSiteView> siteListNew = new ArrayList<BusSiteView>();
		logger.info("前台传过来的时间类型是======>"+time);
		for (BusSiteView s : siteList) {
			if(time.equals("AM")){//判断前台传来的值是AM还是PM，如果是AM
				if(s.getIsGoWork()==0){//判断是否是上班状态
					siteListNew.add(s);
					logger.info("添加上班的数据成功======>"+siteListNew);
				}
			}else if(time.equals("PM")){//判断前台传来的值是AM还是PM，如果是PM
				if(s.getIsGoWork()==1){//判断是否是下班状态
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					//获取所有的时间
					List<BusSiteView> bussiteviewList = bussiteviewdao.getTimeByAll();
					for (BusSiteView b : bussiteviewList) {
						if(i==0){//如果变量为0就可以进入拼接
							sbf.append(sdf.format(b.getTimeDate()));
							i++;//变量自增
						}else{//如果变量不为0那么就加上“|”把时间拼接起来
							sbf.append("|"+sdf.format(b.getTimeDate()));
						}
					}
					//如果变量为1那么将时间添加到实体类
					if(i==1){
						logger.info("拼接后的时间为======>"+sbf.toString());
						//str 转换
						s.setTimeStr(sbf.toString());
						i++;
					}
					//塞入数据
					siteListNew.add(s);
					logger.info("添加下班的数据成功======>"+siteListNew);
				}
			}
		}
		//返回数据
		return siteListNew;
	}

	/**
	 * 
	 * @return 得到途径时间
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByRouteTime(BusSiteInfoByClick b) throws BusinessException {
		//返回数据
		return bussiteviewdao.getSiteByRouteTime(b);
	}


	/**
	 * 
	 * @return 得到起点终点站名称以及时间
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByLineInfo(BusSiteInfoByClick b) throws BusinessException {
		//返回数据
		return bussiteviewdao.getSiteByLineInfo(b);
	}

	/**
	 * 
	 * @return 得到供应商信息
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteByApplyInfo(BusSiteInfoByClick b) throws BusinessException {
		//返回数据
		return bussiteviewdao.getSiteByApplyInfo(b);
	}

	/**
	 * 
	 * @return 获取站点名称和地址
	 * @throws BusinessException
	 */
	public List<BusSiteInfoByClick> getSiteAddressAndSiteName(BusSiteInfoByClick b)
			throws BusinessException {
		//返回数据
		return bussiteviewdao.getSiteAddressAndSiteName(b);
	}

}
