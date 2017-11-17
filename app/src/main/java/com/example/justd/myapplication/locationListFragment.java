package com.example.justd.myapplication;


import android.content.Context;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by justd on 10/26/2017.
 */

public class locationListFragment extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] menuItems = new String[] { "Buildings" , "Food" , "Services"};

        simpleArrayAdapter adapter = new simpleArrayAdapter(getActivity(), menuItems);
        setListAdapter(adapter);


       //final ArrayList<String> menuList = new ArrayList<String>();
       // for (int i=0; i<menuItems.length; ++i){
        //    menuList.add(menuItems[i]);
       // }
       // final StableArrayAdapter sadapter = new
         //       StableArrayAdapter(getActivity(),R.layout.row_layout,R.id.label,menuList);
        //setListAdapter(sadapter);
       // ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
              //  R.array.Categories, android.R.layout.simple_list_item_1);
        //setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        String item = (String) getListAdapter().getItem(position);
        Log.d("Clicked: ", item);
       // ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
        //        R.array.Classrooms, R.layout.row_layout);
        //setListAdapter(adapter);

    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId, int test,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);

        }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

}



