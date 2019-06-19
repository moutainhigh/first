package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 员工宿舍申请
 * 角色名称
	职责描述	对应部门	对应人员	备注
申请人	起草工作流	经营/运作 /保安组	部门经理	
审批人1	从大区角度审核、决策需求是否通过	经营/运作/保安组	直接上级（大区总/总监）	直接上级是事业部办公室主任的可以跳过此审批
审批人2	从事业部的角度审核、决策需求是否通过	事业部办公室	办公室主任	参照参与者配置
审批人3	审核需求；
执行宿舍设立标准	营运培训与食宿管理组	负责人	
审批人4	执行宿舍配置采购及合同盖章等	事业部后勤组	负责人	参照参与者配置

业务功能
业务描述
此工作流仅适用于经营/运作/保安组负责人为其所在部门员工申请集体宿舍时使用，起草工作流前最好先和营运培训与食宿管理组沟通确认。
 * RULE-A1	当宿舍长字段为空时，字段后方空白处红字提示此项必填
RULE-A2	当所在区域字段为空时，字段后方空白处红字提示此项必填
RULE-A3	是否外租单选框默认为是，是否续租单选框默认为否
RULE-A4	当是否续租单选框选中为是时，续租费用字段可以录入数字
RULE-A5	当续租费用字段为空时，字段后方空白处红字提示 此项必填
RULE-A6	当宿舍住宿人数字段为空时，字段后方空白处红字提示 此项必填
RULE-A7	当部门性质字段为空时，字段后方空白处红字提示 此项必填
RULE-A8	当申请事由为空时，字段后方空白处红字提示 此项必填
RULE-A9	当表单填写正确，并且成功提交，字段后方空白处红字提示信息 您的员工宿舍申请工作流已经提交，请关注流转情况！
rule-A10	当点击暂存button时，字段后方空白处红字提示  工作流暂存成功，请到我的工作流中查找！ 当前起草的表单 保存到我的工作流中。
前置条件	用户身份已被鉴别；
用户具有相应权限；
进入审批工作流界面。	
后置条件	工作流流向正常；	
操作步骤
序号	基本步骤	补充步骤
1	选择“同意”单选框	点击“提交”按钮    RULE-A1
2	选择“不同意”单选框	点击“提交”按钮    RULE-A1
3	点击“回退”按钮	
4	点击“返回”按钮	
5	回退选择页中， 选择指定回退节点	点击“提交”按钮 （回退节点是已经审批过的节点）
6	回退选择页中，点击“取消”	

序号	扩展事件	备注
1	工作流正常提交并流转到下一审批人；
工作流下一审批节点人员空缺，工作流不能提交。	弹出窗口提醒“您审批的工作流已正常提交”
弹出窗口提醒“下一位审批者空缺，请联系“门户需求管理组”。
2	申请被驳回，工作流结束	通过消息推送提醒申请人
3	弹出“回退选择”页面	
4	返回“未审批工作流”页面	
5	弹出窗口提醒“工作流已经退回”	返回“未审批工作流界面”RULE-A2
6	关闭回退选择页，返回审批工作流页	
审批人	自动带出	文本	20	是	无	默认当时系统使用人
审批时间	自动带出	文本	20	是	无	默认当前系统时间
审批意见	手动输入	文本	300	否	审批人	
审批结果	单选框			是	审批人	1、同意；2、不同意；

【回退界面】
字段名称 	说明 	输入限制	长度	是否必填	可编辑角色	备注
选择环节	单选框			是	当前
审批人	列出已经流转过的所有界面名称，并根据审批人选择流转方向。
审批意见	手动录入	文本	500	是	当前
审批人	
 */

/**
* @title: EmpDormBean 
* @description：员工宿舍申请实体Bean
* @author： 高雅哲
* @date： 2013-9-3 下午01:33:27
*/
public class EmpDormBean extends Entity{
   /**
    * 流程序号,主键,含有字母
    */
    private String busino;

    /**
     * 流程实例ID，相当于工作流号
     */
    private Long processinstid;

    /**
     * 申请人员工ID
     */
    private String applyPersonId;

    /**
     * 申请人姓名
     */
    private String applyPersonName;

    /**
     * 申请人所在部门,15个字
     */
    private String orgname;

    /**
     * 所属事业部，满足15个字留一位占位
     */
    private String areaub;

    /**
     * 是否外租
     */
    private int isrent;

    /**
     * 宿舍居住人数
     */
    private Integer livingno;

    /**
     * 宿舍长
     */
    private String dormItorymanager;

    /**
     * 申请事由
     */
    private String applyReasons;

    /**
     * 申请人职位
     */
    private String empPost;

    /**
     * 是否续租
     */
    private int continuerent;

    /**
     * 续租费用
     */
    private BigDecimal continuerentCost;

    /**
     * 部门性质
     */
    private String departNature;

    /**
     * 起草时间
     */
    private Date draftdate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 业务状态
     */
    private String isseffective;

    /**
     * 员工宿舍ID(扩展) 
     */
    private int dormitoryid;

    /**
     * 备用字段1
     */
    private String spareField1;

    /**
     * 备用字段2
     */
    private String spareField2;
    /**
     * 迁移：电视数量
     */
    private String tvno;
    /**
     * 迁移：电视柜数量
     */
    private String tvboxno;
    /**
     * 迁移：饮水机数量
     */
    private String watermachineno;
    /**
     * 迁移：鞋架数量
     */
    private String shoesshelfno;
    /**
     * 迁移：床数量
     */
    private String bedno;
    /**
     * 迁移：桌子数量
     */
    private String deskn;
    /**
     * 迁移：热水器数量
     */
    private String waterheatern;
    /**
     * 迁移：椅子数量
     */
    private String CHAIRNOchairno;
    /**
     * 迁移：衣柜数量
     */
    private String clothesboxno;
    /**
     * 迁移：部门开业时间
     */
    private String departmentopentime;
	public EmpDormBean() {
	}

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processinstd
	 */
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstd the processinstd to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	

	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}

	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param orgname the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * @return the areaub
	 */
	public String getAreaub() {
		return areaub;
	}

	/**
	 * @param areaub the areaub to set
	 */
	public void setAreaub(String areaub) {
		this.areaub = areaub;
	}

	/**
	 * @return the isrent
	 */
	public int getIsrent() {
		return isrent;
	}

	/**
	 * @param isrent the isrent to set
	 */
	public void setIsrent(int isrent) {
		this.isrent = isrent;
	}

	/**
	 * @return the livingno
	 */
	public Integer getLivingno() {
		return livingno;
	}

	/**
	 * @param livingno the livingno to set
	 */
	public void setLivingno(Integer livingno) {
		this.livingno = livingno;
	}

	/**
	 * @return the dormItorymanager
	 */
	public String getDormItorymanager() {
		return dormItorymanager;
	}

	/**
	 * @param dormItorymanager the dormItorymanager to set
	 */
	public void setDormItorymanager(String dormItorymanager) {
		this.dormItorymanager = dormItorymanager;
	}

	/**
	 * @return the applyReasons
	 */
	public String getApplyReasons() {
		return applyReasons;
	}

	/**
	 * @param applyReasons the applyReasons to set
	 */
	public void setApplyReasons(String applyReasons) {
		this.applyReasons = applyReasons;
	}

	/**
	 * @return the empPost
	 */
	public String getEmpPost() {
		return empPost;
	}

	/**
	 * @param empPost the empPost to set
	 */
	public void setEmpPost(String empPost) {
		this.empPost = empPost;
	}

	/**
	 * @return the continuerent
	 */
	public int getContinuerent() {
		return continuerent;
	}

	/**
	 * @param continuerent the continuerent to set
	 */
	public void setContinuerent(int continuerent) {
		this.continuerent = continuerent;
	}

	/**
	 * @return the continuerentCost
	 */
	public BigDecimal getContinuerentCost() {
		return continuerentCost;
	}

	/**
	 * @param continuerentCost the continuerentCost to set
	 */
	public void setContinuerentCost(BigDecimal continuerentCost) {
		this.continuerentCost = continuerentCost;
	}
	
	/**
	 * @return the departNature
	 */
	public String getDepartNature() {
		return departNature;
	}

	/**
	 * @param departNature the departNature to set
	 */
	public void setDepartNature(String departNature) {
		this.departNature = departNature;
	}

	/**
	 * @return the draftdate
	 */
	public Date getDraftdate() {
		return draftdate;
	}

	/**
	 * @param draftdate the draftdate to set
	 */
	public void setDraftdate(Date draftdate) {
		this.draftdate = draftdate;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the dormitoryid
	 */
	public int getDormitoryid() {
		return dormitoryid;
	}

	/**
	 * @param dormitoryid the dormitoryid to set
	 */
	public void setDormitoryid(int dormitoryid) {
		this.dormitoryid = dormitoryid;
	}

	/**
	 * @return the spareField1
	 */
	public String getSpareField1() {
		return spareField1;
	}

	/**
	 * @param spareField1 the spareField1 to set
	 */
	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}

	/**
	 * @return the spareField2
	 */
	public String getSpareField2() {
		return spareField2;
	}

	/**
	 * @param spareField2 the spareField2 to set
	 */
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}

	/**
	 * @return the tvno
	 */
	public String getTvno() {
		return tvno;
	}

	/**
	 * @param tvno the tvno to set
	 */
	public void setTvno(String tvno) {
		this.tvno = tvno;
	}

	/**
	 * @return the tvboxno
	 */
	public String getTvboxno() {
		return tvboxno;
	}

	/**
	 * @param tvboxno the tvboxno to set
	 */
	public void setTvboxno(String tvboxno) {
		this.tvboxno = tvboxno;
	}

	/**
	 * @return the watermachineno
	 */
	public String getWatermachineno() {
		return watermachineno;
	}

	/**
	 * @param watermachineno the watermachineno to set
	 */
	public void setWatermachineno(String watermachineno) {
		this.watermachineno = watermachineno;
	}

	/**
	 * @return the shoesshelfno
	 */
	public String getShoesshelfno() {
		return shoesshelfno;
	}

	/**
	 * @param shoesshelfno the shoesshelfno to set
	 */
	public void setShoesshelfno(String shoesshelfno) {
		this.shoesshelfno = shoesshelfno;
	}

	/**
	 * @return the bedno
	 */
	public String getBedno() {
		return bedno;
	}

	/**
	 * @param bedno the bedno to set
	 */
	public void setBedno(String bedno) {
		this.bedno = bedno;
	}

	/**
	 * @return the deskn
	 */
	public String getDeskn() {
		return deskn;
	}

	/**
	 * @param deskn the deskn to set
	 */
	public void setDeskn(String deskn) {
		this.deskn = deskn;
	}

	/**
	 * @return the waterheatern
	 */
	public String getWaterheatern() {
		return waterheatern;
	}

	/**
	 * @param waterheatern the waterheatern to set
	 */
	public void setWaterheatern(String waterheatern) {
		this.waterheatern = waterheatern;
	}

	/**
	 * @return the cHAIRNOchairno
	 */
	public String getCHAIRNOchairno() {
		return CHAIRNOchairno;
	}

	/**
	 * @param cHAIRNOchairno the cHAIRNOchairno to set
	 */
	public void setCHAIRNOchairno(String cHAIRNOchairno) {
		CHAIRNOchairno = cHAIRNOchairno;
	}

	/**
	 * @return the clothesboxno
	 */
	public String getClothesboxno() {
		return clothesboxno;
	}

	/**
	 * @param clothesboxno the clothesboxno to set
	 */
	public void setClothesboxno(String clothesboxno) {
		this.clothesboxno = clothesboxno;
	}

	/**
	 * @return the departmentopentime
	 */
	public String getDepartmentopentime() {
		return departmentopentime;
	}

	/**
	 * @param departmentopentime the departmentopentime to set
	 */
	public void setDepartmentopentime(String departmentopentime) {
		this.departmentopentime = departmentopentime;
	}

	

	
}