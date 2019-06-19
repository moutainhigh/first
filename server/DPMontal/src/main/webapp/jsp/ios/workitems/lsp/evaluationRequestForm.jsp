<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyVo"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterDetailEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterRulesEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplyRaterScaleEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.JudgeApplySupplierEntryEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
	<style type="text/css">
		.otherInfo{
			display:none;
		}
	</style>
</head>
<body>
 <%
	//评标申请单
	JudgeApplyVo info = (JudgeApplyVo)request.getAttribute("lspResponseEntity");
	//评标申请单单头
	JudgeApplyEntity entity = info.getEntity();
	//评标申请单-评标物品信息分录
	JudgeApplyEntryEntity[] entrys = info.getEntrys();
	//评标申请单-评委清单信息分录
	JudgeApplyRaterDetailEntryEntity[] detailEntrys = info.getDetailEntrys();
	//评标申请单-评标细则分录
	JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys = info.getRaterRuleEntrys();
	//评标申请单-评委比例规则分录
	JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys = info.getRaterScaleEntrys();
	//评标申请单-供应商信息分录
	JudgeApplySupplierEntryEntity[] supplierEntrys = info.getSupplierEntrys();
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息-评标申请单</h4>
    	<div class="ulBox2">
	    	<ul>				  
	    		<li>评标申请单单号:<em><%=entity.getFnumber()%></em></li>
				<li>评标细则模板号:<em><%=entity.getCfjudgedetailnumber()%></em></li>
				<li>RFQ单号:<em><%=entity.getCfrfqnumber()%></em></li>
				<li>申请时间:<em><%=FormatUtil.formatDate(entity.getCfapplydate())%></em></li>
				<li>评标时间:<em><%=FormatUtil.formatDate(entity.getCfjudgedate())%></em></li>
				<li>评标地点:<em><%=entity.getCfjudgelocation()%></em></li>
				<li>招标执行组长:<em><%=entity.getCfbidleader()%></em></li>
				<li>评委数量:<em><%=entity.getCfjudgesamountDto()%></em></li>
				<li>专业部门:<em><%=entity.getCfprofessordept().getName()%></em></li>
<%-- 			    <li>单据状态:<em><%=entity.getCfbillstate()%></em></li> --%>
			    <li>商务标评分:<em><%=entity.getCfbusinessscoreDto()%></em></li>
			    <li>技术标评分:<em><%=entity.getCftechnologyscoreDto()%></em></li>
			    <li>综合评分:<em><%=entity.getCfcompositescoreDto()%></em></li>
			    <li>标的物金额:<em><%=FormatUtil.formatDouble("###,###,###.00",entity.getCfdestamountDto())%></em></li>
			    <li>项目描述:<em><%=entity.getCfprojectdescriber()%></em></li>
          	</ul>
        </div>
        <h4 class="yellow" onclick="otherInfoOpen(1);">其他信息-评标物料信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		//评标申请单-评标物品信息分录
			int entrysSize = entrys == null ? 0:entrys.length;
			for(int i = 0; i < entrysSize ; i++ ) {
				JudgeApplyEntryEntity obj1 = entrys[i];
			%>
					    <li <%=i==0?"class='first otherInfo tab1'":"class='line otherInfo tab1'" %>>序号:<em><%=i+1 %></em></li>
					   	<li class="otherInfo tab1">物品编码:<em><%= obj1.getCfmaterialnumber()%></em></li>
					    <li class="otherInfo tab1">物品名称:<em><%= obj1.getCfmaterialname()%></em></li>
					   	<li class="otherInfo tab1">物品类型:<em><%= obj1.getCfmaterialtype()%></em></li>
					    <li class="otherInfo tab1">物品规格:<em><%= obj1.getCfmaterialmodel()%></em></li>
					    <li class="otherInfo tab1">计量单位:<em><%= obj1.getCfunit()%></em></li>
					    <li class="otherInfo tab1">申请数量:<em><%= FormatUtil.formatDouble("###.00",obj1.getCfmaterialamountDto())%></em></li>
				   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo1Close" onclick="otherInfoClose(1);">关闭信息-评标物料信息</h4>
	    
	    <h4 class="yellow" id="otherInfo5Open"  onclick="otherInfoOpen(5);">其他信息-供应商信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%//评标申请单-供应商信息分录 JudgeApplySupplierEntryEntity[] supplierEntrys 
				int supplierEntrysSize = supplierEntrys==null?0:supplierEntrys.length;
				for(int i = 0; i < supplierEntrysSize ; i++ ) {
					JudgeApplySupplierEntryEntity obj1 = supplierEntrys[i];
				%>
				   	<li <%=i==0?"class='first otherInfo tab5'":"class='line otherInfo tab5'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab5">供应商编码:<em><%= obj1.getCfsuppliernumber()%></em></li>
				   	<li class="otherInfo tab5">供应商名称:<em><%= obj1.getCfsuppliername()%></em></li>
				   	<li class="otherInfo tab5">供应商状态:<em><%= "1".equals(obj1.getCfsupplierstate())?"正式":"潜在"%></em></li>
				   	<li class="otherInfo tab5">评审结果:<em><%="10".equals(obj1.getCfjudgeresult())?"通过":"不通过"%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo5Close" onclick="otherInfoClose(5);" >关闭信息-供应商信息</h4>
	    
	    <h4 class="yellow" id="otherInfo4Open" onclick="otherInfoOpen(4);" >其他信息-评委比例规则</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%//评标申请单-评委比例规则分录 JudgeApplyRaterScaleEntryEntity[] raterScaleEntrys 
				int raterScaleEntrysSize = raterScaleEntrys==null?0:raterScaleEntrys.length;
				for(int i = 0; i < raterScaleEntrysSize ; i++ ) {
					JudgeApplyRaterScaleEntryEntity obj1 = raterScaleEntrys[i];
				%>
				   	<li <%=i==0?"class='first otherInfo tab4'":"class='line otherInfo tab4'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab4">评委类别:<em><%= obj1.getCfjudgestype()%></em></li>
				   	<li class="otherInfo tab4">数量:<em><%= obj1.getCfjudgesamount()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo4Close"  onclick="otherInfoClose(4);">关闭信息-评委比例规则</h4>
	    
	    <h4 class="yellow" onclick="otherInfoOpen(2);">其他信息-评委清单信息</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		//评标申请单-评委清单信息分录 JudgeApplyRaterDetailEntryEntity[] detailEntrys
			int detailEntrysSize = detailEntrys==null?0:detailEntrys.length;
			for(int i = 0; i < detailEntrysSize ; i++ ) {
				JudgeApplyRaterDetailEntryEntity obj1 = detailEntrys[i];
				%>
				   <li <%=i==0?"class='first otherInfo tab2'":"class='line otherInfo tab2'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab2">评委库编码:<em><%= obj1.getCfjudgeinfonum()%></em></li>
				   	<li class="otherInfo tab2">评委姓名:<em><%= obj1.getCfjudgesname()%></em></li>
				   	<li class="otherInfo tab2">评委类别:<em><%= obj1.getCfjudgestype()%></em></li>
				   	<li class="otherInfo tab2">评委专长:<em><%= obj1.getCfjudgesmajor()%></em></li>
				   	<li class="otherInfo tab2">是否评标组长:<em><%=obj1.getCfisleader()==1?"是":"否"%></em></li>
				   	<li class="otherInfo tab2">是否选中:<em><%=obj1.getCfisselected()==1?"是":"否"%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo2Close" onclick="otherInfoClose(2);">关闭信息-评委清单信息</h4>
	    
	    <h4 class="yellow" id="otherInfo3Open" onclick="otherInfoOpen(3);">其他信息-评标细则</h4>
	   	<div class="ulBox2">
    		<ul>
    		<%
    		//评标申请单-评标细则分录 JudgeApplyRaterRulesEntryEntity[] raterRuleEntrys
				int raterRuleEntrysSize = raterRuleEntrys==null?0:raterRuleEntrys.length;
				for(int i = 0; i < raterRuleEntrysSize ; i++ ) {
					JudgeApplyRaterRulesEntryEntity obj1 = raterRuleEntrys[i];
				%>
				   	<li <%=i==0?"class='first otherInfo tab3'":"class='line otherInfo tab3'" %>>序号:<em><%=i+1 %></em></li>
				    <li class="otherInfo tab3">评标项类别:<em><%= obj1.getCfjudgebidtype()%></em></li>
				   	<li class="otherInfo tab3">评标项:<em><%= obj1.getCfjudgeitem()%></em></li>
				   	<li class="otherInfo tab3">评委类别:<em><%= obj1.getCfjudgestype()%></em></li>
				   	<li class="otherInfo tab3">分值:<em><%= obj1.getCfjudgescore()%></em></li>
				   	<li class="otherInfo tab3">评标细则:<em><%=obj1.getCfjudgedetail()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    <h4 class="yellow" style="display: none" id="otherInfo3Close" onclick="otherInfoClose(3);">关闭信息-评标细则</h4>
	    
	    <%@include file="approve_process_esb3.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb2.jsp" %>
</div>
</body>
<script type="text/javascript">
function otherInfoClose(obj){
	$(".otherInfo.tab"+obj).slideUp(200);
	$("#otherInfo"+obj+"Close").slideUp(200);
}
function otherInfoOpen(obj){
	$(".otherInfo.tab"+obj).slideDown(200);
	$("#otherInfo"+obj+"Close").slideDown(200);
}
</script>
</html>