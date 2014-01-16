package com.joe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	public static Connection createConnection() {
		Connection conn = null;
		String url="jdbc:mysql://localhost:3306/joexiao?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "admin";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	public static void close(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			ps.close();
			ps = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
			rs = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}    
}
