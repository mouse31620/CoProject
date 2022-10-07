package com.uch.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uch.dao.FoodInfoDAO;
import com.uch.vo.FoodInfo;
import com.uch.vo.Item;

/**
 * Servlet implementation class CountCarServlet
 */
@WebServlet("/CountCarServlet")
public class CountCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CountCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void destroy() {
		super.destroy();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String foodid=request.getParameter("foodid");
		String count=request.getParameter("count");
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		HttpSession session=request.getSession();
		HashMap map=(HashMap)session.getAttribute("cart");
		if (count.equals("add")) {
			if(map.containsKey(foodid))
			{	
				Item item=(Item)map.get(foodid);
				item.setCount(item.getCount()+1);
				map.put(foodid, item);
				session.setAttribute("cart", map);
			}else
			{
				
				FoodInfo food=foodDAO.selectFoodById(foodid);
				Item item=new Item();
				item.setFoodInfo(food);
				item.setCount(1);
				map.put(foodid, item);
				session.setAttribute("cart", map);
				
			}
		}
		else if (count.equals("minus")) {
			Item item=(Item)map.get(foodid);
			if (item.getCount()>1) {
				item.setCount(item.getCount()-1);
				map.put(foodid, item);
				session.setAttribute("cart", map);
				
			}
			else {
				map.remove(foodid);
				
				
			}
			
		}
		
		
		request.getRequestDispatcher("/showcart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void init() throws ServletException {
	}

}
