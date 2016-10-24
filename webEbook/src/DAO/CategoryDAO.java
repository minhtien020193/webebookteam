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
import DTO.CategoryDTO;

public class CategoryDAO {
	private static final Logger logger = Logger.getLogger(CategoryDAO.class.getName());
	
	public ArrayList<CategoryDTO> getListCategory() {
		ArrayList<CategoryDTO> lstCat = new ArrayList<CategoryDTO>();
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_category WHERE del_flg = 0";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				CategoryDTO cat = new CategoryDTO();
				cat.setCategoryId(rs.getInt("categoryId"));
				cat.setCategoryName(rs.getString("categoryName"));
				cat.setDescription(rs.getString("description"));
				cat.setDel_flg(rs.getBoolean("del_flg"));
				cat.setCreateDate(rs.getDate("createDate"));
				cat.setUpdateDate(rs.getDate("updateDate"));
				cat.setDeleteDate(rs.getDate("deleteDate"));
				lstCat.add(cat);
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
		return lstCat;
	}
	
	public String getCategoryById(int categoryId){
		String categoryName = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			pstmt = (PreparedStatement) con.prepareStatement("select * from eb_category WHERE categoryId =? AND del_flg=0");
			pstmt.setInt(1, categoryId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				categoryName = rs.getString("categoryName");
			}
			return categoryName;
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
		logger.info("Done...");
		return null;
	}
}
