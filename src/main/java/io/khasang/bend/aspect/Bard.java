package io.khasang.bend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {

//    @Pointcut("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
//    public void serviceBefore() {
//
//    }

//    @Before("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
//    public void getSong(JoinPoint joinPoint, String val) {
//        System.err.println(val);
//        System.err.println("Lalalala");
//    }
//
    @Around("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..)) && args(val, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        System.err.println("Lalalala");
        System.err.println("Knight defeat an enemy - " + val + " with "  + (timeAfter - timeBefore) + "ms");
        return obj;
    }


}
