package com.deppon.dpm.module.lsp.server.action;

import java.io.BufferedReader;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.lsp.server.service.ISynStocktaskingService;
import com.deppon.dpm.module.lsp.shared.domain.SynchronousStocktaskingInfo;
import com.deppon.dpm.module.lsp.shared.vo.ResponseParameterEntity;


/**
 * 
 * 固定资产 移动端与Lsp数据同步
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:195406 高春玲,date:2015-3-20 下午1:45:08,content:固定资产
 * 移动端与Lsp数据同步
 * </p>
 * 
 * @author 195406 高春玲
 * @date 2015-3-20 下午1:45:08 1、 在移动端接收任务通知后，在对应的盘点任务列表中或者首页直接点击扫一扫按钮，即可扫描固定资产；
 *       2、
 *       移动端扫描时，将扫描的固定资产管理编码推送至LSP，LSP校验此资产是否已被扫描，未扫描则可进行以下操作，若已扫描则推送已扫描信息至移动端。
 *       3、 移动端扫描时，扫描结果选择完成时将信息推送至LSP 4、
 *       移动端扫描时，资产未在盘点任务列表中的扫描完成后将盘盈的资产信息推送至LSP，LSP系统将固定资产信息匹配完整后推送至移动端保存 5、
 *       移动端扫描时，资产在盘点任务列表中但未进行扫描，盘点列表信息暂存或者提交后将盘亏信息推送至LSP 6、
 *       扫描过程中信息同步到LSP中的“固定资产盘点单”中 7、
 *       扫描的固定资产不在任务盘点列表中则自动新增一条记录，自动新增的固定资产可删除，删除确认后将该固定资产信息推送至LSP
 * @version
 */
public class SynStocktaskingAction extends BaseAction {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1397420409043898745L;
	// 日志
	private Logger logger = LoggerFactory
			.getLogger(SynStocktaskingAction.class);

	/**
	 * 同步接口.
	 */
	private ISynStocktaskingService synStocktaskingService;

	private SynchronousStocktaskingInfo info;
	// 记录请求固定资产列表信息的访问时间服务
	private IMonitorCountInfoService monitorCountInfoService;

	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	/**
	 * 盘点明细同步.
	 * 
	 * @author 195406 高春玲
	 * @date 2015-3-20 下午1:45:08
	 * @return
	 * @see
	 */
	public String synStocktaskingInfo() {
		// 返回结果
		Result<SynchronousStocktaskingInfo> res = new Result<SynchronousStocktaskingInfo>();
		// 返回json
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		String newStr = "";
		try {
			// 开始时间
			Date startDt = new Date();
			bu = ServletActionContext.getRequest().getReader();
			//编码转换
			newStr = java.net.URLDecoder.decode(StringUtil.bufferString(bu), "utf-8");
			logger.info("synStocktaskingInfo：固定资产扫描盘点前端所传参数为--"+newStr);
			if (!com.deppon.foss.framework.shared.util.string.StringUtil
					.isEmpty(newStr)) {
				info = JSONObject.parseObject(newStr,
						SynchronousStocktaskingInfo.class);
				if(info!=null){
					logger.info("synStocktaskingInfo：盘点单号："+info.getBillNo() + "的管理编码："+info.getManagementCode()+"--盘点扫描开始---");
				}
				String failReason = "";
				failReason = getFailReason(failReason);
				// 扫描同步信息完整 进行数据同步
				if ("".equals(failReason)) {
					if (StringUtils.isEmpty(info.getRemark())) {
						info.setRemark(" ");
					}
					String resString = synStocktaskingService
							.synStocktasking(info);

					ResponseParameterEntity<?> rpe = JSONObject.parseObject(
							resString, ResponseParameterEntity.class);

					if (rpe.isResultFlag()) {// 成功则返回1并判断是否返回实体
						res.setErrorCode(1);
						if (rpe.getResponseEntity() != null) {// 若实体不为空则返回实体

							SynchronousStocktaskingInfo syn = JSON.parseObject(
									rpe.getResponseEntity().toString(),
									SynchronousStocktaskingInfo.class);
							res.setData(syn);
						}
					} else {// 失败则返回0和失败原因
						res.setErrorCode(0);
						res.setErrorMessage(rpe.getFailureReason());
					}
				} else {
					res.setErrorCode(0);
					res.setErrorMessage(failReason);
				}

				// 结束时间
				Date endDt = new Date();

				// 保存到数据库
				monitorCountInfoService.saveMonitorCountInfo(userId, startDt,
						endDt, 2);
			}
			if(info!=null){
				logger.info("盘点单号："+info.getBillNo() + "的管理编码："+info.getManagementCode()+"--盘点扫描结束---");
			}
			writeToPage(response, res);
		} catch (Exception e) {
			if(info!=null){
				logger.info("synStocktaskingInfo：盘点单号："+info.getBillNo() + "的管理编码："+info.getManagementCode()+"盘点扫描调用LSP异常");
			}
			logger.info("synStocktaskingInfo：盘点扫描异常信息为"+e);
			e.printStackTrace();
			res.setErrorCode(-1);
			res.setErrorMessage("哎呀，请求出错，请稍后再试！");
			writeToPage(response, res);
		}
		return null;
	}

	private String getFailReason(String failReason) {
		if ("盘亏".equals(info.getStockStatus())
				&& (info.getRemark() == null || info.getRemark().trim()
						.equals(""))) {// 盘亏 填写备注
			failReason = "请填写备注信息";
			logger.info("del remark is null return");
		} else {
			if (StringUtils.isEmpty(info.getBillNo())
					|| (StringUtils.isEmpty(info.getManagementCode()) && StringUtils
							.isEmpty(info.getAssetCoding()))) {
				failReason = "盘点单信息为空，请重新扫描";
				logger.info("info is null return");
			} else {
				if (info.getOperateCode() < 2) {// 正常 和 新增时 数量不能为空
					if (StringUtils.isEmpty(info.getDifferencesNum())
							|| StringUtils.isEmpty(info.getRealNum())) {
						failReason = "数量信息为空，请重新扫描";
					}
				}
			}
		}
		return failReason;
	}

	public SynchronousStocktaskingInfo getInfo() {
		return info;
	}

	public void setInfo(SynchronousStocktaskingInfo info) {
		this.info = info;
	}

	public void setSynStocktaskingService(
			ISynStocktaskingService synStocktaskingService) {
		this.synStocktaskingService = synStocktaskingService;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}