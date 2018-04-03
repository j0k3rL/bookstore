package com.bookstore.financial.ws.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bookstore.libraries.ws.AbstractTO;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductTO extends AbstractTO {

	private static final long serialVersionUID = -5658046834915492391L;

	@XmlElement(required=true)
	private String code;
	
	@XmlElement(required=true)
	private Integer quantity;
	
	@XmlElement(required=true)
	private BigDecimal value;

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
	 * @return the code
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "ProductTO [code=" + code + ", quantity=" + quantity + ", value=" + value + "]";
	}
}