package nesti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//Password Validator
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	private static final Pattern patternPwd = Pattern.compile(PASSWORD_PATTERN);

	public static boolean pwdIsValid(final String password) {
		Matcher matcher = patternPwd.matcher(password);
		return matcher.matches();
	}

	
	//Username Validator
	private static final String USERNAME_PATTERN = "^[\\w-]{4,}$";

	private static final Pattern patternUsername = Pattern.compile(USERNAME_PATTERN);

	public static boolean usernameIsValid(final String user_name) {
		Matcher matcher = patternUsername.matcher(user_name);
		return matcher.matches();
	}

	
	//Email Validator
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean emailIsValid(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}
}
