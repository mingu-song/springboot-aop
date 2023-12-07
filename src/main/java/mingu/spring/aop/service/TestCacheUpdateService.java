package mingu.spring.aop.service;

import mingu.spring.aop.cache.PostCacheUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestCacheUpdateService implements PostCacheUpdate {
    private final Logger log = LoggerFactory.getLogger(TestCacheUpdateService.class);

    @Override
    public void doProcess(String cacheType) {
        log.info("INTERNAL CACHE UPDATE : {}", cacheType);
    }
}
