package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class IntegerFilter extends RangeFilter<Integer> {
    
    private static final long serialVersionUID = 1L;

    public IntegerFilter(final IntegerFilter filter) {
        super(filter);
    }

    public IntegerFilter copy() {
        return new IntegerFilter(this);
    }
}