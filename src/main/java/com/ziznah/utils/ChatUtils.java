package com.ziznah.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.utils
 * @Author: sugarzhang
 * @CreateTime: 2023-03-22 01:23
 * @Description: ${Description}
 */
@Slf4j
public class ChatUtils {

    private OkHttpUtils okHttpUtils = new OkHttpUtils();

    public void chat(String text,String filePath) throws IOException {
//        String text = "{"text": "Check this!! <https://www.synology.com|Click here> for details!"}";
//        String templte = "{\"text\": "+ "\"" + text + "\"}";
        String webHook = "https://dsm7.ziznah.vip:8443/webapi/entry.cgi?api=SYNO.Chat.External&method=incoming&version=2&token=%22v07fIKXNquvZG5UqUagjFSk8abEDPiDpIMljwIN1aR8zX9J5lsihn0iqkD2YmQG8%22";
        //请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", text);
        //判断是否上传文件
        if(!filePath.equalsIgnoreCase("")){
            jsonObject.put("file_url", filePath);
        }
//        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-Type:application/x-www-form-urlencoded; charset=utf-8"),String.valueOf(json));
        RequestBody requestBody = new FormBody.Builder().add("payload", jsonObject.toString()).build();
        Request request = new Request.Builder()
                .url(webHook)
                .post(requestBody) //post请求
                .build();
        final Call call = okHttpUtils.httpsClient.newCall(request);
        Response response = call.execute();
        String result = response.body().string();
        log.info(result);
        if(result.contains("true")){
            log.info("发送成功");
        }else {
            log.info("发送失败");
        }
    }


    public void chatDemo() throws IOException {

        String webHook = "https://dsm7.ziznah.vip:8443/webapi/entry.cgi?api=SYNO.Chat.External&method=incoming&version=2&token=%22v07fIKXNquvZG5UqUagjFSk8abEDPiDpIMljwIN1aR8zX9J5lsihn0iqkD2YmQG8%22";

        MediaType JSON = MediaType.parse("Content-Type:application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", "123");
        jsonObject.put("file_url", "https://keestalkstech.com/wp-content/uploads/2023/03/william-daigneault-oWrZoAVOBS0-unsplash-850x400.jpg");
        log.info(jsonObject.toString());
        RequestBody requestBody = RequestBody.create(JSON, "payload="+jsonObject.toString());
        Request request = new Request.Builder()
                .url(webHook)
                .post(requestBody) //post请求
                .build();
        final Call call = okHttpUtils.httpsClient.newCall(request);
        Response response = call.execute();
        String result = response.body().string();
        log.info(result);
        if(result.contains("true")){
            log.info("发送成功");
        }else {
            log.info("发送失败");
        }
    }
}
