package com.liva.dojo.fibonacci.api;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liva.dojo.fibonacci.service.FibonacciService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/{n}")
    @Operation(summary = "Returns the Fibonacci number for a given non-negative integer position n",
        description = "Return 55 for 10, 6765 for 20, and so on"
    )
    public ResponseEntity<String> getFibonacci(@PathVariable int n) {
        if(n < 0) {
            return ResponseEntity.badRequest().body("Input must be a non-negative integer");
        }
        BigInteger result = fibonacciService.fibonacci(n);
        return ResponseEntity.ok("Fibonacci sequence for n=" + n + " is " + result);
    }

}
