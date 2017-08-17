package com.example.hamali.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hamali.location.Model.Explore.Item_;

import java.util.List;

/**
 * Created by hamali on 15/08/2017.
 */

public class Adapter extends ArrayAdapter<Item_>{
    private LayoutInflater layoutInflater;
    private static class ViewHolder {
        TextView names;
        TextView addresses;
        TextView distances;
    }

    public Adapter(Context context, int layout, List<Item_> objects) {
        super(context, layout, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item_ item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view, parent, false);
            // Lookup view for data population
            viewHolder.names = (TextView) convertView.findViewById(R.id.name);
            viewHolder.addresses = (TextView) convertView.findViewById(R.id.address);
            viewHolder.distances = (TextView) convertView.findViewById(R.id.distance);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Get each data from "item_"
        String name = item.getVenue().getName();
        String address = item.getVenue().getLocation().getAddress();
        int distance = item.getVenue().getLocation().getDistance();

        viewHolder.names.setText(name);
        viewHolder.addresses.setText(address);
        viewHolder.distances.setText(String.valueOf(distance));
        // Return the completed view to render on screen
        return convertView;
    }

}
