package DTO;

import java.util.Date;

public class CoinDTO {
	private int coinId;
	private double coinAmount;
	private int userId;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public CoinDTO() {
		super();
	}
	/**
	 * @param coinId
	 * @param coinAmount
	 * @param userId
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public CoinDTO(int coinId, double coinAmount, int userId, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.coinId = coinId;
		this.coinAmount = coinAmount;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	/**
	 * @return the coinId
	 */
	public int getCoinId() {
		return coinId;
	}
	/**
	 * @param coinId the coinId to set
	 */
	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}
	/**
	 * @return the coinAmount
	 */
	public double getCoinAmount() {
		return coinAmount;
	}
	/**
	 * @param coinAmount the coinAmount to set
	 */
	public void setCoinAmount(double coinAmount) {
		this.coinAmount = coinAmount;
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
