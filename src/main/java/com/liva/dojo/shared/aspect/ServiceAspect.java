package com.liva.dojo.shared.aspect;
import java.time.Duration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Around("execution(* com.liva.dojo.*.usecase.*UseCase.*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            String methodName = joinPoint.getSignature().toShortString();
            IO.println("Executed: " + methodName + " in " + Duration.ofNanos(duration).toMillis() + " ms");
        }
    }
    
}
