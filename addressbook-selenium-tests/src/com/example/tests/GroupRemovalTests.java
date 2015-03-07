package com.example.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
@Test
public void deleteSomeGroup(){
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().returnToGroupPage();
	//save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	//actions
	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);
	app.getGroupHelper().deleteGroup(index);
	app.getNavigationHelper().returnToGroupPage();
	//save new state
	List<GroupData> newList = app.getGroupHelper().getGroups();
	//compare
	
	oldList.remove(index);
	Collections.sort(oldList);
	assertEquals(newList, oldList);
}


}
