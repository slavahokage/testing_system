package by.htp.vyacheslav.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.vyacheslav.controller.command.impl.AuthorizationCommand;
import by.htp.vyacheslav.controller.command.impl.ChangeLocale;
import by.htp.vyacheslav.controller.command.impl.GoToIndexPageCommand;
import by.htp.vyacheslav.controller.command.impl.GoToRegistrationCommand;
import by.htp.vyacheslav.controller.command.impl.RegistrationCommand;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	
	public CommandProvider() {
		commands.put("authorization", new AuthorizationCommand());
		commands.put("go_to_registration", new GoToRegistrationCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("go_to_index", new GoToIndexPageCommand());
		commands.put("change_locale", new ChangeLocale());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
