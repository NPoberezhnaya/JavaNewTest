package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		returnToGroupPage().initGroupModification(index).fillGroupForm(group)
				.submitGroupModification().returnToGroupPage();
		manager.getModel().removeGroup(index).addGroup(group);
		return this;

	}

	public GroupHelper createGroup(GroupData group) {
		returnToGroupPage().initGroupCreation().fillGroupForm(group)
				.sumbitGroupCreation().returnToGroupPage();
		// update model
		manager.getModel().addGroup(group);

		return this;

	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		SelectGroupByIndex(index).submitGroupDeletion().returnToGroupPage();
		manager.getModel().removeGroup(index);
		return this;

	}

	private GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		return this;
	}

	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;

	}

	public GroupHelper sumbitGroupCreation() {
		click(By.name("submit"));

		return this;
	}

	public GroupHelper initGroupModification(int i) {
		SelectGroupByIndex(i);
		click(By.name("edit"));

		return this;

	}

	private GroupHelper SelectGroupByIndex(int i) {
		click(By.cssSelector("[name*=selected]:nth-of-type(" + (i + 1) + ")"));
		return this;

	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;

	}

	public SortedListOf<GroupData> getUIGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {

			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()
					- ")".length());

			groups.add(new GroupData().withName(name));
		}
		return groups;

	}

	public GroupHelper returnToGroupPage() {
		click(By.linkText("groups"));
		return this;
	}

}
