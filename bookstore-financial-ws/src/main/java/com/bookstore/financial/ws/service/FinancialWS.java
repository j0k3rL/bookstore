package com.bookstore.financial.ws.service;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class FinancialWS {

	@WebMethod
	public void testeWS() {
		System.out.println("Acessing endpoint...");
	}
}