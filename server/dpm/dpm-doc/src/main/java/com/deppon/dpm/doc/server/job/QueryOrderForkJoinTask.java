package com.deppon.dpm.doc.server.job;

import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.service.IDidiOrderService;

public class QueryOrderForkJoinTask extends RecursiveTask<List<DidiOrderEntity>>{
	
	private static final long serialVersionUID = 3640117631930491716L;
	
	static final int THRESHOULD = 10000;
	
	private int queryStart;
	
	private int queryEnd;
	
	private List<Map<String,String>> queryList;
	
	private IDidiOrderService didiOrderService;
	
	public QueryOrderForkJoinTask(){}
	
	public QueryOrderForkJoinTask(IDidiOrderService didiOrderService,List<Map<String,String>> queryList){
		this.didiOrderService = didiOrderService;
		this.queryList = queryList;
		this.queryStart = 0;
		this.queryEnd = this.queryList.size();
	}
	
	public QueryOrderForkJoinTask(IDidiOrderService didiOrderService,List<Map<String,String>> queryList,int start,int end){
		this.didiOrderService = didiOrderService;
		this.queryList = queryList;
		this.queryStart = start;
		this.queryEnd = end;
	}

	/**
	 * 实际计算方法
	 * 分布查询欢行打车订单
	 * */
	@Override
	protected List<DidiOrderEntity> compute() {
		
		if(queryEnd-queryStart<THRESHOULD){
			List<DidiOrderEntity> orders = didiOrderService.dateOrderByOrderIds(queryList.subList(queryStart, queryEnd));
			return orders;
		}
		
		int middle = (queryEnd+queryStart)/2;
		QueryOrderForkJoinTask taskHead = new QueryOrderForkJoinTask(didiOrderService,queryList,queryStart,middle);
		QueryOrderForkJoinTask taskTail = new QueryOrderForkJoinTask(didiOrderService,queryList,middle,queryEnd);
		
		invokeAll(taskHead, taskTail);
		
		List<DidiOrderEntity> ordersHead = taskHead.join();
		List<DidiOrderEntity> ordersTail = taskTail.join();
		
		ordersHead.addAll(ordersTail);
		
		return ordersHead;
	}

	public IDidiOrderService getDidiOrderService() {
		return didiOrderService;
	}

	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}

	public List<Map<String, String>> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<Map<String, String>> queryList) {
		this.queryList = queryList;
	}

	public int getQueryStart() {
		return queryStart;
	}

	public void setQueryStart(int queryStart) {
		this.queryStart = queryStart;
	}

	public int getQueryEnd() {
		return queryEnd;
	}

	public void setQueryEnd(int queryEnd) {
		this.queryEnd = queryEnd;
	}

}
