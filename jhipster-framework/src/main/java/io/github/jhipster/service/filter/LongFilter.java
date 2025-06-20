package io.github.jhipster.service.filter;

import java.io.Serializable;
import java.util.List;

public class LongFilter extends RangeFilter<Long> {
    
    private static final long serialVersionUID = 1L;

    public LongFilter(final LongFilter filter) {
        super(filter);
    }

    public LongFilter copy() {
        return new LongFilter(this);
    }
}