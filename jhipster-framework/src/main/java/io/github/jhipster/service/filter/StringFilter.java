package io.github.jhipster.service.filter;

import java.util.Objects;

public class StringFilter extends Filter<String> {
    
    private static final long serialVersionUID = 1L;
    
    private String contains;
    
    private String doesNotContain;

    public StringFilter(final StringFilter filter) {
        super(filter);
        this.contains = filter.contains;
        this.doesNotContain = filter.doesNotContain;
    }

    @Override
        public StringFilter copy() {
            return new StringFilter(this);
        }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final StringFilter that = (StringFilter) o;
        return Objects.equals(contains, that.contains) &&
               Objects.equals(doesNotContain, that.doesNotContain);
    }

    public String getContains() {
        return contains;
    }

    public String getDoesNotContain() {
        return doesNotContain;
    }

    @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), contains, doesNotContain);
        }

    public StringFilter setContains(String contains) {
        this.contains = contains;
        return this;
    }

    public StringFilter setDoesNotContain(String doesNotContain) {
        this.doesNotContain = doesNotContain;
        return this;
    }

    @Override
    public String toString() {
        return getFilterName() + " ["
            + (getEquals() != null ? "equals=" + getEquals() + ", " : "")
            + (getNotEquals() != null ? "notEquals=" + getNotEquals() + ", " : "")
            + (getSpecified() != null ? "specified=" + getSpecified() + ", " : "")
            + (getIn() != null ? "in=" + getIn() + ", " : "")
            + (getNotIn() != null ? "notIn=" + getNotIn() + ", " : "")
            + (getContains() != null ? "contains=" + getContains() + ", " : "")
            + (getDoesNotContain() != null ? "doesNotContain=" + getDoesNotContain() : "")
            + "]";
    }
}