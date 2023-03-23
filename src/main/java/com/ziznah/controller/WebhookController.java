package com.ziznah.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.controller
 * @Author: sugarzhang
 * @CreateTime: 2023-03-19 22:42
 * @Description: ${Description}
 */

@RestController
@Slf4j
public class WebhookController {

    @PostMapping("/api")
    public void parse(@RequestBody Object api){
        log.info(api.toString());
    }
}
