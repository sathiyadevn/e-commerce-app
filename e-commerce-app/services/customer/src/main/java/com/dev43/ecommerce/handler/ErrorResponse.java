package com.dev43.ecommerce.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
    ){
        }
