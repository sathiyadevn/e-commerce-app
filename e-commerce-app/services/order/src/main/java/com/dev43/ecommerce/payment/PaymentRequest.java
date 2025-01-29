package com.dev43.ecommerce.payment;

import com.dev43.ecommerce.customer.CustomerResponse;
import com.dev43.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
