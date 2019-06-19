package com.deppon.dpm.module.management.server.service.impl;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.WebCredentials;
import microsoft.exchange.webservices.data.WellKnownFolderName;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.shared.domain.EmailErrorLog;
import com.deppon.dpm.module.management.shared.exception.EmailNullPointException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordErrorException;
import com.deppon.dpm.module.management.shared.exception.EmailPasswordNullPointException;
import com.deppon.dpm.module.management.util.DES;

/**
 * 邮箱
 *
 */
public class OutlookService {

	/**
	 * 日志
	 */
	protected static Logger logger = Logger.getLogger(OutlookService.class);

	/**
	 * jdbc
	 */
	protected JdbcTemplate jdbcTemplate;

	/**
	 * 将二进制流转换成文件，存放到磁盘上的ip和端口
	 */
	protected String serverHostPort;

	/**
	 * 邮件服务器域名
	 */
	protected String host;

	/**
	 * set
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * set
	 * 
	 * @param serverHostPort
	 */
	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}

	/**
	 * set
	 * 
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 验证用户名和密码
	 */
	public boolean validatePassword(String password, String email) {
		try {
			//new 一个新的service
			ExchangeService service = new ExchangeService(
					ExchangeVersion.Exchange2010_SP1);
			//new 一个新的credentials
			ExchangeCredentials credentials = new WebCredentials(email,
					new String(Base64.decodeBase64(DES.decryptDES(password))));
			//set 数据
			service.setCredentials(credentials);
			//set 数据
			service.setUrl(new URI(host));
			Folder.bind(service, WellKnownFolderName.Calendar);
			return true;
		} catch (Exception e) {
			//捕获异常
			logger.info(e.getMessage());
			return false;
		}
	}

	/**
	 * 保存邮箱账号密码，方便下次访问outlook不再需要输入邮箱密码
	 */
	public String insertOrUpdateEmail(String userId, String password) {
		// 返回值
		Result<Object> result = new Result<Object>();
		// 根据工号获取邮箱
		String queryEmail = "select * from om_employee where EMPSTATUS = 'on' and empcode = '"
				+ userId + "'";
		// sql执行返回邮箱
		String email = jdbcTemplate.query(queryEmail,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("oemail");
						}
						return null;
					}
				});
		// 判断是否绑定邮箱
		if (StringUtils.isEmpty(email)) {
			result.setErrorCode(2);
			result.setData("该工号没有邮箱");
			return JSON.toJSONString(result);
		}
		// outlook邮箱密码验证
		boolean flag = validatePassword(password, email);
		//判断邮箱密码是否正确
		if (!flag) {
			//set 数据
			result.setErrorCode(MagicNumber.NUM3);
			//set 数据
			result.setErrorMessage("验证邮箱密码失败");
			//返回json格式的数据
			return JSON.toJSONString(result);
		}
		// 邮箱密码配置表
		String query = "select * from om_email_config where user_id = "
				+ userId;
		try {
			// sql执行获取配置表的工号
			String dpmUserId = jdbcTemplate.query(query,
					new ResultSetExtractor<String>() {
						@Override
						public String extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							while (rs.next()) {
								return rs.getString("user_id");
							}
							return null;
						}
					});
			// 工号为空，向数据库插入工号，密码
			if (StringUtils.isEmpty(dpmUserId)) {
				String insert = "insert into om_email_config values (?,?,now())";
				jdbcTemplate.update(insert, new Object[] { userId, password },
						new int[] { Types.VARCHAR, Types.VARCHAR });
			} else {
				// 更新数据库工号密码
				String update = "update om_email_config set email_password =? where user_id=?";
				//update 数据
				jdbcTemplate.update(update, new Object[] { password, userId },
						new int[] { Types.VARCHAR, Types.VARCHAR });
			}
			// 返回值
			result.setData("邮箱密码保存成功");
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			logger.error("邮件：" + email + ", 密码：" + password + e.getMessage());
			result.setErrorCode(1);
			result.setData("验证邮箱失败");
		}
		// 返回
		return JSON.toJSONString(result);
	}

	/**
	 * 通过邮箱和邮箱密码绑定exchage server
	 */
	public ExchangeService getExchangeService(String userId) throws Exception {
		//根据工号得到email
		String email = getEmail(userId);
		//判断参数是否为null
		if (StringUtils.isEmpty(email)) {
			//如果为null 抛出
			throw new EmailNullPointException(userId + "邮箱不存在");
		}
        //得到用户密码
		String password = getPassword(userId);
		//判断用户密码是否为null
		if (StringUtils.isEmpty(password)) {
			//密码不存在抛出
			throw new EmailPasswordNullPointException("密码不存在");
		}

		try {
			//得到密码
			password = new String(Base64.decodeBase64(DES.decryptDES(password)));
		} catch (Exception e) {
			//异常处理
			throw new EmailPasswordErrorException("密码错误");
		}
        //new 一个新的 service
		ExchangeService service = new ExchangeService(
				ExchangeVersion.Exchange2010);
		ExchangeCredentials credentials = new WebCredentials(email, password);
	   //塞入数据
		service.setCredentials(credentials);
		service.setUrl(new URI(host));
		//返回结果数据
		return service;
	}

	/**
	 * 根据工号获取邮箱地址
	 */
	private String getEmail(String userId) {
		//判断工号是否为null
		if (StringUtils.isEmpty(userId))
			return null;
		//写sql语句
		String queryEmail = "select * from om_employee where EMPSTATUS = 'on' and empcode = '"
				+ userId + "'";
		//执行sql
		String email = jdbcTemplate.query(queryEmail,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("oemail");
						}
						return null;
					}
				});
		//返回email
		return email;
	}

	/**
	 * 根据工号获取配置表的邮箱密码
	 * 
	 * @param userId
	 * @return
	 */
	protected String getPassword(String userId) {
		//判断工号是否为null
		if (StringUtils.isEmpty(userId)) {
			return null;
		}
        //写sql
		String sql = "select * from om_email_config where user_id = '" + userId
				+ "'";
		//jdbc执行
		String password = jdbcTemplate.query(sql,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("email_password");
						}
						return null;
					}
				});
		//返回密码
		return password;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getServerHostPort() {
		return serverHostPort;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 获取邮件存放的路径
	 */
	protected String getRelativePath() {
		return "/dpmfile/emailattachment/";
	}

	/**
	 * 获取邮件列表出错时，将错误信息保存到数据库
	 */
	protected void insertError(EmailErrorLog emailErrorLog) {
		try {
			//写入sql
			String sql = "insert into om_email_error_log (id,user_id,password,error_message,create_time) values(?,?,?,?,now())";
			//执行sql
			jdbcTemplate.update(
					sql,
					new Object[] { UUID.randomUUID().toString(),
							emailErrorLog.getUserId(),
							emailErrorLog.getPassword(),
							emailErrorLog.getErrorMessage() }, new int[] {
							Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
							Types.VARCHAR });
		} catch (DataAccessException e) {
			//异常处理
			e.printStackTrace();
		}
	}

}
