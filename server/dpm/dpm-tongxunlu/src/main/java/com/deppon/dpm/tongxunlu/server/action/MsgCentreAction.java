package com.deppon.dpm.tongxunlu.server.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.tongxunlu.server.service.IJpushMsgCentreService;
import com.deppon.dpm.tongxunlu.shared.domain.JpushMsgCentreEntity;

public class MsgCentreAction extends BaseAction{
	
	private static final Logger LOG = LoggerFactory.getLogger(MsgCentreAction.class);

	private IJpushMsgCentreService msgCentreService;
	
	public void queryMsg () {
		List<JpushMsgCentreEntity> list = new ArrayList<JpushMsgCentreEntity>();
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			EmployeeEntity employee = loginResult.getUserEntity().getEmployee();
			list = msgCentreService.queryMsgByEmp(employee);
		} catch (Exception e) {
			LOG.error("查询消息中心出错!!!",e);
		}
		writeToPage(list);
	}

	public void setMsgCentreService(IJpushMsgCentreService msgCentreService) {
		this.msgCentreService = msgCentreService;
	}
	
}
