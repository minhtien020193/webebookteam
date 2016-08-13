package DTO;

import java.util.Date;

public class OrderDTO {
	private int orderId;
	private int userId;
	private double amount;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public OrderDTO() {
		super();
	}
	/**
	 * @param orderId
	 * @param userId
	 * @param amount
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public OrderDTO(int orderId, int userId, double amount, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.amount = amount;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
