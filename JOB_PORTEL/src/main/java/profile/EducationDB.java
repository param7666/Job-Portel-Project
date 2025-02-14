package profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBHandler.DBConnection;
import JavaBeans.Education;

public class EducationDB {
	
	int k;
	Education edc=null;
	
	public int addEducation(long id,Education ed) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("insert into jobeducation values(?,?,?,?,?)");
			ps.setLong(1, ed.getId());
			ps.setString(2, ed.getDegree());
			ps.setString(3, ed.getInstitute());
			ps.setString(4, ed.getsYear());
			ps.setString(5, ed.geteYear());
			k=ps.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public ArrayList<Education> retriveEdc(long id) {
		ArrayList<Education> edct=new ArrayList<Education>();
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from jobeducation where id=?");
			ps.setLong(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				edc=new Education();
				edc.setId(rs.getLong(1));
				edc.setDegree(rs.getString(2));
				edc.setInstitute(rs.getString(3));
				edc.setsYear(rs.getString(4));
				edc.seteYear(rs.getString(5));
				edct.add(edc);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return edct;
	}
}
