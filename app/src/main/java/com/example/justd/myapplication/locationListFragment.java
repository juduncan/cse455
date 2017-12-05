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

    fragComm mCallback;

    // Container Activity must implement this interface
    public interface fragComm {
        public void passLoc(int loc);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(" Find Places");
        String[] menuItems = new String[] { "Buildings" , "Food" , "Services"};
        simpleArrayAdapter adapter = new simpleArrayAdapter(getActivity(), menuItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        String[] placeholder = new String[]{};
        String[] menuItems = new String[] { "Buildings" , "Food" , "Services"};
        String item = (String) getListAdapter().getItem(position);
        Log.d("Clicked: ", item);
        switch (item) {
            case "Buildings":
                String[] buildings = new String[]{".. back", "Jack Brown", "Library", "University Hall", "Faculty Office Building", "Student Health Center", "Coussoulis Arena", "Murillo Family Observatory", "Performing Arts/Theatre/Recital Hall", "Physical Education", "Parking Structure West", "Parking Structure East", "Physical Science", "Santos Manuel Student Union", "Serrano Village", "University Police", "University Village" };
                placeholder = buildings;
                break;
            case"Food":
                String[] food = new String[]{".. back", "Pizza Hut", "Stir Fresh", "Wing Stop", "Taco Bell", "Starbucks", "Sub Connection", "Simply to go", "Wow Cafe", "The Market Place", "Coyote Market", "Fired Up", "Ignite Grill", "The Blue Coyote"  };
                placeholder = food;
                break;
            case"Services":
                String[] services = new String[]{".. back", "Campus Assessment, Response and Education team", "Career Center", "Computer Labs", "Counseling and Psychologocial Services", "Cross Cultural Center", "Library", "Ombuds Services", "Technology and Support Center", "Student Financial Services", "Testing Office", "Tutoring Center", "Veterans Success Center", "Womens Resource center", "Writing Center"};
                placeholder = services;
                break;
            case ".. back":
                placeholder = menuItems;
                break;
            default:
                Fragment fragment = null;
                fragment = new MapFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            //placeholder = menuItems;


        }
            simpleArrayAdapter adapter = new simpleArrayAdapter(getActivity(), placeholder);
            setListAdapter(adapter);
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



