package DBUtilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection createConnection() {
		Connection con = null;
//		String url = "jdbc:mysql://103.221.221.237:3306/bewriter_ebook?useUnicode=true&characterEncoding=UTF-8";
//		String username = "root"; // username of database user
//		String password = "j39g30C3Y4r|h@:J"; // password
//		
		String url = "jdbc:mysql://localhost:3306/eb_webebook?useUnicode=true&characterEncoding=UTF-8";
		String username = "root"; // username of database user
		String password = "admin"; // password
//		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");// differs from DB server
														// to server
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
