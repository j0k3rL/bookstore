package com.bookstore.financial.core.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.CustomerDAO;
import com.bookstore.financial.core.entity.Customer;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.RollbackBusinessException;

@Stateless
public class CustomerService extends AbstractService {

	@Inject
	private CustomerDAO customerDAO;
	
	public void insert(Customer customer) throws BusinessException {
		
		try {
			customerDAO.insert(customer);
		} catch (DAOException e) {
			throw new RollbackBusinessException(e);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void findByCpf(String cpf) throws BusinessException {

		try {
			customerDAO.findyByCPF(cpf);
		} catch (DAOException e) {
			throw new BusinessException();
		}
	}
}