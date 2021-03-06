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
import by.htp.vyacheslav.service.ClientService;
import by.htp.vyacheslav.service.ServiceException;
import by.htp.vyacheslav.service.ServiceProvider;

public class AuthorizationCommand implements Command{

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";

	private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
	private static final String INDEX_PAGE = "/index.jsp"; // here was index.jsp
	private static final String DEFAULT_PAGE = "/WEB-INF/jsp/authorization.jsp";


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		
		login = request.getParameter(PARAMETER_LOGIN);
		password = request.getParameter(PARAMETER_PASSWORD);

		ServiceProvider provider = ServiceProvider.getInstance();
		ClientService service = provider.getClientService();

		User user = null;
		String page;
		
		try {
			
			user = service.authorization(login, password);
			
			if (user == null) {
				request.setAttribute("error", "login or password error");
				page = DEFAULT_PAGE;
			}else {

				String userLogin = user.getLogin();

				HttpSession session=request.getSession();

				session.setAttribute("user", userLogin);

				request.setAttribute("success", "Successfully login as " + userLogin);
				page = DEFAULT_PAGE;
			}

		} catch (ServiceException e) {
			request.setAttribute("error", "login or password error");
			page = DEFAULT_PAGE;
			// log
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
