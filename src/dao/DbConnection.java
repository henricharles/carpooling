package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
 public void connect()
 {
	 try{
	 Class.forName("com.mysql.jdbc.Driver");  
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
	 Statement stmt=con.createStatement();  
	 ResultSet rs=stmt.executeQuery("select * from like");  
	 System.out.println("hello");
	 }
	 catch(Exception e)
	 {
		 
	 }
 }
 public static void main(String s)
 {
	 DbConnection d=new  DbConnection() ;
	 d.connect();
 }
}
