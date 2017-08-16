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
    private LayoutInflater layoutInflater_;
    private static class ViewHolder {
        TextView v_name;
        TextView v_address;
        TextView v_distance;

    }

    public Adapter(Context context, int layout, List<Item_> objects) {
        super(context, layout, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Get the data item for this position
        Item_ item_ = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view, parent, false);

            // Lookup view for data population
            viewHolder.v_name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.v_address = (TextView) convertView.findViewById(R.id.address);
            viewHolder.v_distance = (TextView) convertView.findViewById(R.id.distance);


            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // Get each data from "item_"
        String name = item_.getVenue().getName();
        String addrss = item_.getVenue().getLocation().getAddress();
        int distance = item_.getVenue().getLocation().getDistance();


        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.v_name.setText(name);
        viewHolder.v_address.setText(addrss);
        viewHolder.v_distance.setText(String.valueOf(distance));

        // Return the completed view to render on screen
        return convertView;


    }

}
