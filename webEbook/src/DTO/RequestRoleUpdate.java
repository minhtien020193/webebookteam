/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class RequestRoleUpdate {
	private int reqUpdateRoleId;
	private int userId;
	private String roleBefore;
	private boolean reqStatus;
	private String description;
	private boolean del_flg;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	/**
	 * 
	 */
	public RequestRoleUpdate() {
		super();
	}
	/**
	 * @param reqUpdateRoleId
	 * @param userId
	 * @param roleBefore
	 * @param reqStatus
	 * @param description
	 * @param del_flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public RequestRoleUpdate(int reqUpdateRoleId, int userId, String roleBefore, boolean reqStatus, String description,
			boolean del_flg, Date createDate, Date updateDate, Date deleteDate) {
		super();
		this.reqUpdateRoleId = reqUpdateRoleId;
		this.userId = userId;
		this.roleBefore = roleBefore;
		this.reqStatus = reqStatus;
		this.description = description;
		this.del_flg = del_flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	public int getReqUpdateRoleId() {
		return reqUpdateRoleId;
	}
	public void setReqUpdateRoleId(int reqUpdateRoleId) {
		this.reqUpdateRoleId = reqUpdateRoleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRoleBefore() {
		return roleBefore;
	}
	public void setRoleBefore(String roleBefore) {
		this.roleBefore = roleBefore;
	}
	public boolean isReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(boolean reqStatus) {
		this.reqStatus = reqStatus;
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
