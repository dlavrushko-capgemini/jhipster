package io.github.jhipster.security;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PersistentTokenCacheTest {

    @Test
        public void testAbsent() {
            PersistentTokenCache<String> cache = new PersistentTokenCache<>(100L);
            assertThat(cache.get("key")).isNull();
        }

    @Test
        public void testAccess() {
            PersistentTokenCache<String> cache = new PersistentTokenCache<>(100L);
            cache.put("key", "val");
            assertThat(cache.size()).isEqualTo(1);
            assertThat(cache.get("key")).isEqualTo("val");
        }

    @Test
        public void testConstructorThrows() {
            Throwable caught = catchThrowable(() -> new PersistentTokenCache<String>(-1L));
            assertThat(caught).isInstanceOf(IllegalArgumentException.class);
        }

    @Test
        public void testExpires() {
            PersistentTokenCache<String> cache = new PersistentTokenCache<>(1L);
            cache.put("key", "val");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException x) {
                // This should not happen
                throw new Error(x);
            }
            assertThat(cache.get("key")).isNull();
        }

    @Test
        public void testPurge() {
            PersistentTokenCache<String> cache = new PersistentTokenCache<>(1L);
            cache.put("key", "val");
            try {
                Thread.sleep(100L);
            } catch (InterruptedException x) {
                // This should not happen
                throw new Error(x);
            }
            assertThat(cache.size()).isEqualTo(1);
            cache.purge();
            assertThat(cache.size()).isEqualTo(0);
        }

    @Test
        public void testReplace() {
            PersistentTokenCache<String> cache = new PersistentTokenCache<>(100L);
            cache.put("key", "val");
            cache.put("key", "foo");
            assertThat(cache.get("key")).isEqualTo("foo");
        }
}