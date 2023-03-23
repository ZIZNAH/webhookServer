package com.ziznah.domain.sonarr;

import lombok.Data;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.domain.sonarr
 * @Author: sugarzhang
 * @CreateTime: 2023-03-21 22:54
 * @Description: ${Description}
 */
@Data
public class Series {

    //剧集id
    private int id;
    //剧集标题
    private String title;
    //剧集thetvdb id
    private int tvdbId;
    //剧集tvmaze id
    private int tvMazeId;
    //剧集imdbId id
    private int imdbId;
    //剧集相对路径
    private String path;
    //剧集类型（standard or anime）
    private String type;

}
