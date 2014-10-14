package laogen.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	public static Connection getConnection() throws SQLException {
		Connection DBconn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bookdb?characterEncoding=utf-8";
			// "jdbc:mysql://localhost:端口号/<数据库名>?characterEncoding=gbk";
			String user = "root"; // 数据库用户名
			String password = "root"; // 数据库密码
			DBconn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			System.out.println("驱动程序加载错误");
		} catch (SQLException e2) {
			System.out.println("数据库连接时错误");
			e2.printStackTrace();
		}
		return DBconn;
	}

	// 关门连接
	public static void clear(Connection DBconn) {
		if (DBconn != null) {
			try {
				DBconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}