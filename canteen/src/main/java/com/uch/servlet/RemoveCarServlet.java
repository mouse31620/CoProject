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
 * Servlet implementation class RemoveCarServlet
 */
@WebServlet("/RemoveCarServlet")
public class RemoveCarServlet extends HttpServlet {
	
    public RemoveCarServlet() {
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
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		HttpSession session=request.getSession();
		HashMap map=(HashMap)session.getAttribute("cart");
		
		map.remove(foodid);
		
		
		
		request.getRequestDispatcher("/showcart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void init() throws ServletException {
	}

}
