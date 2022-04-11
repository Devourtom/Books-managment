<%@page import="com.svse.entity.MajorinfoEntity"%>
<%@page import="com.svse.entity.GradeinfoEntity"%>
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
	MyclassinfoEntity ar=(MyclassinfoEntity)request.getAttribute("yyy");
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
							<form action="${pageContext.request.contextPath }/MyclassinfoServlet?myclassinfo=upp" method="post">
							      <table align="center">
							      	<tr>
									<td class="m">所在专业：</td>
									<td>
									<select name="mid" class="input-text lh30">
						              <%
						                List<MajorinfoEntity> mr = (ArrayList)request.getAttribute("myMajor");
						                for(int i=0;i<mr.size();i++)
						                {
						              %>
						              <option value="<%=mr.get(i).getMid()%>"><%=mr.get(i).getMname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
						            
						            <tr>
									<td class="m">所在年级：</td>
									<td>
									<select name="gid" class="input-text lh30">
						              <%
						                List<GradeinfoEntity> gr = (ArrayList)request.getAttribute("myGrade");
						                for(int i=0;i<gr.size();i++)
						                {
						              %>
						              <option value="<%=gr.get(i).getGid()%>"><%=gr.get(i).getMname() %></option>
						              <%
						                }
						              %>
						             
						            </select>
						            </td>
						            </tr>
							      
							          <tr>
							             <td class="m">班级名称：</td>
							             <td class=""><input type="text" name="mname"
												class="input-text lh30" size="40" value="<%=ar.getMname()%>"></td>
							          </tr>
							          
							          <tr>
										<td class="m">班级备注：</td>
										<td class=""><textarea name="mremark" cols="30" rows="10"
												class="textarea"><%=ar.getMremark()%></textarea></td>
									  </tr>
							          
							          <input type="hidden" name="cid" value="<%=ar.getCid()%>">

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