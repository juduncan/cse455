package com.example.justd.myapplication;

/**
 * Created by justd on 11/17/2017.
 */

import android.content.Context;
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
       // if (s.startsWith("Windows7") || s.startsWith("iPhone")
        //        || s.startsWith("Solaris")) {
         //   imageView.setImageResource(R.drawable.no);
        //} else {
            imageView.setImageResource(R.drawable.common_google_signin_btn_icon_dark_normal);
        //}

        return rowView;
    }
}