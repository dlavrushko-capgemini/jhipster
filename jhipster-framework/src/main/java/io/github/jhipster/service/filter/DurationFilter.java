package io.github.jhipster.service.filter;

import java.time.Duration;

public class DurationFilter extends RangeFilter<Duration> {

    private static final long serialVersionUID = 1L;

    public DurationFilter(final DurationFilter filter) {
        super(filter);
    }

    public DurationFilter copy() {
        return new DurationFilter(this);
    }
}