package com.deppon.dpm.doc.server.service;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.deppon.dpm.module.common.shared.vo.JPushParam;

public interface IDiDiJpushNewsService {
//	PushResult pushAll(JPushParam entity) throws APIConnectionException, APIRequestException;

	void pushByUserIds(JPushParam entity) throws APIConnectionException, APIRequestException;

//	void pushByCondition(JPushParam entity) throws APIConnectionException, APIRequestException;
//
//	List<OrganizationVO> queryPrimaryDept();
//
//	int authSecret(String appKey, String masterSecret);
//
//	void saveToMsgCentre(JPushParam entity, int i);
}
