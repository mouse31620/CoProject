package com.uch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.uch.vo.UserInfo;
import com.microsoft.sqlserver.jdbc.StringUtils;
import com.uch.vo.UserId;

public class UserInfoDAO {
	
	public boolean InsertUser(UserInfo userInfo)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		
		try
		{
			conn=BaseDAO.getConn(); 
			String sql = "insert into userinfo (user_name,login_id,login_pw,email,tel,mobile,address,lastlogin) values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUser_name());
			ps.setString(2, userInfo.getLogin_id());
			ps.setString(3, userInfo.getLogin_pw());
			ps.setString(4, userInfo.getEmail());
			ps.setString(5, userInfo.getTel());
			ps.setString(6, userInfo.getMobile());			
			ps.setString(7, userInfo.getAddress());
			ps.setString(8, userInfo.getLastlogin());
			
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

	public boolean checkLogin(String login_id,String login_pw)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select login_id, login_pw from userinfo where login_id=? and login_pw=?");
			ps.setString(1, login_id);
			ps.setString(2, login_pw);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;				
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return flag;
	}
	
	public ArrayList<UserId> selectUserByName(String login_id)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserId user = null;
		ArrayList<UserId> result=new ArrayList<>();
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select user_id, user_name, login_pw, email, tel, mobile, address from userinfo where login_id=?");
			ps.setString(1, login_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user = new UserId();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setLogin_pw(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setMobile(rs.getString(6));
				user.setAddress(rs.getString(7));
				result.add(user);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return result;
	}
	
	public UserId selectUserByID(String username)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserId user = null;
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select user_id, user_name, login_pw, email, tel, mobile, address, permission from userinfo where login_id=?");
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user = new UserId();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setLogin_pw(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setMobile(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setPermission(rs.getInt("permission"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return user;
	}
	
	public boolean checkLogId(String login_id,String login_pw)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		
		try
		{
			conn=BaseDAO.getConn();
			ps=conn.prepareStatement("select login_id from userinfo where login_id=?");
			ps.setString(1, login_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				flag=true;				
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return flag;
	}
	public ArrayList<UserId> selectList(String sqlLike)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserId user = null;
		ArrayList<UserId> result=new ArrayList<>();
		String sql = "select * from userinfo ";
		
		try
		{
			conn=BaseDAO.getConn();
			if(!StringUtils.isEmpty(sqlLike)){
				String noBlankLike = sqlLike.trim();
				if(noBlankLike.length() > 0){
					sql += " where user_name like '%" + noBlankLike +"%' or tel like '%" + noBlankLike + "%' ";
				}
			}

				sql += " order by user_id desc";
			 ps =  conn.prepareStatement(sql);
			
			 rs = ps.executeQuery(sql);
			 
			 while (rs.next()) {
				 user = new UserId();
					user.setUser_id(rs.getInt(1));
					user.setUser_name(rs.getString(2));
					user.setLogin_id(rs.getString(3));
					user.setLogin_pw(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setTel(rs.getString(6));
					user.setMobile(rs.getString(7));
					user.setAddress(rs.getString(8));
					user.setPermission(rs.getInt("permission"));
					result.add(user);
				
			}

			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			BaseDAO.closeAll(conn, ps, rs);
		}
		return result;
	}

}

