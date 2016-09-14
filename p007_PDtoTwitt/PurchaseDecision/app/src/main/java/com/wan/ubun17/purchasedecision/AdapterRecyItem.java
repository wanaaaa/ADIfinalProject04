package com.wan.ubun17.purchasedecision;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.wan.ubun17.purchasedecision.APIcall.TwitterAPI;
import com.wan.ubun17.purchasedecision.ResponseObject.Ebay.Example;
import com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject.Statuses;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.Item;
import com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject.SingleWarSearch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ubun17 on 8/29/16.
 */
public class AdapterRecyItem extends RecyclerView.Adapter<ViewHolderItemList> {
    ArrayList<Item> mItems;
    ArrayList<Example> mEbayExample;
    String stEbayMin, stEbayMax, stEbayAev, stItemName, stWalPrice
            , stBestBuyPrice, stTwitNum;
    Context mContext;
    //private ProgressBar progressBar;
    DatabaseReference mFirebaseRootRef;

    public AdapterRecyItem(ArrayList<Item> args, ArrayList<Example> examArr, Context context) {
        mItems = args;
        mEbayExample = examArr;
        mContext = context;
    }

    @Override
    public ViewHolderItemList onCreateViewHolder(ViewGroup parent, int viewType) {

        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recy_item_list, parent, false);
        ViewHolderItemList viewHolderItemList = new ViewHolderItemList(parentView);

        return viewHolderItemList;
    }

    @Override
    public void onBindViewHolder(final ViewHolderItemList holder, final int position) {

        if (mEbayExample.get(position) != null) {
            int numItem = mEbayExample.get(position)
                    .getFindItemsByKeywordsResponse().get(0).getSearchResult().get(0)
                    .getItem().size();

            ArrayList<Double> priceArr = new ArrayList<Double>();

            Double ebaySum = Double.valueOf(0);
            for (int i = 0; i < numItem; i ++) {
                double ebayPrice = Double.parseDouble(mEbayExample.get(position)
                        .getFindItemsByKeywordsResponse().get(0).getSearchResult().get(0)
                        .getItem().get(i).getSellingStatus().get(0).getCurrentPrice()
                        .get(0).getValue());

                priceArr.add(ebayPrice);
                ebaySum = ebaySum + ebayPrice;
            }
            String pattern = "###,###.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            stEbayMin = String.valueOf(Collections.min(priceArr));
            stEbayMax = String.valueOf(Collections.max(priceArr));
            stEbayAev = decimalFormat.format(ebaySum/numItem);


        } else {
            stEbayMin = "NA";stEbayMax = "NA"; stEbayAev = "NA";
        }

        final String thumbURL, thumbURLtwo;

        final SingleWarSearch warSearch = SingleWarSearch.getInstance();
        thumbURL = warSearch.getItemList().get(position).getThumbnailImage();
        thumbURLtwo = "https://i5.walmartimages.com/asr/8e0c3fb1-673b-4b29-9b8a-46cae3e0d917_1.c5d745d0e28796c3f8b53893ea6e064c.jpeg?odnHeight=100&odnWidth=100&odnBg=FFFFFF";

        stItemName = mItems.get(position).getName();
        String stUPC = mItems.get(position).getUpc();
        /////////////////////////////////////////////////////
        Log.d("UPC in RecyAdapter", stUPC+"@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        if (mItems.get(position).getSalePrice()==null ) {
            stWalPrice = "data coming";
        } else {
            stWalPrice = mItems.get(position).getSalePrice().toString();
        }

        if (warSearch.getBestBuyArr().size() - 1 < position) {
            stBestBuyPrice = "Best Buy comming";
        } else {
            stBestBuyPrice = warSearch.getBestBuyArr().get(position);
        }



        holder.tvItemName.setText(stItemName);
        holder.tvWalPrice.setText(stWalPrice);

        holder.ebayAverPrice.setText(stEbayAev);
        holder.ebayMinPrice.setText(stEbayMin);
        holder.ebayMaxPrice.setText(stEbayMax);
        holder.bestBuyPrice.setText(stBestBuyPrice);

        Picasso.with(holder.imageThumb.getContext()).load(thumbURL).resize(100, 100)
                .into(holder.imageThumb);

        //if (stTwitNum == null) {
            //stTwitNum = "Data coming";
            TwitterAsyncCalling twittCalling = new TwitterAsyncCalling(holder);
            twittCalling.execute(stItemName);
        //}


        View.OnClickListener buTwitter = new View.OnClickListener(){
            @Override
            public  void onClick(View view) {
                ArrayList<String> twittArrForListView = new ArrayList<String>();

                ArrayList<Statuses> twittList = holder.twittList;

                int twittSize = twittList.size();
                if (twittSize == 0) {
                    twittArrForListView.add("There is no twitt");
                } else {
                    for (int i = 0; i < twittSize; i ++) {
                        twittArrForListView.add(twittList.get(i).getText());
                    }
                }

                final CharSequence[] Twitts = twittArrForListView
                        .toArray(new String[twittArrForListView.size()]);

                AlertDialog.Builder twittDialogBuilder = new AlertDialog.Builder(mContext);
                twittDialogBuilder.setTitle("Twitts");

                twittDialogBuilder.setItems(Twitts, new DialogInterface.OnClickListener(){
                    public  void onClick(DialogInterface dialog, int item) {
                        String anytext = "asdfasdfasf";
                    }
                });
                AlertDialog twitDialogObject = twittDialogBuilder.create();
                twitDialogObject.show();
            }
        };

        holder.buTwitter.setOnClickListener(buTwitter);

        View.OnClickListener buCart = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemName, itemPrice, itemURL;
                itemName = mItems.get(position).getName();
                itemPrice = String.valueOf(mItems.get(position).getSalePrice());
                itemURL = mItems.get(position).getThumbnailImage();

                AdapterFireBase data = new AdapterFireBase(itemName, itemPrice, itemURL);
                mFirebaseRootRef = FirebaseDatabase.getInstance().getReference();

                final DatabaseReference firebaseMessageRef = mFirebaseRootRef.child("WalMartSCart");
                firebaseMessageRef.push().setValue(data);
                Toast.makeText(mContext, itemName+" To Cart",Toast.LENGTH_SHORT).show();
            }
        };

        holder.buToCart.setOnClickListener(buCart);
    }//End of onBindViewHolder

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class TwitterAsyncCalling extends AsyncTask<String, Void, ArrayList<Statuses>> {

        ViewHolderItemList holder;

        public TwitterAsyncCalling(ViewHolderItemList holder) {
            this.holder = holder;
        }

        @Override
        protected ArrayList<Statuses> doInBackground(String... strings) {
            TwitterAPI testTwett = new TwitterAPI(strings[0]);
            testTwett.TwitterCalling();
            ArrayList<Statuses> returnedStat = testTwett.getStatueses();

            if (returnedStat != null) {
                int num = returnedStat.size();
                for (int i = 0; i < num; i++) {
                    String testST = returnedStat.get(i).getText();
                }
            }

            return returnedStat;
        }//End of doInBackGround

        @Override
        protected void onPostExecute(ArrayList<Statuses> statuses) {
            stTwitNum = String.valueOf(statuses.size());
            holder.buTwitter.setText("Twitt # :" + stTwitNum);
            holder.twittList = statuses;
        }
    }

}
