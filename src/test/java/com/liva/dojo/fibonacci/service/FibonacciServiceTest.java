package com.liva.dojo.fibonacci.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.time.Duration;

import org.awaitility.Awaitility;

public class FibonacciServiceTest {
    
    private FibonacciService fibonacciService = new FibonacciService();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "10, 55",
            "20, 6765",
            "30, 832040",
            "40, 102334155",
    })
    void should_return_expected_fibonacci(int input, int expected) {
        assertThat(fibonacciService.fibonacci(input)).isEqualTo(expected);
    }

    @Test
    void should_return_12586269025_for_50_and_execution_time_less_than_1_second() {
        Awaitility.await().atMost(Duration.ofSeconds(1)).untilAsserted(() -> {
            assertThat(fibonacciService.fibonacci(50)).isEqualTo(new BigInteger("12586269025"));
        });
    }

    @Test
    void should_return_354224848179261915075_for_100_and_execution_time_less_than_1_second() {
        Awaitility.await().atMost(Duration.ofSeconds(1)).untilAsserted(() -> {
            assertThat(fibonacciService.fibonacci(100)).isEqualTo(new BigInteger("354224848179261915075"));
        });
    }

    @Test
    void should_throw_illegal_argument_exception_for_negative_input() {
        assertThatThrownBy(() -> fibonacciService.fibonacci(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input must be a non-negative integer");
    }

}
