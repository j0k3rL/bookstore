package com.bookstore.financial.model.service;

import javax.ejb.Local;

import com.bookstore.financial.model.entity.Unit;
import com.bookstore.libraries.exception.BusinessException;

@Local
public interface UnitService {

	Unit findByCode(String code) throws BusinessException;
}