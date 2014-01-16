package com.joe.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joe.util.DBConnection;
import com.joe.vo.UserVO;

public class BizUser {

	public boolean checkUser(UserVO user) throws SQLException{
		if (user == null) {
			return false;
		}
		
		if (user.getName() == null || "".equals(user.getName())) {
			return false;
		}
		
		Connection conn = DBConnection.createConnection();
		String sql = "select * from tb_user";
		
		PreparedStatement ps = DBConnection.prepare(conn, sql);
		ResultSet rs = ps.executeQuery();
		if (rs == null) {
			return false;
		}
		
		boolean boolFoundUser = false;
		while (rs.next()) {
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			
			if (name.equals(user.getName()) && pwd.equals(user.getPassword())) {
				boolFoundUser = true;
				break;
			}
		}
		return boolFoundUser;
	}
	
	public List<UserVO> retrieveAllUsers()  throws SQLException{
		List<UserVO> users = new ArrayList<UserVO>();
		Connection conn = DBConnection.createConnection();
		String sql = "select * from tb_user";
		
		PreparedStatement ps = DBConnection.prepare(conn, sql);
		ResultSet rs = ps.executeQuery();
		if (rs == null) {
			return null;
		}
		
		while (rs.next()) {
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			
			UserVO vo = new UserVO();
			vo.setName(name);
			vo.setPassword(pwd);
			users.add(vo);
		}
		return users;
	}
}
