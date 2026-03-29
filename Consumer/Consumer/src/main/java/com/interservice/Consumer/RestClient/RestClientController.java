package com.interservice.Consumer.RestClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-client")
@RequiredArgsConstructor
public class RestClientController {

    private final ProviderRestClient providerRestClient;
    @GetMapping("/instance")
    public String getInstance()
    {
//        RestClient restClient = RestClient.create();
//       return restClient.get()
//                .uri("http://localhost:8080/instance-info")
//                .retrieve()
//                .body(String.class);

        return providerRestClient.getInstanceInfo();
    }

}
