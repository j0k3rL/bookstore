package com.bookstore.financial.model.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.model.dao.PaymentDAO;
import com.bookstore.financial.model.entity.Customer;
import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.financial.model.entity.Unit;
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
	
	@Inject
	private ProductService productService;
	
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

		List<Product> products = payment.getProducts();
		
		for(Product p : products) {
			p = productService.findByCode(p.getCode());
		}
		
		payment.setProducts(products);
	}
}