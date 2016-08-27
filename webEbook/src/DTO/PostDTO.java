/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class PostDTO {
	private int postId;
	private int userId;
	private int categoryId;
	private boolean postStatus;
	private String postName;
	private String contents;
	private String description;
	private int countChapter;
	private String authorName;
	private String image;
	private double price;
	private int saleoff;
	private String linkDownload;
	private boolean postType;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public PostDTO() {
		super();
	}
	/**
	 * @param postId
	 * @param userId
	 * @param postName
	 * @param contents
	 * @param description
	 * @param countChapter
	 * @param authorName
	 * @param image
	 * @param price
	 * @param saleoff
	 * @param linkDownload
	 * @param postType
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public PostDTO(int postId, int categoryId, int userId, String postName, boolean postStatus, String contents, String description, int countChapter,
			String authorName, String image, double price, int saleoff, String linkDownload, boolean postType,
			boolean del_flg, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.postStatus = postStatus;
		this.postName = postName;
		this.contents = contents;
		this.description = description;
		this.countChapter = countChapter;
		this.authorName = authorName;
		this.image = image;
		this.price = price;
		this.saleoff = saleoff;
		this.linkDownload = linkDownload;
		this.postType = postType;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
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
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the countChapter
	 */
	public int getCountChapter() {
		return countChapter;
	}
	/**
	 * @param countChapter the countChapter to set
	 */
	public void setCountChapter(int countChapter) {
		this.countChapter = countChapter;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the saleoff
	 */
	public int getSaleoff() {
		return saleoff;
	}
	/**
	 * @param saleoff the saleoff to set
	 */
	public void setSaleoff(int saleoff) {
		this.saleoff = saleoff;
	}
	/**
	 * @return the linkDownload
	 */
	public String getLinkDownload() {
		return linkDownload;
	}
	/**
	 * @param linkDownload the linkDownload to set
	 */
	public void setLinkDownload(String linkDownload) {
		this.linkDownload = linkDownload;
	}
	/**
	 * @return the postType
	 */
	public boolean isPostType() {
		return postType;
	}
	/**
	 * @param postType the postType to set
	 */
	public void setPostType(boolean postType) {
		this.postType = postType;
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
	public boolean isPostStatus() {
		return postStatus;
	}
	public void setPostStatus(boolean postStatus) {
		this.postStatus = postStatus;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
