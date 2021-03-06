package com.mytest.common;

import java.sql.*;
import java.util.Locale;
import java.util.PropertyResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
					.getBundle("com.mytest.common.product",
							new Locale("cn", "CN"));

			if (configBundle == null) {
				System.out.println("configBundle is null");
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

	/**
	 * Returns the conn.
	 * 
	 * @return Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Sets the conn.
	 * 
	 * @param conn
	 *            The conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}