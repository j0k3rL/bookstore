package com.bookstore.financial.model.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bookstore.financial.model.dao.PaymentDAO;
import com.bookstore.financial.model.entity.Customer;
import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.financial.model.entity.Unit;
import com.bookstore.financial.model.report.PaymentReportGenerator;
import com.bookstore.financial.model.service.CustomerService;
import com.bookstore.financial.model.service.PaymentService;
import com.bookstore.financial.model.service.ProductService;
import com.bookstore.financial.model.service.UnitService;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.EntityNotFoundException;
import com.bookstore.libraries.exception.RollbackBusinessException;

@Stateless
public class PaymentServiceImpl extends AbstractService implements PaymentService {

	private CustomerService customerService;

	private UnitService unitService;

	private ProductService productService;

	private PaymentDAO paymentDAO;

	private PaymentReportGenerator paymentReportGenerator;

	@Inject
	public PaymentServiceImpl(CustomerService customerService, UnitService unitService, ProductService productService,
			PaymentDAO paymentDAO, PaymentReportGenerator paymentReportGenerator) {
		
		this.customerService = customerService;
		this.unitService = unitService;
		this.productService = productService;
		this.paymentDAO = paymentDAO;
		this.paymentReportGenerator = paymentReportGenerator;
	}

	public void register(Payment payment) throws BusinessException {

		try {

			loadPaymentCustomer(payment);

			loadPaymentUnit(payment);

			loadPaymentProducts(payment);
			
		} catch (Exception e) {
			throw new RollbackBusinessException(e);
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

		if (!isRegistered)
			customerService.insert(customer);

		payment.setCustomer(customer);
	}

	private void loadPaymentUnit(Payment payment) throws BusinessException {

		Unit unit = payment.getUnit();
		unit = unitService.findByCode(unit.getCode());

		payment.setUnit(unit);
	}

	private void loadPaymentProducts(Payment payment) throws BusinessException {

		for (int i = 0; i < payment.getPaymentProducts().size(); i++) {

			Product product = payment.getPaymentProducts().get(i).getProduct();
			product = productService.findByCode(product.getCode());

			payment.getPaymentProducts().get(i).setProduct(product);
		}
	}
}