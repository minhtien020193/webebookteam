package Action.Struts2;

import java.util.List;

import DAO.UserDAO;
import DTO.RoleDTO;
import DTO.UserDTO;

public class UserAction {

	final String ADMIN ="admin";
	List<UserDTO> listUsers;

	public String execute() throws Exception {
		return "success";
	}
	
	public String listSaler() {
		int userId = 1;
		UserDAO usr = new UserDAO();
		int roleId = usr.getRoleIdByUserId(userId);
		RoleDTO role = usr.getRoleByRoleId(roleId);
		if(!(ADMIN).equals(role.getRoleName())){
			return "notAdmin";
		}
		UserDAO user = new UserDAO();
		listUsers = user.getListSaler();
		if(listUsers.isEmpty()){
			return "noData";
		}
		return "success";
	}
	

	//getter setter
	public List<UserDTO> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<UserDTO> listUsers) {
		this.listUsers = listUsers;
	}
	
}
