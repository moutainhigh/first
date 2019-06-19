package com.deppon.dpm.store.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.result.CodeMsg;
import com.deppon.dpm.store.server.service.IStoreListService;
import com.deppon.dpm.store.server.vo.StoreListVo;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 榜单信息,榜单操作
 * 
 * @author XiaoTian
 *
 */
public class StoreListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 753210889097499014L;

	// 查询所有部门信息service
	private ISelectAllDeptService selectAllDeptService;
	// 榜单
	private IStoreListService storeListService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(StoreListAction.class);
	/**
	 * 返回错误名称
	 */
	private final String ERROR = "error";
	/**
	 * 返回错误成功
	 */
	private final String SUCCESS = "success";
	/**
	 * 当前多少条
	 */
	private String rowBegin;
	/**
	 * 显示多少条数据
	 */
	private static final Integer limit = 100;
	/**
	 * 获取当前登录人编号
	 */
	private String creatorcode;
	/**
	 * 获取营业部编号
	 */
	private String deptnum;
	/**
	 * 操作类型 1进行点赞,2进行警告
	 */
	private Integer likelogtype;
	/**
	 * 营业部名称
	 */
	private String deptName;

	/**
	 * 查询榜单
	 */
	//@CookieNotCheckedRequired
	public void findList() {
		// 获取当前日期
		JSONObject jonum = new JSONObject();
		logger.info("查询榜单开始--------");
		try {
			Date currentTime = new Date();
			// 判断当前页从那一页开始 为空从第0页开始
			Map<String, Object> map = new HashMap<String, Object>();
			/**
			 * get方法都验证了是否为空
			 */
			// 当前页
			map.put("rowBegin", Integer.parseInt(getRowBegin()));
			map.put("limit", limit);
			// 存入当前时间
			map.put("likelogtime", ToStringParse(currentTime));
			map.put("creatorcode", getCreatorcode());
			// 营业部名称
			map.put("deptName", getDeptName());
			// 查询榜单信息
			List<StoreListVo> storeListVos = storeListService.fineList(map);
			if (null != storeListVos && storeListVos.size() > 0) {
				try {
					if (storeListVos.size() > 1) {
						// 榜一和榜二换位
						Map<Integer, StoreListVo> StoreListVoMap = new HashMap<Integer, StoreListVo>();
						StoreListVoMap.put(0, storeListVos.get(0));
						StoreListVoMap.put(1, storeListVos.get(1));
						// 数据掉换 2 1 3 顺序
						storeListVos.set(0, StoreListVoMap.get(0));
						storeListVos.set(1, StoreListVoMap.get(1));
					}
				} catch (Exception e) {
					// 榜单更换位置失败了
					e.printStackTrace();
					logger.error("榜单一二名掉换失败");
				}
				// 返回榜单数据 List
				jonum.put("storeListVos", storeListVos);
			} else {
				// 榜单无有数据
				logger.info("榜单信息为空--------");
				jonum.put(SUCCESS, CodeMsg.List_NULL__SUCCESS);
				jonum.put("storeListVos", storeListVos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("榜单信息异常--------");
			jonum.put(ERROR, CodeMsg.List__ERROR);
		} finally {
			writeToPage(jonum);
		}
	}

	/**
	 * 修改当前营业部,点赞或者警告进行 +1 操作
	 */
	//@CookieNotCheckedRequired
	public void alterDeptnum() {
		JSONObject jonum = new JSONObject();
		/**
		 * 判断添加参数不能为空
		 */
		logger.info("修改营业部点信息开始--------");
		if (!StringUtils.isEmpty(creatorcode) && !StringUtils.isEmpty(deptnum)
				&& (1 == likelogtype || 2 == likelogtype)) {
			try {
				/**
				 * 创建一个map
				 */
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("creatorcode", creatorcode);
				map.put("deptnum", deptnum);
				Date currentTime = new Date();
				map.put("likelogtime", ToStringParse(currentTime));
				// 查询是否进行操作
				int conut = storeListService.fineCountlikeIf(map);
				if (conut > 0) {
					// 当前用户今天已经点赞
					jonum.put(SUCCESS, CodeMsg.List_Like_exist);
				} else {
					// likelogtype 为1 进行添加点赞 为2进行添加警告
					int num = storeListService.updateNum(creatorcode,deptnum, likelogtype);
					// 是否操作成功
					jonum.put(SUCCESS, num > 1 ? CodeMsg.List_LIKENUM_SUCCESS : CodeMsg.List_LIKENUM_ERROR);
				}
			} catch (Exception e) {
				// 点赞警告操作异常
				e.printStackTrace();
				logger.error("点赞警告操作异常----------------");
				jonum.put(ERROR, CodeMsg.List_PARAMETER_NULL);
			}
		} else {
			// 传入参数错误
			logger.info("传入参数错误----------------");
			jonum.put(ERROR, CodeMsg.List_PARAMETER_NULL);
		}
		// 返回数据
		writeToPage(jonum);
	}
	// 日期转换 String 转换为 Date
	private static String ToStringParse(Date time) throws ParseException {
		// 设置日期格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// 将日期转换为字符串
		String dateString = formatter.format(time);
		return dateString;
	}
	/**
	 * 
	 * @return
	 */
	public ISelectAllDeptService getSelectAllDeptService() {
		return selectAllDeptService;
	}

	/**
	 * 
	 * @param selectAllDeptService
	 */
	public void setSelectAllDeptService(
			ISelectAllDeptService selectAllDeptService) {
		this.selectAllDeptService = selectAllDeptService;
	}

	/**
	 * 
	 * @return
	 */
	public IStoreListService getStoreListService() {
		return storeListService;
	}

	/**
	 * 
	 * @param storeListService
	 */
	public void setStoreListService(IStoreListService storeListService) {
		this.storeListService = storeListService;
	}

	/**
	 * 
	 * @return
	 */
	public String getRowBegin() {
		return rowBegin == null ? "0" : rowBegin;
	}

	/**
	 * 
	 * @param rowBegin
	 */
	public void setRowBegin(String rowBegin) {
		this.rowBegin = rowBegin;
	}

	/**
	 * 
	 * @return
	 */
	public String getCreatorcode() {
		return creatorcode == null ? "" : creatorcode;
	}

	/**
	 * 
	 * @param creatorcode
	 */
	public void setCreatorcode(String creatorcode) {
		this.creatorcode = creatorcode;
	}

	/**
	 * 
	 * @return
	 */
	public String getDeptnum() {
		return deptnum;
	}

	/**
	 * 
	 * @param deptnum
	 */
	public void setDeptnum(String deptnum) {
		this.deptnum = deptnum;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getLikelogtype() {
		return likelogtype;
	}

	/**
	 * 
	 * @param likelogtype
	 */
	public void setLikelogtype(Integer likelogtype) {
		this.likelogtype = likelogtype;
	}

	/**
	 * 
	 * @return
	 */
	public String getDeptName() {
		return deptName != null ? deptName.trim() : null;
	}

	/**
	 * 
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
