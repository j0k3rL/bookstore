package com.bookstore.financial.ws.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.bookstore.financial.core.service.PaymentService;
import com.bookstore.financial.ws.dto.PaymentDTO;

@WebService(targetNamespace = "http://bookstore-financial.com/paymentws/v1")
public class PaymentWS {

	@Inject
	private PaymentService paymentService;

	@WebMethod(operationName = "RegisterPayment")
	public void doRegister(@WebParam(name = "Payment")PaymentDTO payment) {
		
	}
}