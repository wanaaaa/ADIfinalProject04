package com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject;

import java.util.ArrayList;

/**
 * Created by ubun17 on 9/2/16.
 */
public class TweetsSearch {
    private ArrayList<Statuses> statuses;

    public ArrayList<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Statuses> statuses) {
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return statuses.toString();
    }

}
