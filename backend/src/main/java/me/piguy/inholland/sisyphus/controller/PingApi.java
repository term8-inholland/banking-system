package me.piguy.inholland.sisyphus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingApi {
    @GetMapping
    public ResponseEntity<String> pong() {
        return ResponseEntity.ok("pong");
    }
}
