package DTO;

import java.util.Date;

public class VoteDTO {
	private int voteId;
	private int userId;
	private int postId;
	private boolean vote;
	private Date createDate;
	private Date updateDate;

	public VoteDTO() {
		super();
	}

	public VoteDTO(int voteId, int userId, int postId, boolean vote,
			Date createDate, Date updateDate) {
		super();
		this.voteId = voteId;
		this.userId = userId;
		this.postId = postId;
		this.vote = vote;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

}
