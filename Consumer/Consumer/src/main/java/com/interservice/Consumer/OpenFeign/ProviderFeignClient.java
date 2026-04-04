package com.interservice.Consumer.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "provider-service", url = "http://localhost:8080")
@FeignClient(name = "provider")
public interface ProviderFeignClient {

    @GetMapping("/instance-info")
    String getInstanceInfo();
}
