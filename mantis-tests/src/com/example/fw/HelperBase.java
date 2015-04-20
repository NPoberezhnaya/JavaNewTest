package com.example.fw;

public class HelperBase {

	protected ApplicationManager manager;
	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		
	};
	
	protected void pause(int p) {
		try {
			Thread.sleep(p);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
