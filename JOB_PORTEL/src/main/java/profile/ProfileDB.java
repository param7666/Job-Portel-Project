package profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBHandler.DBConnection;
import JavaBeans.User;

public class ProfileDB {
	
	User u =null;
	
	public User profile(String name) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from jobUser where name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setName(rs.getString(1));
				u.setSirname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getLong(4));
				u.setAge(rs.getInt(5));
				u.setCity(rs.getString(6));
				u.setState(rs.getString(7));
				u.setCountry(rs.getString(8));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
