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
import recruterBean.Recruter;

@WebServlet("/myjobs")
public class MyJobsServlet extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession sess = req.getSession(false);
	if(sess!=null) {
		Recruter rec=(Recruter)sess.getAttribute("recruter");
		String rcid=rec.getComId();
		List<JobPost> myjobs= new PostJobDB().retrieveJobs(rcid);
		if(myjobs!=null) {
			req.setAttribute("myjobs", myjobs);
			req.getRequestDispatcher("myjobs.jsp").forward(req, resp);
		} 
			
	} else {
		req.setAttribute("msg", "Session Expired");
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
	}
}
}
