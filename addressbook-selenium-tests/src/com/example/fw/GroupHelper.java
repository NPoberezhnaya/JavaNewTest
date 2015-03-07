package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		type(By.name("group_header"), group.header);
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
		click(By.cssSelector("[name*=selected]:nth-of-type(" + (i + 1) + ")"));

	}

	public void submitGroupModification() {
		click(By.name("update"));

	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList();
		List<WebElement> checkboxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length()
					- ")".length());
			groups.add(group);
		}

		return groups;
	}

}