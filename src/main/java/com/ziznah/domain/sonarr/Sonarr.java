package com.ziznah.domain.sonarr;

import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.domain.sonarr
 * @Author: sugarzhang
 * @CreateTime: 2023-03-21 23:17
 * @Description: ${Description}
 */
@Data
public class Sonarr {

    //剧集信息
    public Series series;
    //集 集合
    public List<Episodes> episodes;
    //下载版本信息
    public Release release;
    //下载客户端
    public String downloadClient;
    //下载客户端类型
    public String downloadClientType;
    //下载客户端id
    public String downloadId;
    //当前处理的方式（Grab SeriesDelete ApplicationUpdate Download）
    public String eventType;
    //删除文件
    public Boolean deletedFiles;
    //sonarr信息
    public String message;
    //上一个版本
    public String previousVersion;
    //新版本
    public String newVersion;
}
