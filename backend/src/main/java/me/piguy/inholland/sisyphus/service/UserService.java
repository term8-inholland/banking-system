package me.piguy.inholland.sisyphus.service;

import me.piguy.inholland.sisyphus.model.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static me.piguy.inholland.Tables.BANK_USER;

@Service
public class UserService {
    private final DSLContext ctx;

    public UserService(DSLContext ctx) {
        this.ctx = ctx;
    }

    public List<User> getAllUsers() {
        return ctx
                .select(BANK_USER.ID ,BANK_USER.FIRST_NAME, BANK_USER.LAST_NAME, BANK_USER.PASSWORD)
                .from(BANK_USER)
                .fetchInto(User.class);
    }

    public User getUserById(UUID userId) {
        return ctx
                .select(BANK_USER.ID ,BANK_USER.FIRST_NAME, BANK_USER.LAST_NAME, BANK_USER.PASSWORD)
                .from(BANK_USER)
                .where(BANK_USER.ID.eq(userId))
                .fetchOneInto(User.class);
    }

    public void addUser(User user) {
        ctx.insertInto(BANK_USER, BANK_USER.FIRST_NAME, BANK_USER.LAST_NAME, BANK_USER.PASSWORD)
                .values(user.first_name(), user.last_name(), user.password())
                .execute();
    }
}
