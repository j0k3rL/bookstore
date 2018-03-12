package com.bookstore.financial.model.service;

import javax.ejb.Local;

import com.bookstore.financial.model.entity.Product;
import com.bookstore.libraries.exception.BusinessException;

@Local
public interface ProductLocal {

	Product findByCode(String code) throws BusinessException;
}