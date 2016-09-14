package com.wan.ubun17.purchasedecision.APIcall;

import android.util.Log;

import com.google.gson.Gson;
import com.wan.ubun17.purchasedecision.ResponseObject.BestBuyObject.BestBuyObject;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wanmac on 9/12/16.
 */
public class BestBuyAPI {
    String mSearchTerm;
    int mPosition;

    public BestBuyAPI(String str, int num) {
        mSearchTerm = str;
        mPosition = num;
    }

    public void bestBuyCall() {
        String examURL = "https://api.bestbuy.com/v1/products(upc=885909708239)?apiKey=cjawwbadxyj9f37a7uq3r3r8&format=json";
        String beforeURL = "https://api.bestbuy.com/v1/products(upc=";
        String afterURL = ")?apiKey=cjawwbadxyj9f37a7uq3r3r8&format=json";
        String completeURL = beforeURL + mSearchTerm + afterURL;

        OkHttpClient bestBuyClient = new OkHttpClient();
        final Request bestBuyRequest = new Request.Builder().url(completeURL).build();

        try {
            Response response = bestBuyClient.newCall(bestBuyRequest).execute();
            if (!response.isSuccessful()) throw  new IOException("Unexpected Code " + response);

            String stResponseBody = response.body().string();
            Gson gson = new Gson();
            BestBuyObject bestBuyResult = gson.fromJson(stResponseBody, BestBuyObject.class);
            SingleWarSearch warSearch = SingleWarSearch.getInstance();
            if (bestBuyResult.getProductses() != null & bestBuyResult.getProductses().size() !=0 ) {

                String stBestBuyPrice = bestBuyResult.getProductses().get(0).getSalePrice();
                warSearch.addBestBuyPrice(stBestBuyPrice);
                Log.d("Best Object", stBestBuyPrice + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            } else {
                warSearch.addBestBuyPrice("NA");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
