package service;

import java.sql.SQLException;
import java.util.List;

import dao.JsonDao;
import model.Post;

public class PostjsonService {
	JsonDao jsd=new JsonDao();
	public List<Post> allpostoffer(int type) throws ClassNotFoundException, SQLException
	{
		return jsd.listoffert(type) ;

}
	public List<Post> userpost(int id) throws ClassNotFoundException, SQLException
	{
		return jsd.userPost(id);
}
}
