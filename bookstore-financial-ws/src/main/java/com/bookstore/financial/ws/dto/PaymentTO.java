package com.bookstore.financial.ws.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bookstore.financial.model.enumeration.PaymentType;
import com.bookstore.libraries.adapter.DateTimeAdapter;
import com.bookstore.libraries.validation.annotation.UnitCode;
import com.bookstore.libraries.ws.AbstractTO;

@XmlRootElement(name="payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentTO extends AbstractTO {

	private static final long serialVersionUID = 1507769627499703143L;

	@XmlElement(required=true)
	private PaymentType type;

	@XmlElement(required=true)
	private BigDecimal value;
	
	@XmlElement(required=false)
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private Calendar date;
	
	@XmlElement(required=true)
	private List<ProductTO> products;
	
	@UnitCode
	@XmlElement(required=true)
	private String unitCode;
	
	@Valid
	@XmlElement(required=true)
	private CustomerTO customer;

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
	public CustomerTO getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

	/**
	 * @return the products
	 */
	public List<ProductTO> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "PaymentTO [type=" + type + ", value=" + value + ", date=" + date + ", products=" + products
				+ ", unitCode=" + unitCode + ", customer=" + customer + "]";
	}
}