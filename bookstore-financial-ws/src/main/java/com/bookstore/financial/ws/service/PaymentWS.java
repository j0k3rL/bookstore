package com.bookstore.financial.ws.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.service.PaymentService;
import com.bookstore.financial.ws.dto.PaymentTO;
import com.bookstore.libraries.exception.WebServiceException;
import com.bookstore.libraries.ws.AbstractWS;
import com.bookstore.libraries.ws.ObjectMapper;

@WebService(targetNamespace = "http://bookstore-financial.com/paymentws/v1")
public class PaymentWS extends AbstractWS {

	private static final String SCHEMA_PATH = "xsd/bookstore-financial-ws.xsd";
	
	@Inject
	private PaymentService paymentService;
	
	@Inject
	private ObjectMapper<Payment, PaymentTO> paymentMapper;

	@WebMethod(operationName = "registerPayment")
	public void doRegister(@WebParam(name = "payment") PaymentTO paymentTO) throws WebServiceException {
		
		try {

			validateRequest(SCHEMA_PATH, paymentTO);
			
			Payment payment = paymentMapper.toEntity(paymentTO);
			paymentService.register(payment);
			
		} catch (Exception e) {
			throw new WebServiceException(e);
		}
	}
}