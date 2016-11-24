/**
 * 
 */
package DTO;

import java.util.Date;

/**
 * @author mac
 *
 */
public class UserDTO {
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private int roleId;
	private boolean del_Flg;
	private String del_Code;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
	/**
	 * 
	 */
	public UserDTO() {
		super();
	}

	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param midName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phone
	 * @param roleId
	 * @param del_Flg
	 * @param createDate
	 * @param updateDate
	 * @param deleteDate
	 */
	public UserDTO(int userId, String userName, String password, String firstName, String midName, String lastName,
			String address, String email, String phone, int roleId, boolean del_Flg, Date createDate, Date updateDate,
			Date deleteDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.roleId = roleId;
		this.del_Flg = del_Flg;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	
	/**
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param midName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param phone
	 * @param roleId
	 * @param del_Flag
	 */
	public UserDTO(String userName, String password, String firstName, String midName, String lastName,
			String address, String email, String phone, int roleId, boolean del_Flag, String del_Code) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.roleId = roleId;
		this.del_Flg = del_Flag;
		this.del_Code = del_Code;

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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the midName
	 */
	public String getMidName() {
		return midName;
	}

	/**
	 * @param midName the midName to set
	 */
	public void setMidName(String midName) {
		this.midName = midName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the del_Flg
	 */
	public boolean isDel_Flg() {
		return del_Flg;
	}

	/**
	 * @param del_Flg the del_Flg to set
	 */
	public void setDel_Flg(boolean del_Flg) {
		this.del_Flg = del_Flg;
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
	
	/**
	 * @return the del_Code
	 */
	public String getDel_Code() {
		return del_Code;
	}
	
	/**
	 * @param del_Code the del_Code to set
	 */
	public void setDel_Code(String del_Code) {
		this.del_Code = del_Code;
	}
	
}
