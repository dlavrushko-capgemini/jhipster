package io.github.jhipster.service.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ParentEntity extends BaseEntity {

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<ChildEntity> child1s = new HashSet<>();
}