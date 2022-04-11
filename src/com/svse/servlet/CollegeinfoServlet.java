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
			// ȫ��ѯ
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);
		}
		else if (Collegeinfo.equalsIgnoreCase("upp"))
		{
			// �޸�
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "UTF-8");
			int eid = Integer.parseInt(request.getParameter("eid"));

			CollegeinfoEntity dept = new CollegeinfoEntity();
			dept.setEname(ename);
			dept.setEremark(eremark);
			dept.setEid(eid);
			// �����޸�
			dao.updateCollegeinfo(dept);

			// ȫ��ѯ
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);

		}
		else if (Collegeinfo.equalsIgnoreCase("add"))
		{

			// ����
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String eremark = new String(request.getParameter("eremark").getBytes("ISO8859_1"), "UTF-8");

			CollegeinfoEntity dept = new CollegeinfoEntity();
			dept.setEname(ename);
			dept.setEremark(eremark);
			// ��������
			dao.addCollegeinfo(dept);

			// ȫ��ѯ
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);

		}
		
		else if (Collegeinfo.equalsIgnoreCase("one"))
		{
			// ��ѯһ������
			int eid = Integer.parseInt(request.getParameter("eid"));

			CollegeinfoEntity dept = dao.getOne(eid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/collegeinfo/update.jsp").forward(request, response);

		}
		else
		{
			// ɾ��
			int eid = Integer.parseInt(request.getParameter("eid"));
			// ����ɾ��
			dao.delCollegeinfo(eid);

			// ȫ��ѯ
			List<CollegeinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/collegeinfo/all.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
