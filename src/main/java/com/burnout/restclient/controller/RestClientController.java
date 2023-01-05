package com.burnout.restclient.controller;

import com.burnout.restclient.dto.User;
import com.burnout.restclient.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class RestClientController {
    @Autowired
    private RestClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<String> findUserStringById(@PathVariable("id") int id) {
        return service.getUserString(id);
    }

    @GetMapping("/object/{id}")
    public ResponseEntity<User> findUserObjectById(@PathVariable("id") int id) {
        return service.getUserObject(id);
    }

    @GetMapping // ARTINYA PAKAI ENDPOINT UTAMA
    public ResponseEntity<User[]> findAllUserArray() {
        return service.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return service.postUserObject(user);
    }
}