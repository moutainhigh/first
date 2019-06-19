package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.tongxunlu.server.dao.IExternalMethodDao;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.domain.MyConsumptionRequestEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

public class ExternalMethodService implements IExternalMethodService{
	
	private IExternalMethodDao externalMethodDao;
	public static final int NUMBER_OF_103 = 103;
	public static final int NUMBER_OF_104 = 104;

	/**
	 * 获取某一员工的领导的工号姓名
	 */
	public EmployeeVO getLeaderInfo(String empCode){
		
		EmployeeVO empinfo = new EmployeeVO();
		int orgid = 0;
		empinfo = externalMethodDao.getEmpInfo(empCode);
		OrganizationVO organization = getDeptByEmpcode(empCode);
		if(empinfo.getJobGroups().equals("管理族群")){
			/*String deptseq = externalMethodDao.getUpperOrg(empinfo.getOrgId());
			String orgs = deptseq.substring(1, deptseq.length()-1);
			String[] org = orgs.split("\\.");
			System.out.println(org);*/
			//管理族群
			//判断员工所在部门是否有高于他等级的管理层
			List<EmployeeVO> manager = externalMethodDao.
					getUpperManager(empinfo.getOrgId(), empinfo.getJobLevel());
			if(manager != null && manager.size() > 0){
				//同部门有此员工的领导
				orgid = empinfo.getOrgId();
			}else{
				//判断是否是部门管理员
				if(!empCode.equals(organization.getManagerId())){
					orgid = empinfo.getOrgId();
				}else{
					//同部门无此员工的领导，获取上一级部门的领导
					String parentorgid = externalMethodDao.getUpperOrg(empinfo.getOrgId());
					if(Integer.valueOf(parentorgid) != NUMBER_OF_103){
						orgid = Integer.valueOf(parentorgid);
					}else{
						orgid = NUMBER_OF_104;
					}	
				}
				
			}		
		}else{
			//非管理族群
			orgid = empinfo.getOrgId();
		}
		List<EmployeeVO> emplist = new ArrayList<EmployeeVO>();
		/*emplist = externalMethodDao.getLeaderInfo(orgid);
		if (emplist != null && emplist.size() > 0) {
			return emplist.get(0);
		}	*/	
		//若查出领导为空，再追溯到上一级领导
		String org = orgid + "";
		do{
			emplist = externalMethodDao.getLeaderInfo(Integer.valueOf(org));
			org = externalMethodDao.getUpperOrg(Integer.valueOf(org));
		}while(emplist == null || emplist.size() == 0);
		/*EmployeeVO result = new EmployeeVO();
		for(int i=0;i<emplist.size();i++){
			if(emplist.get(i).getEmpCode().equals(organization.getManagerId())){
				result = emplist.get(i);
			}
		}*/
		return emplist.get(0);
	}
	
	/**
	 * 根据工号或姓名搜索员工(员工姓名工号，部门id名称，头像地址)
	 */
	public List<EmployeeVO> getEmpInfolist(String employee){
		List<EmployeeVO> emplist = new ArrayList<EmployeeVO>();
		emplist = externalMethodDao.getEmpInfolist(employee);
		return emplist;
	}
	
	/**
	 * 根据工号获取部门信息
	 */
	public OrganizationVO getDeptByEmpcode(String empCode){
		
		return externalMethodDao.getDeptByEmpcode(empCode);
	}
	
	/**
	 * 查询普通员工部门信息、领导的部门信息+子部门信息
	 */
	public List<MyConsumptionRequestEntity> getDeptInfo(String empNo){
		List<MyConsumptionRequestEntity> mclist= new ArrayList<MyConsumptionRequestEntity>(); 
		MyConsumptionRequestEntity emp = externalMethodDao.getDept(empNo);
		    if(emp==null){
		    	return null;
		    }
			if(!emp.getJobGroups().equals("管理族群")){
				//非管理族群
				//存入该人的部门和人员信息
				mclist.add(emp);
				return mclist;
			}
		
		//管理族群
		/*emp.setOrder("1");
		mclist.add(emp);*/
		//查询子部门信息
		List<MyConsumptionRequestEntity> childorgs = externalMethodDao.getChildOrgs(emp.getDeptId());
		if(childorgs != null && childorgs.size() > 0 ){
			//1.存入该人的部门信息
			emp.setOrder("1");
			mclist.add(emp);
			//2.存入子部门的id名字和自定义级别

			//一次查询所有子部门的领导
            List<EmployeeVO> childLeader = externalMethodDao.getALLLeaderInfo(childorgs);
			for(MyConsumptionRequestEntity child : childorgs){
				child.setOrder("2");
				for(EmployeeVO employeeVO :childLeader){
					if(child.getDeptId().equals(employeeVO.getOrgId())){
						child.setLeaderCode(employeeVO.getEmpCode()); //放入工号
						child.setLeaderName(employeeVO.getEmpName()); //放入姓名
						child.setPictPath(employeeVO.getHeadPhoto()); //放入图片
						break;
					}
				}
				/*List<EmployeeVO> childLeader = externalMethodDao.getLeaderInfo(Integer.valueOf(child.getDeptId()));
				if(childLeader != null && childLeader.size() > 0){
					child.setLeaderCode(childLeader.get(0).getEmpCode()); //放入工号
					child.setLeaderName(childLeader.get(0).getEmpName()); //放入姓名
					child.setPictPath(childLeader.get(0).getHeadPhoto()); //放入图片
				}*/
				//4.存入子部门的所有子部门
				List<MyConsumptionRequestEntity> allchildlist = externalMethodDao.getAllChilddept(child.getDeptId());
				if(allchildlist != null && allchildlist.size() > 0){
					Map<String,String> map = new HashMap<String,String>();
					for(MyConsumptionRequestEntity perchild : allchildlist){
						map.put(perchild.getDeptId(), perchild.getDeptName());
					}
					child.setAllchilddep(map);
				}
				mclist.add(child);
			}		
		}else{
			//下面无子部门
			//1.存入该人的部门信息
			emp.setOrder("2");
			mclist.add(emp);
		}		
		//3.查询并存入同部门同层级人的信息（秘书，直属人员等）
		List<MyConsumptionRequestEntity> emps = externalMethodDao.getSameLevelEmp(emp.getDeptId(),empNo);
		if( emps != null ){
			for(MyConsumptionRequestEntity otheremp : emps){
				mclist.add(otheremp);
			}
		}
		return mclist;	
	}
	
	/**
	 * 根据部门id查询部门人数
	 */
	public int getOrgEmpNum(String orgname){
		String orgid = externalMethodDao.getOrgnameById(orgname);
		if(orgid != null && orgid != ""){
			int num = externalMethodDao.getEmpNum(orgid);
			if(num==0){
				return 0;
			}else{
				return num;
			}
			
		}
		return 0;
	}
	
	/**
	 * 判断是否有相同联系方式 
	 */
	public boolean getSameMobile (String mobileno){
		if(mobileno != null && mobileno !=""){
			int count = externalMethodDao.getSameMobile(mobileno);
			if( count > 0 ){
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据工号查询员工信息
	 * @param empCode
	 * @return
	 */
	public EmployeeVO getEmpInfo(String empCode){
		return externalMethodDao.getEmpInfo(empCode);
	}
	
	/**
	 * 根据手机号获取工号(无人车)
	 */
	public List<String> getEmpcodebyTel(List<String> moblist){

		return externalMethodDao.getEmpcodebyTel(moblist);
	}

	public IExternalMethodDao getExternalMethodDao() {
		return externalMethodDao;
	}

	public void setExternalMethodDao(IExternalMethodDao externalMethodDao) {
		this.externalMethodDao = externalMethodDao;
	}

}
