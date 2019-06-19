package com.deppon.dpm.login.server.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * 登陆工具类，主要包含请求链接的方法封装.
 * 
 * @author 130126
 * 
 */
public class LoginUtil {
	// 内部类。
	private static class SingletonHolder {
		// 是final的，并且是静态的。
		public final static LoginUtil instance = new LoginUtil();
	}
	/**
	 * Constructor
	 */
	private LoginUtil() {
	}

	/**
	 * 单例
	 * 
	 * @return
	 */
	public static LoginUtil getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * 请求一个url返回结果.
	 * 
	 * @param url
	 *            请求链接
	 * @param encoding
	 *            编码格式.
	 * @return
	 //sonar 整改
	 * @throws IOException
	 */
	public String getUrl(String url, String encoding) {
		// 默认的client类。
		CloseableHttpClient client = HttpClients.createDefault();
		// 设置为get取连接的方式.
		HttpGet httpGet = new HttpGet(url);
		// 构建请求配置信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(MagicNumber.NUM3000) // 创建连接的最长时间
                .setConnectionRequestTimeout(MagicNumber.NUM500) // 从连接池中获取到连接的最长时间
                .setSocketTimeout(MagicNumber.NUM10000) // 数据传输的最长时间
                .setStaleConnectionCheckEnabled(true) // 提交请求前测试连接是否可用
                .build();
        // 设置请求配置信息
        httpGet.setConfig(config);
		InputStream instream = null;
		BufferedReader reader = null ;
		try {
			// 得到返回的response.
			HttpResponse response = client.execute(httpGet);
			// 得到返回的client里面的实体对象信息.
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 得到返回的主体内容.
				instream = entity.getContent();
				// 获取输入流
				reader = new BufferedReader(
						new InputStreamReader(instream, encoding));
				// 结果
				String result = reader.readLine();
				// 返回结果
				return result;
			}
		} catch (Exception e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			// 流不为空
			if(null != reader){
				try {
					// 关闭流
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 流不为空
			if(null != instream){
				try {
					// 关闭流
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				// 关闭连接.
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 返回
		return null;
	}
}
