package userposts;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import JavaBeans.Posts;
import JavaBeans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
@MultipartConfig
@WebServlet("/submit_post")
public class UploadPost extends HttpServlet{
	
	Posts p=null;
	
	@Override
	public void init() throws ServletException {
		p=new Posts();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess=req.getSession(false);
		if(sess!=null) {
			User u=(User)sess.getAttribute("user");
			long userid=u.getPhone();
			String postId = UUID.randomUUID().toString();
			p.setPostId(postId);
			p.setUserid(userid);
			String username=u.getName()+" "+u.getSirname();
			p.setUsername(username);
			p.setTitle(req.getParameter("title"));
			p.setDesc(req.getParameter("desc"));
			
			 Part filePart = req.getPart("image");
	            byte[] imageBytes = null;
	            if (filePart != null) {
	                InputStream inputStream = filePart.getInputStream();
	                imageBytes = inputStream.readAllBytes(); // Convert image to byte array
	            }
			
	            p.setImage(imageBytes);
	            
	            int k= new UploadPostDB().insertPost(p);
	            if(k>0) {
					req.setAttribute("msg", "Post Uploaded Successfully !!!");
					req.getRequestDispatcher("msg.jsp").forward(req, resp);
				} else {
					req.setAttribute("msg", "Error !!!");
					req.getRequestDispatcher("msg.jsp").forward(req, resp);
				}
		} else {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
