package com.solanky.jooqdemo;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.solanky.jooqdemo.Tables.*;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;

import static org.jooq.impl.DSL.*;

@RestController
public class WelcomeController {


    @Autowired
    DemoService demoService;



    @GetMapping("/welcome")
    public String Welcome() {
        return demoService.getResult();
    }
}
