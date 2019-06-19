package com.deppon.dpm.module.projecttools.server.util;

import javax.mail.*;
/**
 * 邮件 根据用户名 密码进行身份验证
 * @author gcl
 */
public class MyAuthenticator extends Authenticator {
	// 用户名
    String userName = null;   
    // 密码
    String password = null;   
        
    public MyAuthenticator() {   
    }   
    // 构造方法
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication() {   
        return new PasswordAuthentication(userName, password);   
    }   
}   