package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.GradeinfoDAO;
import com.svse.dao.MajorinfoDAO;
import com.svse.dao.MyclassinfoDAO;
import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.DeptinfoEntity;
import com.svse.entity.GradeinfoEntity;
import com.svse.entity.MajorinfoEntity;
import com.svse.entity.MyclassinfoEntity;

/**
 * Servlet implementation class MyclassServlet
 */
@WebServlet("/MyclassinfoServlet")
public class MyclassinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String myclassinfo=request.getParameter("myclassinfo");
		MyclassinfoDAO dao = new MyclassinfoDAO();
		MajorinfoDAO mdao = new MajorinfoDAO();
		GradeinfoDAO gdao = new GradeinfoDAO();
		
		if(myclassinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<MyclassinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("myclassinfo/all.jsp").forward(request, response);
		}
		else if (myclassinfo.equalsIgnoreCase("MajorGrade"))
		{
			// 全查询部门----下拉框的内容
			List<MajorinfoEntity> mr = mdao.getAll();
			request.setAttribute("myMajor", mr);
			
			List<GradeinfoEntity> gr = gdao.getAll();
			request.setAttribute("myGrade", gr);
			request.getRequestDispatcher("myclassinfo/add.jsp").forward(request, response);

		}
		else if (myclassinfo.equalsIgnoreCase("add"))
		{
			int mid = Integer.parseInt(request.getParameter("mid"));
			int gid = Integer.parseInt(request.getParameter("gid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			MyclassinfoEntity dept = new MyclassinfoEntity();

			dept.setMid(mid);
			dept.setGid(gid);
			dept.setMname(mname);
			dept.setMremark(mremark);

			dao.addMyclassinfo(dept);
			List<MyclassinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("myclassinfo/all.jsp").forward(request, response);
		}
		
		else if (myclassinfo.equalsIgnoreCase("one"))
		{
			List<MajorinfoEntity> mr = mdao.getAll();
			request.setAttribute("myMajor", mr);
			
			List<GradeinfoEntity> gr = gdao.getAll();
			request.setAttribute("myGrade", gr);
			
			// 查询一个对象
			int cid = Integer.parseInt(request.getParameter("cid"));

			MyclassinfoEntity dept = dao.getOne(cid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/myclassinfo/update.jsp").forward(request, response);

		}
		else if (myclassinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int cid = Integer.parseInt(request.getParameter("cid"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			int gid = Integer.parseInt(request.getParameter("gid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			
			MyclassinfoEntity dept = new MyclassinfoEntity();

			dept.setMname(mname);
			dept.setMremark(mremark);
			dept.setGid(gid);
			dept.setMid(mid);
			dept.setCid(cid);

			// 调用修改
			dao.updateMyclassinfo(dept);

			// 全查询
			List<MyclassinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/myclassinfo/all.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
