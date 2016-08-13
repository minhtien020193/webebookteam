package DTO;

import java.util.Date;

public class ChapterDTO {
	private int chapterId;
	private String chapterName;
	private String contents;
	private String description;
	private int commentId;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public ChapterDTO() {
		super();
	}
	/**
	 * @param chapterId
	 * @param chapterName
	 * @param contents
	 * @param description
	 * @param commentId
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public ChapterDTO(int chapterId, String chapterName, String contents, String description, int commentId,
			boolean del_flg, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.chapterId = chapterId;
		this.chapterName = chapterName;
		this.contents = contents;
		this.description = description;
		this.commentId = commentId;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
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
	 * @return the chapterName
	 */
	public String getChapterName() {
		return chapterName;
	}
	/**
	 * @param chapterName the chapterName to set
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * @return the del_flg
	 */
	public boolean isDel_flg() {
		return del_flg;
	}
	/**
	 * @param del_flg the del_flg to set
	 */
	public void setDel_flg(boolean del_flg) {
		this.del_flg = del_flg;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the deleteDate
	 */
	public Date getDeleteDate() {
		return deleteDate;
	}
	/**
	 * @param deleteDate the deleteDate to set
	 */
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
}
