package Action.Struts2;

import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;
import DTO.RequestRoleUpdate;
import DTO.RoleDTO;
import DTO.UserDTO;
import java.util.Map;
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
	final String ADMIN = "admin";
	final int saleId = 2;
	List<UserDTO> listUsers;
	boolean noData = false;
	int userId;

	public String execute() throws Exception {
		System.out.println(" cuc cuc " + username + password);
		return SUCCESS;
	}

	public String listSaler() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("LOGINED") == null){
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
			return SUCCESS;
		}
		return FAIL;
	}

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("LOGINED");

		return SUCCESS;
	}

	public String register() {
		UserDTO userDto = new UserDTO(username, password, firstName, midName, lastName, address, email, phone, 3); // TODO
		UserDAO userDao = new UserDAO();
		if (userDao.registerAccount(userDto)) {
			return SUCCESS;
		}
		return FAIL;
	}

	public String listUpgrande() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("LOGINED") == null){
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

}
