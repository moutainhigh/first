
    package com.deppon.montal.module.workitems.dao; 

import java.util.List;

import com.deppon.montal.model.OABusinessBaddebtbill;
import com.deppon.montal.model.OABusinessBaddebtleaf;
import com.deppon.montal.model.OABusinessBaddebts;
 

   /** 
   * @ClassName: IOABusinessBaddebtsDao 
   * @Description:(业务类坏账申请数据层) 
   * @author 廖建雄 
   * @date 2013-8-5 下午2:07:53 
   * 
   */
public interface IOABusinessBaddebtsDao {
    
    
       /** 
       * @Title: getBusinessBaddebts 
       * @Description:(业务类坏账申请工作流详细) 
       * @param processinstid
       * @return OABusinessBaddebts 返回类型 
       * @throws 
       * @date 2013-8-5 下午2:07:53        
       */
    public OABusinessBaddebts getBusinessBaddebts(String processinstid);
    
       /** 
       * @Title: getBaddebtbills 
       * @Description:(业务类坏账申请工作流坏账表单明细) 
       * @param @param processinstid
       * @param @return 设定文件 
       * @returnList<OABusinessBaddebtbill> 返回类型 
       * @throws 
       * @date 2013-8-5 下午2:13:23 
       */
    public List<OABusinessBaddebtbill> getBaddebtbills(String processinstid);
    /** 
     * @Title: getBaddebtleafs 
     * @Description:(业务类坏账申请工作流责任明细) 
     * @param @param processinstid
     * @param @return 设定文件 
     * @returnList<OABusinessBaddebtleaf> 返回类型 
     * @throws 
     * @date 2013-8-5 下午2:13:23 
     */
    public List<OABusinessBaddebtleaf> getBaddebtleafs(String processinstid);
}

