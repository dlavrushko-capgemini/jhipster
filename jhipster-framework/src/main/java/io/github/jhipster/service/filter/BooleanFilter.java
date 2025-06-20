package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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