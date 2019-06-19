
    package com.deppon.montal.module.workitems.service; 

import com.deppon.montal.model.RecommendExcellentEmp;

   /** 
   * @ClassName: IRecommendExcellentEmpService 
   * @Description:(优秀人才推荐数据层) 
   * @author 廖建雄 
   * @date 2013-8-21 上午9:11:24 
   * 
   */
public interface IRecommendExcellentEmpService {
    
    
    /** 
     * @Title: getrExcellentEmp 
     * @Description:(获取优秀人才推荐工作流详细) 
     * @param @param processinstid
     * @param @return 设定文件 
     * @returnRecommendExcellentEmp 返回类型 
     * @throws 
     * @date 2013-8-21 上午9:07:52 
     */
  public RecommendExcellentEmp getExcellentEmp(String processinstid);


}

