package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;


/**
 * 提示消息类
 * @author gwl
 *
 */
public class MessageShowAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(KeepOnRecordAction.class);
	

	private IAddMessageService addmessageservice ;
	
	private int id;
	
	private String dept;
	
	/**
	 * 页码
	 */
	private int page;
	
	/**
	 * 每页条数
	 */
	private int pageSize;
	
	/**
	 * 构造方法
	 */
	public MessageShowAction(){
		super();
	}
	
	/*
	 * 查询人员所在部门的消息记录（含已读和未读）
	 */
	@CookieNotCheckedRequired
	public void queryMessage(){
//		//根据人员编码获取 部门
//		EmployeeEntity empentity = personIDService.queryPersonIDByID(userId);
		//根据部门得到消息记录
		List<PushMessageVO> msgList = addmessageservice.queryMessage(userId);
		//返回消息记录（包含消息状态）1List未读，2List已读
		JSONObject jonum = new JSONObject();
		if(msgList == null || msgList.size()==0){
			jonum.put("msgvos", "0");//0为未查到用户对应的消息
		}else{
			List<PushMessageVO> wlList = new ArrayList<PushMessageVO>();
			List<PushMessageVO> ylList = new ArrayList<PushMessageVO>();
			for(PushMessageVO temp : msgList){
				PushMessageVO pmvo = temp;
				pmvo.setId(temp.getId());
				pmvo.setBillno(temp.getBillno()==null?"":temp.getBillno());//订单号
				pmvo.setAbnormalrule(temp.getAbnormalrule()==null?"":temp.getAbnormalrule());//异常规则
				String state = temp.getState();
				if(state.equals("0")){
					wlList.add(pmvo);
				}else{
					ylList.add(pmvo);
				}
			}
			jonum.put("msgvos", "1");
			jonum.put("newmsg", wlList);//1List未读
			jonum.put("oldmsg", ylList);//2List已读
		}
//		outMessage(jonum);
		writeToPage(jonum);
		logger.debug("success");
//		List<String> str = new ArrayList<String>();
//		str.add("005565");
//		str.add("123456");
//		addmessageservice.insert(str, String.valueOf(dept));
		
	}
	
	/*
	 * 查询人员所在部门的消息记录（含已读和未读），分页
	 */
	@CookieNotCheckedRequired
	public void queryMessage4Pagination(){
		//根据部门得到消息记录
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("page", (page-1)*pageSize);//当页的第一条数据的序号,即pageStart
		params.put("pageSize", pageSize);
		List<PushMessageVO> msgList = addmessageservice.queryMessage4Pagination(params);
		params.put("state", "0");
		Integer unreadTotal = addmessageservice.queryMsgByUSERId4Total(params);
		
		//返回消息记录（包含消息状态）1List未读，2List已读
		JSONObject jonum = new JSONObject();
		jonum.put("unreadTotal", unreadTotal);
		if(msgList == null || msgList.size()==0){
			jonum.put("msgvos", "0");//0为未查到用户对应的消息
		}else{
			jonum.put("msgvos", "1");
			jonum.put("msgList", msgList);//全部消息
		}
		jonum.put("page", page);
		jonum.put("pageSize", pageSize);
		writeToPage(jonum);
		logger.debug("success");
		
	}
	
	/*
	 * 更新消息状态
	 */
	@CookieNotCheckedRequired
	public void updateMessage(){
		//点击消息，更新消息状态为已读0失败，1成功
		int aa = addmessageservice.updateMessage(String.valueOf(id));
		JSONObject jonum = new JSONObject();
		jonum.put("msg", aa);
		
		writeToPage(jonum);
		logger.debug("success");
//		outMessage(jonum);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
//	private void outMessage(JSONObject jsonobject){
//		// 返回页面数据
//		PrintWriter printwriter = null;
//		try {
//			HttpServletResponse response = ServletActionContext.getResponse();
//			// 设置响应类型
//			response.setContentType("text/html;charset=utf-8");
//			// 跨域设置
//			response.setHeader("Access-Control-Allow-Origin", "*");
//
//			// 获取一个printWriter对象
//			printwriter = response.getWriter();
//			// 打印,将null值输出为空字符串
//			printwriter.println(JSON.toJSONString(jsonobject,
//					SerializerFeature.WriteNullStringAsEmpty));
//		} catch (IOException e) {
//			// 错误打印
//			LOG.debug(e.getMessage());
//		} finally {
//			if (printwriter != null) {
//				printwriter.flush();
//				printwriter.close();
//			}
//		}
//		LOG.debug("success");
//	}
}
