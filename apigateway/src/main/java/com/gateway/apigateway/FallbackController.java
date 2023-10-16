package com.gateway.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/profileServiceFallback")
    public String profileServiceFallback() {
        return "Profile Service Is Down At This Time";
    }

    @GetMapping("/productServiceFallback")
    public String productServiceFallback() {
        return "Product Service Is Down At This Time";
    }

    @GetMapping("/cartServiceFallback")
    public String cartServiceFallback() {
        return "Cart Service Is Down At This Time";
    }

    @GetMapping("/orderServiceFallback")
    public String orderServiceFallback() {
        return "Order Service Is Down At This Time";
    }

    @GetMapping("/jwtauthServiceFallback")
    public String jwtauthServiceFallback() {
        return "Security Service Is Down At This Time";
    }

}
