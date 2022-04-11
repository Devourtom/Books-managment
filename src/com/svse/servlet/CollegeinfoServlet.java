package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.CollegeinfoDAO;
import com.svse.entity.CollegeinfoEntity;

/**
 * Servlet implementation class CollegeinfoServlet
 */
@WebServlet("/CollegeinfoServlet")
public class CollegeinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Collegeinfo=request.getParameter("Collegeinfo");
		CollegeinfoDAO dao = new CollegeinfoDAO();
		if(Collegeinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);
		}
		else if (Collegeinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "UTF-8");
			int eid = Integer.parseInt(request.getParameter("eid"));

			CollegeinfoEntity dept = new CollegeinfoEntity();
			dept.setEname(ename);
			dept.setEremark(eremark);
			dept.setEid(eid);
			// 调用修改
			dao.updateCollegeinfo(dept);

			// 全查询
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);

		}
		else if (Collegeinfo.equalsIgnoreCase("add"))
		{

			// 增加
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "UTF-8");

			CollegeinfoEntity dept = new CollegeinfoEntity();
			dept.setEname(ename);
			dept.setEremark(eremark);
			// 调用增加
			dao.addCollegeinfo(dept);

			// 全查询
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);

		}
		
		else if (Collegeinfo.equalsIgnoreCase("one"))
		{
			// 查询一个对象
			int eid = Integer.parseInt(request.getParameter("eid"));

			CollegeinfoEntity dept = dao.getOne(eid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/collegeinfo/update.jsp").forward(request, response);

		}
		else
		{
			// 删除
			int eid = Integer.parseInt(request.getParameter("eid"));
			// 调用删除
			dao.delCollegeinfo(eid);

			// 全查询
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
