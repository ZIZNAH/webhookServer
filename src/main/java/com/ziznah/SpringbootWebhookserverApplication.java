package com.ziznah;

import com.ziznah.utils.ChatUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringbootWebhookserverApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootWebhookserverApplication.class, args);

        ChatUtils chatUtils = new ChatUtils();
        chatUtils.chat("123", "");

    }

}
