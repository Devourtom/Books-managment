package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.CollegeinfoDAO;
import com.svse.dao.DeptinfoDAO;
import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.DeptinfoEntity;


/**
 * Servlet implementation class DeptinfoServlet
 */
@WebServlet("/DeptinfoServlet")
public class DeptinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptinfo=request.getParameter("deptinfo");
		DeptinfoDAO ddao = new DeptinfoDAO();
		CollegeinfoDAO cdao = new CollegeinfoDAO();
		if(deptinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<DeptinfoEntity> ar = ddao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/deptinfo/all.jsp").forward(request, response);
		}
		else if (deptinfo.equalsIgnoreCase("college"))
		{
			// 全查询部门----下拉框的内容
			List<CollegeinfoEntity> ar = cdao.getAll();
			request.setAttribute("myCollege", ar);
			request.getRequestDispatcher("deptinfo/add.jsp").forward(request, response);

		}
		else if (deptinfo.equalsIgnoreCase("add"))
		{
			int eid = Integer.parseInt(request.getParameter("eid"));
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			String premark = new String(request.getParameter("premark").getBytes("ISO8859_1"), "utf-8");
			DeptinfoEntity dept = new DeptinfoEntity();

			dept.setEid(eid);
			dept.setPname(pname);
			dept.setPremark(premark);

			ddao.addDeptinfo(dept);
			List<DeptinfoEntity> ar = ddao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("deptinfo/all.jsp").forward(request, response);
		}
		else if (deptinfo.equalsIgnoreCase("one"))
		{
			// 全查询部门----下拉框的内容
			List<CollegeinfoEntity> ar = cdao.getAll();
			request.setAttribute("myCollege", ar);
			
			// 查询一个对象
			int pid = Integer.parseInt(request.getParameter("pid"));

			DeptinfoEntity dept = ddao.getOne(pid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/deptinfo/update.jsp").forward(request, response);

		}
		else if (deptinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int pid = Integer.parseInt(request.getParameter("pid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			String premark = new String(request.getParameter("premark").getBytes("ISO8859_1"), "utf-8");
			
			DeptinfoEntity dept = new DeptinfoEntity();

			dept.setPname(pname);
			dept.setPremark(premark);
			dept.setEid(eid);
			dept.setPid(pid);

			// 调用修改
			ddao.updateDeptinfo(dept);

			// 全查询
			List<DeptinfoEntity> ar = ddao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/deptinfo/all.jsp").forward(request, response);

		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
