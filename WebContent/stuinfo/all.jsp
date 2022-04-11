<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.StuinfoEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
   
  <style type="text/css">
  
     *{
        text-align: center;
     }
  </style>
   <title>Document</title>
 </head>
 <body>
  <div class="container">
     <div id="table" class="mt10">
      <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
                 <a href="${pageContext.request.contextPath }/StuinfoServlet?stuinfo=myGrade" class="ext_btn"><span class="add"></span>添加</a>
              </div>
            </div>
     
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="10%">学生编号</th>
                   <th width="10%">班级编号</th>
                   <th width="15%">学生姓名</th>
                   <th width="10">学生性别</th>
                   <th width="15">学生电话</th>
                   <th width="30">学生寝室地址</th>
                   <th width="10%">修改</th>
                </tr>
                	
		<%
			List<StuinfoEntity> ar = (ArrayList)request.getAttribute("xxx");
			for (int i = 0; i < ar.size(); i++)
			{
		%>
		<tr>
			<Td><%=ar.get(i).getSid() %></Td>
			<Td><%=ar.get(i).getMid() %></Td>
			<Td><%=ar.get(i).getSname()%></Td>
			<Td><%=ar.get(i).getSsex() %></Td>
			<Td><%=ar.get(i).getStel() %></Td>
			<Td><%=ar.get(i).getSaddress()%></Td>
			<Td><a href="${pageContext.request.contextPath }/StuinfoServlet?stuinfo=one&sid=<%=ar.get(i).getSid() %>">修改</a></Td>
		</tr>
		<%
			}
		%>
              </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
  