package com.deppon.dpm.module.management.server.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IReservationManageByAdminService;
import com.deppon.dpm.module.management.server.service.IReserveManageCancelService;

/**
 * 
 * 预订管理羽毛球和瑜伽室的取消预订和提前结束action层.
 * @author 曹嵩
 * <p>时间:2015.10.20</p>
 */
public class ReserveManageCancelAction extends BaseAction {

	/**
	 * 编号.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态.
	 */
	private int status;
	
	/**
	 * 编号.
	 */
	private int id;
	
	/**
	 * 楼层区域名称.
	 */
	private String areaName;
	/**
	 * 搜索时间
	 */
	private String searchTime;
	
	/**
	 * 预定类型标志（0羽毛球室，1瑜伽室）.
	 */
	private int siteMark;

	/**
	* @Fields reserveManageCancelService : reserveManageCancelService的注入
	*/
	private IReserveManageCancelService reserveManageCancelService;
	
	/**
	* @Fields reservationManageByAdminService : reservationManageByAdminService的注入
	*/
	private IReservationManageByAdminService reservationManageByAdminService;
    //reserveManageCancelService 的get set
	public IReserveManageCancelService getReserveManageCancelService() {
		return reserveManageCancelService;
	}
	 //reserveManageCancelService 的get set
	public void setReserveManageCancelService(
			IReserveManageCancelService reserveManageCancelService) {
		this.reserveManageCancelService = reserveManageCancelService;
	}
	 //reserveManageCancelService 的get set
	public IReservationManageByAdminService getReservationManageByAdminService() {
		return reservationManageByAdminService;
	}
	 //reserveManageCancelService 的get set
	public void setReservationManageByAdminService(
			IReservationManageByAdminService reservationManageByAdminService) {
		this.reservationManageByAdminService = reservationManageByAdminService;
	}

	/** 
	* @Title: getStatus 
	* @Description: 状态
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/ 
	
	public int getStatus() {
		return status;
	}

	/** 
	* @Title: setStatus 
	* @Description: 状态
	* @param @param status    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setStatus(int status) {
		this.status = status;
	}

	/** 
	* @Title: getId 
	* @Description:id 的get set
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/ 
	
	public int getId() {
		return id;
	}

	/** 
	* @Title: setId 
	* @Description: id 的get set
	* @param @param id    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setId(int id) {
		this.id = id;
	}

	/** 
	* @Title: getAreaName 
	* @Description: 楼层区域名称get set
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	public String getAreaName() {
		return areaName;
	}

	/** 
	* @Title: setAreaName 
	* @Description: 楼层区域名称get set
	* @param @param areaName    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
    //预定类型标志（0羽毛球室，1瑜伽室）.
	public int getSiteMark() {
		return siteMark;
	}
    //预定类型标志（0羽毛球室，1瑜伽室）.
	public void setSiteMark(int siteMark) {
		this.siteMark = siteMark;
	}

	
	//搜索时间
	public String getSearchTime() {
		return searchTime;
	}
	//搜索时间
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	/**
	 * 修改状态并且修改当前时间根据id.
	 * @param status 状态0 –预定 1-取消预定 2-提前结束预定
	 * @param id 编号
	 */
	public void updateStatus() throws Exception{
		// 设置页面响应实体
				String res = "";
				int result = 0;
				HttpServletResponse response = ServletActionContext.getResponse();
				// 设置页面响应实体
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
				response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
					try {
						//得到结果集
						result = reserveManageCancelService.updateState(status, id);
						//判断结果
						if(result>0){
							res = "{\"resultFlag\":true,\"failureReason\":\"执行修改成功！\"}";
						}else{
							res = "{\"resultFlag\":false,\"failureReason\":\"执行修改失败！\"}";
						}
					} catch (Exception e) {
						//捕获异常
						e.printStackTrace();
						res = "{\"resultFlag\":false,\"failureReason\":\"执行修改出现异常！\"}";
					}
					//写入数据
					writeToPage(response, res);
	}
	/**
	 * 查询所有的已预订信息.
	 * @param areaName 楼层区域名称
	 * @param siteMark 预定类型标志（0羽毛球室，1瑜伽室）
	 */
	public void getReservationManagList(){
		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			try {
				
				      Map<String, Object> list = reservationManageByAdminService.getReservationManagList(areaName, siteMark,searchTime);
				res = JsonUtil.beanToJsonString(list);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//写入数据
			writeToPage(response, res);
	}
}
