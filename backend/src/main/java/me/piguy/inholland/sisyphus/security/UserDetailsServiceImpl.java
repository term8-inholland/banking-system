package me.piguy.inholland.sisyphus.security;

import me.piguy.inholland.sisyphus.model.User;
import me.piguy.inholland.sisyphus.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.EmailNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public UserDetails loadUserByUsername(String username) throws EmailNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return org.springframework.security.core.userdetails.User
                    .withEmail(user.Email())
                    .password(user.getPassword())
                    .authorities(user.getRoles())
                    .build();
        }
        throw new EmailNotFoundException("User not found");
    }
}
