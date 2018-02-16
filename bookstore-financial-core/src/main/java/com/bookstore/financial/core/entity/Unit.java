package com.bookstore.financial.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.bookstore.financial.core.enumeration.UnitType;
import com.bookstore.libraries.jpa.AbstractEntity;

@Entity
@Table
public class Unit extends AbstractEntity {

	private static final long serialVersionUID = -6464957647150213257L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UnitType type;

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
	 * @return the type
	 */
	public UnitType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(UnitType type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Unit [code=" + code + ", name=" + name + ", type=" + type + "]";
	}
}
