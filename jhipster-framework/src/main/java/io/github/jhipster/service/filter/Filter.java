package io.github.jhipster.service.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filter<FIELD_TYPE> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private FIELD_TYPE equals;
    
    private FIELD_TYPE notEquals;
    
    private Boolean specified;
    
    private List<FIELD_TYPE> in;
    
    private List<FIELD_TYPE> notIn;

    public Filter(Filter<FIELD_TYPE> filter) {
        this.equals = filter.equals;
        this.notEquals = filter.notEquals;
        this.specified = filter.specified;
        this.in = filter.in == null ? null : new ArrayList<>(filter.in);
        this.notIn = filter.notIn == null ? null : new ArrayList<>(filter.notIn);
    }

    public Filter<FIELD_TYPE> copy() {
        return new Filter<>(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Filter<?> filter = (Filter<?>) o;
        return Objects.equals(equals, filter.equals) &&
               Objects.equals(notEquals, filter.notEquals) &&
               Objects.equals(specified, filter.specified) &&
               Objects.equals(in, filter.in) &&
               Objects.equals(notIn, filter.notIn);
    }

    public FIELD_TYPE getEquals() {
        return equals;
    }

    protected String getFilterName() {
        return this.getClass().getSimpleName();
    }

    public List<FIELD_TYPE> getIn() {
        return in;
    }

    public FIELD_TYPE getNotEquals() {
        return notEquals;
    }

    public List<FIELD_TYPE> getNotIn() {
        return notIn;
    }

    public Boolean getSpecified() {
        return specified;
    }

    @Override
        public int hashCode() {
            return Objects.hash(equals, notEquals, specified, in, notIn);
        }

    public Filter<FIELD_TYPE> setEquals(FIELD_TYPE equals) {
        this.equals = equals;
        return this;
    }

    public Filter<FIELD_TYPE> setIn(List<FIELD_TYPE> in) {
        this.in = in;
        return this;
    }

    public Filter<FIELD_TYPE> setNotEquals(FIELD_TYPE notEquals) {
        this.notEquals = notEquals;
        return this;
    }

    public Filter<FIELD_TYPE> setNotIn(List<FIELD_TYPE> notIn) {
        this.notIn = notIn;
        return this;
    }

    public Filter<FIELD_TYPE> setSpecified(Boolean specified) {
        this.specified = specified;
        return this;
    }

    @Override
    public String toString() {
        return getFilterName() + " ["
                + (getEquals() != null ? "equals=" + getEquals() + ", " : "")
                + (getNotEquals() != null ? "notEquals=" + getNotEquals() + ", " : "")
                + (getSpecified() != null ? "specified=" + getSpecified() + ", " : "")
                + (getIn() != null ? "in=" + getIn() + ", " : "")
                + (getNotIn() != null ? "notIn=" + getNotIn() : "")
                + "]";
    }
}