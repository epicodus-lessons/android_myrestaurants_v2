package com.epicodus.myrestaurants;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;

public class RestaurantService {
    static String apiUrl = "http://138.197.214.133/api/v1/foodtruck";

    public static void findRestaurants(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request= new Request.Builder()
                .url(apiUrl)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
