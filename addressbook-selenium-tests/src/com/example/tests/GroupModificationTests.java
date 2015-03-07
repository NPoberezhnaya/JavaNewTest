package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modificateNameFirstGroup(GroupData group) {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().returnToGroupPage();
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getGroupHelper().initGroupModification(index);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().returnToGroupPage();
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare

		oldList.remove(index);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(oldList, newList);

	}

	
}
