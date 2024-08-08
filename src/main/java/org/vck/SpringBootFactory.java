package org.vck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

    @SpringBootApplication(exclude = KafkaAutoConfiguration.class)
    public class SpringBootFactory {

        public static void main(String[] args) {
            SpringApplication.run(SpringBootFactory.class, args);
        }

    }
