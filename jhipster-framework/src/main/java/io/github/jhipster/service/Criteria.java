package io.github.jhipster.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface Criteria {
    /**
     * <p>copy.</p>
     *
     * @return a new criteria with copied filters
     */
    Criteria copy();
}