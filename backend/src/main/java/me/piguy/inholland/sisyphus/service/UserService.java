package me.piguy.inholland.sisyphus.service;

import me.piguy.inholland.sisyphus.model.User;
import me.piguy.inholland.sisyphus.model.dto.BankUserDTO;
import me.piguy.inholland.sisyphus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(BankUserDTO bankUserDTO) {
        User user = new User(bankUserDTO.name(), bankUserDTO.password());
        userRepository.save(user);
        return user;
    }
}
