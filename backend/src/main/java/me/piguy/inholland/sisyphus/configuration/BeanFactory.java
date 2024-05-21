package me.piguy.inholland.sisyphus.configuration;

import me.piguy.inholland.sisyphus.service.IbanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanFactory {
    @Bean
    public IbanService ibanService() {
        return new IbanService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
