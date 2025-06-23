package io.github.jhipster.security.uaa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.security.oauth2.client.registration.ClientCredentialsResourceDetails;
import java.net.URI;
import java.net.URISyntaxException;

@ConditionalOnMissingBean
public class LoadBalancedResourceDetails extends ClientCredentialsResourceDetails {

    public static final String EXCEPTION_MESSAGE = "Returning an invalid URI: {}";

    private final Logger log = LoggerFactory.getLogger(LoadBalancedResourceDetails.class);

    private String tokenServiceId;

    private LoadBalancerClient loadBalancerClient;

    public LoadBalancedResourceDetails(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    public String getAccessTokenUri() {
        if (loadBalancerClient != null && tokenServiceId != null && !tokenServiceId.isEmpty()) {
            try {
                return loadBalancerClient.reconstructURI(
                    loadBalancerClient.choose(tokenServiceId),
                    new URI(super.getAccessTokenUri())
                ).toString();
            } catch (URISyntaxException e) {
                log.error(EXCEPTION_MESSAGE, e.getMessage());
    
                return super.getAccessTokenUri();
            }
        } else {
            return super.getAccessTokenUri();
        }
    }

    public String getTokenServiceId() {
        return this.tokenServiceId;
    }

    public void setTokenServiceId(String tokenServiceId) {
        this.tokenServiceId = tokenServiceId;
    }
}