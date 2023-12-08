package mingu.spring.aop.aspect;

import mingu.spring.aop.cache.PostCacheUpdate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PostCacheUpdateAspect {

    private final Logger log = LoggerFactory.getLogger(PostCacheUpdateAspect.class);
    private final List<PostCacheUpdate> updateProcessorList;


    public PostCacheUpdateAspect(List<PostCacheUpdate> updateProcessorList) {
        this.updateProcessorList = updateProcessorList;
    }

    @AfterReturning("execution(public * mingu.spring.aop.service.CacheService.updateLocalCache(..))")
    public void afterUpdate(JoinPoint joinPoint) {
        String cacheType = String.valueOf(joinPoint.getArgs()[0]);
        updateProcessorList.forEach(processor -> processor.doProcess(cacheType));
    }
}
