package org.btm.jdbcApp;
import java.sql.*;
public class FetchDemo {
		public static void main(String[] args) 
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String qry="select * from btm.student";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				pstmt=con.prepareStatement(qry);
				rs=	pstmt.executeQuery();
				while(rs.next())
				{
					int id=rs.getInt("id");
					String name=rs.getString(2);
					double perc=rs.getDouble(3);
					System.out.println(id+" "+name+" "+perc);
				}
			
			} 
			catch (ClassNotFoundException | SQLException e) 
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
				System.out.println("Closed All Costly Resources");
			}
		}
	}


