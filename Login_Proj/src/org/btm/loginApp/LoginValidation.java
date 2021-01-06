package org.btm.loginApp;
import java.sql.*;
import java.util.Scanner;
public class LoginValidation 
{
public static void main(String[] args) 
{
	 Connection con = null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	 String qry="select username from btm.user where name=? and password=?";
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Name ??");
    String name=sc.next();
	System.out.println("Enter Password ??");
    String pwd=sc.next();
	sc.close();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		pstmt=con.prepareStatement(qry);
		//set the value for place holder
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			String un=rs.getString(1);
			System.out.println("Welcome "+un);
		}
		else {
			System.err.println("Invalid Name/Password");
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

