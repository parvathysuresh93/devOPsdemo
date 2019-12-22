package com.vrms.rto.dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBHelper {
	


		
		static Connection con;
		public static Connection getConnection()
		{

			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RTO","rto1234");    

			}
			catch(Exception e)
			{
				System.out.println("**Error** : DBHelper:getConnection " +e.getMessage());
				
			}
			return con;
		}
		public static void closeConnection()
		{
			try {
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


