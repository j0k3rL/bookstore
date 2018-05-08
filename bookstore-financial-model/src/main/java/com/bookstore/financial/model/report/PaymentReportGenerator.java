package com.bookstore.financial.model.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.financial.model.entity.Payment;
import com.bookstore.financial.model.entity.PaymentProduct;
import com.bookstore.libraries.exception.ReportException;
import com.bookstore.libraries.report.ReportGenerator;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PaymentReportGenerator {

	private static final String JASPER_PATH = "report/invoice.jasper";

	private static final String CUSTOMER_NAME_PARAMETER = "CUSTOMER_NAME";
	
	private static final String CUSTOMER_CPF_PARAMETER = "CUSTOMER_CPF";
	
	private static final String CUSTOMER_MAIL_PARAMETER = "CUSTOMER_MAIL";

	public void generatePDF(Payment payment, OutputStream out) throws ReportException {

		JRDataSource datasouce = getDatasouce(payment);
		Map<String, Object> parameters = getParameters(payment);

		ReportGenerator.generatePDF(JASPER_PATH, parameters, datasouce, out);
	}

	private JRDataSource getDatasouce(Payment payment) {

		List<PaymentReport> paymentProductReports = new ArrayList<>();

		for (PaymentProduct pp : payment.getPaymentProducts()) {
			paymentProductReports.add(new PaymentReport(pp));
		}

		return new JRBeanCollectionDataSource(paymentProductReports);
	}

	private Map<String, Object> getParameters(Payment payment) {

		Map<String, Object> parameters = new HashMap<>();

		parameters.put(CUSTOMER_NAME_PARAMETER, payment.getCustomer().getName());
		parameters.put(CUSTOMER_CPF_PARAMETER, payment.getCustomer().getCpf());
		parameters.put(CUSTOMER_MAIL_PARAMETER, payment.getCustomer().getEmail());

		return parameters;
	}
}