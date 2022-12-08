package com.solanky.jooqdemo;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.currentOffsetDateTime;

@Service
public class DemoService {
    @Autowired
    private javax.sql.DataSource dataSource;

        public String getResult() {

        DSLContext dslContext = DSL.using(dataSource, SQLDialect.POSTGRES);

        Field<?> sort_order    = field("sortOrder");
        var result = dslContext
                .select(Tables.ACCOUNTS.CREATED_ON, currentOffsetDateTime(), dateDiff(currentOffsetDateTime().cast(Date.class), Tables.ACCOUNTS.CREATED_ON.cast(Date.class)).as(sort_order))
                .from(Tables.ACCOUNTS)
                .orderBy(sort_order.asc())
                .fetch();
        return result.toString();
    }





}
