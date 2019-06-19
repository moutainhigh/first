package com.deppon.dpm.module.management.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IBusSiteViewService;
import com.deppon.dpm.module.management.shared.domain.BusSiteInfoByClick;
import com.deppon.dpm.module.management.shared.domain.BusSiteView;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 站点显示action
 * 
 * @author 曹嵩
 * @date 2015.6.18
 */
public class BusSiteViewAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IBusSiteViewService bussiteviewservice;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(BusSiteViewAction.class);

	//前台传送过来的时间类型(AM:表示早班类型PM:表示晚班类型)
	private String time;

	//前台传送过来的站点id
	private int id;
	
	//前台传送过来的站点名称
	private String siteName;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public IBusSiteViewService getBussiteviewservice() {
		return bussiteviewservice;
	}

	public void setBussiteviewservice(IBusSiteViewService bussiteviewservice) {
		this.bussiteviewservice = bussiteviewservice;
	}

	/**
	 * 得到上班下班的名称和状态
	 */
	public void getSiteNameAndState() {
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			// 根据前台传过来的时间类型判断得到的是上班信息还是下班信息（time的值为AM和PM）
			List<BusSiteView> bussiteview = bussiteviewservice
					.getSiteNameAndState(time);
			res = JsonUtil.beanToJsonString(bussiteview);
			Log.info("获取数据成功" + res);
		} catch (Exception ce) {
			Log.info("获取数据失败" + res);
			ce.printStackTrace();
		}
		writeToPage(response, res);
	}

	/**
	 * 点击站点的时候显示的详情
	 */
	public void getSiteByClick() {
		//String ss = siteName;
		//int gg = id;
		String res = "";
		Map<String, Object> mapList = new HashMap<String, Object>();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			int i = 0;// 变量，用来判断
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");// 将时间格式转化成小时：分钟
			BusSiteInfoByClick siteClick = new BusSiteInfoByClick();// 初始化一个实体类siteClick
			BusSiteInfoByClick newSiteClick = new BusSiteInfoByClick();// 再次初始化一个实体类newSiteClick
			StringBuffer sbf = new StringBuffer();// 用来拼接字符串
			List<BusSiteInfoByClick> siteClickList = new ArrayList<BusSiteInfoByClick>();// 创建一个siteClickList
			//将站点编号、时间类型、站点名称保存在实体类中
			siteClick.setId(id);
			siteClick.setTimeType(time);
			siteClick.setSiteName(siteName);
			if(siteClick.getTimeType().equals("AM")){//判断类型是否为AM
				siteClick.setStartName(siteName);//如果是AM就将站点名称保存在起点站名称中
			}else{
				siteClick.setEndName(siteName);//如果是PM就将站点名称保存在终点站名称中
			}
			//得到站点的名称和地址
			List<BusSiteInfoByClick> list = bussiteviewservice.getSiteAddressAndSiteName(siteClick);
			// 根据id和时间类型得到途径时间
			List<BusSiteInfoByClick> oneList = bussiteviewservice
					.getSiteByRouteTime(siteClick);
			for (BusSiteInfoByClick one : oneList) {
				if (i == 0) {//如果是第一次循环得到第一个时间
					sbf.append(sdf.format(one.getRouteTime()));// 将时间格式转换成HH:mm然后进行拼接
					
				} else if((i+1)==oneList.size()){//如果循环得到最后一个数据就将最后一个时间拼接起来
					sbf.append("至" + sdf.format(one.getRouteTime()));
				}
				i++;//自加
			}
			//newSiteClick.setRouteTimestr(sbf.toString());
			mapList.put("routeTime", sbf.toString());
			// 得到线路的详细信息
			List<BusSiteInfoByClick> twoList = bussiteviewservice
					.getSiteByLineInfo(siteClick);
			// 判断线路
			//String lineInfo = "";
			StringBuilder lineInfo = new StringBuilder();//字符串的增加，优先选择StringBuilder 
			int j = 1;// 变量，判断是否拼接用
			for (BusSiteInfoByClick two : twoList) {

				/*
				 * newSiteClick.setLineId(two.getLineId());
				 * newSiteClick.setLineName(two.getLineName());
				 * newSiteClick.setStartName(two.getStartName());
				 * newSiteClick.setStartDate(two.getStartDate());
				 * newSiteClick.setStartDatestr(sdf.format(two.getStartDate()));
				 * newSiteClick.setEndName(two.getEndName());
				 * newSiteClick.setSiteId(two.getSiteId());
				 */
				// 判断如果是最后一个就不加拼接符号"|"
				if (j == twoList.size()) {
					//lineInfo += sdf.format(two.getStartDate()) + " " + two.getStartName() + "-" + two.getEndName();
					lineInfo.append(sdf.format(two.getStartDate()) + " " + two.getStartName() + "-" + two.getEndName());
				} else {
					//lineInfo += sdf.format(two.getStartDate()) + " " + two.getStartName() + "-" + two.getEndName() + "|";
					lineInfo.append(sdf.format(two.getStartDate()) + " " + two.getStartName() + "-" + two.getEndName() + "|");
					j++;
				}

			}
			//将路线信息中的数据通过"|"分割成数组
			String[] arryLineInfo = lineInfo.toString().split("\\|");
			mapList.put("arryLineInfo", arryLineInfo);
			// newSiteClick.setLineInfo(lineInfo);
			// 得到供应商的详细信息
			List<BusSiteInfoByClick> threeList = bussiteviewservice
					.getSiteByApplyInfo(siteClick);
			//List<String> userList = new ArrayList<String>();
			List<String> userNameList = new ArrayList<String>();
			List<String> telList = new ArrayList<String>();
			// 判断供应商
			List<String> applyList = new ArrayList<String>();
			//String linkMan = "";
			String newUserName = "";
			String newTel = "";
			//String newApplyName = "";
			StringBuilder newApplyName = new StringBuilder();
			//int k = 0;// 变量，判断是否拼接用
			int l = 0;// 变量，判断是否拼接用
			
			for (BusSiteInfoByClick three : threeList) {
				String userName = three.getUserName();//得到联系人
				String tel = three.getTel();//得到电话
					if(!StringUtil.isEmpty(userName)){//如果联系人不为空
						if(!userNameList.contains(userName)){//如果联系人不重复
							userNameList.add(userName);
							mapList.put("userNameList", userNameList);
						}
					}
				
					if(!StringUtil.isEmpty(tel)){//如果电话不为空
						if(!telList.contains(tel)){//如果电话不重复
							telList.add(tel);
							mapList.put("telList", telList);
						}
					}
			
				mapList.put("newUserName", newUserName);
				mapList.put("newTel", newTel);

				// 判断联系人
				/*if (!com.deppon.foss.framework.shared.util.string.StringUtil
						.isEmpty(userName)) {// 判断是否为空
					if (!userList.contains(userName)) {// 判断是否重复
						userList.add(userName);
						if (!com.deppon.foss.framework.shared.util.string.StringUtil
								.isEmpty(tel))
							if (k == 0) {
								linkMan += userName + " " + tel;
								k++;
							} else {
								linkMan += "|" + userName + " " + tel;
							}
					}
				}*/

				String applyName = three.getApplyName();//得到供应商名称
				// 判断是否为空
				if (!com.deppon.foss.framework.shared.util.string.StringUtil
						.isEmpty(applyName)) {
					if (!applyList.contains(applyName)) {// 判断是否重复
						applyList.add(applyName);
						if (l == 0) {
							//newApplyName += applyName;
							newApplyName.append(applyName);
							l++;
						} else {
							//newApplyName += "|" + applyName;
							newApplyName.append("|" +applyName);
						}
					}
				}
			}
			// 将字符串分割成数组
			//String[] arrayLinkMan = linkMan.split("\\|");
			String[] arrayNewApplyName = newApplyName.toString().split("\\|");
			// 将分割后的数组存放在map集合中
			//mapList.put("arrayLinkMan", arrayLinkMan);
			mapList.put("arrayNewApplyName", arrayNewApplyName);
			mapList.put("siteName", siteClick.getSiteName());
			mapList.put("address", list.get(0).getAddress());
			// newSiteClick.setUserName(linkMan);
			// newSiteClick.setApplyName(newApplyName);
			// newSiteClick.setTel(three.getTel());
			siteClickList.add(newSiteClick);
			// 将list集合保存到MAP集合中
			mapList.put("siteClickList", siteClickList);
			// res=JsonUtil.beanToJsonString(siteClickList);
			res = JsonUtil.mapToJsonString(mapList);
			logger.info("getSiteByClick======>返回数据"+res);
		} catch (Exception ce) {
			ce.printStackTrace();
			logger.info("点击站点的时候显示的详情 ------方法getSiteByClick======>程序出错");
		}
		writeToPage(response, res);
	}

}
