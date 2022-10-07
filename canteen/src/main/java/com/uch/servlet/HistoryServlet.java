package com.uch.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uch.dao.FoodInfoDAO;
import com.uch.vo.FoodInfo;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String user_id=session.getAttribute("user_id").toString();
		FoodInfoDAO foodDAO = new FoodInfoDAO();
		System.out.println(user_id);
		
		//Map<String, FoodInfo> map=new HashMap<String, FoodInfo>();
		ArrayList<FoodInfo> foodList = foodDAO.selectFoodByUserId(user_id);
		//FoodInfo foodinfo = foodDAO.selectFoodByUserId(user_id);
		//map.put(user_id,foodinfo);
		//session.setAttribute("historyOrder", map);
		request.setAttribute("historyOrder", foodList);
		
		request.getRequestDispatcher("/showHistory.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
