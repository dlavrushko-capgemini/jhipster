package io.github.jhipster.service.filter;

import jakarta.validation.constraints.*; // Example import, update as necessary
import java.io.Serializable;
import java.util.List;

public class FloatFilter extends RangeFilter<Float> {
    
    private static final long serialVersionUID = 1L;

    public FloatFilter(final FloatFilter filter) {
        super(filter);
    }

    public FloatFilter copy() {
        return new FloatFilter(this);
    }
}