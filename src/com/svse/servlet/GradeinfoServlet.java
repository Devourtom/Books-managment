package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.GradeinfoDAO;
import com.svse.entity.GradeinfoEntity;
import com.svse.entity.UserinfoEntity;


/**
 * Servlet implementation class GradeinfoServlet
 */
@WebServlet("/GradeinfoServlet")
public class GradeinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gradeinfo=request.getParameter("gradeinfo");
		GradeinfoDAO dao = new GradeinfoDAO();
		if(gradeinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<GradeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/gradeinfo/all.jsp").forward(request, response);
		}
		else if (gradeinfo.equalsIgnoreCase("add"))
		{ 

			// 增加
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "UTF-8");

			GradeinfoEntity dept = new GradeinfoEntity();
			dept.setMname(mname);
			dept.setMremark(mremark);
			// 调用增加
			dao.addGradeinfo(dept);

			// 全查询
			List<GradeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/gradeinfo/all.jsp").forward(request, response);

		}
		else if (gradeinfo.equalsIgnoreCase("one"))
		{
			// 查询一个对象
			int gid = Integer.parseInt(request.getParameter("gid"));

			GradeinfoEntity dept = dao.getOne(gid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/gradeinfo/update.jsp").forward(request, response);

		}
		else if (gradeinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "UTF-8");
			int gid = Integer.parseInt(request.getParameter("gid"));

			GradeinfoEntity dept = new GradeinfoEntity();
			dept.setMname(mname);
			dept.setMremark(mremark);
			dept.setGid(gid);
			// 调用修改
			dao.updateGradeinfo(dept);

			// 全查询
			List<GradeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/gradeinfo/all.jsp").forward(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
