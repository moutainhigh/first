package com.deppon.dpm.module.common.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.shared.vo.Result;

public class DecryptNewFile {
	
	/**
	 * 日志
	 */
	private static final Logger logger = Logger.getLogger(DecryptNewFile.class);
   
	/**
	 * jdbc 模板
	 */
	private static JdbcTemplate template;
	
	public static void delFile(String userId,String deviceType,String filename,File file){
		logger.info("新的解密开始----------commonfile，工号是："+userId);
		ServletOutputStream out = null;
		InputStream in = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			out = response.getOutputStream();
			//String decryptFile = FileDlpUtil.getDecryptFile(file.getPath());
			//File file_un = new File(decryptFile);
			in = new FileInputStream(file);
			String ext = filename.substring(filename.lastIndexOf("."))
					.toLowerCase();
			// 随机文件名，防多线程解同一文件名，需求对文件名不敏感
			String fileName = String
					.valueOf(new Random().nextInt(Integer.MAX_VALUE));
			File decryptFile = DlpCommonFiles.decryptFile(in, fileName, ext, deviceType);
			if (!decryptFile.exists()) {					
				out.write("40007".getBytes());
				return;
			}
			FileInputStream fis = new FileInputStream(decryptFile);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = fis.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			fis.close();
			// 文件删除
			file.delete();
			out.flush();
			attachmentMonitor("attachment");
		} catch (Exception e) {
			logger.error("新的附件解密失败>>>>工号"+userId, e);
			try {
				if(null != out){
					// 异常返回
					out.write("40007".getBytes());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}finally {
			// 释放资源
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 释放资源
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 附件查看次数监控
	 * 
	 * @param userId
	 * @return
	 */
	protected static String attachmentMonitor(String app_name) {
		// 返回值
		Result<Object> result = new Result<Object>();
		//判断是否为null
		if (StringUtils.isEmpty(app_name)) {
			return null;
		}
		// 更新数据库工号密码
		String update = "update attachment_monitor set down_load_count = down_load_count + 1, updatetime = now() "
				+ "where app_name = ?";
		//update 数据
		template.update(update, new Object[] {app_name},
				new int[] { Types.VARCHAR});
		// 返回值
		result.setData("附件查看次数+1保存成功");
		// 返回
		return JSON.toJSONString(result);
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
}
