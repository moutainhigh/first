package com.deppon.dpm.module.common.server.util;

import com.deppon.dpm.module.common.shared.vo.LoginResult;

public class ThreadLocalUtil {
    
    private static final ThreadLocal<LoginResult>  THREADLOCAL = new ThreadLocal<LoginResult>();
    
    public static void setThreadLocal(LoginResult loginResult){
        THREADLOCAL.set(loginResult);
    }
    
    public static LoginResult getThreadLocal(){
        return (LoginResult)THREADLOCAL.get();
    }

}
