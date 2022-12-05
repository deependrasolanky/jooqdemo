package com.solanky.jooqdemo;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.solanky.jooqdemo.Tables.*;

import java.sql.Date;
import java.time.LocalDate;

import static org.jooq.impl.DSL.*;

@RestController
public class WelcomeController {
    @Autowired
    private DSLContext dslContext;
    @GetMapping("/welcome")
    public String Welcome() {
        String welcomeMsg = "Welcome to Springboot planet!";
        var result = dslContext.select(Tables.ACCOUNTS.CREATED_ON, currentOffsetDateTime(), dateDiff(currentOffsetDateTime().cast(Date.class), Tables.ACCOUNTS.CREATED_ON.cast(Date.class))).from(Tables.ACCOUNTS).fetch();
        return result.toString();
    }
}
