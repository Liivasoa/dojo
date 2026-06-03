package com.liva.dojo.fibonacci.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public BigInteger fibonacci(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if (i == 0) {
            return BigInteger.ZERO;
        }

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int index = 1; index < i; index++) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }

        return current;
    }

}
