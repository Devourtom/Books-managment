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
			// 全查询
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("upp"))
		{
			// 修改
			String uname = new String(request.getParameter("uname").getBytes("ISO8859_1"), "utf-8");
			String upsw = new String(request.getParameter("upsw").getBytes("ISO8859_1"), "UTF-8");
			int uid = Integer.parseInt(request.getParameter("uid"));

			UserinfoEntity dept = new UserinfoEntity();
			dept.setUname(uname);
			dept.setUpsw(upsw);
			dept.setUid(uid);
			// 调用修改
			dao.updateUserinfo(dept);

			// 全查询
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("add"))
		{

			// 增加
			String uname = new String(request.getParameter("uname").getBytes("ISO8859_1"), "utf-8");
			String upsw = new String(request.getParameter("upsw").getBytes("ISO8859_1"), "UTF-8");

			UserinfoEntity dept = new UserinfoEntity();
			dept.setUname(uname);
			dept.setUpsw(upsw);
			// 调用增加
			dao.addUserinfo(dept);

			// 全查询
			List<UserinfoEntity> ar = dao.getAll();
			request.setAttribute("xxx", ar);
			request.getRequestDispatcher("/user/all.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("one"))
		{
			// 查询一个对象
			int uid = Integer.parseInt(request.getParameter("uid"));

			UserinfoEntity dept = dao.getOne(uid);
			request.setAttribute("yyy", dept);
			request.getRequestDispatcher("/user/update.jsp").forward(request, response);

		}
		else
		{
			// 删除
			int uid = Integer.parseInt(request.getParameter("uid"));
			// 调用删除
			dao.delUserinfo(uid);

			// 全查询
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
