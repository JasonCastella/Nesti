package nesti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryUser extends MyConnection {

	static String ing;

	/**
	 * Create a new user
	 * 
	 * @param user: object with the user's information
	 */
	public static void createUser(User user) {
		openConnection();
		try {
			String query = "INSERT INTO user(last_name, first_name, city, user_name, email, password) VALUES (?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, user.getLastName());
			declaration.setString(2, user.getFirstName());
			declaration.setString(3, user.getCity());
			declaration.setString(4, user.getUserName());
			declaration.setString(5, user.getEmail());
			declaration.setString(6, user.getPassword());
			declaration.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erreur d'insertion de donnée : " + e.getMessage());
		}
		closeConnection();
	}

	public static User findUser(String fieldName, String fieldValue) {
		openConnection();
		User user = null;
		var query = "";
		try {
			query = "SELECT * FROM user WHERE " + fieldName + " = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, fieldValue);
			ResultSet rs = declaration.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setIdUser(rs.getInt("id_user"));
				user.setLastName(rs.getString("last_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setCity(rs.getString("city"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.err.println("Erreur de lecture de donnée : " + e.getMessage());
		}
		closeConnection();
		return user;
	}

	/*
	public static boolean validUpdate(User user) {
		boolean flag = true;
		openConnection();
		var query = "";
		try {
			query = "SELECT id_user FROM user WHERE (email = ? OR user_name= ?) AND id_user <> ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, user.getEmail());
			declaration.setString(2, user.getUserName());
			declaration.setInt(3, user.getIdUser());
			ResultSet rs = declaration.executeQuery();
			if (rs.next()) {
				flag=false;
			}
		} catch (Exception e) {
			System.err.println("Erreur de lecture de donnée : " + e.getMessage());
		}
		closeConnection();
		return flag;
	}
	 */

	/**
	 * Check if there is a couple of email (or user name) and password in the
	 * database
	 * 
	 * @param id  : user name or email in the JTextField from Connection
	 * @param pwd : password in the JTextField from Connection
	 * @return true if there is a valid couple of email (or user name) and password
	 *         in the database, else false
	 */

	/*
	 * public static boolean testCo(String id, String pwd) { boolean test = false;
	 * openConnection(); String query = ""; try { query =
	 * "SELECT last_name FROM user WHERE password = ? AND (email = ? OR user_name = ?)"
	 * ; PreparedStatement declaration = accessDataBase.prepareStatement(query);
	 * declaration.setString(1, pwd); declaration.setString(2, id);
	 * declaration.setString(3, id); ResultSet rs = declaration.executeQuery(); if
	 * (rs.next()) { test = true; } } catch (Exception e) {
	 * System.err.println("Erreur de lecture de donnée : " + e.getMessage()); }
	 * closeConnection(); return test; }
	 */

	/**
	 * Load the information corresponding to the id (email or user name) in the
	 * JTextField from Connection
	 * 
	 * @param id: user name or email in the JTextField from Connection
	 * @return the corresponding data as 'user'
	 */
	/*
	 * public static User readUser(String id) { openConnection(); User user = new
	 * User(); try { String query =
	 * "SELECT * FROM user WHERE user_name = ? OR email = ?"; PreparedStatement
	 * declaration = accessDataBase.prepareStatement(query);
	 * declaration.setString(1, id); declaration.setString(2, id); ResultSet rs =
	 * declaration.executeQuery(); rs.next();
	 * user.setLastName(rs.getString("last_name"));
	 * user.setFirstName(rs.getString("first_name"));
	 * user.setCity(rs.getString("city"));
	 * user.setUserName(rs.getString("user_name"));
	 * user.setEmail(rs.getString("email"));
	 * user.setPassword(rs.getString("password")); } catch (Exception e) {
	 * System.err.println("Erreur de lecture de donnée : " + e.getMessage()); }
	 * closeConnection(); return user; } /*
	 * 
	 * /** Allows to update the user's data
	 * 
	 * @param user: user that wants to make updates
	 */
	public static void updateUser(User user) {
		openConnection();
		// int nbUpdate = 0;
		try {
			String query = "UPDATE user SET last_name = ?, first_name = ?, city = ?, user_name = ?, email = ?, password = ? WHERE id_user = ? ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, user.getLastName());
			declaration.setString(2, user.getFirstName());
			declaration.setString(3, user.getCity());
			declaration.setString(4, user.getUserName());
			declaration.setString(5, user.getEmail());
			declaration.setString(6, user.getPassword());
			declaration.setInt(7, user.getIdUser());
			declaration.executeUpdate();
			// nbUpdate = declaration.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur de modification de donnée : " + e.getMessage());
		}
		closeConnection();
		// return (nbUpdate == 1); Permet de savoir combien de ligne on fait une
		// modification (en locurence ici on travaille que sur 1 d'ou le ==1)
	}
}
