package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase {
	private Process exec;
	private ApplicationManager manager;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}

	public void startAppUnderTest() throws IOException {
		String command = manager.getProperty("app.path");
		//exec = Runtime.getRuntime().exec(command);
		exec = Runtime.getRuntime().exec("D:/eclipse/eclipseLast/data/SSuiteAddressBookPro2/AddressBook.exe");
	}

	public void stopAppUnderTest() {
		exec.destroy();
	}

}
