package com.bookstore.financial.core.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.PaymentDAO;
import com.bookstore.financial.core.entity.Customer;
import com.bookstore.financial.core.entity.Payment;
import com.bookstore.financial.core.entity.Unit;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.EntityNotFoundException;

@Stateless
public class PaymentService extends AbstractService {

	@Inject
	private PaymentDAO paymentDAO;
	
	@Inject
	private CustomerService customerService;
	@Inject
	private UnitService unitService;
	
	public void register(Payment payment) throws BusinessException {
		
		try {
			
			loadPaymentCustomer(payment);
		
			loadPaymentUnit(payment);
		
			//TODO: Continue...
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	
	private void loadPaymentCustomer(Payment payment) throws BusinessException {
		
		Customer customer = payment.getCustomer();
		boolean isRegistered = true;

		try {
			customer = customerService.findByCPF(customer.getCpf());
		} catch (EntityNotFoundException e) {
			isRegistered = false;
		}
	
		if(!isRegistered)
			customerService.insert(customer);
		
		payment.setCustomer(customer);
	}
	
	private void loadPaymentUnit(Payment payment) throws BusinessException {
		
		Unit unit = payment.getUnit();
		unit = unitService.findByCode(unit.getCode());
		
		payment.setUnit(unit);
	}
}