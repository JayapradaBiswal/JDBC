package org.btm.jdbcApp;
import java.sql.*;
public class InsertDemo {
		public static void main(String[] args) 
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			String qry="insert into btm.student values(?,?,?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");//static
				System.out.println("Driver class loaded and Registered");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				System.out.println("Connection Established with DBServer");
				pstmt=con.prepareStatement(qry);//nonstatic
				System.out.println("Platform Created");
				//SET THE VALUE FOR PLACE HOLDER
				pstmt.setInt(1,70);
				pstmt.setString(2,"pk");
				pstmt.setDouble(3,76.39);
				pstmt.executeUpdate();
				
				pstmt.setInt(1,4);
				pstmt.setString(2,"jp");
				pstmt.setDouble(3,77.99);
				pstmt.executeUpdate();
				
				pstmt.setInt(1,30);
				pstmt.setString(2,"Al");
				pstmt.setDouble(3,80.39);
				pstmt.executeUpdate();
				System.out.println("Data Inserted!!!");
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				if(pstmt!=null)
				{
					try {
						pstmt.close();
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


