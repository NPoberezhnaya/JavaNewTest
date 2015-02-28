package com.example.tests;

import org.testng.annotations.Test;



public class GroupModificationTests extends TestBase{

	@Test
	public void modificateNameFirstGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().returnToGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().returnToGroupPage();
		
	}
	
	@Test
	public void modificateHeaderFirstGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().returnToGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.header = "new header";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().returnToGroupPage();
		
	}
	
	@Test
	public void modificateFooterFirstGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().returnToGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.footer = "new footer";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().returnToGroupPage();
		
	}
	
	


	}
