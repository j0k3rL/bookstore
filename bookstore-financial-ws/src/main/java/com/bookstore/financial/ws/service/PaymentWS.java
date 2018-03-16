package com.bookstore.financial.ws.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.service.PaymentLocal;
import com.bookstore.financial.ws.dto.PaymentDTO;
import com.bookstore.libraries.exception.WebServiceException;
import com.bookstore.libraries.ws.AbstractWS;
import com.bookstore.libraries.ws.ObjectMapper;

@WebService(targetNamespace = "http://bookstore-financial.com/paymentws/v1")
public class PaymentWS extends AbstractWS {

	private static final String SCHEMA_PATH = "xsd/bookstore-financial-ws.xsd";

	@Inject
	private PaymentLocal paymentService;
	
	@Inject
	private ObjectMapper<Payment, PaymentDTO> paymentMapper;

	@WebMethod(operationName = "registerPayment")
	public void doRegister(@WebParam(name = "payment") PaymentDTO paymentDTO) throws WebServiceException {
		
		try {

			validateContract(SCHEMA_PATH, paymentDTO);
			
			Payment payment = paymentMapper.toEntity(paymentDTO);
			paymentService.register(payment);
			
		} catch (Exception e) {
			throw new WebServiceException(e);
		}
	}
}