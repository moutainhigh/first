package com.deppon.dpm.module.wfs.server.util;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MethodTimeActive implements MethodInterceptor{

	/**
     * 自定义map集合，key：方法名，value：[0：运行次数，1：总时间]
     */
    //public static Map<String,Long[]> methodTest = new HashMap<String, Long[]>();
    private static Logger logger  = LoggerFactory.getLogger(MethodTimeActive.class);
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 创建一个计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start(); 
        // 执行方法
        Object object = invocation.proceed();
        // 计时器停止
        watch.stop();
        /*// 方法名称
        String methodName = invocation.getMethod().getName();
        // 获取计时器计时时间
        Long time = watch.getTime();
        if(methodTest.containsKey(methodName)) {
            Long[] x = methodTest.get(methodName);
            x[0]++;
            x[1] += time;
        }else{
            methodTest.put(methodName, new Long[] {1L,time});
        }*/
      //方法参数类型，转换成简单类型     
        Class[] params = invocation.getMethod().getParameterTypes();     
        String[] simpleParams = new String[params.length];     
        for (int i = 0; i < params.length; i++) {     
            simpleParams[i] = params[i].getSimpleName();     
        }     
        System.out.println("Takes:" + watch.getTime() + " ms ["    
                + invocation.getThis().getClass().getName() + "."    
                + invocation.getMethod().getName() + "("+StringUtils.join(simpleParams,",")+")] ");
        logger.info("WeaverWfsService方法时长:" + watch.getTime() + " ms ["    
                + invocation.getThis().getClass().getName() + "."    
                + invocation.getMethod().getName() + "("+StringUtils.join(simpleParams,",")+")] ");
        return object;
	}

}
