package com.liva.dojo.fibonacci.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.liva.dojo.fibonacci.usecase.FibonacciUseCase;

@Service
public class NewWayFibonacciService implements FibonacciUseCase {

    @Override
    public BigInteger fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if (n == 0) {
            return BigInteger.ZERO;
        }

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int index = 1; index < n; index++) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }

        return current;
    }

}