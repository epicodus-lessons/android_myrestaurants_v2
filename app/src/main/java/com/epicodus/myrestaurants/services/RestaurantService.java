package com.epicodus.myrestaurants.services;

import com.epicodus.myrestaurants.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Response;

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

    public ArrayList<Restaurant> processResults(Response response) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONArray restaurantsJSON = new JSONArray(jsonData);
                for (int i = 0; i < restaurantsJSON.length(); i++) {
                    JSONObject restaurantJSON = restaurantsJSON.getJSONObject(i);
                    String name = restaurantJSON.getString("name");
                    double averageCost = restaurantJSON.getDouble("avgcost");
                    int rating = Integer.parseInt(restaurantJSON.getString("rating"));
                    String website = restaurantJSON.getString("website");
                    String imageUrl = restaurantJSON.getString("image");
                    String foodType = restaurantJSON.getString("foodtype");

                    Restaurant restaurant = new Restaurant(name, averageCost, rating, website,
                            imageUrl, foodType);
                    restaurants.add(restaurant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

}
