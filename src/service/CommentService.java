package service;

import dao.DbConnection;
import model.Comment;
import model.User;

public class CommentService {
	DbConnection db=new DbConnection();
	Comment com;
	public void  create(int userId,int postId,String comment)
	{
		com=new Comment();
		com.setComment(comment);
		com.setUserId(userId);
		com.setPostId(postId);
		db.createCommement(com);
	
		
	}

}
