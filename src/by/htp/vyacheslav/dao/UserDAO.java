package by.htp.vyacheslav.dao;

import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.entity.UserData;

public interface UserDAO {

	User authentification(String login, String password) throws DaoException;
	
	boolean registration(UserData userData) throws DaoException;

	public User getUserByLogin(String login) throws DaoException;
}
