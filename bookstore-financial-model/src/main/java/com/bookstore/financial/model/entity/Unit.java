package com.bookstore.financial.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.bookstore.financial.model.enumeration.UnitType;
import com.bookstore.libraries.jpa.AbstractEntity;
import com.bookstore.libraries.validation.annotation.UnitCode;

@Entity
@NamedQuery(name = Unit.NQ_FIND_BY_CODE, query = "SELECT u FROM Unit u WHERE u.code = :code")
public class Unit extends AbstractEntity {

	private static final long serialVersionUID = -6464957647150213257L;

	public static final String NQ_FIND_BY_CODE = "Unit.findByCode";
	public static final String CODE_PROPERTY = "code";
	
	@NotBlank @UnitCode
	@Basic(optional = false)
	@Column(length = 9, nullable = false, unique = true)
	private String code;
	
	@NotBlank
	@Basic(optional = false)
	@Column(length = 25, nullable = false)
	private String name;
	
	@NotNull
	@Basic(optional = false)
	@Column(nullable = false)
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
		return "Unit [code=" + code + ", name=" + name + ", type=" + type + ", id=" + id + "]";
	}
}
