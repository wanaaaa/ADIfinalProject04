package com.wan.ubun17.purchasedecision.APIcall;

import android.util.Log;

import com.wan.ubun17.purchasedecision.ResponseObject.Ebay.Example;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ubun17 on 8/26/16.
 */
public class EbayAPI {
    String mURL;
    int mPosition;

    public EbayAPI(String url, int num) {
        mURL = url;
        mPosition = num;
    }

    public void EbayCall() {
        String ebayURL = "http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsByKeywords&SERVICE-VERSION=1.0.0&SECURITY-APPNAME=WanLim-priceCom-PRD-59a67cc35-c54e5d44&GLOBAL-ID=EBAY-US&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&keywords=harry%20potter&paginationInput.entriesPerPage=10";

        String baseURL = "http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsByKeywords&SERVICE-VERSION=1.0.0&SECURITY-APPNAME=WanLim-priceCom-PRD-59a67cc35-c54e5d44&GLOBAL-ID=EBAY-US&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&keywords=";
        String afterURL = "&paginationInput.entriesPerPage=10";
        String searchURL = baseURL+mURL+afterURL;

        OkHttpClient ebayClient = new OkHttpClient();

        final Request ebayRequest = new Request.Builder().url(searchURL).build();

        try {
            Response response = ebayClient.newCall(ebayRequest).execute();

            if (!response.isSuccessful()) throw new IOException("Unexpected Code " + response);

            String stRepnoseBody = response.body().string();
            Gson gson = new Gson();

            Example ebayResult = gson.fromJson(stRepnoseBody,Example.class);

            SingleWarSearch warSearch = SingleWarSearch.getInstance();


            String countSt = ebayResult.getFindItemsByKeywordsResponse().get(0)
                    .getSearchResult().get(0).getCount();
            Log.d("count..", countSt);
            if (!countSt.matches("0")) {

                //warSearch.addExample(ebayResult);
                warSearch.getEbayExampleList().set(mPosition, ebayResult);

                int itemSize = ebayResult
                        .getFindItemsByKeywordsResponse().get(0).getSearchResult()
                        .get(0).getItem().size();
                for(int i = 0; i < itemSize; i++) {
                    String stPrice = String.valueOf(ebayResult
                            .getFindItemsByKeywordsResponse().get(0).getSearchResult()
                            .get(0).getItem().get(i).getSellingStatus()
                            .get(0).getCurrentPrice().get(0).getValue());
                    Log.d("price..",stPrice);
                    //Toast.makeText(getC)
                }
            } else {
                //warSearch.addExample(null);
            }

            Log.d("in Ebay call", stRepnoseBody);
            response.body().close();
        } catch (IOException e) {
            //waterSingleWarSearch warSearch = SingleWarSearch.getInstance();
            //warSearch.addExample(null);
            e.printStackTrace();
            //response.body().close();
        }
    }
}
