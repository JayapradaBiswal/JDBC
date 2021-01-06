package org.btm.jdbcApp;
import java.sql.*;
public class Demo {
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm.student values(4,'Sn',65.22)";
		try {
			Class.forName("com.mysql.jdbc.Driver");//static
			System.out.println("Driver class loaded and Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DBServer");
			stmt=con.createStatement();//nonstatic
			System.out.println("Platform Created");
			stmt.executeUpdate(qry);
			System.out.println("Data Inserted!!!");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Closed All Costly Resources");
		}
	}
}
