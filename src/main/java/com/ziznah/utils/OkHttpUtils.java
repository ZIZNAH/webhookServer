package com.ziznah.utils;

import com.alibaba.fastjson.JSONObject;
import com.ziznah.domain.chat.Chat;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @BelongsProject: webhookserver
 * @BelongsPackage: com.ziznah.utils
 * @Author: sugarzhang
 * @CreateTime: 2023-03-22 00:37
 * @Description: ${Description}
 */
public class OkHttpUtils {

    public String BASE_URL = "";

    //http请求
    public OkHttpClient httpClient = new OkHttpClient();

    //https请求 信任所有证书（暴力模式）
    public OkHttpClient httpsClient = new OkHttpClient.Builder()
            .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
            .hostnameVerifier(new TrustAllHostnameVerifier()).build();

    /**
     * http GET请求
     * @throws IOException
     */
    public void httpGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = httpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    /**
     * http Put请求
     * @throws IOException
     */
    public void httpPut() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        Chat chat = Chat.builder().payload("payload").build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                JSONObject.toJSONString(chat));
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();
        final Call call = httpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    /**
     * http Post请求
     * @throws IOException
     */
    public void httpPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        JSONObject json = new JSONObject();
        json.put("name", "hetiantian");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),     String.valueOf(json));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody) //post请求
                .build();
        final Call call = httpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    /**
     * http DELETE请求
     * @throws IOException
     */
    public void httpDelete() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        final Call call = httpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    /**
     * http 取消请求
     * @throws IOException
     */
    public void testCancelSysnc() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = httpClient.newCall(request);
        Response response = call.execute();
        long start = System.currentTimeMillis();
        //测试连接的取消
        while (true) {
            //1分钟获取不到结果就取消请求
            if (System.currentTimeMillis() - start > 1000) {
                call.cancel();
                System.out.println("task canceled");
                break;
            }
        }
        System.out.println(response.body().string());
    }

    /**
     * OkHttp https请求demo
     * @return
     * @throws IOException
     */
    public  String test() throws IOException {

        String url = "https://xxxxxxx";   //修改成自己的url
        Request request = new Request.Builder().url(url).build();
        Call call = httpsClient.newCall(request);
        Response response = call.execute();
        if(response.body() != null)
        {
            String result = response.body().string();
            //处理result
            return result;
        }
        return response.body().string();
    }

    private static class TrustAllCerts implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) { return true; }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssfFactory;
    }
}
