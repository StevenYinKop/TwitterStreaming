package tech.stevenyin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.stevenyin.config.TwitterKafkaConfig;
import tech.stevenyin.runner.StreamRunner;

/**
 * Hello world!
 */

@Slf4j
@SpringBootApplication
//@Scope("request")
public class App /*  implements ApplicationListener */ implements CommandLineRunner {
    private final TwitterKafkaConfig twitterKafkaConfig;
    private final StreamRunner streamRunner;

    public App(TwitterKafkaConfig twitterKafkaConfig, StreamRunner streamRunner) {
        this.twitterKafkaConfig = twitterKafkaConfig;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App starts...");
        streamRunner.start();
    }

    /*
      {@link jakarta.annotation.PostConstruct} annotation for annotating a method that should be run once immediately after the bean’s initialization.
      Keep in mind that Spring will run the annotated method even if there is nothing to inject.
     */
//    @PostConstruct
//    public void init() {}

//    @Override
//    public void run(String... args) throws Exception {
//
//    }

//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//
//    }
}
