package com.deppon.dpm.store.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.store.server.entity.StoreLike;
import com.deppon.dpm.store.server.entity.StoreLikelog;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.vo.StoreListVo;
/**
 * 榜单信息,榜单操作
 * @author XiaoTian
 *
 */
public interface IStoreListDao {

    /**
     * 查询所有榜单信息
     */
    List<StoreListVo> fineList(Map<String, Object> map);
    /**
     * 查询当前用户是否点赞或者警告
     */
    int fineCountlikeIf(Map<String, Object> map);
    /**
     * 修改用户点赞或者警告记录
     */
    int updateNum(Map<String, Object> map);
    /**
     * 添加log记录
     */
    int insertStorelog(StoreLikelog storeLikelog);
   
}	