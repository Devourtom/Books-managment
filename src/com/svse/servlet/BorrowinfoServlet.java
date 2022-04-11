package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.BookinfoDAO;
import com.svse.dao.BorrowinfoDAO;
import com.svse.dao.EmpinfoDAO;
import com.svse.dao.GradeinfoDAO;
import com.svse.dao.MajorinfoDAO;
import com.svse.dao.MyclassinfoDAO;
import com.svse.dao.StuinfoDAO;
import com.svse.entity.BookinfoEntity;
import com.svse.entity.BorrowinfoEntity;
import com.svse.entity.EmpinfoEntity;
import com.svse.entity.GradeinfoEntity;
import com.svse.entity.MajorinfoEntity;
import com.svse.entity.MyclassinfoEntity;
import com.svse.entity.StuinfoEntity;

/**
 * Servlet implementation class BorrowinfoServlet
 */
@WebServlet("/BorrowinfoServlet")
public class BorrowinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String borrowinfo=request.getParameter("borrowinfo");
		BorrowinfoDAO dao = new BorrowinfoDAO();
		BookinfoDAO bdao = new BookinfoDAO();
		StuinfoDAO sdao = new StuinfoDAO();
		EmpinfoDAO edao = new EmpinfoDAO();
		
		if(borrowinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<BorrowinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("borrowinfo/all.jsp").forward(request, response);
		}
		else if (borrowinfo.equalsIgnoreCase("MaBorrow"))
		{
			List<StuinfoEntity> sr = sdao.getAll();
			request.setAttribute("myStu", sr);
			
			List<BookinfoEntity> br = bdao.getAll();
			request.setAttribute("myBook", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);
			
			List<BorrowinfoEntity> ar = dao.getAll();
			request.setAttribute("myBorrow", ar);
			request.getRequestDispatcher("borrowinfo/add.jsp").forward(request, response);

		}
		
		else if (borrowinfo.equalsIgnoreCase("add"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			int bid = Integer.parseInt(request.getParameter("bid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String bdate = new String(request.getParameter("bdate").getBytes("ISO8859_1"), "utf-8");
			BorrowinfoEntity dept = new BorrowinfoEntity();

			dept.setSid(sid);
			dept.setBid(bid);
			dept.setEid(eid);
			dept.setBdate(bdate);

			dao.addBorrowinfo(dept);
			List<BorrowinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("borrowinfo/all.jsp").forward(request, response);
		}
		
		
		else if (borrowinfo.equalsIgnoreCase("one"))
		{
			List<StuinfoEntity> sr = sdao.getAll();
			request.setAttribute("myStu", sr);
			
			List<BookinfoEntity> br = bdao.getAll();
			request.setAttribute("myBook", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);
			
			// 查询一个对象
			int wid = Integer.parseInt(request.getParameter("wid"));

			BorrowinfoEntity dept = dao.getOne(wid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/borrowinfo/update.jsp").forward(request, response);

		}
		
		else if (borrowinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int wid = Integer.parseInt(request.getParameter("wid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			int bid = Integer.parseInt(request.getParameter("bid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String bdate = new String(request.getParameter("bdate").getBytes("ISO8859_1"), "utf-8");
			BorrowinfoEntity dept = new BorrowinfoEntity();
			
			dept.setWid(wid);
			dept.setSid(sid);
			dept.setBid(bid);
			dept.setEid(eid);
			dept.setBdate(bdate);
			
			// 调用修改
			dao.updateBorrowinfo(dept);

			// 全查询
			List<BorrowinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/borrowinfo/all.jsp").forward(request, response);

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
