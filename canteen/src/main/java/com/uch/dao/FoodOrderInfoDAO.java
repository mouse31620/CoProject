package com.uch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uch.servlet.FoodInfoServlet;
import com.uch.vo.FoodOrderInfo;
import com.uch.vo.OrderInfo;
import com.uch.vo.UserId;

public class FoodOrderInfoDAO {

	public boolean regUserInfo(FoodOrderInfo foodOrderinfo)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		
		try
		{
			conn=BaseDAO.getConn();
			String sql = "insert into orderinfo (reciver, address, email, tel, mobile, notice, totalPrice, user_id, order_sn) values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);

			ps.setString(1, foodOrderinfo.getReciver());
			ps.setString(2, foodOrderinfo.getAddress());
			ps.setString(3, foodOrderinfo.getEmail());
			ps.setString(4, foodOrderinfo.getTel());
			ps.setString(5, foodOrderinfo.getMobile());
			ps.setString(6, foodOrderinfo.getNotice());
			ps.setDouble(7, foodOrderinfo.getTotalPrice());
			ps.setInt(8, foodOrderinfo.getUser_id());
			ps.setString(9, foodOrderinfo.getOrder_sn());
			
			int sult=ps.executeUpdate();
			
			if(sult>0)
			{
				flag=true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, null);
		}
		return flag;
	}
	public boolean regFoodInfo(OrderInfo orderinfo)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		
		try
		{
			conn=BaseDAO.getConn();
			String sql = "insert into orderfood (foods_id, foods_name, foods_number, foods_price, subtotal, order_id, order_sn) values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);

			ps.setString(1, orderinfo.getFoods_id());
			ps.setString(2, orderinfo.getFoods_name());
			ps.setString(3, orderinfo.getFoods_number());
			ps.setString(4, orderinfo.getFoods_price());
			ps.setString(5, orderinfo.getSubtotal());
			ps.setString(6, orderinfo.getOrder_id());
			ps.setString(7, orderinfo.getOrder_sn());
			
			
			int sult=ps.executeUpdate();
			
			if(sult>0)
			{
				flag=true;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, null);
		}
		return flag;
	}
	
	public String selectIdBySn(String order_sn) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sn = null;
		try {
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select order_id from orderinfo where order_sn=?");
			ps.setString(1, order_sn);
			rs=ps.executeQuery();
			while(rs.next()) {
				sn=rs.getString(1);
			}
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return sn;
	}
	
	
	
}
