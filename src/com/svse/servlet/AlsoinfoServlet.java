package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.AlsoinfoDAO;
import com.svse.dao.BookinfoDAO;
import com.svse.dao.BorrowinfoDAO;
import com.svse.dao.EmpinfoDAO;
import com.svse.dao.StuinfoDAO;
import com.svse.entity.AlsoinfoEntity;
import com.svse.entity.BookinfoEntity;
import com.svse.entity.BorrowinfoEntity;
import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.EmpinfoEntity;
import com.svse.entity.StuinfoEntity;

/**
 * Servlet implementation class AlsoinfoServlet
 */
@WebServlet("/AlsoinfoServlet")
public class AlsoinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String alsoinfo=request.getParameter("alsoinfo");
		AlsoinfoDAO dao = new AlsoinfoDAO();
		BorrowinfoDAO bdao = new BorrowinfoDAO();
		EmpinfoDAO edao = new EmpinfoDAO();
		
		if(alsoinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<AlsoinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("alsoinfo/all.jsp").forward(request, response);
		}
		else if (alsoinfo.equalsIgnoreCase("alsoinfo"))
		{
			List<BorrowinfoEntity> br = bdao.getAll();
			request.setAttribute("myBorrow", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);

			List<AlsoinfoEntity> ar = dao.getAll();
			request.setAttribute("myAlso", ar);
			request.getRequestDispatcher("alsoinfo/add.jsp").forward(request, response);

		}
		
		else if (alsoinfo.equalsIgnoreCase("add"))
		{
			int wid = Integer.parseInt(request.getParameter("wid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String aremark = new String(request.getParameter("aremark").getBytes("ISO8859_1"), "utf-8");
			AlsoinfoEntity dept = new AlsoinfoEntity();

			dept.setWid(wid);
			dept.setEid(eid);
			dept.setAremark(aremark);

			dao.addAlsoinfo(dept);
			List<AlsoinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("alsoinfo/all.jsp").forward(request, response);
		}
		

		else if (alsoinfo.equalsIgnoreCase("one"))
		{
			List<BorrowinfoEntity> br = bdao.getAll();
			request.setAttribute("myBorrow", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);

			
			// 查询一个对象
			int aid = Integer.parseInt(request.getParameter("aid"));

			AlsoinfoEntity dept = dao.getOne(aid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/alsoinfo/update.jsp").forward(request, response);

		}
		
		
		else if (alsoinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int aid = Integer.parseInt(request.getParameter("aid"));
			int wid = Integer.parseInt(request.getParameter("wid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String aremark = new String(request.getParameter("aremark").getBytes("ISO8859_1"), "utf-8");
			AlsoinfoEntity dept = new AlsoinfoEntity();
			
			dept.setWid(wid);
			dept.setAid(aid);
			dept.setEid(eid);
			dept.setAremark(aremark);
			
			// 调用修改
			dao.updateAlsoinfo(dept);

			// 全查询
			List<AlsoinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/alsoinfo/all.jsp").forward(request, response);

		}
		
		else
		{
			// 删除
			int aid = Integer.parseInt(request.getParameter("aid"));
			// 调用删除
			dao.delAlsoinfo(aid);

			// 全查询
			List<AlsoinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/alsoinfo/all.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
