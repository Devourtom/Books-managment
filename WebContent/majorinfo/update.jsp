<%@page import="com.svse.entity.MajorinfoEntity"%>
<%@page import="com.svse.entity.DeptinfoEntity"%>
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
	MajorinfoEntity de = (MajorinfoEntity)request.getAttribute("yyy");
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
							<form action="${pageContext.request.contextPath }/MajorinfoServlet?majorinfo=upp" method="post">
							      <table align="center">
							      	<tr>
									<td class="m">所在系：</td>
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
							             <td class="m">专业名称：</td>
							             <td class=""><input type="text" name="mname"
												class="input-text lh30" size="40" value="<%=de.getMname()%>"></td>
							          </tr>
							          
							          <tr>
										<td class="m">专业备注：</td>
										<td class=""><textarea name="mremark" cols="30" rows="10"
												class="textarea"><%=de.getMremark()%></textarea></td>
									  </tr>
							          
							        	<input type="hidden" name="mid" value="<%=de.getMid()%>">

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