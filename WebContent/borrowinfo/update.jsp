<%@page import="com.svse.entity.StuinfoEntity"%>
<%@page import="com.svse.entity.EmpinfoEntity"%>
<%@page import="com.svse.entity.BookinfoEntity"%>
<%@page import="com.svse.entity.BorrowinfoEntity"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
s<%@page import="java.util.List"%>
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
	BorrowinfoEntity ar=(BorrowinfoEntity)request.getAttribute("yyy");
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
							<form action="${pageContext.request.contextPath }/BorrowinfoServlet?borrowinfo=upp" method="post">
							      <table align="center">
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
									<td class="td_right">图书编号：</td>
									<td>
									<select name="bid" class="input-text lh30">
						              <%
						                List<BookinfoEntity> br =(ArrayList)request.getAttribute("myBook");
						                for(int i=0;i<br.size();i++)
						                {
						              %>
						              <option value="<%=br.get(i).getBid()%>"><%=br.get(i).getBname() %></option>
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
						                List<EmpinfoEntity> er =(ArrayList)request.getAttribute("myEmp");
						                for(int i=0;i<er.size();i++)
						                {
						              %>
						              <option value="<%=er.get(i).getEid()%>"><%=er.get(i).getEname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
						            
									<tr>
										<td class="td_right">借书日期：</td>
										<td class=""><input type="text" name="bdate"
											class="input-text lh30" size="40" value="<%=ar.getBdate() %>"></td>

									</tr>
							          <input type="hidden" name="wid" value="<%=ar.getWid()%>">

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