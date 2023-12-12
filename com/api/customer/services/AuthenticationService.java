package com.api.customer.services;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.customer.models.LoginRequest;

@Service
public class AuthenticationService {

    private final String AUTH_API_URL = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

    public String authenticate(LoginRequest loginRequest) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(AUTH_API_URL, loginRequest, String.class);
        HttpHeaders headers = response.getHeaders();
        return headers.getFirst("Authorization");
    }
}
