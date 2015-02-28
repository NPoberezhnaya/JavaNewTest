package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupPage();
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group1";
		group.header = "header1";
		group.footer = "footer1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().sumbitGroupCreation();
		app.getNavigationHelper().returnToGroupPage();
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare states
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(oldList, newList);

	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupPage();
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		app.getGroupHelper().initGroupCreation();

		GroupData group = new GroupData("", "", "");
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().sumbitGroupCreation();
		app.getNavigationHelper().returnToGroupPage();
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(oldList, newList);
	}
}