package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;
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

			String query = "SELECT * FROM eb_posts WHERE del_flg = 0 and postStatus = 1";
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

	public PostDTO findPostDTO(int postId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_posts WHERE postId ='" + postId + "' AND del_flg = 0";
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
			} // do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		return null;
	}

	public int getPostIdbyChapterId(int chapterId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_postChapter WHERE chapterId ='" + chapterId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("postId");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		return 0;
	}

	public ArrayList<PostDTO> getListPostbyUserId(int userId) {
		ArrayList<PostDTO> lstPostByUserId = new ArrayList<PostDTO>();
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_posts WHERE userId ='" + userId + "' AND postStatus = 1 AND del_flg = 0";
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

				lstPostByUserId.add(post);
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
		return lstPostByUserId;
	}

	public int insertPost(PostDTO post) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		int postId = 0;
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_posts(userId, postStatus, postName, contents, description, countChapter, authorName, image, saleoff, price, linkDownload, postType, del_flg, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, post.getUserId());
			pstmt.setBoolean(2, post.isPostStatus());
			pstmt.setString(3, post.getPostName());
			pstmt.setString(4, post.getContents());
			pstmt.setString(5, post.getDescription());
			pstmt.setInt(6, post.getCountChapter());
			pstmt.setString(7, post.getAuthorName());
			pstmt.setString(8, post.getImage());
			pstmt.setInt(9, post.getSaleoff());
			pstmt.setDouble(10, post.getPrice());
			pstmt.setString(11, post.getLinkDownload());
			pstmt.setBoolean(12, post.isPostType());
			pstmt.setBoolean(13, post.isDel_flg());
			pstmt.setDate(14, currentDate);
			int index = pstmt.executeUpdate();
			if (index == 1) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						postId = (int) generatedKeys.getInt(1);
					} else {
						return postId;
					}
				}
				return postId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ex) {
				logger.log(Level.SEVERE, ex.getMessage(), ex);
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				logger.log(Level.SEVERE, se.getMessage(), se);
			} // end finally try
		}
		logger.info("Done...");
		return postId;
	}
	
	
	public boolean updatePostDTO(PostDTO post) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_posts SET postName=?, contents=?, description=?, countChapter=?, authorName=?, image=?, price=?, linkDownload=?, updateDate=? "
					+ " WHERE postId ='" + post.getPostId() + "'";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setString(1, post.getPostName());
			pstmt.setString(2, post.getContents());
			pstmt.setString(3, post.getDescription());
			pstmt.setInt(4, post.getCountChapter());
			pstmt.setString(5, post.getAuthorName());
			pstmt.setString(6, post.getImage());
			pstmt.setDouble(7, post.getPrice());
			pstmt.setString(8, post.getLinkDownload());
			pstmt.setDate(9, currentDate);
			
			int index = pstmt.executeUpdate();
			if (index == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ex) {
				logger.log(Level.SEVERE, ex.getMessage(), ex);
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				logger.log(Level.SEVERE, se.getMessage(), se);
			} // end finally try
		}
		logger.info("Done...");
		return false;
	}
	
	//detele post (change status)
	public boolean updateDel_FlgPostDTO(int postId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_posts SET  del_flg=?, updateDate=?, deleteDate=? "
					+ " WHERE postId ='" + postId + "'";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setDate(2, currentDate);
			pstmt.setDate(3, currentDate);
			
			int index = pstmt.executeUpdate();
			if (index == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException ex) {
				logger.log(Level.SEVERE, ex.getMessage(), ex);
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				logger.log(Level.SEVERE, se.getMessage(), se);
			} // end finally try
		}
		logger.info("Done...");
		return false;
	}
	
	//get post by commentId
	public int getPostIdbyCommentId(int commentId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_postComment WHERE commentId ='" + commentId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("postId");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		return 0;
	}
}
