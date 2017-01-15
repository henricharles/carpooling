package service;

import java.sql.SQLException;
import java.util.List;

import dao.JsonDao;
import model.Comment;
import model.Post;

public class CommentJsonService {
	
	JsonDao jsd=new JsonDao();
	public List<Comment> allComment() throws ClassNotFoundException, SQLException
	{
		return jsd.listComment();
	}


}
