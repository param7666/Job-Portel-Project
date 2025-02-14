package jobsOpration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import recruterBean.JobPost;

@WebServlet("/allJobs")
public class AllJobservlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		
		if(sess!=null) {
			List<JobPost> alljobList= new ArrayList<JobPost>();
			alljobList=new PostJobDB().retrieveJobs();
			if(alljobList!=null) {
				req.setAttribute("allJobs", alljobList);
				req.getRequestDispatcher("allJobs.jsp").forward(req, resp);
			}
			
		} else {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
