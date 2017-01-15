package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Post;

public class JsonDao {
	Connection con;
	List<Post> posts;
	List<Comment> comments;
	
	
	public List<Post> userPost(int id)throws SQLException, ClassNotFoundException{
		
		posts =new ArrayList<Post>();
		String sql="select * from Posts where userid='"+id+"'";
		// ResultSet rs=null;
		Class.forName("com.mysql.jdbc.Driver");
	
	try(
		  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		 PreparedStatement st = con.prepareStatement(sql);
		 ResultSet  rs=st.executeQuery();)
		{
		 while(rs.next())
		 {
			 Post p=new Post();
			 p.setPostId(rs.getInt("userid"));
			 p.setPostId(rs.getInt("postid"));
			 p.setPost(rs.getString("post"));
			 p.setDateCreated(rs.getDate("datecreated"));
			 p.setPosttype(rs.getInt("posttype"));
			 p.setDateUpdate(rs.getDate("dateupdated"));
			 posts.add(p);
		 }
		 
		}
	return posts;
	}
	
	public List<Post> listoffert(int type)  throws SQLException, ClassNotFoundException
	{
		ArrayList<Post> Posts2=new ArrayList<Post>();
		posts =new ArrayList<Post>();
		String sql="select * from Posts where postType='"+type+"'";
		// ResultSet rs=null;
		Class.forName("com.mysql.jdbc.Driver");
	
	try(
		  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		 PreparedStatement st = con.prepareStatement(sql);
		 ResultSet  rs=st.executeQuery();)
		{
		 while(rs.next())
		 {
			 Post p=new Post();
			 p.setPostId(rs.getInt("userid"));
			 p.setPostId(rs.getInt("postid"));
			 p.setPost(rs.getString("post"));
			 p.setDateCreated(rs.getDate("datecreated"));
			 p.setPosttype(rs.getInt("posttype"));
			 p.setDateUpdate(rs.getDate("dateupdated"));
			 posts.add(p);
		 }
		 
		}
	for(int i=posts.size()-1;i>=0;i--)
		Posts2.add(posts.get(i));
	
	return Posts2;

}
	
	public List<Comment> listComment()  throws SQLException, ClassNotFoundException
	{
		comments =new ArrayList<Comment>();
		String sql="select * from Comments";
		// ResultSet rs=null;
		Class.forName("com.mysql.jdbc.Driver");
	
	try(
		  
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carpoolingdb","root","");  
		 PreparedStatement st = con.prepareStatement(sql);
		 ResultSet  rs=st.executeQuery();)
		{
		 while(rs.next())
		 {
			 Comment cmt=new Comment();
			 cmt.setComment(rs.getString("comment"));
			 cmt.setCommmentId(rs.getInt("commentid"));
			 cmt.setDateCreated(rs.getDate("datecreated"));
			 cmt.setDateUpdate(rs.getDate("dateupdated"));
			 cmt.setDateCreated(rs.getDate("datecreated"));
			 cmt.setPostId(rs.getInt("postid"));
			 comments.add(cmt);
		 }
		 
		}
	return comments;

}
	
}