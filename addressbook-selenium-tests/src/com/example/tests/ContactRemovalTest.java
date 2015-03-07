package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	@Test
	public void deleteSomeContact() {

		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		app.getContactHelper().initContactModification(index);
		app.getContactHelper().deleteContact(index);
		app.getNavigationHelper().returnToMainPage();
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		// compare
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
