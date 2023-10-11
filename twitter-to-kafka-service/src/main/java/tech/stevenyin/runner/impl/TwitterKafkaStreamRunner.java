package tech.stevenyin.runner.impl;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.stevenyin.config.TwitterKafkaConfig;
import tech.stevenyin.listener.TwitterKafkaStatusListener;
import tech.stevenyin.runner.StreamRunner;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TwitterKafkaStreamRunner implements StreamRunner {

    private final TwitterKafkaConfig twitterKafkaConfig;
    private final TwitterKafkaStatusListener twitterKafkaStatusListener;
    private TwitterStream twitterStream;

    public TwitterKafkaStreamRunner(TwitterKafkaConfig twitterKafkaConfig, TwitterKafkaStatusListener twitterKafkaStatusListener) {
        this.twitterKafkaConfig = twitterKafkaConfig;
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
    }

    @PreDestroy
    public void shutdown() {
        if (twitterStream != null) {
            log.info("Closing twitter stream!");
            twitterStream.shutdown();
        }
    }

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);
        List<String> twitterKeywords = twitterKafkaConfig.getTwitterKeywords();
        FilterQuery filterQuery = new FilterQuery(
                twitterKeywords.toArray(new String[] {})
        );
        twitterStream.filter(filterQuery);
        log.info("Started filtering twitter stream for keywords {}", String.join(",", twitterKeywords));
    }
}
