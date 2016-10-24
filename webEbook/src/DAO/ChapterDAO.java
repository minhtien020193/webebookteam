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
import DTO.ChapterDTO;
import DTO.PostDTO;

/**
 * @author mac
 *
 */
public class ChapterDAO {
	private static final Logger logger = Logger.getLogger(ChapterDAO.class.getName());

	public ArrayList<ChapterDTO> getListChapterByPostId(int postId) {
		ArrayList<ChapterDTO> lstChapter = new ArrayList<ChapterDTO>();
		List<Integer> lstChapterId = listChapterPostByPostId(postId);

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);
			for (Integer chapterId : lstChapterId) {

				String query = "SELECT * FROM eb_chapters WHERE chapterId ='" + chapterId + "' AND del_flg = 0 ORDER BY createDate DESC";
				stmt = (Statement) con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					ChapterDTO chapter = new ChapterDTO();
					chapter.setChapterId(rs.getInt("chapterId"));
					chapter.setChapterName(rs.getString("chapterName"));
					chapter.setContents(rs.getString("contents"));
					chapter.setDescription(rs.getString("description"));
					chapter.setDel_flg(rs.getBoolean("del_flg"));
					chapter.setCreateDate(rs.getDate("createDate"));
					chapter.setUpdateDate(rs.getDate("updateDate"));
					chapter.setDeleteDate(rs.getDate("deleteDate"));

					lstChapter.add(chapter);
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
		return lstChapter;
	}

	public List<Integer> listChapterPostByPostId(int postId) {
		List<Integer> lstChapterId = new ArrayList<Integer>();

		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "SELECT * FROM eb_postChapter WHERE postId ='" + postId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lstChapterId.add(rs.getInt("chapterId"));
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
		return lstChapterId;
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

	public ChapterDTO getChapterDTObyChapterId(int chapterId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_chapters WHERE chapterId ='" + chapterId + "' AND del_flg = 0";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ChapterDTO chapter = new ChapterDTO();
				chapter.setChapterId(rs.getInt("chapterId"));
				chapter.setChapterName(rs.getString("chapterName"));
				chapter.setContents(rs.getString("contents"));
				chapter.setDescription(rs.getString("description"));
				chapter.setDel_flg(rs.getBoolean("del_flg"));
				chapter.setCreateDate(rs.getDate("createDate"));
				chapter.setUpdateDate(rs.getDate("updateDate"));
				chapter.setDeleteDate(rs.getDate("deleteDate"));

				return chapter;
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

	public int insertChapter(ChapterDTO chapter) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		int chapterId = 0;
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_chapters(chapterName, contents, description, del_flg, createDate) VALUES (?, ?, ?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, chapter.getChapterName());
			pstmt.setString(2, chapter.getContents());
			pstmt.setString(3, chapter.getDescription());
			pstmt.setBoolean(4, chapter.isDel_flg());
			pstmt.setDate(5, currentDate);
			int index = pstmt.executeUpdate();
			if (index == 1) {
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						chapterId = (int) generatedKeys.getInt(1);
					} else {
						return chapterId;
					}
				}
				return chapterId;
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
		return chapterId;
	}

	public boolean insertPostChapter(int chapterId, int postId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "INSERT INTO eb_postChapter(postId, chapterId, del_flg) VALUES (?, ?, ?)";
			pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, postId);
			pstmt.setInt(2, chapterId);
			pstmt.setBoolean(3, false);
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

	/**
	 * update chapter
	 * 
	 * @param chapter
	 * @return
	 */
	public boolean updateChapterDTO(ChapterDTO chapter) {
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		Connection con = null;
		PreparedStatement pstmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			logger.log(Level.SEVERE, "Connect...:", con);

			String query = "UPDATE eb_chapters SET  chapterName=?, contents=?, description=?, updateDate=?"
					+ " WHERE chapterId ='" + chapter.getChapterId() + "'";
			pstmt = (PreparedStatement) con.prepareStatement(query);
			pstmt.setString(1, chapter.getChapterName());
			pstmt.setString(2, chapter.getContents());
			pstmt.setString(3, chapter.getDescription());
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

	// get chapter by commentId
	public int getChapterIdbyCommentId(int commentId) {
		Connection con = null;
		Statement stmt = null;
		logger.info("Logging begins...");
		try {
			con = DBConnect.createConnection(); // establishing connection
			String query = "SELECT * FROM eb_chapterComment WHERE commentId ='" + commentId + "'";
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return rs.getInt("chapterId");
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
