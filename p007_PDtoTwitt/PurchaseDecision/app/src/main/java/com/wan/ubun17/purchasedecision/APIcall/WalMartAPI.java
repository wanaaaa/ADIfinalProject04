package com.wan.ubun17.purchasedecision.APIcall;

import android.util.Log;

import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.Item;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.WalMartSearch;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ubun17 on 8/26/16.
 */
public class WalMartAPI {
    String mURL;

    public WalMartAPI (String str) {
        mURL = str;
    }

    public void WalMartCall() {
        String WalMartURL = "http://api.walmartlabs.com/v1/search?query=chair&format=json&apiKey=usu6xmuc5dha75jepwnp2ds9";

        String walBaseURL = "http://api.walmartlabs.com/v1/search?query=";
        String walBaseURLafter = "&format=json&apiKey=usu6xmuc5dha75jepwnp2ds9";

        String finalURL = walBaseURL+mURL+walBaseURLafter;

        OkHttpClient walMartClient = new OkHttpClient();

        final Request WalMartRequest = new Request.Builder().url(finalURL).build();

        try {
            Response response = walMartClient.newCall(WalMartRequest).execute();
            if (!response.isSuccessful())  throw new IOException("Unexpected code " + response);
            if (!response.isSuccessful())  {
                SingleWarSearch singleWarSearch = SingleWarSearch.getInstance();
                singleWarSearch.setWalSingleton(null, null);
                Log.d("Wal Mart", "Bad Request////////////////////////////////////////////");
            } else {
                String responseBody = response.body().string();

                Gson gson = new Gson();
                WalMartSearch walMartSearch = gson.fromJson(responseBody, WalMartSearch.class);
                String sss = walMartSearch.getQuery();

                SingleWarSearch searResult = SingleWarSearch.getInstance();
                searResult.setWalSingleton(walMartSearch.getQuery(), (ArrayList<Item>) walMartSearch.getItems());

                Log.d("Walin try Singleton",searResult.getQuery());

                Log.d("Wal in try", sss);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}