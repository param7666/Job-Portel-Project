package auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.Posts;
import JavaBeans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobsOpration.PostJobDB;
import userposts.UploadPostDB;

@WebServlet("/login")
public class LoginSevlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String pass=req.getParameter("password");
		User user=new LoginDB().login(userName, pass);
		if(user!=null) {
			List<Posts> allpostList=new ArrayList<Posts>();
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			allpostList=new UploadPostDB().getPostsByUser();
			req.setAttribute("alljobs", allpostList);
			req.getRequestDispatcher("homepage.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Login Fail.....");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
	
}
