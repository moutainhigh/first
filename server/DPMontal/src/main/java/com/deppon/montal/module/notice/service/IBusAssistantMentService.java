
    package com.deppon.montal.module.notice.service; 

import java.util.List;

import com.deppon.montal.model.BusAssistantMent;
   /** 
 * @Title: IAnnounceMentService.java
 * @Package com.deppon.montal.module.notice.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-2-22 下午2:22:56 
 * @version V1.0 
 */
public interface IBusAssistantMentService {
    /** 
     * @Title: queryAnnounceMentList 
     * @Description:(小助手查询) 
     * @return List<OaAnnounceMent> 返回类型 
     * @throws 
     * @date 2013-2-21 上午8:52:23 
     */
    public List<BusAssistantMent> queryAssistantMentList(Long empId,String key,int pageNum,int pageSize);
    /** 
     * @Title: queryById 
     * @Description:(根据公告ID查询公告详细) 
     * @param @param ggId
     * @return OaAnnounceMent 返回类型 
     * @throws 
     * @date 2013-2-21 上午8:51:01 
     */
    public BusAssistantMent queryById(String ggId);
}

