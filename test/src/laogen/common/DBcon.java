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
			// "jdbc:mysql://localhost:�˿ں�/<���ݿ���>?characterEncoding=gbk";
			String user = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ�����
			DBconn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			System.out.println("����������ش���");
		} catch (SQLException e2) {
			System.out.println("���ݿ�����ʱ����");
			e2.printStackTrace();
		}
		return DBconn;
	}

	// ��������
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