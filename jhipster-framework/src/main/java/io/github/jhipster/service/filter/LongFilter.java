package io.github.jhipster.service.filter;

import jakarta.persistence.*; // Example of updating javax to jakarta if applicable
import java.util.List; // Assuming List is used in the class
import java.util.ArrayList; // Assuming ArrayList is used in the class
import java.util.Optional; // Assuming Optional is used in the class

public class LongFilter extends RangeFilter<Long> {
    
    private static final long serialVersionUID = 1L;

    public LongFilter(final LongFilter filter) {
        super(filter);
    }

    public LongFilter copy() {
        return new LongFilter(this);
    }
}