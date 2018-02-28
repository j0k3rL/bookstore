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
import com.bookstore.libraries.exception.EntityNotFoundException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;
import com.bookstore.libraries.exception.RollbackBusinessException;

@Stateless
public class CustomerService extends AbstractService {

	@Inject
	private CustomerDAO customerDAO;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Customer findByCPF(String cpf) throws BusinessException {

		try {

			return customerDAO.findByCPF(cpf);

		} catch (ObjectNotFoundDAOException e) {
			throw new EntityNotFoundException(e);
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}
	
	public void insert(Customer customer) throws BusinessException {

		try {

			customerDAO.insert(customer);

		} catch (DAOException e) {
			throw new RollbackBusinessException(e);
		}
	}
	
	public void register(Customer customer) throws BusinessException {
		
		boolean isRegistered = true;
		
		try {
			customer = findByCPF(customer.getCpf());
		} catch (EntityNotFoundException e) {
			isRegistered = false;
		}
		
		if(!isRegistered) {
			insert(customer);
		}
	}
}