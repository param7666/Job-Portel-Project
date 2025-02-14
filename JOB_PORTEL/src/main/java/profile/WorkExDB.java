package profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBHandler.DBConnection;
import JavaBeans.Education;
import JavaBeans.WorkExperiance;

public class WorkExDB {
	
	int k;
	WorkExperiance work=null;
	
	public int addEx(long id,WorkExperiance w) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("insert into jobExp values (?,?,?,?,?)");
			ps.setLong(1, id);
			ps.setString(2, w.getTitle());
			ps.setString(3, w.getCompany());
			ps.setString(4, w.getJoinYear());
			ps.setString(5, w.getEndYear());
			
			k=ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public ArrayList<WorkExperiance> retriveWorkExp(long id) {
		ArrayList<WorkExperiance> wr=new ArrayList<WorkExperiance>();
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from jobExp where id=?");
			ps.setLong(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				work=new WorkExperiance();
				work.setId(rs.getLong(1));
				work.setCompany(rs.getString(2));
				work.setTitle(rs.getString(3));
				work.setJoinYear(rs.getString(4));
				work.setEndYear(rs.getString(5));
				wr.add(work);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return wr;
	}
}
