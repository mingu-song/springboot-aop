package mingu.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EnableRestCallLogAspect {
    private final Logger log = LoggerFactory.getLogger(EnableRestCallLogAspect.class);

    @Around("@annotation(mingu.spring.aop.aspect.EnableRestCallLogs)")
//    @Around("within(mingu.spring.aop.controller.*)")
//    @Around("execution(public * mingu.spring.aop.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long initTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - initTime;
        log.info("============================================================================================================");
        log.info("Method Signature is : {}", joinPoint.getSignature());
        log.info("Method executed in : {}", executionTime + "ms");
        log.info("Input Request: {}", joinPoint.getArgs()[0]);
        log.info("Output Response {}: ", proceed);
        return proceed;
    }
}
