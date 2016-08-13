package DTO;

import java.util.Date;

public class RankingDTO {
	private int rankId;
	private double rank;
	private int userId;
	private int postId;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public RankingDTO() {
		super();
	}
	/**
	 * @param rankId
	 * @param rank
	 * @param userId
	 * @param postId
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public RankingDTO(int rankId, double rank, int userId, int postId, boolean del_flg, Date createDate,
			Date updateDate, Date deleteDate) {
		super();
		this.rankId = rankId;
		this.rank = rank;
		this.userId = userId;
		this.postId = postId;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	/**
	 * @return the rankId
	 */
	public int getRankId() {
		return rankId;
	}
	/**
	 * @param rankId the rankId to set
	 */
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	/**
	 * @return the rank
	 */
	public double getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(double rank) {
		this.rank = rank;
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
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
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
