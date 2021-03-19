/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author neira
 */
@Aspect
@Component
public class AopAudit {

    /**
     * Maybe could be trace the operations in the future
     */
    @Before("execution(* getClients())")
    public void log() {
        System.out.println("el metodo se ha invocado");
    }
    
    /**
     * Maybe could be control the exceptions in the future
     * @param ex
     */
    @AfterThrowing(pointcut = "execution(* com.valid.*.*.*(..))", throwing = "ex")
    public void logError(Exception ex) {
        ex.printStackTrace();
    }    
  
}
