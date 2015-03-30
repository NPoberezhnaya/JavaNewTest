package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modificateNameFirstGroup(GroupData group) {

		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getGroupHelper().modifyGroup(index, group);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		// compare

		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));

	}

}
