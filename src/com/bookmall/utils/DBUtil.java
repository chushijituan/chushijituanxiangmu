package com.bookmall.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.1.247:1521:bookdb1";
	public static final String USER = "king";
	public static final String PASSWORD = "bookdb";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	public static void getClose(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
