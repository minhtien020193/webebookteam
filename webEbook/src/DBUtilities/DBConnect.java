package DBUtilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection createConnection() {
		Connection con = null;
//		String url = "jdbc:mysql://bewriterbeyou.com:3306/bewriter_ebook?useUnicode=true&characterEncoding=UTF-8";
//		String username = "root"; // username of database user
//		String password = "7V[^f!R;2ofs"; // password
		
		String url = "jdbc:mysql://localhost:3306/eb_webEbook?useUnicode=true&characterEncoding=UTF-8";
		String username = "root"; // username of database user
		String password = ""; // password
		
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
