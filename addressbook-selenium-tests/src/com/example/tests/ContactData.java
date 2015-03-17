package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String newGroup;
	public String address2;
	public String phone2;

	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, String bday, String bmonth,
			String byear, String newGroup, String address2, String phone2) {
		this.firstName = lastName;
		this.lastName = firstName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.newGroup = newGroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}

	public ContactData() {

	}


	@Override
	public int compareTo(ContactData other) {

		return this.lastName.toLowerCase().compareTo(
				other.lastName.toLowerCase());

	}

	public ContactData withName(String name) {
		this.lastName = name;
		return this;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;

	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;

	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;

	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withNewGroup(String newGroup) {
		this.newGroup = newGroup;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

}