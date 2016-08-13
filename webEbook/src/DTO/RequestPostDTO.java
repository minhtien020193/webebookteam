/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class RequestPostDTO {
	private int reqPostId;
	private int postId;
	private int userId;
	private String postStatus;
	private String description;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	public RequestPostDTO() {
		super();
	}
	/**
	 * @param reqPostId
	 * @param postId
	 * @param userId
	 * @param postStatus
	 * @param description
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public RequestPostDTO(int reqPostId, int postId, int userId, String postStatus, String description, boolean del_flg,
			Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.reqPostId = reqPostId;
		this.postId = postId;
		this.userId = userId;
		this.postStatus = postStatus;
		this.description = description;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	public int getReqPostId() {
		return reqPostId;
	}
	public void setReqPostId(int reqPostId) {
		this.reqPostId = reqPostId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
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
