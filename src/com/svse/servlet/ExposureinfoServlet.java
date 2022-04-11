package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.AlsoinfoDAO;
import com.svse.dao.BorrowinfoDAO;
import com.svse.dao.EmpinfoDAO;
import com.svse.dao.ExposureinfoDAO;
import com.svse.dao.StuinfoDAO;
import com.svse.entity.AlsoinfoEntity;
import com.svse.entity.BorrowinfoEntity;
import com.svse.entity.EmpinfoEntity;
import com.svse.entity.ExposureinfoEntity;
import com.svse.entity.StuinfoEntity;

/**
 * Servlet implementation class ExposureinfoServlet
 */
@WebServlet("/ExposureinfoServlet")
public class ExposureinfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String exposureinfo=request.getParameter("exposureinfo");
		ExposureinfoDAO dao = new ExposureinfoDAO();
		StuinfoDAO sdao = new StuinfoDAO();
		EmpinfoDAO edao = new EmpinfoDAO();
		
		if(exposureinfo.equalsIgnoreCase("all"))
		{	
			// 全查询
			List<ExposureinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("exposureinfo/all.jsp").forward(request, response);
		}
		else if (exposureinfo.equalsIgnoreCase("exposureinfo"))
		{
			List<StuinfoEntity> br = sdao.getAll();
			request.setAttribute("myStu", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);

			List<ExposureinfoEntity> ar = dao.getAll();
			request.setAttribute("myExposure", ar);
			request.getRequestDispatcher("exposureinfo/add.jsp").forward(request, response);

		}
		
		else if (exposureinfo.equalsIgnoreCase("add"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "utf-8");
			ExposureinfoEntity dept = new ExposureinfoEntity();

			dept.setSid(sid);
			dept.setEid(eid);
			dept.setEremark(eremark);

			dao.addExposureinfo(dept);
			List<ExposureinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("exposureinfo/all.jsp").forward(request, response);
		}

		else if (exposureinfo.equalsIgnoreCase("one"))
		{
			List<StuinfoEntity> br = sdao.getAll();
			request.setAttribute("myStu", br);
			
			List<EmpinfoEntity> er = edao.getAll();
			request.setAttribute("myEmp", er);

			
			// 查询一个对象
			int oid = Integer.parseInt(request.getParameter("oid"));

			ExposureinfoEntity dept = dao.getOne(oid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/exposureinfo/update.jsp").forward(request, response);

		}

		else if (exposureinfo.equalsIgnoreCase("upp"))
		{
			// 修改
			int oid = Integer.parseInt(request.getParameter("oid"));
			int sid = Integer.parseInt(request.getParameter("sid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "utf-8");
			ExposureinfoEntity dept = new ExposureinfoEntity();
			
			dept.setOid(oid);
			dept.setSid(sid);
			dept.setEid(eid);
			dept.setEremark(eremark);
			
			// 调用修改
			dao.updateExposureinfo(dept);

			// 全查询
			List<ExposureinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/exposureinfo/all.jsp").forward(request, response);

		}
		
		else
		{
			// 删除
			int aid = Integer.parseInt(request.getParameter("oid"));
			// 调用删除
			dao.delExposureinfo(aid);

			// 全查询
			List<ExposureinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/exposureinfo/all.jsp").forward(request, response);
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
