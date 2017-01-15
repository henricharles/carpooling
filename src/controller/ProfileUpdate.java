package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

/**
 * Servlet implementation class ProfileUpdate
 */
@WebServlet("/ProfileUpdate")
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		service=new UserService(); 
		
		int sex;
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		String name=request.getParameter("name");
		String state=request.getParameter("state");
		String password=request.getParameter("password");
		int zip=Integer.parseInt(request.getParameter("zipcode"));
		String email=request.getParameter("email");
		String gen=request.getParameter("gender");
		String bd=request.getParameter("birth");
		int  year=Integer.parseInt(bd.split("-")[0]);
		if(gen.equals("male"))
			sex=1;
		else
			sex=2;
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("id");
		
		service.userUpdate(name, sex, state, city, street, zip, year, email, password, id);
		response.sendRedirect("home.jsp");
	}

}
