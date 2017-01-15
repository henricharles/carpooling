package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Comment;
import model.Post;
import service.CommentJsonService;
import service.PostjsonService;


@WebServlet("/comments.json")
public class CommentJsonController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		CommentJsonService service=new  CommentJsonService();
		try {
	            List<Comment> comments=service.allComment();
	            String postJson = new Gson().toJson(comments);
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
