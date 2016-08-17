package DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.PreparedStatement;

import DBUtilities.DBConnect;
import DTO.UserDTO;



public class UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
	
	public boolean authenticateUser(UserDTO user) {
		String username = user.getUserName();
		String password = hash256(user.getPassword());

		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			pstmt = (PreparedStatement) con.prepareStatement("select * from thtb_users WHERE username=? AND password=?");
			pstmt.setString(1, username); 
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			boolean check = rs.next();
			if (check) {
				return true;
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
				
			} catch (SQLException se) {
			}// do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		logger.info("Done...");
		return false;
	}
	
	public int getUserId(String username){
		int userId = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			pstmt = (PreparedStatement) con.prepareStatement("select * from thtb_users WHERE username=?");
			pstmt.setString(1, username); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				userId = rs.getInt(1);
			}
			return userId;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		logger.info("Done...");
		return userId;
	}
	
	public String getUserNameById(int userId){
		String username = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			pstmt = (PreparedStatement) con.prepareStatement("select * from eb_users WHERE userId =?");
			pstmt.setInt(1, userId); 
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				username = rs.getString("username");
			}
			return username;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		logger.info("Done...");
		return null;
	}
	
	public static String hash256(String data){
        MessageDigest md = null;
        logger.info("Logging begins...");
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		logger.info("Done...");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
	
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}
