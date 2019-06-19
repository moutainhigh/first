/*package com.deppon.dpm.login.server.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.tongxunlu.shared.vo.Result;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 限制等级7以下不能登录
 *//*
@Deprecated
public class CheckBand7Interceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -1028453810469798032L;

	private DataSource dpmDataSource;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String doLogin = request.getParameter("doLogin");
		if (doLogin == null || doLogin.equals("false")) {
			return invocation.invoke();
		} else {
			String userId = request.getParameter("loginName");
			if (userId == null) {
				userId = request.getParameter("userId");
			}
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dpmDataSource);
			String sql = "select count(1) from om_employee t where now()<'2015-05-29 23:59:59' and t.joblevel is not null and (t.joblevel>=7 or t.JOBLEVEL ='D') and t.empcode="
					+ userId;
			int count = jdbcTemplate.queryForInt(sql);
			if (count > 0) {
				return invocation.invoke();
			} else {
				Result<Object> result = new Result<Object>();
				result.setErrorCode(1);
				result.setErrorMessage("等级7以下在 2015年5月30日之前限制使用移动办公");
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setContentType("text/html;charset=utf-8");
				PrintWriter writer = response.getWriter();
				if (writer != null) {
					writer.write(JSON.toJSONString(result));
					writer.close();
				}
				return null;
			}
		}
	}

	public DataSource getDpmDataSource() {
		return dpmDataSource;
	}

	public void setDpmDataSource(DataSource dpmDataSource) {
		this.dpmDataSource = dpmDataSource;
	}

}
*/