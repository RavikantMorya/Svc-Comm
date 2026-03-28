package com.interservice.Consumer.restTemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {

    private final static String  PROVIDER_URL = "http://localhost:8080";
    private final RestTemplate restTemplate;

    public String getInstanceInfo()
    {
        return restTemplate.getForObject(PROVIDER_URL+"/instance-info", String.class);
    }

}
