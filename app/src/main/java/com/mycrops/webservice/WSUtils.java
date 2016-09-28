package com.mycrops.webservice;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WSUtils {

    public static String callServiceHttpPost(final String url, final RequestBody requestBody) {
        String responseString = "";
        try {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            final Request.Builder builder = new Request.Builder();
            builder.url(url);
            builder.post(requestBody);
            final Response response = okHttpClient.newCall(builder.build()).execute();
            responseString = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            responseString = WSConstants.getNetworkError();
        }
        return responseString;
    }

    public static String callServiceHttpGet(final String url) {
        String responseString = "";
        try {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            final Request.Builder builder = new Request.Builder();
            builder.url(url);
            final Response response = okHttpClient.newCall(builder.build()).execute();
            responseString = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            responseString = WSConstants.getNetworkError();
        }
        return responseString;
    }


}
