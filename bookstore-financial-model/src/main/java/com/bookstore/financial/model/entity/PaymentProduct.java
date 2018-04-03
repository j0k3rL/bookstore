package com.bookstore.financial.model.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.bookstore.libraries.jpa.AbstractEntity;

@Entity
public class PaymentProduct extends AbstractEntity {

	private static final long serialVersionUID = -1735988308583891005L;

	@NotBlank
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer quantity;
	
	@NotNull @Min(value = 0)
	@Basic(optional = false)
	@Column(nullable = false, precision = 2)
	private BigDecimal value;
	
	@NotNull @Valid
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id")
	private Payment payment;

	@NotNull @Valid
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
	private Product product;

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment
	 *            the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PaymentProduct [quantity=" + quantity + ", value=" + value + ", payment=" + payment + ", product="
				+ product + ", id=" + id + "]";
	}
}