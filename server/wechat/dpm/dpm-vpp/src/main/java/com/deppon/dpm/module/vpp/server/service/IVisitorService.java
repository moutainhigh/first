package com.deppon.dpm.module.vpp.server.service;

import java.io.IOException;

/**
 * 
 * 访客 Interface
 **/
public interface IVisitorService {
	/**
     * 访客预约保存
     */
	public String visitorAdd(String json) throws IOException ;
	public String visitorDel(String json) throws IOException;
	public String visitorQuery(String json) throws IOException;
}
