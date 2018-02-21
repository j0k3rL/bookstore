package com.bookstore.financial.ws.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.bookstore.financial.core.service.UnitService;
import com.bookstore.libraries.exception.BusinessException;

@WebService
public class PaymentWS {

	@Inject
	private UnitService unitService;
	
	@WebMethod
	public void testService() {
		try {
			unitService.listAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}