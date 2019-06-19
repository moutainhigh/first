package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.doc.server.dao.IPcKeepRecordDao;
import com.deppon.dpm.doc.server.vo.DiDiRecordVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class PcKeepRecordDao extends iBatis3DaoImpl implements IPcKeepRecordDao{

	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.pcRecordDao.";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryRecordAll(DiDiRecordVO diDiRecord,
			String starttime, String endtime) {
		//传入参数
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());//工号
		map.put("userName", diDiRecord.getUserName());//姓名
		map.put("dept", diDiRecord.getDept());//部门
		map.put("recordtime", diDiRecord.getRecordtime());//备案时间
		map.put("recordtype", diDiRecord.getRecordtype());//备案类型
		map.put("recordstate", diDiRecord.getRecordstate());//备案状态
		map.put("starttime", starttime);//开始时间
		map.put("endtime", endtime);//结束时间
		List<DiDiRecordVO> list = getSqlSession().selectList(NAME_SPACE+"queryRecord", map);
		if(list==null || list.size()==0){
			return null;
		}else{
			return list;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryAllDidiRecord() {
		List<DiDiRecordVO>  list=getSqlSession().selectList(NAME_SPACE+"queryAllDidiRecord");
		if(list==null || list.size()==0){
			return null;
		}else{
			for (int i = 0; i < list.size(); i++) {
				//拆分图片的字符串
				String recordpic = list.get(i).getRecordpic();
				if(StringUtils.isNotEmpty(recordpic)){
					String[] recordpicArray = recordpic.split(",");
					list.get(i).setRecordpicArray(recordpicArray);
				}else{
					String[] recordpicArray = new String[10];//返回一个空的数组
					list.get(i).setRecordpicArray(recordpicArray);
				}
				//设置备案状态
				String recordstate=list.get(i).getRecordstate();
				if(recordstate==null){
					list.get(i).setRecordstate(""); //为Null直接设置为空字符串
				}else{
					if(recordstate.equals("1")){
						list.get(i).setRecordstate("通过");
					}else if(recordstate.equals("2")){
						list.get(i).setRecordstate("不通过");
					}else{
						list.get(i).setRecordstate("待审核");
					}
				}
				//设置备案类型
				String recordtype=list.get(i).getRecordtype();
				if(recordtype==null){
					list.get(i).setRecordtype(""); //为Null直接设置为空字符串
				}else{
					if(recordtype.equals("1")){
						list.get(i).setRecordtype("系统异常");
					}else{
						list.get(i).setRecordtype("未配置预算");
					}
				}	
			}
			return list;
		}
		
	}
	/**
	 * 根据条件和起始位置进行查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiDiRecordVO> queryRecordByCondition(DiDiRecordVO diDiRecord,int requestbeginNum, String starttime, String endtime, int limit) {
		//传入参数
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", diDiRecord.getUserId());//工号
		map.put("userName", diDiRecord.getUserName());//姓名
		map.put("dept", diDiRecord.getDept());//部门
		map.put("recordtime", diDiRecord.getRecordtime());//备案时间
		map.put("recordtype", diDiRecord.getRecordtype());//备案类型
		map.put("recordstate", diDiRecord.getRecordstate());//备案状态
		map.put("starttime", starttime);//开始时间
		map.put("endtime", endtime);//结束时间
		map.put("requestbeginNum", requestbeginNum);//首条数据库位置
		map.put("limit", limit);//每页的条数
		List<DiDiRecordVO> list = getSqlSession().selectList(NAME_SPACE+"queryRecordByCondition", map);
		if(list==null || list.size()==0){
			return null;
		}else{
			for (int i = 0; i < list.size(); i++) {
				//设置图片,拆分成数组
				String recordpic = list.get(i).getRecordpic();
				if(StringUtils.isNotEmpty(recordpic)){
					String[] recordpicArray = recordpic.split(",");
					list.get(i).setRecordpicArray(recordpicArray);
				}else{
					String[] recordpicArray = new String[10];//返回一个空的数组
					list.get(i).setRecordpicArray(recordpicArray);
				}
				//设置备案状态
				String recordstate=list.get(i).getRecordstate();
				if(recordstate==null){
					list.get(i).setRecordstate(""); //为Null直接设置为空字符串
				}else{
					if(recordstate.equals("1")){
						list.get(i).setRecordstate("通过");
					}else if(recordstate.equals("2")){
						list.get(i).setRecordstate("不通过");
					}else{
						list.get(i).setRecordstate("待审核");
					}
				}
				//设置备案类型
				String recordtype=list.get(i).getRecordtype();
				if(recordtype==null){
					list.get(i).setRecordtype(""); //为Null直接设置为空字符串
				}else{
					if(recordtype.equals("1")){
						list.get(i).setRecordtype("系统异常");
					}else{
						list.get(i).setRecordtype("未配置预算");
					}
				}	
			}	
			return list;
		}
		
	}

	/**
	 * 删除UserId为空的
	 */
	@Override
	public void deleteByUserId() {
		getSqlSession().delete(NAME_SPACE+"deleteByUserId");
	}

}
