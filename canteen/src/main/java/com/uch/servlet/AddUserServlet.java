package com.uch.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uch.dao.UserInfoDAO;
import com.uch.vo.UserInfo;

public class AddUserServlet extends HttpServlet {

	public AddUserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String login_id=request.getParameter("login_id");
		String login_pw=request.getParameter("login_pw");
		UserInfoDAO userDAO = new UserInfoDAO();
		String op=request.getParameter("op");
		
		if(op.equals("useradd")) 
		{
			boolean flag=userDAO.checkLogId(login_id, login_pw);
			boolean flag2=userDAO.checkLogin(login_id, login_pw);
			if(flag) {
				request.setAttribute("change", "帳號已註冊");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			else if(flag2)
			{				
				request.setAttribute("ok", "已註冊");
				request.getRequestDispatcher("/finish.jsp").forward(request, response);
			}else
			{
				String user_name=request.getParameter("user_name");
				String email=request.getParameter("email");
			 	String tel=request.getParameter("tel");
				String mobile=request.getParameter("mobile");
			 	String address=request.getParameter("address");
			 	String lastlogin=request.getParameter("lastlogin");
			 	UserInfo userinfo=new UserInfo(user_name, login_id, login_pw,
						email, tel,	mobile, address, lastlogin);
				
				if(userDAO.InsertUser(userinfo))
				{
					request.setAttribute("success", "會員註冊成功!!");
					request.getRequestDispatcher("/finish.jsp").forward(request, response);
				}else
				{
					request.setAttribute("faila", "會員註冊失敗!!");
					request.getRequestDispatcher("/finish.jsp").forward(request, response);
				}
			}
		  }		
	}

	public void init() throws ServletException {

	}
}
