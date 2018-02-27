package com.bookstore.financial.core.dao;

import javax.persistence.Query;

import com.bookstore.financial.core.entity.Customer;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.jpa.AbstractDAO;

public class CustomerDAO extends AbstractDAO<Customer> {

	public Customer findyByCPF(String cpf) throws DAOException {
		
		try {
			
			Query query = createNamedQuery(Customer.NQ_FIND_BY_CPF, Customer.class);
			return getSingleResult(query);
			
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
}