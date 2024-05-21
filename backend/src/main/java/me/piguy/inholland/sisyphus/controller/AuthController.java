package me.piguy.inholland.sisyphus.controller;

import me.piguy.inholland.sisyphus.model.dto.UserAuthReq;
import me.piguy.inholland.sisyphus.model.dto.UserAuthResDTO;
import me.piguy.inholland.sisyphus.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> ass() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping
    public ResponseEntity<Object> authUser(@RequestBody UserAuthReq user) {
        try {
            return ResponseEntity.ok(userService.findUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }
}