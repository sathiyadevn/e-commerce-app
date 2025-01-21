package com.dev43.ecommerce.product;

import jakarta.validation.constraints.NotNull;

public record PurchaseRequest(

        @NotNull(message = "product is mandatory")
        Integer productId,
        @NotNull(message = "Quantity is mandatory")
        double quantity

) {
}
