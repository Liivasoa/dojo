package com.liva.dojo.fibonacci.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public long fibonacci(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return (long) fibonacci(i - 1) + (long) fibonacci(i - 2);
    }

}
