package userposts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DBHandler.DBConnection;
import JavaBeans.Posts;

public class UploadPostDB {
	
	int k;
	
	public int insertPost(Posts p) {
		try {
			Connection con=DBConnection.connect();
            PreparedStatement stmt = con.prepareStatement("insert into posts values(?,?,?,?,?,?,?)");
            
            String postId = p.getPostId();
            if (postId.length() > 20) {
                postId = postId.substring(0, 20);  // Truncate to 20 characters
            }
            stmt.setString(1, postId);
            stmt.setLong(2, p.getUserid());
            stmt.setString(3, p.getUsername());
            stmt.setString(4, p.getTitle());
            stmt.setString(5, p.getDesc());
            stmt.setBytes(6, p.getImage());
            stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            k = stmt.executeUpdate(); // Execute and store result (1 if successful, 0 if not)
            
            stmt.close();
            con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	 public List<Posts> getPostsByUser() {
	        List<Posts> allpostList = new ArrayList<>();
	        try {
	            Connection con = DBConnection.connect();
	            String sql = "SELECT * FROM posts ORDER BY created_at DESC";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            
	            
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Posts post = new Posts();
	                post.setPostId(rs.getString(1));
	                post.setUserid(rs.getLong(2));
	                post.setUsername(rs.getString(3));
	                post.setTitle(rs.getString(4));
	                post.setDesc(rs.getString(5));
	                post.setImage(rs.getBytes(6));

	                allpostList.add(post);
	            }
	            
	            rs.close();
	            stmt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return allpostList;
	    }
	 
	 public List<Posts> getPostsByUser(long userId) {
	        List<Posts> postList = new ArrayList<>();
	        try {
	            Connection con = DBConnection.connect();
	            String sql = "SELECT * FROM posts WHERE userid = ? ORDER BY created_at DESC";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setLong(1, userId);
	            
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Posts post = new Posts();
	                post.setPostId(rs.getString(1));
	                post.setUserid(rs.getLong(2));
	                post.setUsername(rs.getString(3));
	                post.setTitle(rs.getString(4));
	                post.setDesc(rs.getString(5));
	                post.setImage(rs.getBytes(6));

	                postList.add(post);
	            }
	            
	            rs.close();
	            stmt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return postList;
	    }
}
