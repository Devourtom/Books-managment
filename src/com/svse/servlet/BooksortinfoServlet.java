package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.BooksortinfoDAO;
import com.svse.dao.UserinfoDAO;
import com.svse.entity.BooksortinfoEntity;
import com.svse.entity.UserinfoEntity;

/**
 * Servlet implementation class BooksortinfoServlet
 */
@WebServlet("/BooksortinfoServlet")
public class BooksortinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String booksortinfo=request.getParameter("booksortinfo");
		BooksortinfoDAO dao = new BooksortinfoDAO();
		if(booksortinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<BooksortinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/booksortinfo/all.jsp").forward(request, response);
		}
		
		else if (booksortinfo.equalsIgnoreCase("add"))
		{

			// 增加
			String sname = new String(request.getParameter("sname").getBytes("ISO8859_1"), "utf-8");
			String sremark = new String(request.getParameter("sremark").getBytes("ISO8859_1"), "UTF-8");

			BooksortinfoEntity dept = new BooksortinfoEntity();
			dept.setSname(sname);
			dept.setSremark(sremark);
			// 调用增加
			dao.addBooksortinfo(dept);

			// 全查询
			List<BooksortinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/booksortinfo/all.jsp").forward(request, response);

		}
		
		else if (booksortinfo.equalsIgnoreCase("one"))
		{
			// 查询一个对象
			int sid = Integer.parseInt(request.getParameter("sid"));

			BooksortinfoEntity dept = dao.getOne(sid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/booksortinfo/update.jsp").forward(request, response);

		}
		
		
		else if (booksortinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			String sname = new String(request.getParameter("sname").getBytes("ISO8859_1"), "utf-8");
			String sremark = new String(request.getParameter("sremark").getBytes("ISO8859_1"), "UTF-8");
			int sid = Integer.parseInt(request.getParameter("sid"));

			BooksortinfoEntity dept = new BooksortinfoEntity();
			dept.setSname(sname);
			dept.setSremark(sremark);
			dept.setSid(sid);
			// 调用修改
			dao.updateBooksortinfo(dept);

			// 全查询
			List<BooksortinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/booksortinfo/all.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
