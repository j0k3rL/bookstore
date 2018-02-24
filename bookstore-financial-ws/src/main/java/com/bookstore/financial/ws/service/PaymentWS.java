package com.bookstore.financial.ws.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.bookstore.financial.core.service.PaymentService;
import com.bookstore.financial.ws.dto.PaymentDTO;
import com.bookstore.libraries.exception.WebServiceException;
import com.bookstore.libraries.ws.AbstractWS;

@WebService(targetNamespace = "http://bookstore-financial.com/paymentws/v1")
public class PaymentWS extends AbstractWS {

	private static final String SCHEMA_PATH = "xsd/bookstore-financial-ws.xsd";

	@Inject
	private PaymentService paymentService;

	@WebMethod(operationName = "RegisterPayment")
	public void doRegister(@WebParam(name = "Payment") PaymentDTO payment) throws WebServiceException {

		try {

			validate(SCHEMA_PATH, payment);

			//TODO
			
		} catch (Exception e) {
			throw new WebServiceException(e);
		}
	}
}