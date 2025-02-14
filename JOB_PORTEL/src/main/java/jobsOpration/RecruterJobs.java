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
import recruterBean.Recruter;
@WebServlet("/recJobs")
public class RecruterJobs extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		List<JobPost> alljobList= new ArrayList<JobPost>();
		if(sess!=null) {
			Recruter rec=(Recruter)sess.getAttribute("recruter");
			String rcid=rec.getComId();
			alljobList=new PostJobDB().retrieveJobs(rcid);
			if(alljobList!=null) {
				req.setAttribute("allJobs", alljobList);
				req.getRequestDispatcher("recruterHomepage.jsp").forward(req, resp);
			}
			
		} else {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
