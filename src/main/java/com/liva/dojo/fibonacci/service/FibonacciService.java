package com.liva.dojo.fibonacci.service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    private final ConcurrentMap<Integer, BigInteger> memoizationCache = new ConcurrentHashMap<>(Map.of(0, BigInteger.ZERO, 1, BigInteger.ONE));

    public BigInteger fibonacci(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }

        if (memoizationCache.containsKey(i)) {
            return memoizationCache.get(i);
        }

        BigInteger result = fibonacci(i - 1).add(fibonacci(i - 2));
        memoizationCache.put(i, result);
        return result;
    }

}
