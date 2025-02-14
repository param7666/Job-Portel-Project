package jobsOpration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import recruterBean.Recruter;

@WebServlet("/deletejob")
public class DeleteJob extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess!=null) {
			Recruter rec=(Recruter)sess.getAttribute("recruter");
			String rcid=rec.getComId();
			String jobid=req.getParameter("jobid");
			int k= new PostJobDB().deleteJob(jobid, rcid);
			if(k>0) {
				req.setAttribute("msg", "job Deleted");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "job deletion fail");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
	}
}
