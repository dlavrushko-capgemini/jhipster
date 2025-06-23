package io.github.jhipster.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface Criteria {
    /**
     * <p>copy.</p>
     *
     * @return a new criteria with copied filters
     */
    Criteria copy();
}