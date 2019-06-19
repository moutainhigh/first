<%@page import="com.deppon.dpm.module.acms.domain.SyncWorkflowinfoResponse"%>
<%@page import="com.deppon.dpm.module.acms.domain.SubSiDiarySetEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.CompanyFillChangeEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.ApproveEntity"%>
<%@page import="com.deppon.dpm.module.acms.domain.Attachment"%>
<%@page import="com.deppon.montal.util.FormatUtil"%>
<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="java.util.List"%>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>

<% 
SyncWorkflowinfoResponse syncwfinfos = (SyncWorkflowinfoResponse)request.getAttribute("acmsSyncResponse");
SubSiDiarySetEntity subSiinfo = syncwfinfos.getSubSiDiarySetEntity();
CompanyFillChangeEntity comInfo = syncwfinfos.getCompanyFillChangeEntity();
//附件
List<Attachment> fileList = null;
//审批意见
List<ApproveEntity> approveList = null;
if(subSiinfo != null && comInfo == null){
	fileList = subSiinfo.getFileList();
	approveList = subSiinfo.getApproveList();
}else if(subSiinfo == null && comInfo != null){
	approveList = comInfo.getApproveList();
	fileList = comInfo.getFileList();
}
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
		<table width="100%">
		<tbody class="dpFiles">
	<!-- 附件 -->
		<tr class="files"><th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th></tr>
		<%int length = fileList == null ? 0:fileList.size();
		for(int i = 0 ; i < length; i++) {%>
		<tr class='toFile'  style="display: none">
			<td class="<%=i == 0 ? "first" : "line" %>">
			<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileList.get(i).getFileUrl()%>&fileName=<%=fileList.get(i).getFileName()%>" style="color: red"><%=fileList.get(i).getFileName()%></a>&nbsp;
			</td>
		</tr>
		<%} %>
		<tr class="toFile" style="display: none">
			<th colspan="2"><a class="yellow" id="hideFile">关闭附件列表</a></th>
		</tr>
		</tbody>
			<tr id="appstr"><th colspan="2"><a class="yellow" id="sliderDown">查看审批记录</a></th></tr>					
			<%int size = approveList == null ? 0:approveList.size();
				for(int i=0; i< size; i++){
					ApproveEntity  appInfo = approveList.get(i);
			%>
				 <tr <%=i==0?"class='sh'":"class='topLine sh'" %>><th>审批时间:</th> <td><%=FormatUtil.formatDate(appInfo.getApproveDate(), "yyyy-MM-dd HH:mm:ss")%></td> </tr>
				 <tr class="sh"><th>审批处理人:</th> <td><%=appInfo.getApprover()%></td> </tr>
				 <tr class="sh"><th>审批人结果:</th> <td><%=appInfo.getApproveDesition()%></td> </tr>
				 <tr class="sh"><th>审批人意见:</th> <td><%=appInfo.getApproveOpinion()==null?"":appInfo.getApproveOpinion()%></td> </tr>
			<%
				}
			%>

			<tr class="sh">
				<th colspan="2"><a class="yellow" id="sliderUp">关闭审批记录</a></th>
			</tr>
			<tr>
				<td colspan="2" class="fyy-textRt"></td>
			</tr>
			<tr>
			   	<td colspan="2">
			   		<div class="area" id="approve_area">
						<textarea onpropertychange="if(value.length>300) value=value.substr(0,300)" id="textarea-a" placeholder="请输入审批意见..."></textarea>
						<h6>剩余<i id="textareaNum">300</i><i>/300</i>字</h6>
					</div>
			   	</td>
			</tr>
		</table>
		
	<script type="text/javascript">
		$(function(){
			//显示附件列表
			$("#showFile").click(function(){
				$(".toFile").show();
			});
			//关闭附件列表
			$("#hideFile").click(function(){
				$(".toFile").hide();
			});
			//显示审批记录
			$("#sliderDown").click(function(){
				$("table").find(".sh").show();
			});
			//关闭审批记录
			$("#sliderUp").click(function(){
				$("table").find(".sh").hide();
			});
			if($("#app_ui").val()=="false"){
				$(".dpFiles").hide();
			}
		});
	</script>