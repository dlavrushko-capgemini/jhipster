package io.github.jhipster.config.apidoc.customizer;

import io.github.jhipster.config.JHipsterProperties;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Server;
import springfox.documentation.spring.web.plugins.Docket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import springfox.documentation.builders.PathSelectors;

public class JHipsterSpringfoxCustomizer implements SpringfoxCustomizer, Ordered {
    
    public static final int DEFAULT_ORDER = 0;

    private int order = DEFAULT_ORDER;

    private final JHipsterProperties.ApiDocs properties;

    public JHipsterSpringfoxCustomizer(JHipsterProperties.ApiDocs properties) {
        this.properties = properties;
    }

    @Override
    public void customize(Docket docket) {
        Contact contact = new Contact(
            properties.getContactName(),
            properties.getContactUrl(),
            properties.getContactEmail()
        );
    
        ApiInfo apiInfo = new ApiInfo(
            properties.getTitle(),
            properties.getDescription(),
            properties.getVersion(),
            properties.getTermsOfServiceUrl(),
            contact,
            properties.getLicense(),
            properties.getLicenseUrl(),
            List.of()
        );
    
        for (JHipsterProperties.ApiDocs.Server server : properties.getServers()) {
            docket.servers(new Server(server.getName(), server.getUrl(), server.getDescription(),
                List.of(), List.of()));
        }
    
        docket.host(properties.getHost())
            .protocols(Set.of(properties.getProtocols()))
            .apiInfo(apiInfo)
            .useDefaultResponseMessages(properties.isUseDefaultResponseMessages())
            .forCodeGeneration(true)
            .directModelSubstitute(ByteBuffer.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
            .ignoredParameterTypes(Pageable.class)
            .select()
            .paths(regex(properties.getDefaultIncludePattern()))
            .build();
    }

    @Override
        public int getOrder() {
            return order;
        }

    public void setOrder(int order) {
        this.order = order;
    }
}