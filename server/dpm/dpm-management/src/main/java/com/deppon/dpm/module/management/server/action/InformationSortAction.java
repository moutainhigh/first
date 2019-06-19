package com.deppon.dpm.module.management.server.action;

import java.util.List;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IInformationService;
import com.deppon.dpm.module.management.shared.domain.InformationSort;

/**
 * 资讯排序
 * 
 */
public class InformationSortAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 4766717849714269680L;

	/**
	 * 1 新闻动态<br>
	 * 2 高管随笔 <br>
	 * 3 任免公告 <br>
	 * 4 违纪 <br>
	 * 5 早安快递<br>
	 * 6 营业部晨会<br>
	 */
	private String sortStr;
	/**
	 * informationService 注入
	 */
	private IInformationService informationService;

	/**
	 * @return getSortStr
	 */
	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}

	/**
	 * 根据工号获取资讯列表
	 */
	public void list() {
		Result<Object> result = new Result<Object>();
		try {
			// 根据Id得到list数据
			List<InformationSort> list = informationService.list(userId);
			// 塞入数据
			result.setData(list);
			// 塞入数据
			result.setCount(list.size());
			// 塞入数据
			result.setErrorMessage("获取资讯列表成功");
		} catch (Exception e) {
			// 设置不成功的标志位
			result.setErrorCode(2);
			result.setErrorMessage("获取资讯列表失败");
		}
		// 写入数据
		writeToPage(result);
	}

	/**
	 * 保存资讯排序
	 */
	public void sort() {
		// 结果集
		Result<Object> result = new Result<Object>();
		try {
			// 排序
			informationService.sort(userId, sortStr);
			result.setResult("保存排序成功");
		} catch (Exception e) {
			result.setErrorCode(1);
			result.setResult("保存排序失败");
		}
		// 写入数据
		writeToPage(result);
	}

	/**
	 * 获取资讯排序
	 */
	public void getSort() {
		// 结果集
		Result<Object> result = new Result<Object>();
		try {
			// 根据工号得到数据
			String sort = informationService.getSort(userId);
			// 塞入数据
			result.setData(sort);
		} catch (Exception e) {
			// 给状态位
			result.setErrorCode(1);
			result.setErrorMessage(e.getMessage());
		}
		// 写入数据
		writeToPage(result);
	}

	public IInformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(IInformationService informationService) {
		this.informationService = informationService;
	}

}
