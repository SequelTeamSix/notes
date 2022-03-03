package spring2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DigimonAspect {

    /*Cross cutting concerns?
    Sometimes we have a desired action that is performed *across* methods, across components...
    and, in the interest of reducing boilerplate, we want to have a strategy
    for implementing some functionality across these

    An aspect: eliminates the need for cross cutting concerns
    by applying this functionality for us

    A joinpoint: is a place where an advice can be executed
    An advice is an action taken by an aspect
    A pointcut is an expression used to select a joinpoint

//    pointcut expression:
    @Before("execution(String get*(..))")
    public void BeforeGetting(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
    }
*/



}
