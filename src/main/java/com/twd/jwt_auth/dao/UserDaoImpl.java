package com.twd.jwt_auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.twd.jwt_auth.model.User;
import com.twd.jwt_auth.util.DBConnection;

public class UserDaoImpl {

	public boolean saveUser(User user) {

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean validateUser(String username, String password) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT username,password FROM users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
