package com.bookstore.financial.core.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.PaymentDAO;
import com.bookstore.financial.core.entity.Payment;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;

@Stateless
public class PaymentService extends AbstractService {

	@Inject
	private PaymentDAO paymentDAO;
	
	@Inject
	private CustomerService customerService;
	
	public void register(Payment payment) throws BusinessException {
		
		try {
		
			customerService.register(payment.getCustomer());
			
			paymentDAO.insert(payment);
		
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}
}