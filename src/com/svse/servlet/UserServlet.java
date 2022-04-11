package com.svse.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.UserinfoDAO;
import com.svse.entity.UserinfoEntity;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        UserinfoDAO user = new UserinfoDAO();
        
        
        String code = request.getParameter("action");
        
        if (code.equals("login")){
            UserinfoEntity userEntity = new UserinfoEntity();
            userEntity.setUname(request.getParameter("uname"));
            userEntity.setUpsw(request.getParameter("upsw"));
            int t = user.login(userEntity);

            if (t>0){
              
                request.getRequestDispatcher("/main/main.jsp").forward(request,response);

            }else{
                
                request.getRequestDispatcher("eorr.jsp").forward(request,response);

            }

        }
		
		
	}

}
