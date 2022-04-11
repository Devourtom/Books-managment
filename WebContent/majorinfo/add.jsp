<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.DeptinfoEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/colResizable-1.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common.js"></script>

<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});

	});
</script>
<title>Document</title>
</head>
<body>
	<div class="container">
		<div class="main_top">
			<div id="forms" class="mt10">
				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15">添加</b>
						</div>
						<div class="box_center">
							<form action="${pageContext.request.contextPath }/MajorinfoServlet?majorinfo=add" class="jqtransform" method="post">
								<table class="form_table pt15 pb15" width="100%" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
									<td class="td_right">所在系：</td>
									<td>
									<select name="pid" class="input-text lh30">
						              <%
						                List<DeptinfoEntity> ar=(ArrayList)request.getAttribute("myDept");
						                for(int i=0;i<ar.size();i++)
						                {
						              %>
						              <option value="<%=ar.get(i).getPid()%>"><%=ar.get(i).getPname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
									<tr>
										<td class="td_right">专业名称：</td>
										<td class=""><input type="text" name="mname"
											class="input-text lh30" size="40"></td>

									</tr>

									<tr>
										<td class="td_right">专业备注：</td>
										<td class=""><textarea name="mremark" cols="30" rows="10"
												class="textarea"></textarea></td>
									</tr>

									<tr>
										<td class="td_right">&nbsp;</td>
										<td class=""><input type="submit" name="button"
											class="btn btn82 btn_save2" value="保存"> <input
											type="button" name="button" class="btn btn82 btn_res"
											value="重置"></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
