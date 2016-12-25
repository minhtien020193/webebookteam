package Action.Struts2;

import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;
import DTO.RequestRoleUpdate;
import DTO.RoleDTO;
import DTO.UserDTO;
import MailUtilities.MailUtilities;

import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements SessionAware {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private Map<String, Object> sessionMap;
	private String username;
	private String password;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private String code;
	final String ADMIN = "admin";
	final String SALER = "saler";
	final String MEMBER = "member";
	final int saleId = 2;
	List<UserDTO> listUsers;
	boolean noData = false;
	int userId;
	UserDTO userDTO;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String listSaler() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (!(ADMIN).equals(role)) {
			return "notAdmin";
		}
		listUsers = user.getListSaler();
		if (listUsers.isEmpty()) {
			noData = true;
		}
		return "success";
	}

	public String login() {
		UserDTO userDto = new UserDTO();
		userDto.setUserName(username);
		userDto.setPassword(password);
		UserDAO userDao = new UserDAO();
		userDto = userDao.authenticateUser(userDto);
		if (userDto != null) {
			sessionMap.put("LOGINED", userDto);
			int roleId = userDao.getRoleIdByUserId(userDto.getUserId());
			String roleName = MEMBER;
			if (roleId == 1) {
				roleName = ADMIN;
			} else if (roleId == 2) {
				roleName = SALER;
			}
			sessionMap.put("ROLE", roleName);
			return SUCCESS;
		}
		return FAIL;
	}

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("LOGINED");
		session.remove("ROLE");

		return SUCCESS;
	}

	public String register(){
		Random r = new Random(System.currentTimeMillis());
		String del_code = Integer.toString(((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)));

		UserDTO userDto = new UserDTO(username, password, firstName, midName, lastName, address, email, phone, 3, true,
				del_code); 
		UserDAO userDao = new UserDAO();
		boolean check  = userDao.checkUserName(username, email);
		if(check){
			System.out.println("aa exist");
			return FAIL;
		}
		
		MailUtilities mail = new MailUtilities();
		if (userDao.registerAccount(userDto)) {
			mail.sendEmailCheckCode(del_code, email);
			return SUCCESS;
		}
		return FAIL;
	}

	public String listUpgrande() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (!(ADMIN).equals(role)) {
			return "notAdmin";
		}

		listUsers = new ArrayList<>();
		for (RequestRoleUpdate reqRole : user.getListUpgrand()) {
			UserDTO userDTO = user.getUserbyId(reqRole.getUserId());
			listUsers.add(userDTO);
		}
		if (user.getListUpgrand().isEmpty()) {
			noData = true;
		}
		return "success";
	}

	public String updateRoleUser() {
		UserDAO urs = new UserDAO();
		boolean check = urs.updateRoleSaler(userId, saleId);
		if (check) {
			return "success";
		}
		return "fail";
	}

	public String getProfile() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO userDAO = new UserDAO();
		userDTO = userDAO.getUserbyId(userId);
		if (userDTO == null) {
			return "noData";
		}
		return "success";
	}

	// Toan start this
	public String checkCode() {
		UserDAO userDao = new UserDAO();
		String del_Code = userDao.getDelCode(username);
		if (del_Code.equals(code)) {
			int userId = userDao.getUserId(username);
			userDao.updateDelFlg(userId);
			return SUCCESS;
		}
		return FAIL;
	}

	// getter setter
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
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

	public List<UserDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UserDTO> listUsers) {
		this.listUsers = listUsers;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
