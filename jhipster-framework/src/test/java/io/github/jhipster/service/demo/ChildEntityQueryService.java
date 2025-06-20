package io.github.jhipster.service.demo;

import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.LongFilter;
import org.springframework.data.jpa.domain.Specification;

public static class ChildEntityCriteria extends BaseEntityQueryService.BaseEntityCriteria {
    LongFilter parentId;

    public LongFilter getParentId() {
        return parentId;
    }
}

LongFilter parentId;

    public LongFilter getParentId() {
        return id;
    }
}

public class ChildEntityQueryService extends QueryService<ChildEntity> {

    public Specification<ChildEntity> createSpecification(ChildEntityCriteria criteria) {
        Specification<ChildEntity> specification = Specification.where(null);
        if (criteria.getParentId() != null) {
            specification = specification.and(buildReferringEntitySpecification(criteria.getParentId(), ChildEntity_.parent, ParentEntity_.id));
        }
        return specification;
    }
}