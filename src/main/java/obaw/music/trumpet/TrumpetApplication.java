package obaw.music.trumpet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableAutoConfiguration
@SpringBootApplication
public class TrumpetApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrumpetApplication.class, args);
  }
}