/**
 * 
 */
package DTO;

/**
 * @author mac
 *
 */
public class PostCommentDTO {
	private int postCommentId;
	private int postId;
	private int commentId;
	private boolean del_flg;
	/**
	 * 
	 */
	public PostCommentDTO() {
		super();
	}

	/**
	 * @param postCommentId
	 * @param postId
	 * @param commentId
	 */
	public PostCommentDTO(int postCommentId, int postId, int commentId, boolean del_flg) {
		super();
		this.postCommentId = postCommentId;
		this.postId = postId;
		this.commentId = commentId;
		this.del_flg = del_flg;
	}

	/**
	 * @return the postCommentId
	 */
	public int getPostCommentId() {
		return postCommentId;
	}

	/**
	 * @param postCommentId
	 *            the postCommentId to set
	 */
	public void setPostCommentId(int postCommentId) {
		this.postCommentId = postCommentId;
	}

	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId
	 *            the commentId to set
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

}
