package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class runListView extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    public runListView(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);  // returns item at that location
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_sw720dp, parent, false);
        }
        // get current item
        Item currentItem = (Item) getItem(position);

        // now get the text view
        TextView textViewItemName = (TextView)  convertView.findViewById(R.id.text_view_item_name);
        TextView textViewItemHeight = (TextView)  convertView.findViewById(R.id.text_view_item_height);
        TextView textViewItemMass = (TextView)  convertView.findViewById(R.id.text_view_item_mass);

        // set it
        textViewItemName.setText(currentItem.getItemName());
        textViewItemHeight.setText(currentItem.getItemHeight());
        textViewItemMass.setText(currentItem.getItemMass());

        return convertView;
    }
}

