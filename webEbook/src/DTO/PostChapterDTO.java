package DTO;

public class PostChapterDTO {
	private int postChapterId;
	private int postId;
	private int chapterId;
	private boolean del_flg;

	/**
	 * 
	 */
	public PostChapterDTO() {
		super();
	}

	/**
	 * @param postChapterId
	 * @param postId
	 * @param chapterId
	 */
	public PostChapterDTO(int postChapterId, int postId, int chapterId, boolean del_flg) {
		super();
		this.postChapterId = postChapterId;
		this.postId = postId;
		this.chapterId = chapterId;
		this.del_flg = del_flg;
	}

	/**
	 * @return the postChapterId
	 */
	public int getPostChapterId() {
		return postChapterId;
	}

	/**
	 * @param postChapterId
	 *            the postChapterId to set
	 */
	public void setPostChapterId(int postChapterId) {
		this.postChapterId = postChapterId;
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
	 * @return the chapterId
	 */
	public int getChapterId() {
		return chapterId;
	}

	/**
	 * @param chapterId
	 *            the chapterId to set
	 */
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public boolean isDel_flg() {
		return del_flg;
	}

	public void setDel_flg(boolean del_flg) {
		this.del_flg = del_flg;
	}
}
