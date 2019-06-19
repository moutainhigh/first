package com.deppon.dpm.module.common.server.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程回调和执行线程
 * 
 * @author 245968
 * 
 */
public class ThreadCallBack {

	/**
	 * 线程池定义
	 */
	private static ExecutorService executorService;

	/**
	 * Constructor
	 */
	private ThreadCallBack() {

	}

	/**
	 * 静态代码块
	 */
	static {
		executorService = Executors.newFixedThreadPool(MagicNumber.NUM20);
	}

	/**
	 * 执行线程获得返回结果
	 */
	public static <T> Future<T> call(Callable<T> runnable) throws Exception {
		return executorService.submit(runnable);
	}

	/**
	 * 执行线程
	 */
	public static void run(Runnable runnable) {
		executorService.execute(runnable);
	}
}
