package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;


public class TestBase {

	protected ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;

	@BeforeTest
//	@Parameters({ "configFile" })
	public void setUp() throws Exception {
		//if (configFile == null) {
			String configFile = System.getProperty("configFile",
					"application.properties");
	//	}

		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));

		app = new ApplicationManager(properties);
	
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty(
				"check.frequency", "0"));
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	protected boolean wantToCheck() {
		checkCounter++;
		if (checkCounter > checkFrequency) {
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
	}


}