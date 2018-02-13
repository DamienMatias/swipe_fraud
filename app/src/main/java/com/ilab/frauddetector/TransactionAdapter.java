package com.ilab.frauddetector;

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

public class TransactionAdapter extends ArrayAdapter<Transactions> {
    public TransactionAdapter(Context context, ArrayList<Transactions> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Transactions transaction = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        // Lookup view for data population
        TextView transaction_label = (TextView) convertView.findViewById(R.id.transaction_label);
        TextView transaction_amount = (TextView) convertView.findViewById(R.id.transaction_amount);
        TextView transaction_date = (TextView) convertView.findViewById(R.id.transaction_date);
        // Populate the data into the template view using the data object
        transaction_label.setText(transaction.getLabel());
        transaction_date.setText(transaction.getDate());
        transaction_amount.setText(transaction.getAmount().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
