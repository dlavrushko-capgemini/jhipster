package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class LongFilter extends RangeFilter<Long> {
    
    private static final long serialVersionUID = 1L;

    public LongFilter() {
    }

    public LongFilter(final LongFilter filter) {
        super(filter);
    }

    public LongFilter copy() {
        return new LongFilter(this);
    }
}