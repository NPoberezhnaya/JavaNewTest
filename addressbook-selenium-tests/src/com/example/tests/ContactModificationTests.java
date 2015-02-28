package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modificateNameOnFirstContact() {

		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstName = "new name";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().sumbitContactModification();
		app.getNavigationHelper().returnToMainPage();

	}
	
	@Test
	public void modificateBirthDataOnFirstContact() {

		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(2);
		ContactData contact = new ContactData();
		contact.bday = "10";
		contact.bmonth = "June";
		contact.byear = "2011";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().sumbitContactModification();
		app.getNavigationHelper().returnToMainPage();

	}
	
	

}
