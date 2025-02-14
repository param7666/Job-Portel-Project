package profile;

import java.io.IOException;
import java.util.ArrayList;

import JavaBeans.Education;
import JavaBeans.Skill;
import JavaBeans.User;
import JavaBeans.WorkExperiance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class ProfileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); 
		ArrayList<Education> edct=new ArrayList<Education>();
		ArrayList<WorkExperiance> wr=new ArrayList<WorkExperiance>();
		ArrayList<Skill> skl=new ArrayList<Skill>();
		
		if(session!=null) {
			User user=(User)session.getAttribute("user");
			String name=user.getName();
			User u=new ProfileDB().profile(name);
			long id=u.getPhone();
			edct=new EducationDB().retriveEdc(id);
			wr=new WorkExDB().retriveWorkExp(id);
			skl=new SkillDB().retriveSkill(id);
			req.setAttribute("u", u);
			req.setAttribute("edList", edct);
			req.setAttribute("workList", wr);
			req.setAttribute("skillList", skl);
			req.getRequestDispatcher("updateProfile.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
