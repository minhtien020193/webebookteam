package DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.PreparedStatement;

import DBUtilities.DBConnect;
import DTO.UserDTO;



public class UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
	
	public UserDTO authenticateUser(UserDTO user) {
		String username = user.getUserName();
		String password = hash256(user.getPassword());
		
		UserDTO result = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			pstmt = (PreparedStatement) con.prepareStatement("select * from eb_users WHERE userName=? AND password=?");
			pstmt.setString(1, username); 
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				
				result = new UserDTO();
				
				result.setUserName(rs.getString("userName"));
				result.setFirstName(rs.getString("firstName"));
				result.setMidName(rs.getString("midName"));
				result.setLastName(rs.getString("lastName"));

				return result;
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
		return result;
	}
	
	public boolean registerAccount(UserDTO user)
	{
		// hash password
		user.setPassword(hash256(user.getPassword()));
		
		// add create date
		
		// create a sql date object so we can use it in our INSERT statement
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date createDate = new java.sql.Date(calendar.getTime().getTime());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("register begins...");

		try {
			con = DBConnect.createConnection(); // establishing connection
			
			// the mysql insert statement
		    String query = "insert into eb_users (userName, password, firstName, midName, "
		    		     + "lastName, address, email, phone, roleId, del_Flg, createDate) "
		                 + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setString(1, user.getUserName()); 
			pstmt.setString(2, user.getPassword());
			
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getMidName());
			pstmt.setString(5, user.getLastName());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getPhone());
			
			pstmt.setInt(9, user.getRoleId());
			pstmt.setBoolean(10,false);
			pstmt.setDate(11, createDate);
			
			boolean check = pstmt.execute();
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
