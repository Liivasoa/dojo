package com.liva.dojo.fibonacci.service;

public class FibonacciService {

    public int fibonacci(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return (int) fibonacci(i - 1) + (int) fibonacci(i - 2);
    }

}
