
    package com.deppon.montal.module.workitems.service; 

import java.util.List;

import com.deppon.montal.model.OABaddebtApply;
import com.deppon.montal.model.OABaddebtChild;
   /** 
 * @Title: IOADaddebtService.java
 * @Package com.deppon.montal.module.workitems.service 
 * @Description: TODO(非业务类坏账申请service接口) 
 * @author yinrongping 
 * @date 2013-8-2 下午3:34:59 
 * @version V1.0 
 */
public interface IOABaddebtService {

	/**
	 * 
	   * @Title: getBaddebtApply 
	   * @Description:TODO(获取非业务类坏账申请信息) 
	   * @param @param processinstid
	   * @throws 
	   * @date 2013-8-2 上午11:08:27
	 */
	public OABaddebtApply getBaddebtApply(String processinstid);
	/**
	 * 
	   * @Title: getBaddebtChild 
	   * @Description:TODO(获取非业务类坏账申请详情)
	   * @date 2013-8-2 上午11:10:55
	 */
	public List<OABaddebtChild> getBaddebtChild(String processinstid);
}

