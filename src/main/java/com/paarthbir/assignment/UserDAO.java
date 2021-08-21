package com.paarthbir.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	public void getAllUsers(Statement stmt) throws SQLException {
		String str = "select userId,firstName,lastName,email from users";
		ResultSet rs = stmt.executeQuery(str);
		int rowCounter = 0;
		while (rs.next()) {
			int userId = rs.getInt("userId");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String email = rs.getString("email");
			System.out.println("The Data =");
			System.out.println("userId = " + userId);
			System.out.println("firstName = " + firstName);
			System.out.println("lastName = " + lastName);
			System.out.println("email = " + email);
			++rowCounter;
		}
		System.out.println("Count of records: " + rowCounter);
	}
	
	public void saveData(Connection con, int userId,String firstName,String lastName,String email) throws SQLException {
		if (con != null && !con.isClosed()) {
			String str = "insert into users (userId,firstName,lastName,email) values (?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(str);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, email);
			int row = preparedStatement.executeUpdate();
		}

	}

	public void deleteUser(Connection con, Statement stmt, int userId) throws SQLException {
		if (con != null && !con.isClosed()) {
			String sql = "delete from users where userId=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, userId);
			int counter = statement.executeUpdate();
			System.out.println("The delete recorded:- " + counter);
		}	
	}

	public void updateUser(Connection con, Statement stmt, int userId, String firstName,String lastName,String email) throws SQLException {
		if (con != null && !con.isClosed()) {
			String sql = "UPDATE users SET firstName=?, lastName=?, email=? where userId=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
			statement.setInt(4, userId);
			System.out.println(statement);
			int counter = statement.executeUpdate();
			System.out.println("Update performed");
		}
	}

}
