package com.bookstore.financial.model.service;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.bookstore.financial.model.dao.ProductDAO;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.EntityNotFoundException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;

public class ProductService extends AbstractService {

	@Inject
	private ProductDAO productDAO;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Product findByCode(String code) throws BusinessException {

		try {
			return productDAO.findByCode(code);
		} catch (ObjectNotFoundDAOException e) {
			throw new EntityNotFoundException(e);
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}
}