package org.example;

import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by palevo on 11.05.2017.
 */
@SpringBootApplication
public class Application {

    @Bean
    IPersonService mockPersonService() {
        return new PersonService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
