package com.ziznah.service.sonarr;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.service.sonarr
 * @Author: sugarzhang
 * @CreateTime: 2023-03-21 23:34
 * @Description: ${Description}
 */
public class SonarrService {


    /**
     * 根据季数来格式化显示内容
     * 1~9季自动添加0 显示为S0x
     * ≥9季直接显示
     * @param seasonNumber
     * @return
     */
    public String parseSeasonNumber(Integer seasonNumber){
        //判断当前季数是否为1~9区间
        if(seasonNumber < 10){
            return "S0" + seasonNumber.toString();
        }
        return "S" + seasonNumber.toString();
    }

    /**
     * 格式化显示的剧集处理方式
     * @param eventType
     * @return
     */
    public String parseEventType(String eventType){
        //Grab SeriesDelete
        if(eventType == "Grab"){
            return "成功抓取";
        }else if(eventType == "Download"){
            return "开始下载";
        }else if(eventType == "ApplicationUpdate"){
            return "程序升级";
        }
        else if(eventType == "SeriesDelete"){
            return "删除任务";
        }
        return eventType;
    }


}
