package io.github.jhipster.config.cache;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PrefixedKeyGenerator implements KeyGenerator {

    private final String prefix;

    public PrefixedKeyGenerator(GitProperties gitProperties, BuildProperties buildProperties) {
        this.prefix = generatePrefix(gitProperties, buildProperties);
    }

    @Override
        public Object generate(Object target, Method method, Object... params) {
            return new PrefixedSimpleKey(prefix, method.getName(), params);
        }

    private String generatePrefix(GitProperties gitProperties, BuildProperties buildProperties) {
        String shortCommitId = null;
        if (gitProperties != null) {
            shortCommitId = gitProperties.getShortCommitId();
        }

        Instant time = null;
        String version = null;
        if (buildProperties != null) {
            time = buildProperties.getTime();
            version = buildProperties.getVersion();
        }
        Object p = ObjectUtils.firstNonNull(shortCommitId, time, version, RandomStringUtils.randomAlphanumeric(12));

        if (p instanceof Instant) {
            return DateTimeFormatter.ISO_INSTANT.format((Instant) p);
        }
        return p.toString();
    }

    String getPrefix() {
        return this.prefix;
    }
}