package io.github.jhipster.service.filter;

import jakarta.validation.constraints.*; // Example of a potential import that may need updating
import java.util.*; // Original import, compatible with Java 21
import java.io.*; // Original import, compatible with Java 21

public class FloatFilter extends RangeFilter<Float> {
    
    private static final long serialVersionUID = 1L;

    public FloatFilter() {
    }

    public FloatFilter(final FloatFilter filter) {
        super(filter);
    }

    public FloatFilter copy() {
        return new FloatFilter(this);
    }
}