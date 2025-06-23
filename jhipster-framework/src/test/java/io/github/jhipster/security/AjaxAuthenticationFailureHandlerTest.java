package io.github.jhipster.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import io.github.jhipster.security.AjaxAuthenticationFailureHandler.UNAUTHORIZED_MESSAGE;
import jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions.catchThrowable;
import org.mockito.ArgumentMatchers.anyInt;
import org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;

public class AjaxAuthenticationFailureHandlerTest {

    private HttpServletResponse response;

    private AjaxAuthenticationFailureHandler handler;

    @BeforeEach
        public void setup() {
            response = spy(HttpServletResponse.class);
            handler = new AjaxAuthenticationFailureHandler();
        }

    @Test
        public void testOnAuthenticationFailure() {
            Throwable caught = catchThrowable(() -> {
                handler.onAuthenticationFailure(null, response, null);
                verify(response).sendError(SC_UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
            });
            assertThat(caught).isNull();
        }

    @Test
        public void testOnAuthenticationFailureWithException() {
            IOException exception = new IOException("Eek");
            Throwable caught = catchThrowable(() -> {
                doThrow(exception).when(response).sendError(anyInt(), anyString());
                handler.onAuthenticationFailure(null, response, null);
            });
            assertThat(caught).isEqualTo(exception);
        }
}