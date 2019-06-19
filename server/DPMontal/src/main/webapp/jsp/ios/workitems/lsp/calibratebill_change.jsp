<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.deppon.montal.util.InitDataServlet"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.WorkflowEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibratebillChangeVo"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeEntryEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeDEntrysEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeThreeEntrysEntity"%>
<%@page import="com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain.CalibrateBillChangeFourEntryEntity"%>
<%@ page language="java"  pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<title><%=InitDataServlet.getValue("page_title") %>-待办事项</title>
	<%@include file="/common_ios.jsp" %>
</head>
<body>
 <%
 WorkflowEntity info = (WorkflowEntity)request.getAttribute("lspResponseEntity");
 CalibratebillChangeVo change = info.getCalibratebillChangeVo();
 //基本信息
 CalibrateBillChangeEntity base = change.getCalibrateBillChangeEntity();
 //其他信息之物品信息
 CalibrateBillChangeEntryEntity[] materiaArr = change.getMaterialList();
 //其他信息之供应商报价 
 Map<String, CalibrateBillChangeDEntrysEntity[]> priceMap = change.getSupplierPriceMap();
 //其他信息之定标结果信息
 Map<String, CalibrateBillChangeThreeEntrysEntity[]> resultMap = change.getChangeResultMap();
 //其他信息之评委信息
 CalibrateBillChangeFourEntryEntity[] judgeArr = change.getJudgePersonList();
 //临时循环变量
 double d;
 String str;
 %>
<div id="list">
	<%@include file="/jsp/ios/work_items_head.jsp" %>
	<div id="div2">
		<h4 class="yellow">基本信息</h4>
    	<div class="ulBox2">
	    	<ul>
	    		<li>工作流:<em>定标变更单</em></li>	  
          		<li>单据编号:<em><%=base.getFnumber()%></em></li>
				<li>定标单号:<em><%=base.getCalibrateNumber()%></em></li>
				<li>RFQ单号:<em><%=base.getRfqNumber()%></em></li>
				<li>版本号:<em><%=base.getEditionNumber()%></em></li>
				<li>执行小组名:<em><%=base.getNameList()%></em></li>
			   	<li>定标结果:<em><%= base.getCalibrateRest()==null?"":base.getCalibrateRest()%></em></li>
			   	<li>标的物金额:<em><%=base.getDestAmount()%></em></li>
			   	<li>需求评委意见:<em><%=base.getNeedSuggest()==null?"":("0".equals(base.getNeedSuggest())?"同意":"不同意")%></em></li>
			   	<li>专业评委意见:<em><%=base.getSpecialtySuggest()==null?"":("0".equals(base.getSpecialtySuggest())?"同意":"不同意")%></em></li>
			   	<li>采购评委意见:<em><%=base.getPurchaseSuggest()==null?"":("0".equals(base.getPurchaseSuggest())?"同意":"不同意")%></em></li>
          	</ul>
        </div>
        
        <h4 class="yellow">其他信息-物品信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int i = 0; i < materiaArr.length; i++ ) {
					String classK = materiaArr[i].getId().replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
				%>
					<li <%=i==0?"class='first'":"class='line'" %> onclick="showRelationship('<%=classK%>');">序号:<em><%=i+1 %></em></li>
				   	<li onclick="showRelationship('<%=classK%>');">物品编码:<em><%= materiaArr[i].getMaterialNumber()%></em></li>
				    <li onclick="showRelationship('<%=classK%>');">物品名称:<em><%= materiaArr[i].getMaterialName()%></em></li>
				   	<li onclick="showRelationship('<%=classK%>');">物品类型:<em><%= materiaArr[i].getMaterialType()%></em></li>
				    <li onclick="showRelationship('<%=classK%>');">物品规格:<em><%= materiaArr[i].getMaterialModel()%></em></li>
				    <%
				    	d = materiaArr[i].getNum();
				    	str = String.valueOf(d);
				    %>
				    <li>数量:<em><%= str.substring(0,str.indexOf("."))%></em></li>
				    <li>计量单位:<em><%= materiaArr[i].getUnit()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    
	    <h4 class="yellow">其他信息-供应商报价</h4>
	   	<div class="ulBox2">
    		<ul>
				 <%Iterator iterator = priceMap.keySet().iterator();
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
						CalibrateBillChangeDEntrysEntity[] priceArr= priceMap.get(key);
						int lengthTemp = (priceArr == null ? 0:priceArr.length);
				  		for(int j = 0; j < lengthTemp; j++) {%>
							<li <%=j==0?"class='"+classKey+"first'":"class='"+classKey+"line'" %> style="display: none">序号:<em><%=j+1 %></em></li>
						   	<li class="<%=classKey%>" style="display: none">供应商编码:<em><%= priceArr[j].getSupplierNumber()%></em></li>
						    <li class="<%=classKey%>" style="display: none">供应商名称:<em><%= priceArr[j].getSupplierName()%></em></li>
						   	<li class="<%=classKey%>" style="display: none">单价:<em><%= priceArr[j].getPrice()%></em></li>
			   			<%} 
				   }%>
		   </ul>
	    </div>
	    
	    <h4 class="yellow">其他信息-定标结果信息</h4>
	   	<div class="ulBox2">
    		<ul>
				 <% Iterator iterator1 = resultMap.keySet().iterator();
					while(iterator1.hasNext()){
						String key = (String)iterator1.next();
						String classKey = key.replaceAll("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]","");
						CalibrateBillChangeThreeEntrysEntity[] resultArr= resultMap.get(key);
						int lengthTemp2 = (resultArr == null? 0:resultArr.length);
						for(int k = 0; k < lengthTemp2; k++) {%>
							<li <%=k==0?"class='"+classKey+"first'":"class='"+classKey+"line'" %> style="display: none">序号:<em><%=k+1 %></em></li>
						   	<li style="display: none;" class="<%=classKey%>">供应商编码:<em><%= resultArr[k].getSupplierNumber()%></em></li>
						    <li style="display: none;" class="<%=classKey%>">供应商名称:<em><%= resultArr[k].getSupplierName()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">商务标排名:<em><%= resultArr[k].getBusinessRank()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">技术标排名:<em><%= resultArr[k].getTechnologyRank()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">综合排名:<em><%= resultArr[k].getRank()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">综合得分:<em><%= resultArr[k].getScores()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">配额类型:<em><%= resultArr[k].getType()==null?"":("10".equals(resultArr[k].getType())?"文本":"数字")%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">配额(%):<em><%= resultArr[k].getQuota()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">配额说明:<em><%= resultArr[k].getQuptaDescription()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">审批结论:<em><%= resultArr[k].getAuditConclusion()==null?"":resultArr[k].getAuditConclusion()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">评标结果:<em><%= resultArr[k].getResult()%></em></li>
						   	<li style="display: none;" class="<%=classKey%>">变更原因:<em><%= resultArr[k].getRemark()==null?"":resultArr[k].getRemark()%></em></li>
			   			<%} 
				   }%>
		   </ul>
	    </div>
	    
	    <h4 class="yellow">其他信息-评委信息</h4>
	   	<div class="ulBox2">
    		<ul>
				<%for(int l = 0; l < judgeArr.length; l++ ) {%>
					<li <%=l==0?"class='first'":"class='line'"%>>序号:<em><%=l+1 %></em></li>
				   	<li>评委姓名:<em><%= judgeArr[l].getJudgeName()%></em></li>
				    <li>评委类别:<em><%= judgeArr[l].getJudgeType()%></em></li>
				   	<li>评委专长:<em><%= judgeArr[l].getJudgeExpertise()%></em></li>
				    <li>是否评标组长:<em><%= judgeArr[l].isIfGroupleader()?"是":"否"%></em></li>
				    <li>授权信息:<em><%= judgeArr[l].getGrantInformation()==null?"":judgeArr[l].getGrantInformation()%></em></li>
			   <%} %>
		   </ul>
	    </div>
	    
	    <%@include file="approve_process_esb.jsp"%> 
	</div>
	 <%@include file="workflow_approve_button_esb.jsp" %>
</div>
</body>
<script type="text/javascript">
function showRelationship(classK){
	$('.'+classK).show();
	$('.'+classK+'line').show();
	$('.'+classK+'first').show();
	$('.'+classK+'line').css('border-color','#faaf19');
}
</script>
</html>