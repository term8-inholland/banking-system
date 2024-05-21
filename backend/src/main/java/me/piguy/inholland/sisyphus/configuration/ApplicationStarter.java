package me.piguy.inholland.sisyphus.configuration;

import me.piguy.inholland.sisyphus.model.dto.BankUserDTO;
import me.piguy.inholland.sisyphus.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStarter implements ApplicationRunner {
    private final UserService userService;

    public ApplicationStarter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addUser(new BankUserDTO("a@b.c", "tobehashed"));
    }
}
