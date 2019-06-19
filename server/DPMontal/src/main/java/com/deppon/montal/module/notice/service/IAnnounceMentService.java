
    package com.deppon.montal.module.notice.service; 

import java.sql.Date;
import java.util.List;

import com.deppon.montal.model.OaAnnounceMent;
import com.deppon.montal.model.OaRollNews;
   /** 
 * @Title: IAnnounceMentService.java
 * @Package com.deppon.montal.module.notice.service 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-2-22 下午2:22:56 
 * @version V1.0 
 */
public interface IAnnounceMentService {
    /** 
     * @Title: queryAnnounceMentList 
     * @Description:(公告查询) 
     * @return List<OaAnnounceMent> 返回类型 
     * @throws 
     * @date 2013-2-21 上午8:52:23 
     */
    public List<OaAnnounceMent> queryAnnounceMentList(Long empId,String key,int pageNum,int pageSize);
    /** 
     * @Title: queryById 
     * @Description:(根据公告ID查询公告详细) 
     * @param @param ggId
     * @return OaAnnounceMent 返回类型 
     * @throws 
     * @date 2013-2-21 上午8:51:01 
     */
    public OaAnnounceMent queryById(String ggId);
    
    /**
     * 公告未读置已读
     * @param ggId
     * @param empId
     * @param empName
     */
    public void insertBulletinClick(String ggId,Long empId,String empName);
    
    
    /**
     * 查询图片新闻列表
     * @param empId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<OaRollNews>  queryRollnews(Long empId,int pageNum,int pageSize);
    
    /**
     * 查询图片新闻详情
     * @param ggid
     * @return
     */
    public OaRollNews getRollnewDetail(String ggid);
    
    /**
     * 压缩图片
     * @param startDate
     */
    public List<String> queryRollnewImage(Date startDate);
    /**
     * 查询图片新闻列表,包含详情图片
     * @param empId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<OaRollNews>  queryNewsList(Long empId,int pageNum,int pageSize);
    /**
     * 每一分钟查询一次图片列表并进行压缩
     * @param startDate
     * @param endDate
     * @return
     */
    public List<OaRollNews> queryNewsByDate(String startDate,String endDate);
}

