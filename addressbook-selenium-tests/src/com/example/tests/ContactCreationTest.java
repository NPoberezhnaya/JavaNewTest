package com.example.tests;

import static org.testng.Assert.assertEquals;


import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact)
			throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// actions
		app.getContactHelper().initContactCreation();

		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().sumbitContactCreation();
		// save new state
		app.getNavigationHelper().openMainPage();
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare

		oldList.add(contact);
		assertEquals(oldList, newList);

	}

}