package by.htp.vyacheslav.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.htp.vyacheslav.dao.DBConnection;
import by.htp.vyacheslav.dao.DaoException;
import by.htp.vyacheslav.dao.UserDAO;
import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.entity.UserData;

public class SQLUserDAO implements UserDAO{

	protected String insertNewUserQuery = "insert into users(login,name,surname,password,email,is_admin) values (?,?,?,?,?,?)";

	@Override
	public User authentification(String login, String password)  throws DaoException{

		try {
			throw new SQLException();
		}catch (SQLException e) {
			throw new DaoException(e);
		}
		
		//return null;
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
			preparedStatement.setString(4, userData.getPassword());
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
}

