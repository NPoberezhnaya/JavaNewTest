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
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		// actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		app.getGroupHelper().modifyGroup(index, group);

		// save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		// compare

	
//////
		if (wantToCheck()) {
			if ("yes".equals(app.getProperty("check.db"))) {

				assertThat(app.getModel().getGroups(), equalTo(app
						.getHibernateHelper().listGroups()));

			}
			if ("yes".equals(app.getProperty("check.ui"))) {

				assertThat(app.getModel().getGroups(), equalTo(app
						.getGroupHelper().getUIGroups()));

			}

		}
		
		
		
		
		///////
	}

}
