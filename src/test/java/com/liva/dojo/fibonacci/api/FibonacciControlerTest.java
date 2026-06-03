package com.liva.dojo.fibonacci.api;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.liva.dojo.fibonacci.service.FibonacciService;

import static org.mockito.BDDMockito.given;

@WebMvcTest(FibonacciController.class)
@AutoConfigureRestTestClient
public class FibonacciControlerTest {

    @Autowired
    private RestTestClient restClient;

    @MockitoBean
    private FibonacciService fibonacciService;

    @Test
    void should_return_fibonacci_sequence_for_valid_input() {
        given(fibonacciService.fibonacci(10)).willReturn(BigInteger.valueOf(55));

        restClient.get().uri("/fibonacci/10")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Fibonacci sequence for n=10 is 55");
    }

    @Test
    void should_return_fibonacci_sequence_for_zero() {
        given(fibonacciService.fibonacci(0)).willReturn(BigInteger.ZERO);

        restClient.get().uri("/fibonacci/0")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Fibonacci sequence for n=0 is 0");
    }

    @Test
    void should_return_large_fibonacci_sequence_for_large_input() {
        given(fibonacciService.fibonacci(50_000))
                .willReturn(new FibonacciService().fibonacci(50_000));

        restClient.get().uri("/fibonacci/50000")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> org.assertj.core.api.Assertions.assertThat(body)
                        .startsWith("Fibonacci sequence for n=50000 is 1077773489307297478027903")
                        .endsWith("0297618305364252373553125"));
    }

    @Test
    void should_return_bad_request_when_input_is_negative() {
        restClient.get().uri("/fibonacci/-5")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void should_return_bad_request_when_input_is_not_integer() {
        restClient.get().uri("/fibonacci/abc")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void should_return_not_found_when_input_is_missing() {
        restClient.get().uri("/fibonacci/")
                .exchange()
                .expectStatus().isNotFound();
    }


}
