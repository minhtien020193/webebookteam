package Action.Struts2;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import DAO.UserDAO;
import DTO.UserDTO;

public class UserAction {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private String username;
	private String password;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String email;
	private String phone;


	public String execute() throws Exception {
		System.out.println(" cuc cuc " + username + password);
		return SUCCESS;
	}
	public String test() {
		return SUCCESS;
	}
	
	public String login()
	{

		UserDTO userDto = new UserDTO();
		userDto.setUserName(username);
		userDto.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		
		if (userDao.authenticateUser(userDto))
		{
			return SUCCESS;
		}
		
		return FAIL;
	}
	
	public String register()
	{
		UserDTO userDto = new UserDTO(
				username, 
				password, 
				firstName, 
				midName, 
				lastName, 
				address, 
				email, 
				phone,
				2); //TODO check role
		
		UserDAO userDao = new UserDAO();
		
		if (userDao.registerAccount(userDto))
		{
			return SUCCESS;
		}
		
		return FAIL;
		
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
