package com.dev43.ecommerce.customer;

import com.dev43.ecommerce.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(@Valid CustomerRequest request) {

        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided id:: %s", request.id())
                ));
        mergeCustomer(customer, request);       //
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {
        if (StringUtils.isBlank(request.firstName())) {         // record - No need to use of request.getFirstName();
            customer.setFirstName(request.firstName());         //
        }
        if (StringUtils.isBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomer() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)      // convert Customer Object to CustomerResponse Object
                .collect(Collectors.toList());  // can use .toList() - Java 16
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(()-> new CustomerNotFoundException(String.format("No customer found with the provided ID:: %s",customerId)));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
