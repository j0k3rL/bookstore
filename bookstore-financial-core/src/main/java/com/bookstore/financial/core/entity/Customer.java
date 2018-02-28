package com.bookstore.financial.core.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import com.bookstore.libraries.jpa.AbstractEntity;
import com.bookstore.libraries.validation.annotation.CpfValid;
import com.bookstore.libraries.validation.annotation.EmailValid;

@Entity
@NamedQuery(name = Customer.NQ_FIND_BY_CPF, query = "SELECT c FROM Customer c WHERE c.cpf = :cpf")
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 8546466113547101306L;

	public static final String NQ_FIND_BY_CPF = "Customer.findByCpf";

	@NotNull @CpfValid
	@Basic(optional = false)
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@NotNull
	@Basic(optional = false)
	@Column(length = 25, nullable = false)
	private String name;

	@NotNull @EmailValid
	@Basic(optional = false)
	@Column(length = 25, nullable = false)
	private String email;

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}
}