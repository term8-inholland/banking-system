package me.piguy.inholland.sisyphus.service;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

import me.piguy.inholland.tables.pojos.*;
import static me.piguy.inholland.Tables.*;
import static org.jooq.impl.DSL.defaultValue;

@Service
public class UserService {
    private final DSLContext ctx;

    public UserService(DSLContext ctx) {
        this.ctx = ctx;
    }

    public List<BankUser> getAllUsers() {
        return ctx.selectFrom(BANK_USER).fetchInto(BankUser.class);
    }

    public void addUser(BankUser user) {
        ctx.insertInto(BANK_USER).values(defaultValue(BANK_USER.ID), user).execute();
    }
}
