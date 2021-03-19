/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author neira
 */
@Aspect
@Component
public class AopAuditCore {

    /**
     * When operation timeout is reached print time execution
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(* *service.ClientService.*(..))")
    public void timeOut(ProceedingJoinPoint joinPoint) throws Throwable {
        Long start = System.currentTimeMillis(), end, total;
        try {
            joinPoint.proceed();
            end = System.currentTimeMillis();
            total = start - end;
            if (total >= 2) {
                System.out.format("Operaacion: %s time %d\n", joinPoint.getSignature().getName(), total);
            }
        } finally {

        }

    }
}
