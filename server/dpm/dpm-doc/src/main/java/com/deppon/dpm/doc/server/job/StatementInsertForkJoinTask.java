package com.deppon.dpm.doc.server.job;

import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.dao.IFileDao;

public class StatementInsertForkJoinTask extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 3640117631930491716L;
	
	static final int THRESHOULD = 2000;
	
	private int queryStart;
	
	private int queryEnd;
	
	private List<Map<String,String>> queryList;
	
	private IFileDao fileDao;
	
	private boolean isMatched;
	
	private static final Logger LOG = LoggerFactory.getLogger(StatementInsertForkJoinTask.class);
	
	public StatementInsertForkJoinTask(){}
	
	public StatementInsertForkJoinTask(IFileDao fileDao,List<Map<String,String>> queryList,boolean isMatched){
		this.fileDao = fileDao;
		this.queryList = queryList;
		this.queryStart = 0;
		this.queryEnd = this.queryList.size();
		this.isMatched = isMatched;
	}
	
	public StatementInsertForkJoinTask(IFileDao fileDao,List<Map<String,String>> queryList,int start,int end,boolean isMatched){
		this.fileDao = fileDao;
		this.queryList = queryList;
		this.queryStart = start;
		this.queryEnd = end;
		this.isMatched = isMatched;
	}

	/**
	 * 实际计算方法
	 * 分布查询欢行打车订单
	 * */
	@Override
	protected Integer compute() {
		try {

			if(queryEnd-queryStart<THRESHOULD){
				
				int result = 0;
				if(isMatched){
					result=fileDao.addStatement(queryList.subList(queryStart, queryEnd));
					LOG.error("【匹配的】对账数据提交条数:>>>>>"+result);
				}else{
					result=fileDao.addStatement2(queryList.subList(queryStart, queryEnd));
					LOG.error("【未匹配的】对账数据提交条数:>>>>>"+result);
				}
				return result;
			}
			
			int middle = (queryEnd+queryStart)/2;
			StatementInsertForkJoinTask taskHead = new StatementInsertForkJoinTask(fileDao,queryList,queryStart,middle,isMatched);
			StatementInsertForkJoinTask taskTail = new StatementInsertForkJoinTask(fileDao,queryList,middle,queryEnd,isMatched);
			
			invokeAll(taskHead, taskTail);
			
			int ordersHead = taskHead.join();
			int ordersTail = taskTail.join();
			
			return ordersHead + ordersTail;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("对账数据提交条数:>>>>>"+e.getMessage());
			return -1;
		}
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

	public IFileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(IFileDao fileDao) {
		this.fileDao = fileDao;
	}

	public boolean isMatched() {
		return isMatched;
	}

	public void setMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}

}
