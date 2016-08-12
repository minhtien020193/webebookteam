package Action.struts2;

public class UserAction {

	private String username;
	private String password;
	

	public String execute() throws Exception {
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		// check session is not empty (is exist)
//		if (session.get("userLogined") != null) {
//			// remove session user login
//			session.remove("userLogined");
//		}
//		if (session.get("cart") != null) {
//			// remove session cart
//			session.remove("cart");
//		}
		return "success";
	}

//	public String checkLogin() {
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		String result = "fail";
//		// check user login
//		if (session.get("userLogined") == null
//				|| session.get("userLogined").equals("")) {
//			UserDAO dao = new UserDAO();
//			UserDTO user = new UserDTO();
//			user.setUsername(username);
//			user.setPassword(password);
//			// check username and password
//			boolean checkLogin = dao.authenticateUser(user);
//			if (checkLogin) {
//				// set username to session
//				session.put("userLogined", user.getUsername());
//				ProductDAO proDAO = new ProductDAO();
//				list = proDAO.display();
//				result = "success";
//			}
//		}
//		// user logged in, send to list product page
//		else {
//			ProductDAO proDAO = new ProductDAO();
//			list = proDAO.display();
//			result = "success";
//		}
//		return result;
//	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
