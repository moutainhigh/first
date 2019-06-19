package com.deppon.dpm.tongxunlu.server.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deppon.dpm.tongxunlu.server.dao.ISelectAllDeptDao;
import com.deppon.dpm.tongxunlu.server.dao.impl.SelectAllDeptDao;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.OrgMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectNameAndPicVO;
import com.deppon.dpm.tongxunlu.shared.vo.DeptMappingVO;

/**
 * 智慧门店查询所有相关部门信息
 * 
 * @author RY
 *
 */
public class SelectAllDeptService implements ISelectAllDeptService {
	// 注入DAO
	private ISelectAllDeptDao selectAllDeptDao;

	@Override
	// 智慧门店查询所有相关部门信息
	public List<SelectAllDeptEntity> selectAllDept(String JOBNAME,String PARENTORGID) {
		if(PARENTORGID!=null && !"".equals(PARENTORGID)){
			// 智慧门店查询所有相关部门信息
			return selectAllDeptDao.selectAllDept("",PARENTORGID);
		}else{
			// 智慧门店查询所有相关部门信息
			return selectAllDeptDao.selectAllDept(JOBNAME,PARENTORGID);
		}
	}

	// 智慧门店根据工号查询所有相关部门信息
	@Override
	public SelectAllDeptEntity selectAllDeptByempcode(String empCode) {
		// 智慧门店根据工号查询所有相关部门信息
		return selectAllDeptDao.selectAllDeptByempcode(empCode);
	}

	/**
	 * 
	 * @return
	 */
	public ISelectAllDeptDao getSelectAllDeptDao() {
		return selectAllDeptDao;
	}

	/**
	 * 
	 * @param selectAllDeptDao
	 */
	public void setSelectAllDeptDao(ISelectAllDeptDao selectAllDeptDao) {
		this.selectAllDeptDao = selectAllDeptDao;
	}
	/**
	 * 查询专业部门人员信息
	 * @author XiaoTian
	 * @param  orgname = 门店服务部
	 * @return SelectAllDeptEntity
	 */
	@Override
	public List<SelectAllDeptEntity> findStoreServiceDepartment(String empcode) {
		// TODO Auto-generated method stub
		return selectAllDeptDao.findStoreServiceDepartment(empcode);
	}
	/**
	 * 根据员工号的list查询营业部头像
	 */
	@Override
	public List<SelectAllDeptEntity> selectAllDeptpic(List<String> empcodelist) {
		// TODO Auto-generated method stub
		return selectAllDeptDao.selectAllDeptpic(empcodelist);
	}
	/**
	 * 根据工号查询德邦所有人员信息
	 */
	@Override
	public SelectAllDeptEntity selectUserByEmpcode(String empCode) {
		// TODO Auto-generated method stub
		return selectAllDeptDao.selectUserByEmpcode(empCode);
	}
	/**
	 * 根据工号查询智慧门店相关人员信息
	 * @author RY
	 */
	@Override
	public SelectAllDeptVO selectInfoByEmpCode(String empcode) {
		// 根据工号查询智慧门店相关人员级别
		return selectAllDeptDao.selectInfoByEmpCode(empcode);
	}
	/**
	 *  //查询执行人
	 *  @author RY
	 */
	@Override
	public List<SelectAllDeptVO> selectUpInfo(String deptseq, String psnlevel,Integer nowPage,Integer pageSize,String searchInfo) {
		//定义返回list
		List<SelectAllDeptVO> listvo = new ArrayList<SelectAllDeptVO>();
		//定义存储级别相关sql
		Map<String,String> map = new HashMap<String,String>();
		map.put("01", "");//存储
		map.put("02", "%事业部总裁%");//存储
		map.put("03", "%大区总经理%");//存储
		if("".equals(deptseq)||"".equals(psnlevel)||deptseq==null||psnlevel==null){
			return null;//若为空则返回null
		}else{
			SelectAllDeptVO vo = new SelectAllDeptVO();//定义vo
			List<String> orgidlist = Arrays.asList(deptseq.split("\\."));//分隔字符串
			String jobname = map.get(psnlevel);//取出sql
			if(psnlevel.equals("01")){
				listvo=selectAllDeptDao.selectInfo02(nowPage,pageSize,searchInfo);//若为1级则查询02所有角色
				//循环所有角色，如果级别为05则将isnext改为false否则为true
				for(int i=0;i<listvo.size();i++){
					if("05".equals(listvo.get(i).getPsnlevel())){
						//改为false
						listvo.get(i).setIsnext(false);
					}else{
						//改为true
						listvo.get(i).setIsnext(true);
					}
				}
			}else if(psnlevel.equals("02")){
				 vo= selectAllDeptDao.selectUpInfo02(orgidlist, jobname);
				 String seq = vo.getDeptseq()+"%";//取出Deptseq拼接成sql
				 listvo=selectAllDeptDao.selectInfo03(seq,nowPage,pageSize,searchInfo);
				//循环所有角色，如果级别为05则将isnext改为false否则为true
					for(int i=0;i<listvo.size();i++){
						if("05".equals(listvo.get(i).getPsnlevel())){
							//改为false
							listvo.get(i).setIsnext(false);
						}else{
							//改为true
							listvo.get(i).setIsnext(true);
						}
					}
			}else if(psnlevel.equals("03")){
				 vo= selectAllDeptDao.selectUpInfo03(orgidlist, jobname);
				 String seq = vo.getDeptseq()+"%";//取出Deptseq拼接成sql
				 listvo=selectAllDeptDao.selectInfo04(seq,nowPage,pageSize,searchInfo);
				//循环所有角色，如果级别为05则将isnext改为false否则为true
					for(int i=0;i<listvo.size();i++){
						if("05".equals(listvo.get(i).getPsnlevel())){
							//改为false
							listvo.get(i).setIsnext(false);
						}else{
							//改为true
							listvo.get(i).setIsnext(true);
						}
					}
			}else if(psnlevel.equals("04")||psnlevel.equals("05")){
				String seq=deptseq+"%";//取出Deptseq拼接成sql
				listvo=selectAllDeptDao.selectInfo05(seq,nowPage,pageSize,searchInfo);
				//循环所有角色，如果级别为05则将isnext改为false否则为true
				for(int i=0;i<listvo.size();i++){
					if("05".equals(listvo.get(i).getPsnlevel())){
						//改为false
						listvo.get(i).setIsnext(false);
					}else{
						//改为true
						listvo.get(i).setIsnext(true);
					}
				}
			}
			//返回
			return listvo;
		}		
		
	}
	/**
	 * 根据执行人查询下属所有营业部
	 * @author RY
	 */
	@SuppressWarnings("unused")
	@Override
	public List<SelectAllDeptVO> selectAll(String empCode,String deptseq,String psnlevel,Integer nowPage,Integer pageSize,String searchInfo,Integer mark) {
		//定义存储级别相关sql
		Map<String,String> map = new HashMap<String,String>();
		map.put("01", "%事业部总裁%");//存储
		map.put("02", "%事业部总裁%");//存储
		map.put("03", "%大区总经理%");//存储
		if(StringUtils.isEmpty(psnlevel) || StringUtils.isEmpty(deptseq)){
			return null;
		}else{
			//根据员工号查询员工seq
			SelectAllDeptVO vo = new SelectAllDeptVO();
			List<String> orgidlist=new ArrayList<String>();
			String jobname = map.get(psnlevel);//取出sql
			orgidlist = Arrays.asList(deptseq.split("\\."));//分隔字符串
			//判断级别
			if(psnlevel.equals("01")){
				List<SelectAllDeptVO> vo5 = selectAllDeptDao.selectSelfTest(nowPage,pageSize,searchInfo,mark);
				//非空判断=
				return vo5;
			}
			else if(psnlevel.equals("02")){
				//查询实际领导
				vo= selectAllDeptDao.selectUpInfo02(orgidlist, jobname);
				//取出实际领导的工号
				String empcode =vo.getEmpcode();
				List<SelectAllDeptVO> vo5 = selectAllDeptDao.selectDeptBy02(empcode,nowPage,pageSize,searchInfo,mark);
				//返回vo5
				return vo5;
			}
			//判断级别
			else if(psnlevel.equals("03")){
				//查询实际领导
				vo= selectAllDeptDao.selectUpInfo03(orgidlist, jobname);
				//取出实际领导的工号
				String empcode =vo.getEmpcode();
				List<SelectAllDeptVO> vo5 = selectAllDeptDao.selectDeptBy03(empcode,nowPage,pageSize,searchInfo,mark);
				//返回vo5
				return vo5;
			}
			//判断级别
			else if(psnlevel.equals("04")){
				List<SelectAllDeptVO> vo5 = selectAllDeptDao.selectDeptBy04(empCode, nowPage, pageSize,searchInfo,mark);
				//返回空
				return vo5;
			}//判断级别
			else if (psnlevel.equals("05")){
				//根据执行人查询营业部
				List<SelectAllDeptVO> vo5 = selectAllDeptDao.selectDeptBy05(empCode,searchInfo);
				//返回vo5
				return vo5;
			}else{
				//返回空
				return null;
			}
		}
	}
	/**
	 *  查询角色信息（个人信息如头像） 
	 */
	@Override
	public SelectAllDeptEntity selectdpmAdmin(String empCode) {
		// 查询特殊角色信息 
		return selectAllDeptDao.selectdpmAdmin(empCode);
	}
	/**
	 * 根据工号list查询人员信息
	 * @author RY
	 */
	@Override
	public List<SelectAllDeptEntity> foreachInfoByEmpCode(String exeerIdAll) {
		//  根据工号list查询人员信息
		//传过来的exeerIdAll为逗号分隔的工号
		List<String> idList = Arrays.asList(exeerIdAll.split(","));
		return selectAllDeptDao.foreachInfoByEmpCode(idList);
	}
	/**
	 * 组织映射
	 */
	@Override
	public List<OrgMappingVO> orgMapping() {
		// 
		return selectAllDeptDao.orgMapping();
	}

	@Override
	public List<SelectNameAndPicVO> selectNameAndPic(String list) {
		//  根据工号list查询人员信息
		//传过来的exeerIdAll为逗号分隔的工号
		List<String> idList = Arrays.asList(list.split(","));
		List<SelectNameAndPicVO> listvo =  null;
		listvo =selectAllDeptDao.selectNameAndPic(idList);
		for (SelectNameAndPicVO vo : listvo) {
			if(vo.getPictpath()==null){
				vo.setPictpath("");
			}
		}
		return listvo;
	}
	/**
	 * 查询智能门店所有人员信息  映射
	 */
	@Override
	public List<DeptMappingVO> deptMapping() {
		// 查询智能门店所有人员信息  映射
		return selectAllDeptDao.deptMapping();
	}
}
