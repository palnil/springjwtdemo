package com.yoshallc.security.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){

        this.customerService = customerService;
    }

    @GetMapping("/home")
    public String home(){

        return "Home";
    }

    @GetMapping("/hello")
    public CustomerResponse hello(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setLastName(customerService.makeUpperCase("patel"));

        return customerResponse;
    }

    @GetMapping("/token")
    public String token(){

        String token = "";

        try {
            Algorithm algorithm = Algorithm.HMAC512("secret");
            token = JWT.create()
                    .withSubject("nilesh")
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }

        return token;

    }
}
