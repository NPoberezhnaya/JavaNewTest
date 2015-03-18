package com.example.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {

		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getGroupHelper().deleteGroup(index);

		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		// compare
		assertThat(newList, equalTo(oldList.without(index)));

	}

}
