package com.deppon.dpm.module.projecttools.test.servier;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.projecttools.server.service.IDppmCollectService;
import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;
import com.deppon.dpm.module.projecttools.test.BaseTestCase;

public class DppmCollectServiceTest extends BaseTestCase {
    private IDppmCollectService dppmCollectService;
    protected ApplicationContext appContext = null;
    
    /**
     * 执行测试方法之前调用
     */
    @Before
    public void setUp() throws Exception {
        //实例化spring 应用容器
        appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/projecttools/test/META-INF/spring.xml");
        //获取service实例
        this.dppmCollectService = (IDppmCollectService) appContext.getBean("dppmCollectService");
    }
    
    @Test
    public void collectInfoTest(){
        CollectVo vo = new CollectVo();
        try {
            //{"userCode":"051880","dppmCode":"227","isCollect":1,"dppmType":0}
            vo.setUserCode("051880");
            vo.setDppmCode("227");
            vo.setIsCollect(1);
            dppmCollectService.dppmCollect(vo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
