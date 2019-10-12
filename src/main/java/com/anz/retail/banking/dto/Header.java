package com.anz.retail.banking.dto;

public class Header {
	
	private String name;
	private String description;
	private Integer sortOrder;
	
	public Header() {
		super();
	}

	public Header(String name, String description, Integer sortOrder) {
		super();
		this.name = name;
		this.description = description;
		this.sortOrder = sortOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	

}
