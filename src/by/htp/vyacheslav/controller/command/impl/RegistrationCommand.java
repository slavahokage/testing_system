package by.htp.vyacheslav.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.vyacheslav.controller.command.Command;
import by.htp.vyacheslav.entity.User;
import by.htp.vyacheslav.entity.UserData;
import by.htp.vyacheslav.service.ClientService;
import by.htp.vyacheslav.service.ServiceException;
import by.htp.vyacheslav.service.ServiceProvider;
import by.htp.vyacheslav.service.validation.SignValidator;

public class RegistrationCommand implements Command{

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_SURNAME = "surname";
	private static final String PARAMETER_EMAIL = "email";

	private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
	private static final String INDEX_PAGE = "/index.jsp";
	private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";
	private static final String USER_PAGE = "/WEB-INF/jsp/userPage.jsp";


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String login;
		String password;
		String email;
		String name;
		String surname;

		login = request.getParameter(PARAMETER_LOGIN);
		password = request.getParameter(PARAMETER_PASSWORD);
		email = request.getParameter(PARAMETER_EMAIL);
		name = request.getParameter(PARAMETER_NAME);
		surname = request.getParameter(PARAMETER_SURNAME);
		
		ServiceProvider provider = ServiceProvider.getInstance();
		ClientService service = provider.getClientService();

		UserData userData = new UserData();

	
		userData.setName(name);
		userData.setSurname(surname);
		userData.setEmail(email);
		userData.setLogin(login);
		userData.setPassword(password);

		synchronized (this) {
			try {
				boolean result = service.registration(userData);

				if (result) {
					request.setAttribute("success", "Successfully register");
					User user = service.getUserByLogin(userData.getLogin());

					HttpSession session=request.getSession();
					session.setAttribute("user",user.getLogin());

				} else {
					request.setAttribute("errors", SignValidator.getErrors());
				}

			} catch (ServiceException e) {

				request.setAttribute("exception", "Error. Try again! Login or email is already taken");
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTRATION_PAGE);
		dispatcher.forward(request, response);

	}

}
