package com.bookstore.financial.model.service.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.bookstore.financial.model.dao.UnitDAO;
import com.bookstore.financial.model.entity.Unit;
import com.bookstore.financial.model.service.UnitLocal;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.EntityNotFoundException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;

@Stateless
public class UnitService extends AbstractService implements UnitLocal {

	private UnitDAO unitDAO;
	
	@Inject
	public UnitService(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}
	
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