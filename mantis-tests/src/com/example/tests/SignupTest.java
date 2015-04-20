package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class SignupTest extends TestBase {
	@Test
	public void newUserShouldSignuptest() {
		User user = new User().setLogin("testuser111").setPassword("123456")
				.setEmail("testuser11@localhost.localdomain");
		
		app.getAccountHelper().signUp(user);

		assertTrue(app.getAccountHelper().isLogged(user));
	}
}
