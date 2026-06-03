package com.liva.dojo.fibonacci;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.liva.dojo.fibonacci.service.FibonacciService;

@WebMvcTest
@AutoConfigureRestTestClient
public class FibonacciIntegrationTest {

    @Autowired
    private RestTestClient restClient;
    
    @MockitoBean
    private FibonacciService fibonacciService;

    @Test
    void should_call_fibonacci_service_with_user_input() {
        // Given
        int input = 10;

        // When
        restClient.get().uri("/fibonacci/" + input)
                .exchange()
                .expectStatus().isOk();

        // Then
        Mockito.verify(fibonacciService).fibonacci(input);
    }

}
