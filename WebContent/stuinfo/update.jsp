<%@page import="com.svse.entity.StuinfoEntity"%>
<%@page import="com.svse.entity.MyclassinfoEntity"%>
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
	StuinfoEntity de = (StuinfoEntity)request.getAttribute("yyy");
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
							<form action="${pageContext.request.contextPath }/StuinfoServlet?stuinfo=upp" method="post">
							      <table align="center">
							      	<tr>
									<td class="m">所在班级：</td>
									<td>
									<select name="mid" class="input-text lh30">
						              <%
						                List<MyclassinfoEntity> ar=(ArrayList)request.getAttribute("myGrade");
						                for(int i=0;i<ar.size();i++)
						                {
						              %>
						              <option value="<%=ar.get(i).getCid()%>"><%=ar.get(i).getMname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
							      
							          <tr>
										<td class="td_right">学生姓名：</td>
										<td class=""><input type="text" name="sname"
											class="input-text lh30" size="40" value="<%=de.getSname() %>"></td>

									</tr>
									<tr>
										<td class="td_right">学生性别：</td>
										<td class=""><input type="text" name="ssex"
											class="input-text lh30" size="40" value="<%=de.getSsex() %>"></td>
									</tr>
									
									<tr>
										<td class="td_right">学生电话：</td>
										<td class=""><input type="text" name="stel"
											class="input-text lh30" size="40" value="<%=de.getStel() %>"></td>
									</tr>
									

									<tr>
										<td class="td_right">学生寝室地址：</td>
										<td class=""><textarea name="saddress" cols="30" rows="10"
												class="textarea" ><%=de.getSaddress() %></textarea></td>
									</tr>
									
							        	<input type="hidden" name="sid" value="<%=de.getSid()%>">

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