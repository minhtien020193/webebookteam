package DTO;

public class PostChapterDTO {
	private int postChapterId;
	private int postId;
	private int chapterId;

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
	public PostChapterDTO(int postChapterId, int postId, int chapterId) {
		super();
		this.postChapterId = postChapterId;
		this.postId = postId;
		this.chapterId = chapterId;
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

}
