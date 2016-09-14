package com.wan.ubun17.purchasedecision;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ubun17 on 9/10/16.
 */
public class ViewHolderCart extends RecyclerView.ViewHolder {
    public TextView tvName, tvPrice;
    public ImageView ivThum;
    Button buItemDelete;

    public ViewHolderCart(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.cartName);
        tvPrice = (TextView) itemView.findViewById(R.id.cartPrice);
        ivThum = (ImageView) itemView.findViewById(R.id.cartImage);
        buItemDelete = (Button) itemView.findViewById(R.id.buDelItemCart);
    }
}
