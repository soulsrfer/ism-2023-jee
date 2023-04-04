package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.bean.UserBean;
import com.google.util.DbConnection;

public class UserDao {

	public void addUser(UserBean userBean) {
		try {
			// store into database
			Connection con = DbConnection.getConnection();
			// sql
			// Statement
			// PreparedStatement
			// CallableStatement
			PreparedStatement pstm = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?) ");
			pstm.setString(1, userBean.getFirstName());
			pstm.setString(2, userBean.getEmail());
			pstm.setString(3, userBean.getPassword());

			int record = pstm.executeUpdate(); // db -> 1 -> inserted , updated , deleted

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserBean authenticate(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// insert update delete -> executeUpdate()
			// read select --> executeQuery()

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) { // true
				user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { // true
				UserBean user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	public void deleteUser(Integer userId) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where userId = ? ");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
