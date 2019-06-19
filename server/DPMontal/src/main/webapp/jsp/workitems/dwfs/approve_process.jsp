<%@page import="com.deppon.wfs.workflow.domain.Fileupload"%>
<%@page import="java.util.List"%>
<%@page errorPage="/errorPage.jsp" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
	<%List<Fileupload> fileList = (List<Fileupload>)request.getAttribute("fileList"); %>
		<!-- 获取UI标记 ，转为判断附件是否显示的-->
		<input type="hidden" id="app_ui" value="<%=request.getAttribute("app_ui")%>">
	
		<table width="100%">
		<tbody class="dpFiles">
		<!-- 		<th>附件信息：</th> -->
			<tr class="files">
					<th colspan="2"><a class="yellow" id="showFile">查看附件列表</a></th>
				</tr>	
				<%Fileupload temp = new Fileupload();
				if(fileList!=null&&fileList.size()>0){
							for(int i = 0 ; i < fileList.size() ; i++) {
								temp = fileList.get(i);%>
					 <tr class='toFile' style="display:none;">
						<th colspan="2">
								<a href = "downloadFiles?syscode=<%=request.getAttribute("syscode")%>&fileId=<%=temp.getFileId()%>" style="color: red"><%=temp.getFileName()%></a>&nbsp;
						</th>
					</tr> 
					<%}} %>
				 <tr class="toFile" style="display: none">
					<th colspan="2"><a class="yellow" id="hideFile">关闭附件列表</a></th>
				</tr>
			</tbody>
			<tr>
					<tr id="appstr">
						<th colspan="2"><a class="yellow" id="sliderDown">查看审批记录</a></th>
					</tr>
					<tr id="qytr" style="display: none">
					 	<td colspan="2">查询中,请稍等...</td>
					 </tr>
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
		$("#showFile").click(function(){
			$(".toFile").slideDown();
		});
		$("#hideFile").click(function(){
			$(".toFile").slideUp();
		});
		if($("#app_ui").val()=="false"){
			$(".dpFiles").hide();
		}
	</script>