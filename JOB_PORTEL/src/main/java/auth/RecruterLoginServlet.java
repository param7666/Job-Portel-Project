package auth;

import java.io.IOException;
import java.util.List;

import JavaBeans.Posts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import recruterBean.Recruter;
import userposts.UploadPostDB;

@WebServlet("/rcLogin")
public class RecruterLoginServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		Recruter recruter=new RecruterLogin().recLogin(email, pass);
		if(recruter!=null) {
			HttpSession sess=req.getSession();
			List<Posts> posts=new UploadPostDB().getPostsByUser();
			sess.setAttribute("recruter", recruter);
			req.setAttribute("posts", posts);
			req.getRequestDispatcher("recruterHomepage.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Login Fail.....");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
	
}
