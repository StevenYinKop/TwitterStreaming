# TwitterStreaming
Sprint Boot, Twitter4j, Kafka, Event-Driven.

day1:
- package: Application
- @SpringBootApplication 
- .run 
- lombok/twitter4j/tester/starter
- test package
- @SpringBootTest @Test contextLoad()

- @Scope("request")/@PostConstruct

day2:
@Data
@ConfigurationProperties(prefix = "")
@Configuration
class XXX {
    private List<String> twitterKeywords
}
