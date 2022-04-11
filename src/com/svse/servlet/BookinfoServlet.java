package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.BookinfoDAO;
import com.svse.dao.BooksortinfoDAO;
import com.svse.dao.DeptinfoDAO;
import com.svse.entity.BookinfoEntity;
import com.svse.entity.BooksortinfoEntity;
import com.svse.entity.DeptinfoEntity;
import com.svse.entity.MajorinfoEntity;

/**
 * Servlet implementation class BookinfoServlet
 */
@WebServlet("/BookinfoServlet")
public class BookinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookinfo = request.getParameter("bookinfo");
		BookinfoDAO dao = new BookinfoDAO();
		BooksortinfoDAO bdao = new BooksortinfoDAO();
		
		if(bookinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<BookinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/bookinfo/all.jsp").forward(request, response);
		}
		else if (bookinfo.equalsIgnoreCase("book"))
		{
			List<BooksortinfoEntity> ar = bdao.getAll();
			request.setAttribute("myBook", ar);
			request.getRequestDispatcher("bookinfo/add.jsp").forward(request, response);

		}
		else if (bookinfo.equalsIgnoreCase("add"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			String bname = new String(request.getParameter("bname").getBytes("ISO8859_1"), "utf-8");
			float bprice = Float.parseFloat(request.getParameter("bprice"));
			String bisbn = new String(request.getParameter("bisbn").getBytes("ISO8859_1"), "utf-8");
			String bpublish = new String(request.getParameter("bpublish").getBytes("ISO8859_1"), "utf-8");
			String bauth = new String(request.getParameter("bauth").getBytes("ISO8859_1"), "utf-8");
			int bcount = Integer.parseInt(request.getParameter("bcount"));
			String sremark = new String(request.getParameter("sremark").getBytes("ISO8859_1"), "utf-8");
			int bout = Integer.parseInt(request.getParameter("bout"));
			BookinfoEntity dept = new BookinfoEntity();

			dept.setSid(sid);
			dept.setBname(bname);
			dept.setBprice(bprice);
			dept.setBisbn(bisbn);
			dept.setBpublish(bpublish);
			dept.setBauth(bauth);
			dept.setBcount(bcount);
			dept.setSremark(sremark);
			dept.setBout(bout);

			dao.addBookinfo(dept);
			List<BookinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/bookinfo/all.jsp").forward(request, response);
		}
		

		else if (bookinfo.equalsIgnoreCase("one"))
		{
			List<BooksortinfoEntity> ar = bdao.getAll();
			request.setAttribute("myBook", ar);
			
			// 查询一个对象
			int bid = Integer.parseInt(request.getParameter("bid"));

			BookinfoEntity dept = dao.getOne(bid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/bookinfo/update.jsp").forward(request, response);

		}
		
		else if (bookinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int bid = Integer.parseInt(request.getParameter("bid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			String bname = new String(request.getParameter("bname").getBytes("ISO8859_1"), "utf-8");
			float bprice = Float.parseFloat(request.getParameter("bprice"));
			String bisbn = new String(request.getParameter("bisbn").getBytes("ISO8859_1"), "utf-8");
			String bpublish = new String(request.getParameter("bpublish").getBytes("ISO8859_1"), "utf-8");
			String bauth = new String(request.getParameter("bauth").getBytes("ISO8859_1"), "utf-8");
			int bcount = Integer.parseInt(request.getParameter("bcount"));
			String sremark = new String(request.getParameter("sremark").getBytes("ISO8859_1"), "utf-8");
			int bout = Integer.parseInt(request.getParameter("bout"));
			BookinfoEntity dept = new BookinfoEntity();
			
			dept.setBid(bid);
			dept.setSid(sid);
			dept.setBname(bname);
			dept.setBprice(bprice);
			dept.setBisbn(bisbn);
			dept.setBpublish(bpublish);
			dept.setBauth(bauth);
			dept.setBcount(bcount);
			dept.setSremark(sremark);
			dept.setBout(bout);

			// 调用修改
			dao.updateBookinfo(dept);

			// 全查询
			List<BookinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/bookinfo/all.jsp").forward(request, response);

		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
