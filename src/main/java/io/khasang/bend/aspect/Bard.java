package io.khasang.bend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterThrowing(pointcut = "execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..))", throwing = "ex")
    public void bardSingSongOfUpset(Throwable ex) throws Throwable {
        System.err.println("Something awfull has happened and knight could not solve his sacral mission :( this is how it happened in details:");
        ex.printStackTrace();
        System.err.println("May be it was a.... ddddrrragonnnn?   =$");
    }

    @AfterReturning(pointcut="execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..))", returning="retVal")
    public void bardIsApprovingSuccess(Object retVal) {
        System.err.println("Knight successfully crushed a "+ retVal);
    }

    @After("execution(* io.khasang.bend.service.impl.KnightServiceImpl.getAchievement(..))")
    public void bardConstitutingFact() {
        System.err.println("singing a song... anyway... he is brave, he have tried.... ");
    }
}