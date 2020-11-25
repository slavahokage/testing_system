package by.htp.vyacheslav.service.impl;

import by.htp.vyacheslav.dao.DAOProvider;
import by.htp.vyacheslav.dao.DaoException;
import by.htp.vyacheslav.dao.UserDAO;
import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.service.ClientService;
import by.htp.vyacheslav.service.ServiceException;
import by.htp.vyacheslav.entity.UserData;

public class ClientServiceImpl implements ClientService{

	@Override
	public User authorization(String login, String password) throws ServiceException{

		
		DAOProvider daoProvider = DAOProvider.getInstance();
		UserDAO userDAO = daoProvider.getUserDAO();

		User user = null;

		try {
			user = userDAO.authentification(login, password);
		}catch (DaoException e){
			throw new ServiceException(e);
		}

		return user;
	}


	@Override
	public boolean registration(UserData user) throws ServiceException{
		
		//validation
		
		DAOProvider daoProvider = DAOProvider.getInstance();
		UserDAO userDAO = daoProvider.getUserDAO();

		try {
			return userDAO.registration(user);
		}catch (DaoException e){
			throw new ServiceException(e);
			
		}

	}
}


