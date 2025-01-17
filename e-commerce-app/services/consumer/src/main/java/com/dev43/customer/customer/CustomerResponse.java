package com.dev43.customer.customer;

public record CustomerResponse(

        String id,

        String firstName,

        String lastName,

        String email,

        Address address         // validating by @Validated in Address class

            ){
}
