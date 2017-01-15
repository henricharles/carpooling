package service;

import java.sql.SQLException;

import dao.DbConnection;
import model.Post;
import model.User;

public class UserService {
	User user;
	DbConnection db;
	

	public void  create(String fn,int g,String state,String city,String street,int zip,int year,String email,String password)
	{
		db=new DbConnection();
		user=new User();
		user.setFullName(fn);
		user.setGender(g);
		user.setState(state);
		user.setCity(city);
		user.setState(street);
		user.setZipcode(zip);
		user.setBirthYear(year);
		user.setEmail(email);
		user.setPassword(password);
		user.setStreet(street);
		
		db.createUser(user);
	}
	public boolean login(String email, String pwd) throws ClassNotFoundException, SQLException
	{
		
		DbConnection db=new DbConnection();
		return db.userlogin(email, pwd);
		
	
	}
	
	public void userUpdate(String fn,int g,String state,String city,String street,int zip,int year,String email,String password,int id)
	{	db=new DbConnection();
	user=new User();
	user.setFullName(fn);
	user.setGender(g);
	user.setState(state);
	user.setCity(city);
	user.setState(street);
	user.setZipcode(zip);
	user.setBirthYear(year);
	user.setEmail(email);
	user.setPassword(password);
	user.setStreet(street);
	db.updateUser(user,id);
		
	}

	
}
