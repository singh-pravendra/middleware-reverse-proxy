package com.pravendra.analytics.dao;

import com.pravendra.analytics.bean.UsageData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsageDataRepository extends ReactiveMongoRepository<UsageData, String> {
    Flux<UsageData> findByUsername(String username);
    Mono<UsageData> findByUsernameAndApiPath(String username, String apiPath);
}
