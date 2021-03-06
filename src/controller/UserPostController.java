package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Post;
import service.PostjsonService;

/**
 * Servlet implementation class UserPost
 */
@WebServlet("/UserPost.json")
public class UserPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession();
	int id=(Integer)session.getAttribute("id");
		PostjsonService service=new  PostjsonService();
		try {
	            List<Post> posts=service.userpost(id);
	            String postJson = new Gson().toJson(posts);
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");
	            response.getWriter().write(postJson);
	        } catch (SQLException | ClassNotFoundException e) {
	            throw new ServletException("DB error", e);
	        }
	    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
