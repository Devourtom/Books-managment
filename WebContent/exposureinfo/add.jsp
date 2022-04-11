<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.EmpinfoEntity"%>
<%@page import="com.svse.entity.StuinfoEntity"%>
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
							<form action="${pageContext.request.contextPath }/ExposureinfoServlet?exposureinfo=add" class="jqtransform" method="post">
								<table class="form_table pt15 pb15" width="100%" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
									<td class="td_right">学生编号：</td>
									<td>
									<select name="sid" class="input-text lh30">
						              <%
						                List<StuinfoEntity> sr=(ArrayList)request.getAttribute("myStu");
						                for(int i=0;i<sr.size();i++)
						                {
						              %>
						              <option value="<%=sr.get(i).getSid()%>"><%=sr.get(i).getSname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
						            
						            <tr>
									<td class="td_right">经办人编号：</td>
									<td>
									<select name="eid" class="input-text lh30">
						              <%
						                List<EmpinfoEntity> br =(ArrayList)request.getAttribute("myEmp");
						                for(int i=0;i<br.size();i++)
						                {
						              %>
						              <option value="<%=br.get(i).getEid()%>"><%=br.get(i).getEname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
						            
									<tr>
										<td class="td_right">曝光事由：</td>
										<td class=""><textarea name="eremark" cols="30" rows="10"
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
