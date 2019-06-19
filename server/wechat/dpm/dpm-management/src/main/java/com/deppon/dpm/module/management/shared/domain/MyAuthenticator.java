package com.deppon.dpm.module.management.shared.domain;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @date 2015-08-26
 * @author 231586
 * 账号存储
 *
 */
public class MyAuthenticator extends Authenticator{
	/**
	 * 用户名
	 */
	String userName=null;    
    /**
     * 密码
     */
    String password=null;    
         
    /**
     * 构造方法
     */
    public MyAuthenticator(){    
    }    
    /**
     * @param username 用户名
     * @param password 密码
     */
    public MyAuthenticator(String username, String password) {      
        this.userName = username;      
        this.password = password;      
    }    
    //得到
    protected PasswordAuthentication getPasswordAuthentication(){    
        return new PasswordAuthentication(userName, password);    
    }  
}
