package final4j.lmtesting;

import final4j.lmtesting.Component.ApiKeySet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmTestingApplication {
    public static void main(String[] args) {
        ApiKeySet.init();
        SpringApplication.run(LmTestingApplication.class, args);
    }
}
