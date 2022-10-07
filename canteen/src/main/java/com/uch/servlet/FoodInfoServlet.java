package com.uch.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uch.dao.FoodInfoDAO;
import com.uch.dao.FoodOrderInfoDAO;
import com.uch.dao.UserInfoDAO;
import com.uch.vo.FoodInfo;
import com.uch.vo.FoodOrderInfo;
import com.uch.vo.Item;
import com.uch.vo.OrderInfo;
import com.uch.vo.UserInfo;
import com.uch.vo.UserId;


public class FoodInfoServlet extends HttpServlet {
	
	public FoodInfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		String op=request.getParameter("op");
		if(op.equals("reg"))
		{
			String reciver=request.getParameter("customerName") ;
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String tel=request.getParameter("tel");
			String mobile=request.getParameter("mobile");
			String notice=request.getParameter("notice");
			double totalPrice=Double.parseDouble(request.getParameter("totalPrice"));
			int user_id=Integer.parseInt(request.getParameter("user_id"));
			Item item = new Item();
			String order_sn = item.order_sn();
			FoodOrderInfo foodOrderinfo=new FoodOrderInfo(reciver,	address, email,	
					 tel,	mobile,	notice,	totalPrice, user_id, order_sn);
			 			 
			 FoodOrderInfoDAO forDAO =new FoodOrderInfoDAO();
			 boolean insert = forDAO.regUserInfo(foodOrderinfo);
			 if(insert)
			 {		
				String foods_id[] =request.getParameterValues("foods_id") ;
				String foods_name[] =request.getParameterValues("foods_name");
				String foods_number[] =request.getParameterValues("foods_number") ;
				String[] foods_price=request.getParameterValues("foods_price");
				String[] subtotal=request.getParameterValues("subtotal");
				String order_id = forDAO.selectIdBySn(order_sn);
					
				for (int i =0;i<foods_id.length;i++) {
					OrderInfo orderinfo=new OrderInfo(foods_id[i],	foods_name[i], foods_number[i],	
							foods_price[i], subtotal[i], order_id, order_sn);
					forDAO.regFoodInfo(orderinfo);
						 
					}
				 request.setAttribute("buy", "<h2>訂餐已完成...</h2><br/>"
				 		+ "		   	<h1>感謝您的訂餐<h1>");
				 request.getRequestDispatcher("/finish.jsp").forward(request, response);
			 }else
			 {
				 request.setAttribute("fail", "失敗");
				 request.getRequestDispatcher("/finish.jsp").forward(request, response);
			 }
		}
		if(op.equals("details"))
		{
			String foodid=request.getParameter("foodid");
			FoodInfo food= foodDAO.selectFoodById(foodid);
			request.setAttribute("food", food);
			request.getRequestDispatcher("/fooddetails.jsp").forward(request, response);
		}
		if(op.equals("login"))
		{	
			ArrayList<FoodInfo> foodlist = foodDAO.selectAllFood();
			request.setAttribute("foodlist", foodlist);
			request.getRequestDispatcher("/showfood.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	public void init() throws ServletException {

	}

}
