package com.liva.dojo.fibonacci.service;

import java.util.HashMap;
import java.util.Map;

public class FibonacciService {

    private Map<Integer, Integer> counterMap = new HashMap<>();

    public Object fibonacci(int i) {
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
