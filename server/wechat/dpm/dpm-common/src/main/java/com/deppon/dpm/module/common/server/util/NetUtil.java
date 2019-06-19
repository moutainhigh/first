package com.deppon.dpm.module.common.server.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Net工具类
 * 
 */
public class NetUtil {
	/**
	 * 连接超时时间
	 */
	private static final int CONNECTTIMEOUT = 3000;
	
	/**
	 * 读取超时时间
	 */
	private static final int READTIMEOUT = 10000;
	
	/**
	 * 得到HTTP客户端对象 完成所有HTTP请求的工作
	 * 
	 * @return
	 */
	public static IHttpClient fetchHttpClient() {
		// 创建NetUtil对象
		NetUtil util = new NetUtil();
		// 返回HttpClient
		return util.getHttpClient();
	}

	/**
	 * get
	 * 
	 * @return
	 */
	private IHttpClient getHttpClient() {
		// 创建对象
		return new HttpClient();
	}

	private class HttpClient implements IHttpClient {
		// headers
		private Map<String, String> headers = new HashMap<String, String>();

		// url
		private URL url = null;

		// httpConn
		private HttpURLConnection httpConn = null;

		// in
		private InputStream in = null;

		// output
		private ByteArrayOutputStream output = null;

		// method
		private String method = "POST";

		// requestURL
		private String requestURL = null;

		// location
		private String location = null;

		// isReDirect
		private boolean isReDirect = false;

		// cookei
		private String cookei = null;

		/**
		 * set
		 */
		public void setCookie(String cookei) {
			this.cookei = cookei;
		}

		/**
		 * fetchCookie
		 */
		public String fetchCookie() {
			return this.httpConn.getHeaderField("Set-Cookie");
		}

		/**
		 * get
		 */
		public String getLocation() {
			return this.location;
		}

		/**
		 * getOutputStream
		 */
		public ByteArrayOutputStream getOutputStream() {
			return this.output;
		}

		/**
		 * isReDirect
		 */
		public boolean isReDirect() {
			return this.isReDirect;
		}

		/**
		 * setMethod
		 */
		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * setRequestURL
		 */
		public void setRequestURL(String requestURL) {
			this.requestURL = requestURL;
		}

		/**
		 * send
		 */
		public void send(String param) {
			send(param, null);
		}

		/**
		 * send
		 */
		public void send(String param, String enc) {
			try {
				this.url = new URL(this.requestURL);
				this.httpConn = ((HttpURLConnection) this.url.openConnection());
				this.httpConn.setInstanceFollowRedirects(false);
				this.httpConn.setDoOutput(true);
				this.httpConn.setRequestMethod(this.method);

				this.httpConn.setConnectTimeout(CONNECTTIMEOUT);
				this.httpConn.setReadTimeout(READTIMEOUT);
				if (this.cookei != null)
					this.httpConn.setRequestProperty("Cookie", this.cookei);
				addHead(this.httpConn);

				DataOutputStream dataOutputStream = new DataOutputStream(
						this.httpConn.getOutputStream());
				if (param == null)
					param = "";
				if (enc == null)
					dataOutputStream.writeBytes(param);
				else
					dataOutputStream.write(param.getBytes(enc));
				dataOutputStream.flush();
				dataOutputStream.close();

				this.location = this.httpConn.getHeaderField("location");
				if (this.location != null) {
					this.isReDirect = true;
					return;
				}
				this.in = this.httpConn.getInputStream();
				int chByte = 0;
				this.output = new ByteArrayOutputStream();
				chByte = this.in.read();
				while (chByte != -1) {
					this.output.write(chByte);
					chByte = this.in.read();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (this.output != null){
					try {
						this.output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (this.in != null){
					try {
						this.in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				this.httpConn.disconnect();
			}
		}

		/**
		 * addHead
		 */
		public void addHead(String name, String value) {
			this.headers.put(name, value);
		}

		/**
		 * addHead
		 * 
		 * @param httpconn
		 */
		@SuppressWarnings("rawtypes")
		private void addHead(HttpURLConnection httpconn) {
			Iterator keys = this.headers.keySet().iterator();
			while (keys.hasNext()) {
				String name = (String) keys.next();
				httpconn.setRequestProperty(name,
						(String) this.headers.get(name));
			}
		}
	}
}
