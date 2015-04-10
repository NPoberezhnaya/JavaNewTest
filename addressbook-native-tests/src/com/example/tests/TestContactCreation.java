package com.example.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase{
	@Test
	public void shouldCreateContactWithValidData(){
		
		Contact contact = new Contact();
		contact.setFirstName("tester1").setLastName("tester2");
		app.getContactHelper().createContact(contact);
		
		Contact createdContact = app.getContactHelper().getFirstContact();
	    Assert.assertEquals(contact, createdContact);
		
		
	}

}
