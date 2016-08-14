/**
 * 
 */
package DTO;

/**
 * @author mac
 *
 */
public class ChapterCommentDTO {
	private int chapterCommentId;
	private int chapterId;
	private int commentId;
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
	public ChapterCommentDTO(int chapterCommentId, int chapterId, int commentId) {
		super();
		this.chapterCommentId = chapterCommentId;
		this.chapterId = chapterId;
		this.commentId = commentId;
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
	
}
