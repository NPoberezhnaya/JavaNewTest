package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public ContactHelper initContactModification(int i) {
		SelectContactByIndex(i);
		return this;
	}

	private void SelectContactByIndex(int i) {
		click(By.cssSelector("[name='entry']:nth-of-type(" + (i + 2)
				+ ") [title='Edit']"));
	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		cashedContacts = null;
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {

		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);

		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);

		type(By.name("byear"), contact.byear);
		if (formType = CREATION) {
			// selectByText(By.name("new_group"), contact.newGroup);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error(
						"Group seector exists in contact modification form");
			}
		}

		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);

		return this;
	}

	public ContactHelper sumbitContactModification() {
		click(By.cssSelector("[value='Update']"));
	cashedContacts = null;
		return this;
	}

	public ContactHelper sumbitContactRemoval() {
		click(By.cssSelector("[value='Delete']"));
		cashedContacts = null;
		return this;
	}

	public ContactHelper sumbitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	// /////////////////////
	public ContactHelper deleteContact(int index) {
		initContactModification(index).sumbitContactRemoval().openMainPage()
				.rebuildCash();
		return this;
	}

	private SortedListOf<ContactData> cashedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cashedContacts == null) {
			rebuildCash();
		}
		return cashedContacts;
	}

	private void rebuildCash() {
		cashedContacts = new SortedListOf<ContactData>();

		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver
				.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {

			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(),
					title.length() - ")".length());
			String lastName = title.substring(title.indexOf(" ") + 1,
					title.length());
			System.out.println(lastName);
			cashedContacts.add(new ContactData().withName(lastName));

		}

	}

	public ContactHelper openMainPage() {
		manager.driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		return this;
	}

	public ContactHelper createContact(ContactData contact) {
		openMainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		sumbitContactCreation();

		rebuildCash();

		return this;

	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		openMainPage();
		initContactModification(index).fillContactForm(contact, MODIFICATION)
				.sumbitContactModification();
		openMainPage();
		rebuildCash();
		return this;

	
		
		
		
	}
}
