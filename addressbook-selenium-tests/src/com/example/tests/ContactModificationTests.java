package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	

	}
}
