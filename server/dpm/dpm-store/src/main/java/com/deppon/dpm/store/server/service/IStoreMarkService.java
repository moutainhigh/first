package com.deppon.dpm.store.server.service;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreMark;
/**
 * 
 * @author XiaoTian
 *
 */
public interface IStoreMarkService {
	/**
	 * 添加打分数据
	 * @param record
	 * @return
	 */
	int insertSelective(List<StoreMark> record);

    /**
     * 
     * @param storeMark
     * @param taskid
     * @param dynamicsname
     * @param exeid
     * @return
     */
  //boolean insertMark(ArrayList<StoreMark> storeMark, String taskid, String dynamicsname,String exeid);
	boolean insertMark(ArrayList<StoreMark> storeMark, String exeid);
	
	/**
     * 循环查询所有模块是否打分
     */
    int selectList(List<StoreMark> record);
}
