package com.wan.ubun17.purchasedecision.APIcall;

import android.util.Log;

import com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject.Statuses;
import com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject.TweetsSearch;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ubun17 on 9/1/16.
 */
public class TwitterAPI {
    String mSearch;
    ArrayList<Statuses> comingStatuses;

    public TwitterAPI(String str) {
        mSearch = str;
    }

    public ArrayList<Statuses> getStatueses() {
        return comingStatuses;
    }

    public void TwitterCalling() {
        String searchURL = "https://api.twitter.com/1.1/search/tweets.json?q="+mSearch;
        OkHttpClient twittClient = new OkHttpClient();

        final Request twittRequest = new Request.Builder()
                .addHeader("Authorization", "Bearer " +
                        "AAAAAAAAAAAAAAAAAAAAAPjFuAAAAAAAw4DhWE0PW1fC%2FNu9IqlACrmkceQ%3DAfrebWvQJeZg6ttJrEEMWod9Wa7qGSyTM05dsFzae39UE5W4ZW")
                .url(searchURL).build();
 //////////////////////////////////////////////////////////////
        try {
            Response response = twittClient.newCall(twittRequest).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String responseBody = response.body().string();
            Gson gson = new Gson();
            TweetsSearch tSearch = gson.fromJson(responseBody,TweetsSearch.class);
            comingStatuses =  tSearch.getStatuses();

            Log.d("in TwitterAPI", "---------------------------  API is calling");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
