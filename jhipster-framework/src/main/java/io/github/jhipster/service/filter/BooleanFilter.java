package io.github.jhipster.service.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class BooleanFilter extends Filter<Boolean> {
    
    private static final long serialVersionUID = 1L;

    public BooleanFilter(final BooleanFilter filter) {
        super(filter);
    }

    @Override
        public BooleanFilter copy() {
            return new BooleanFilter(this);
        }
}