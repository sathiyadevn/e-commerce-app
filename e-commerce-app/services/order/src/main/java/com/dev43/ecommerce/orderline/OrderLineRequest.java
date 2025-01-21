package com.dev43.ecommerce.orderline;

import jakarta.validation.constraints.NotNull;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        @NotNull(message = "product is mandatory")
        Integer productId,
        @NotNull(message = "Quantity is mandatory")
        double quantity
) {

}
