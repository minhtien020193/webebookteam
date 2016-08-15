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
import DTO.ChapterDTO;
import DTO.CommentDTO;

/**
 * @author mac
 *
 */
public class ChapterDAO {
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

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
}
