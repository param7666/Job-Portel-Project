package profile;

import java.io.IOException;

import JavaBeans.User;
import JavaBeans.WorkExperiance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ExperienceServlet")
public class WorkExperinceServlet extends HttpServlet {
	
	WorkExperiance w=null;
	
	@Override
	public void init() throws ServletException {
		w=new WorkExperiance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); 
		if(session!=null) {
			User user=(User)session.getAttribute("user");
			long id=user.getPhone();
			w.setId(id);
			w.setTitle(req.getParameter("jobTitle"));
			w.setCompany(req.getParameter("company"));
			w.setJoinYear(req.getParameter("startYear"));
			w.setEndYear(req.getParameter("endYear"));
			
			int k=new WorkExDB().addEx(id, w);
			if(k>0) {
				req.setAttribute("msg", "Experiance Added");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "fail");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		}
		else {
			req.setAttribute("msg", "Sesson Expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
	
}
