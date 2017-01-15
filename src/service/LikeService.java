package service;

import dao.DbConnection;
import model.Like;

public class LikeService {
	DbConnection db;
	public void createLike(int userId,int postId)
	{
		Like like=new Like();
		like.setUserId(userId);
		like.setPostId(postId);
		
		db=new DbConnection();
		db.createLike(like);
	}

}
