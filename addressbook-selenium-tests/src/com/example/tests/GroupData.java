package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	private String id;
	private String name;
	private String header;
	private String footer;

	public GroupData(String id, String groupName, String header, String footer) {
		this.id = id;
		this.name = groupName;
		this.header = header;
		this.footer = footer;
	}

	public GroupData() {

	}

	@Override
	public String toString() {
		return "GroupData [id=" + getId() + "name=" + getName() + ", header=" + header
				+ ", footer=" + footer + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {

		return this.getName().toLowerCase()
				.compareTo(other.getName().toLowerCase());

	}

	public GroupData withName(String name) {
		this.name = name;
		return this;
	}

	public GroupData withId(String name) {
		this.id = id;
		return this;
	}
	public GroupData withHeader(String header) {
		this.header = header;
		return this;

	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;

	}

	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

}