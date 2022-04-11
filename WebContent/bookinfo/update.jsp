<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.BooksortinfoEntity"%>
<%@page import="com.svse.entity.BookinfoEntity"%>
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
<%
	BookinfoEntity de = (BookinfoEntity)request.getAttribute("yyy");
%>
	<div class="container">
		<div class="main_top">
			<div id="forms" class="mt10">
				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15">添加</b>
						</div>
						<div class="box_center">
							<form action="${pageContext.request.contextPath }/BookinfoServlet?bookinfo=upp" class="jqtransform" method="post">
								<table class="form_table pt15 pb15" width="100%" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
									<td class="td_right">所在类别：</td>
									<td>
									<select name="sid" class="input-text lh30">
						              <%
						                List<BooksortinfoEntity> ar=(ArrayList)request.getAttribute("myBook");
						                for(int i=0;i<ar.size();i++)
						                {
						              %>
						              <option value="<%=ar.get(i).getSid()%>"><%=ar.get(i).getSname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
									<tr>
										<td class="td_right">图书名称：</td>
										<td class=""><input type="text" name="bname"
											class="input-text lh30" size="40" value="<%=de.getBname()%>"></td>

									</tr>
									<tr>
										<td class="td_right">图书价格：</td>
										<td class=""><input type="text" name="bprice"
											class="input-text lh30" size="40" value="<%=de.getBprice()%>"></td>

									</tr>
									
									<tr>
										<td class="td_right">ISBN：</td>
										<td class=""><input type="text" name="bisbn"
											class="input-text lh30" size="40" value="<%=de.getBisbn()%>"></td>

									</tr>
									
									<tr>
										<td class="td_right">出版社：</td>
										<td class=""><input type="text" name="bpublish"
											class="input-text lh30" size="40" value="<%=de.getBpublish()%>"></td>

									</tr>
									
									<tr>
										<td class="td_right">作者：</td>
										<td class=""><input type="text" name="bauth"
											class="input-text lh30" size="40" value="<%=de.getBauth()%>"></td>

									</tr>
									<tr>
										<td class="td_right">数量：</td>
										<td class=""><input type="text" name="bcount"
											class="input-text lh30" size="40" value="<%=de.getBcount()%>"></td>

									</tr>
									

									<tr>
										<td class="td_right">图书备注：</td>
										<td class=""><textarea name="sremark" cols="30" rows="10"
												class="textarea"><%=de.getSremark()%></textarea></td>
									</tr>
									<tr>
										<td class="td_right">已经借出数量：</td>
										<td class=""><input type="text" name="bout"
											class="input-text lh30" size="40" value="<%=de.getBout()%>"></td>

									</tr>
									<input type="hidden" name="bid" value="<%=de.getBid()%>">

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
