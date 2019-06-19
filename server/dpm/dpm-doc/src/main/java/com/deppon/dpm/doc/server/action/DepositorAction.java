package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IDepositorService;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.LoginResult;
/**
 * @className:DepositorAction
 * @author lvdf
 * @date:2018年3月2日14:13:15
 * @Desciption:TODO(公款存户Action)
 */
public class DepositorAction extends BaseAction {

	
	private static final long serialVersionUID = 4420599423758431543L;
	
	//公款存户service
	private IDepositorService depositorService;
	
	// 查询服务接口
	private IPersonIDService personIDService;
	
	//持卡人
	private String cardHolder;
	
	//对公账号
	private String bankCardNumber;
	
	//用户id
	private String userId;
	
	private String id ;

	/**
	 * @Desciption:TODO(新增对公账号)
	 * @author lvdf
	 * @date 2018年3月2日14:39:11
	 */
	public void publicMoneyDepositor(){
		JSONObject jonum = new JSONObject();
		com.deppon.dpm.module.common.shared.vo.LoginResult loginResult = ThreadLocalUtil
				.getThreadLocal();
		String orgName = loginResult.getUserEntity().getEmployee().getOrgName();
		
		// 根据员工号查询员工身份信息
		EmployeeEntity empentity1 = personIDService.queryPersonIDByID(userId);
		
		String userdept = empentity1.getOrgName();
		
		if(userdept!=null&&orgName!=null&&!orgName.equals(userdept)){
			jonum.put("error", -1);
			jonum.put("msg", "部门错误");
	        writeToPage(jonum);
	        return;
		}



		if (ParamUtils.checkUserId(userId)) {
			jonum.put("error", -2);
			jonum.put("msg", "工号错误，不符合规范");
			writeToPage(jonum);
			return;
		}
		if(StringUtils.isNotEmpty(userId)){
			// 根据员工号查询员工身份信息
			EmployeeEntity empentity = personIDService.queryPersonIDByID(userId);
			if(empentity!=null){
				//员工信息存在时查询部门部门名称
				String OrgName = empentity.getOrgName();// 部门名称
				//封装VO
				DidiBankCardVO didiBankCardvo = new DidiBankCardVO();
				didiBankCardvo.setUserId(userId);
				didiBankCardvo.setCardHolder(cardHolder);
				didiBankCardvo.setBankCardNumber(bankCardNumber);
				didiBankCardvo.setUserDept(OrgName);
				//新增对公账号
				int i=depositorService.insertAccount(didiBankCardvo);
				if(i == 0){
					jonum.put("error", i);
					jonum.put("msg", "同事您好，该账号已被其他部门绑定，请确认填写是否正确");
				}else{
					jonum.put("error", i);
					jonum.put("msg", "新增成功");	
				}
				writeToPage(jonum);
			}else{
				jonum.put("msg", "该员工没有部门");	
				writeToPage(jonum);
			}		
		}else{
			jonum.put("msg", "新增失败,员工号为空");	
			writeToPage(jonum);
		}
		
	}
	
	
	/**
	 * @Desciption:TODO(根据部门查询账号)
	 * @author lvdf
	 * @date:2018年3月7日13:55:26
	 */
	public void queryDepositorByDept(){
		JSONObject jonum = new JSONObject();
		com.deppon.dpm.module.common.shared.vo.LoginResult loginResult = ThreadLocalUtil
				.getThreadLocal();
		String orgName = loginResult.getUserEntity().getEmployee().getOrgName();
		// 根据员工号查询员工身份信息
		EmployeeEntity empentity1 = personIDService.queryPersonIDByID(userId);
		String userdept = empentity1.getOrgName();
		if(userdept!=null&&orgName!=null&&!orgName.equals(userdept)){
			jonum.put("error", -1);
			jonum.put("msg", "部门错误");
	        writeToPage(jonum);
	        return;
		}


		if(ParamUtils.checkUserId(userId)){
			jonum.put("error", -2);
			jonum.put("msg", "工号错误，不符合规范");
	        writeToPage(jonum);
	        return;
	       }
		if(StringUtils.isNotEmpty(userId)){
			// 根据员工号查询员工身份信息
			EmployeeEntity empentity = personIDService.queryPersonIDByID(userId);
			if(empentity!=null){
				String OrgName = empentity.getOrgName();// 部门名称
				//根据部门名称查询全部对公账号
				List<DidiBankCardVO> list=depositorService.queryByDeptName(OrgName);
				//银行账号List
				List<String> bandcardnumList  = new ArrayList<String>();
				for(DidiBankCardVO temp : list){
					if(!"".equals(temp.getBankCardNumber()==null?"":temp.getBankCardNumber())){
						bandcardnumList.add(temp.getBankCardNumber());
					}
				}
				
				if(list.size()!=0){
					jonum.put("time", System.currentTimeMillis());
					jonum.put("bankcardList", bandcardnumList);
					jonum.put("msg", "对公账号查询成功");
					writeToPage(jonum);
				}else{
					jonum.put("time", System.currentTimeMillis());
					jonum.put("bankcardList", bandcardnumList);
					jonum.put("msg", "该部门没有对公账号");
					writeToPage(jonum);
				}	
			}
			
		}else{
			jonum.put("time", System.currentTimeMillis());
			jonum.put("msg", "员工号不能为空");
		}
		
	}
	
	/**
	 * @Desciption:TODO(删除账号)
	 */
	public void deleteCarNumberById(){
		JSONObject jonum = new JSONObject();
		com.deppon.dpm.module.common.shared.vo.LoginResult loginResult = ThreadLocalUtil
				.getThreadLocal();
		String orgName = loginResult.getUserEntity().getEmployee().getOrgName();
		// 根据员工号查询员工身份信息
		EmployeeEntity empentity1 = personIDService.queryPersonIDByID(userId);
		String userdept = empentity1.getOrgName();
		if(userdept!=null&&orgName!=null&&!orgName.equals(userdept)){
			jonum.put("error", -1);
			jonum.put("msg", "部门错误");
	        writeToPage(jonum);
	        return;
		}
		
		
		if(id!=null && !"".equals(id)){
			
			int aa = depositorService.delete(id);
			if(aa == 0){
				jonum.put("error", aa);
				jonum.put("msg", "删除失败,数据库中不存在该ID");
			}else{
				jonum.put("error", aa);
				jonum.put("msg", "删除成功");	
			}
		}
		writeToPage(jonum);
	}
	
	public IDepositorService getDepositorService() {
		return depositorService;
	}

	
	public void setDepositorService(IDepositorService depositorService) {
		this.depositorService = depositorService;
	}

	
	public String getBankCardNumber() {
		return bankCardNumber;
	}


	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public IPersonIDService getPersonIDService() {
		return personIDService;
	}


	public void setPersonIDService(IPersonIDService personIDService) {
		this.personIDService = personIDService;
	}


	public String getCardHolder() {
		return cardHolder;
	}


	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
