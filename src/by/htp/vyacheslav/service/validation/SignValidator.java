package by.htp.vyacheslav.service.validation;

import by.htp.vyacheslav.entity.UserData;

import java.util.ArrayList;
import java.util.List;

public class SignValidator {

	private static List<String> errors = new ArrayList<>();

	private SignValidator() {
	}

	public static boolean validate(UserData userData) {

		errors.clear();

		if (userData.getPassword().length() < 5) {
			errors.add("Too short password");
		}

		if (userData.getLogin().length() < 2) {
			errors.add("Too short login");
		}

		if (userData.getName().length() < 2) {
			errors.add("Too short name");
		}

		if (userData.getSurname().length() < 2) {
			errors.add("Too short surname");
		}

		if (userData.getEmail().length() < 2) {
			errors.add("Too short email");
		}


		return errors.isEmpty();

	}


	public static List<String> getErrors(){
		return errors;
	}

}
