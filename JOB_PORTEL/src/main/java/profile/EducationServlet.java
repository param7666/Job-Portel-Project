package profile;

import java.io.IOException;

import JavaBeans.Education;
import JavaBeans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet{
	
	Education e=null;
	
	@Override
	public void init() throws ServletException {
		e=new Education();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session!=null) {
			User u=(User)session.getAttribute("user");
			long id=u.getPhone();
			e.setId(id);
			e.setDegree(req.getParameter("degree"));
			e.setInstitute(req.getParameter("institute"));
			e.setsYear(req.getParameter("startYear"));
			e.seteYear(req.getParameter("endYear"));
			
			int k=new EducationDB().addEducation(id,e);
			if(k>0) {
				req.setAttribute("msg", "Education added Successfully !!!");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "Education added fail !!!");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
