package DTO;

import java.util.Date;

public class CommentDTO {
	private int commentId;
	private int userId;
	private String comment;
	private boolean typeComment;
	private boolean voteComment;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public CommentDTO() {
		super();
	}
	/**
	 * @param commentId
	 * @param userId
	 * @param comment
	 * @param typeComment
	 * @param voteComment
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public CommentDTO(int commentId, int userId, String comment, boolean typeComment, boolean voteComment,
			boolean del_flg, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.comment = comment;
		this.typeComment = typeComment;
		this.voteComment = voteComment;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the typeComment
	 */
	public boolean isTypeComment() {
		return typeComment;
	}
	/**
	 * @param typeComment the typeComment to set
	 */
	public void setTypeComment(boolean typeComment) {
		this.typeComment = typeComment;
	}
	/**
	 * @return the voteComment
	 */
	public boolean isVoteComment() {
		return voteComment;
	}
	/**
	 * @param voteComment the voteComment to set
	 */
	public void setVoteComment(boolean voteComment) {
		this.voteComment = voteComment;
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
