package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.DeptinfoDAO;
import com.svse.dao.MajorinfoDAO;
import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.DeptinfoEntity;
import com.svse.entity.MajorinfoEntity;

/**
 * Servlet implementation class MajorinfoServlet
 */
@WebServlet("/MajorinfoServlet")
public class MajorinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String majorinfo = request.getParameter("majorinfo");
		DeptinfoDAO dao = new DeptinfoDAO();
		MajorinfoDAO mdao = new MajorinfoDAO();
		
		if(majorinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<MajorinfoEntity> ar = mdao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/majorinfo/all.jsp").forward(request, response);
		}
		else if (majorinfo.equalsIgnoreCase("dept"))
		{
			// 全查询部门----下拉框的内容
			List<DeptinfoEntity> ar = dao.getAll();
			request.setAttribute("myDept", ar);
			request.getRequestDispatcher("majorinfo/add.jsp").forward(request, response);

		}
		else if (majorinfo.equalsIgnoreCase("add"))
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			MajorinfoEntity dept = new MajorinfoEntity();

			dept.setPid(pid);
			dept.setMname(mname);
			dept.setMremark(mremark);

			mdao.addMajorinfo(dept);
			List<MajorinfoEntity> ar = mdao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/majorinfo/all.jsp").forward(request, response);
		}
		
		else if (majorinfo.equalsIgnoreCase("one"))
		{
			// 全查询部门----下拉框的内容
			List<DeptinfoEntity> ar = dao.getAll();
			request.setAttribute("myDept", ar);
			
			// 查询一个对象
			int mid = Integer.parseInt(request.getParameter("mid"));

			MajorinfoEntity dept = mdao.getOne(mid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/majorinfo/update.jsp").forward(request, response);

		}
		else if (majorinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int mid = Integer.parseInt(request.getParameter("mid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			
			MajorinfoEntity dept = new MajorinfoEntity();

			dept.setMname(mname);
			dept.setMremark(mremark);
			dept.setPid(pid);
			dept.setMid(mid);

			// 调用修改
			mdao.updateMajorinfo(dept);

			// 全查询
			List<MajorinfoEntity> ar = mdao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/majorinfo/all.jsp").forward(request, response);

		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
