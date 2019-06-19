package com.deppon.dpm.module.projecttools.test.servier;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.projecttools.server.service.IDppmResourcesPlanService;
import com.deppon.dpm.module.projecttools.test.BaseTestCase;

public class DppmResourcesPlanServiceTest  extends BaseTestCase {
    private IDppmResourcesPlanService dppmResourcesPlanService;
    protected ApplicationContext appContext = null;
    
    /**
     * 执行测试方法之前调用
     */
    @Before
    public void setUp() throws Exception {
        //实例化spring 应用容器
        appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/projecttools/test/META-INF/spring.xml");
        //获取service实例
        this.dppmResourcesPlanService = (IDppmResourcesPlanService) appContext.getBean("dppmResourcesPlanService");
    }
    
    @Test
    public void getDeptPeopleInfoTest(){
        try {
            dppmResourcesPlanService.getDeptPeopleInfo("061825", "2015-12");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
