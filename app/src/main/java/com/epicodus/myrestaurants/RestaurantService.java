package com.epicodus.myrestaurants;

import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class RestaurantService {
    static String apiUrl = "http://138.197.214.133/api/v1/foodtruck";

    public static void findRestaurants(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
    }

}
