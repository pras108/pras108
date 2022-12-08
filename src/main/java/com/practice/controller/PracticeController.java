package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/practice")
public class PracticeController {
    @GetMapping("/id")
    public ResponseEntity<String>getDetails(@RequestParam("id") int id) {
        String response = "Welcome to Controller with id: %s";
        System.out.printf((response) + "%n", id);
        return new ResponseEntity<>(String.format(response, id), HttpStatus.OK);
    }
}
