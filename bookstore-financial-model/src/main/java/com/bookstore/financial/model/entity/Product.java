package com.bookstore.financial.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

import com.bookstore.libraries.jpa.AbstractEntity;
import com.bookstore.libraries.validation.annotation.ProductCode;

@Entity
@NamedQuery(name = Product.NQ_FIND_BY_CODE, query = "SELECT p FROM Product u WHERE p.code = :code")
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 752734198576111568L;

	public static final String NQ_FIND_BY_CODE = "Product.findByCode";
	public static final String CODE_PROPERTY = "code";
	
	@NotBlank @ProductCode
	@Basic(optional = false)
	@Column(length = 9, nullable = false, unique = true)
	private String code;
	
	@NotBlank
	@Basic(optional = false)
	@Column(length = 25, nullable = false)
	private String name;
	
	@NotBlank @Lob
	@Basic(optional = false)
	@Column(nullable = false)
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
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", id=" + id + "]";
	}
}