package com.bookstore.financial.ws.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bookstore.financial.core.enumeration.PaymentType;
import com.bookstore.libraries.adapter.DateAdapter;
import com.bookstore.libraries.ejb.AbstractDTO;

@XmlRootElement(name="payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDTO extends AbstractDTO {

	private static final long serialVersionUID = 1507769627499703143L;

	@XmlElement(required=true)
	private PaymentType type;

	@XmlElement(required=true)
	private BigDecimal value;
	
	@XmlElement(required=false)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Calendar date;
	
	@XmlElement(required=true)
	private List<String> products;
	
	@XmlElement(required=true)
	private String unitCode;
	
	@XmlElement(required=true)
	private CustomerDTO customer;

	/**
	 * @return the type
	 */
	public PaymentType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PaymentType type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return the products
	 */
	public List<String> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<String> products) {
		this.products = products;
	}

	/**
	 * @return the unitCode
	 */
	public String getUnitCode() {
		return unitCode;
	}

	/**
	 * @param unitCode the unitCode to set
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * @return the customer
	 */
	public CustomerDTO getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentDTO [type=" + type + ", value=" + value + ", date=" + date + ", products=" + products
				+ ", unitCode=" + unitCode + ", customer=" + customer + "]";
	}
}