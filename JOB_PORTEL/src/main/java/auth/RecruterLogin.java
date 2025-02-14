package auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBHandler.DBConnection;
import recruterBean.Recruter;

public class RecruterLogin {
	Recruter rc=null;
	public Recruter recLogin(String email,String pass) {
		try {
			Connection con=DBConnection.connect();
			PreparedStatement ps=con.prepareStatement("select * from jobRecruter where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				rc=new Recruter();
				rc.setComId(rs.getString(1));
				rc.setName(rs.getString(2));
				rc.setSirname(rs.getString(3));
				rc.setEmail(rs.getString(4));
				rc.setPhone(5);
				rc.setPass(pass);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rc;
	}
	
}
