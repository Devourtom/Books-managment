package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.svse.dao.UserinfoDAO;
import com.svse.entity.UserinfoEntity;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/UserinfoServlet")
public class UserinfoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		UserinfoDAO dao = new UserinfoDAO();
		if(action.equalsIgnoreCase("all"))
		{	
			// ȫ��ѯ
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("upp"))
		{
			// �޸�
			String uname = new String(request.getParameter("uname").getBytes("ISO8859_1"), "utf-8");
			String upsw = new String(request.getParameter("upsw").getBytes("ISO8859_1"), "UTF-8");
			int uid = Integer.parseInt(request.getParameter("uid"));

			UserinfoEntity dept = new UserinfoEntity();
			dept.setUname(uname);
			dept.setUpsw(upsw);
			dept.setUid(uid);
			// �����޸�
			dao.updateUserinfo(dept);

			// ȫ��ѯ
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("add"))
		{

			// ����
			String uname = new String(request.getParameter("uname").getBytes("ISO8859_1"), "utf-8");
			String upsw = new String(request.getParameter("upsw").getBytes("ISO8859_1"), "UTF-8");

			UserinfoEntity dept = new UserinfoEntity();
			dept.setUname(uname);
			dept.setUpsw(upsw);
			// ��������
			dao.addUserinfo(dept);

			// ȫ��ѯ
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("one"))
		{
			// ��ѯһ������
			int uid = Integer.parseInt(request.getParameter("uid"));

			UserinfoEntity dept = dao.getOne(uid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/user/update.jsp").forward(request, response);

		}
		else
		{
			// ɾ��
			int uid = Integer.parseInt(request.getParameter("uid"));
			// ����ɾ��
			dao.delUserinfo(uid);

			// ȫ��ѯ
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
