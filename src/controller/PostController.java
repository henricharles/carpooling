package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PostService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	PostService service=new PostService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String post=request.getParameter("postoffereing");
		int type=Integer.parseInt(request.getParameter("type"));
		HttpSession session =request.getSession();
		int uid=(Integer) session.getAttribute("id");
		service.create(uid, post, type);
		response.sendRedirect("home.jsp");
		//service.create(1, "I need a rid to Iowa city", 1);
		

	}

}
