package com.interservice.Consumer.restTemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
@RequiredArgsConstructor
public class RestTemplateController {

    private final ProviderRestTemplateClient providerRestTemplateClient;
    @GetMapping("/instance")
    public String getInstance()
    {
      return providerRestTemplateClient.getInstanceInfo();
    }
}
