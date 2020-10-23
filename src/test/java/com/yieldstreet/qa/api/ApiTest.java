package com.yieldstreet.qa.api;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void validateGetLondonWeather() {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("http://api.openweathermap.org" + "/data/2.5/weather").newBuilder();
        urlBuilder.addQueryParameter("q", "London,uk");
        urlBuilder.addQueryParameter("APPID", "e6974292627b33bcb8ee3c985d52c2d5");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            response.body().string();
            Assert.assertEquals(response.code(), 200, "Response Code");
            Assert.assertEquals(response.isSuccessful(), true, "Response Status");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
