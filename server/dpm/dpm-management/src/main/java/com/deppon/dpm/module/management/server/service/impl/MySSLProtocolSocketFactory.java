package com.deppon.dpm.module.management.server.service.impl;

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
	 * sslcontext
	 */
	private SSLContext sslcontext = null;
	/**
	 * 创建SSLContext
	 * 
	 * @return
	 */
	private SSLContext createSSLContext() {
		// 定义
		SSLContext ssl = null;
		try {
			// 获取
			ssl = SSLContext.getInstance("SSL");
			// 初始化
			ssl.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
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
	 * get
	 * 
	 * @return
	 */
	private SSLContext getSSLContext() {
		if (this.sslcontext == null) {
			this.sslcontext = createSSLContext();
		}
		return this.sslcontext;
	}
	
	/**
	 * 创建socket
	 * 
	 * @param socket
	 * @param host
	 * @param port
	 * @param autoClose
	 * @return
	 * @throws IOException
	 */
	public Socket createSocket(Socket socket, String host, int port,
			boolean autoClose) throws IOException {
		// 创建
		return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
	}
	
	/**
	 * 创建socket
	 * 
	 * @param host
	 * @param port
	 */
	public Socket createSocket(String host, int port) throws IOException {
		// 创建
		return getSSLContext().getSocketFactory().createSocket(host, port);
	}

	/**
	 * 创建socket
	 */
	public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException {
		// 创建
		return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
	}

	/**
	 * 创建socket
	 */
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams params) throws IOException {
		// 参数为空
		if (params == null) {
			// 抛出异常
			throw new IllegalArgumentException("Parameters may not be null");
		}
		// 获取连接超时时间
		int timeout = params.getConnectionTimeout();
		// 获取cocket工厂
		SocketFactory socketfactory = getSSLContext().getSocketFactory();
		// 如果超时时间为0
		if (timeout == 0) {
			// 创建一个默认时间的socket
			return socketfactory.createSocket(host, port, localAddress, localPort);
		} else {
			// 获取socket
			Socket socket = socketfactory.createSocket();
			// 本地地址
			SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
			// 远程socket地址
			SocketAddress remoteaddr = new InetSocketAddress(host, port);
			// 绑定
			socket.bind(localaddr);
			// 连接，有失效时间
			socket.connect(remoteaddr, timeout);
			// 返回socket
			return socket;
		}
	}

	/**
	 * 自定义私有类
	 */
	private static class TrustAnyTrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}
}