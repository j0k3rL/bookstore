package com.bookstore.financial.ws.mapper;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;

import com.bookstore.financial.model.entity.Customer;
import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.PaymentProduct;
import com.bookstore.financial.model.entity.Product;
import com.bookstore.financial.model.entity.Unit;
import com.bookstore.financial.ws.dto.PaymentTO;
import com.bookstore.financial.ws.dto.ProductTO;
import com.bookstore.libraries.util.CollectionUtils;
import com.bookstore.libraries.util.StringUtils;
import com.bookstore.libraries.ws.ObjectMapper;

@Dependent
public class PaymentMapper implements ObjectMapper<Payment, PaymentTO> {

	@Override
	public Payment toEntity(PaymentTO paymentTO) {
		
		if(paymentTO == null) {
			return null;
		}
		
		Payment payment = new Payment();
		
		payment.setType(paymentTO.getType());
		payment.setValue(paymentTO.getValue());
		payment.setDate(paymentTO.getDate());
		
		if(CollectionUtils.isNotEmpty(paymentTO.getProducts())) {
			
			payment.setPaymentProducts(new ArrayList<>());
			
			for(ProductTO p : paymentTO.getProducts()) {
				
				Product product = new Product();
				product.setCode(p.getCode());
				
				PaymentProduct paymentProduct = new PaymentProduct();
				paymentProduct.setQuantity(p.getQuantity());
				paymentProduct.setValue(p.getValue());
				paymentProduct.setProduct(product);
				
				payment.getPaymentProducts().add(paymentProduct);
			}
		}
		
		if(StringUtils.isNotEmpty(paymentTO.getUnitCode())) {
			
			Unit unit = new Unit();
			unit.setCode(paymentTO.getUnitCode());
			
			payment.setUnit(unit);
		}
		
		if(paymentTO.getCustomer() != null) {
			
			Customer customer = new Customer();
			
			customer.setCpf(paymentTO.getCustomer().getCpf());
			customer.setEmail(paymentTO.getCustomer().getEmail());
			customer.setName(paymentTO.getCustomer().getName());

			payment.setCustomer(customer);
		}
		
		return payment;
	}

	@Override
	public PaymentTO toDTO(Payment entity) { //TODO
		return null;
	}
}