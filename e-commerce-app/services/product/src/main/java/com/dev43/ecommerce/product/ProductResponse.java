package com.dev43.ecommerce.product;

import java.math.BigDecimal;

public record ProductResponse(

        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,

        Integer categoryIid,
        String categoryName,
        String categoryDescription

) {
}
