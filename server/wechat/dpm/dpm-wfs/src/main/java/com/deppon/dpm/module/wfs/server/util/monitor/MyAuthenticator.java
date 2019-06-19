package com.deppon.dpm.module.wfs.server.util.monitor;

import javax.mail.*;
/**
 * 邮件 根据用户名 密码进行身份验证
 * @author gcl
 */
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
}   