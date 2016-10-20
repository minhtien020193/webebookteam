package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DBUtilities.DBConnect;
import com.mysql.jdbc.PreparedStatement;

public class VoteDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
	
	public boolean voteInsertPost(int postId, int userId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "INSERT INTO  eb_votes(userId, postId, createDate, updateDate) VALUES(?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, postId);
			pstmt.setDate(3, currentDate);
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
	
	public boolean voteUpdatePost(int voteId, boolean vote) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE  eb_votes set vote=?, updateDate=? where voteId=?";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setBoolean(1, vote);
			pstmt.setDate(2, currentDate);
			pstmt.setInt(3, voteId);
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
	
	public int searchVote(int userId, int postId){
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_votes WHERE userId =? AND postId=?";
			pstmt = (PreparedStatement) con.createStatement();
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("voteId");
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
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
