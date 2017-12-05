package com.example.justd.myapplication;

/**
 * Created by justd on 11/17/2017.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class simpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public simpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // Change the icon for Windows and iPhone
        String s = values[position];
        //Log.d("value simpleadapter: ", s);
       if (s.startsWith("Buildings") || s.startsWith("Food")|| s.startsWith("Services")|| s.startsWith("..back")
               || s.startsWith("Clubs")|| s.startsWith("Shops")|| s.startsWith("Other"))
         {
             imageView.setImageResource(R.drawable.mr_ic_play_light);
         } else {
        imageView.setImageResource(R.drawable.ic_action_navigate);
        }

        return rowView;
    }
}