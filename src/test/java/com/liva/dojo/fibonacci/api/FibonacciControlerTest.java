package com.liva.dojo.fibonacci.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.liva.dojo.fibonacci.service.FibonacciService;

@WebMvcTest(FibonacciController.class)
@AutoConfigureRestTestClient
public class FibonacciControlerTest {

    @Autowired
    private RestTestClient restClient;

    @MockitoBean
    private FibonacciService fibonacciService;

    @Test
    void should_return_fibonacci_sequence_for_valid_input() {
        restClient.get().uri("/fibonacci/10")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void should_return_fibonacci_sequence_for_zero() {
        restClient.get().uri("/fibonacci/0")
                .exchange()
                .expectStatus().isOk();
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
