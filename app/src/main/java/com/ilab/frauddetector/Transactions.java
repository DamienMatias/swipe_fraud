package com.ilab.frauddetector;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 44106567 on 13/02/2018.
 */

public class Transactions {

//    @SerializedName("name")
//    @Expose
    private String label;

//    @SerializedName("age")
//    @Expose
    private Integer amount;

    private String date;


    public String getLabel() {
        return label;
    }

    public String getDate() {
        return date;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDate(String label) {
        this.label = label;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Transactions(String label, Integer amount, String date) {
        this.label = label;
        this.amount = amount;
        this.date = date;
    }

}


