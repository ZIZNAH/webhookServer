package com.ziznah.domain.sonarr;

import lombok.Data;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.domain.sonarr
 * @Author: sugarzhang
 * @CreateTime: 2023-03-21 23:20
 * @Description: ${Description}
 */
@Data
public class Release {

    //剧集质量
    private String quality;
    //质量版本
    private int qualityVersion;
    //版本分组
    private String releaseGroup;
    //版本标题
    private String releaseTitle;
    //下载索引来源
    private String indexer;
    //剧集大小
    private int size;

}
