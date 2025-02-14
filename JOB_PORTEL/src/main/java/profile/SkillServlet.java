package profile;

import java.io.IOException;
import java.net.http.HttpClient;

import JavaBeans.Skill;
import JavaBeans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SkillsServlet")
public class SkillServlet extends HttpServlet{
	
	Skill s=null;
	
	
	@Override
	public void init() throws ServletException {
		s=new Skill();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); 
		if(session!=null) {
			User user=(User)session.getAttribute("user");
			long id=user.getPhone();
			s.setId(id);
			s.setSkill(req.getParameter("skills"));
			
			int k= new SkillDB().addSkill(id, s);
			if(k>0) {
				req.setAttribute("msg", "Skill Added");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "fail");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
