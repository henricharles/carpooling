package service;

import dao.DbConnection;
import model.User;

public class UserService {
	User use1;
	

	public void  create()
	{
		DbConnection db=new DbConnection();
		db.createUser();
	}
}
