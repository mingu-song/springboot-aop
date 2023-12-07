package mingu.spring.aop.controller;

import mingu.spring.aop.service.CacheService;
import mingu.spring.aop.aspect.EnableRestCallLogs;
import mingu.spring.aop.dto.InputRequestInfo;
import mingu.spring.aop.dto.OutputResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private final CacheService cacheService;

    public DemoRestController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/testGet/{name}")
    @EnableRestCallLogs
    public ResponseEntity<OutputResponseInfo> testGetEndPoint(@PathVariable String name) {
        OutputResponseInfo responseInfo = new OutputResponseInfo();
        responseInfo.setResponseState(HttpStatus.OK);
        Map<String, Object> hm = new HashMap<>();
        hm.put("Id", 1);
        hm.put("Name", String.valueOf(name));
        responseInfo.setPayload(hm);
        return ResponseEntity.ok(responseInfo);
    }

    @PostMapping("/testPost")
    @EnableRestCallLogs
    public ResponseEntity<OutputResponseInfo> testPostEndPoint(@RequestBody InputRequestInfo inputRequestInfo) {
        OutputResponseInfo responseInfo = new OutputResponseInfo();
        responseInfo.setResponseState(HttpStatus.CREATED);
        Map<String, Object> hm = new HashMap<>();
        hm.put("Payload", inputRequestInfo);
        responseInfo.setPayload(hm);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseInfo);
    }

    @PatchMapping("/cache/{cacheType}")
    @EnableRestCallLogs
    public ResponseEntity<OutputResponseInfo> cacheUpdate(@PathVariable String cacheType) {
        cacheService.updateLocalCache(cacheType);
        OutputResponseInfo responseInfo = new OutputResponseInfo();
        responseInfo.setResponseState(HttpStatus.OK);
        Map<String, Object> hm = new HashMap<>();
        hm.put("CacheType", cacheType);
        responseInfo.setPayload(hm);
        return ResponseEntity.ok(responseInfo);
    }
}
