package io.github.jhipster.security;

import org.apache.commons.lang3.RandomStringUtils;
import java.security.SecureRandom;

public final class RandomUtil {

    private static final int DEF_COUNT = 20;

    private static final SecureRandom SECURE_RANDOM;

    private RandomUtil() {
    }

    public static String generateActivationKey() {
        return generateRandomAlphanumericString();
    }

    public static String generatePassword() {
        return generateRandomAlphanumericString();
    }

    public static String generateRandomAlphanumericString() {
        return RandomStringUtils.random(DEF_COUNT, 0, 0, true, true, null, SECURE_RANDOM);
    }

    public static String generateResetKey() {
        return generateRandomAlphanumericString();
    }
}