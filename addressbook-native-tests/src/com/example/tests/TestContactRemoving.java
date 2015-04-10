package com.example.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactRemoving extends TestBase{
	@Test
	public void shouldRemoveContactWithValidData(){
		Contact contact = app.getContactHelper().getFirstContact();
		app.getContactHelper().deleteContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
	    Assert.assertNotEquals(contact, createdContact);
		
		
	}

}
