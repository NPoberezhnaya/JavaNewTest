package com.example.fw;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	private static ApplicationManager singleton;
	
	WebDriver driver;


	private Properties props;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	
	public ApplicationManager(Properties props) {
		this.props = props;
	}

	public void stop() {
		getProcessHelper().stopAppUnderTest();

	}
	
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();

	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}


	
	public void setProperty(Properties props) {
		this.props = props;
	}
	
	
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}

	
	public static ApplicationManager getInstance(Properties props) throws IOException {
		if (singleton == null) {
			singleton = new ApplicationManager(props);

			singleton.setProperty(props);

			singleton.start();
		}
		return singleton;
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}
	

	

}
