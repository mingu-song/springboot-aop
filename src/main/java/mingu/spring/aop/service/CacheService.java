package mingu.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private final Logger log = LoggerFactory.getLogger(CacheService.class);

    public void updateLocalCache(String cacheType) {
        log.info("============================================================================================================");
        log.info("CACHE UPDATED !!! : {}", cacheType);
    }
}
