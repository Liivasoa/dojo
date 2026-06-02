package com.liva.dojo.fibonacci;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciControler {

    @GetMapping("/{n}")
    public ResponseEntity<String> getFibonacci(@PathVariable int n) {
        if(n < 0) {
            return ResponseEntity.badRequest().body("Input must be a non-negative integer");
        }
        return ResponseEntity.ok("Fibonacci sequence for n=" + n);
    }

}
