package com.ziznah.domain.chat;

import lombok.Builder;
import lombok.Data;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.domain.chat
 * @Author: sugarzhang
 * @CreateTime: 2023-03-22 00:55
 * @Description: ${Description}
 */
@Data
@Builder
public class Chat {

    private String payload;


}
