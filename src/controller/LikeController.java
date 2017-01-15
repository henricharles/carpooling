package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LikeService;

/**
 * Servlet implementation class LikeController
 */
@WebServlet("/LikeController")
public class LikeController extends HttpServlet {
	LikeService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		int postId=Integer.parseInt(request.getParameter("postId"));
		int userId=(Integer) session.getAttribute("id");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 service=new LikeService();
	 service.createLike(userId,postId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
