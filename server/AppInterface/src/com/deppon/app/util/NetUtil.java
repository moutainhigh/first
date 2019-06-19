package com.deppon.app.util;

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
 * 
 * @author lin.liu
 *
 */
public class NetUtil {

	/**
	 * 得到HTTP客户端对�?
	 * 完成�?��HTTP请求的工�?
	 * 
	 * @return
	 */
	public static IHttpClient fetchHttpClient(){
		NetUtil util = new NetUtil();
		return util.getHttpClient();
	}
	
	private IHttpClient getHttpClient(){
		return new HttpClient();
	}
	
	private class HttpClient implements IHttpClient {
		private Map<String, String> headers = new HashMap<String, String>();

		private URL url = null;

		private HttpURLConnection httpConn = null;

		private InputStream in = null;

		private ByteArrayOutputStream output = null;

		private String method = "POST";

		private String requestURL = null;

		private String location = null;

		private boolean isReDirect = false;

		private String cookei = null;

		public void setCookie(String cookei) {
			this.cookei = cookei;
		}

		public String fetchCookie() {
			return this.httpConn.getHeaderField("Set-Cookie");
		}

		public String getLocation() {
			return this.location;
		}

		public ByteArrayOutputStream getOutputStream() {
			return this.output;
		}

		public boolean isReDirect() {
			return this.isReDirect;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public void setRequestURL(String requestURL) {
			this.requestURL = requestURL;
		}

		public void send(String param) {
			send(param, null);
		}

		public void send(String param, String enc) {
			try {
				this.url = new URL(this.requestURL);
				this.httpConn = ((HttpURLConnection) this.url.openConnection());
				this.httpConn.setInstanceFollowRedirects(false);
				this.httpConn.setDoOutput(true);
				this.httpConn.setRequestMethod(this.method);

				this.httpConn.setConnectTimeout(2000);
				if (this.cookei != null)
					this.httpConn.setRequestProperty("Cookie", this.cookei);
				addHead(this.httpConn);

				DataOutputStream dataOutputStream = new DataOutputStream(this.httpConn.getOutputStream());
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
				try {
					if (this.output != null)
						this.output.close();
					if (this.in != null)
						this.in.close();
					this.httpConn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		public void addHead(String name, String value) {
			this.headers.put(name, value);
		}

		private void addHead(HttpURLConnection httpconn) {
			Iterator keys = this.headers.keySet().iterator();
			while (keys.hasNext()) {
				String name = (String) keys.next();
				httpconn.setRequestProperty(name, (String) this.headers.get(name));
			}
		}
	}
}
