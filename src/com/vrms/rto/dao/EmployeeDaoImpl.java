package com.vrms.rto.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.vrms.rto.bean.Employee;

//import com.spring.mvc.component.*;
 
@Repository
public class EmployeeDaoImpl {
 
    
    public static int addEmployee(Employee employee)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			//INSERT INTO `employee_mvc`.`USER_TAB` (`ID`, `NAME`, `USERID`, `password`, `phone`) VALUES ('501', 'ahana', 'ahana sarva', '190', '897979')
			
			con=DBHelper.getConnection();
			query = "INSERT INTO employee1 (firstName,lastName,emailId) VALUES(?,?,?)";
			
			ps=con.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmailId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			
			
			 result = ps.executeUpdate();

			 query = "delete from TB_FEEDBACK";
			 ps=con.prepareStatement(query);
			 ps.executeUpdate();
			 query = "INSERT INTO TB_FEEDBACK( id, name,place,comments ) SELECT id, firstname, lastname, emailid FROM employee1";
			 ps=con.prepareStatement(query);
			 result=ps.executeUpdate();
			    ps.close();
		        con.close();
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**Error** CustomerDL:addCustomer "+e.getMessage());
		}
		
	return result;
	}
    
    
	public static ArrayList<Employee> getEmployees()
	{
		ArrayList<Employee> employees=null;
		Connection con=null;
		  Statement statement =null;
		  ResultSet resultSet=null;
		  Employee employee=null;
		try
		{
			employees = new ArrayList<Employee>();
		        String sql = "SELECT * FROM  employee1 ORDER BY id DESC";
		        con=DBHelper.getConnection();
		        statement = con.createStatement();
		        resultSet = statement.executeQuery(sql);
		        while (resultSet.next()) {
		        	employee = new Employee();
		        	employee.setId(resultSet.getInt("id"));
		        	employee.setFirstName(resultSet.getString("firstName"));
		        	employee.setLastName(resultSet.getString("lastName"));
		        	employee.setEmailId(resultSet.getString("emailId"));
		      
		          
		        	employees.add(employee);
		        }
		         
		        resultSet.close();
		        statement.close();
		        con.close();
		       
			
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:getEmployees "+e.getMessage());
		}
		
	return employees;
	}
	public static Employee getEmployee(int id)
	{
		Connection con=null;
		Statement statement =null;
		ResultSet resultSet=null;
		Employee employee=null;
		
		try
		{
			
			
			String sql = "SELECT * FROM employee1 WHERE id="+id+"";
	        con=DBHelper.getConnection();
	        statement = con.createStatement();
	        resultSet = statement.executeQuery(sql);
	         if(resultSet.next()) {
	        	 employee = new Employee();
		        	employee.setId(resultSet.getInt("id"));
		        	employee.setFirstName(resultSet.getString("firstName"));
		        	employee.setLastName(resultSet.getString("lastName"));
		        	employee.setEmailId(resultSet.getString("emailId"));
		      
	         }
	         
	         return employee;
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:getEmployee "+e.getMessage());
		}
		
	return employee;
	}
	
	
	public static int updateEmployee(Employee employee)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "UPDATE employee1 SET firstName=?,lastName=?,emailId=? WHERE id=?";
			ps=con.prepareStatement(query);
		
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmailId());
			ps.setLong(4, employee.getId());
			
			
			 result = ps.executeUpdate();
			 
			 query = "delete from TB_FEEDBACK";
			 ps=con.prepareStatement(query);
			 ps.executeUpdate();
			 query = "INSERT INTO TB_FEEDBACK( id, name,place,comments ) SELECT id, firstname, lastname, emailid FROM employee1";
			 ps=con.prepareStatement(query);
			 result=ps.executeUpdate();
			
			 ps.close();
		        con.close();
		        
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:updateEmployee "+e.getMessage());
		}
		
	return result;
	}
	
	public static int deleteEmployee(int id)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		
		try
		{
			con=DBHelper.getConnection();
			query = "delete from employee1 where id=?";
			ps=con.prepareStatement(query);
			ps.setLong(1, id);
			 result = ps.executeUpdate();

			 query = "delete from TB_FEEDBACK";
			 ps=con.prepareStatement(query);
			 ps.executeUpdate();
			 query = "INSERT INTO TB_FEEDBACK( id, name,place,comments ) SELECT id, firstname, lastname, emailid FROM employee1";
			 ps=con.prepareStatement(query);
			 result=ps.executeUpdate();
			 
			    ps.close();
		        con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("**Error** EmployeeDaoimpl:deleteEmployee "+e.getMessage());
		}
		
	return result;
	}


	
    
}