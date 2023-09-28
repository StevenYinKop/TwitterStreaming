package tech.stevenyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */

@SpringBootApplication
//@Scope("request")
public class App /*  implements ApplicationListener */ /* implements CommandLineRunner */ {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
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
