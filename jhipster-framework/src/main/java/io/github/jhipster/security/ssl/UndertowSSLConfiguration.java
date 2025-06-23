package io.github.jhipster.security.ssl;

import io.undertow.UndertowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(UndertowServletWebServerFactory.class)
@ConditionalOnClass(UndertowOptions.class)
@ConditionalOnProperty({"server.ssl.ciphers", "server.ssl.key-store"})
public class UndertowSSLConfiguration {

    private final UndertowServletWebServerFactory factory;

    private final Logger log = LoggerFactory.getLogger(UndertowSSLConfiguration.class);

    public UndertowSSLConfiguration(UndertowServletWebServerFactory undertowServletWebServerFactory) {
        this.factory = undertowServletWebServerFactory;
    
        configuringUserCipherSuiteOrder();
    }

    private void configuringUserCipherSuiteOrder() {
        log.info("Configuring Undertow");
        log.info("Setting user cipher suite order to true");
        factory.addBuilderCustomizers(builder -> 
            builder.setSocketOption(UndertowOptions.SSL_USER_CIPHER_SUITES_ORDER, Boolean.TRUE)
        );
    }
}