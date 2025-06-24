package io.github.jhipster.service.filter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class ShortFilter extends RangeFilter<Short> {
    
    private static final long serialVersionUID = 1L;

    public ShortFilter() {
    }

    public ShortFilter(final ShortFilter filter) {
        super(filter);
    }

    public ShortFilter copy() {
        return new ShortFilter(this);
    }
}