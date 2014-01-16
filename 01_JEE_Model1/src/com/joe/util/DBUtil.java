package com.joe.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public ResultSet select(PreparedStatement ps, String sql) {
		ResultSet rs = null;
		try {
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
