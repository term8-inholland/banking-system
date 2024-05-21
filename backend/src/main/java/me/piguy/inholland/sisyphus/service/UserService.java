package me.piguy.inholland.sisyphus.service;

import me.piguy.inholland.sisyphus.model.User;
import me.piguy.inholland.sisyphus.model.dto.BankUserDTO;
import me.piguy.inholland.sisyphus.model.dto.UserAuthReq;
import me.piguy.inholland.sisyphus.model.dto.UserAuthResDTO;
import me.piguy.inholland.sisyphus.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(BankUserDTO bankUserDTO) {
        String password = passwordEncoder.encode(bankUserDTO.password());
        User user = new User(bankUserDTO.email(), password);
        userRepository.save(user);
        return user;
    }

    public UserAuthResDTO findUser(UserAuthReq authReq) throws Exception {
        var user = userRepository.findByEmail(authReq.email());

        if (user != null && passwordEncoder.matches(authReq.password(), user.getPassword())) {
            return new UserAuthResDTO(user.getEmail() + "totallyarealtoken");
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}