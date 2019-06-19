package com.deppon.dpm.module.common.server.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.foss.framework.server.web.action.AbstractAction;

/**
 * 用以规范返回数据给前端的公共方法 注释添加
 * 
 * @date 2015-09-25
 * @author 231586
 * 
 */
public class BaseAction extends AbstractAction {

	private static final long serialVersionUID = 7553099065733474191L;

	// 工号
	public String userId;
	// token验证
	public String token;

	/**
	 * 结果集是Result对象
	 * 
	 * @param response
	 * @param result
	 */
	protected void writeToPage(HttpServletResponse response, Result<?> result) {
		// 定义输出流
		PrintWriter writer = null;
		try {
			if (response == null) {
				response = ServletActionContext.getResponse();
			}
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印,将null值输出为空字符串
			writer.write(JSON.toJSONString(result,SerializerFeature.WriteNullStringAsEmpty));
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}

	/**
	 * 结果集是object对象
	 * 
	 * @param result
	 */
	protected void writeToPage(Object result) {
		// 定义输出流
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印,将null值输出为空字符串
			writer.write(JSON.toJSONString(result,
					SerializerFeature.WriteNullStringAsEmpty));
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}

	/**
	 * 字符串结果集
	 * 
	 * @param result
	 */
	protected void writeToPage(String result) {
		// 输出
		writeToPage(null, result);
	}

	/**
	 * 字符串结果集
	 * 
	 * @param response
	 * @param result
	 */
	protected void writeToPage(HttpServletResponse response, String result) {
		// 定义输出流
		PrintWriter writer = null;
		try {
			if (response == null) {
				response = ServletActionContext.getResponse();
			}
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印
			writer.write(result);
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}
	
	// get
	public String getToken() {
		return token;
	}

	// set
	public void setToken(String token) {
		this.token = token;
	}

	// get
	public String getUserId() {
		return userId;
	}

	// set
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
