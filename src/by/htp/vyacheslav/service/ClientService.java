package by.htp.vyacheslav.service;

import by.htp.vyacheslav.dao.DaoException;
import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.entity.UserData;

public interface ClientService {

		User authorization(String login, String password) throws ServiceException;

		boolean registration(UserData user) throws ServiceException;

	    public User getUserByLogin(String login) throws ServiceException;
}
