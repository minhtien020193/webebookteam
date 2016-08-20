/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class linkDTO {
	private int linkId;
	private int postId;
	private int userId;
	private String linkDetail;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public linkDTO() {
		super();
	}
	/**
	 * @param linkId
	 * @param postId
	 * @param userId
	 * @param linkDetail
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public linkDTO(int linkId, int postId, int userId, String linkDetail, boolean del_flg, Date createDate,
			Date updateDate, Date deleteDate) {
		super();
		this.linkId = linkId;
		this.postId = postId;
		this.userId = userId;
		this.linkDetail = linkDetail;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
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
	public String getLinkDetail() {
		return linkDetail;
	}
	public void setLinkDetail(String linkDetail) {
		this.linkDetail = linkDetail;
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
