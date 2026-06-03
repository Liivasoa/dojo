package com.liva.dojo.fibonacci.service;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void should_return_expected_fibonacci(int input, long expected) {
        assertThat(fibonacciService.fibonacci(input)).isEqualTo(BigInteger.valueOf(expected));
    }

    @Test
    void should_return_large_fibonacci_without_overflow() {
        assertThat(fibonacciService.fibonacci(50_000).toString())
                .hasSize(10450)
                .startsWith("1077773489307297478027903")
                .endsWith("0297618305364252373553125");
    }

    @Test
    void should_throw_illegal_argument_exception_for_negative_input() {
        assertThatThrownBy(() -> fibonacciService.fibonacci(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input must be a non-negative integer");
    }

}
