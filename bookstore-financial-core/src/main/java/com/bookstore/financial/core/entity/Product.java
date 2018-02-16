package com.bookstore.financial.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bookstore.libraries.jpa.AbstractEntity;

@Entity
@Table
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 752734198576111568L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + "]";
	}
}