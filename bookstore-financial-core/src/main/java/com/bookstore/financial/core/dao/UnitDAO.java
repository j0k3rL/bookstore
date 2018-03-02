package com.bookstore.financial.core.dao;

import javax.persistence.Query;

import com.bookstore.financial.core.entity.Unit;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.jpa.AbstractDAO;

public class UnitDAO extends AbstractDAO<Unit> {
	
	public Unit findByCode(String code) throws DAOException {

		try {

			Query query = createNamedQuery(Unit.NQ_FIND_BY_CODE, Unit.class);
			query.setParameter(Unit.CODE_PROPERTY, code);

			return getSingleResult(query);

		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
}