
package org.btm.jdbcApp;
import java.sql.*;
import java.util.Scanner;
public class FetchDemo1 
{
public static void main(String[] args) 
{
	 Connection con = null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 String qry="select * from btm.student where name=?";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Name ??");
	String name=sc.nextLine();
	sc.close();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		pstmt=con.prepareStatement(qry);
		//set the value for place holder
		pstmt.setString(1,name);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			double perc=rs.getDouble(3);
			System.out.println("Id="+id+" "+"Perc="+perc );
		}
		else {
			System.err.println("No data found for Name "+name);
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
