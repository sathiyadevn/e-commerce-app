package com.dev43.ecommerce.kafka;

import com.dev43.ecommerce.customer.CustomerResponse;
import com.dev43.ecommerce.order.PaymentMethod;
import com.dev43.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
