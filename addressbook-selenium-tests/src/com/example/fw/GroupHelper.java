package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_group_header"), group.header);
		type(By.name("group_footer"), group.footer);

	}

	public void sumbitGroupCreation() {
		click(By.name("submit"));
	}



	public void deleteGroup(int i) {
		SelectGroupByIndex(i);
		click(By.name("delete"));

	}

	public void initGroupModification(int i) {
		SelectGroupByIndex(i);
		click(By.name("edit"));
		
	}

	private void SelectGroupByIndex(int i) {
		click(By.cssSelector("[name*=selected]:nth-of-type("+i+")"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
		
	}

	
}
