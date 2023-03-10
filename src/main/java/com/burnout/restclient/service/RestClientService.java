package com.burnout.restclient.service;

import com.burnout.restclient.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getUserString(int id) {
        ResponseEntity<String> response = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/users/" + id, String.class);
        return response;
    }

    public ResponseEntity<User[]> getAllUser() {
        ResponseEntity<User[]> response = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/users/", User[].class);
        return response;
    }

    public ResponseEntity<User> getUserObject(int id) {
        User user = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);

        // PROSES OBJECT, BISA SAVE KE DB ATAU YANG LAINNYA
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> postUserObject(User user) {
        User response = restTemplate.postForObject("https://jsonplaceholder.typicode.com/users/", user, User.class);
        // PROSES DATA YANG DIINGINKAN ADA DIBAGIAN SINI, BISA SAVE ATAU PROSES LAINNYA
        return ResponseEntity.ok(response);
    }
}
























