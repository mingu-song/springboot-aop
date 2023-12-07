package mingu.spring.aop.aspect;

import mingu.spring.aop.cache.PostCacheUpdate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostCacheUpdateAspect {

    private final Logger log = LoggerFactory.getLogger(PostCacheUpdateAspect.class);
    private final ApplicationContext applicationContext;

    public PostCacheUpdateAspect(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @AfterReturning("execution(public * mingu.spring.aop.service.CacheService.updateLocalCache(..))")
    public void afterUpdate(JoinPoint joinPoint) {
        String cacheType = String.valueOf(joinPoint.getArgs()[0]);
        applicationContext.getBeansOfType(PostCacheUpdate.class).forEach((name, processor) -> processor.doProcess(cacheType));
    }
}
