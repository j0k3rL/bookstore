package com.bookstore.financial.model.report;

import java.math.BigDecimal;

import com.bookstore.financial.model.entity.PaymentProduct;

public class PaymentReport {

	private PaymentProduct paymentProduct;
	
	public PaymentReport(PaymentProduct paymentProduct) {
		this.paymentProduct = paymentProduct;
	}
	
	public String getCode() {
		return paymentProduct.getProduct().getCode();
	}
	
	public String getName() {
		return paymentProduct.getProduct().getName();
	}
	
	public Integer getQuantity() {
		return paymentProduct.getQuantity();
	}
	
	public BigDecimal getValue() {
		return paymentProduct.getValue();
	}
}