package io.github.jhipster.web.filter;

import io.github.jhipster.config.JHipsterProperties;
import jakarta.servlet;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CachingHttpHeadersFilter implements Filter {

    public static final int DEFAULT_DAYS_TO_LIVE = 1461;

    public static final long DEFAULT_SECONDS_TO_LIVE = TimeUnit.DAYS.toMillis(DEFAULT_DAYS_TO_LIVE);

    private long cacheTimeToLive = DEFAULT_SECONDS_TO_LIVE;

    private JHipsterProperties jHipsterProperties;

    public CachingHttpHeadersFilter(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @Override
        public void destroy() {
            // Nothing to destroy
        }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    
        HttpServletResponse httpResponse = (HttpServletResponse) response;
    
        httpResponse.setHeader("Cache-Control", "max-age=" + cacheTimeToLive + ", public");
        httpResponse.setHeader("Pragma", "cache");
    
        // Setting Expires header, for proxy caching
        httpResponse.setDateHeader("Expires", cacheTimeToLive + System.currentTimeMillis());
    
        chain.doFilter(request, response);
    }

    @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            cacheTimeToLive = TimeUnit.DAYS.toMillis(jHipsterProperties.getHttp().getCache().getTimeToLiveInDays());
        }
}