package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactModificationWithValidData(ContactData contact)
			throws Exception {
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getContactHelper().modifyContact(index, contact);
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		// compare
		oldList.remove(index);
		oldList.add(contact);
		assertEquals(oldList, newList);

	}
}
