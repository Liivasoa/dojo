package com.liva.dojo.fibonacci.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liva.dojo.fibonacci.service.FibonacciService;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciControler {

    private final FibonacciService fibonacciService;

    public FibonacciControler(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/{n}")
    public ResponseEntity<String> getFibonacci(@PathVariable int n) {
        if(n < 0) {
            return ResponseEntity.badRequest().body("Input must be a non-negative integer");
        }
        long result = fibonacciService.fibonacci(n);
        return ResponseEntity.ok("Fibonacci sequence for n=" + n + " is " + result);
    }

}
