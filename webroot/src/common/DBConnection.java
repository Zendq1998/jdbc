package common;

import java.sql.*;
import java.util.Locale;
import java.util.PropertyResourceBundle;

 
public class DBConnection {
	Connection conn = null;
	public boolean getConnect() {
		String str_URL = "";
		String str_userName = "";
		String str_passWord = ""; // the connect passWord
		String str_JdbcDriverName = ""; // the connect JDBCDriverName
		// Connection con = null;
		try {
			PropertyResourceBundle configBundle = (PropertyResourceBundle) PropertyResourceBundle
					.getBundle("common.product",
							new Locale("cn", "CN"));

			if (configBundle == null) {
				System.out.println("�ļ�product_cn_CN.properties�������");
				return false;
			}

			// the connect URL
			str_URL = configBundle.getString("ConnectString");
			// the connect userName
			str_userName = configBundle.getString("UserID");
			// the connect passWord
			str_passWord = configBundle.getString("Password");
			// the connect JDBCDriverName
			str_JdbcDriverName = configBundle.getString("JdbcDriverName");
			try {
				// ������������
				Class.forName(str_JdbcDriverName).newInstance();
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not found");
			}

			// DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			// DriverManager.registerDriver(null);

			this.conn = DriverManager.getConnection(str_URL, str_userName,
					str_passWord);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}