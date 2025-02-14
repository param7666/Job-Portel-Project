package jobsOpration;

import java.io.IOException;

import JavaBeans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import recruterBean.JobPost;
import recruterBean.Recruter;

@WebServlet("/uploadJob")
public class PostJobServlet extends HttpServlet {
	
	JobPost jb=null;
	
	@Override
	public void init() throws ServletException {
		jb=new JobPost();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if(sess!=null) {
			Recruter rec=(Recruter)sess.getAttribute("recruter");
			String rcid=rec.getComId();
			jb.setJobId(req.getParameter("jobId"));
			jb.setRecruterId(rcid);
			jb.setCompanyName(req.getParameter("companyName"));
			jb.setTitle(req.getParameter("title"));
			jb.setSalary(Double.parseDouble(req.getParameter("salary")));
			jb.setRole(req.getParameter("role"));
			jb.setEmpType(req.getParameter("empType"));
			jb.setCatagory(req.getParameter("catagory"));
			jb.setLocation(req.getParameter("location"));
			jb.setExperince(req.getParameter("Experince"));
			jb.setSkill(req.getParameter("skill"));
			jb.setDescription(req.getParameter("description"));
			jb.setResponsibility(req.getParameter("responsibility"));
			
			int k=new PostJobDB().addJob(jb);
			
			if(k>0) {
				req.setAttribute("msg", "Job added Successfully !!!");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "Job added fail !!!");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
			
		}else {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		
	}
}
