

package org.btm.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class FetchDemo2 
{
public static void main(String[] args) 
{
	 Connection con = null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 String qry="select * from btm.student where perc=?";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Perc ??");
	double perc=sc.nextDouble();
	sc.close();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		pstmt=con.prepareStatement(qry);
		//set the value for place holder
		pstmt.setDouble(1,perc);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			System.out.println("Id="+id+" "+"Name="+name );
		}
		else {
			System.err.println("No data found for Name "+perc);
		}
	}catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		if(rs!=null)
		{
			try {
				rs.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
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
	}
}
}
