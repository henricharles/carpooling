package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.sql.PreparedStatement;

import model.Comment;
import model.Like;
import model.Post;
import model.User;

public class DbConnection {
	Connection con;
	 Statement stmt;
	 ResultSet rs;
	 
	 public void createLike(Like like)
	 {
		 int userId=like.getUserId();
		 int postId=like.getPostId();
		 try{
				 Class.forName("com.mysql.jdbc.Driver");  
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
				  stmt=con.createStatement(); 
				  String sql="insert into likes(userid,postid) VALUES('"+userId+"',+'"+postId+"')";
				  PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
				  pr.execute();
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
	 }
	 
	 public void  createCommement(Comment cmt)
	 {
		 try{
			 String comment= cmt.getComment();
			int postId=cmt.getPostId();
			int userId=cmt.getUserId();
		
				 Class.forName("com.mysql.jdbc.Driver");  
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
				  stmt=con.createStatement(); 
				  String sql="insert into Comments(userid,postid,comment) VALUES('"+userId+"',+'"+postId+"','"+comment+"')";
				  PreparedStatement pr=con.prepareStatement(sql);
				  pr.execute();
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
	 }
	 
	public void createPost(Post p)
	{
		try{
			int uid=p.getUserId();
			String post=p.getPost();
			int type=p.getPosttype();
			
			 Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
			  stmt=con.createStatement(); 
			  String sql="insert into posts(userid,post,posttype) VALUES('"+uid+"',+'"+post+"','"+type+"')";
			  PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
			  pr.execute();
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public void createUser(User user)
{
	Connection con;
	 Statement stmt;
	 ResultSet rs;

	 try{

		 Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		  stmt=con.createStatement(); 
		  
		  String sql="insert into users(fullname,gender,state,city,street,zipcode,birthyear,email,password) "
		  		+ "VALUES('"+user.getFullName()+"',+'"+user.getGender()+"','"+user.getState()+"','"+user.getCity()+"','"+user.getStreet()+"','"+user.getZipcode()+"','"+user.getBirthYear()+"','"+user.getEmail()+"','"+user.getPassword()+"')";
		  PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
		  pr.execute();
	  
	  // rs=stmt.executeQuery(query1);  
	 System.out.println("user successful created");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
}
public void updateUser(User user,int id)
{
	String sql="update users set fullname='"+user.getFullName()+"',gender='"+user.getGender()+"',state='"+user.getState()+"',"
			+ "city='"+user.getCity()+"',street='"+user.getStreet()+"',zipcode='"+user.getZipcode()+"',birthyear='"+user.getBirthYear()+"',"
					+ "email='"+user.getEmail()+"',password='"+user.getPassword()+"'";
	
	try{

		 Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		  stmt=con.createStatement(); 
		  PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
		  pr.execute();
		  System.out.println("user successful created");
	}
	catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
}
//login part

public int useid(String email,String pwd)
{
	  int id=0;
	String sql="select * from users where email='"+email+"' and password='"+pwd+"'";
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		 PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		 ResultSet  rs=st.executeQuery();
		  rs=st.executeQuery(sql);
		
		  while(rs.next())
			 id= rs.getInt("userid");
		  
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return id;
}
	public boolean userlogin(String email,String pwd) throws SQLException, ClassNotFoundException
	{
		boolean b=false;
		int count=0;
		String sql="select * from users where email='"+email+"' and password='"+pwd+"'";
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
			 PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			 ResultSet  rs=st.executeQuery();
			  rs=st.executeQuery(sql);
			 while(rs.next())
			 {
				  count++;
			 }
			 
			 if(count>0)
				 b=true;
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return b;
	}
}