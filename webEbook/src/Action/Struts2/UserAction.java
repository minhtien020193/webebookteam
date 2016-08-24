package Action.Struts2;

import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import DTO.RequestRoleUpdate;
import DTO.RoleDTO;
import DTO.UserDTO;

public class UserAction {

	final String ADMIN ="admin";
	final int saleId = 2;
	List<UserDTO> listUsers;
	boolean noData = false;
	int userId;

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
			noData = true;
		}
		return "success";
	}
	
	public String listUpgrande(){
		int userId = 1;
		UserDAO usr = new UserDAO();
		int roleId = usr.getRoleIdByUserId(userId);
		RoleDTO role = usr.getRoleByRoleId(roleId);
		if(!(ADMIN).equals(role.getRoleName())){
			return "notAdmin";
		}
		listUsers = new ArrayList<>();
		for (RequestRoleUpdate reqRole : usr.getListUpgrand()) {
			UserDTO userDTO=  usr.getUserbyId(reqRole.getUserId());
			listUsers.add(userDTO);
		}
		if(usr.getListUpgrand().isEmpty()){
			noData = true;
		}
		return "success";
	}
	
	public String updateRoleUser(){
		UserDAO urs = new UserDAO();
		boolean check = urs.updateRoleSaler(userId, saleId);
		if(check){
			return "success";
		}
		return "fail";
	}
	

	//getter setter
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
