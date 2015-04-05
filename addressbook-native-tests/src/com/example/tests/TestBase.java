package com.example.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.example.fw.ApplicationManager;

public class TestBase {


	protected ApplicationManager app;

	@BeforeTest
	@Parameters({ "configFile" })
	public void setUp(@Optional String configFile)
			throws FileNotFoundException, IOException {
	
		if (configFile == null) {
			configFile = "application.properties";
		}

		Properties props = new Properties();

		props.load(new FileReader(configFile));

		app = ApplicationManager.getInstance(props);


	}

	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance(null).stop();

	}

}