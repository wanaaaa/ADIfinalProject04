package com.wan.ubun17.purchasedecision;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ubun17 on 9/11/16.
 */
public class AdapRecyCart extends RecyclerView.Adapter<ViewHolderCart> {
    ArrayList<AdapterFireBase> mFireBaseArray;
    DatabaseReference mFirebaseRootRef;
    String mRefer;

    public AdapRecyCart(ArrayList<AdapterFireBase> arg) {
        mFireBaseArray = arg;
    }

    @Override
    public ViewHolderCart onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_recycle, parent, false);

        ViewHolderCart viewHolderCart = new ViewHolderCart(parentView);

        return viewHolderCart;
    }

    @Override
    public void onBindViewHolder(ViewHolderCart holder,final int position) {

        String itemName, itemPrice, itemURL;
        itemName = mFireBaseArray.get(position).getmName();
        itemPrice = mFireBaseArray.get(position).getmPrice();
        itemURL = mFireBaseArray.get(position).getmImageUrl();

        holder.tvName.setText(itemName);
        Log.d("itemName in Recy","^^^^^^^^^^^"+ itemName);
        Log.d("itemPrice in Recy","^^^^^^^^^^^"+ itemPrice);
        holder.tvPrice.setText(itemPrice);
        Picasso.with(holder.ivThum.getContext()).load(itemURL)
                .resize(100, 100).into(holder.ivThum);

        View.OnClickListener buDelete = new View.OnClickListener(){
          @Override
            public void onClick(View view) {
              mRefer = mFireBaseArray.get(position).getmFireReference();
              mRefer = mRefer.replace("https://project04-f01be.firebaseio.com/", "");
              mFirebaseRootRef = FirebaseDatabase.getInstance().getReference();
//              mFirebaseRootRef.child("WalMartSCart/-KRRiNkr-m6RU0Cn9E8-")
//                      .removeValue();
              mFirebaseRootRef.child(mRefer)
                      .removeValue();

              mFireBaseArray.remove(position);
              notifyItemRemoved(position);

              Log.d("AdapCart", "Delete clicked");

          }
        };

        holder.buItemDelete.setOnClickListener(buDelete);

        Log.d("Refer in Recy", mFireBaseArray.get(position).getmFireReference()+"//////////////////");
    }

    @Override
    public int getItemCount() {
        return mFireBaseArray.size();
    }
}
