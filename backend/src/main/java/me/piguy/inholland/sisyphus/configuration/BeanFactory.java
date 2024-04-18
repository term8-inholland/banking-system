package me.piguy.inholland.sisyphus.configuration;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
public class BeanFactory {

    private final DataSource dataSource;

    @Autowired
    public BeanFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DSLContext ctx() throws Exception {
        Connection connection = dataSource.getConnection();
        return DSL.using(connection);
    }
}
