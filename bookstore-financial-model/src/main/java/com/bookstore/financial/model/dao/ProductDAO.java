package com.bookstore.financial.model.dao;

import javax.persistence.Query;

import com.bookstore.financial.model.entity.Product;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.jpa.AbstractDAO;

public class ProductDAO extends AbstractDAO<Product> {
	
	public Product findByCode(String code) throws DAOException {

		try {

			Query query = createNamedQuery(Product.NQ_FIND_BY_CODE, Product.class);
			query.setParameter(Product.CODE_PROPERTY, code);

			return getSingleResult(query);

		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
}