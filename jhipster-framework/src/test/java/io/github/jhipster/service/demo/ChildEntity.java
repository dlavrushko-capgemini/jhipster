package io.github.jhipster.service.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class ChildEntity extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParentEntity parent;
}