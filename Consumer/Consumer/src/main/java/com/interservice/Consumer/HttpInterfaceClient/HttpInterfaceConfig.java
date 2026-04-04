package com.interservice.Consumer.HttpInterfaceClient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class HttpInterfaceConfig {
// There is already a bean of Webclient.Builder in WebClient folder so we commented this otherwise there will
//    be two bean of same type and Spring will be confused which one to inject.
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder webClietnBuilder(){
//        return WebClient.builder();
//    }

//    @Bean
//    public ProviderHttpInterface webClientHttpInterface(WebClient.Builder webClientBuilder){
//       // WebClient webClient = WebClient
//         WebClient webClient= webClientBuilder.baseUrl("http://provider").build();
//        WebClientAdapter webClientAdapter = WebClientAdapter.create(webClient);
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(webClientAdapter).build();
//        ProviderHttpInterface  service = factory.createClient(ProviderHttpInterface.class);
//        return service;
//    }

    // There is already a bean of Webclient.Builder in WebClient folder so we commented this otherwise there will
//    be two bean of same type and Spring will be confused which one to inject.
//    @Bean
//    @LoadBalanced
//    public RestClient.Builder restClientBuilder(){
//        return RestClient.builder();
//    }
//    @Bean
//    public ProviderHttpInterface restClientHttpInterface(RestClient.Builder restClientBuilder){
//
//        RestClient restClient = restClientBuilder.baseUrl("http://provider").build();
//        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
//        ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
//        return service;
//    }


//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
    @Bean
    public ProviderHttpInterface restTemplateHttpInterface(RestTemplate restTemplate){

        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://provider"));
        RestTemplateAdapter restTemplateAdapter = RestTemplateAdapter.create(restTemplate);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restTemplateAdapter).build();
        ProviderHttpInterface service = factory.createClient(ProviderHttpInterface.class);
        return service;
    }


}
