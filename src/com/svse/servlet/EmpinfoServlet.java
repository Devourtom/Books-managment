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
			// ȫ��ѯ
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);
		}
		
		
		else if (empinfo.equalsIgnoreCase("add"))
		{

			// ����
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			int esex = Integer.parseInt(request.getParameter("esex"));
			int eage = Integer.parseInt(request.getParameter("eage"));

			EmpinfoEntity dept = new EmpinfoEntity();
			dept.setEname(ename);
			dept.setEsex(esex);
			dept.setEage(eage);
			
			// ��������
			dao.addEmpinfo(dept);

			// ȫ��ѯ
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);

		}
		else if (empinfo.equalsIgnoreCase("one"))
		{
			// ��ѯһ������
			int eid = Integer.parseInt(request.getParameter("eid"));

			EmpinfoEntity dept = dao.getOne(eid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/empinfo/update.jsp").forward(request, response);

		}
		else if (empinfo.equalsIgnoreCase("upp"))
		{
			// �޸�
			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			int eid = Integer.parseInt(request.getParameter("eid"));
			int esex = Integer.parseInt(request.getParameter("esex"));
			int eage = Integer.parseInt(request.getParameter("eage"));

			EmpinfoEntity dept = new EmpinfoEntity();
			dept.setEname(ename);
			dept.setEsex(esex);
			dept.setEage(eage);
			dept.setEid(eid);
			// �����޸�
			dao.updateEmpinfo(dept);

			// ȫ��ѯ
			List<EmpinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/empinfo/all.jsp").forward(request, response);

		}
		
		else
		{
			// ɾ��
			int eid = Integer.parseInt(request.getParameter("eid"));
			// ����ɾ��
			dao.delEmpinfo(eid);

			// ȫ��ѯ
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
