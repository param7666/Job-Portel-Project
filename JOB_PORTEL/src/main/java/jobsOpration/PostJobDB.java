package jobsOpration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBHandler.DBConnection;
import recruterBean.JobPost;

public class PostJobDB {
	
	int k;
	
	public int addJob(JobPost jb) {
	    
	    try {
	    	Connection con = DBConnection.connect();
	        PreparedStatement ps = con.prepareStatement("INSERT INTO jobPost VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        ps.setString(1, jb.getJobId());
	        ps.setString(2, jb.getRecruterId()); 
	        ps.setString(3, jb.getCompanyName());
	        ps.setString(4, jb.getTitle()); 
	        ps.setDouble(5, jb.getSalary());
	        ps.setString(6, jb.getRole()); 
	        ps.setString(7, jb.getEmpType());
	        ps.setString(8, jb.getCatagory()); 
	        ps.setString(9, jb.getLocation()); 
	        ps.setString(10, jb.getExperince());
	        ps.setString(11, jb.getSkill());
	        ps.setString(12, jb.getDescription()); 
	        ps.setString(13, jb.getResponsibility()); 

	        k = ps.executeUpdate();

	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return k; 
	}
	
	public List<JobPost> retrieveJobs() {
	    List<JobPost> jobList = new ArrayList<>(); 
	    try {
	        Connection con = DBConnection.connect();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM jobPost");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            JobPost job = new JobPost();
	  
	            job.setJobId(rs.getString("jobId"));
	            job.setRecruterId(rs.getString("recruterId"));
	            job.setCompanyName(rs.getString("companyName"));
	            job.setTitle(rs.getString("title"));
	            job.setSalary(rs.getDouble("salary"));
	            job.setRole(rs.getString("role"));
	            job.setEmpType(rs.getString("empType"));
	            job.setCatagory(rs.getString("catagory"));
	            job.setLocation(rs.getString("location"));
	            job.setExperince(rs.getString("Experince"));
	            job.setSkill(rs.getString("skill"));
	            job.setDescription(rs.getString("description"));
	            job.setResponsibility(rs.getString("responsibility"));
	            jobList.add(job);
	        }
	        rs.close();
	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return jobList;
	}
	
	public List<JobPost> retrieveJobs(String recid) {
	    List<JobPost> jobList = new ArrayList<>(); 
	    try {
	        Connection con = DBConnection.connect();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM jobPost where recruterId=?");
	        ps.setString(1, recid);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            JobPost job = new JobPost();
	            job.setJobId(rs.getString("jobId"));
	            job.setRecruterId(rs.getString("recruterId"));
	            job.setCompanyName(rs.getString("companyName"));
	            job.setTitle(rs.getString("title"));
	            job.setSalary(rs.getDouble("salary"));
	            job.setRole(rs.getString("role"));
	            job.setEmpType(rs.getString("empType"));
	            job.setCatagory(rs.getString("catagory"));
	            job.setLocation(rs.getString("location"));
	            job.setExperince(rs.getString("Experince"));
	            job.setSkill(rs.getString("skill"));
	            job.setDescription(rs.getString("description"));
	            job.setResponsibility(rs.getString("responsibility"));
	            
	            jobList.add(job);
	        }
	        rs.close();
	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return jobList;
	}
	
	public JobPost getJobById(String jobid) {
		JobPost job=null;
	    try {
	        Connection con = DBConnection.connect();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM jobPost where JOBID=?");
	        ps.setString(1, jobid);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	job = new JobPost();
	            job.setJobId(rs.getString("jobId"));
	            job.setRecruterId(rs.getString("recruterId"));
	            job.setCompanyName(rs.getString("companyName"));
	            job.setTitle(rs.getString("title"));
	            job.setSalary(rs.getDouble("salary"));
	            job.setRole(rs.getString("role"));
	            job.setEmpType(rs.getString("empType"));
	            job.setCatagory(rs.getString("catagory"));
	            job.setLocation(rs.getString("location"));
	            job.setExperince(rs.getString("Experince"));
	            job.setSkill(rs.getString("skill"));
	            job.setDescription(rs.getString("description"));
	            job.setResponsibility(rs.getString("responsibility"));
	            
	            
	        }
	        rs.close();
	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return job;
	}
	
	public int deleteJob(String jobId, String recruiterId) {
        try{
        	 Connection con = DBConnection.connect();
 	        PreparedStatement ps = con.prepareStatement("DELETE FROM jobpost WHERE JOBID = ? AND RECRUITERID = ?");
 	        	ps.setString(1, jobId);
                ps.setString(2, recruiterId);
                int k = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k; 
    }


	
}
