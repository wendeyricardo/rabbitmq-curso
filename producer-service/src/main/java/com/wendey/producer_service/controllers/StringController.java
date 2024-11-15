package com.wendey.producer_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wendey.producer_service.services.StringService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produces")
public class StringController {
    
    private final StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message){
        service.produce(message);
        return ResponseEntity.ok().body("Sending message");
    }
}
