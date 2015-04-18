package com.example.fw;

import java.util.List;

import com.example.tests.GroupData;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	public SortedListOf<GroupData> groups;
	public SortedListOf<ContactData> contacts;

	public SortedListOf<GroupData> getGroups() {
		
		return groups;

	}

	
	public SortedListOf<ContactData> getContacts() {
		return contacts;

	}

	
	public void setGroups(List<GroupData> groups) {
		 this.groups = new SortedListOf<GroupData>(groups);
	}
	
	
	public void setContacts(List<ContactData> contacts) {
		 this.contacts = new SortedListOf<ContactData>(contacts);
	}
	

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
		
	}
	
	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
		
	}
	
	public ApplicationModel  addContact(ContactData contact) {
		contacts.add(contact);
		return this;
		
	}

	public ApplicationModel  addGroup(GroupData group) {
		groups.add(group);
		return this;
		
	}

	
}
