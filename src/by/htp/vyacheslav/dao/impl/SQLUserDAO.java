package by.htp.vyacheslav.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.vyacheslav.controller.command.util.HashGenerator;
import by.htp.vyacheslav.dao.DBConnection;
import by.htp.vyacheslav.dao.DaoException;
import by.htp.vyacheslav.dao.UserDAO;
import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.entity.UserData;

public class SQLUserDAO implements UserDAO{

	protected String insertNewUserQuery = "insert into users(login,name,surname,password,email,is_admin) values (?,?,?,?,?,?)";

	protected String getUserQuery = "SELECT * FROM users WHERE login = ? AND password = ? LIMIT 1";

	protected String getUserByLogin = "SELECT * FROM users WHERE login = ? LIMIT 1";

	@Override
	public User authentification(String login, String password)  throws DaoException{
		Connection connection;
		User user = new User();

		try {
			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(getUserQuery);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
					return null;
			} else {
				do {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String surname = resultSet.getString("surname");
					String email = resultSet.getString("email");
					String userLogin = resultSet.getString("login");
					boolean isAdmin = resultSet.getBoolean("is_admin");

					user.setEmail(email);
					user.setName(name);
					user.setId(id);
					user.setSurname(surname);
					user.setAdmin(isAdmin);
					user.setLogin(userLogin);
				} while (resultSet.next());
			}

			return user;

		}catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean registration(UserData userData) throws DaoException {
		Connection connection;
		PreparedStatement preparedStatement;
		int isInsert;

		try {

			connection = DBConnection.getConnection();
			preparedStatement = connection.prepareStatement(insertNewUserQuery);
			preparedStatement.setString(1, userData.getLogin());
			preparedStatement.setString(2, userData.getName());
			preparedStatement.setString(3, userData.getSurname());
			preparedStatement.setString(4, HashGenerator.generateHash(userData.getPassword()));
			preparedStatement.setString(5, userData.getEmail());
			preparedStatement.setBoolean(6, userData.isAdmin());

			isInsert = preparedStatement.executeUpdate();


		} catch (Exception ex){
			throw new DaoException();
		}


		if (isInsert != 0) {

			return  true;
		}

		return false;
	}

	@Override
	public User getUserByLogin(String login) throws DaoException {
		Connection connection;

		try {
			User user = new User();

			connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(getUserByLogin);
			preparedStatement.setString(1, login);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				return null;
			} else {
				do {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String surname = resultSet.getString("surname");
					String email = resultSet.getString("email");
					boolean isAdmin = resultSet.getBoolean("is_admin");
					String userLogin = resultSet.getString("login");

					user.setEmail(email);
					user.setName(name);
					user.setId(id);
					user.setSurname(surname);
					user.setAdmin(isAdmin);
					user.setLogin(userLogin);
				} while (resultSet.next());
			}

			return user;
		} catch (SQLException e){
			throw new DaoException(e);
		}

	}
}

