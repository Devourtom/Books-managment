package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.DeptinfoDAO;
import com.svse.dao.GradeinfoDAO;
import com.svse.dao.MajorinfoDAO;
import com.svse.dao.MyclassinfoDAO;
import com.svse.dao.StuinfoDAO;
import com.svse.entity.DeptinfoEntity;
import com.svse.entity.GradeinfoEntity;
import com.svse.entity.MajorinfoEntity;
import com.svse.entity.MyclassinfoEntity;
import com.svse.entity.StuinfoEntity;

/**
 * Servlet implementation class StuinfoServlet
 */
@WebServlet("/StuinfoServlet")
public class StuinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stuinfo = request.getParameter("stuinfo");
		StuinfoDAO dao = new StuinfoDAO();
		MyclassinfoDAO gdao = new MyclassinfoDAO();
		
		if(stuinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<StuinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/stuinfo/all.jsp").forward(request, response);
		}
		
		else if (stuinfo.equalsIgnoreCase("myGrade"))
		{
			// 全查询部门----下拉框的内容
			List<MyclassinfoEntity> ar = gdao.getAll();
			request.setAttribute("myStu", ar);
			request.getRequestDispatcher("stuinfo/add.jsp").forward(request, response);

		}
		else if (stuinfo.equalsIgnoreCase("add"))
		{
			int mid = Integer.parseInt(request.getParameter("mid"));
			String sname = new String(request.getParameter("sname").getBytes("ISO8859_1"), "utf-8");
			String ssex = new String(request.getParameter("ssex").getBytes("ISO8859_1"), "utf-8");
			String stel = new String(request.getParameter("stel").getBytes("ISO8859_1"), "utf-8");
			String saddress = new String(request.getParameter("saddress").getBytes("ISO8859_1"), "utf-8");
			StuinfoEntity dept = new StuinfoEntity();

			dept.setMid(mid);
			dept.setSname(sname);
			dept.setSsex(ssex);
			dept.setStel(stel);
			dept.setSaddress(saddress);

			dao.addStuinfo(dept);
			List<StuinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/stuinfo/all.jsp").forward(request, response);
		}
		
		
		else if (stuinfo.equalsIgnoreCase("one"))
		{

			List<MyclassinfoEntity> ar = gdao.getAll();
			request.setAttribute("myGrade", ar);
			
			// 查询一个对象
			int sid = Integer.parseInt(request.getParameter("sid"));

			StuinfoEntity dept = dao.getOne(sid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/stuinfo/update.jsp").forward(request, response);

		}
		else if (stuinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int sid = Integer.parseInt(request.getParameter("sid"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			String sname = new String(request.getParameter("sname").getBytes("ISO8859_1"), "utf-8");
			String ssex = new String(request.getParameter("ssex").getBytes("ISO8859_1"), "utf-8");
			String stel = new String(request.getParameter("stel").getBytes("ISO8859_1"), "utf-8");
			String saddress = new String(request.getParameter("saddress").getBytes("ISO8859_1"), "utf-8");
			
			StuinfoEntity dept = new StuinfoEntity();

			dept.setSname(sname);
			dept.setStel(stel);
			dept.setSaddress(saddress);
			dept.setSsex(ssex);
			dept.setMid(mid);
			dept.setSid(sid);

			// 调用修改
			dao.updateStuinfo(dept);

			// 全查询
			List<StuinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/stuinfo/all.jsp").forward(request, response);

		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
