package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class IntegerFilter extends RangeFilter<Integer> {
    
    private static final long serialVersionUID = 1L;

    public IntegerFilter() {
    }

    public IntegerFilter(final IntegerFilter filter) {
        super(filter);
    }

    public IntegerFilter copy() {
        return new IntegerFilter(this);
    }
}