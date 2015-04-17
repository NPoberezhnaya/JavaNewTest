package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {

	protected ApplicationManager app;
	private int checkCounter;
	private int checkFreguency;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile",
				"application.properties");
		
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		checkCounter = 0;
		checkFreguency = Integer.parseInt(properties.getProperty(
				"check.freguency", "0"));
	}

	protected boolean wantToCheck(){
		checkCounter++;
		if (checkCounter > checkFreguency){
			checkCounter = 0;
			return true;
		}else {
			return false;
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {

		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {

		return wrapContactsForDataProvider(generateRandomContacts(5))
				.iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(
			List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[] { group });
		}
		return list;
	}

	public static List<Object[]> wrapContactsForDataProvider(
			List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[] { contact });
		}
		return list;
	}

}