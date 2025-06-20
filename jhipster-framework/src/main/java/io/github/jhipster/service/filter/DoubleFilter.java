package io.github.jhipster.service.filter;

import java.util.List;
import java.util.Optional;
import jakarta.validation.constraints.NotNull;

public class DoubleFilter extends RangeFilter<Double> {
    
    private static final long serialVersionUID = 1L;

    public DoubleFilter(final DoubleFilter filter) {
        super(filter);
    }

    public DoubleFilter copy() {
        return new DoubleFilter(this);
    }
}