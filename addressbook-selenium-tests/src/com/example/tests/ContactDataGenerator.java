package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out
					.println("Please specify parametres: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: "
					+ file);
			return;
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {

			System.out.println("Unknown format" + format);
			return;
		}

	}

	public static List<ContactData> loadContactsFromCsvFile(File file)
			throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			//
			String[] part = line.split(",");
			ContactData contact = new ContactData().withFirstName(part[0])
					.withName(part[1]).withEmail(part[2])
					.withHomePhone(part[3]);
			list.add(contact);
			line = bufferedReader.readLine();

		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> loadContactsFromXmlFile(File file)
			throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);

		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName()
					+ "," + contact.getEmail() + "," + contact.getHomePhone()

					+ contact.getAddress() + "," + contact.getAddress2() + ","
					+ contact.getBday() + "," + contact.getBmonth() + ","
					+ contact.getByear() + "," + contact.getEmail2() + ","
					+ contact.getMobilePhone() + "," + contact.getNewGroup()
					+ "," + contact.getPhone2() + "," + contact.getWorkPhone()
					+ "!" + "\n");
		}
		writer.close();
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {

		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withName(generateRandomString())
					.withEmail(generateRandomMail())
					.withHomePhone(generatePhoneNumberNumber())
					.withAddress(generateRandomString())
					.withAddress2(generateRandomString())
					.withBday(generateRandomBDay())
					.withBmonth(generateRandomMonth())
					.withByear(generateRandomYear())
					.withEmail2(generateRandomMail())
					.withMobilePhone(generateMobilePhoneNumberNumber())
					.withNewGroup(generateRandomString())
					.withPhone2(generateMobilePhoneNumberNumber())
					.withWorkPhone(generatePhoneNumberNumber());
			list.add(contact);
		}

		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();

		return "test" + rnd.nextInt(60);

	}

	private static String generateRandomBDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return "" + (1 + rnd.nextInt(30));
		}
	}

	public static String generateMobilePhoneNumberNumber() {
		Random rnd = new Random();
		Integer res = 980000000;
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			res += rnd.nextInt(999999);
		}
		return "0" + res.toString();
	}

	public static String generatePhoneNumberNumber() {
		Random rnd = new Random();
		Integer res = 71900000;
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			res += rnd.nextInt(99999);
		}
		return res.toString();
	}

	public String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "" + rnd.nextInt(2015);
		}
	}

	public static String generateRandomMail() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt(2015) + "@uklr.net";
		}
	}

	public static String generateRandomYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			Integer res = 1950 + rnd.nextInt(65);

			return res.toString();
		}
	}

	public static String generateRandomMonth() {
		Random rnd = new Random();
		int month;

		month = 1 + rnd.nextInt(12);

		String res = "";
		switch (month) {
		case 1:
			res = "January";
			break;
		case 2:
			res = "February";
			break;
		case 3:
			res = "March";
			break;
		case 4:
			res = "April";
			break;
		case 5:
			res = "May";
			break;
		case 6:
			res = "June";
			break;
		case 7:
			res = "July";
			break;
		case 8:
			res = "August";
			break;
		case 9:
			res = "September";
			break;
		case 10:
			res = "October";
			break;
		case 11:
			res = "November";
			break;
		case 12:
			res = "December";
			break;

		default:
			break;
		}

		return res;
	}

}
