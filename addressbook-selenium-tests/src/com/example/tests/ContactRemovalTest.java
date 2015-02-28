package com.example.tests;

import org.testng.annotations.Test;


public class ContactRemovalTest extends TestBase {
	@Test
	public void deleteSomeContact() {
		for (int i = 0; i < 10; i++) {
			app.getNavigationHelper().openMainPage();
			app.getContactHelper().initContactModification(2);
			app.getContactHelper().deleteContact(2);
			app.getNavigationHelper().returnToMainPage();
		}
	}

}
