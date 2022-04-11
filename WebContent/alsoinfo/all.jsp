<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.AlsoinfoEntity"%>
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
                 <a href="${pageContext.request.contextPath }/AlsoinfoServlet?alsoinfo=alsoinfo" class="ext_btn"><span class="add"></span>添加</a>
              </div>
            </div>
     
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="15%">还书编号</th>
                   <th width="15%">借书编号</th>
                   <th width="15%">经办人编号</th>
                   <th width="45">还书日期</th>
                   <th width="10%">修改</th>
                   <th width="10%">删除</th>
                </tr>
                	
		<%
			List<AlsoinfoEntity> ar = (ArrayList)request.getAttribute("xxx");
			for (int i = 0; i < ar.size(); i++)
			{
		%>
		<tr>
			<Td><%=ar.get(i).getAid() %></Td>
			<Td><%=ar.get(i).getWid() %></Td>
			<Td><%=ar.get(i).getEid() %></Td>
			<Td><%=ar.get(i).getAremark()%></Td>
			<Td><a href="${pageContext.request.contextPath }/AlsoinfoServlet?alsoinfo=one&aid=<%=ar.get(i).getAid() %>">修改</a></Td>
			<Td><a href="${pageContext.request.contextPath }/AlsoinfoServlet?alsoinfo=del&aid=<%=ar.get(i).getAid() %>">删除</a></Td>
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
  