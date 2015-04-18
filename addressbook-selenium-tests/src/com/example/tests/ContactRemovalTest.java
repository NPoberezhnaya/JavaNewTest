package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {
	@Test
	public void deleteSomeContact() {

		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper()
				.getContacts();

		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getContactHelper().deleteContact(index);

		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper()
				.getContacts();

		// compare

		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {

				assertThat(app.getModel().getContacts(), equalTo(app
						.getHibernateHelper().listContacts()));

			}
			if ("yes".equals(app.getProperty("check.ui"))) {

				assertThat(app.getModel().getContacts(), equalTo(app
						.getContactHelper().getUIContacts()));

			}
		}

	}
	

}
