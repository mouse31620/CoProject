package com.uch.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uch.dao.UserInfoDAO;
import com.uch.vo.UserId;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	
	public MemberServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
//		FoodInfoDAO foodDAO = new FoodInfoDAO();
		UserInfoDAO userDAO = new UserInfoDAO();
		String op = (String)request.getParameter("op");
		String username = (String)request.getParameter("username");
//		String op=request.getParameter("op");
//		HttpSession session=request.getSession();
		
		//執行
		if("member".equalsIgnoreCase(op)){

			ArrayList<UserId> userList = userDAO.selectList(username);
			
			
			request.setAttribute("users", userList);
			request.setAttribute("username", username == null ? "":username);
			
			request.getRequestDispatcher("/showMember.jsp").forward(request, response);
		
		}else{//回首頁.
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	public void init() throws ServletException {

	}

}
