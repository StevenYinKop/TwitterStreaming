package tech.stevenyin.runner.impl;

import tech.stevenyin.config.TwitterKafkaConfig;
import tech.stevenyin.listener.TwitterKafkaStatusListener;
import tech.stevenyin.runner.StreamRunner;
import twitter4j.TwitterException;

import java.util.Random;

public class MockKafkaStreamRunner implements StreamRunner {

    private final TwitterKafkaConfig twitterKafkaConfig;
    private final TwitterKafkaStatusListener twitterKafkaStatusListener;

    private static final Random RANDOM = new Random();
    private static final String[] WORDS = new String[] {
            "Lorem"
    };

    private static final String tweetAsRawJson = """
            {
                "create_at": "{0}",
                "id: "{1}",
                "text": "{2}",
                "user": { "id": "{3}" }
            }
            """;

    private static final String TWITTER_STATUS_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    public MockKafkaStreamRunner(TwitterKafkaConfig twitterKafkaConfig, TwitterKafkaStatusListener twitterKafkaStatusListener) {
        this.twitterKafkaConfig = twitterKafkaConfig;
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
    }

    @Override
    public void start() throws TwitterException {
        String[] array = twitterKafkaConfig.getTwitterKeywords().toArray(new String[0]);
        Long mockSleepMs = twitterKafkaConfig.getMockSleepMs();
        Integer mockMinTweetLength = twitterKafkaConfig.getMockMinTweetLength();
        Integer mockMaxTweetLength = twitterKafkaConfig.getMockMaxTweetLength();
    }
}
