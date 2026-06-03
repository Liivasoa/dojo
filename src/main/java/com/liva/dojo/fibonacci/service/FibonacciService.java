package com.liva.dojo.fibonacci.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    private Map<Integer, Long> memoizationCache = new HashMap<>(Map.of(0, 0L, 1, 1L));

    public long fibonacci(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }

        if (memoizationCache.containsKey(i)) {
            return memoizationCache.get(i);
        }

        long result = fibonacci(i - 1) + fibonacci(i - 2);
        memoizationCache.put(i, result);
        return result;
    }

}
