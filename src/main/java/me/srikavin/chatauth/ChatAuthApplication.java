package me.srikavin.chatauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class ChatAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatAuthApplication.class, args);
    }
}
