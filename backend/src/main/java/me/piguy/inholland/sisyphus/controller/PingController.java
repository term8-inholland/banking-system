package me.piguy.inholland.sisyphus.controller;

import me.piguy.inholland.sisyphus.service.IbanService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    private final IbanService ibanService;

    public PingController(IbanService ibanService) {
        this.ibanService = ibanService;
    }

    @GetMapping
    public ResponseEntity<String> pong() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        String iban = ibanService.generateIban();
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(iban);
    }
}
