package com.pravendra.analytics.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "api_usage")
public class UsageData {

    @Setter
    @Id
    private String id;
    private String username;
    private String apiPath;
    private int callCount;

    public UsageData() {
    }

    public UsageData(String username, String apiPath) {
        this.username = username;
        this.apiPath = apiPath;
        this.callCount = 1; // Initial call
    }

    public void incrementUsage() {
        this.callCount += 1;
    }
}
