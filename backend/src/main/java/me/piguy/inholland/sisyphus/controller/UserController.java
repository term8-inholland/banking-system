package me.piguy.inholland.sisyphus.controller;

import me.piguy.inholland.sisyphus.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import me.piguy.inholland.tables.pojos.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<BankUser>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody BankUser user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nuh uh");
        }
    }
}
