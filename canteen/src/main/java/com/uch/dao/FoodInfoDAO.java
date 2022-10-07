package com.uch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.uch.vo.FoodInfo;

public class FoodInfoDAO {

	public FoodInfo selectFoodById(String foodid)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		FoodInfo food=null;
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from foodInfo where foodID="+foodid+"");

			rs=ps.executeQuery();
			if(rs.next())
			{
				food=new FoodInfo();
				food.setFoodID(rs.getString(1));
				food.setFoodName(rs.getString(2));
				food.setRemark(rs.getString(3));
				food.setFoodPrice(rs.getDouble(4));
				food.setDescription(rs.getString(5));
				food.setFoodImage(rs.getString(6));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return food;
	}

	public ArrayList<FoodInfo> selectAllFood()
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<FoodInfo> foodlist=new ArrayList<FoodInfo>();
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select * from foodinfo");
			rs=ps.executeQuery();
			while(rs.next())
			{
				FoodInfo food=new FoodInfo();
				food.setFoodID(rs.getString(1));
				food.setFoodName(rs.getString(2));
				food.setRemark(rs.getString(3));
				food.setFoodPrice(rs.getDouble(4));
				food.setDescription(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				foodlist.add(food);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return foodlist;
	}
	
	public ArrayList<FoodInfo> selectFoodByUserId(String user_id)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<FoodInfo> foodlist=new ArrayList<FoodInfo>();
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select i.reciver,i.add_time,f.foods_name,f.foods_number,f.foods_price,f.subtotal from orderfood f LEFT join orderinfo i on i.order_id = f.order_id where i.user_id=?");
			ps.setString(1, user_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				FoodInfo food=new FoodInfo();
				food.setReciver(rs.getString(1));
				food.setAdd_time(rs.getString(2));
				food.setFoodName(rs.getString(3));
				food.setFoods_number(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));
				food.setSubtotal(rs.getString(6));
				foodlist.add(food);
				//food.setFoodImage(rs.getString(7));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return foodlist;
	}
}