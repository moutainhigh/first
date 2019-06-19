package com.deppon.dpm.module.management.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.ISendParcelService;
import com.deppon.dpm.module.management.shared.domain.KeyValueEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;

/**
 * @author 王亚男
 * 收发室包裹
 */
public class SendParcelAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6202329759862848820L;
	
	/**
	 * 包裹service
	 */
	private ISendParcelService sendParcelService;
	
	private Logger logger = LoggerFactory.getLogger(SendParcelAction.class);
	
	/**
	 * 包裹状态  代领
	 */
	private static final int STATUS_POST_REPLACE = 1;
	
	/**
	 * 包裹状态  自己领取
	 */
	private static final int STATUS_POST_SELF = 0;
	
	/**
	 * 获取包裹信息
	 * 已领取 ( 代领 或 自己领)
	 * 并没有分页
	 */
	public void getSendPage(){
		//设置响应头
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//声明并创建返回结果
		Result<List<KeyValueEntity>> result = new Result<List<KeyValueEntity>>();
		
		try{
			// 获取用户工号
			String userId = getUserId();
			logger.info("SEND userNo:"+userId);
			/*userId="01";*/
			List<ParcelEntity> list = this.sendParcelService.getParcelList(userId);
			List<KeyValueEntity> dataList = new ArrayList<KeyValueEntity>();
			Map<String,KeyValueEntity> dateMap = new HashMap<String, KeyValueEntity>();
			
			for(ParcelEntity en : list){
				//修改包裹PostStatus信息  根据登录名UserNo
				if(STATUS_POST_REPLACE == en.getPostStatus()){
					if(StringUtils.isNotEmpty(userId)){
						if(userId.equals(en.getUserNo())){
							en.setPostStatus(STATUS_POST_SELF);
						}
					}
				}
				//对包裹数据进行组装
				//主要是 时间
				String arr = en.getArriveDate();
				//到达时间不为空
				if(StringUtils.isNotBlank(arr)){
					//获取年月日 yyyy-mm-dd
					String date = arr.substring(0,arr.indexOf(" "));
					//判断该年月日是否已经存在
					if(dateMap.containsKey(date)){
						//得到某年月日的list并添加en
						dateMap.get(date).getList().add(en);
					}else{
						//重新放入map
						KeyValueEntity keyValueEntity = new KeyValueEntity();
						keyValueEntity.setValue(date);
						keyValueEntity.getList().add(en);
						dataList.add(keyValueEntity);
						dateMap.put(date, keyValueEntity);
					}
				}
			}
			//包裹总数
			result.setCount(list.size());
			result.setData(dataList);
		}catch (Exception e) {
			logger.info("has Error in getSendPage");
			e.printStackTrace();
			result.setErrorMessage("系统异常");
		}
		writeToPage(response,result);
	}

	public ISendParcelService getSendParcelService() {
		return sendParcelService;
	}

	public void setSendParcelService(ISendParcelService sendParcelService) {
		this.sendParcelService = sendParcelService;
	}
	
	

}
