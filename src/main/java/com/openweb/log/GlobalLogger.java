package com.openweb.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/*
*This class acts as a Monitor on certain classes as it logs when the methods are being
*called and what are the parameters passed to each method are It also logs if an error occurred
* */


@Component
@Aspect
public class GlobalLogger {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLogger.class);

    /*
    * This method is called before every method in cetain classes gets executed to log the method name
    * and the parameters being sent to it
    * */
    @Before("execution(* com..*Service.*(..)) || execution(* com..*Controller.*(..)) || execution(* com..*Processor.*(..)) || execution(* com..*Reader.*(..)) || execution(* com..*Writer.*(..))")
    public void loggingMethod(JoinPoint joinPoint) {
        logger.info("the method being executed is : " + joinPoint.getSignature().getName());
        logger.info("the method being executed arguments are : " + Arrays.toString(joinPoint.getArgs()));
    }

    /*This method is called if an exception was thrown*/
    @AfterThrowing(pointcut = "execution(* com..*Service.*(..)) || execution(* com..*Controller.*(..)) || execution(* com..*Processor.*(..)) || execution(* com..*Reader.*(..)) || execution(* com..*Writer.*(..))", throwing = "e")
    public void errorLoggingMethod(JoinPoint joinPoint, Throwable e) {
        logger.error("error did occur in : " + joinPoint.getSignature().getName() + " exception was " + e.getMessage());
    }

}
