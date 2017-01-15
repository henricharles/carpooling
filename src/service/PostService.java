package service;

import dao.DbConnection;
import model.Post;

public class PostService {
	DbConnection db;
	Post p;
	public void create(int userId,String post,int type)
	{
		db=new DbConnection();
		p=new Post();
		p.setPost(post);
		p.setPosttype(type);
		p.setUserId(userId);
		db.createPost(p);
	}

}
