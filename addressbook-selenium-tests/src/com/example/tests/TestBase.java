package com.example.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;
public class TestBase {

	public ApplicationManager app;

	

	@BeforeTest

	public void setUp() throws Exception {
		app = new ApplicationManager();
		
	}

	@AfterTest


	public void tearDown() throws Exception {
		app.stop();
	
	}

}