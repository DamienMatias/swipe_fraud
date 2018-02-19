package com.ilab.frauddetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class SwipeTransactionActivity extends AppCompatActivity {

    private TransactionAdapter transactionAdapter;
    private ArrayList<Transactions> transactionsArrayList;
    private int i;
    private Transactions data1;
    private Transactions data2;
    private Transactions data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_transaction);

        transactionsArrayList = new ArrayList<Transactions>();
        data1 = new Transactions("Fnac", "70€", "10/02/2018");
        data2 = new Transactions("Darty", "30€", "11/02/2018");
        data3 = new Transactions("McDO", "10€", "12/02/2018");

        transactionsArrayList.add(data1);
        transactionsArrayList.add(data2);
        transactionsArrayList.add(data3);

//        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.transaction_amount, al );
        transactionAdapter = new TransactionAdapter(this, transactionsArrayList);
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
//        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setAdapter(transactionAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
//                al.remove(0);
                transactionsArrayList.remove(0);
                transactionAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(SwipeTransactionActivity.this, "Fraud", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(SwipeTransactionActivity.this, "Not Fraud", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
               /* al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;*/
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                /*View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);*/
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(SwipeTransactionActivity.this, "Clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }

 /*   static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.right)
    public void right() {
        *//**
         * Trigger the right event manually.
         *//*
        flingContainer.getTopCardListener().selectRight();
    }

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }*/




}
