package profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBHandler.DBConnection;
import JavaBeans.Skill;
import JavaBeans.WorkExperiance;

public class SkillDB {
	
	int k;
	Skill sk=null;
	
	public int addSkill(long id,Skill s) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("insert into jobSkill values(?,?)");
			ps.setLong(1, id);
			ps.setString(2, s.getSkill());
			
			k=ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public ArrayList<Skill> retriveSkill(long id) {
		ArrayList<Skill> skl=new ArrayList<Skill>();
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from jobSkill where id=?");
			ps.setLong(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				sk=new Skill();
				sk.setId(rs.getLong(1));
				sk.setSkill(rs.getString(2));
				skl.add(sk);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return skl;
	}
}
