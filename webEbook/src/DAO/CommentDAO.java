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

	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

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

	public List<Integer> listChapterCommentByPostId(int postId) {
		List<Integer> lstCommentId = new ArrayList<Integer>();

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_postComment WHERE postId ='" + postId + "'";
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
}
