package me.piguy.inholland.sisyphus.configuration;

import me.piguy.inholland.sisyphus.service.IbanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {
    @Bean
    public IbanService ibanService() {
        return new IbanService();
    }
}
