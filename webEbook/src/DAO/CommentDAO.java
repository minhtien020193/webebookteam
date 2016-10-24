/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DBUtilities.DBConnect;
import DTO.CommentDTO;
import DTO.PostCommentDTO;
import DTO.PostDTO;

/**
 * @author mac
 *
 */
public class CommentDAO {

	private static final Logger logger = Logger.getLogger(CommentDAO.class.getName());

	public ArrayList<CommentDTO> getListCommentByPostId(int postId) {
		ArrayList<CommentDTO> lstComment = new ArrayList<CommentDTO>();
		List<Integer> lstCommentId = listChapterCommentByPostId(postId);

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);
			for (Integer commentId : lstCommentId) {

				String query = "SELECT * FROM eb_comments WHERE commentId ='" + commentId + "' AND typeComment = 0";
				stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					CommentDTO comment = new CommentDTO();
					comment.setCommentId(rs.getInt("commentId"));
					comment.setUserId(rs.getInt("userId"));
					comment.setComment(rs.getString("comment"));
					comment.setTypeComment(rs.getBoolean("typeComment"));
					comment.setVoteComment(rs.getBoolean("voteComment"));
					comment.setDel_flg(rs.getBoolean("del_flg"));
					comment.setCreateDate(rs.getDate("createDate"));
					comment.setUpdateDate(rs.getDate("updateDate"));
					comment.setDeleteDate(rs.getDate("deleteDate"));

					lstComment.add(comment);
				}
				rs.close();
			}

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
		return lstComment;
	}

	// get list comment chapter
	public ArrayList<CommentDTO> getListCommentByChapterId(int chapterId) {
		ArrayList<CommentDTO> lstComment = new ArrayList<CommentDTO>();
		List<Integer> lstCommentId = listChapterCommentByChapterId(chapterId);

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);
			for (Integer commentId : lstCommentId) {

				String query = "SELECT * FROM eb_comments WHERE commentId ='" + commentId + "' AND typeComment = 1";
				stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					CommentDTO comment = new CommentDTO();
					comment.setCommentId(rs.getInt("commentId"));
					comment.setUserId(rs.getInt("userId"));
					comment.setComment(rs.getString("comment"));
					comment.setTypeComment(rs.getBoolean("typeComment"));
					comment.setVoteComment(rs.getBoolean("voteComment"));
					comment.setDel_flg(rs.getBoolean("del_flg"));
					comment.setCreateDate(rs.getDate("createDate"));
					comment.setUpdateDate(rs.getDate("updateDate"));
					comment.setDeleteDate(rs.getDate("deleteDate"));

					lstComment.add(comment);
				}
				rs.close();
			}

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
		return lstComment;
	}

	// list comment id by post id
	public List<Integer> listChapterCommentByPostId(int postId) {
		List<Integer> lstCommentId = new ArrayList<Integer>();

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_postcomment WHERE postId ='" + postId + "' ORDER BY createDate DESC";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lstCommentId.add(rs.getInt("commentId"));
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
		return lstCommentId;
	}

	// list comment id by chapter id
	public List<Integer> listChapterCommentByChapterId(int chapterId) {
		List<Integer> lstCommentId = new ArrayList<Integer>();

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_chaptercomment WHERE chapterId ='" + chapterId + "' ORDER BY createDate DESC";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lstCommentId.add(rs.getInt("commentId"));
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
		return lstCommentId;
	}

	// insert comment table
	// type comment = true -> comment chapter
	public int postCommentPost(String content, int userId, boolean typeComment) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		int commentId = 0;
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_comments(userId, comment, typeComment, voteComment, del_flg, createDate) VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, userId);
			pstmt.setString(2, content);
			pstmt.setBoolean(3, typeComment);
			pstmt.setBoolean(4, false);
			pstmt.setBoolean(5, false);
			pstmt.setDate(6, currentDate);
			int index = pstmt.executeUpdate();
			if (index == 1) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						commentId = (int) generatedKeys.getInt(1);
					} else {
						return commentId;
					}
				}
				return commentId;
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
		return commentId;
	}

	// insert post comment table
	public boolean insertPostComment(int postId, int commentId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_postcomment(postId, commentId, del_flg, createDate) VALUES (?, ?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, postId);
			pstmt.setInt(2, commentId);
			pstmt.setBoolean(3, false);
			pstmt.setDate(4, currentDate);
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

	// insert chapter comment table
	public boolean insertChapterComment(int chapterId, int commentId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_chaptercomment(chapterId, commentId, del_flg, createDate) VALUES (?, ?, ?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, chapterId);
			pstmt.setInt(2, commentId);
			pstmt.setBoolean(3, false);
			pstmt.setDate(4, currentDate);
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

	//update vote comment
	public boolean updateVoteComment(int commentId, boolean voteComment) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_comments SET  voteComment=?, updateDate=? "
					+ " WHERE commentId ='" + commentId + "'";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setBoolean(1, voteComment);
			pstmt.setDate(2, currentDate);
			
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
}
