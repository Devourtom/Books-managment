<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.BorrowinfoEntity"%>
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
                 <a href="${pageContext.request.contextPath }/BorrowinfoServlet?borrowinfo=MaBorrow" class="ext_btn"><span class="add"></span>添加</a>
              </div>
            </div>
     
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="15%">借书编号</th>
                   <th width="15%">学生编号</th>
                   <th width="15%">图书编号</th>
                   <th width="15">经办人编号</th>
                   <th width="30">借书日期</th>
                   <th width="10%">修改</th>
                </tr>
                	
		<%
			List<BorrowinfoEntity> ar = (ArrayList)request.getAttribute("xxx");
			for (int i = 0; i < ar.size(); i++)
			{
		%>
		<tr>
			<Td><%=ar.get(i).getWid() %></Td>
			<Td><%=ar.get(i).getSid() %></Td>
			<Td><%=ar.get(i).getBid() %></Td>
			<Td><%=ar.get(i).getEid()%></Td>
			<Td><%=ar.get(i).getBdate()%></Td>
			<Td><a href="${pageContext.request.contextPath }/BorrowinfoServlet?borrowinfo=one&wid=<%=ar.get(i).getWid() %>">修改</a></Td>
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
  