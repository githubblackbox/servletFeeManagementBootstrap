package com.cognizant.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

import com.cognizant.beans.AdminBean;




	public class AdminDao {
		
	public static int save(AdminBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into FEE_Admin(name,email,password,city,contact) values(?,?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setString(4,bean.getcity());
			ps.setString(5,bean.getContact());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	public static boolean validate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from FEE_Admin where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	public static int update(AdminBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update FEE_Admin set name=?,email=?,password=?,city=?,contact=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setString(4,bean.getcity());
			ps.setString(5,bean.getContact());
			ps.setInt(6,bean.getId());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}	

	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from FEE_Admin where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}

	public static List<AdminBean> getAllRecords(){
		List<AdminBean> list=new ArrayList<AdminBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from FEE_Admin");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AdminBean bean=new AdminBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setcity(rs.getString(5));
				bean.setContact(rs.getString(6));
				list.add(bean);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list;
	}

	public static AdminBean getRecordById(int id){
		AdminBean bean=new AdminBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from FEE_Admin where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setcity(rs.getString(5));
				bean.setContact(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return bean;
	}
	}

