package com.pravendra.gateway.filters;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        // Resolve key by user or IP
        return exchange -> {
            final String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            System.out.println("HostAddress : " + hostAddress);
            return Mono.just(hostAddress);
        };
    }
}
