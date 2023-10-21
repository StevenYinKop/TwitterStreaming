package tech.stevenyin.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "twitter-to-kafka-service.twitter-service")
@Configuration
public class TwitterKafkaConfig {
    private List<String> twitterKeywords;
    private Boolean enableMockTweets;
    private Long mockSleepMs;
    private Integer mockMaxTweetLength;
    private Integer mockMinTweetLength;
}
