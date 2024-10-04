package com.pravendra.analytics.controller;

import com.pravendra.analytics.bean.UsageData;
import com.pravendra.analytics.dao.UsageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/monetization")
public class MonetizationController {

    @Autowired
    private UsageDataRepository usageDataRepository;

    @PostMapping("/track-usage")
    public Mono<Void> trackUsage(@RequestBody UsageData usageData) {
        return usageDataRepository.findByUsernameAndApiPath(usageData.getUsername(), usageData.getApiPath())
                .flatMap(existingUsage -> {
                    existingUsage.incrementUsage();
                    return usageDataRepository.save(existingUsage);
                })
                .switchIfEmpty(usageDataRepository.save(new UsageData(usageData.getUsername(), usageData.getApiPath())))
                .then();
    }

    @GetMapping("/usage-report")
    public Flux<UsageData> getUsageReport(@RequestParam String username) {
        return usageDataRepository.findByUsername(username);
    }
}
