package nesti;

import junit.framework.TestCase;

class UnitTest extends TestCase {


	public void testPwd() throws Exception {
		assertEquals(false, Validator.pwdIsValid("aze"));
		assertEquals(true, Validator.pwdIsValid("Azerty123456!"));
	}

	public void testUsername() throws Exception {
		assertEquals(false, Validator.usernameIsValid("aze"));
		assertEquals(true, Validator.usernameIsValid("Francis"));
	}

	public void testEmail() throws Exception {
		assertEquals(false, Validator.emailIsValid("aze"));
		assertEquals(true, Validator.emailIsValid("francis@gmail.com"));
	}
}
