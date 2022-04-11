package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.CollegeinfoDAO;
import com.svse.dao.EmpinfoDAO;
import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.EmpinfoEntity;

/**
 * Servlet implementation class EmpinfoServlet
 */
@WebServlet("/EmpinfoServlet")
public class EmpinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String empinfo=request.getParameter("empinfo");
		EmpinfoDAO dao = new EmpinfoDAO();
		if(empinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);
		}
		
		
		else if (empinfo.equalsIgnoreCase("add"))
		{

			// 增加
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			int esex = Integer.parseInt(request.getParameter("esex"));
			int eage = Integer.parseInt(request.getParameter("eage"));

			EmpinfoEntity dept = new EmpinfoEntity();
			dept.setEname(ename);
			dept.setEsex(esex);
			dept.setEage(eage);
			
			// 调用增加
			dao.addEmpinfo(dept);

			// 全查询
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);

		}
		else if (empinfo.equalsIgnoreCase("one"))
		{
			// 查询一个对象
			int eid = Integer.parseInt(request.getParameter("eid"));

			EmpinfoEntity dept = dao.getOne(eid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/empinfo/update.jsp").forward(request, response);

		}
		else if (empinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			int eid = Integer.parseInt(request.getParameter("eid"));
			int esex = Integer.parseInt(request.getParameter("esex"));
			int eage = Integer.parseInt(request.getParameter("eage"));

			EmpinfoEntity dept = new EmpinfoEntity();
			dept.setEname(ename);
			dept.setEsex(esex);
			dept.setEage(eage);
			dept.setEid(eid);
			// 调用修改
			dao.updateEmpinfo(dept);

			// 全查询
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);

		}
		
		else
		{
			// 删除
			int eid = Integer.parseInt(request.getParameter("eid"));
			// 调用删除
			dao.delEmpinfo(eid);

			// 全查询
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
