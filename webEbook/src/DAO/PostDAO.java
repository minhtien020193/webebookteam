package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Statement;
import DBUtilities.DBConnect;
import DTO.PostDTO;

public class PostDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

	public ArrayList<PostDTO> getListPost() {
		ArrayList<PostDTO> lstPost = new ArrayList<PostDTO>();
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_posts";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				PostDTO post = new PostDTO();
				post.setPostId(rs.getInt("postId"));
				post.setUserId(rs.getInt("userId"));
				post.setPostName(rs.getString("postName"));
				post.setContents(rs.getString("contents"));
				post.setDescription(rs.getString("description"));
				post.setCountChapter(rs.getInt("countChapter"));
				post.setAuthorName(rs.getString("authorName"));
				post.setImage(rs.getString("image"));
				post.setPrice(rs.getDouble("price"));
				post.setSaleoff(rs.getInt("saleoff"));
				post.setLinkDownload(rs.getString("linkDownload"));
				post.setPostType(rs.getBoolean("postType"));
				post.setDel_flg(rs.getBoolean("del_flg"));
				post.setCreateDate(rs.getDate("createDate"));
				post.setUpdateDate(rs.getDate("updateDate"));
				post.setDeleteDate(rs.getDate("deleteDate"));

				lstPost.add(post);
			}
			rs.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					con.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		logger.info("Done...");
		return lstPost;
	}
	
	public PostDTO findPost(int postId){
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);
			
			String query = "SELECT * FROM eb_posts WHERE postId ='" + postId  + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				PostDTO post = new PostDTO();
				post.setPostId(rs.getInt("postId"));
				post.setUserId(rs.getInt("userId"));
				post.setPostName(rs.getString("postName"));
				post.setContents(rs.getString("contents"));
				post.setDescription(rs.getString("description"));
				post.setCountChapter(rs.getInt("countChapter"));
				post.setAuthorName(rs.getString("authorName"));
				post.setImage(rs.getString("image"));
				post.setPrice(rs.getDouble("price"));
				post.setSaleoff(rs.getInt("saleoff"));
				post.setLinkDownload(rs.getString("linkDownload"));
				post.setPostType(rs.getBoolean("postType"));
				post.setDel_flg(rs.getBoolean("del_flg"));
				post.setCreateDate(rs.getDate("createDate"));
				post.setUpdateDate(rs.getDate("updateDate"));
				post.setDeleteDate(rs.getDate("deleteDate"));

				return post;
	        }
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return null;
	}
}
