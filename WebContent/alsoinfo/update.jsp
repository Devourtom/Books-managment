<%@page import="com.svse.entity.EmpinfoEntity"%>
<%@page import="com.svse.entity.AlsoinfoEntity"%>
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
	AlsoinfoEntity ar=(AlsoinfoEntity)request.getAttribute("yyy");
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
							<form action="${pageContext.request.contextPath }/AlsoinfoServlet?alsoinfo=upp" method="post">
							      <table align="center">
							       
						            <tr>
									<td class="td_right">借书编号：</td>
									<td>
									<select name="wid" class="input-text lh30">
						              <%
						                List<BorrowinfoEntity> sr=(ArrayList)request.getAttribute("myBorrow");
						                for(int i=0;i<sr.size();i++)
						                {
						              %>
						              <option value="<%=sr.get(i).getWid()%>"><%=sr.get(i).getWid() %></option>
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
										<td class="td_right">还书日期：</td>
										<td class=""><input type="text" name="aremark"
											class="input-text lh30" size="40" value="<%=ar.getAremark() %>"></td>

									</tr>

							          <input type="hidden" name="aid" value="<%=ar.getAid()%>">

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