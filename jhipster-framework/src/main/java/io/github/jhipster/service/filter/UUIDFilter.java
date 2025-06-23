package io.github.jhipster.service.filter;

import java.util.UUID;

public class UUIDFilter extends Filter<UUID> {

    private static final long serialVersionUID = 1L;

    public UUIDFilter(final UUIDFilter filter) {
        super(filter);
    }

    public UUIDFilter copy() {
        return new UUIDFilter(this);
    }
}