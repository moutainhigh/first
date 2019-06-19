<%@page import="com.deppon.montal.conf.F_Constants"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.ApproveFssc"%>
<%@page import="com.deppon.fssc.module.remote.mobile.service.MobileFsscEntity"%>
<%@page import="com.deppon.fssc.module.remote.mobile.shared.AttachResource"%>
<%@page import="java.util.List"%>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>

<% 
	ApproveFssc[] appInfos = (ApproveFssc[])request.getAttribute("approvalInfos");

	String accountNode = "";
%>
<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
		<table width="100%">
		<tbody class="dpFiles">
		<!-- 附件信息 -->
			<tr class="files">
				<th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th>
			</tr>	
		   <tr class='toFile' style="display: none">
						<th colspan="2">
						<%MobileFsscEntity fsscFile = (MobileFsscEntity)request.getAttribute("mobileFsscEntity");
							AttachResource[] fileArray = fsscFile.getAttachResource();
     						int length = fileArray == null ? 0:fileArray.length;

							for(int i = 0 ; i < length ; i++) {
								%>
								<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&filePath=<%=fileArray[i].getAttachpath()%>&fileName=<%=fileArray[i].getAttachname()%>" style="color: red"><%=fileArray[i].getAttachname()%></a>&nbsp;
							<%} %>
						</th>
					</tr> 
			<tr class="toFile" style="display: none">
				<th colspan="2"><a class="yellow" id="hideFile">关闭附件列表</a></th>
			</tr>
			</tbody>
			<tr id="appstr">
				<th colspan="2"><a class="yellow" id="sliderDown">查看审批记录</a></th>
			</tr>					
			<%
				for(int i=0; i<appInfos.length-1; i++){//最后一条为当前申请节点，需过滤
					ApproveFssc  appInfo = appInfos[i];
					if ("费用核算组核算专员".contentEquals(appInfo.getCurrentactivitydefname())) {
						accountNode = "AccountXX";
					}
			%>
				 <tr <%=i==0?"class='sh'":"class='topLine sh'" %>><th>审批时间:</th> <td><%=appInfo.getApprovedateStr()%></td> </tr>
				 <tr class="sh"><th>审批处理人:</th> <td><%=appInfo.getApprover()%></td> </tr>
				 <tr class="sh"><th>审批人结果:</th> <td><%=F_Constants.WORKFLOW_RESULT_MAP.get(appInfo.getIsagree())%></td> </tr>
				 <tr class="sh"><th>审批人意见:</th> <td><%=appInfo.getApprovever()==null?"":appInfo.getApprovever()%></td> </tr>
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
		
		<input type="hidden" id ="AccountXXID" value = <%=accountNode %>>
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