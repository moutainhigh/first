package com.deppon.dpm.tongxunlu.server.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.server.util.CodeMsg;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.server.util.UploadPic;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.DeptMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrgMappingVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;
import com.deppon.dpm.tongxunlu.shared.vo.SelectNameAndPicVO;

public class SelectAllDeptAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// log
	private static final Logger logger = Logger.getLogger(SelectAllDeptAction.class);
	//注入service
	private ISelectAllDeptService selectAllDeptService;
	//
	private String JOBNAME;
	//
	private String PARENTORGID;
	//
	private String empCode;
	//
	private List<String> empcodelist;
	//
	private String deptseq;
	//
	private String psnlevel;
	//
	private Integer nowPage;
	//
	private Integer pageSize;
	//
	private String searchInfo;
	//
	private Integer mark;
	//
	private String exeerIdAll;
	/**
	 * 智慧门店查询所有相关部门信息
	 */
	@CookieNotCheckedRequired
	public void selectAllDept(){
		//定义返回参数
		List<SelectAllDeptEntity> resultList = null;
		try{
			//获取数据
			resultList = selectAllDeptService.selectAllDept(JOBNAME, PARENTORGID);
		}catch(Exception e){
			//异常
			logger.error("智能门店调用通讯录selectAllDept接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultList);
	}
	/**
	 * 智慧门店根据工号查询所有相关部门信息
	 */
	@CookieNotCheckedRequired
	public void selectAllDeptByempcode(){
		//定义返回参数
		SelectAllDeptEntity resultEntity = null;
		try{
			resultEntity = selectAllDeptService.selectAllDeptByempcode(empCode);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectAllDeptByempcode接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultEntity);
	}
	/**
	 *  查询专业部门人员信息
	 */
	@CookieNotCheckedRequired
	public void findStoreServiceDepartment(){
		//定义返回参数
		List<SelectAllDeptEntity> resultList = null;
		try{
			resultList = selectAllDeptService.findStoreServiceDepartment(empCode);
		}catch(Exception e){
			logger.error("智能门店调用通讯录findStoreServiceDepartment接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultList);
	}
	/**
	 * 根据员工号的list查询营业部头像
	 */
	@CookieNotCheckedRequired
	public void selectAllDeptpic(){
		//定义返回参数
		List<SelectAllDeptEntity> resultList = null;
		try{
			resultList = selectAllDeptService.selectAllDeptpic(empcodelist);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectAllDeptpic接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultList);
	}
	/**
	 * 根据工号查询德邦所有人员信息
	 */
	@CookieNotCheckedRequired
	public void selectUserByEmpcode(){
		//定义返回参数
		SelectAllDeptEntity resultEntity = null;
		try{
			resultEntity = selectAllDeptService.selectUserByEmpcode(empCode);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectUserByEmpcode接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultEntity);
	}
	/**
	 * 根据工号查询智慧门店相关人员级别
	 */
	@CookieNotCheckedRequired
	public void selectInfoByEmpCode(){
		//定义返回参数
		SelectAllDeptVO resultVO = null;
		try{
			resultVO = selectAllDeptService.selectInfoByEmpCode(empCode);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectInfoByEmpCode接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultVO);
	}
	/**
	 * 查询执行人
	 */
	@CookieNotCheckedRequired
	public void selectUpInfo(){
		//定义返回参数
		List<SelectAllDeptVO> resultList = null;
		try{
			resultList = selectAllDeptService.selectUpInfo(deptseq, psnlevel, nowPage, pageSize, searchInfo);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectUpInfo接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultList);
	}
	/**
	 * 根据执行人查询下属所有营业部
	 */
	@CookieNotCheckedRequired
	public void selectAll(){
		//定义返回参数
		List<SelectAllDeptVO> resultList = null;
		try{
			resultList = selectAllDeptService.selectAll(empCode, deptseq, psnlevel, nowPage, pageSize, searchInfo, mark);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectAll接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultList);
	}
	/**
	 * 查询角色信息（个人信息如头像） 
	 */
	@CookieNotCheckedRequired
	public void selectdpmAdmin(){
		//定义返回参数
		SelectAllDeptEntity resultEntity = null;
		try{
			resultEntity = selectAllDeptService.selectdpmAdmin(empCode);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectdpmAdmin接口失败--------------");
		}
		//返回页面数据
		writeToPage(resultEntity);
	}
	/**
	 * 根据工号list查询人员信息
	 */
	@CookieNotCheckedRequired
	public void foreachInfoByEmpCode(){
		List<SelectAllDeptEntity> listentity = null;
		try{
			listentity = selectAllDeptService.foreachInfoByEmpCode(exeerIdAll);
		}catch(Exception e){
			logger.error("智能门店调用通讯录ForeachInfoByEmpCode接口失败--------------");
		}
		//返回页面数据
		writeToPage(listentity);
	}
	/**
	 * 组织映射
	 * @author RY
	 */
	@CookieNotCheckedRequired
	public void orgMapping(){
		List<OrgMappingVO> vo = null;
		try{
			vo=selectAllDeptService.orgMapping();
		}catch(Exception e){
			logger.error("智能门店调用通讯录orgMapping接口失败--------------");
		}
		//返回页面数据
		writeToPage(vo);
	}
	/**
	 * 根据工号list查询人员信息
	 */
	@CookieNotCheckedRequired
	public void selectNameAndPic(){
		List<SelectNameAndPicVO> listentity = null;
		try{
			listentity = selectAllDeptService.selectNameAndPic(exeerIdAll);
		}catch(Exception e){
			logger.error("智能门店调用通讯录selectNameAndPic接口失败--------------");
		}
		//返回页面数据
		writeToPage(listentity);
	}
	/**
	 * 组织映射
	 * @author RY
	 */
	@CookieNotCheckedRequired
	public void deptMapping(){
		List<DeptMappingVO> vo = null;
		try{
			vo=selectAllDeptService.deptMapping();
		}catch(Exception e){
			logger.error("智能门店调用通讯录deptMapping接口失败--------------");
		}
		//返回页面数据
		writeToPage(vo);
	}
	/**
	 * 
	 * @return
	 */
	public ISelectAllDeptService getSelectAllDeptService() {
		return selectAllDeptService;
	}
	/**
	 * 
	 * 
	 * @param selectAllDeptService
	 */
	public void setSelectAllDeptService(ISelectAllDeptService selectAllDeptService) {
		this.selectAllDeptService = selectAllDeptService;
	}
	/**
	 * 
	 * @return
	 */
	public String getJOBNAME() {
		return JOBNAME;
	}
	/**
	 * 
	 * @param jOBNAME
	 */
	public void setJOBNAME(String jOBNAME) {
		JOBNAME = jOBNAME;
	}
	/**
	 * 
	 * @return
	 */
	public String getPARENTORGID() {
		return PARENTORGID;
	}
	/**
	 * 
	 * @param pARENTORGID
	 */
	public void setPARENTORGID(String pARENTORGID) {
		PARENTORGID = pARENTORGID;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}
	
	/**
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * 
	 * @return
	 */
	public List<String> getEmpcodelist() {
		return empcodelist;
	}
	/**
	 * 
	 * @param empcodelist
	 */
	public void setEmpcodelist(List<String> empcodelist) {
		this.empcodelist = empcodelist;
	}
	/**
	 * 
	 * @return
	 */
	public String getDeptseq() {
		return deptseq;
	}
	/**
	 * 
	 * @param deptseq
	 */
	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
	}
	/**
	 * 
	 * @return
	 */
	public String getPsnlevel() {
		return psnlevel;
	}
	/**
	 * 
	 * @param psnlevel
	 */
	public void setPsnlevel(String psnlevel) {
		this.psnlevel = psnlevel;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getNowPage() {
		return nowPage;
	}
	/**
	 * 
	 * @param nowPage
	 */
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 
	 * @return
	 */
	public String getSearchInfo() {
		return searchInfo;
	}
	/**
	 * 
	 * @param searchInfo
	 */
	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getMark() {
		return mark;
	}
	/**
	 * 
	 * @param mark
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getExeerIdAll() {
		return exeerIdAll;
	}
	public void setExeerIdAll(String exeerIdAll) {
		this.exeerIdAll = exeerIdAll;
	}
	
	private String picture;
	
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 定义参数
	 * 
	 * @param picture
	 *            图片json字符串
	 * @param exeid
	 */
	@SuppressWarnings("all")
	@CookieNotCheckedRequired
	public void Upload() {
		JSONObject jonum = new JSONObject();
		logger.info("图片上传开始-------------");
		if (StringUtils.isEmpty(picture)) {
			jonum.put(ERROR, CodeMsg.Mark_JSON_pric);
		} else {
			try {
				List<String> pictureString = new ArrayList<String>();
				picture = picture.replace(" " , "+");
				ArrayList<String> stringsarray = (ArrayList<String>) JSONObject.parseArray(picture, String.class);
				System.out.println(picture);
				for (String string : stringsarray) {
					StringBuffer img = new StringBuffer();
					UploadPic uploadPic = new UploadPic();
					String imgName = uploadPic.stringImgSuffix(string);
					img.append(imgName);
					pictureString.add(img.toString());
					UploadPic.Base64ToImage(string, imgName);
				}
				jonum.put("picture", pictureString);
			} catch (Exception e) {
				// TODO: handle exception
				// 打分异常,操作失败 -------------
				e.printStackTrace();
				logger.error("打分异常,操作失败 -------------");
				jonum.put(SUCCESS, CodeMsg.Mark_JSON_pric);
			}
			writeToPage(jonum);
		}
	}
}
