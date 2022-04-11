<%@page import="com.svse.entity.EmpinfoEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
</head>
<body>
<%

	EmpinfoEntity dept = (EmpinfoEntity)request.getAttribute("yyy");
%>
	<div class="container">
		<div class="main_top">
			<div id="forms" class="mt10">
				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15">更改信息</b>
						</div>
						<div class="box_center">
							<form action="${pageContext.request.contextPath }/EmpinfoServlet?empinfo=upp" method="post">
							      <table align="center">
							          <tr>
										<td class="td_right">员工姓名：</td>
										<td class=""><input type="text" name="ename"
											class="input-text lh30" size="40" value="<%=dept.getEname() %>"></td>

									</tr>
										
										<tr>
										<td class="td_right">员工性别：</td>
										<td class=""><input type="text" name="esex"
											class="input-text lh30" size="40" value="<%=dept.getEsex() %>"></td>

									</tr>
									<tr>
										<td class="td_right">员工年龄：</td>
										<td class=""><input type="text" name="eage"
											class="input-text lh30" size="40" value="<%=dept.getEage() %>"></td>

									</tr>
									
							          <input type="hidden" name="eid" value="<%=dept.getEid()%>">
							          <tr>
							          	<td class="td_right">&nbsp;</td>
							            <td class=""><input type="submit" name="button"
												class="btn btn82 btn_save2" value="保存">
							                
							             </td>
							            
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