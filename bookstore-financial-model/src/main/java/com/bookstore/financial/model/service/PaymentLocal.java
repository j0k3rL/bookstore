package com.bookstore.financial.model.service;

import javax.ejb.Local;

import com.bookstore.financial.model.entity.Payment;
import com.bookstore.libraries.exception.BusinessException;

@Local
public interface PaymentLocal {

	void register(Payment payment) throws BusinessException;
}