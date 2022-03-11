package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class cookbookAspect {
    Logger logger = Logger.getLogger(cookbookAspect.class);

    @Before("execution(* getChef*(..))")
    public void BeforeGettingChef(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature());
    }

    @Before("execution(* getRecipe*(..))")
    public void BeforeGettingRecipe(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature());
    }
}

