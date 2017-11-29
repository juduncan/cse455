package com.example.justd.myapplication;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
    OnItemSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnItemSelectedListener {
        public void onArticleSelected(int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(" Find Places");
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
        String[] placeholder = new String[]{};
        String[] menuItems = new String[] { "Buildings" , "Food" , "Services"};
        String item = (String) getListAdapter().getItem(position);
        //Log.d("Clicked: ", item);
        //mCallback.onArticleSelected(position);
        switch (item) {
            case "Buildings":
                String[] buildings = new String[]{".. back", "Jack Brown", "Library", "University Hall"};
                placeholder = buildings;
                break;
            case"Food":
                String[] food = new String[]{".. back", "Pizza Hut", "Wing Stop", "Taco Bell"};
                placeholder = food;
                break;
            case ".. back":
                placeholder = menuItems;
            default:
                Fragment fragment = null;
                fragment = new MapFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            placeholder = menuItems;


        }
            simpleArrayAdapter adapter = new simpleArrayAdapter(getActivity(), placeholder);
            setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("test", "test insided on attach ");
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
           Log.d("try ", "being called");
           // mCallback = (OnItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
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



