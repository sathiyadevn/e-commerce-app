package com.dev43.product.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
    ){
        }
