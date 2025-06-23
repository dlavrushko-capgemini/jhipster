package io.github.jhipster.service.filter;

import java.io.Serializable;
import java.util.Objects;

public class ShortFilter extends RangeFilter<Short> {

    private static final long serialVersionUID = 1L;

    public ShortFilter(final ShortFilter filter) {
        super(filter);
    }

    public ShortFilter copy() {
        return new ShortFilter(this);
    }
}