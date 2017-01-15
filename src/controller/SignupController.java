package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;


@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		int today=LocalDate.now().getYear();
		
		if(today-year>=18){
		
		if(gen.equals("male"))
			sex=1;
		else
			sex=2;
		UserService service=new UserService();
		
		service.create(name, sex, state, city, street, zip, year, email, password);
		HttpSession session =request.getSession();
		session.setAttribute("email", name);
		session.setAttribute("email", email);
	response.sendRedirect("home.jsp");
		}
		else{
			response.sendRedirect("errorpage.jsp");
		}
		
	}

}
