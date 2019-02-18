package io.khasang.bend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {

    @Pointcut("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
    public void servicePointcut(String val) {
    }
//
//    @Before("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
//    public void getSongBefore(JoinPoint joinPoint, String val) {
//        System.err.println(val);
//        System.err.println("Before");
//    }
//
//    @After("execution(* *.getAchievement(..)) && args(val, ..)")
//    public void getSongAfter(JoinPoint joinPoint, String val) {
//        System.err.println(val);
//        System.err.println("After");
//    }

    @AfterReturning(value = "servicePointcut(val)", argNames = "joinPoint,val")
    public void getSongAfterReturn(JoinPoint joinPoint, String val) {
        System.err.println(val);
        System.err.println("AfterReturning");
    }

    @AfterThrowing(value = "servicePointcut(val)", argNames = "joinPoint,val")
    public void getSongAfterThrow(JoinPoint joinPoint, String val) {
        System.err.println(val);
        System.err.println("AfterThrowing");
    }

//    @Around(value = "servicePointcut(val)", argNames = "joinPoint,val")
//    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable {
//        System.err.println("Before invoking getAchievement() method.");
//        long timeBefore = System.currentTimeMillis();
//        Object obj = joinPoint.proceed();
//        long timeAfter = System.currentTimeMillis();
//        System.err.println("After invoking getAchievement() method. Return value: " + val);
//        System.err.println("Knight defeated an enemy - " + val + " for " + (timeAfter - timeBefore) + "ms");
//        return obj;
//    }
}
