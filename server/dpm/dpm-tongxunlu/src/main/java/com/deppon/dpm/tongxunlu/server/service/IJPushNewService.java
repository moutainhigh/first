package com.deppon.dpm.tongxunlu.server.service;

import java.util.List;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public interface IJPushNewService {
//	PushResult pushAll(JPushParam entity) throws APIConnectionException, APIRequestException;

	void pushByUserIds(JPushParam entity) throws APIConnectionException, APIRequestException;

	void pushByCondition(JPushParam entity) throws APIConnectionException, APIRequestException;

	List<OrganizationVO> queryPrimaryDept();

	int authSecret(String appKey, String masterSecret);

	void saveToMsgCentre(JPushParam entity, int i);
}
