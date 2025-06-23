package io.github.jhipster.service.filter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import java.time.ZonedDateTime;
import java.util.List;

public class ZonedDateTimeFilter extends RangeFilter<ZonedDateTime> {

    private static final long serialVersionUID = 1L;

    public ZonedDateTimeFilter(final ZonedDateTimeFilter filter) {
        super(filter);
    }

    @Override
        public ZonedDateTimeFilter copy() {
            return new ZonedDateTimeFilter(this);
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setEquals(ZonedDateTime equals) {
            super.setEquals(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setGreaterThan(ZonedDateTime equals) {
            super.setGreaterThan(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setGreaterThanOrEqual(ZonedDateTime equals) {
            super.setGreaterThanOrEqual(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setIn(List<ZonedDateTime> in) {
            super.setIn(in);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setLessThan(ZonedDateTime equals) {
            super.setLessThan(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setLessThanOrEqual(ZonedDateTime equals) {
            super.setLessThanOrEqual(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setNotEquals(ZonedDateTime equals) {
            super.setNotEquals(equals);
            return this;
        }

    @Override
        @DateTimeFormat(iso = ISO.DATE_TIME)
        public ZonedDateTimeFilter setNotIn(List<ZonedDateTime> notIn) {
            super.setNotIn(notIn);
            return this;
        }
}