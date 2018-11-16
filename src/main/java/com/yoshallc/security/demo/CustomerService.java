package com.yoshallc.security.demo;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public String makeUpperCase(String input){

        return input.toUpperCase();
    }
}
