package com.bookstore.financial.ws.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bookstore.financial.core.enumeration.PaymentType;
import com.bookstore.libraries.adapter.DateTimeAdapter;
import com.bookstore.libraries.ejb.AbstractDTO;
import com.bookstore.libraries.validation.annotation.ProductCodeValid;
import com.bookstore.libraries.validation.annotation.UnitCodeValid;

@XmlRootElement(name="payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDTO extends AbstractDTO {

	private static final long serialVersionUID = 1507769627499703143L;

	@XmlElement(name="Type", required=true)
	private PaymentType type;

	@XmlElement(name="Value", required=true)
	private BigDecimal value;
	
	@XmlElement(name="Date", required=false)
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private Calendar date;
	
	@ProductCodeValid
	@XmlElementWrapper(name = "Products", required=true)
	@XmlElement(name="Code", required=true)
	private List<String> productCodes;
	
	@UnitCodeValid
	@XmlElement(name="UnitCode", required=true)
	private String unitCode;
	
	@XmlElement(name="Customer", required=true)
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
	 * @return the productCodes
	 */
	public List<String> getProductCodes() {
		return productCodes;
	}

	/**
	 * @param products the products to set
	 */
	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
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
		return "PaymentDTO [type=" + type + ", value=" + value + ", date=" + date + ", productCodes=" + productCodes
				+ ", unitCode=" + unitCode + ", customer=" + customer + "]";
	}
}