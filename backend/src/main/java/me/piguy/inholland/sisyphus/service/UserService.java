package me.piguy.inholland.sisyphus.service;

import me.piguy.inholland.sisyphus.model.User;
import me.piguy.inholland.sisyphus.model.dto.BankUserDTO;
import me.piguy.inholland.sisyphus.model.dto.UserAuthReq;
import me.piguy.inholland.sisyphus.model.dto.UserAuthResDTO;
import me.piguy.inholland.sisyphus.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
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
        User user = new User(bankUserDTO.email(), bankUserDTO.password());
        userRepository.save(user);
        return user;
    }

    public UserAuthResDTO findUser(UserAuthReq authReq) throws Exception {
        var user = userRepository.findByEmail(authReq.email());

        // TODO: hash HASH HASH HASH HAASSSSSHHHHH
        if (user != null && authReq.password().equals(user.getPassword())) {
            return new UserAuthResDTO(user.getEmail() , "totallyrealtoken");
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}
