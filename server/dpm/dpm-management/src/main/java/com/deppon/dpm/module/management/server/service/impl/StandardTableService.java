package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IStandardTableDao;
import com.deppon.dpm.module.management.server.service.IStandardTableService;
import com.deppon.dpm.module.management.shared.domain.StandardTableEntity;

/**
 * 
 * @author 王亚男
 * 工程验收基础数据同步
 * 验收明细信息
 */
public class StandardTableService implements IStandardTableService {

	private static Logger logger = Logger.getLogger(StandardTableService.class);
	
	/**
	 * standardDao 
	 */
	@Resource
	private IStandardTableDao standardTableDao;
	
	/**
	 * 同步基础数据接口
	 */
	@Override
	public Response updateStandardTable(String json) {
		logger.info(json);
		try{
			logger.info("同步基础数据明细信息...数据:JSON is "+json);
			//解析同步的基础数据
			List<StandardTableEntity> list = JsonUtil.jsonToList(json, StandardTableEntity.class);
			//应该插入数据声明
			List<StandardTableEntity> insertTables = new ArrayList<StandardTableEntity>();
			//应该修改数据声明
			List<StandardTableEntity> updateTables = new ArrayList<StandardTableEntity>();
			//应该删除数据声明
			List<StandardTableEntity> deleteTables = new ArrayList<StandardTableEntity>();
			//查询已有数据
			List<StandardTableEntity> hasStandardList = this.standardTableDao.getStandardAll();
			Map<String,String> hasMap = new HashMap<String, String>();
			
			//HashMap 存入已存在数据
			for(StandardTableEntity en : hasStandardList){
				hasMap.put(en.getOrigItemCode(), en.getOrigItemCode());
			}
			//根据传的状态码 进行 数据的 	0-导入或 	1-修改	2-删除
			//遍历从PC推过来的数据
			for(StandardTableEntity table : list){
				//判断是否导入
				if("0".equals(table.getStatus())||"1".equals(table.getStatus())){
					//判断数据是否存在
					if(hasMap.containsKey(table.getOrigItemCode())){
						//存在数据 所有update
						updateTables.add(table);
					}else{
						//不存在 insert
						insertTables.add(table);
					}
				}else if("2".equals(table.getStatus())){
					//标记是删除  放入删除List
					//删除操作
					deleteTables.add(table);
				}
			}
			//插入数据
			if(insertTables.size()>0){
				//对数据操作
				this.standardTableDao.insertTable(insertTables);
			}
			//修改数据
			if(updateTables.size()>0){
				//对数据操作
				this.standardTableDao.updateTable(updateTables);
			}
			//删除 数据 (修改 数据 状态位)
			if(deleteTables.size()>0){
				//对数据操作
				this.standardTableDao.deleteStandardInfo(deleteTables);
			}
			//设置成功响应信息
			String re = "{\"status\":1,\"message\":\"Synchronous data success\"}";
			//设置 响应ESB 
			return Response.ok(re).header("ESB-ResultCode", "1").build();
		}catch (Exception e) {
			//系统异常
			logger.info("同步基础数据明细信息出现异常 has error");
			e.printStackTrace();
		}
		//返回异常信息
		String re =  "{\"status\":0,\"message\":\"Synchronous data fail\"}";
		//设置 响应ESB 
		return Response.ok(re).header("ESB-ResultCode", "1").build();
	}

	//getter
	public IStandardTableDao getStandardTableDao() {
		return standardTableDao;
	}
	
	//setter
	public void setStandardTableDao(IStandardTableDao standardTableDao) {
		this.standardTableDao = standardTableDao;
	}
	
	

}
