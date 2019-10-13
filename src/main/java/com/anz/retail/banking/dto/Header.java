package com.anz.retail.banking.dto;

import io.swagger.annotations.ApiModelProperty;

public class Header {
	
	@ApiModelProperty(notes = "Column Header Name - should match with data property")
	private String name;
	@ApiModelProperty(notes = "Column Header Display Name")
	private String description;
	@ApiModelProperty(notes = "Column Header Display Order/Position on Screen")
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
