/**
 * Liquibase specific code.
 */
package io.github.jhipster.config.liquibase;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private SpringLiquibase liquibase;

    @PostConstruct
    public void init() throws LiquibaseException {
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.afterPropertiesSet();
    }

    @PreDestroy
    public void destroy() {
        // Cleanup resources if necessary
    }
}