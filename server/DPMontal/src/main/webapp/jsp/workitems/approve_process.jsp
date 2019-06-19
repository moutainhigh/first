<%@ page language="java"  pageEncoding="UTF-8"%>
		<table width="100%">
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