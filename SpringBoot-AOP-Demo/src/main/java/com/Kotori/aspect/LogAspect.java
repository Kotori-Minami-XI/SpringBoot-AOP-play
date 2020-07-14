package com.Kotori.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    /***
     * 前置增强：目标方法执行之前执行
     */
    @Before("execution(* com.Kotori.controller.PersonController.*(..))")
    public void logBefore() {
        System.out.println("LogAspect Before----------------------");
    }

    /***
     * 后置增强：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     */
    @After("execution(* com.Kotori.controller.PersonController.*(..))")
    public void afterLog() {
        System.out.println("LogAspect After----------------------");
    }

    /**
     * 返回增强：目标方法正常执行完毕时执行
     */
    @AfterReturning(value = "execution(* com.Kotori.controller.PersonController.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        System.out.println("LogAspect AfterReturning------" + methodName+"-------" + result);
    }

    /***
     * 异常增强：目标方法发生异常的时候执行，第二个参数表示异常的类型
     */
    @AfterThrowing(value = "execution(* com.Kotori.controller.PersonController.*(..))", throwing = "e")
    public void afterThrowingMethod(JoinPoint jp, Exception e) {
        String methodName = jp.getSignature().getName();
        System.out.println("LogAspect afterThrowingMethod------" + methodName+"-------" + e.toString());
    }

    /***
     * 环绕增强：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     */
    @Around(value = "execution(* com.Kotori.controller.PersonController.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        String methodName = jp.getSignature().getName();
        Object result = null;

        System.out.println("aroundMethod first-----------------------------");
        //执行目标方法
        result = jp.proceed();
        System.out.println("aroundMethod second-----------------------------");
        return result;
    }

}
