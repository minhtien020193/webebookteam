package DTO;

import java.util.Date;

public class CategoryDTO {
	private int categoryId;
	private String categoryName;
	private String description;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public CategoryDTO() {
		super();
	}
	/**
	 * @param categoryId
	 * @param categoryName
	 * @param description
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public CategoryDTO(int categoryId, String categoryName, String description, boolean del_flg, Date createDate,
			Date updateDate, Date deleteDate) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	
	/**
	 * @param categoryId
	 * @param categoryName
	 */
	public CategoryDTO(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDel_flg() {
		return del_flg;
	}
	public void setDel_flg(boolean del_flg) {
		this.del_flg = del_flg;
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
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
}
