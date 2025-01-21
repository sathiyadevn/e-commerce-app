package com.dev43.ecommerce.order;

import java.math.BigDecimal;

public record OrderResponse(

        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
