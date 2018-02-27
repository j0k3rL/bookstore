package com.bookstore.financial.core.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.PaymentDAO;
import com.bookstore.financial.core.entity.Payment;
import com.bookstore.libraries.ejb.AbstractService;

@Stateless
public class PaymentService extends AbstractService {

	@Inject
	private PaymentDAO paymentDAO;
	
	public void register(Payment payment) {
		
	}
}