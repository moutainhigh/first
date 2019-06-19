package com.deppon.dpm.module.common.server.service;

/**
 * Redis的偷取代码接口
 * @param <E>
 * @param <T>
 */
public interface Function<E,T> {
	// 回调方法
	public T callback(E e);
}
