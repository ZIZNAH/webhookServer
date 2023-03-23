package com.ziznah.domain.sonarr;

import lombok.Data;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.domain.sonarr
 * @Author: sugarzhang
 * @CreateTime: 2023-03-21 23:01
 * @Description: ${Description}
 */
@Data
public class Episodes {

    //当前集的id
    private int id;
    //集数
    private int episodeNumber;
    //季数
    private int seasonNumber;
    //集的标题
    private String title;
    //	播出日期
    private String airDate;
    //	播出日期（Utc时间）
    private String airDateUtc;


}
