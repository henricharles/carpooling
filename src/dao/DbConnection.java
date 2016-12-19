package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DbConnection {
	Connection con;
	 Statement stmt;
	 ResultSet rs;
 public void connect()
 {
	 try{
	 Class.forName("com.mysql.jdbc.Driver");  
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
	 Statement stmt=con.createStatement();  
	// ResultSet rs=stmt.executeQuery("select * from likes");  
	 System.out.println("hello");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }



public void createUser()
{
	String query1="insert into users VALUES(henri,1,Iowa,fairfield,4th ,52556,1988,ch@gam.com,'hello')";
	this.connect();
	try {
		stmt.executeQuery(query1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
	
	
}
}