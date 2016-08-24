package DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DBUtilities.DBConnect;
import DTO.ChapterDTO;
import DTO.PostDTO;
import DTO.RequestRoleUpdate;
import DTO.RoleDTO;
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
    
    public RoleDTO getRoleByRoleId(int roleId){
    	Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_roles WHERE roleId ='" + roleId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				RoleDTO role = new RoleDTO();
				role.setRoleId(roleId);
				role.setRoleName(rs.getString("roleName"));
				role.setDescription(rs.getString("description"));
				role.setCreateDate(rs.getDate("createDate"));
				role.setUpdateDate(rs.getDate("updateDate"));
				role.setDeleteDate(rs.getDate("deleteDate"));
				return role;
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
    
    public int getRoleIdByUserId(int userId){
    	Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_users WHERE userId ='" + userId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("roleId");
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
    
    //get UserDTO by userID
    public UserDTO getUserbyId(int userId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_users WHERE userId ='" + userId + "' AND del_flg = 0";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				UserDTO usr = new UserDTO();
				usr.setUserId(rs.getInt("userId"));
				usr.setUserName(rs.getString("userName"));
				usr.setFirstName(rs.getString("firstName"));
				usr.setMidName(rs.getString("midName"));
				usr.setLastName(rs.getString("lastName"));
				usr.setAddress(rs.getString("address"));
				usr.setEmail(rs.getString("email"));
				usr.setPhone(rs.getString("phone"));
				usr.setRoleId(rs.getInt("roleId"));
				usr.setCreateDate(rs.getDate("createDate"));
				usr.setUpdateDate(rs.getDate("updateDate"));
				
				return usr;
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
		return null;
	}
    
    public ArrayList<UserDTO> getListSaler() {
		ArrayList<UserDTO> lstSaler = new ArrayList<UserDTO>();
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_users WHERE roleId = 2 and del_Flg = 0";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				UserDTO usr = new UserDTO();
				usr.setUserId(rs.getInt("userId"));
				usr.setUserName(rs.getString("userName"));
				usr.setFirstName(rs.getString("firstName"));
				usr.setMidName(rs.getString("midName"));
				usr.setLastName(rs.getString("lastName"));
				usr.setAddress(rs.getString("address"));
				usr.setEmail(rs.getString("email"));
				usr.setPhone(rs.getString("phone"));
				usr.setRoleId(rs.getInt("roleId"));
				usr.setCreateDate(rs.getDate("createDate"));
				usr.setUpdateDate(rs.getDate("updateDate"));
				
				lstSaler.add(usr);
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
		return lstSaler;
	}
    
    public ArrayList<RequestRoleUpdate> getListUpgrand() {
		ArrayList<RequestRoleUpdate> lstUpgrande = new ArrayList<RequestRoleUpdate>();
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_requestRoleUpdate WHERE reqStatus = 0 and del_Flg = 0";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				RequestRoleUpdate upgrande = new RequestRoleUpdate();
				upgrande.setReqUpdateRoleId(rs.getInt("reqUpdateRoleId"));
				upgrande.setUserId(rs.getInt("userId"));
				upgrande.setReqStatus(rs.getBoolean("reqStatus"));
				upgrande.setDescription(rs.getString("description"));
				upgrande.setRoleBefore(rs.getString("roleBefore"));
				upgrande.setCreateDate(rs.getDate("createDate"));
				lstUpgrande.add(upgrande);
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
		return lstUpgrande;
	}

    public boolean updateRoleSaler(int userId, int roleId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_users SET roleId = ?, updateDate =?"
					+ " WHERE userId ='" + userId + "'";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setInt(1, roleId);
			pstmt.setDate(2, currentDate);
			
			int index = pstmt.executeUpdate();
			if (index == 1) {
				updateRequestRoleUpdate(userId);
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
    
    private boolean updateRequestRoleUpdate(int userId) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_requestRoleUpdate SET reqStatus = ?, updateDate =?"
					+ " WHERE userId ='" + userId + "' AND reqStatus = 0";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setBoolean(1, true);
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
