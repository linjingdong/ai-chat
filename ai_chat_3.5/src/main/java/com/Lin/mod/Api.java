package com.Lin.mod;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Date 2023/12/4 15:50
 * @Author Lin
 * @Version 1.0
 */

@Component("api")
public class Api {
    public JSONObject open(String questionContext, String conversationId){

        OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.MINUTES) //连接超时(单位:分钟)
                    .callTimeout(5, TimeUnit.MINUTES)
                    .pingInterval(5,TimeUnit.MINUTES)
                    .readTimeout(5,TimeUnit.MINUTES)
                    .writeTimeout(5,TimeUnit.MINUTES)
                    .build();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("question", questionContext);
        jsonObject.put("conversation_id", conversationId);
        jsonObject.put("stateful", true);

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType,jsonObject.toString());

        Request request = new Request.Builder()
                .url("https://api.zhishuyun.com/chatgpt?token=31dd4689e2a74acd932bbf7685d0e114")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .build();

        Response response = null;

        JSONObject respJSON = null;

        try{
            response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBody.byteStream(), "UTF-8"));
            respJSON = JSONObject.parseObject(bufferedReader.readLine());
            System.out.println(respJSON);
        }catch (Exception e){
            e.printStackTrace();
        }

//        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
//        CompletableFuture.runAsync(()->{
//
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .connectTimeout(5, TimeUnit.MINUTES) //连接超时(单位:分钟)
//                    .callTimeout(5, TimeUnit.MINUTES)
//                    .pingInterval(5,TimeUnit.MINUTES)
//                    .readTimeout(5,TimeUnit.MINUTES)
//                    .writeTimeout(5,TimeUnit.MINUTES)
//                    .build();
//
//            JSONObject jsonObject1 = new JSONObject();
//            jsonObject1.put("question", questionContext);
//            jsonObject1.put("conversation_id", "");
//            jsonObject1.put("stateful", true);
//
//
//            MediaType mediaType = MediaType.parse("application/json");
//
//            RequestBody body = RequestBody.create(mediaType,jsonObject1.toString());
//
//            Request request = new Request.Builder()
//                    .url("https://api.zhishuyun.com/chatgpt?token=31dd4689e2a74acd932bbf7685d0e114")
//                    .post(body)
//                    .addHeader("accept", "application/json")
//                    .addHeader("content-type", "application/json")
//                    .build();
//
//            Response response = null;
//
//            try {
//                response = client.newCall(request).execute();
//                ResponseBody responseBody = response.body();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBody.byteStream(), "UTF-8"));
//                JSONObject jsonObject = JSONObject.parseObject(bufferedReader.readLine());
//                System.out.println(jsonObject);
//                new Thread(() -> {
//                    try {
//                        // 发送值到客户端
//                        emitter.send(jsonObject);
//                        // 发送完成信号
//                        emitter.complete();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }).start();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });

        return respJSON;
    }
}
