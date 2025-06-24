package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class DoubleFilter extends RangeFilter<Double> {
    
    private static final long serialVersionUID = 1L;

    public DoubleFilter() {
    }

    public DoubleFilter(final DoubleFilter filter) {
        super(filter);
    }

    public DoubleFilter copy() {
        return new DoubleFilter(this);
    }
}