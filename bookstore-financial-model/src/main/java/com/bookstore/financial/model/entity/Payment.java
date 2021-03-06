package com.bookstore.financial.model.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.bookstore.financial.model.enumeration.PaymentType;
import com.bookstore.libraries.jpa.AbstractEntity;

@Entity
public class Payment extends AbstractEntity {

	private static final long serialVersionUID = 5057123697187222044L;

	@NotBlank
	@Basic(optional = false)
	@Column(length = 10, nullable = false)
	private String code;

	@NotNull @Valid
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private Customer customer;

	@NotNull @Valid
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private Unit unit;

	@NotNull @Valid
    @OneToMany(mappedBy="payment", fetch = FetchType.LAZY)
	private List<PaymentProduct> paymentProducts;

	@NotNull
	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar date;

	@NotNull @Min(value = 0)
	@Basic(optional = false)
	@Column(nullable = false, precision = 2)
	private BigDecimal value;

	@NotNull
	@Basic(optional = false)
	@Column(nullable = false, length = 6)
	@Enumerated(EnumType.STRING)
	private PaymentType type;

	@NotNull @Valid
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
	private Invoice invoice;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the paymentProducts
	 */
	public List<PaymentProduct> getPaymentProducts() {
		return paymentProducts;
	}

	/**
	 * @param paymentProducts
	 *            the paymentProducts to set
	 */
	public void setPaymentProducts(List<PaymentProduct> paymentProducts) {
		this.paymentProducts = paymentProducts;
	}
	
	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
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

	/**
	 * @return the type
	 */
	public PaymentType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(PaymentType type) {
		this.type = type;
	}

	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice
	 *            the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Payment [code=" + code + ", customer=" + customer + ", unit=" + unit + ", paymentProducts="
				+ paymentProducts + ", date=" + date + ", value=" + value + ", type=" + type + ", invoice=" + invoice
				+ ", id=" + id + "]";
	}
}