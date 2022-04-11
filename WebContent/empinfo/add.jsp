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
							<b class="pl15">表单</b>
						</div>
						<div class="box_center">
							<form action="${pageContext.request.contextPath }/EmpinfoServlet?empinfo=add" class="jqtransform" method="post">
								<table class="form_table pt15 pb15" width="100%" border="0"
									cellpadding="0" cellspacing="0">
									<tr>
										<td class="td_right">员工姓名：</td>
										<td class=""><input type="text" name="ename"
											class="input-text lh30" size="40"></td>

									</tr>
										
										<tr>
										<td class="td_right">员工性别：</td>
										<td class=""><input type="text" name="esex"
											class="input-text lh30" size="40"></td>

									</tr>
									<tr>
										<td class="td_right">员工年龄：</td>
										<td class=""><input type="text" name="eage"
											class="input-text lh30" size="40"></td>

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
