package com.bookstore.financial.core.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.bookstore.financial.core.dao.UnitDAO;
import com.bookstore.financial.core.entity.Unit;
import com.bookstore.libraries.ejb.AbstractService;
import com.bookstore.libraries.exception.BusinessException;
import com.bookstore.libraries.exception.DAOException;

@Stateless
public class UnitService extends AbstractService {

	@Inject
	private UnitDAO unitDAO;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Unit> listAll() throws BusinessException {
		
		try {
			
			return (List<Unit>) unitDAO.listAll();
		
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}
}