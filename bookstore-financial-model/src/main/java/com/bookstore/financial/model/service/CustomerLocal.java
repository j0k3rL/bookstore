package com.bookstore.financial.model.service;

import javax.ejb.Local;

import com.bookstore.financial.model.entity.Customer;
import com.bookstore.libraries.exception.BusinessException;

@Local
public interface CustomerLocal {

	Customer findByCPF(String cpf) throws BusinessException;
	
	void insert(Customer customer) throws BusinessException;
}