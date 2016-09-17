package com.wan.ubun17.purchasedecision.ResponseObject.TwitterObject;

/**
 * Created by ubun17 on 9/2/16.
 */
public class Statuses {
    private String text;

    public String getText() {return  text;}

    public void setText(String str) {
        this.text = str;
    }

    @Override
    public String toString() {
        return text;
    }
}
