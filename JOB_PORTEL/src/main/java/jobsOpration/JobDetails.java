package jobsOpration;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import recruterBean.JobPost;

@WebServlet("/jobdetails")
public class JobDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess!=null) {
			String jobId=req.getParameter("jobid");
			JobPost jobDetails= new PostJobDB().getJobById(jobId);
			req.setAttribute("jobDetails", jobDetails);
			req.getRequestDispatcher("jobDetails.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
	
