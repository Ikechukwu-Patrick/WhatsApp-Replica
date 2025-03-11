package com.patrick.whatsappclone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/healthCheck")
public class KeycloakHealthCheckController {

    private static final String KEYCLOAK_LIVENESS_URL = "http://localhost:9090/health/live";
    private static final String KEYCLOAK_READINESS_URL = "http://localhost:9090/health/read";

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/keycloak")
    public ResponseEntity<Map<String, String>> checkKeycloakHealth() {
        Map<String, String> healthStatus = new HashMap<>();
        healthStatus.put("keycloak_liveness", checkHealth(KEYCLOAK_LIVENESS_URL));
        healthStatus.put("Keycloak_readiness",checkHealth(KEYCLOAK_READINESS_URL));
        return ResponseEntity.ok(healthStatus);
    }
    private String checkHealth(String url) {
        try{
            restTemplate.getForEntity(url, String.class);
            return "UP";
        }catch (Exception e){
            return "DOWN";
        }
    }

}
