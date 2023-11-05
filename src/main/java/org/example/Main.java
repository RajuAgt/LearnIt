package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        OkHttpClient client = new OkHttpClient();

        var request = new Request.Builder()
                .url("https://example.com")
                .build();
        try(var res = client.newCall(request).execute()){
            System.out.println(res.body().string());
        }catch (Exception e){
            e.getMessage();
        }
    }
}