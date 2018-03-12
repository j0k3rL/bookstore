package com.bookstore.financial.model.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.model.dao.PaymentDAO;
import com.bookstore.financial.model.entity.Customer;
import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.financial.model.entity.Unit;
import com.bookstore.financial.model.service.CustomerLocal;
import com.bookstore.financial.model.service.PaymentLocal;
import com.bookstore.financial.model.service.ProductLocal;
import com.bookstore.financial.model.service.UnitLocal;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.EntityNotFoundException;

@Stateless
public class PaymentService extends AbstractService implements PaymentLocal {

	private PaymentDAO paymentDAO;
	
	private CustomerLocal customerService;
	
	private UnitLocal unitService;
	
	private ProductLocal productService;

	@Inject
	public PaymentService(PaymentDAO paymentDAO, CustomerLocal customerService, UnitLocal unitService, ProductLocal productService) {
		this.paymentDAO = paymentDAO;
		this.customerService = customerService;
		this.unitService = unitService;
		this.productService = productService;
	}
	
	public void register(Payment payment) throws BusinessException {
		
		try {
			
			loadPaymentCustomer(payment);
		
			loadPaymentUnit(payment);
			
			loadPaymentProducts(payment);
		
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
	
	private void loadPaymentProducts(Payment payment) throws BusinessException {

		for(int i = 0 ; i < payment.getProducts().size() ; i++) {
			
			Product product = payment.getProducts().get(i);
			product = productService.findByCode(product.getCode());
			
			payment.getProducts().set(i, product);
		}
	}
}