package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		returnToGroupPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		rebuildCash();
		return this;
		
	

	}

	private SortedListOf<GroupData> cashedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cashedGroups == null) {
			rebuildCash();
		}
		return cashedGroups;
	}

	private void rebuildCash() {
		 cashedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {

			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length()
					- ")".length());

			cashedGroups.add(new GroupData().withName(name));
		}

	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		sumbitGroupCreation();
		returnToGroupPage();
		rebuildCash();
		return this;

	}

	public GroupHelper deleteGroup(int i) {
		SelectGroupByIndex(i);
		submitGroupDeletion();
		returnToGroupPage();
		rebuildCash();
				return this;

	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		cashedGroups = null;
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
		cashedGroups = null;
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
		cashedGroups = null;
		return this;

	}

	public GroupHelper returnToGroupPage() {
		click(By.linkText("groups"));
		return this;
	}


}
