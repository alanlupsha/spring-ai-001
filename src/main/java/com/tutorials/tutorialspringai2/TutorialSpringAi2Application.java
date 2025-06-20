package com.tutorials.tutorialspringai2;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication(
        exclude = {
                org.springframework.ai.model.openai.autoconfigure.OpenAiChatAutoConfiguration.class,
                org.springframework.ai.model.openai.autoconfigure.OpenAiEmbeddingAutoConfiguration.class
        }
)
public class TutorialSpringAi2Application {

    public static void main(String[] args) {
        SpringApplication.run(TutorialSpringAi2Application.class, args);
    }

    @Bean
    CommandLineRunner cli(ChatClient chatClient) {
        return args -> {
            var scanner = new Scanner(System.in);
            System.out.println("\nLet's chat!");
            while (true) {
                System.out.print("\nUSER: ");
                System.out.println("ASSISTANT: " +
                        chatClient.prompt(scanner.nextLine()).call().content());
            }
        };
    }


//    @Bean
//    CommandLineRunner cli(ChatClient.Builder builder) {
//        return args -> {
//            var chat = builder.build();
//            var scanner = new Scanner(System.in);
//            System.out.println("\nLet's chat!");
//            while (true) {
//                System.out.print("\nUSER: ");
//                System.out.println("ASSISTANT: " +
//                        chat.prompt(scanner.nextLine()).call().content());
//            }
//        };
//    }
}
