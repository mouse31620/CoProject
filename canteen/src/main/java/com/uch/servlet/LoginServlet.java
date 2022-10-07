package com.uch.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uch.dao.UserInfoDAO;
import com.uch.vo.FoodInfo;
import com.uch.vo.Item;
import com.uch.vo.UserId;

public class LoginServlet extends HttpServlet {
	
	public LoginServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String op = request.getParameter("op");
		
		/**
		 * 
		 * 
		Map<String,String> errors = new HashMap<String,String>();
		
		if(username == null || "".equals(username)) {
			errors.put("username", "請輸會員姓名不能為空");
		}
		if(userpass == null || "".equals(userpass)) {
			errors.put("userpass", "請輸密碼不能為空");
		}
		String msg="用戶登入失敗,錯誤的會員姓名或密碼!";
		if(errors.size() == 0)
		{
		
		}else {
			
			request.setAttribute("errors", msg);
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/finish.jsp").forward(request, response);
 
		 */
		
			
		
			UserInfoDAO userDAO=new UserInfoDAO();
			boolean flag=userDAO.checkLogin(username, userpass);
			if(op.equalsIgnoreCase("logout")) {
				HttpSession session=request.getSession();
				
				session.invalidate();
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}
			else {
				if(flag)
				{	
					HttpSession session=request.getSession();
					Map<String, UserId> map=new HashMap<String, UserId>();
					UserId user = userDAO.selectUserByID(username);
					map.put(username, user);
					session.setAttribute("user", map);
					session.setAttribute("permission", map.get(username).getPermission());
					session.setAttribute("user_id", map.get(username).getUser_id());
					
					
					request.getRequestDispatcher("/foodinfoservlet").forward(request, response);
					
				}else
				{
					response.sendRedirect("/canteen/register.jsp");
				}
			}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
	public void init() throws ServletException {
		
	}

}

