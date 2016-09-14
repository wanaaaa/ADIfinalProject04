package com.wan.ubun17.purchasedecision;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject.Statuses;

import java.util.ArrayList;

/**
 * Created by ubun17 on 8/29/16.
 */
public class ViewHolderItemList extends RecyclerView.ViewHolder {
    public TextView tvItemName,tvWalPrice, ebayMinPrice, ebayMaxPrice, ebayAverPrice
            , bestBuyPrice;
    public ImageView imageThumb;
    public Button buTwitter, buToCart;
    public ArrayList<Statuses> twittList;

    public ViewHolderItemList(View itemView) {
        super(itemView);

        imageThumb = (ImageView) itemView.findViewById(R.id.imaThumb);

        tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
        tvWalPrice = (TextView) itemView.findViewById(R.id.WalPrice) ;
        ebayAverPrice = (TextView) itemView.findViewById(R.id.ebayAverPrice);
        ebayMinPrice = (TextView) itemView.findViewById(R.id.ebayMinPrice);
        ebayMaxPrice = (TextView) itemView.findViewById(R.id.ebayMaxPrice);
        bestBuyPrice = (TextView) itemView.findViewById(R.id.tvBestBuyPrice);

        buTwitter = (Button) itemView.findViewById(R.id.buTwitterRecycle);
        buToCart = (Button) itemView.findViewById(R.id.buSaveInCart);
    }
}
