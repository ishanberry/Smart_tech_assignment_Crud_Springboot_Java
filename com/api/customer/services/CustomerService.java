package com.api.customer.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.customer.models.Customer;

@Service
public class CustomerService {

    @Value("${sunbase.api.url}")
    private String SUNBASE_API_URL;

    public List<Customer> getCustomerList(String bearerToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                SUNBASE_API_URL + "/get_customer_list",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<Customer>>() {}
        );

        return responseEntity.getBody();
    }

    public ResponseEntity<String> createCustomer(String bearerToken, Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);
        return restTemplate.postForEntity(SUNBASE_API_URL + "/create", requestEntity, String.class);
    }

    public ResponseEntity<String> updateCustomer(String bearerToken, Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);
        return restTemplate.exchange(SUNBASE_API_URL + "/update", HttpMethod.POST, requestEntity, String.class);
    }

    public ResponseEntity<String> deleteCustomer(String bearerToken, String customerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(SUNBASE_API_URL + "/delete/" + customerId, HttpMethod.DELETE, requestEntity, String.class);
    }
}
