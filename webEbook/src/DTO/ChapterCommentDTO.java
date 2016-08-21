/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class ChapterCommentDTO {
	private int chapterCommentId;
	private int chapterId;
	private int commentId;
	private boolean del_flg;
	private Date createDate;
	/**
	 * 
	 */
	public ChapterCommentDTO() {
		super();
	}
	/**
	 * @param chapterCommentId
	 * @param chapterId
	 * @param commentId
	 */
	public ChapterCommentDTO(int chapterCommentId, int chapterId, int commentId, boolean del_flg, Date createDate) {
		super();
		this.chapterCommentId = chapterCommentId;
		this.chapterId = chapterId;
		this.commentId = commentId;
		this.del_flg = del_flg;
		this.createDate = createDate;
	}
	/**
	 * @return the chapterCommentId
	 */
	public int getChapterCommentId() {
		return chapterCommentId;
	}
	/**
	 * @param chapterCommentId the chapterCommentId to set
	 */
	public void setChapterCommentId(int chapterCommentId) {
		this.chapterCommentId = chapterCommentId;
	}
	/**
	 * @return the chapterId
	 */
	public int getChapterId() {
		return chapterId;
	}
	/**
	 * @param chapterId the chapterId to set
	 */
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public boolean isDel_flg() {
		return del_flg;
	}
	public void setDel_flg(boolean del_flg) {
		this.del_flg = del_flg;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
