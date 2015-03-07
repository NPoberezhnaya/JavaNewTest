package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactModificationWithValidData(ContactData contact)
			throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().sumbitContactModification();
		// save new state
		app.getNavigationHelper().openMainPage();
		List<ContactData> newList = app.getContactHelper().getContacts();
		// compare
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(oldList, newList);

	}

}
