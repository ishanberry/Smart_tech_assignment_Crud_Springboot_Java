package com.api.customer.apiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.customer.models.Customer;
import com.api.customer.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/sunbase/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomerList(@RequestHeader("Authorization") String bearerToken) {
        try {
            List<Customer> customers = customerService.getCustomerList(bearerToken);
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Adjust the error handling as needed
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestHeader("Authorization") String bearerToken,
                                                @RequestBody Customer customer) {
        try {
            ResponseEntity<String> response = customerService.createCustomer(bearerToken, customer);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Adjust the error handling as needed
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestHeader("Authorization") String bearerToken,
                                                @RequestBody Customer customer) {
        try {
            ResponseEntity<String> response = customerService.updateCustomer(bearerToken, customer);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Adjust the error handling as needed
        }
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@RequestHeader("Authorization") String bearerToken,
                                                @PathVariable String customerId) {
        try {
            ResponseEntity<String> response = customerService.deleteCustomer(bearerToken, customerId);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Adjust the error handling as needed
        }
    }
}
