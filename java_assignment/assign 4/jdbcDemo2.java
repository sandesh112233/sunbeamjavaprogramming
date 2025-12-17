package com.jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDemo2 {
	private static final String URL = "jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL , USERNAME , PASSWORD);
	}
	
	public static void ViewStudent() {
		String sql = "Select * from student";
		try {
			Connection c = getConnection();
			PreparedStatement sp = c.prepareStatement(sql);
			ResultSet rs = sp.executeQuery();
			while(rs.next()){
				int rollNo = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				System.out.println("RollNo : " + rollNo +"\nName : " + name + "\nEmail : " + email);
				System.out.println();
			}
			c.close();
			sp.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateStudent() {
		String sql = "Update student set email = 'rohit@gmail.com' where rollNo = 94821";
		try {
			Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Update Succesfully");
			c.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//ViewStudent();
		//UpdateStudent();
	}

}
