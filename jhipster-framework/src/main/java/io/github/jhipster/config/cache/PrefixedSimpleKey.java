package io.github.jhipster.config.cache;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import java.io.Serializable;
import java.util.Arrays;

public class PrefixedSimpleKey implements Serializable {
    
    private final String prefix;
    
    private final Object[] params;
    
    private final String methodName;
    
    private int hashCode;

    public PrefixedSimpleKey(String prefix, String methodName, Object... elements) {
        Assert.notNull(prefix, "Prefix must not be null");
        Assert.notNull(elements, "Elements must not be null");
        this.prefix = prefix;
        this.methodName = methodName;
        this.params = Arrays.copyOf(elements, elements.length);
        this.hashCode = prefix.hashCode();
        this.hashCode = 31 * this.hashCode + methodName.hashCode();
        this.hashCode = 31 * this.hashCode + Arrays.deepHashCode(this.params);
    }

    @Override
    public boolean equals(Object other) {
        return (this == other ||
                (other instanceof PrefixedSimpleKey prefixedSimpleKey && 
                 this.prefix.equals(prefixedSimpleKey.prefix) &&
                 this.methodName.equals(prefixedSimpleKey.methodName) &&
                 Arrays.deepEquals(this.params, prefixedSimpleKey.params)));
    }

    @Override
        public final int hashCode() {
            return this.hashCode;
        }

    @Override
        public String toString() {
            return this.prefix + " " + getClass().getSimpleName() + this.methodName + " [" + String.join(", ", this.params) + "]";
        }
}