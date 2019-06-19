package com.deppon.dpm.module.lsp.shared.domain;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

/**
 * author by lpp
 * 
 * created at 2010-7-26 上午09:29:33
 */
public class MySSLProtocolSocketFactory implements ProtocolSocketFactory {

	/**
	 * sslcontext 创建
	 */
	private SSLContext sslcontext = null;

	/**
	 * @return createSSLContext 方法
	 */
	private SSLContext createSSLContext() {
		// 定义
		SSLContext ssl = null;
		try {
			// 获取
			ssl = SSLContext.getInstance("SSL");
			// 初始化
			ssl.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new java.security.SecureRandom());
			// catch异常
		} catch (NoSuchAlgorithmException e) {
			// 打印异常
			e.printStackTrace();
			// catch异常
		} catch (KeyManagementException e) {
			// 打印异常
			e.printStackTrace();
		}
		// 返回初始化结果
		return ssl;
	}

	/**
	 * @return sslcontext 数据
	 */
	private SSLContext getSSLContext() {
		// 先判断这个对象是否为Null
		if (this.sslcontext == null) {
			this.sslcontext = createSSLContext();
		}
		// 返回对象数据
		return this.sslcontext;
	}

	/**
	 * @param socket
	 *            socket
	 * @param host
	 *            host
	 * @param port
	 *            port
	 * @param autoClose
	 *            autoClose
	 * @return
	 * @throws IOException
	 *             IOException
	 * @throws UnknownHostException
	 *             UnknownHostException
	 */
	public Socket createSocket(Socket socket, String host, int port,
			boolean autoClose) throws IOException {
		return getSSLContext().getSocketFactory().createSocket(socket, host,
				port, autoClose);
	}

	public Socket createSocket(String host, int port) throws IOException {
		return getSSLContext().getSocketFactory().createSocket(host, port);
	}

	public Socket createSocket(String host, int port, InetAddress clientHost,
			int clientPort) throws IOException {
		return getSSLContext().getSocketFactory().createSocket(host, port,
				clientHost, clientPort);
	}

	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams params) throws IOException {
		// 先判断对象是否为null
		if (params == null) {
			throw new IllegalArgumentException("Parameters may not be null");
		}
		// 得到时间
		int timeout = params.getConnectionTimeout();
		// 得到对象值
		SocketFactory socketfactory = getSSLContext().getSocketFactory();
		// 判断时间
		if (timeout == 0) {
			// 返回符合条件的数据
			return socketfactory.createSocket(host, port, localAddress,
					localPort);
		} else {
			// 得到 socket
			Socket socket = socketfactory.createSocket();
			// 得到 SocketAddress
			SocketAddress localaddr = new InetSocketAddress(localAddress,
					localPort);
			// new 一个新对象
			SocketAddress remoteaddr = new InetSocketAddress(host, port);
			// 塞入数据
			socket.bind(localaddr);
			// 塞入数据
			socket.connect(remoteaddr, timeout);
			// 返回socket
			return socket;
		}
	}

	// 自定义私有类
	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

}