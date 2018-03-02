package com.bookstore.financial.core.service;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.UnitDAO;
import com.bookstore.financial.core.entity.Unit;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.EntityNotFoundException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;

public class UnitService extends AbstractService {

	@Inject
	private UnitDAO unitDAO;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Unit findByCode(String code) throws BusinessException {

		try {
			return unitDAO.findByCode(code);
		} catch (ObjectNotFoundDAOException e) {
			throw new EntityNotFoundException(e);
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}
}