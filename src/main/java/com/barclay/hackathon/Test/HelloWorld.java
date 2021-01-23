package com.barclay.hackathon.Test;

import com.barclay.hackathon.services.InstamojoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorld {

    @Autowired
    private InstamojoPaymentService paymentService;

    @GetMapping
    public String createPayment(){
        String uri = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json";
        RestTemplate restTemplate = new RestTemplate();
       return restTemplate.getForObject(uri, String.class);
//        HttpRequest request = HttpRequest.newBuilder(URI.create("https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json"))
//                .header("Content-Type", "application/json")
//                .GET().build();
//        request.
////        this.paymentService.createNewOrder();
    }
}
