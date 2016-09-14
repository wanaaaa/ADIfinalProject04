package com.wan.ubun17.purchasedecision;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.wan.ubun17.purchasedecision.APIcall.BestBuyAPI;
import com.wan.ubun17.purchasedecision.APIcall.EbayAPI;
import com.wan.ubun17.purchasedecision.APIcall.TwitterAPI;
import com.wan.ubun17.purchasedecision.APIcall.WalMartAPI;
import com.wan.ubun17.purchasedecision.ResponseObject.Ebay.Example;
import com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject.Statuses;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.Item;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch;

import java.util.ArrayList;
import java.util.List;

import static com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch.getInstance;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    AdapterRecyItem adapter;
    ArrayList<Item> mItems;
    ArrayList<Example> mEbayExamples;
    ArrayList<Statuses> twittArr;

    EditText inputItem;
    Button buItem, buTwittSearch, buToCart;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setVisibility(View.GONE);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleViewItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mItems = new ArrayList<>();
        mEbayExamples = new ArrayList<>();
        adapter = new AdapterRecyItem(mItems, mEbayExamples, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        buItem = (Button) findViewById(R.id.buSearch);
        buTwittSearch = (Button) findViewById(R.id.buTwittSearch);
        buToCart = (Button) findViewById(R.id.buToCart);

        buItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputItem = (EditText) findViewById(R.id.inputSearch);

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(10);

                String stSearchItem = inputItem.getText().toString();
                AsycAPIcalling asycAPIcalling = new AsycAPIcalling();
                asycAPIcalling.execute(stSearchItem);

                EbayAsyncCalling ebayCalling = new EbayAsyncCalling();
                ebayCalling.execute("calling");

                BestBuyAsyncCalling bestBuyCalling = new BestBuyAsyncCalling();
                bestBuyCalling.execute("asdfasdf");
            }
        });//End of button

        buTwittSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputItem = (EditText) findViewById(R.id.inputSearch);
                String stSearchItem = inputItem.getText().toString();

                TwitterAsyncCalling twittCalling = new TwitterAsyncCalling();
                twittCalling.execute(stSearchItem);
            }
        });

        buToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToCart = new Intent(MainActivity.this, MmShoppingCart.class);
                startActivity(intentToCart);
            }
        });

    }//End of onStart

    class AsycAPIcalling extends AsyncTask<String, Double, List<Item>> {

        @Override
        protected List<Item> doInBackground(String... strings) {
            WalMartAPI walCalling = new WalMartAPI(strings[0]);
            walCalling.WalMartCall();

            SingleWarSearch singleWarSearch = getInstance();
            ArrayList<Item> walItems = singleWarSearch.getItemList();

            if (walItems != null) {
                for (int i = 0; i < walItems.size(); i ++) {
                    singleWarSearch.getEbayExampleList().add(null);
                    publishProgress(Double.valueOf(i));
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(5);
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            //progressBar.setVisibility(View.GONE);
            SingleWarSearch singleWarSearch = getInstance();

            final ArrayList<Item> dataItem = singleWarSearch.getItemList();
            final ArrayList<Example> dataEbay = singleWarSearch.getEbayExampleList();

            if (singleWarSearch.getQuery() == null) {
                Log.d("Walmartccc", "nulnulnulnul");
            } else {
                mItems.clear();
                mItems.addAll(dataItem);
                mEbayExamples.clear();
                mEbayExamples.addAll(dataEbay);
                adapter.notifyDataSetChanged();
            }
        }
    }//End of AsycAPIcalling

    class EbayAsyncCalling extends  AsyncTask<String, Double, List<Item>> {

        @Override
        protected List<Item> doInBackground(String... strings) {
            SingleWarSearch singleWarSearch = getInstance();
            ArrayList<Item> walItems = singleWarSearch.getItemList();

            if (walItems == null) {
                Log.d("walitmes", "nulNulNUl---------------------------------------");
            } else {
                for (int i = 0; i < walItems.size(); i ++) {
                    String searTerm = walItems.get(i).getName();
                    EbayAPI ebayCall = new EbayAPI(searTerm, i);
                    ebayCall.EbayCall();

                    try {
                        Thread.sleep(155);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected  void onProgressUpdate(Double... values) {
            super.onProgressUpdate(values);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(7);
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            //progressBar.setVisibility(View.GONE);
            SingleWarSearch singleWarSearch = getInstance();
            //singleWarSearch.getItemList().get(0).getUpc();

            final ArrayList<Item> dataItem = singleWarSearch.getItemList();
            final ArrayList<Example> dataEbay = singleWarSearch.getEbayExampleList();

            if (dataEbay == null) {
                Log.d("dataEbay", "nulnulnulnulnulnul-------------------------------");
            } else {
                mEbayExamples.clear();
                mEbayExamples.addAll(dataEbay);
                adapter.notifyDataSetChanged();
            }
            //progressBar.setVisibility(View.GONE);
        }
    }// End of EbayAsyncCalling
//////////////////////////////////////////////////////////
    class BestBuyAsyncCalling extends AsyncTask<String, Double, List<String>> {

    @Override
    protected List<String> doInBackground(String... strings) {
        SingleWarSearch singleWarSearch = getInstance();
        ArrayList<Item> walItems = singleWarSearch.getItemList();

        if (walItems == null) {
            Log.d("BestBuy", "nulNulNUl---------------------------------------");
        } else {
            for (int i = 0; i < walItems.size(); i ++) {
                String upcTerm = walItems.get(i).getUpc();
                Log.d("upc", upcTerm+"   UUUUUUUUUUUUUUUUUUUUUU");
                BestBuyAPI bestBuyCall = new BestBuyAPI(upcTerm, i);
                bestBuyCall.bestBuyCall();

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected  void onProgressUpdate(Double... values) {
        super.onProgressUpdate(values);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(5);
    }

    @Override
    protected void onPostExecute(List<String> list) {
        progressBar.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();

    }
}
//////////////////////////////////////////////////////////
    class TwitterAsyncCalling extends AsyncTask<String, String, ArrayList<Statuses>> {

        @Override
        protected ArrayList<Statuses> doInBackground(String... strings) {

            TwitterAPI testTwett = new TwitterAPI(strings[0]);
            testTwett.TwitterCalling();
            ArrayList<Statuses> returnedStat = testTwett.getStatueses();
            twittArr = returnedStat;
            if (returnedStat != null) {
                int num = returnedStat.size();
                for (int i = 0; i < num; i++) {
                    String testST = returnedStat.get(i).getText();
                    Log.d("twitt tt ", "tttttttttttttttttttttttttttttt   " + testST);
                }
            }
            return returnedStat;
        }
    @Override
    protected void onProgressUpdate(String... st) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(3);

    }

    @Override
        protected void onPostExecute(ArrayList<Statuses> statuses) {
            //progressBar.setVisibility(View.GONE);
            ArrayList<String> twittArrForListView = new ArrayList<String>();

            //int twittSize = statuses.size();
            if (statuses != null) {
                int twittSize = statuses.size();
                for (int i = 0; i < twittSize; i ++ ) {
                    String stEachTwitt = statuses.get(i).getText();
                    twittArrForListView.add(stEachTwitt);
                }
            } else {
                twittArrForListView.add("There is no twitt");
            }

            final CharSequence[] Twitts = twittArrForListView
                    .toArray(new String[twittArrForListView.size()]);

            AlertDialog.Builder twittDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            twittDialogBuilder.setTitle("Twits");

            twittDialogBuilder.setItems(Twitts, new DialogInterface.OnClickListener(){
                public  void onClick(DialogInterface dialog, int item) {
                    String anytext = "asdfasdfasf";
                }
            });

            AlertDialog twitDialogObject = twittDialogBuilder.create();
            twitDialogObject.show();
        }
    }//End of TwitterAsyncCalling...

    protected void showErrorMessage(String str) {
        AlertDialog.Builder errorMessageBuilder = new AlertDialog.Builder(this);
        errorMessageBuilder.setTitle(str);
        errorMessageBuilder.setCancelable(true)
                .setNeutralButton("Click to remove",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton){
                                finish();
                            }
                        });

        AlertDialog errMessageObject = errorMessageBuilder.create();
        errMessageObject.show();//
    }

}
