package com.bookstore.financial.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bookstore.libraries.ejb.AbstractDTO;
import com.bookstore.libraries.validation.annotation.CpfValid;
import com.bookstore.libraries.validation.annotation.EmailValid;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDTO extends AbstractDTO  {

	private static final long serialVersionUID = 8440798476852640571L;

	@CpfValid
	@XmlElement(name="CPF", required=true)
	private String cpf;
	
	@XmlElement(name="Name", required=true)
	private String name;
	
	@EmailValid
	@XmlElement(name="E-mail", required=true)
	private String email;

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
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
	 * @param name the name to set
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerDTO [cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}
}