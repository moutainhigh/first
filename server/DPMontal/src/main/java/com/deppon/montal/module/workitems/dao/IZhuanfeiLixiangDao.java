
    package com.deppon.montal.module.workitems.dao; 

import com.deppon.montal.model.CCZhuanfeiLixiang;
   /** 
 * @Title: IZhuanfeiLixiangDao.java
 * @Package com.deppon.montal.module.workitems.dao 
 * @Description: (专项费用立项申请工作流数据层) 
 * @author 廖建雄 
 * @date 2013-6-20 上午10:43:10 
 * @version V1.0 
 */
public interface IZhuanfeiLixiangDao {

    
       /** 
       * @Title: getLixiangInfo 
       * @Description:(获取专项费用立项申请工作流详细信息) 
       * @param @param processinstid
       * @return CCZhuanfeiLixiang 返回类型 
       * @throws 
       * @date 2013-6-20 上午10:46:20 
       */
    public CCZhuanfeiLixiang getLixiangInfo(String proccessinstid);
}

