package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
@Test
public void deleteSomeGroup(){
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().returnToGroupPage();
	//save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
	app.getGroupHelper().deleteGroup(0);
	app.getNavigationHelper().returnToGroupPage();
	//save new state
	List<GroupData> newList = app.getGroupHelper().getGroups();
	//compare
	
	oldList.remove(0);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
}


}
