package com.example.fw;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	private void confirmContactCreation() {
		manager.getAutoItHelper().winWaitAndActivate("Add Contact", "", 5000)
				.click("Save");
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper().send("TDBEdit12", contact.getFirstName())
				.send("TDBEdit11", contact.getLastName());
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", 5000)
				.click("Add").winWaitAndActivate("Add Contact", "", 8000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", 5000)
				.click("TListView1").send("{DOWN} {SPACE}").click("Edit")
				.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact().setFirstName(
				manager.getAutoItHelper().getText("TDBEdit12")).setLastName(
				manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
				.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
	}

	public void createContact(Contact contact) {

		initContactCreation();

		fillContactForm(contact);

		confirmContactCreation();

	}

	public void deleteContact(Contact contact) {

		initContactRemoving();

		deleteContactForm(contact);

		confirmContactRemoving();

	}

	private void confirmContactRemoving() {
		manager.getAutoItHelper().winWaitAndActivate("Confirm", "", 10000)
				.click("TButton2");

	}

	private void deleteContactForm(Contact contact) {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", 8000)
				.click("Delete");

	}

	private void initContactRemoving() {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", 8000)
				.click("TListView1").send("{DOWN} {SPACE} {DOWN} {SPACE}");

	}
	
	public void exit() {
		manager.getAutoItHelper()
				.winWaitAndActivate("AddressBook Portable", "", 8000)
				.click("Exit");

	}
	

}
