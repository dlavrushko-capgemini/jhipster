package io.github.jhipster.service.filter;

import jakarta.filter.Filter;

public class BooleanFilter extends Filter<Boolean> {
    
    private static final long serialVersionUID = 1L;

    public BooleanFilter() {
    }

    public BooleanFilter(final BooleanFilter filter) {
        super(filter);
    }

    @Override
        public BooleanFilter copy() {
            return new BooleanFilter(this);
        }
}