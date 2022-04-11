<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.BookinfoEntity"%>
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
                 <a href="${pageContext.request.contextPath }/BookinfoServlet?bookinfo=book" class="ext_btn"><span class="add"></span>添加</a>
              </div>
            </div>
     
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="5%">图书编号</th>
                   <th width="5%">类别编号</th>
                   <th width="10%">图书名称</th>
                   <th width="5%">图书价格</th>
                   <th width="10%">ISBN</th>
                   <th width="10%">出版社</th>
                   <th width="10%">作者</th>
                   <th width="5%">数量</th>
                   <th width="20%">图书备注</th>
                   <th width="10%">已经借出数量</th>
                   <th width="5%">修改</th>
                </tr>
                	
		<%
			List<BookinfoEntity> ar = (ArrayList)request.getAttribute("xxx");
			for (int i = 0; i < ar.size(); i++)
			{
		%>
		<tr>
			<Td><%=ar.get(i).getBid() %></Td>
			<Td><%=ar.get(i).getSid() %></Td>
			<Td><%=ar.get(i).getBname()%></Td>
			<Td><%=ar.get(i).getBprice()%></Td>
			<Td><%=ar.get(i).getBisbn() %></Td>
			<Td><%=ar.get(i).getBpublish() %></Td>
			<Td><%=ar.get(i).getBauth() %></Td>
			<Td><%=ar.get(i).getBcount() %></Td>
			<Td><%=ar.get(i).getSremark() %></Td>
			<Td><%=ar.get(i).getBout() %></Td>
			
			<Td><a href="${pageContext.request.contextPath }/BookinfoServlet?bookinfo=one&bid=<%=ar.get(i).getBid() %>">修改</a></Td>
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
  