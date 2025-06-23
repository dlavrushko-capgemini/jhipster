package io.github.jhipster.service.filter;

import java.util.List;
import java.util.ArrayList;

public class DoubleFilter extends RangeFilter<Double> {

    private static final long serialVersionUID = 1L;

    public DoubleFilter(final DoubleFilter filter) {
        super(filter);
    }

    public DoubleFilter copy() {
        return new DoubleFilter(this);
    }
}