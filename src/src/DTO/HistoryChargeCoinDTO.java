package DTO;

import java.util.Date;

public class HistoryChargeCoinDTO {
	private int historyId;
	private Date dateCharge;
	private double amountCharge;
	private int coinId;
	private String typeCharge;
	private Date createDate;
	/**
	 * 
	 */
	public HistoryChargeCoinDTO() {
		super();
	}
	/**
	 * @param historyId
	 * @param dateCharge
	 * @param amountCharge
	 * @param coinId
	 * @param typeCharge
	 * @param createDate
	 */
	public HistoryChargeCoinDTO(int historyId, Date dateCharge, double amountCharge, int coinId, String typeCharge,
			Date createDate) {
		super();
		this.historyId = historyId;
		this.dateCharge = dateCharge;
		this.amountCharge = amountCharge;
		this.coinId = coinId;
		this.typeCharge = typeCharge;
		this.createDate = createDate;
	}
	/**
	 * @return the historyId
	 */
	public int getHistoryId() {
		return historyId;
	}
	/**
	 * @param historyId the historyId to set
	 */
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	/**
	 * @return the dateCharge
	 */
	public Date getDateCharge() {
		return dateCharge;
	}
	/**
	 * @param dateCharge the dateCharge to set
	 */
	public void setDateCharge(Date dateCharge) {
		this.dateCharge = dateCharge;
	}
	/**
	 * @return the amountCharge
	 */
	public double getAmountCharge() {
		return amountCharge;
	}
	/**
	 * @param amountCharge the amountCharge to set
	 */
	public void setAmountCharge(double amountCharge) {
		this.amountCharge = amountCharge;
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
	 * @return the typeCharge
	 */
	public String getTypeCharge() {
		return typeCharge;
	}
	/**
	 * @param typeCharge the typeCharge to set
	 */
	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
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
	
	
}
