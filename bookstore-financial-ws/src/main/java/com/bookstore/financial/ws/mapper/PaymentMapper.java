package com.bookstore.financial.ws.mapper;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;

import com.bookstore.financial.model.entity.Customer;
import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.financial.model.entity.Unit;
import com.bookstore.financial.ws.dto.PaymentDTO;
import com.bookstore.libraries.util.CollectionUtils;
import com.bookstore.libraries.util.StringUtils;
import com.bookstore.libraries.ws.ObjectMapper;

@Dependent
public class PaymentMapper implements ObjectMapper<Payment, PaymentDTO> {

	@Override
	public Payment toEntity(PaymentDTO paymentDTO) {
		
		if(paymentDTO == null) {
			return null;
		}
		
		Payment payment = new Payment();
		
		payment.setType(paymentDTO.getType());
		payment.setValue(paymentDTO.getValue());
		payment.setDate(paymentDTO.getDate());
		
		if(CollectionUtils.isNotEmpty(paymentDTO.getProductCodes())) {
			
			payment.setProducts(new ArrayList<>());
			
			for(String code : paymentDTO.getProductCodes()) {
				
				Product product = new Product();
				product.setCode(code);
				
				payment.getProducts().add(product);
			}
		}
		
		if(StringUtils.isNotEmpty(paymentDTO.getUnitCode())) {
			
			Unit unit = new Unit();
			unit.setCode(paymentDTO.getUnitCode());
			
			payment.setUnit(unit);
		}
		
		if(paymentDTO.getCustomer() != null) {
			
			Customer customer = new Customer();
			
			customer.setCpf(paymentDTO.getCustomer().getCpf());
			customer.setEmail(paymentDTO.getCustomer().getEmail());
			customer.setName(paymentDTO.getCustomer().getName());

			payment.setCustomer(customer);
		}
		
		return payment;
	}

	@Override
	public PaymentDTO toDTO(Payment entity) { //TODO
		return null;
	}
}