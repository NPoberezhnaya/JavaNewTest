package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class TestBase  {

	public ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		//

		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
			.withName( generateRandomString())
			.withHeader(generateRandomString())
			.withFooter( generateRandomString());
		
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	



	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		//
		
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			
			contact.lastName = generateRandomString();

			contact.firstName = generateRandomString();
		
			contact.address = "Deribasovskay street, "+generateRandomNumber();
			contact.address2 = "Deribasovskay street, "+generateRandomNumber();
			contact.bday = generateRandomBDay();
			contact.bmonth = generateRandomMonth();
			contact.byear = generateRandomYear();
			contact.email = generateRandomMail();
			contact.email2 =generateRandomMail();
			contact.homePhone = generatePhoneNumberNumber();
			contact.mobilePhone = generateMobilePhoneNumberNumber();
			//contact.newGroup = "[none]";
			contact.phone2 =  generatePhoneNumberNumber();
			contact.workPhone =  generatePhoneNumberNumber();
			
		
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	private String generateRandomBDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return "" + (1+rnd.nextInt(30));
		}
	}

	public String generateRandomString() {
		Random rnd = new Random();
		
			return "test" + rnd.nextInt(60);
		
	}

	public String generateMobilePhoneNumberNumber() {
		Random rnd = new Random();
		Integer res = 980000000;
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			res += rnd.nextInt(999999);
		}
		return "0"+res.toString();
	}
	public String generatePhoneNumberNumber() {
		Random rnd = new Random();
		Integer res = 71900000;
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			res += rnd.nextInt(99999);
		}
		return res.toString();
	}
	public String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "" + rnd.nextInt(2015);
		}
	}
	public String generateRandomMail() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt(2015)+"@uklr.net";
		}
	}
	public String generateRandomYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			Integer res = 1950 + rnd.nextInt(65);
			
			return res.toString();
		}
	}
	public String generateRandomMonth() {
		Random rnd = new Random();
		int month;
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			month =  1 + rnd.nextInt(12);
		}
		String res= "";
		switch (month) {
		case 1:
			res = "January";
			break;
		case 2:
			res = "February";
			break;
		case 3:
			res = "March";
			break;
		case 4:
			res = "April";
			break;
		case 5:
			res = "May";
			break;
		case 6:
			res = "June";
			break;
		case 7:
			res = "July";
			break;
		case 8:
			res = "August";
			break;
		case 9:
			res = "September";
			break;
		case 10:
			res = "October";
			break;
		case 11:
			res = "November";
			break;
		case 12:
			res = "December";
			break;
		
		default:
			break;
		}
		
		return res;
	}

}