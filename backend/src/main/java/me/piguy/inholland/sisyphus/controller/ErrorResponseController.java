package me.piguy.inholland.sisyphus.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorResponseController implements ErrorController {
    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFound() {
        return ResponseEntity.status(404).contentType(MediaType.TEXT_PLAIN).body("Not Found");
    }
}
