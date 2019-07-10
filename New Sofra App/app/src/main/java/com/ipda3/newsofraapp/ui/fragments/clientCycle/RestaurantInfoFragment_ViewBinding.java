package com.ipda3.newsofraapp.ui.fragments.clientCycle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipda3.newsofraapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantInfoFragment_ViewBinding extends Fragment {


    public RestaurantInfoFragment_ViewBinding() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_info_fragment__view_binding, container, false);
    }

}
